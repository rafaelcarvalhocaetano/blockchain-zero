package io.mda.recicleview;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pkmmte.pkrss.Article;

import java.util.List;

/**
 * Created by rafael on 31/12/17.
 */

public class RecycleAdapter extends RecyclerView.Adapter<ViewRolder>{

    private List<Article> list;

    public RecycleAdapter(List<Article> list){
        this.list = list;
    }

    @Override
    public ViewRolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);

        return new ViewRolder(  view );
    }

    @Override
    public void onBindViewHolder(ViewRolder holder, int position) {

        Article article = list.get( position );
        holder.title.setText( article.getTitle() );
        holder.desc.setText( article.getAuthor() );
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
