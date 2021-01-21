package hr.dominik.library.UnesiKnjiguActivity;

import androidx.appcompat.app.AppCompatActivity;
import hr.dominik.library.DatabaseHelpers.HardverDatabaseHelper;
import hr.dominik.library.DatabaseHelpers.ProgramiranjeDatabaseHelper;
import hr.dominik.library.R;
import hr.dominik.library.draweraktivnosti.HardverActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UnesiteKnjiguHardverActivity extends AppCompatActivity {

    Button gumbUnesiKnjiguHardver;
    EditText editTextUnesiKnjiguHardver;
    EditText editTextUnesiAutoraHardver;
    EditText editTextUnesiStraniceHardver;
    SQLiteDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unesite_knjigu_hardver);

        HardverDatabaseHelper databaseHelper = new HardverDatabaseHelper(this);

        gumbUnesiKnjiguHardver = findViewById(R.id.gumbUnesiKnjiguHardver);
        editTextUnesiKnjiguHardver = findViewById(R.id.editTextUnesiKnjiguHardver);
        editTextUnesiAutoraHardver = findViewById(R.id.editTextUnesiAutoraHardver);
        editTextUnesiStraniceHardver = findViewById(R.id.editTextUnesiStraniceHardver);

        gumbUnesiKnjiguHardver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String knjiga = editTextUnesiKnjiguHardver.getText().toString();
                String autor = editTextUnesiAutoraHardver.getText().toString();
                String stranice = editTextUnesiStraniceHardver.getText().toString();
                HardverDatabaseHelper databaseHelper =new HardverDatabaseHelper(UnesiteKnjiguHardverActivity.this);
                databaseHelper.insertBookHardver(knjiga,autor,stranice);
                startActivity(new Intent(UnesiteKnjiguHardverActivity.this, HardverActivity.class));
                Toast.makeText(getApplicationContext(),"Knjiga unešena u bazu podataka"
                        ,Toast.LENGTH_LONG).show();
            }
        });

    }
}