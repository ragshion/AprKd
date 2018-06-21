package online.aprkd_pekalongankab.aprkd.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import online.aprkd_pekalongankab.aprkd.R;

public class DetailImage extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_image);

        String thumbnail = getIntent().getStringExtra("foto");

        ImageView imageView = (ImageView) findViewById(R.id.photo_view);
        Glide.with(this).load(thumbnail)
                .thumbnail(Glide.with(this).load(R.drawable.def))
                .fitCenter()
                .crossFade()
                .into(imageView);

    }
}
