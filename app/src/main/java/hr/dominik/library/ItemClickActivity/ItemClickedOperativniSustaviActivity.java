package hr.dominik.library.ItemClickActivity;

import androidx.appcompat.app.AppCompatActivity;
import hr.dominik.library.R;

import android.os.Bundle;

public class ItemClickedOperativniSustaviActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_clicked_operativni_sustavi);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setTitle("Item Clicked");
    }
}