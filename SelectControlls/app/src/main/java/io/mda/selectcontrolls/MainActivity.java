package io.mda.selectcontrolls;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatCheckBox;
import android.support.v7.widget.SwitchCompat;
import android.widget.CompoundButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    private SwitchCompat switchCompat;
    private AppCompatCheckBox appCompatCheckBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        switchCompat = (SwitchCompat) findViewById(R.id.switchButton);
        switchCompat.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if(isChecked){
                    Toast.makeText(getApplicationContext(), "LIGADO", Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(getApplicationContext(), "DESLIGADO", Toast.LENGTH_LONG).show();
                }
            }
        });

        appCompatCheckBox = (AppCompatCheckBox) findViewById(R.id.switchButton);
        appCompatCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if(isChecked){
                    Toast.makeText(getApplicationContext(), "MARCADO", Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(getApplicationContext(), "DESMARCADO", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
