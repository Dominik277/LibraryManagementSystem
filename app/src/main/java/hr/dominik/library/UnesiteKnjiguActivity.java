package hr.dominik.library;

import androidx.appcompat.app.AppCompatActivity;
import hr.dominik.library.DatabaseHelpers.ProgramiranjeDatabaseHelper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class UnesiteKnjiguActivity extends AppCompatActivity {

    Button gumbUnesiKnjigu;
    EditText editTextUnesiKnjigu;
    SQLiteDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unesite_knjigu);

        ProgramiranjeDatabaseHelper databaseHelper = new ProgramiranjeDatabaseHelper(this);

        gumbUnesiKnjigu = findViewById(R.id.gumbUnesiKnjigu);
        editTextUnesiKnjigu = findViewById(R.id.editTextUnesiKnjigu);

        gumbUnesiKnjigu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String knjiga = editTextUnesiKnjigu.getText().toString();
                databaseHelper.insertBook(knjiga);
            }
        });
    }
}