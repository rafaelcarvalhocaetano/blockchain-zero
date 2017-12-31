package io.mda.recicleview;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by rafael on 31/12/17.
 */

public class ViewRolder extends RecyclerView.ViewHolder {

    public ImageView fImageView;
    public TextView title;
    public TextView desc;
    public AppCompatButton appCompatButton;


    public ViewRolder(View view) {
        super(view);

        this.fImageView = (ImageView) view.findViewById(R.id.img_view1);
        this.title = (TextView) view.findViewById(R.id.title);
        this.desc = (TextView) view.findViewById(R.id.sub_title);
        this.appCompatButton = (AppCompatButton) view.findViewById(R.id.btn1);

    }
}
