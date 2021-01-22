package hr.dominik.library.draweraktivnosti;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import hr.dominik.library.DatabaseHelpers.ProgramiranjeDatabaseHelper;
import hr.dominik.library.ItemClickActivity.ItemClickProgramiranjeActivity;
import hr.dominik.library.ModifyActivity.ModifyProgramiranjeActivity;
import hr.dominik.library.ProgramiranjeMenuActivity.PosudeneKnjigeProgramiranjeActivity;
import hr.dominik.library.ProgramiranjeMenuActivity.WishListProgramiranjeActivity;
import hr.dominik.library.R;
import hr.dominik.library.SearchActivity.SearchProgramiranjeActivity;
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

public class ProgramiranjeActivity extends AppCompatActivity {

    ListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_programiranje);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setTitle("Programiranje");

        ProgramiranjeDatabaseHelper databaseHelper = new ProgramiranjeDatabaseHelper(this);
        ArrayList<HashMap<String,String>> booksList = databaseHelper.getBooksProgramiranje();

        ListView listView = findViewById(R.id.listViewProgramiranje);
        adapter = new SimpleAdapter(ProgramiranjeActivity.this
                                    ,booksList
                                    ,R.layout.list_row_programiranje
                                    ,new String[]{"name","author","pages"}
                                    ,new int[]{R.id.textViewNameProgramiranje,R.id.textViewAuthorProgramiranje,R.id.textViewPagesProgramiranje});
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TextView textViewName = view.findViewById(R.id.textViewNameProgramiranje);
                String name = textViewName.getText().toString();

                Intent intent = new Intent(ProgramiranjeActivity.this,ItemClickProgramiranjeActivity.class);
                intent.putExtra("name",name);
                startActivity(intent);

            }
        });

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                TextView textViewName = view.findViewById(R.id.textViewNameProgramiranje);
                TextView textViewAutor = view.findViewById(R.id.textViewAuthorProgramiranje);
                TextView textViewStranice = view.findViewById(R.id.textViewPagesProgramiranje);

                String name = textViewName.getText().toString();
                String autor = textViewAutor.getText().toString();
                String stranice = textViewStranice.getText().toString();

                Intent intent = new Intent(getApplicationContext(), ModifyProgramiranjeActivity.class);
                intent.putExtra("name",name);
                intent.putExtra("author",autor);
                intent.putExtra("pages",stranice);

                startActivity(intent);
                return true;
            }
        });

        AdapterView.OnItemClickListener itemClickListener = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        };

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.programiranje_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.programiranje_menuAdd:
                startActivity(new Intent(ProgramiranjeActivity.this, UnesiteKnjiguProgramiranjeActivity.class));
                break;
            case R.id.programiranje_menuSearch:
                startActivity(new Intent(ProgramiranjeActivity.this, SearchProgramiranjeActivity.class));
                break;
            case R.id.posudeneKnjigeProgramiranje:
                startActivity(new Intent(ProgramiranjeActivity.this, PosudeneKnjigeProgramiranjeActivity.class));
                break;
            case R.id.wishListKnjigeProgramiranje:
                startActivity(new Intent(ProgramiranjeActivity.this, WishListProgramiranjeActivity.class));
        }
        return true;
    }
}