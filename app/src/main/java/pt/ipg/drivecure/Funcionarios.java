package pt.ipg.drivecure;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class Funcionarios extends AppCompatActivity {


    RecyclerView recyclerView;
    FloatingActionButton floatingActionButtonFun;

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

    }



}
