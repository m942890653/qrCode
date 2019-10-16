package com.example.zheng.qrcode;

import android.os.Bundle;
import android.view.SurfaceView;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;

import com.google.zxing.client.android.CaptureActivity;


/**
 * Created by zheng on 2019/10/16.
 */
public final class MyCaptureActivity extends CaptureActivity {
    private static final String TAG = "MyCaptureActivity";
    private ImageView scanLine;
    private TranslateAnimation animation;

    @Override
    protected SurfaceView getSurfaceView() {
        return (SurfaceView) findViewById(R.id.preview_view);
    }

    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.capture);
        animation = new TranslateAnimation(Animation.RELATIVE_TO_PARENT, 0.0f, Animation
                .RELATIVE_TO_PARENT, 0.0f, Animation.RELATIVE_TO_PARENT, 0.0f, Animation.RELATIVE_TO_PARENT,
                0.9f);
        animation.setDuration(3000);
        animation.setRepeatCount(-1);
        animation.setRepeatMode(Animation.RESTART);
        scanLine = (ImageView) findViewById(R.id.capture_scan_line);
        findViewById(R.id.capture_back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    protected void initCameraResult(boolean success) {
        handleScanLine(success);
    }

    private void handleScanLine(boolean show) {
        if (show) {
            scanLine.setVisibility(View.VISIBLE);
            scanLine.startAnimation(animation);
        } else {
            scanLine.clearAnimation();
            scanLine.setVisibility(View.GONE);
        }
    }

    @Override
    protected void onDestroy() {
        handleScanLine(false);
        super.onDestroy();
    }
}
