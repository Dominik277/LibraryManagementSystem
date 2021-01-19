package hr.dominik.library.DatabaseHelpers;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class ProgramiranjeDatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "programiranje_db";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_NAME = "programiranje";
    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "name";

    SQLiteDatabase database;

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
        ContentValues contentValues = new ContentValues();
        contentValues.put("name",name);
        database.insert(TABLE_NAME,null,contentValues);
    }

    public Cursor getBook(){
        String[] columns = new String[]{ProgramiranjeDatabaseHelper.KEY_ID,
                                        ProgramiranjeDatabaseHelper.KEY_NAME};
        Cursor cursor = database.query(ProgramiranjeDatabaseHelper.TABLE_NAME
                        ,columns
                        ,null,null,null,null,null);
        if (columns != null){
            cursor.moveToFirst();
        }
        return cursor;
    }

    public int updateBook(long id,String name){
        ContentValues contentValues = new ContentValues();
        contentValues.put("name",name);
        int i = database.update(ProgramiranjeDatabaseHelper.TABLE_NAME
                ,contentValues
                ,ProgramiranjeDatabaseHelper.KEY_ID + "=" + id
                ,null);
        return i;
    }

    public void deleteRow(long id){
        database.delete(TABLE_NAME,ProgramiranjeDatabaseHelper.KEY_ID + "=" + id,null);
    }

}
