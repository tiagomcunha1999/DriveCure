package pt.ipg.drivecure;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

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
        String query = "CREATE TABLE " + TABLE_NAME +
                        " (" + COLUMN_ID_FUNCIONARIO + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                        COLUMN_NOME_FUNCIONARIO + " TEXT, " +
                        COLUMN_EMAIL_FUNCIONARIO + " TEXT, " +
                        COLUMN_CONTACTO_FUNCIONARIO + " INTEGER);";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        /*db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);*/
    }

    void addFuncionario(String nomeFuncionario, String emailFuncionario, Integer contactoFuncionario){
        SQLiteDatabase db = this.getWritableDatabase(); /* POder escrever dados na tabela*/
        ContentValues cv = new ContentValues(); /*Passar dados para as tabelas*/

        cv.put(COLUMN_NOME_FUNCIONARIO, nomeFuncionario);
        cv.put(COLUMN_EMAIL_FUNCIONARIO, emailFuncionario);
        cv.put(COLUMN_CONTACTO_FUNCIONARIO, contactoFuncionario);

        long resultado = db.insert(TABLE_NAME, null, cv);

        if (resultado == -1){
            Toast.makeText(context, "Funcionario nao foi registado", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "Funcionario registado com sucesso", Toast.LENGTH_SHORT).show();
        }
    }


    Cursor lerFuncionarios(){
        String query = "SELECT * FROM " + TABLE_NAME; /*Selecionar e ler os dados da tabela na base de dados*/
        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = null;
        if(db != null){
            cursor = db.rawQuery(query,null);
        }
        return cursor;
    }
}
