/*package BaseDados;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
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
    public static final String TABELA_ENTREGAS = "Entregas";

    public static final String CAMPO_NOME_FUNCIONARIO = "nome_funcionario";
    public static final String CAMPO_ID_FUNCIONARIO = "id_funcionario";
    public static final String CAMPO_EMAIL_FUNCIONARIO = "email_funcionario";
    public static final String CAMPO_NUMERO_FUNCIONARIO = "numero_funcionario";

    public static final String CAMPO_NOME_CLIENTE = "nome_cliente";
    public static final String CAMPO_ID_ENTREGA = "id_entrega";
    public static final String CAMPO_CONTACTO = "contacto_cliente";
    public static final String CAMPO_MORADA = "morada_cliente";
    public static final String CAMPO_DESCRICAO = "descricao_entrega";

    public BaseDadosHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String query = "CREATE TABLE " + NOME_TABELA + "(" +
                CAMPO_ID_FUNCIONARIO + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                CAMPO_NOME_FUNCIONARIO + " TEXT NOT NULL," +
                CAMPO_EMAIL_FUNCIONARIO + " TEXT NOT NULL," +
                CAMPO_NUMERO_FUNCIONARIO + " INTEGER NOT NULL" +
                ");";
        db.execSQL(query);
    }

    /* public void seedData(SQLiteDatabase db){

        BdTableFuncionarios tabelaFuncionarios = new BdTableFuncionarios(db);


    } */
 /*
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {


        db.execSQL("DROP TABLE IF EXISTS "+ NOME_TABELA);
        onCreate(db);


    }

    public void addFuncionario(String nomeFuncionario, String emailFuncionario, Integer numeroFuncionario) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(CAMPO_NOME_FUNCIONARIO, nomeFuncionario);
        cv.put(CAMPO_EMAIL_FUNCIONARIO, emailFuncionario);
        cv.put(CAMPO_NUMERO_FUNCIONARIO, numeroFuncionario);

        long resultado = db.insert(NOME_TABELA, null, cv);

        if (resultado == -1) {
            Toast.makeText(context, "Registo Falhado", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "Registado com sucesso", Toast.LENGTH_SHORT).show();

        }
    }

    public Cursor lerFuncionarios(){

        String query ="SELECT * FROM " + NOME_TABELA;
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = null;

        if(db != null){
             cursor = db.rawQuery(query, null);

        }
        return cursor;

    }
}

*/