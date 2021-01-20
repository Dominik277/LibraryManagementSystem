package hr.dominik.library.ModifyActivity;

import androidx.appcompat.app.AppCompatActivity;
import hr.dominik.library.DatabaseHelpers.OperativniSustaviDatabaseHelper;
import hr.dominik.library.R;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ModifyOperativniSustaviActivity extends AppCompatActivity {

    private EditText editTextImeKnjigeOperativniSustavi;
    private EditText editTextPisacOperativniSustavi;
    private EditText editTextStraniceOperativniSustavi;
    private Button gumbUpdateOperativniSustavi;
    private Button gumbDeleteOperativniSustavi;
    private long _id;

    private OperativniSustaviDatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modify_operativni_sustavi);

        editTextImeKnjigeOperativniSustavi = findViewById(R.id.modify_nameProgramiranje);
        editTextPisacOperativniSustavi = findViewById(R.id.modify_authorProgramiranje);
        editTextStraniceOperativniSustavi = findViewById(R.id.modify_pagesProgramiranje);

        gumbUpdateOperativniSustavi = findViewById(R.id.gumbUpdateProgramiranje);
        gumbDeleteOperativniSustavi = findViewById(R.id.gumbDeleteProgramiranje);

        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        String author = intent.getStringExtra("author");
        String pages = intent.getStringExtra("pages");

        editTextImeKnjigeOperativniSustavi.setText(name);
        editTextPisacOperativniSustavi.setText(author);
        editTextStraniceOperativniSustavi.setText(pages);

        gumbUpdateOperativniSustavi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = editTextImeKnjigeOperativniSustavi.getText().toString();
                String author = editTextPisacOperativniSustavi.getText().toString();
                String pages = editTextStraniceOperativniSustavi.getText().toString();
                databaseHelper.updateBookOperativniSustavi(name,author,pages);
            }
        });

        gumbDeleteOperativniSustavi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nameKnjige = editTextImeKnjigeOperativniSustavi.getText().toString();
                databaseHelper.deleteRowOperativniSustavi(nameKnjige);
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