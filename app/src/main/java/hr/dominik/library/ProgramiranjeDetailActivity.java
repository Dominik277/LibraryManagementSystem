package hr.dominik.library;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class ProgramiranjeDetailActivity extends AppCompatActivity {

    ImageView slika;
    TextView imeKnjige;
    TextView pisac;
    TextView stranice;
    TextView godine;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_programiranje_detail);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        int id = (Integer)getIntent().getExtras().get("id");

        slika = findViewById(R.id.slika);
        imeKnjige = findViewById(R.id.imeKnjige);
        pisac = findViewById(R.id.pisac);
        stranice = findViewById(R.id.stranice);
        godine = findViewById(R.id.godina);

        String imeKnjige2 = getIntent().getStringExtra("imeKnjige");
        String pisac2 = getIntent().getStringExtra("pisac");
        String stranice2 = getIntent().getStringExtra("stranice");
        String godina2 = getIntent().getStringExtra("godina");
        int slika2 = getIntent().getIntExtra("slika",0);



    }
}