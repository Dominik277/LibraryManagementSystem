package hr.dominik.library.DatabaseHelpers;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.view.View;

import java.util.ArrayList;
import java.util.HashMap;


public class ProgramiranjeDatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "programiranje_db";
    public static final int DATABASE_VERSION = 2;
    public static final String TABLE_NAME = "programiranje";
    public static final String KEY_ID = "id";
    public static final String KEY_NAME = "name";
    public static final String KEY_AUTHOR = "author";
    public static final String KEY_PAGES = "pages";

    SQLiteDatabase database;

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

    public void insertBook(String name,String author,String pages){
        database = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(KEY_NAME,name);
        contentValues.put(KEY_AUTHOR,author);
        contentValues.put(KEY_PAGES,pages);
        database.insert(TABLE_NAME,null,contentValues);
        database.close();
    }

    public ArrayList<HashMap<String,String>> getBooks(){
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

    public ArrayList<HashMap<String,String>> getBookById(int bookId){
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

    public int updateBook(String name,String author,String pages,int id){
        database = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(KEY_NAME,name);
        contentValues.put(KEY_AUTHOR,author);
        contentValues.put(KEY_PAGES,pages);
        int count = database.update(TABLE_NAME
                ,contentValues
                ,KEY_ID + "=" + id
                ,new String[]{String.valueOf(id)});
        return count;
    }

    public void deleteRow(long id){
        database = this.getWritableDatabase();
        database.delete(TABLE_NAME
                ,KEY_ID + " = ?"
                ,new String[]{String.valueOf(id)});
    }

}
