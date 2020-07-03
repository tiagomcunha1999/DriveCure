package pt.ipg.drivecure;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class Funcionarios extends AppCompatActivity {

    RecyclerView recyclerViewFun;
    FloatingActionButton floatingButtonFun;

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
    }
}