package hr.dominik.library.draweraktivnosti;

import androidx.appcompat.app.AppCompatActivity;
import hr.dominik.library.R;

import android.os.Bundle;

public class OrganskaKemijaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_organska_kemija);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}