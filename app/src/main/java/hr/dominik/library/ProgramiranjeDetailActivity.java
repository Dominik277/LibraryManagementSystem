package hr.dominik.library;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class ProgramiranjeDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_programiranje_detail);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}