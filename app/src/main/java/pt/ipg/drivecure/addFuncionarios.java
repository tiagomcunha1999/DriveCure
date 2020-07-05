package pt.ipg.drivecure;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class addFuncionarios extends AppCompatActivity {

    EditText nomeFuncionario, emailFuncionario, contactoFuncionario;
    Button registarFuncionario;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_funcionarios);

        nomeFuncionario = findViewById(R.id.nomeFuncionario);
        emailFuncionario = findViewById(R.id.emailFuncionario);
        contactoFuncionario = findViewById(R.id.contactoFuncionario);
        registarFuncionario = findViewById(R.id.registarFuncionario);

        registarFuncionario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { /*metodo para ir buscar informaçoes inseridas pelo utilizador*/
            MyDatabaseHelper myDB = new MyDatabaseHelper(addFuncionarios.this);
            myDB.addFuncionario(nomeFuncionario.getText().toString().trim(),
                    emailFuncionario.getText().toString().trim(),
                    Integer.valueOf(contactoFuncionario.getText().toString().trim())
            );
            }

            });

    }
}