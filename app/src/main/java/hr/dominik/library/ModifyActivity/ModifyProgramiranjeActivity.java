package hr.dominik.library.ModifyActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import hr.dominik.library.DatabaseHelpers.ProgramiranjeDatabaseHelper;
import hr.dominik.library.R;

public class ModifyProgramiranjeActivity extends AppCompatActivity {

    private EditText editTextImeKnjige;
    private EditText editTextPisac;
    private EditText editTextStranice;
    private Button gumbUpdate;
    private Button gumbDelete;
    private long _id;

    private ProgramiranjeDatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modify_programiranje);
        setTitle("Azurirajte podatke");

        editTextImeKnjige = findViewById(R.id.modify_nameProgramiranje);
        editTextPisac = findViewById(R.id.modify_authorProgramiranje);
        editTextStranice = findViewById(R.id.modify_pagesProgramiranje);

        gumbUpdate = findViewById(R.id.gumbUpdateProgramiranje);
        gumbDelete = findViewById(R.id.gumbDeleteProgramiranje);

        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        String author = intent.getStringExtra("author");
        String pages = intent.getStringExtra("pages");

        editTextImeKnjige.setText(name);
        editTextPisac.setText(author);
        editTextStranice.setText(pages);

        gumbUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    String name = editTextImeKnjige.getText().toString();
                    String author = editTextPisac.getText().toString();
                    String pages = editTextStranice.getText().toString();
                    databaseHelper.updateBookProgramiranje(name,author,pages);
            }
        });

        gumbDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    String nameKnjige = editTextImeKnjige.getText().toString();
                    databaseHelper.deleteRowProgramiranje(nameKnjige);
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