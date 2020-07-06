package pt.ipg.drivecure;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class Funcionarios extends AppCompatActivity {

    RecyclerView recyclerViewFun;
    FloatingActionButton floatingButtonFun;

    MyDatabaseHelper myDB;
    ArrayList<String> id_funcionario, nome_funcionario, email_funcionario, contacto_funcionario;
    AdaptadorFuncionarios adaptadorFuncionarios;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_funcionarios);

        /* Ler recycler view e botão */
        recyclerViewFun = findViewById(R.id.recyclerViewFun);
        floatingButtonFun = findViewById(R.id.floatingButtonFun);

        floatingButtonFun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { /* Passar de atividade */
                Intent intent = new Intent(Funcionarios.this, addFuncionarios.class );
                startActivity(intent);
            }
        });

        myDB = new MyDatabaseHelper(Funcionarios.this);

        id_funcionario = new ArrayList<>();
        nome_funcionario = new ArrayList<>();
        email_funcionario = new ArrayList<>();
        contacto_funcionario = new ArrayList<>();

        storeFuncionariosArrays();

        adaptadorFuncionarios = new AdaptadorFuncionarios(Funcionarios.this,this, id_funcionario, nome_funcionario, email_funcionario,
                contacto_funcionario);
        recyclerViewFun.setAdapter(adaptadorFuncionarios);

        recyclerViewFun.setLayoutManager(new LinearLayoutManager(Funcionarios.this));

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == 1){ // se o codigo da actividade for 1 como anteriormente referido ela é recriada logo faz refresh
            recreate();
        }
    }

    void storeFuncionariosArrays(){
        Cursor cursor = myDB.lerFuncionarios();

        if(cursor.getCount() == 0){
            Toast.makeText(this,"Não existem dados", Toast.LENGTH_SHORT).show();
        }else{
            while (cursor.moveToNext()){
                id_funcionario.add(cursor.getString(0));
                nome_funcionario.add(cursor.getString(1));
                email_funcionario.add(cursor.getString(2));
                contacto_funcionario.add(cursor.getString(3));
            }

        }
    }
}