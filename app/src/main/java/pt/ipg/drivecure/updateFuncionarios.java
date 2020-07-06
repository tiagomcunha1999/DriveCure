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

        update_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

    }

    void receberDadosIntent(){  /*receber e guardar dados dentro das strings*/
        if (getIntent().hasExtra("id") && getIntent().hasExtra("nome")
                && getIntent().hasExtra("email") && getIntent().hasExtra("contacto") ){

            id = getIntent().getStringExtra("id");
            nome = getIntent().getStringExtra("nome");
            email = getIntent().getStringExtra("email");
            contacto = getIntent().getStringExtra("contacto");

        }else{
            Toast.makeText(this, "No data", Toast.LENGTH_SHORT).show();
        }
    }


}