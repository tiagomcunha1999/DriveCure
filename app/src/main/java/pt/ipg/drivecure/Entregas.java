package pt.ipg.drivecure;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Entregas extends AppCompatActivity {

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entregas);

        recyclerView = findViewById(R.id.recyclerViewFuncionarios);

    }

    public void novaEntrega (View view){

        Intent intent = new Intent(this, novaEntrega.class);
        startActivity(intent);
    }
}
