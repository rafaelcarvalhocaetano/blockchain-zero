package io.mda.recicleview;

import android.content.Intent;
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
    public void onBindViewHolder(final ViewRolder holder, int position) {

        final Article article = list.get( position );
        holder.title.setText( article.getTitle() );
        holder.desc.setText( article.getAuthor() );
        new DownloadImage( holder.fImageView ).execute( article.getEnclosure().getUrl() );
        holder.appCompatButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Integer(Intent.ACTION_VIEW, article.getSource());
                holder.itemView.getContext().startActivity( i );
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
