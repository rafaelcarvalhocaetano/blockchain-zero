package io.mda.animation;

import android.support.transition.Scene;
import android.support.transition.Slide;
import android.support.transition.Transition;
import android.support.transition.TransitionInflater;
import android.support.transition.TransitionManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {


    private Button btn;
    private ImageView imageView;
    private Scene scene1;
    private Scene scene2;
    private Boolean start = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ViewGroup root = (ViewGroup) findViewById(R.id.root);


        scene1 = Scene.getSceneForLayout( root, R.layout.activity_main, this );
        scene2 = Scene.getSceneForLayout( root, R.layout.activity_main2, this );

        btn = (Button) findViewById(R.id.btn);
        imageView = (ImageView) findViewById(R.id.imagem);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                TransitionManager.beginDelayedTransition(root, new Slide());

                imageView.setVisibility( imageView.getVisibility() == View.INVISIBLE ? View.VISIBLE : View.INVISIBLE);
            }
        });
    }

    public void changeScene(View view){

        //chamando o layout transition, custom
        Transition transition = TransitionInflater.from( this ).inflateTransition(R.transition.custom);

        if( start ){
            TransitionManager.go( scene2, transition );
            start = false;
        }else{
            TransitionManager.go( scene1, transition );
            start = true;
        }
    }
}
