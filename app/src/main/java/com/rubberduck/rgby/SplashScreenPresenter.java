package com.rubberduck.rgby;

import android.os.Handler;

/**
 * Created by akshay on 3/20/16.
 */
public class SplashScreenPresenter implements ISplashScreenPresenter {

    private ISplashScreenView splashScreenView;

    public SplashScreenPresenter(ISplashScreenView splashScreenView) {
        this.splashScreenView = splashScreenView;

    }

    @Override
    public void onStart() {
        splashScreenView.showProgressBar();
        startCounter();
    }

    @Override
    public void onStartButtonClicked() {
        splashScreenView.openGamePlayActivity();
    }

    private void startCounter() {
        Handler handler = new Handler();

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                splashScreenView.hideProgressBar();
                splashScreenView.showStartGameButton();
            }
        };

        handler.postDelayed(runnable, 5000);
    }

}
