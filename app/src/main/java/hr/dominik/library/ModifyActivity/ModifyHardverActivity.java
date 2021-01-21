package hr.dominik.library.ModifyActivity;

import androidx.appcompat.app.AppCompatActivity;
import hr.dominik.library.DatabaseHelpers.HardverDatabaseHelper;
import hr.dominik.library.DatabaseHelpers.ProgramiranjeDatabaseHelper;
import hr.dominik.library.R;
import hr.dominik.library.draweraktivnosti.HardverActivity;
import hr.dominik.library.draweraktivnosti.ProgramiranjeActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ModifyHardverActivity extends AppCompatActivity {

    private EditText editTextImeKnjigeHardver;
    private EditText editTextPisacHardver;
    private EditText editTextStraniceHardver;
    private Button gumbUpdateHardver;
    private Button gumbDeleteHardver;

    private HardverDatabaseHelper databaseHelperHardver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modify_hardver);

        editTextImeKnjigeHardver = findViewById(R.id.modify_nameHardver);
        editTextPisacHardver = findViewById(R.id.modify_authorHardver);
        editTextStraniceHardver = findViewById(R.id.modify_pagesHardver);

        gumbUpdateHardver = findViewById(R.id.gumbUpdateHardver);
        gumbDeleteHardver = findViewById(R.id.gumbDeleteHardver);

        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        String author = intent.getStringExtra("author");
        String pages = intent.getStringExtra("pages");

        editTextImeKnjigeHardver.setText(name);
        editTextPisacHardver.setText(author);
        editTextStraniceHardver.setText(pages);

        String oldName = editTextImeKnjigeHardver.getText().toString();

        gumbUpdateHardver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                databaseHelperHardver = new HardverDatabaseHelper(getApplicationContext());
                String name = editTextImeKnjigeHardver.getText().toString();
                String author = editTextPisacHardver.getText().toString();
                String pages = editTextStraniceHardver.getText().toString();
                databaseHelperHardver.updateItemHardver(name,author,pages,oldName);
                Toast.makeText(ModifyHardverActivity.this,"Uspješno ste ažurirali artikl!",Toast.LENGTH_LONG).show();
                startActivity(new Intent(ModifyHardverActivity.this, HardverActivity.class));
            }
        });

        gumbDeleteHardver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nameKnjige = editTextImeKnjigeHardver.getText().toString();
                //databaseHelper.deleteRowHardver(nameKnjige);
                databaseHelperHardver = new HardverDatabaseHelper(getApplicationContext());
                databaseHelperHardver.deleteItemHardver(nameKnjige);

            }
        });
    }
}