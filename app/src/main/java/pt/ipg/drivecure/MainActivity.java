package pt.ipg.drivecure;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void novaEntrega(View view){

        /*Intent intent = new Intent(this, novaEntrega.class);
        startActivity(intent);*/
    }

    public void Entregas(View view){

        /*Intent intent = new Intent(this, Entregas.class);
        startActivity(intent);*/
    }

    public void Funcionarios(View view){

        /*Intent intent = new Intent(this, Funcionarios.class);
        startActivity(intent);*/
    }
}
