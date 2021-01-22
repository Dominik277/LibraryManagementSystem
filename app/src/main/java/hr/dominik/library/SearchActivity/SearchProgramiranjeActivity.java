package hr.dominik.library.SearchActivity;

import androidx.appcompat.app.AppCompatActivity;
import hr.dominik.library.DatabaseHelpers.ProgramiranjeDatabaseHelper;
import hr.dominik.library.R;
import hr.dominik.library.draweraktivnosti.ProgramiranjeActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

public class SearchProgramiranjeActivity extends AppCompatActivity {

    EditText editTextSearchProgramiranje;
    Button gumbPronadiKnjigu;
    ListView listViewSearchProgramiranje;

    private ProgramiranjeDatabaseHelper databaseHelperProgramiranje;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_programiranje);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setTitle("Ovdje možete pretražiti knjižnicu");

        editTextSearchProgramiranje = findViewById(R.id.editTextSearchProgramiranje);
        gumbPronadiKnjigu = findViewById(R.id.gumbPronadiKnjigu);
        listViewSearchProgramiranje = findViewById(R.id.listViewSearchProgramiranje);

        gumbPronadiKnjigu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               String editText = editTextSearchProgramiranje.getText().toString();
            }
        });

    }
}