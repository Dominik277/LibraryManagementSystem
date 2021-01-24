package hr.dominik.library.HardverMenuActivity;

import androidx.appcompat.app.AppCompatActivity;
import hr.dominik.library.R;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;

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
        String posudio = intent.getStringExtra("posudio");
        String email = intent.getStringExtra("email");

        listViewPosudeneKnjigeHardver = findViewById(R.id.listViewPosudeneHardver);



    }
}