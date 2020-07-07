package pt.ipg.drivecure;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class novaEntrega extends AppCompatActivity {


    EditText nomeCliente, emailCliente, contactoCliente, descricaoProduto;
    Button registarCliente;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nova_entrega);

        nomeCliente = findViewById(R.id.nomeCliente);
        emailCliente = findViewById(R.id.emailCliente);
        contactoCliente = findViewById(R.id.contactoCliente);
        descricaoProduto = findViewById(R.id.descricaoProduto);

        registarCliente = findViewById(R.id.registarCliente);

        /*metodo para passar informações inseridas pelo utilizador para a funçao addfuncionarios*/

        registarCliente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                MyDatabaseHelper myDB = new MyDatabaseHelper(novaEntrega.this);
                myDB.novaEntrega(nomeCliente.getText().toString().trim(),
                        emailCliente.getText().toString().trim(),
                        Integer.valueOf(contactoCliente.getText().toString().trim()),
                        descricaoProduto.getText().toString().trim());

                //codigo para dar refresh
                Intent intent = new Intent(novaEntrega.this, Entregas.class);
                startActivity(intent);
                finish();
            }
        });

    }

}