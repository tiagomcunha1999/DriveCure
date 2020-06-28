package pt.ipg.drivecure;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class BaseDadosEntregas extends SQLiteOpenHelper {

    private Context context;

    public static final String DATABASE_NAME = "Entregas.db";
    public static final int DATABASE_VERSION = 1;

    public static final String TABLE_NAME = "Entregas";

    public static final String CAMPO_NOME_CLIENTE = "nome_cliente";
    public static final String CAMPO_ID_ENTREGA = "id_entrega";
    public static final String CAMPO_CONTACTO = "contacto_cliente";
    public static final String CAMPO_MORADA = "morada_cliente";
    public static final String CAMPO_DESCRICAO = "descricao_entrega";
    public static final String CAMPO_NOME_FUNCIONARIO = "nome_funcionario";

    public BaseDadosEntregas(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String query = "CREATE TABLE " + TABLE_NAME + "(" +
                CAMPO_ID_ENTREGA + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                CAMPO_NOME_CLIENTE + " TEXT NOT NULL," +
                CAMPO_CONTACTO + " INTEGER NOT NULL," +
                CAMPO_MORADA + " TEXT NOT NULL," +
                CAMPO_DESCRICAO + " TEXT NOT NULL," +
                CAMPO_NOME_FUNCIONARIO + " TEXT NOT NULL" +
                ");";
        db.execSQL(query);
    }



    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }


    public void addEntrega(String nomeCliente, Integer numeroCliente, String moradaCliente, String descricaoEntrega, String nomeFuncionario) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(CAMPO_NOME_CLIENTE, nomeCliente);
        cv.put(CAMPO_CONTACTO, numeroCliente);
        cv.put(CAMPO_MORADA, moradaCliente);
        cv.put(CAMPO_DESCRICAO, descricaoEntrega);
        cv.put(CAMPO_NOME_FUNCIONARIO, nomeFuncionario);

        long resultado = db.insert(TABLE_NAME, null, cv);

        if (resultado == -1) {
            Toast.makeText(context, "Registo Falhado", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "Registado com sucesso", Toast.LENGTH_SHORT).show();

        }
    }

}
