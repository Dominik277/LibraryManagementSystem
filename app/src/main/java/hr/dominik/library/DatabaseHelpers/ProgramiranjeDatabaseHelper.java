package hr.dominik.library.DatabaseHelpers;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.view.View;


public class ProgramiranjeDatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "programiranje_db";
    public static final int DATABASE_VERSION = 1;
    public static final String TABLE_NAME = "programiranje";
    public static final String KEY_ID = "id";
    public static final String KEY_NAME = "name";

    SQLiteDatabase database;

    public ProgramiranjeDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + "("
                + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + KEY_NAME + " TEXT " + ")";
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public void insertBook(String name){
        database = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(ProgramiranjeDatabaseHelper.KEY_NAME,name);
        database.insert(TABLE_NAME,null,contentValues);
        database.close();
    }

    public Cursor getBook(){
        database = this.getReadableDatabase();
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
        database = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name",name);
        int i = database.update(ProgramiranjeDatabaseHelper.TABLE_NAME
                ,contentValues
                ,ProgramiranjeDatabaseHelper.KEY_ID + "=" + id
                ,null);
        return i;
    }

    public void deleteRow(long id){
        database = this.getWritableDatabase();
        database.delete(TABLE_NAME,ProgramiranjeDatabaseHelper.KEY_ID + "=" + id,null);
    }

}
