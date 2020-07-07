package pt.ipg.drivecure;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class updateFuncionarios extends AppCompatActivity {

    EditText nome_funcionario, email_funcionario, contacto_funcionario;
    Button update_button;

    String id, nome, email, contacto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_funcionarios);

        nome_funcionario = findViewById(R.id.nomeFuncionarioUpdate);
        email_funcionario = findViewById(R.id.emailFuncionarioUpdate);
        contacto_funcionario = findViewById(R.id.contactoFuncionarioUpdate);
        update_button = findViewById(R.id.updateFuncionario);

        receberDadosIntent(); //recebe os dados

        update_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                MyDatabaseHelper myDB = new MyDatabaseHelper(updateFuncionarios.this);

                nome = nome_funcionario.getText().toString().trim();
                email = email_funcionario.getText().toString().trim();
                contacto = contacto_funcionario.getText().toString().trim();
                myDB.updateData(id, nome, email, contacto); //faz os update dos dados
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
            nome_funcionario.setText(nome);
            email_funcionario.setText(email);
            contacto_funcionario.setText(contacto);


        }else{
            Toast.makeText(this, "No data", Toast.LENGTH_SHORT).show();
        }
    }


}