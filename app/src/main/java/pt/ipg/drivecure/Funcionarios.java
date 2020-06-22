package pt.ipg.drivecure;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Funcionarios extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_funcionarios);

    }

    public void registaFuncionario (View view){

        Intent intent = new Intent(this, registarFuncionario.class);
        startActivity(intent);
    }

}
