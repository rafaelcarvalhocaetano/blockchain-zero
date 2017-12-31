package io.mda.recicleview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.pkmmte.pkrss.Article;
import com.pkmmte.pkrss.Callback;
import com.pkmmte.pkrss.PkRSS;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements Callback {


    private RecyclerView recyclerView;
    private RecycleAdapter recycleAdapter;
    private List<Article> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.recycleview);
       recyclerView.setLayoutManager( new LinearLayoutManager(this));

       recycleAdapter = new RecycleAdapter(list);
       recyclerView.setAdapter( recycleAdapter );

        PkRSS.with(this).load("http://www.androidpro.com.br/feed/").skipCache().callback(this).async();
    }

    @Override
    public void onPreload() {

    }

    @Override
    public void onLoaded(List<Article> newArticles) {
        list.clear();
        list.addAll( newArticles );
        recycleAdapter.notifyDataSetChanged();

    }

    @Override
    public void onLoadFailed() {

    }
}
