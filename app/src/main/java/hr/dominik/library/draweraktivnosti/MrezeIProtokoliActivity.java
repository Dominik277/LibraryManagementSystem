package hr.dominik.library.draweraktivnosti;

import androidx.appcompat.app.AppCompatActivity;
import hr.dominik.library.R;

import android.os.Bundle;

public class MrezeIProtokoliActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mreze_i_protokoli);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}