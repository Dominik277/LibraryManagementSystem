package hr.dominik.library;

import androidx.appcompat.app.AppCompatActivity;
import hr.dominik.library.DatabaseHelpers.ProgramiranjeDatabaseHelper;

import android.content.Intent;
import android.os.Bundle;
import android.os.strictmode.SqliteObjectLeakedViolation;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.sql.SQLException;

public class ModifyActivity extends AppCompatActivity {

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
        setContentView(R.layout.activity_modify);
        setTitle("Azurirajte podatke");

        editTextImeKnjige = findViewById(R.id.modify_name);
        editTextPisac = findViewById(R.id.modify_author);
        editTextStranice = findViewById(R.id.modify_pages);

        gumbUpdate = findViewById(R.id.gumbUpdate);
        gumbDelete = findViewById(R.id.gumbDelete);

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
                    databaseHelper.updateBook(name,author,pages);
            }
        });

        gumbDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    String nameKnjige = editTextImeKnjige.getText().toString();
                    databaseHelper.deleteRow(nameKnjige);
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