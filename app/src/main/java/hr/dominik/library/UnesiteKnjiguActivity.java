package hr.dominik.library;

import androidx.appcompat.app.AppCompatActivity;
import hr.dominik.library.DatabaseHelpers.ProgramiranjeDatabaseHelper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UnesiteKnjiguActivity extends AppCompatActivity {

    Button gumbUnesiKnjigu;
    EditText editTextUnesiKnjigu;
    EditText editTextUnesiAutora;
    EditText editTextUnesiStranice;
    SQLiteDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unesite_knjigu);

        ProgramiranjeDatabaseHelper databaseHelper = new ProgramiranjeDatabaseHelper(this);

        gumbUnesiKnjigu = findViewById(R.id.gumbUnesiKnjigu);
        editTextUnesiKnjigu = findViewById(R.id.editTextUnesiKnjigu);
        editTextUnesiAutora = findViewById(R.id.editTextUnesiAutora);
        editTextUnesiStranice = findViewById(R.id.editTextUnesiStranice);

        gumbUnesiKnjigu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String knjiga = editTextUnesiKnjigu.getText().toString();
                String autor = editTextUnesiAutora.getText().toString();
                String stranice = editTextUnesiStranice.getText().toString();
                ProgramiranjeDatabaseHelper databaseHelper =new ProgramiranjeDatabaseHelper(UnesiteKnjiguActivity.this);
                databaseHelper.insertBook(knjiga,autor,stranice);
                Toast.makeText(getApplicationContext(),"Knjiga unešena u bazu podataka"
                        ,Toast.LENGTH_LONG).show();
            }
        });
    }
}