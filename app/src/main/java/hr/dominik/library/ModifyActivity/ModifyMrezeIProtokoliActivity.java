package hr.dominik.library.ModifyActivity;

import androidx.appcompat.app.AppCompatActivity;
import hr.dominik.library.DatabaseHelpers.HardverDatabaseHelper;
import hr.dominik.library.DatabaseHelpers.MrezeIProtokoliDatabaseHelper;
import hr.dominik.library.R;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ModifyMrezeIProtokoliActivity extends AppCompatActivity {

    private EditText editTextImeKnjigeMrezeIProtokoli;
    private EditText editTextPisacMrezeIProtokoli;
    private EditText editTextStraniceMrezeIProtokoli;
    private Button gumbUpdateMrezeIProtokoli;
    private Button gumbDeleteMrezeIProtokoli;
    private long _id;

    private MrezeIProtokoliDatabaseHelper databaseHelper;
    SQLiteDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modify_mreze_i_protokoli);

        editTextImeKnjigeMrezeIProtokoli = findViewById(R.id.modify_nameProgramiranje);
        editTextPisacMrezeIProtokoli = findViewById(R.id.modify_authorProgramiranje);
        editTextStraniceMrezeIProtokoli = findViewById(R.id.modify_pagesProgramiranje);

        gumbUpdateMrezeIProtokoli = findViewById(R.id.gumbUpdateProgramiranje);
        gumbDeleteMrezeIProtokoli = findViewById(R.id.gumbDeleteProgramiranje);

        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        String author = intent.getStringExtra("author");
        String pages = intent.getStringExtra("pages");

        editTextImeKnjigeMrezeIProtokoli.setText(name);
        editTextPisacMrezeIProtokoli.setText(author);
        editTextStraniceMrezeIProtokoli.setText(pages);

        gumbUpdateMrezeIProtokoli.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = editTextImeKnjigeMrezeIProtokoli.getText().toString();
                String author = editTextPisacMrezeIProtokoli.getText().toString();
                String pages = editTextStraniceMrezeIProtokoli.getText().toString();
                databaseHelper.updateBookMrezeIProtokoli(name,author,pages);
            }
        });

        gumbDeleteMrezeIProtokoli.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nameKnjige = editTextImeKnjigeMrezeIProtokoli.getText().toString();
                databaseHelper = new MrezeIProtokoliDatabaseHelper(getApplicationContext());
                databaseHelper.deleteItemMrezeIProtokoli(nameKnjige);
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