package hr.dominik.library.draweraktivnosti;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import hr.dominik.library.DatabaseHelpers.HardverDatabaseHelper;
import hr.dominik.library.DatabaseHelpers.ProgramiranjeDatabaseHelper;
import hr.dominik.library.ItemClickActivity.ItemClickProgramiranjeActivity;
import hr.dominik.library.ItemClickActivity.ItemClickedHardverActivity;
import hr.dominik.library.ModifyActivity.ModifyHardverActivity;
import hr.dominik.library.R;
import hr.dominik.library.UnesiKnjiguActivity.UnesiteKnjiguHardverActivity;

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

public class HardverActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hardver);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setTitle("Hardver");

        HardverDatabaseHelper databaseHelper = new HardverDatabaseHelper(this);
        ArrayList<HashMap<String,String>> booksList = databaseHelper.getBooksHardver();

        ListView listView = findViewById(R.id.listViewHardver);
        ListAdapter adapter = new SimpleAdapter(HardverActivity.this
                ,booksList
                ,R.layout.list_row_hardver
                ,new String[]{"name","author","pages"}
                ,new int[]{R.id.textViewNameHardver,R.id.textViewAuthorHardver,R.id.textViewPagesHardver});
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TextView textViewName = view.findViewById(R.id.textViewNameHardver);
                String name = textViewName.getText().toString();

                Intent intent = new Intent(HardverActivity.this, ItemClickedHardverActivity.class);
                intent.putExtra("name",name);
                startActivity(intent);

            }
        });

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                TextView textViewName = view.findViewById(R.id.textViewNameHardver);
                TextView textViewAutor = view.findViewById(R.id.textViewAuthorHardver);
                TextView textViewStranice = view.findViewById(R.id.textViewPagesHardver);

                String name = textViewName.getText().toString();
                String autor = textViewAutor.getText().toString();
                String stranice = textViewStranice.getText().toString();

                Intent intent = new Intent(getApplicationContext(), ModifyHardverActivity.class);
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
        getMenuInflater().inflate(R.menu.hardver_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        startActivity(new Intent(HardverActivity.this, UnesiteKnjiguHardverActivity.class));
        return true;
    }

}