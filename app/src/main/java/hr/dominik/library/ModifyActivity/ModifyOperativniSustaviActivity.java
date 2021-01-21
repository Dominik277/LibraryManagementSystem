package hr.dominik.library.ModifyActivity;

import androidx.appcompat.app.AppCompatActivity;
import hr.dominik.library.DatabaseHelpers.HardverDatabaseHelper;
import hr.dominik.library.DatabaseHelpers.OperativniSustaviDatabaseHelper;
import hr.dominik.library.DatabaseHelpers.ProgramiranjeDatabaseHelper;
import hr.dominik.library.R;
import hr.dominik.library.draweraktivnosti.OperativniSustaviActivity;
import hr.dominik.library.draweraktivnosti.ProgramiranjeActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ModifyOperativniSustaviActivity extends AppCompatActivity {

    private EditText editTextImeKnjigeOperativniSustavi;
    private EditText editTextPisacOperativniSustavi;
    private EditText editTextStraniceOperativniSustavi;
    private Button gumbUpdateOperativniSustavi;
    private Button gumbDeleteOperativniSustavi;

    private OperativniSustaviDatabaseHelper databaseHelperOperativniSustavi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modify_operativni_sustavi);

        editTextImeKnjigeOperativniSustavi = findViewById(R.id.modify_nameOperativniSustavi);
        editTextPisacOperativniSustavi = findViewById(R.id.modify_authorOperativniSustavi);
        editTextStraniceOperativniSustavi = findViewById(R.id.modify_pagesOperativniSustavi);

        gumbUpdateOperativniSustavi = findViewById(R.id.gumbUpdateOperativniSustavi);
        gumbDeleteOperativniSustavi = findViewById(R.id.gumbDeleteOperativniSustavi);

        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        String author = intent.getStringExtra("author");
        String pages = intent.getStringExtra("pages");

        editTextImeKnjigeOperativniSustavi.setText(name);
        editTextPisacOperativniSustavi.setText(author);
        editTextStraniceOperativniSustavi.setText(pages);

        String oldName = editTextImeKnjigeOperativniSustavi.getText().toString();

        gumbUpdateOperativniSustavi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                databaseHelperOperativniSustavi = new OperativniSustaviDatabaseHelper(getApplicationContext());
                String name = editTextImeKnjigeOperativniSustavi.getText().toString();
                String author = editTextPisacOperativniSustavi.getText().toString();
                String pages = editTextStraniceOperativniSustavi.getText().toString();
                databaseHelperOperativniSustavi.updateItemOperativniSustavi(name,author,pages,oldName);
                Toast.makeText(ModifyOperativniSustaviActivity.this,"Uspješno ste ažurirali artikl!",Toast.LENGTH_LONG).show();
                startActivity(new Intent(ModifyOperativniSustaviActivity.this, OperativniSustaviActivity.class));
            }
        });

        gumbDeleteOperativniSustavi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nameKnjige = editTextImeKnjigeOperativniSustavi.getText().toString();
                databaseHelperOperativniSustavi = new OperativniSustaviDatabaseHelper(getApplicationContext());
                databaseHelperOperativniSustavi.deleteItemOperativniSustavi(nameKnjige);
                Toast.makeText(ModifyOperativniSustaviActivity.this,"Uspješno ste obrisali artikl!",Toast.LENGTH_LONG).show();
                startActivity(new Intent(ModifyOperativniSustaviActivity.this, OperativniSustaviActivity.class));
            }
        });
    }
}