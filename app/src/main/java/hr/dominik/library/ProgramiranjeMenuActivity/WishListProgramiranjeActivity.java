package hr.dominik.library.ProgramiranjeMenuActivity;

import androidx.appcompat.app.AppCompatActivity;
import hr.dominik.library.DatabaseHelpers.HardverDatabaseHelper;
import hr.dominik.library.HardverMenuActivity.WishListHardverActivity;
import hr.dominik.library.R;

import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.widget.CursorAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

public class WishListProgramiranjeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wish_list_programiranje);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setTitle("Ovo je vaša Wish Lista");
    }

    private void setupFavoritesListView(){
        ListView listView = findViewById(R.id.listViewWishListHardver);
        try {
            SQLiteOpenHelper databaseHelper = new HardverDatabaseHelper(this);
            SQLiteDatabase database = databaseHelper.getWritableDatabase();
            Cursor cursor = database.query(HardverDatabaseHelper.TABLE_NAME,
                    new String[]{},
                    "favorite = 1",
                    null,null,null,null);
            CursorAdapter favoriteAdapter = new SimpleCursorAdapter(WishListProgramiranjeActivity.this,
                    android.R.layout.simple_list_item_1,
                    cursor,
                    new String[]{"name"},
                    new int[]{android.R.id.text1},
                    0);
            listView.setAdapter(favoriteAdapter);
        }catch (SQLException e){
            Toast.makeText(this,"Database unavailable",
                    Toast.LENGTH_LONG).show();
        }
    }

}