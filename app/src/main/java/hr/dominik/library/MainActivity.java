package hr.dominik.library;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Menu;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import hr.dominik.library.draweraktivnosti.FABActivity;
import hr.dominik.library.draweraktivnosti.HardverActivity;
import hr.dominik.library.draweraktivnosti.MrezeIProtokoliActivity;
import hr.dominik.library.draweraktivnosti.OperativniSustaviActivity;
import hr.dominik.library.draweraktivnosti.ProgramiranjeActivity;

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
                openNewActivity(fab);
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
        return false;
    }

    private void openNewActivity(View view){
        Intent intent = new Intent(MainActivity.this, FABActivity.class);
        startActivity(intent);
    }

}