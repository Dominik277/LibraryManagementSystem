package hr.dominik.library.DatabaseHelpers;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;
import hr.dominik.library.R;

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

        insertProgramiranje(db,"Naučite React:Prevod drugog izdanja","Kirupa Čitanambi","298","2018", R.drawable.react);
        insertProgramiranje(db,"Arduino:Uvod u programiranje","Simon Monk","194","2017",R.drawable.arduino);
        insertProgramiranje(db,"Demistificirani C++","Julijan Šribar","1112","2017",R.drawable.demistrificiranic);
        insertProgramiranje(db,"Node.js Web razvoj","David Herron","840","2020",R.drawable.nodejs);
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

        ContentValues programiranjeValues = new ContentValues();
        programiranjeValues.put("IME_KNJIGE",imeKnjige);
        programiranjeValues.put("PISAC",pisac);
        programiranjeValues.put("STRANICE",stranice);
        programiranjeValues.put("GODINA",godina);
        programiranjeValues.put("SLIKA",slika);
        db.insert("PROGRAMIRANJE",null,programiranjeValues);

    }

}
