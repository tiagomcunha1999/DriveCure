package pt.ipg.drivecure;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
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

        /*metodo para passar informações inseridas pelo utilizador para a funçao addfuncionarios*/

        registarFuncionario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                MyDatabaseHelper myDB = new MyDatabaseHelper(addFuncionarios.this);
                myDB.addFuncionario(nomeFuncionario.getText().toString().trim(),
                        emailFuncionario.getText().toString().trim(),
                        Integer.valueOf(contactoFuncionario.getText().toString().trim()));

                //codigo para dar refresh
                Intent intent = new Intent(addFuncionarios.this, Funcionarios.class);
                startActivity(intent);
                finish();
            }
            });

    }

}