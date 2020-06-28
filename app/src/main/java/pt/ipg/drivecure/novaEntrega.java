package pt.ipg.drivecure;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class novaEntrega extends AppCompatActivity {

    EditText nome_cliente, numero_cliente, morada_cliente, descricao_entrega, nome_funcionario;
    Button adicionar_entrega;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nova_entrega);

        nome_cliente = findViewById(R.id.nome_cliente);
        numero_cliente = findViewById(R.id.numero_cliente);
        morada_cliente = findViewById(R.id.morada_cliente);
        descricao_entrega = findViewById(R.id.descricao_entrega);
        nome_funcionario = findViewById(R.id.nome_funcionario);

        adicionar_entrega = findViewById(R.id.adicionar_entrega);

        adicionar_entrega.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BaseDadosEntregas db = new BaseDadosEntregas(novaEntrega.this);
                db.addEntrega(nome_cliente.getText().toString().trim(),
                        Integer.valueOf(numero_cliente.getText().toString().trim()),
                        morada_cliente.getText().toString().trim(),
                        descricao_entrega.getText().toString().trim(),
                        nome_funcionario.getText().toString().trim());

            }
        });

    }




}