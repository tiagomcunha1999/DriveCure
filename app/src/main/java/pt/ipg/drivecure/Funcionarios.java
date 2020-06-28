package pt.ipg.drivecure;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

import BaseDados.BaseDadosHelper;

public class Funcionarios extends AppCompatActivity {


     RecyclerView recyclerView;
     FloatingActionButton floatingActionButtonFun;

     BaseDadosHelper db;
     ArrayList<String> id_funcionario, nome_funcionario, email_funcionario, numero_funcionario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_funcionarios);

        recyclerView = findViewById(R.id.recyclerViewFuncionarios);
        floatingActionButtonFun = findViewById(R.id.recyclerViewFuncionarios);

        floatingActionButtonFun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Funcionarios.this, novoFuncionario.class);
                startActivity(intent);
            }
        });

        db = new BaseDadosHelper(Funcionarios.this);
        id_funcionario = new ArrayList<>();
        nome_funcionario = new ArrayList<>();
        email_funcionario = new ArrayList<>();
        numero_funcionario = new ArrayList<>();

        verDataArrays();
    }

        void  verDataArrays(){

         Cursor cursor = db.lerFuncionarios();
         if(cursor.getCount() == 0){

             Toast.makeText(this, "Nao existem dados.", Toast.LENGTH_SHORT).show();
         }else{
             while (cursor.moveToNext()){
                 id_funcionario.add(cursor.getString(0));
                 nome_funcionario.add(cursor.getString(1));
                 email_funcionario.add(cursor.getString(2));
                 numero_funcionario.add(cursor.getString(3));

             }
         }




        }


}
