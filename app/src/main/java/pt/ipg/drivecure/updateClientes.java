package pt.ipg.drivecure;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class updateClientes extends AppCompatActivity {

    EditText nome_cliente, email_cliente, contacto_cliente;
    Button update_button, delete_button;

    String id, nome, email, contacto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_clientes);

        nome_cliente = findViewById(R.id.nomeClienteUpdate);
        email_cliente = findViewById(R.id.emailClienteUpdate);
        contacto_cliente = findViewById(R.id.contactoClienteUpdate);
        update_button = findViewById(R.id.updateCliente);
        delete_button = findViewById(R.id.eliminarCliente);

        receberDadosIntent(); //recebe os dados

        update_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                MyDatabaseHelper myDB = new MyDatabaseHelper(updateClientes.this);

                nome = nome_cliente.getText().toString().trim();
                email = email_cliente.getText().toString().trim();
                contacto = contacto_cliente.getText().toString().trim();
                myDB.updateData2(id, nome, email, contacto); //faz os update dos dados
                finish();
            }
        });

        delete_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                confirmDialog();//chama metodo que confirma se quer ou nao apagar os dados
            }
        });


    }

    void receberDadosIntent(){  /*receber e guardar dados dentro das strings*/
        if (getIntent().hasExtra("id") && getIntent().hasExtra("nome")
                && getIntent().hasExtra("email") && getIntent().hasExtra("contacto") ){
            //receber dados
            id = getIntent().getStringExtra("id");
            nome = getIntent().getStringExtra("nome");
            email = getIntent().getStringExtra("email");
            contacto = getIntent().getStringExtra("contacto");

            //gerir dados
            nome_cliente.setText(nome);
            email_cliente.setText(email);
            contacto_cliente.setText(contacto);

            //Action bar para ver nome de pessoa que se quer editar
            ActionBar ab = getSupportActionBar();
            if (ab != null) {
                ab.setTitle(nome);
            }


        }else{
            Toast.makeText(this, "No data", Toast.LENGTH_SHORT).show();
        }
    }


    void confirmDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Delete " + nome + "?");
        builder.setMessage("Are you sure you want to delete " + nome + "?");
        builder.setPositiveButton("yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                MyDatabaseHelper myDB = new MyDatabaseHelper(updateClientes.this);
                myDB.deleteOneRow2(id); // chama o metodo para eliminar a row
                finish();
            }
        });

        builder.setNegativeButton("no", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        builder.create().show();
    }

}