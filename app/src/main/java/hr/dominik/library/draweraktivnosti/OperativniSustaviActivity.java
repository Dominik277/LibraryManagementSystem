package hr.dominik.library.draweraktivnosti;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import hr.dominik.library.DatabaseHelpers.OperativniSustaviDatabaseHelper;
import hr.dominik.library.DatabaseHelpers.ProgramiranjeDatabaseHelper;
import hr.dominik.library.ItemClickActivity.ItemClickedOperativniSustaviActivity;
import hr.dominik.library.ModifyActivity.ModifyOperativniSustaviActivity;
import hr.dominik.library.R;
import hr.dominik.library.UnesiKnjiguActivity.UnesiteKnjiguOperativniSustaviActivity;

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
                startActivity(new Intent(OperativniSustaviActivity.this, ItemClickedOperativniSustaviActivity.class));

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
        startActivity(new Intent(OperativniSustaviActivity.this, UnesiteKnjiguOperativniSustaviActivity.class));
        return true;
    }

}