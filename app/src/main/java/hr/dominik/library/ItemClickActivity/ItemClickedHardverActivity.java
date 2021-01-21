package hr.dominik.library.ItemClickActivity;

import androidx.appcompat.app.AppCompatActivity;
import hr.dominik.library.R;

import android.content.Intent;
import android.os.Bundle;

public class ItemClickedHardverActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_clicked_hardver);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        setTitle("Informacije o " + name);
    }
}