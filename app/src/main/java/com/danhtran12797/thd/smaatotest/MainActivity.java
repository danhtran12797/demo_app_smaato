package com.danhtran12797.thd.smaatotest;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.smaato.sdk.banner.ad.BannerAdSize;
import com.smaato.sdk.banner.widget.BannerError;
import com.smaato.sdk.banner.widget.BannerView;
import com.smaato.sdk.interstitial.EventListener;
import com.smaato.sdk.interstitial.Interstitial;
import com.smaato.sdk.interstitial.InterstitialAd;
import com.smaato.sdk.interstitial.InterstitialError;
import com.smaato.sdk.interstitial.InterstitialRequestError;
import com.smaato.sdk.rewarded.RewardedError;
import com.smaato.sdk.rewarded.RewardedInterstitial;
import com.smaato.sdk.rewarded.RewardedInterstitialAd;
import com.smaato.sdk.rewarded.RewardedRequestError;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnInterstitial, btnRewarded;

    EventListener eventListenerInterstitial;
    com.smaato.sdk.rewarded.EventListener eventListenerRewarded;
    BannerView bannerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnRewarded = findViewById(R.id.btnRewarded);
        btnInterstitial = findViewById(R.id.btnInterstitial);

        bannerView = findViewById(R.id.bannerView);
        bannerView.loadAd(getResources().getString(R.string.adspace_id_banner), BannerAdSize.XX_LARGE_320x50);

        bannerView.setEventListener(new BannerView.EventListener() {
            @Override
            public void onAdLoaded(@NonNull BannerView bannerView) {
            }

            @Override
            public void onAdFailedToLoad(@NonNull BannerView bannerView, @NonNull BannerError bannerError) {
            }

            @Override
            public void onAdImpression(@NonNull BannerView bannerView) {
            }

            @Override
            public void onAdClicked(@NonNull BannerView bannerView) {
            }

            @Override
            public void onAdTTLExpired(@NonNull BannerView bannerView) {
            }
        });


        eventListenerRewarded = new com.smaato.sdk.rewarded.EventListener() {
            @Override
            public void onAdLoaded(@NonNull RewardedInterstitialAd rewardedInterstitialAd) {
                rewardedInterstitialAd.showAd();
            }

            @Override
            public void onAdFailedToLoad(@NonNull RewardedRequestError rewardedRequestError) {

            }

            @Override
            public void onAdError(@NonNull RewardedInterstitialAd rewardedInterstitialAd, @NonNull RewardedError rewardedError) {

            }

            @Override
            public void onAdClosed(@NonNull RewardedInterstitialAd rewardedInterstitialAd) {

            }

            @Override
            public void onAdClicked(@NonNull RewardedInterstitialAd rewardedInterstitialAd) {

            }

            @Override
            public void onAdStarted(@NonNull RewardedInterstitialAd rewardedInterstitialAd) {

            }

            @Override
            public void onAdReward(@NonNull RewardedInterstitialAd rewardedInterstitialAd) {

            }

            @Override
            public void onAdTTLExpired(@NonNull RewardedInterstitialAd rewardedInterstitialAd) {

            }
        };

        eventListenerInterstitial = new EventListener() {
            @Override
            public void onAdLoaded(@NonNull InterstitialAd interstitialAd) {
                interstitialAd.showAd(MainActivity.this);
            }

            @Override
            public void onAdFailedToLoad(@NonNull InterstitialRequestError interstitialRequestError) {

            }

            @Override
            public void onAdError(@NonNull InterstitialAd interstitialAd, @NonNull InterstitialError interstitialError) {

            }

            @Override
            public void onAdOpened(@NonNull InterstitialAd interstitialAd) {

            }

            @Override
            public void onAdClosed(@NonNull InterstitialAd interstitialAd) {

            }

            @Override
            public void onAdClicked(@NonNull InterstitialAd interstitialAd) {

            }

            @Override
            public void onAdImpression(@NonNull InterstitialAd interstitialAd) {

            }

            @Override
            public void onAdTTLExpired(@NonNull InterstitialAd interstitialAd) {

            }
        };

        btnInterstitial.setOnClickListener(this);
        btnRewarded.setOnClickListener(this);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        bannerView.destroy();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnInterstitial:
                Interstitial.loadAd(getResources().getString(R.string.adspace_id_nterstitial), eventListenerInterstitial);
                break;
            case R.id.btnRewarded:
                RewardedInterstitial.loadAd(getResources().getString(R.string.adspace_id_rewarded), eventListenerRewarded);
                break;
        }
    }
}
