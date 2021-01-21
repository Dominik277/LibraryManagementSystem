package hr.dominik.library.ModifyActivity;

import androidx.appcompat.app.AppCompatActivity;
import hr.dominik.library.DatabaseHelpers.HardverDatabaseHelper;
import hr.dominik.library.DatabaseHelpers.MrezeIProtokoliDatabaseHelper;
import hr.dominik.library.DatabaseHelpers.ProgramiranjeDatabaseHelper;
import hr.dominik.library.R;
import hr.dominik.library.draweraktivnosti.MrezeIProtokoliActivity;
import hr.dominik.library.draweraktivnosti.ProgramiranjeActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ModifyMrezeIProtokoliActivity extends AppCompatActivity {

    private EditText editTextImeKnjigeMrezeIProtokoli;
    private EditText editTextPisacMrezeIProtokoli;
    private EditText editTextStraniceMrezeIProtokoli;
    private Button gumbUpdateMrezeIProtokoli;
    private Button gumbDeleteMrezeIProtokoli;

    private MrezeIProtokoliDatabaseHelper databaseHelperMrezeIProtokoli;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modify_mreze_i_protokoli);

        editTextImeKnjigeMrezeIProtokoli = findViewById(R.id.modify_nameMrezeIProtokoli);
        editTextPisacMrezeIProtokoli = findViewById(R.id.modify_authorMrezeIProtokoli);
        editTextStraniceMrezeIProtokoli = findViewById(R.id.modify_pagesMrezeIProtokoli);

        gumbUpdateMrezeIProtokoli = findViewById(R.id.gumbUpdateMrezeIProtokoli);
        gumbDeleteMrezeIProtokoli = findViewById(R.id.gumbDeleteMrezeIProtokoli);

        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        String author = intent.getStringExtra("author");
        String pages = intent.getStringExtra("pages");

        editTextImeKnjigeMrezeIProtokoli.setText(name);
        editTextPisacMrezeIProtokoli.setText(author);
        editTextStraniceMrezeIProtokoli.setText(pages);

        String oldName = editTextImeKnjigeMrezeIProtokoli.getText().toString();

        gumbUpdateMrezeIProtokoli.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                databaseHelperMrezeIProtokoli = new MrezeIProtokoliDatabaseHelper(getApplicationContext());
                String name = editTextImeKnjigeMrezeIProtokoli.getText().toString();
                String author = editTextPisacMrezeIProtokoli.getText().toString();
                String pages = editTextStraniceMrezeIProtokoli.getText().toString();
                databaseHelperMrezeIProtokoli.updateItemMrezeIProtokoli(name,author,pages,oldName);
                Toast.makeText(ModifyMrezeIProtokoliActivity.this,"Uspješno ste ažurirali artikl!",Toast.LENGTH_LONG).show();
                startActivity(new Intent(ModifyMrezeIProtokoliActivity.this, MrezeIProtokoliActivity.class));
            }
        });

        gumbDeleteMrezeIProtokoli.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nameKnjige = editTextImeKnjigeMrezeIProtokoli.getText().toString();
                databaseHelperMrezeIProtokoli = new MrezeIProtokoliDatabaseHelper(getApplicationContext());
                databaseHelperMrezeIProtokoli.deleteItemMrezeIProtokoli(nameKnjige);
            }
        });
    }
}