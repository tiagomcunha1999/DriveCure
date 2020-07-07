package pt.ipg.drivecure;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class Funcionarios extends AppCompatActivity {

    RecyclerView recyclerViewFun;
    FloatingActionButton floatingButtonFun;
    ImageView empty_data;
    TextView no_data;


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
        empty_data = findViewById(R.id.empty_data);
        no_data = findViewById(R.id.no_data);

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
            empty_data.setVisibility(View.VISIBLE);
            no_data.setVisibility(View.VISIBLE);

        }else{
            while (cursor.moveToNext()){
                id_funcionario.add(cursor.getString(0));
                nome_funcionario.add(cursor.getString(1));
                email_funcionario.add(cursor.getString(2));
                contacto_funcionario.add(cursor.getString(3));
            }
            empty_data.setVisibility(View.GONE);
            no_data.setVisibility(View.GONE);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.my_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
       if(item.getItemId() == R.id.delete_all){
           confirmDialog();
       }

        return super.onOptionsItemSelected(item);
    }

    void confirmDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Delete All?");
        builder.setMessage("Are you sure you want to delete all data?");
        builder.setPositiveButton("yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                MyDatabaseHelper myDB = new MyDatabaseHelper(Funcionarios.this);

                myDB.deleteAllData();

                //codigo para dar refresh
                Intent intent = new Intent(Funcionarios.this, Funcionarios.class);
                startActivity(intent);
                finish();
            }
        });

        builder.setNegativeButton("no", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        builder.create().show();
    }
}