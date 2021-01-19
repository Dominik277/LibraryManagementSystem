package hr.dominik.library.DatabaseHelpers;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;


public class ProgramiranjeDatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "programiranje_db";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_NAME = "programiranje";
    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "name";

    public ProgramiranjeDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + "("
                + KEY_ID + "INTEGER PRIMARY KEY AUTOINCREMENT,"
                + KEY_NAME + "TEXT" + ")";
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public void insertBook(String name){

    }

    public Cursor getBook(){

    }

    public int updateBook(long id,String name){

    }

    public void deleteRow(long id){

    }

}
