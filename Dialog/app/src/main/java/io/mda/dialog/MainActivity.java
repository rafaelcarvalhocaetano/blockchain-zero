package io.mda.dialog;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button btn, btnInfo;
    private AlertDialog alertDialog;
    private AlertDialog alertInfo;

    private String [] itens = {"Item 1", "Item 2", "Item 3", "Item 4"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = (Button) findViewById(R.id.btn_dialogo);
        btnInfo = (Button) findViewById(R.id.btn_info);


        AlertDialog.Builder adb = new AlertDialog.Builder(this, R.style.AlertDialog);
        final AlertDialog.Builder adbInfo = new AlertDialog.Builder(this);
        adb.setMessage("Deseja excluir");

        //add botão positivo
        adb.setPositiveButton("SIM", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "SIM", Toast.LENGTH_LONG).show();
            }
        });
        adb.setNegativeButton("NÃO", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "NÂO", Toast.LENGTH_LONG).show();
            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog.show();
            }
        });
        alertDialog = adb.create();

        //new button
        adbInfo.setTitle("Selecione a opção desejada");
        //adbInfo.setSingleChoiceItems( itens, -1, null );
        adbInfo.setMultiChoiceItems(itens, null, null);

        alertInfo = adbInfo.create();
        btnInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adbInfo.show();
            }
        });
        adbInfo.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int i) {
                Toast.makeText(MainActivity.this, itens[i], Toast.LENGTH_LONG).show();
            }
        });
        adbInfo.setNegativeButton("CANCELAR", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "Cancelando", Toast.LENGTH_LONG).show();
            }
        });


    }
}
