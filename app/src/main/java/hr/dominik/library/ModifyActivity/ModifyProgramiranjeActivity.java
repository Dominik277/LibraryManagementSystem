package hr.dominik.library.ModifyActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import hr.dominik.library.DatabaseHelpers.ProgramiranjeDatabaseHelper;
import hr.dominik.library.R;

public class ModifyProgramiranjeActivity extends AppCompatActivity {

    private EditText editTextImeKnjigeProgramiranje;
    private EditText editTextPisacProgramiranje;
    private EditText editTextStraniceProgramiranje;
    private Button gumbUpdateProgramiranje;
    private Button gumbDeleteProgramiranje;

    private ProgramiranjeDatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modify_programiranje);
        setTitle("Azurirajte podatke");

        editTextImeKnjigeProgramiranje = findViewById(R.id.modify_nameProgramiranje);
        editTextPisacProgramiranje = findViewById(R.id.modify_authorProgramiranje);
        editTextStraniceProgramiranje = findViewById(R.id.modify_pagesProgramiranje);

        gumbUpdateProgramiranje = findViewById(R.id.gumbUpdateProgramiranje);
        gumbDeleteProgramiranje = findViewById(R.id.gumbDeleteProgramiranje);

        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        String author = intent.getStringExtra("author");
        String pages = intent.getStringExtra("pages");

        editTextImeKnjigeProgramiranje.setText(name);
        editTextPisacProgramiranje.setText(author);
        editTextStraniceProgramiranje.setText(pages);

        gumbUpdateProgramiranje.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    String name = editTextImeKnjigeProgramiranje.getText().toString();
                    String author = editTextPisacProgramiranje.getText().toString();
                    String pages = editTextStraniceProgramiranje.getText().toString();
                    databaseHelper.updateBookProgramiranje(name,author,pages);
            }
        });

        gumbDeleteProgramiranje.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nameKnjige = editTextImeKnjigeProgramiranje.getText().toString();
                    databaseHelper = new ProgramiranjeDatabaseHelper(getApplicationContext());
                    databaseHelper.deleteItemProgramiranje(nameKnjige);

            }
        });
    }
}