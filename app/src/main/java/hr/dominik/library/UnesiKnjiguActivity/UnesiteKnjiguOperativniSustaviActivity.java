package hr.dominik.library.UnesiKnjiguActivity;

import androidx.appcompat.app.AppCompatActivity;
import hr.dominik.library.DatabaseHelpers.MrezeIProtokoliDatabaseHelper;
import hr.dominik.library.DatabaseHelpers.OperativniSustaviDatabaseHelper;
import hr.dominik.library.R;
import hr.dominik.library.draweraktivnosti.OperativniSustaviActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UnesiteKnjiguOperativniSustaviActivity extends AppCompatActivity {

    Button gumbUnesiKnjiguOperativniSustavi;
    EditText editTextUnesiKnjiguOperativniSustavi;
    EditText editTextUnesiAutoraOperativniSustavi;
    EditText editTextUnesiStraniceOperativniSustavi;
    SQLiteDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unesite_knjigu_operativni_sustavi);

        MrezeIProtokoliDatabaseHelper databaseHelper = new MrezeIProtokoliDatabaseHelper(this);

        gumbUnesiKnjiguOperativniSustavi = findViewById(R.id.gumbUnesiKnjiguOperativniSustavi);
        editTextUnesiKnjiguOperativniSustavi = findViewById(R.id.editTextUnesiKnjiguOperativniSustavi);
        editTextUnesiAutoraOperativniSustavi = findViewById(R.id.editTextUnesiAutoraOperativniSustavi);
        editTextUnesiStraniceOperativniSustavi = findViewById(R.id.editTextUnesiStraniceOperativniSustavi);

        gumbUnesiKnjiguOperativniSustavi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String knjiga = editTextUnesiKnjiguOperativniSustavi.getText().toString();
                String autor = editTextUnesiAutoraOperativniSustavi.getText().toString();
                String stranice = editTextUnesiStraniceOperativniSustavi.getText().toString();
                OperativniSustaviDatabaseHelper databaseHelper =new OperativniSustaviDatabaseHelper(UnesiteKnjiguOperativniSustaviActivity.this);
                databaseHelper.insertBookOperativniSustavi(knjiga,autor,stranice);
                startActivity(new Intent(UnesiteKnjiguOperativniSustaviActivity.this, OperativniSustaviActivity.class));
                Toast.makeText(getApplicationContext(),"Knjiga unešena u bazu podataka"
                        ,Toast.LENGTH_LONG).show();
            }
        });

    }
}