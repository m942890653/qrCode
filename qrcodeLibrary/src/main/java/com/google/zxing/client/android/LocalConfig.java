package com.google.zxing.client.android;

/**
 * Created by zheng on 2019/10/15.
 */
public final class LocalConfig {

    public static final boolean DECODE_1D_PRODUCT = true;
    public static final boolean DECODE_1D_INDUSTRIAL = true;
    public static final boolean DECODE_QR = true;
    public static final boolean DECODE_DATA_MATRIX = true;
    public static final boolean DECODE_AZTEC = false;
    public static final boolean DECODE_PDF417 = false;

    public static final boolean PLAY_BEEP = true;//提示音
    public static final boolean VIBRATE = true;//震动
    public static final String FRONT_LIGHT_MODE = "OFF";//闪光灯
    public static final boolean BULK_MODE = false;//批量扫描模式
    public static final boolean AUTO_FOCUS = true;//自动对焦
    public static final boolean INVERT_SCAN = false;//反色

    public static final boolean DISABLE_CONTINUOUS_FOCUS = true;//不持续对焦
    public static final boolean DISABLE_EXPOSURE = true;//不曝光
    public static final boolean DISABLE_METERING = true;//不使用距离测量
    public static final boolean DISABLE_BARCODE_SCENE_MODE = true;//不进行条形码场景匹配

}
