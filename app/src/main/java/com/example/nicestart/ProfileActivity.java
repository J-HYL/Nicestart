package com.example.nicestart;

import android.os.Bundle;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

public class ProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_profile);

        ImageView mSea = findViewById(R.id.backView);

        Glide.with(this)
                .load("https://img.freepik.com/foto-gratis/retrato-hombre-blanco-aislado_53876-40306.jpg?semt=ais_hybrid&w=740&q=80")
//                        .transition(DrawableTransitionOptions.withCrossFade(100))
                .circleCrop()
//                                        .diskCacheStrategy(DiskCacheStrategy.ALL)
//                .placeholder(new ColorDrawable(this.getResources().getColor(R.color.teal_200)))
                .into(mSea);

    }
}
