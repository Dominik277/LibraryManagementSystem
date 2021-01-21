package hr.dominik.library.SearchActivity;

import androidx.appcompat.app.AppCompatActivity;
import hr.dominik.library.R;

import android.os.Bundle;

public class SearchProgramiranjeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_programiranje);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setTitle("Ovdje možete pretražiti knjižnicu");
    }
}