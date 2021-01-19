package hr.dominik.library;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class ItemClickActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_click);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setTitle("Item Clicked");
    }
}