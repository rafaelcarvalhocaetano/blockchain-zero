package io.mda.snackbar;

import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

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

                View snackView = snackbar.getView();
                snackView.setBackground(getResources().getColor(R.color.colorPrimaryDark, null));

                TextView scaneText = snackView.findViewById(android.support.design.R.id.snackbar_action);
                scaneText.setTextColor(getResources().getColor(android.R.color.white, null));


                snackbar.show();
            }
        });
    }
}
