package hr.dominik.library.MrezeIProtokoliMenuActivity;

import androidx.appcompat.app.AppCompatActivity;
import hr.dominik.library.R;

import android.os.Bundle;

public class WishListMrezeIProtokoliActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wish_list_mreze_i_protokoli);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setTitle("Ovo je vaša Wish Lista!");
    }
}