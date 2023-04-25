package com.capco.oldschooljava;

import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.capco.oldschooljava.databinding.ActivityMainBinding;

import android.view.Menu;
import android.view.MenuItem;

import java.util.Objects;

class Base {
    Integer x;

    void aMethod(int x, int y) {}
    void aMethod(int x) { aMethod(x,33); }


    Base() { this(0); }
    Base(Integer x) {
        this.x = x;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Base)) return false;
        Base base = (Base) o;
        return Objects.equals(x, base.x);
    }

    @Override
    public int hashCode() {
        return Objects.hash(x);
    }
}

// if (base1 == base2) { ... }
// if (base1.equals(base2)) { ... }

class Derive extends Base {
    Integer y;
    Derive(Integer x, Integer y) {
        super(x); // this = new Base(x);
        this.y = y;
    }

    void method() {
        Integer z = 33;
        // var z = 33;

         z=18;

         final Integer c= 82;
         // int const * c = new int(82);


         // val z = 82;



    }
}
class WeatherAPI {};

public class MainActivity extends AppCompatActivity {

    private WeatherAPI weatherAPI = null;
    private Object weatherAPILock = new Object();
    public  WeatherAPI getWeatherAPI() {
        if (weatherAPI == null) {
            synchronized (weatherAPILock) {
                if (weatherAPI == null) {
                    weatherAPI = new WeatherAPI();
                }
            }
        }
        return weatherAPI;
    }

    MainActivity() {
        super();
    }
    private AppBarConfiguration appBarConfiguration;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.toolbar);

        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph()).build();
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);

        binding.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, appBarConfiguration)
                || super.onSupportNavigateUp();
    }
}