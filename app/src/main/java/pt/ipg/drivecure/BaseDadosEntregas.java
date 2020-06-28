package pt.ipg.drivecure;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

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
                CAMPO_DESCRICAO + " TEXT NOT NULL" +
                ");";
        db.execSQL(query);
    }



    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
}
