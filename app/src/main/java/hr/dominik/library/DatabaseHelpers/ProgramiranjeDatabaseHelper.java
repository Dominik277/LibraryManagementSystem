package hr.dominik.library.DatabaseHelpers;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class ProgramiranjeDatabaseHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "programiranje";
    private static final int DB_VERSION = 1;

    public ProgramiranjeDatabaseHelper(@Nullable Context context) {
        super(context,DB_NAME,null,DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE PROGRAMIRANJE ("
                + "_id INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "IME_KNJIGE TEXT, "
                + "PISAC TEXT, "
                + "STRANICE TEXT, "
                + "GODINA TEXT, "
                + "SLIKA INTEGER);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    private static void insertProgramiranje(SQLiteDatabase db,
                                            String imeKnjige,
                                            String pisac,
                                            String stranice,
                                            String godina,
                                            int slika){



    }

}
