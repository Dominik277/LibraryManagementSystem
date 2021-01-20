package hr.dominik.library.ItemClickActivity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import hr.dominik.library.R;

public class ItemClickProgramiranjeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_clicked_programiranje);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setTitle("Item Clicked");
    }
}