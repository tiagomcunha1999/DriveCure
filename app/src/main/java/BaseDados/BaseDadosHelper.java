package BaseDados;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class BaseDadosHelper extends SQLiteOpenHelper {

    private  Context context;
    public static final String DATABASE_NAME = "DiveCure.db";
    public static final int DATABASE_VERSION = 1;




    public BaseDadosHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
