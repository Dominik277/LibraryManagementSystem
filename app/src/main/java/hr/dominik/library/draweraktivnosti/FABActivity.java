package hr.dominik.library.draweraktivnosti;

import androidx.appcompat.app.AppCompatActivity;
import hr.dominik.library.R;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class FABActivity extends AppCompatActivity {

    Button gumbPosaljiUpit;
    EditText editTextIme;
    EditText editTextPrezime;
    EditText editTextEmail;
    EditText editTextUpit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_f_a_b);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        gumbPosaljiUpit = findViewById(R.id.gumbPosaljiUpit);
        editTextIme = findViewById(R.id.editTextIme);
        editTextPrezime = findViewById(R.id.editTextPrezime);
        editTextEmail = findViewById(R.id.editTextEmail);
        editTextUpit = findViewById(R.id.editTextUpit);

        gumbPosaljiUpit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ime = editTextIme.getText().toString();
                String prezime = editTextPrezime.getText().toString();
                String email = editTextEmail.getText().toString();
                Toast.makeText(FABActivity.this,ime + " " + prezime + " " +
                        "vaš upit je zaprimljen i bit će ubrzo odgovoren na " + email,Toast.LENGTH_LONG).show();
            }
        });

    }
}