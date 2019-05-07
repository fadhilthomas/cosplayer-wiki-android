package com.lappungdev.cosplayerwiki.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.transition.TransitionManager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.lappungdev.cosplayerwiki.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SplashActivity extends AppCompatActivity {

    @BindView(R.id.tvSubJudul)
    TextView tvTitle;
    @BindView(R.id.transContainer)
    ViewGroup transContainer;
    private boolean visibleTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        ButterKnife.bind(this);

        new Handler().postDelayed(() -> {
            TransitionManager.beginDelayedTransition(transContainer);
            visibleTitle = !visibleTitle;
            tvTitle.setVisibility(visibleTitle ? View.VISIBLE : View.GONE);
        }, 1000);

        new Handler().postDelayed(() -> {
            startActivity(new Intent(SplashActivity.this, MainActivity.class));
            finish();
        }, 3000);

    }
}
