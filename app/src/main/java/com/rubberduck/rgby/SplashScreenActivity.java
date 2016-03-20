package com.rubberduck.rgby;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class SplashScreenActivity extends AppCompatActivity implements ISplashScreenView {

    private SplashScreenPresenter splashScreenPresenter;

    @Bind(R.id.button_start)
    Button startButton;

    @Bind(R.id.progress_bar)
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        ButterKnife.bind(this);

        splashScreenPresenter = new SplashScreenPresenter(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        splashScreenPresenter.onScreenOpened();
    }

    @OnClick(R.id.button_start)
    public void onStartButtonClicked() {
        splashScreenPresenter.onStartButtonClicked();
    }

    @Override
    public void showProgressBar() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgressBar() {
        progressBar.setVisibility(View.INVISIBLE);
    }

    @Override
    public void showStartGameButton() {
        startButton.setVisibility(View.VISIBLE);
    }

    @Override
    public void openGamePlayActivity() {
        Toast.makeText(this, "Hello!", Toast.LENGTH_SHORT).show();
    }
}
