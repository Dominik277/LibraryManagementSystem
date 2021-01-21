package hr.dominik.library.UnesiKnjiguActivity;

import androidx.appcompat.app.AppCompatActivity;
import hr.dominik.library.DatabaseHelpers.MrezeIProtokoliDatabaseHelper;
import hr.dominik.library.DatabaseHelpers.ProgramiranjeDatabaseHelper;
import hr.dominik.library.R;
import hr.dominik.library.draweraktivnosti.MrezeIProtokoliActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UnesiteKnjiguMrezeIProtokoliActivity extends AppCompatActivity {

    Button gumbUnesiKnjiguMrezeIProtokoli;
    EditText editTextUnesiKnjiguMrezeIProtokoli;
    EditText editTextUnesiAutoraMrezeIProtokoli;
    EditText editTextUnesiStraniceMrezeIProtokoli;
    SQLiteDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unesite_knjigu_mreze_i_protokoli);

        MrezeIProtokoliDatabaseHelper databaseHelper = new MrezeIProtokoliDatabaseHelper(this);

        gumbUnesiKnjiguMrezeIProtokoli = findViewById(R.id.gumbUnesiKnjiguMrezeIProtokoli);
        editTextUnesiKnjiguMrezeIProtokoli = findViewById(R.id.editTextUnesiKnjiguMrezeIProtokoli);
        editTextUnesiAutoraMrezeIProtokoli = findViewById(R.id.editTextUnesiAutoraMrezeIProtokoli);
        editTextUnesiStraniceMrezeIProtokoli = findViewById(R.id.editTextUnesiStraniceMrezeIProtokoli);

        gumbUnesiKnjiguMrezeIProtokoli.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String knjiga = editTextUnesiKnjiguMrezeIProtokoli.getText().toString();
                String autor = editTextUnesiAutoraMrezeIProtokoli.getText().toString();
                String stranice = editTextUnesiStraniceMrezeIProtokoli.getText().toString();
                MrezeIProtokoliDatabaseHelper databaseHelper =new MrezeIProtokoliDatabaseHelper(UnesiteKnjiguMrezeIProtokoliActivity.this);
                databaseHelper.insertBookMrezeIProtokoli(knjiga,autor,stranice);
                startActivity(new Intent(UnesiteKnjiguMrezeIProtokoliActivity.this, MrezeIProtokoliActivity.class));
                Toast.makeText(getApplicationContext(),"Knjiga unešena u bazu podataka"
                        ,Toast.LENGTH_LONG).show();
            }
        });

    }
}