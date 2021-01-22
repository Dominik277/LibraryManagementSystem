package hr.dominik.library.ProgramiranjeMenuActivity;

import androidx.appcompat.app.AppCompatActivity;
import hr.dominik.library.R;

import android.os.Bundle;

public class PosudeneKnjigeProgramiranjeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_posudene_knjige_programiranje);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setTitle("Ove knjige su posuđene!");
    }
}