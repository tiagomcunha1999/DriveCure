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
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class Entregas extends AppCompatActivity {

    RecyclerView recyclerViewEntregas;
    FloatingActionButton floatingButtonEntregas;
    ImageView empty_data;
    TextView no_data;

    MyDatabaseHelper myDB;
    ArrayList<String> id_cliente, nome_cliente, email_cliente, contacto_cliente;
    AdaptadorEntregas adaptadorEntregas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entregas);


        /* Ler recycler view e botão */
        recyclerViewEntregas = findViewById(R.id.recyclerViewEntregas);
        floatingButtonEntregas = findViewById(R.id.floatingButtonEntregas);
        empty_data = findViewById(R.id.empty_data_ent);
        no_data = findViewById(R.id.no_data_ent);

        floatingButtonEntregas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { /* Passar de atividade */
                Intent intent = new Intent(Entregas.this, novaEntrega.class );
                startActivity(intent);
            }
        });
        myDB = new MyDatabaseHelper(Entregas.this);

        id_cliente = new ArrayList<>();
        nome_cliente = new ArrayList<>();
        email_cliente = new ArrayList<>();
        contacto_cliente = new ArrayList<>();

        storeEntregasArrays();

        adaptadorEntregas = new AdaptadorEntregas(Entregas.this,this, id_cliente, nome_cliente, email_cliente,
                contacto_cliente);
        recyclerViewEntregas.setAdapter(adaptadorEntregas);

        recyclerViewEntregas.setLayoutManager(new LinearLayoutManager(Entregas.this));

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == 1){ // se o codigo da actividade for 1 como anteriormente referido ela é recriada logo faz refresh
            recreate();
        }
    }

    void storeEntregasArrays(){
        Cursor cursor = myDB.lerEntregas();

        if(cursor.getCount() == 0){
            empty_data.setVisibility(View.VISIBLE);
            no_data.setVisibility(View.VISIBLE);

        }else{
            while (cursor.moveToNext()){
                id_cliente.add(cursor.getString(0));
                nome_cliente.add(cursor.getString(1));
                email_cliente.add(cursor.getString(2));
                contacto_cliente.add(cursor.getString(3));
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
                MyDatabaseHelper myDB = new MyDatabaseHelper(Entregas.this);

                myDB.deleteAllData();

                //codigo para dar refresh
                Intent intent = new Intent(Entregas.this, Entregas.class);
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