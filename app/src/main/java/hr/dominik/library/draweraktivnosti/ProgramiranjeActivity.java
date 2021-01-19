package hr.dominik.library.draweraktivnosti;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import hr.dominik.library.DatabaseHelpers.ProgramiranjeDatabaseHelper;
import hr.dominik.library.ModifyActivity;
import hr.dominik.library.R;
import hr.dominik.library.UnesiteKnjiguActivity;

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

public class ProgramiranjeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_programiranje);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ProgramiranjeDatabaseHelper databaseHelper = new ProgramiranjeDatabaseHelper(this);
        ArrayList<HashMap<String,String>> booksList = databaseHelper.getBooks();

        ListView listView = findViewById(R.id.listView);
        ListAdapter adapter = new SimpleAdapter(ProgramiranjeActivity.this
                                    ,booksList
                                    ,R.layout.list_row
                                    ,new String[]{"name","author","pages"}
                                    ,new int[]{R.id.textViewName,R.id.textViewAuthor,R.id.textViewPages});
        listView.setAdapter(adapter);

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                TextView textViewName = view.findViewById(R.id.textViewName);
                TextView textViewAutor = view.findViewById(R.id.textViewAuthor);
                TextView textViewStranice = view.findViewById(R.id.textViewPages);

                String name = textViewName.getText().toString();
                String autor = textViewAutor.getText().toString();
                String stranice = textViewStranice.getText().toString();

                Intent intent = new Intent(getApplicationContext(), ModifyActivity.class);
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
        getMenuInflater().inflate(R.menu.programiranje_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        startActivity(new Intent(ProgramiranjeActivity.this, UnesiteKnjiguActivity.class));
        return true;
    }
}