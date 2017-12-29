package io.mda.navigationdrawer;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    private Toolbar toolbar;
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        drawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar( toolbar );


        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open_drawer, R.string.close_drawer);
        drawerLayout.addDrawerListener( toggle );

        toggle.syncState();

        //colocando click no menu do drawer
        navigationView = (NavigationView) findViewById(R.id.navigationView);
        navigationView.setNavigationItemSelectedListener( this );


    }

    @Override
    public void onBackPressed() {
        if(drawerLayout.isDrawerOpen( GravityCompat.START ) ){
            drawerLayout.closeDrawer( GravityCompat.START );
        }else {
            super.onBackPressed();
        }

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch ( item.getItemId() ){
            case R.id.menu_inbox:
                Toast.makeText(this, "INBOX", Toast.LENGTH_LONG).show();
                break;
            case R.id.menu_favoritos:
                Toast.makeText(this, "FAVORITOS", Toast.LENGTH_LONG).show();
                break;
            case R.id.menu_enviados:
                Toast.makeText(this, "EMAILS", Toast.LENGTH_LONG).show();
                break;
            case R.id.menu_lixeira:
                Toast.makeText(this, "LIXEIRA", Toast.LENGTH_LONG).show();
                break;
            case R.id.menu_span:
                Toast.makeText(this, "SPAN", Toast.LENGTH_LONG).show();
                break;
        }
        drawerLayout.closeDrawer( GravityCompat.START );
        return false;
    }
}
