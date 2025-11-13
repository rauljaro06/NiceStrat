package com.example.nicestrat;

import android.os.Bundle;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.bumptech.glide.Glide;

public class Profile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_profile);

        ImageView mSea = findViewById(R.id.imagenProfile);

        Glide.with(this).load("https://i.pinimg.com/736x/a0/65/07/a0650730e514f6214100a21e32572c88.jpg")
                //.transition(DrawableTransitionOptions.withCrossFade())
               // .centerCrop()
                //.diskCacheStrategy(DiskCacheStrategy.ALL)
                //.placeholder(new ColorDrawable(this.getResources().getColor()))
                .circleCrop()
                .into(mSea);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}