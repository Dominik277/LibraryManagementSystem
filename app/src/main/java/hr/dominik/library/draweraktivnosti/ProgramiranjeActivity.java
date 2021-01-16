package hr.dominik.library.draweraktivnosti;

import androidx.appcompat.app.AppCompatActivity;
import hr.dominik.library.ProgramiranjeAdapter;
import hr.dominik.library.ProgramiranjeKnjige;
import hr.dominik.library.R;

import android.os.Bundle;
import android.widget.GridView;

import java.util.ArrayList;

public class ProgramiranjeActivity extends AppCompatActivity {

    GridView gridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_programiranje);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        gridView = findViewById(R.id.gridView);

        ArrayList<ProgramiranjeKnjige> courseModelArrayList = new ArrayList<ProgramiranjeKnjige>();
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
    }
}