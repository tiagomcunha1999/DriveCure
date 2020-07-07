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

    //Tabela CLIENTES
    private static final String TABLE_NAME2 = "TabelaClientes";
    private static final String COLUMN_ID_CLIENTE = "id_cliente";
    private static final String COLUMN_NOME_CLIENTE = "nome_cliente";
    private static final String COLUMN_EMAIL_CLIENTE = "email_clinte";
    private static final String COLUMN_CONTACTO_CLIENTE = "contacto_cliente";
    private static final String COLUMN_DESCRICAO = "descricao_produto";

    MyDatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {  /* CRIAÇAO DA TABELA DOS FUNCIONARIOS  */
        String query = "CREATE TABLE " + TABLE_NAME +
                        " (" + COLUMN_ID_FUNCIONARIO + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                        COLUMN_NOME_FUNCIONARIO + " TEXT NOT NULL, " +
                        COLUMN_EMAIL_FUNCIONARIO + " TEXT NOT NULL, " +
                        COLUMN_CONTACTO_FUNCIONARIO + " INTEGER NOT NULL);";
        db.execSQL(query);

        String query2 = "CREATE TABLE " + TABLE_NAME2 +
                " (" + COLUMN_ID_CLIENTE + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                COLUMN_NOME_CLIENTE + " TEXT NOT NULL, " +
                COLUMN_EMAIL_CLIENTE + " TEXT NOT NULL, " +
                COLUMN_CONTACTO_CLIENTE + " INTEGER NOT NULL," +
                COLUMN_DESCRICAO + " TEXT NOT NULL);";
        db.execSQL(query2);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME2);
        onCreate(db);
    }

    void addFuncionario(String nomeFuncionario, String emailFuncionario, Integer contactoFuncionario){
        SQLiteDatabase db = this.getWritableDatabase(); /* POder escrever dados na tabela*/
        ContentValues cv = new ContentValues(); /*Passar dados para as tabelas*/

        cv.put(COLUMN_NOME_FUNCIONARIO, nomeFuncionario);
        cv.put(COLUMN_EMAIL_FUNCIONARIO, emailFuncionario);
        cv.put(COLUMN_CONTACTO_FUNCIONARIO, contactoFuncionario);

        long resultado = db.insert(TABLE_NAME, null, cv);

        if (resultado == -1){
            Toast.makeText(context, "Failed to insert!", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "Successfully inserted!", Toast.LENGTH_SHORT).show();
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

    void updateData(String row_id, String nome, String email, String contacto){
        SQLiteDatabase db = this.getWritableDatabase(); //para poder escrever na base de dados
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_NOME_FUNCIONARIO, nome);
        cv.put(COLUMN_EMAIL_FUNCIONARIO, email);
        cv.put(COLUMN_CONTACTO_FUNCIONARIO, contacto);

         long result = db.update(TABLE_NAME, cv, "id_funcionario=?", new String[]{row_id});

        if(result == -1){
            Toast.makeText(context, "Failed update!", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(context, "Update!", Toast.LENGTH_SHORT).show();
        }
    }

    void deleteOneRow(String row_id){
        SQLiteDatabase db = this.getWritableDatabase();
        long result = db.delete(TABLE_NAME, "id_funcionario=?", new String[]{row_id}); //Eliminar string pelo id

        if(result == -1){
            Toast.makeText(context, "FAILED!", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(context, "Successfully deleted!", Toast.LENGTH_SHORT).show();
        }
    }


    void deleteAllData(){ //eleminar todos os dados
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("DELETE FROM " + TABLE_NAME);
    }

    public void novaEntrega(String nomeCliente, String emailCliente, Integer contactoCliente, String descricaoProduto) {

        SQLiteDatabase db = this.getWritableDatabase(); /* POder escrever dados na tabela*/
        ContentValues cv = new ContentValues(); /*Passar dados para as tabelas*/

        cv.put(COLUMN_NOME_CLIENTE, nomeCliente);
        cv.put(COLUMN_EMAIL_CLIENTE, emailCliente);
        cv.put(COLUMN_CONTACTO_CLIENTE, contactoCliente);
        cv.put(COLUMN_DESCRICAO, descricaoProduto);

        long resultado = db.insert(TABLE_NAME2, null, cv);

        if (resultado == -1){
            Toast.makeText(context, "Failed to insert!", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "Successfully inserted!", Toast.LENGTH_SHORT).show();
        }

    }

    Cursor lerEntregas(){
        String query = "SELECT * FROM " + TABLE_NAME2; /*Selecionar e ler os dados da tabela na base de dados*/
        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = null;
        if(db != null){
            cursor = db.rawQuery(query,null);
        }
        return cursor;
    }


    void updateData2(String row_id2, String nome, String email, String contacto){
        SQLiteDatabase db = this.getWritableDatabase(); //para poder escrever na base de dados
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_NOME_CLIENTE, nome);
        cv.put(COLUMN_EMAIL_CLIENTE, email);
        cv.put(COLUMN_CONTACTO_CLIENTE, contacto);

        long result = db.update(TABLE_NAME2, cv, "id_cliente=?", new String[]{row_id2});

        if(result == -1){
            Toast.makeText(context, "Failed update!", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(context, "Update!", Toast.LENGTH_SHORT).show();
        }
    }

    void deleteOneRow2(String row_id2){
        SQLiteDatabase db = this.getWritableDatabase();
        long result = db.delete(TABLE_NAME2, "id_cliente=?", new String[]{row_id2}); //Eliminar string pelo id

        if(result == -1){
            Toast.makeText(context, "FAILED!", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(context, "Successfully deleted!", Toast.LENGTH_SHORT).show();
        }
    }

    void deleteAllData2(){ //eleminar todos os dados
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("DELETE FROM " + TABLE_NAME2);
    }

}
