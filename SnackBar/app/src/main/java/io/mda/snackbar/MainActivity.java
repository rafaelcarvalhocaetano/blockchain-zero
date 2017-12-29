package io.mda.snackbar;

import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private FloatingActionButton btnF;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnF = (FloatingActionButton) findViewById(R.id.fab);
        final View relative = findViewById(R.id.relative);

        btnF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Snackbar snackbar = Snackbar.make( v, "ITEM EXCLUÍDO", Snackbar.LENGTH_LONG);
                //atribuindo uma ação ao botão
                snackbar.setAction("FECHAR", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        //fechando a snackbar
                        snackbar.dismiss();
                    }
                });
                snackbar.show();
            }
        });
    }
}
