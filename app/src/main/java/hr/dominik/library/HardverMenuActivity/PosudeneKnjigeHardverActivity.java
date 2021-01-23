package hr.dominik.library.HardverMenuActivity;

import androidx.appcompat.app.AppCompatActivity;
import hr.dominik.library.R;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;

public class PosudeneKnjigeHardverActivity extends AppCompatActivity {

    ListView listViewPosudeneKnjigeHardver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_posudene_knjige_hardver);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setTitle("Ove knjige su posuđene!");

        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        String author = intent.getStringExtra("author");

        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add(name);
        arrayList.add(author);

        listViewPosudeneKnjigeHardver = findViewById(R.id.listViewPosudeneHardver);
        ListAdapter adapter = new SimpleAdapter(
                PosudeneKnjigeHardverActivity.this
                ,arrayList
                ,R.layout.posudene_knjige_item
                ,new String[]{}
                ,
        );
        listViewPosudeneKnjigeHardver.setAdapter(adapter);

    }
}