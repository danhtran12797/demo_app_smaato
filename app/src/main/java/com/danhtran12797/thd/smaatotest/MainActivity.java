package com.danhtran12797.thd.smaatotest;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

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
                Toast.makeText(MainActivity.this, "Banner load success, can show ad", Toast.LENGTH_LONG).show();
                Log.d("AAA", "Banner load success, can show ad");
            }

            @Override
            public void onAdFailedToLoad(@NonNull BannerView bannerView, @NonNull BannerError bannerError) {
                Toast.makeText(MainActivity.this, "Bannner load failed", Toast.LENGTH_LONG).show();
                Log.d("AAA", "Bannner load failed");
            }

            @Override
            public void onAdImpression(@NonNull BannerView bannerView) {
                Log.d("AAA", "Banner onAdImpression");
            }

            @Override
            public void onAdClicked(@NonNull BannerView bannerView) {
                Toast.makeText(MainActivity.this, "Banner clicked", Toast.LENGTH_LONG).show();
                Log.d("AAA", "Banner clicked");
            }

            @Override
            public void onAdTTLExpired(@NonNull BannerView bannerView) {
                Log.d("AAA", "Banner onAdTTLExpired");
            }
        });


        eventListenerRewarded = new com.smaato.sdk.rewarded.EventListener() {
            @Override
            public void onAdLoaded(@NonNull RewardedInterstitialAd rewardedInterstitialAd) {
                Toast.makeText(MainActivity.this, "RewardedAd load success, can show ad", Toast.LENGTH_LONG).show();
                Log.d("AAA", "RewardedAd: load success");
                rewardedInterstitialAd.showAd();
            }

            @Override
            public void onAdFailedToLoad(@NonNull RewardedRequestError rewardedRequestError) {
                Log.d("AAA", "RewardedAd load failed");
                Toast.makeText(MainActivity.this, "RewardedAd load failed", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onAdError(@NonNull RewardedInterstitialAd rewardedInterstitialAd, @NonNull RewardedError rewardedError) {
                Toast.makeText(MainActivity.this, "RewardedAd error", Toast.LENGTH_LONG).show();
                Log.d("AAA", "RewardedAd error");
            }

            @Override
            public void onAdClosed(@NonNull RewardedInterstitialAd rewardedInterstitialAd) {
                Toast.makeText(MainActivity.this, "RewardedAd closed", Toast.LENGTH_LONG).show();
                Log.d("AAA", "RewardedAd closed");
            }

            @Override
            public void onAdClicked(@NonNull RewardedInterstitialAd rewardedInterstitialAd) {
                Toast.makeText(MainActivity.this, "RewardedAd clicked", Toast.LENGTH_LONG).show();
                Log.d("AAA", "RewardedAd clicked");
            }

            @Override
            public void onAdStarted(@NonNull RewardedInterstitialAd rewardedInterstitialAd) {
                Log.d("AAA", "RewardedAd: started");
            }

            @Override
            public void onAdReward(@NonNull RewardedInterstitialAd rewardedInterstitialAd) {
                Log.d("AAA", "RewardedAd: onAdReward");
            }

            @Override
            public void onAdTTLExpired(@NonNull RewardedInterstitialAd rewardedInterstitialAd) {
                Log.d("AAA", "RewardedAd: onAdTTLExpired");
            }

        };

        eventListenerInterstitial = new EventListener() {
            @Override
            public void onAdLoaded(@NonNull InterstitialAd interstitialAd) {
                Toast.makeText(MainActivity.this, "InterstitialAd load success, can show ad.", Toast.LENGTH_LONG).show();
                Log.d("AAA", "InterstitialAd: load success");
                interstitialAd.showAd(MainActivity.this);
            }

            @Override
            public void onAdFailedToLoad(@NonNull InterstitialRequestError interstitialRequestError) {
                Toast.makeText(MainActivity.this, "InterstitialAd load failed", Toast.LENGTH_LONG).show();
                Log.d("AAA", "InterstitialAd: load failed");
            }

            @Override
            public void onAdError(@NonNull InterstitialAd interstitialAd, @NonNull InterstitialError interstitialError) {
                Toast.makeText(MainActivity.this, "InterstitialAd error", Toast.LENGTH_LONG).show();
                Log.d("AAA", "InterstitialAd: error");
            }

            @Override
            public void onAdOpened(@NonNull InterstitialAd interstitialAd) {
                Toast.makeText(MainActivity.this, "InterstitialAd opened", Toast.LENGTH_LONG).show();
                Log.d("AAA", "InterstitialAd: opened");
            }

            @Override
            public void onAdClosed(@NonNull InterstitialAd interstitialAd) {
                Toast.makeText(MainActivity.this, "InterstitialAd closed", Toast.LENGTH_LONG).show();
                Log.d("AAA", "InterstitialAd: closed");
            }

            @Override
            public void onAdClicked(@NonNull InterstitialAd interstitialAd) {
                Toast.makeText(MainActivity.this, "InterstitialAd clicked", Toast.LENGTH_LONG).show();
                Log.d("AAA", "InterstitialAd: clicked");

            }

            @Override
            public void onAdImpression(@NonNull InterstitialAd interstitialAd) {
                Log.d("AAA", "InterstitialAd: onAdImpression");
            }

            @Override
            public void onAdTTLExpired(@NonNull InterstitialAd interstitialAd) {
                Log.d("AAA", "InterstitialAd: onAdTTLExpired");
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
