package io.mda.progressbar;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {

    private ProgressBar progressBar;
    private ProgressBar linearBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressBar = (ProgressBar) findViewById(R.id.circular_bar);
        linearBar = (ProgressBar) findViewById(R.id.linear_bar);
        progressBar.setVisibility(View.GONE);

        //setando o valor no linear progress bar de 40
        int init = 0;
        int max = 100;
        linearBar.setProgress( init );
        linearBar.setSecondaryProgress( init );
        linearBar.setMax( max );

        new AsyncCircular().execute();

    }

    public class AsyncCircular extends AsyncTask<Void, Integer, Void>{

        @Override
        protected Void doInBackground(Void... voids) {

            for (int i=0; i<=100; i++){
                try {
                    //chamando o método onProgressUpdate
                    publishProgress( i );

                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }

        @Override
        protected void onPreExecute() {
            progressBar.setVisibility(View.VISIBLE);
        }

        @Override
        protected void onPostExecute(Void aVoid) {
           progressBar.setVisibility(View.GONE);
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            linearBar.setProgress( values[0] );
            linearBar.setProgress( values[0] + 15 );
        }
    }
}
