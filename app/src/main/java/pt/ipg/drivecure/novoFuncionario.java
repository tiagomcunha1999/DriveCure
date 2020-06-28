package pt.ipg.drivecure;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import BaseDados.BaseDadosHelper;

public class novoFuncionario extends AppCompatActivity {

    EditText nomeFuncionario, emailFuncionario, numeroFuncionario;
    Button btn_registoFuncionario;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.novo_funcionario);

        nomeFuncionario = findViewById(R.id.nomeFuncionario);
        emailFuncionario = findViewById(R.id.emailFuncionario);
        numeroFuncionario = findViewById(R.id.numeroFuncionario);

        btn_registoFuncionario = findViewById(R.id.btn_registoFuncionario);


        btn_registoFuncionario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                BaseDadosHelper db =  new BaseDadosHelper (novoFuncionario.this);
                db.addFuncionario(nomeFuncionario.getText().toString().trim(),
                        emailFuncionario.getText().toString().trim(),
                        Integer.valueOf(numeroFuncionario.getText().toString().trim()));


            }
        });



    }
}