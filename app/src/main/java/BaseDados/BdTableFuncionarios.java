package BaseDados;

import android.database.sqlite.SQLiteDatabase;
import android.provider.BaseColumns;

public class BdTableFuncionarios implements BaseColumns {

    private SQLiteDatabase db;

    public BdTableFuncionarios(SQLiteDatabase db) {
        this.db = db;
    }

    public void cria() {
        db.execSQL("CREATE TABLE " + NOME_TABELA + "(" +
                _ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                CAMPO_TITULO + " TEXT NOT NULL," +
                CAMPO_ID_CATEGORIA + " INTEGER NOT NULL," +
                "FOREIGN KEY (" + CAMPO_ID_CATEGORIA + ") REFERENCES " +
                BdTableCategorias.NOME_TABELA + "("+ BdTableCategorias._ID + ")" +
                ")");
    }




}
