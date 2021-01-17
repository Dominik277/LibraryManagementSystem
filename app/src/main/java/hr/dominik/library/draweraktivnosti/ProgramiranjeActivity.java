package hr.dominik.library.draweraktivnosti;

import androidx.appcompat.app.AppCompatActivity;
import hr.dominik.library.DatabaseHelpers.ProgramiranjeDatabaseHelper;
import hr.dominik.library.ProgramiranjeAdapter;
import hr.dominik.library.ProgramiranjeKnjige;
import hr.dominik.library.R;

import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

import java.util.ArrayList;

public class ProgramiranjeActivity extends AppCompatActivity {

    GridView gridView;
    private SQLiteDatabase db;
    private Cursor cursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_programiranje);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        gridView = findViewById(R.id.gridView);

        SQLiteOpenHelper programiranjeDatabaseHelper = new ProgramiranjeDatabaseHelper(this);
        try {
            db = programiranjeDatabaseHelper.getReadableDatabase();
            cursor = db.query("PROGRAMIRANJE",
                             new String[]{"_id","IME_KNJIGE","PISAC","STRANICE","GODINA","SLIKA"}
                             ,null,null,null,null,null);
            SimpleCursorAdapter listAdapter = new SimpleCursorAdapter(this,
                    android.R.layout.simple_list_item_1,
                    cursor,
                    new String[]{"IME_KNJIGE"},
                    new int[]{android.R.id.text1},
                    0);
        }catch (SQLException e){
            Toast toast = Toast.makeText(this,"Database unavailable",Toast.LENGTH_LONG);
            toast.show();
        }

/*
        ArrayList<ProgramiranjeKnjige> courseModelArrayList = new ArrayList<>();
        courseModelArrayList.add(new ProgramiranjeKnjige("Naučite React:Prevod Drugog Izdanja","Pisac:Kirupa Činatambi","Stranice:298","Godina:2018.", R.drawable.react));
        courseModelArrayList.add(new ProgramiranjeKnjige("Arduino:Uvod u programiranje","Pisac:Simon Monk","Stranice:194","Godina:2017", R.drawable.arduino));
        courseModelArrayList.add(new ProgramiranjeKnjige("Demistificirani C++","Pisac:Julijan Šribar","Stranice:1112","Godina:2018", R.drawable.demistrificiranic));
        courseModelArrayList.add(new ProgramiranjeKnjige("Node.js Web razvoj","Pisac:David Herron","Stranice:748","Godina:2020", R.drawable.nodejs));
        courseModelArrayList.add(new ProgramiranjeKnjige("Python bez okljevanja","Pisac:Paul Barry","Stranice:616", "Godina:2017",R.drawable.python));
        courseModelArrayList.add(new ProgramiranjeKnjige("Osnove PHP Programiranja","Pisac:Markus Gray","Stranice:212","Godina:2019", R.drawable.osnovephpprogramiranja));
        courseModelArrayList.add(new ProgramiranjeKnjige("PHP7,MySql i JavaScript","Pisac:Julie C.Meloni","Stranice:704","Godina:2018", R.drawable.php7));
        courseModelArrayList.add(new ProgramiranjeKnjige("Android Programiranje","Pisac:David Griffiths","Stranice:936","Godina:2018", R.drawable.androidprogramiranje));

        ProgramiranjeAdapter adapter = new ProgramiranjeAdapter(this, courseModelArrayList);
        gridView.setAdapter(adapter);

 */
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        cursor.close();
        db.close();
    }
}