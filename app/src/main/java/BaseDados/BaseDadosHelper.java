package BaseDados;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class BaseDadosHelper extends SQLiteOpenHelper {

    private Context context;
    public static final String DATABASE_NAME = "DiveCure.db";
    public static final int DATABASE_VERSION = 1;
    private static final boolean DESENVOLVIMENTO = true;

    public static final String NOME_TABELA = "funcionarios";

    public static final String CAMPO_NOME_FUNCIONARIO = "nome_funcionario";
    public static final String CAMPO_ID_FUNCIONARIO = "id_funcionario";
    public static final String CAMPO_EMAIL_FUNCIONARIO = "email_funcionario";
    public static final String CAMPO_NUMERO_FUNCIONARIO = "numero_funcionario";


    public BaseDadosHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("CREATE TABLE " + NOME_TABELA + "(" +
                CAMPO_ID_FUNCIONARIO + "INTERGER PRIMARY KEY AUTOINCREMENT, " +
                CAMPO_NOME_FUNCIONARIO + " TEXT NOT NULL," +
                CAMPO_EMAIL_FUNCIONARIO + " TEXT NOT NULL," +
                CAMPO_NUMERO_FUNCIONARIO + " TEXT NOT NULL" +
                ")");
    }

    /* public void seedData(SQLiteDatabase db){

        BdTableFuncionarios tabelaFuncionarios = new BdTableFuncionarios(db);


    } */

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        /*
        db.execSQL("DROP TABLE IF EXISTS "+ NOME_TABELA);
        onCreate(db);
        */

    }

    boolean addFuncionario(String nomeFuncionario, String emailFuncionario, String numeroFuncionario) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(CAMPO_NOME_FUNCIONARIO, nomeFuncionario);
        cv.put(CAMPO_EMAIL_FUNCIONARIO, emailFuncionario);
        cv.put(CAMPO_NUMERO_FUNCIONARIO, numeroFuncionario);

        long resultado = db.insert(NOME_TABELA, null, cv);

        if (resultado == -1) {
            Toast.makeText(context, "Registo Falhado", Toast.LENGTH_SHORT).show();
            return false;
        } else {
            Toast.makeText(context, "Registado com sucesso", Toast.LENGTH_SHORT).show();
            return true;

        }
    }
}