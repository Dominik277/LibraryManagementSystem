package hr.dominik.library.draweraktivnosti;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import hr.dominik.library.DatabaseHelpers.MrezeIProtokoliDatabaseHelper;
import hr.dominik.library.DatabaseHelpers.ProgramiranjeDatabaseHelper;
import hr.dominik.library.ItemClickActivity.ItemClickProgramiranjeActivity;
import hr.dominik.library.ItemClickActivity.ItemClickedMrezeIProtokoliActivity;
import hr.dominik.library.ModifyActivity.ModifyMrezeIProtokoliActivity;
import hr.dominik.library.MrezeIProtokoliMenuActivity.PosudeneKnjigeMrezeIProtokoliActivity;
import hr.dominik.library.MrezeIProtokoliMenuActivity.WishListMrezeIProtokoliActivity;
import hr.dominik.library.R;
import hr.dominik.library.SearchActivity.SearchMrezeIProtokoliActivity;
import hr.dominik.library.SearchActivity.SearchProgramiranjeActivity;
import hr.dominik.library.UnesiKnjiguActivity.UnesiteKnjiguMrezeIProtokoliActivity;
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

public class MrezeIProtokoliActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mreze_i_protokoli);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setTitle("Mreže i Protokoli");

        MrezeIProtokoliDatabaseHelper databaseHelper = new MrezeIProtokoliDatabaseHelper(this);
        ArrayList<HashMap<String,String>> booksList = databaseHelper.getBooksMrezeIProtokoli();

        ListView listView = findViewById(R.id.listViewMrezeIProtokoli);
        ListAdapter adapter = new SimpleAdapter(MrezeIProtokoliActivity.this
                ,booksList
                ,R.layout.list_row_mreze_i_protokoli
                ,new String[]{"name","author","pages"}
                ,new int[]{R.id.textViewNameMrezeIProtokoli,R.id.textViewAuthorMrezeIProtokoli,R.id.textViewPagesMrezeIProtokoli});
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TextView textViewName = view.findViewById(R.id.textViewNameMrezeIProtokoli);
                String name = textViewName.getText().toString();

                Intent intent = new Intent(MrezeIProtokoliActivity.this, ItemClickedMrezeIProtokoliActivity.class);
                intent.putExtra("name",name);
                startActivity(intent);

            }
        });

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                TextView textViewName = view.findViewById(R.id.textViewNameMrezeIProtokoli);
                TextView textViewAutor = view.findViewById(R.id.textViewAuthorMrezeIProtokoli);
                TextView textViewStranice = view.findViewById(R.id.textViewPagesMrezeIProtokoli);

                String name = textViewName.getText().toString();
                String autor = textViewAutor.getText().toString();
                String stranice = textViewStranice.getText().toString();

                Intent intent = new Intent(getApplicationContext(), ModifyMrezeIProtokoliActivity.class);
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
        getMenuInflater().inflate(R.menu.mrezeiprotokoli_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.mreze_i_protokoli_menuAdd:
                startActivity(new Intent(MrezeIProtokoliActivity.this, UnesiteKnjiguMrezeIProtokoliActivity.class));
                break;
            case R.id.mreze_i_protokoli_menuSearch:
                startActivity(new Intent(MrezeIProtokoliActivity.this, SearchMrezeIProtokoliActivity.class));
                break;
            case R.id.posudeneKnjigeMrezeIProtokoli:
                startActivity(new Intent(MrezeIProtokoliActivity.this, PosudeneKnjigeMrezeIProtokoliActivity.class));
                break;
            case R.id.wishListKnjigeMrezeIProtokoli:
                startActivity(new Intent(MrezeIProtokoliActivity.this, WishListMrezeIProtokoliActivity.class));
                break;
        }
        return true;
    }
}