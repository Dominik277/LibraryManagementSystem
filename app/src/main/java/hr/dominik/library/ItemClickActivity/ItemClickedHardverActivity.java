package hr.dominik.library.ItemClickActivity;

import androidx.appcompat.app.AppCompatActivity;
import hr.dominik.library.HardverMenuActivity.PosudeneKnjigeHardverActivity;
import hr.dominik.library.R;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ItemClickedHardverActivity extends AppCompatActivity {

    TextView hardverKnjiga;
    TextView hardverPisac;
    EditText editTextPosudbaImeHardver;
    EditText editTextPosudbaPrezimeHardver;
    EditText editTextPosudbaEmailHardver;
    Button gumbPosudi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_clicked_hardver);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        hardverKnjiga = findViewById(R.id.hardverKnjiga);
        hardverPisac = findViewById(R.id.hardverPisac);
        editTextPosudbaImeHardver = findViewById(R.id.editTextPosudbaImeHardver);
        editTextPosudbaPrezimeHardver = findViewById(R.id.editTextPosudbaPrezimeHardver);
        editTextPosudbaEmailHardver = findViewById(R.id.editTextPosudbaEmailHardver);
        gumbPosudi = findViewById(R.id.gumbPosudi);

        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        String author = intent.getStringExtra("author");
        String pages = intent.getStringExtra("pages");

        setTitle("Informacije o " + name);

        hardverKnjiga.setText(name);
        hardverPisac.setText(author);

        gumbPosudi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String editTextIme = editTextPosudbaImeHardver.getText().toString();
                String editTextPrezime = editTextPosudbaPrezimeHardver.getText().toString();
                String editTextEmail = editTextPosudbaEmailHardver.getText().toString();
                Toast.makeText(ItemClickedHardverActivity.this,editTextIme + editTextPrezime
                        + ". Zahvaljujemo se na posudbi.Detaljne podatke smo vam poslali na email "
                        + editTextEmail + ". Srdačan Pozdrav!",Toast.LENGTH_LONG).show();
                Intent intent = new Intent(ItemClickedHardverActivity.this,PosudeneKnjigeHardverActivity.class);
                intent.putExtra("name",name);
                intent.putExtra("author",author);
                startActivity(intent);
            }
        });

    }
}