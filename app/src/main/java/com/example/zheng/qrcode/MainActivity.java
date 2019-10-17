package com.example.zheng.qrcode;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.zxing.client.android.QRCodeUtil;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private static final int REQUEST_CODE = 100;
    private TextView mRvScanResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        View qRCodeBtn = findViewById(R.id.qr_code_bottom_btn);//扫描二维码按钮
        qRCodeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //调用第三方ZXing库的api进行扫描
                startActivityForResult(new Intent(MainActivity.this, MyCaptureActivity.class), REQUEST_CODE);
                mRvScanResult.setText("");
            }
        });
        mRvScanResult = findViewById(R.id.tv_scan_result);

        final EditText etCreateQRCode = findViewById(R.id.et_create_qrcode);
        View btCreateQRCode = findViewById(R.id.bt_create_qrcode);//生成二维码按钮
        final ImageView ivQrCode = findViewById(R.id.iv_qr_code);
        btCreateQRCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bitmap qrCodeBitmap = QRCodeUtil.createQRCodeBitmap(etCreateQRCode.getText().toString(), 800);
                if (qrCodeBitmap != null) {
                    ivQrCode.setImageBitmap(qrCodeBitmap);
                }
            }
        });
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == Activity.RESULT_OK && data != null) {
            String sResult = data.getStringExtra("result");//获取扫描后的结果数据
            Log.i(TAG, "onActivityResult: " + sResult);
            mRvScanResult.setText(sResult);
        }
    }
}
