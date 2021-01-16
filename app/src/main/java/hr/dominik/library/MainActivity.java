package hr.dominik.library;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Menu;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import hr.dominik.library.draweraktivnosti.AnalitickaKemijaActivity;
import hr.dominik.library.draweraktivnosti.AnatomijaActivity;
import hr.dominik.library.draweraktivnosti.BioKemijaActivity;
import hr.dominik.library.draweraktivnosti.ElektronikaActivity;
import hr.dominik.library.draweraktivnosti.ElektrotehnikaActivity;
import hr.dominik.library.draweraktivnosti.EnergetikaActivity;
import hr.dominik.library.draweraktivnosti.FizikalnaKemijaActivity;
import hr.dominik.library.draweraktivnosti.HardverActivity;
import hr.dominik.library.draweraktivnosti.MrezeIProtokoliActivity;
import hr.dominik.library.draweraktivnosti.OperativniSustaviActivity;
import hr.dominik.library.draweraktivnosti.OrganskaKemijaActivity;
import hr.dominik.library.draweraktivnosti.PovijestMedicineActivity;
import hr.dominik.library.draweraktivnosti.ProgramiranjeActivity;
import hr.dominik.library.draweraktivnosti.RobotikaActivity;
import hr.dominik.library.draweraktivnosti.SportskaMedicinaActivity;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private AppBarConfiguration mAppBarConfiguration;
    DrawerLayout drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


        drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.




        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle
                (this,drawer,toolbar,R.string.navigation_drawer_open,
                        R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        navigationView.bringToFront();
        drawer.requestLayout();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.programiranje){
            startActivity(new Intent(MainActivity.this, ProgramiranjeActivity.class));
        }
        if (id == R.id.hardver){
            startActivity(new Intent(MainActivity.this, HardverActivity.class));
        }
        if (id == R.id.mreze_i_protokoli){
            startActivity(new Intent(MainActivity.this, MrezeIProtokoliActivity.class));
        }
        if (id == R.id.operativni_sustavi){
            startActivity(new Intent(MainActivity.this, OperativniSustaviActivity.class));
        }
        if (id == R.id.elektronika){
            startActivity(new Intent(MainActivity.this, ElektronikaActivity.class));
        }
        if (id == R.id.energetika){
            startActivity(new Intent(MainActivity.this, EnergetikaActivity.class));
        }
        if (id == R.id.elektrotehnika){
            startActivity(new Intent(MainActivity.this, ElektrotehnikaActivity.class));
        }
        if (id == R.id.robotika){
            startActivity(new Intent(MainActivity.this, RobotikaActivity.class));
        }
        if (id == R.id.organska_kemija){
            startActivity(new Intent(MainActivity.this, OrganskaKemijaActivity.class));
        }
        if (id == R.id.fizikalna_kemija){
            startActivity(new Intent(MainActivity.this, FizikalnaKemijaActivity.class));
        }
        if (id == R.id.analiticka_kemija){
            startActivity(new Intent(MainActivity.this, AnalitickaKemijaActivity.class));
        }
        if (id == R.id.biokemija){
            startActivity(new Intent(MainActivity.this, BioKemijaActivity.class));
        }
        if (id == R.id.sportska_medicina){
            startActivity(new Intent(MainActivity.this, SportskaMedicinaActivity.class));
        }
        if (id == R.id.povijest_medicine){
            startActivity(new Intent(MainActivity.this, PovijestMedicineActivity.class));
        }
        return false;
    }
}