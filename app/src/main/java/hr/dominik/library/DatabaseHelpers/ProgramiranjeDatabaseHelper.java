package hr.dominik.library.DatabaseHelpers;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.HashMap;


public class ProgramiranjeDatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "programiranje_db";
    public static final int DATABASE_VERSION = 3;
    public static final String TABLE_NAME = "programiranje";
    public static final String KEY_ID = "id";
    public static final String KEY_NAME = "name";
    public static final String KEY_AUTHOR = "author";
    public static final String KEY_PAGES = "pages";

    public SQLiteDatabase databaseProgramiranje;

    public ProgramiranjeDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + "("
                + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + KEY_NAME + " TEXT, "
                + KEY_AUTHOR + " TEXT, "
                + KEY_PAGES + " TEXT "
                + ")";
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public void insertBookProgramiranje(String name, String author, String pages){
        databaseProgramiranje = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(KEY_NAME,name);
        contentValues.put(KEY_AUTHOR,author);
        contentValues.put(KEY_PAGES,pages);
        databaseProgramiranje.insert(TABLE_NAME,null,contentValues);
        databaseProgramiranje.close();
    }

    public ArrayList<HashMap<String,String>> getBooksProgramiranje(){
        SQLiteDatabase database = this.getWritableDatabase();
        ArrayList<HashMap<String,String>> booksList = new ArrayList<>();
        String query = " SELECT name,author,pages FROM " + TABLE_NAME;
        Cursor cursor = database.rawQuery(query,null);
        while (cursor.moveToNext()){
            HashMap<String,String> books = new HashMap<>();
            books.put("name",cursor.getString(cursor.getColumnIndex(KEY_NAME)));
            books.put("author",cursor.getString(cursor.getColumnIndex(KEY_AUTHOR)));
            books.put("pages",cursor.getString(cursor.getColumnIndex(KEY_PAGES)));
            booksList.add(books);
        }
        return booksList;
    }

    public ArrayList<HashMap<String,String>> getBookByIdProgramiranje(int bookId){
        SQLiteDatabase database = this.getWritableDatabase();
        ArrayList<HashMap<String,String>> bookList = new ArrayList<>();
        String query = "SELECT name, author, pages FROM " + TABLE_NAME;
        Cursor cursor = database.query(TABLE_NAME,new String[]{KEY_NAME,KEY_AUTHOR,KEY_PAGES}
                                    , KEY_ID + "=?"
                                    ,new String[]{String.valueOf(bookId)}
                                    ,null,null,null,null);
        if (cursor.moveToNext()){
            HashMap<String,String> book = new HashMap<>();
            book.put("name",cursor.getString(cursor.getColumnIndex(KEY_NAME)));
            book.put("author",cursor.getString(cursor.getColumnIndex(KEY_AUTHOR)));
            book.put("pages",cursor.getString(cursor.getColumnIndex(KEY_PAGES)));
            bookList.add(book);
        }
        return bookList;
    }

    public void deleteItemProgramiranje(String name){
        SQLiteDatabase database = this.getWritableDatabase();
        database.execSQL("DELETE FROM " + TABLE_NAME + " WHERE name = '" + name + "'");
    }

    public int updateItemProgramiranje(String name, String author, String pages,String oldName){
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(KEY_NAME,name);
        contentValues.put(KEY_AUTHOR,author);
        contentValues.put(KEY_PAGES,pages);
        int i = database.update(TABLE_NAME,contentValues,"name = ?",new String[]{oldName});
        return i;
    }

    public void searchQuery(){

    }

}
