package hr.dominik.library.ItemClickActivity;

import androidx.appcompat.app.AppCompatActivity;
import hr.dominik.library.R;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ItemClickedHardverActivity extends AppCompatActivity {

    TextView hardverKnjiga;
    TextView hardverPisac;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_clicked_hardver);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        hardverKnjiga = findViewById(R.id.hardverKnjiga);
        hardverPisac = findViewById(R.id.hardverPisac);

        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        String author = intent.getStringExtra("author");
        String pages = intent.getStringExtra("pages");

        setTitle("Informacije o " + name);

        hardverKnjiga.setText(name);
        hardverPisac.setText(author);
    }
}