package hr.dominik.library.UnesiKnjiguActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import hr.dominik.library.DatabaseHelpers.ProgramiranjeDatabaseHelper;
import hr.dominik.library.R;
import hr.dominik.library.draweraktivnosti.ProgramiranjeActivity;

public class UnesiteKnjiguProgramiranjeActivity extends AppCompatActivity {

    Button gumbUnesiKnjigu;
    EditText editTextUnesiKnjigu;
    EditText editTextUnesiAutora;
    EditText editTextUnesiStranice;
    SQLiteDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unesite_knjigu_programiranje);
        setTitle("Ovdje možete unijeti novu knjigu");

        ProgramiranjeDatabaseHelper databaseHelper = new ProgramiranjeDatabaseHelper(this);

        gumbUnesiKnjigu = findViewById(R.id.gumbUnesiKnjiguProgramiranje);
        editTextUnesiKnjigu = findViewById(R.id.editTextUnesiKnjiguProgramiranje);
        editTextUnesiAutora = findViewById(R.id.editTextUnesiAutoraProgramiranje);
        editTextUnesiStranice = findViewById(R.id.editTextUnesiStraniceProgramiranje);

        gumbUnesiKnjigu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String knjiga = editTextUnesiKnjigu.getText().toString();
                String autor = editTextUnesiAutora.getText().toString();
                String stranice = editTextUnesiStranice.getText().toString();
                ProgramiranjeDatabaseHelper databaseHelper =new ProgramiranjeDatabaseHelper(UnesiteKnjiguProgramiranjeActivity.this);
                databaseHelper.insertBookProgramiranje(knjiga,autor,stranice);
                startActivity(new Intent(UnesiteKnjiguProgramiranjeActivity.this, ProgramiranjeActivity.class));
                Toast.makeText(getApplicationContext(),"Knjiga unešena u bazu podataka"
                        ,Toast.LENGTH_LONG).show();
            }
        });
    }
}