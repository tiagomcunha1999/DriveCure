package pt.ipg.drivecure;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;


public class MyDatabaseHelper extends SQLiteOpenHelper {

    private Context context;
    /*Versao e nome da base de dados*/
    private static final String DATABASE_NAME = "DriveCure.db";
    private static final int DATABASE_VERSION = 1;

    /*tabela dos funcionarios - nome e colunas*/
    private static final String TABLE_NAME = "TabelaFuncionarios";
    private static final String COLUMN_ID_FUNCIONARIO = "id_funcionario";
    private static final String COLUMN_NOME_FUNCIONARIO = "nome_funcionario";
    private static final String COLUMN_EMAIL_FUNCIONARIO = "email_funcionario";
    private static final String COLUMN_CONTACTO_FUNCIONARIO = "contacto_funcionario";


    public MyDatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {  /* CRIAÇAO DA TABELA DOS FUNCIONARIOS  */
        String query =
                "CREATE TABLE " + TABLE_NAME +
                        " (" + COLUMN_ID_FUNCIONARIO + "INTEGER PRIMARY KEY AUTOINCREMENT," +
                        COLUMN_NOME_FUNCIONARIO + " TEXT, " +
                        COLUMN_EMAIL_FUNCIONARIO + " TEXT, " +
                        COLUMN_CONTACTO_FUNCIONARIO + " INTEGER);";
        db.execSQL(query);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    void addFuncionario(){
        
    }
}
