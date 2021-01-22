package hr.dominik.library.draweraktivnosti;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import hr.dominik.library.DatabaseHelpers.OperativniSustaviDatabaseHelper;
import hr.dominik.library.DatabaseHelpers.ProgramiranjeDatabaseHelper;
import hr.dominik.library.ItemClickActivity.ItemClickProgramiranjeActivity;
import hr.dominik.library.ItemClickActivity.ItemClickedOperativniSustaviActivity;
import hr.dominik.library.ModifyActivity.ModifyOperativniSustaviActivity;
import hr.dominik.library.OperativniSustaviMenuActivity.PosudeneKnjigeOperativniSustaviActivity;
import hr.dominik.library.OperativniSustaviMenuActivity.WishListOperativniSustaviActivity;
import hr.dominik.library.R;
import hr.dominik.library.SearchActivity.SearchOperativniSustaviActivity;
import hr.dominik.library.SearchActivity.SearchProgramiranjeActivity;
import hr.dominik.library.UnesiKnjiguActivity.UnesiteKnjiguOperativniSustaviActivity;
import hr.dominik.library.UnesiKnjiguActivity.UnesiteKnjiguProgramiranjeActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class OperativniSustaviActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_operativni_sustavi);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setTitle("Operativni Sustavi");

        OperativniSustaviDatabaseHelper databaseHelper = new OperativniSustaviDatabaseHelper(this);
        ArrayList<HashMap<String,String>> booksList = databaseHelper.getBooksOperativniSustavi();

        ListView listView = findViewById(R.id.listViewOperativniSustavi);
        ListAdapter adapter = new SimpleAdapter(OperativniSustaviActivity.this
                ,booksList
                ,R.layout.list_row_operativni_sustavi
                ,new String[]{"name","author","pages"}
                ,new int[]{R.id.textViewNameOperativniSustavi,R.id.textViewAuthorOperativniSustavi,R.id.textViewPagesOperativniSustavi});
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TextView textViewName = view.findViewById(R.id.textViewNameOperativniSustavi);
                String name = textViewName.getText().toString();

                Intent intent = new Intent(OperativniSustaviActivity.this, ItemClickedOperativniSustaviActivity.class);
                intent.putExtra("name",name);
                startActivity(intent);

            }
        });

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                TextView textViewName = view.findViewById(R.id.textViewNameOperativniSustavi);
                TextView textViewAutor = view.findViewById(R.id.textViewAuthorOperativniSustavi);
                TextView textViewStranice = view.findViewById(R.id.textViewPagesOperativniSustavi);

                String name = textViewName.getText().toString();
                String autor = textViewAutor.getText().toString();
                String stranice = textViewStranice.getText().toString();

                Intent intent = new Intent(getApplicationContext(), ModifyOperativniSustaviActivity.class);
                intent.putExtra("name",name);
                intent.putExtra("author",autor);
                intent.putExtra("pages",stranice);

                startActivity(intent);
                return true;
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.operativnisustavi_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.operativni_sustavi_menuAdd:
                startActivity(new Intent(OperativniSustaviActivity.this, UnesiteKnjiguOperativniSustaviActivity.class));
                break;
            case R.id.operativni_sustavi_menuSearch:
                startActivity(new Intent(OperativniSustaviActivity.this, SearchOperativniSustaviActivity.class));
                break;
            case R.id.posudeneKnjigeOperativniSustavi:
                startActivity(new Intent(OperativniSustaviActivity.this, PosudeneKnjigeOperativniSustaviActivity.class));
                break;
            case R.id.wishListKnjigeOperativniSustavi:
                startActivity(new Intent(OperativniSustaviActivity.this, WishListOperativniSustaviActivity.class));
                break;
        }
        return true;
    }
}