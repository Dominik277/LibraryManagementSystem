package hr.dominik.library.ProgramiranjeMenuActivity;

import androidx.appcompat.app.AppCompatActivity;
import hr.dominik.library.R;

import android.os.Bundle;

public class WishListProgramiranjeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wish_list_programiranje);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setTitle("Ovo je vaša Wish Lista");
    }
}