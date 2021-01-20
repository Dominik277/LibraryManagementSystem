package hr.dominik.library.ModifyActivity;

import androidx.appcompat.app.AppCompatActivity;
import hr.dominik.library.DatabaseHelpers.HardverDatabaseHelper;
import hr.dominik.library.DatabaseHelpers.ProgramiranjeDatabaseHelper;
import hr.dominik.library.R;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ModifyHardverActivity extends AppCompatActivity {

    private EditText editTextImeKnjigeHardver;
    private EditText editTextPisacHardver;
    private EditText editTextStraniceHardver;
    private Button gumbUpdateHardver;
    private Button gumbDeleteHardver;
    private long _id;

    private HardverDatabaseHelper databaseHelper;

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

        gumbUpdateHardver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = editTextImeKnjigeHardver.getText().toString();
                String author = editTextPisacHardver.getText().toString();
                String pages = editTextStraniceHardver.getText().toString();
                databaseHelper.updateBookHardver(name,author,pages);
            }
        });

        gumbDeleteHardver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nameKnjige = editTextImeKnjigeHardver.getText().toString();
                databaseHelper.deleteRowHardver(nameKnjige);
            }
        });
    }

    /*
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.gumbUpdate:
                String name = editTextImeKnjige.getText().toString();
                String author = editTextPisac.getText().toString();
                String pages = editTextStranice.getText().toString();
                databaseHelper.updateBook(name,author,pages);

            case R.id.gumbDelete:
                String nameKnjige = editTextImeKnjige.getText().toString();
                databaseHelper.deleteRow(nameKnjige);
                break;
        }
    }

 */

}