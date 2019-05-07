package com.lappungdev.cosplayerwiki.activity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.lappungdev.cosplayerwiki.R;

import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CosplayDetailActivity extends AppCompatActivity {

    @BindView(R.id.ivCosplayPhoto)
    ImageView ivCosplayPhoto;
    @BindView(R.id.tvCosplayNickname)
    TextView tvCosplayNickname;
    @BindView(R.id.tvCosplayGender)
    TextView tvCosplayGender;
    @BindView(R.id.tvCosplayCountry)
    TextView tvCosplayCountry;
    @BindView(R.id.tvCosplayID)
    TextView tvCosplayID;
    @BindView(R.id.tvCosplayBirthday)
    TextView tvCosplayBirthday;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cosplay_detail);
        ButterKnife.bind(this);

        Intent i = getIntent();
        Bundle bd = i.getExtras();
        if (bd != null) {
            tvCosplayNickname.setText(Objects.requireNonNull(bd.get("cosplayNickname")).toString());
            tvCosplayGender.setText(Objects.requireNonNull(bd.get("cosplayGender")).toString());
            tvCosplayCountry.setText(Objects.requireNonNull(bd.get("cosplayCountry")).toString());
            tvCosplayID.setText(Objects.requireNonNull(bd.get("cosplayID")).toString());
            tvCosplayBirthday.setText(Objects.requireNonNull(bd.get("cosplayBirthday")).toString());
            Glide.with(this).load(Objects.requireNonNull(bd.get("cosplayPhoto")).toString())
                    .listener(new RequestListener<Drawable>() {
                        @Override
                        public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {
                            return false;
                        }

                        @Override
                        public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {
                            return false;
                        }
                    })
                    .into(ivCosplayPhoto);
            bd.remove("cosplayNickname");
            bd.remove("cosplayGender");
            bd.remove("cosplayCountry");
            bd.remove("cosplayPhoto");
            bd.remove("cosplayID");
            bd.remove("cosplayBirthday");
        }

    }

    public void finishActivity(View view) {
        finish();
    }
}
