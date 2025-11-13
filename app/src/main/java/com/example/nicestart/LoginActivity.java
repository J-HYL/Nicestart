package com.example.nicestart;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.bumptech.glide.Glide;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);


        ImageView mSea = findViewById(R.id.backView);

        Glide.with(this)
                .load("https://images.pexels.com/photos/3538721/pexels-photo-3538721.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1")
//                        .transition(DrawableTransitionOptions.withCrossFade(100))
                .centerCrop()
//                                        .diskCacheStrategy(DiskCacheStrategy.ALL)
//                .placeholder(new ColorDrawable(this.getResources().getColor(R.color.teal_200)))
                .into(mSea);

    }
    public void openMain(View view){
        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }
    public void openSignUp(View view){
        Intent intent = new Intent(LoginActivity.this, SignupActivity.class);

        startActivity(intent);
    }

}