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
        courseModelArrayList.add(new ProgramiranjeKnjige("DSA", R.drawable.library));
        courseModelArrayList.add(new ProgramiranjeKnjige("JAVA", R.drawable.library));
        courseModelArrayList.add(new ProgramiranjeKnjige("C++", R.drawable.library));
        courseModelArrayList.add(new ProgramiranjeKnjige("Python", R.drawable.library));
        courseModelArrayList.add(new ProgramiranjeKnjige("Javascript", R.drawable.library));
        courseModelArrayList.add(new ProgramiranjeKnjige("DSA", R.drawable.library));

        ProgramiranjeAdapter adapter = new ProgramiranjeAdapter(this, courseModelArrayList);
        gridView.setAdapter(adapter);
    }
}