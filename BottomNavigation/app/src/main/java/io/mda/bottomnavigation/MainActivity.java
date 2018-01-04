package io.mda.bottomnavigation;

import android.support.annotation.NonNull;

import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener{

    private BottomNavigationView btn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = (BottomNavigationView) findViewById(R.id.btn_navi);
        btn.setOnNavigationItemSelectedListener( this );


    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch ( item.getItemId() ){
            case R.id.menu_fav:
                Toast.makeText(MainActivity.this, "FAVORITOS", Toast.LENGTH_SHORT).show();
                break;
            case R.id.menu_info:
                Toast.makeText(MainActivity.this, "INFORMAÇÃO", Toast.LENGTH_SHORT).show();
                break;
            case R.id.menu_loc:
                Toast.makeText(MainActivity.this, "LOCALIZAÇÃO", Toast.LENGTH_SHORT).show();
                break;
        }
        return true;
    }
}
