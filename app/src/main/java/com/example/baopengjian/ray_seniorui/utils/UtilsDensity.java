package com.example.baopengjian.ray_seniorui.utils;

import android.content.Context;
import android.content.res.Resources;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.util.TypedValue;

import java.math.BigDecimal;

/**
 * 获取和手机密度相关的数据：屏幕宽高、单位转换
 */
public class UtilsDensity {

    /**
     * 得到设备的密度
     */
    public static float getScreenDensity() {
        return Resources.getSystem().getDisplayMetrics().density;
    }

    /**
     * 得到设备屏幕的高度
     */
    public static int getScreenHeight() {
        return Resources.getSystem().getDisplayMetrics().heightPixels;
    }


    /**
     * 得到设备屏幕的宽度
     */
    public static int getScreenWidth() {
        return Resources.getSystem().getDisplayMetrics().widthPixels;
    }


    /**
     * sp转px
     *
     * @param spValue
     * @return
     */
    public static int sp2px(float spValue) {
        float fontScale = Resources.getSystem().getDisplayMetrics().scaledDensity;
        return (int) (spValue * fontScale + 0.5f);
    }

    /**
     * px转sp
     *
     * @param pxValue
     * @return
     */
    public static int px2sp(float pxValue) {
        float fontScale = Resources.getSystem().getDisplayMetrics().scaledDensity;
        return (int) (pxValue / fontScale + 0.5f);
    }

    /**
     * dip转px
     *
     * @param dipValue
     * @return
     */
    public static int dip2px(float dipValue) {
        final float scale = Resources.getSystem().getDisplayMetrics().density;
        return (int) (dipValue * scale + 0.5f);
    }

    /**
     * px转dip
     *
     * @param pxValue
     * @return
     */
    public static int px2dip(float pxValue) {
        final float scale = Resources.getSystem().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);

    }

    public static int dp2px(float dpVal) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dpVal, Resources.getSystem().getDisplayMetrics());
    }


/*** ================================过时的方法，不建议使用==========================================================*/

    @Deprecated
    public static int doubleCompare(double d1, double d2) {
        BigDecimal data1 = new BigDecimal(d1);
        BigDecimal data2 = new BigDecimal(d2);
        return data1.compareTo(data2);
    }




    public static int getStatusBarHeight(Context context) {
        int result = 0;
        int resourceId = Resources.getSystem().getIdentifier("status_bar_height",
                "dimen", "android");
        if (resourceId > 0) {
            result = Resources.getSystem().getDimensionPixelSize(resourceId);
        }
        return result;
    }






    /**
     * 人民币转换
     */
    @Deprecated
    public static String gettvPriceStr3(String i, String destiny) {
        if (TextUtils.isEmpty(i)) {
            return "0.00" + destiny;
        }
        double d = Double.parseDouble(i);
        StringBuffer sb = new StringBuffer();
        if (Math.abs(d) > 100000000) {
            sb.append(round2(d / 100000000d + "")).append("亿" + destiny);
            return sb.toString();
        } else if (Math.abs(d) > 10000d) {
            sb.append(round2(d / 10000d + "")).append("万" + destiny);
            return sb.toString();
        } else {
            return sb.append(i).append(destiny).toString();
        }
    }

    /**
     * 数组单位转换
     *      getIntDensityFormat("50000","元")
     *      return 5万元
     * @return
     */
    @Deprecated
    public static String getIntNumberFormat(String number, String destiny){
        try{
            int d;
            if(number.contains(".")){
                d = (int) Float.parseFloat(number);
            }else{
                d = Integer.parseInt(number);
            }

            StringBuffer sb = new StringBuffer();
            if (Math.abs(d) > 100000000) {
                sb.append((d/100000000)+"").append("亿" + destiny);
                return sb.toString();
            } else if (Math.abs(d) > 10000) {
                sb.append((d/10000)+"").append("万" + destiny);
                return sb.toString();
            } else {
                return sb.append(d).append(destiny).toString();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return number;
    }

    /**
     * 单位转换
     *  如：10000 -> 1万
     * @param numberStr 10000
     * @param destiny 万
     * @return 1万 忽略小数点
     */
    @Deprecated
    public static String unitTransform(String numberStr, String destiny) {

        if (numberStr == null || TextUtils.isEmpty(numberStr.trim())  ) {
            return "0" + destiny;
        }

        try{
            int d = (int) Float.parseFloat(numberStr);
            StringBuffer sb = new StringBuffer();
            if (Math.abs(d) > 100000000) {
                sb.append((d/100000000)+"").append("亿" + destiny);
                return sb.toString();
            } else if (Math.abs(d) > 10000) {
                sb.append((d/10000)+"").append("万" + destiny);
                return sb.toString();
            } else {
                return sb.append(numberStr).append(destiny).toString();
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return numberStr;
    }
    @Deprecated
    public static String getUnit(String i) {
        try {
            if (TextUtils.isEmpty(i)) {
                return "";
            }
            double d = Double.parseDouble(i);
            if (Math.abs(d) > 100000000) {
                return "亿";
            } else if (Math.abs(d) > 10000000) {
                return "千万";
            } else if (Math.abs(d) > 1000000) {
                return "百万";
            } else if (Math.abs(d) > 100000) {
                return "十万";
            } else if (Math.abs(d) > 10000) {
                return "万";
            } else {
                return "";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }
    @Deprecated
    public static String getFoundPrice(String i, String destiny) {
        if (TextUtils.isEmpty(i)) {
            return "0.00" + destiny;
        }
        double d = Double.parseDouble(i);
        StringBuffer sb = new StringBuffer();
        if (UtilsDensity.doubleCompare(d, 10000) >= 0) {
            sb.append(round2(d / 10000d + "")).append("万" + destiny);
            return sb.toString();
        } else {
            return sb.append(i).append(destiny).toString();
        }
    }

    /***
     * F10:保留八位，人民币转换
     */
    public static String gettvPriceStr4(String i, String destiny) {
        double d = Double.parseDouble(i);
        StringBuffer sb = new StringBuffer();
        if (Math.abs(d) > 100000000) {
            sb.append(round2(d / 100000000d + ""));
            return keep4(sb.toString()) + "亿" + destiny;
        } else if (Math.abs(d) > 10000d) {
            sb.append(round2(d / 10000d + ""));
            return keep4(sb.toString()) + "万" + destiny;
        } else {
            return keep4(sb.toString()) + destiny;
        }
    }

    /**
     * 小数点前保留4位
     *
     * @param str
     * @return
     */
    @Deprecated
    private static String keep4(String str) {
        if (str.contains(".")) {
            String s = str.substring(0, str.indexOf("."));
            if (s.length() >= 4) {
                return round(str);
            }
        }
        return str;
    }

    @Deprecated
    public static String round(String num) {
        String str;
        try {
            BigDecimal bd = new BigDecimal(num).setScale(0, BigDecimal.ROUND_HALF_UP);
            str = bd.intValue() + "";
            return str;
        } catch (Exception e) {
            return num;
        }
    }

    /**
     * 保留两位小数
     *
     * @param num
     * @return
     */
    @Deprecated
    public static String round2(String num) {
        String str;
        try {
            BigDecimal bd = new BigDecimal(num).setScale(2,
                    BigDecimal.ROUND_HALF_UP);
            str = bd.doubleValue() + "";
            return str;
        } catch (Exception e) {
            return "0.00";
        }
    }

    /**
     * 设置字体大小
     *
     * @param ss
     * @param start  开始位置（包含）
     * @param end    结束位置（不包含）
     * @param spSize 字体大小的dp值
     */
    @Deprecated
    public static void setStringSize(SpannableString ss, int start, int end, int spSize, Context context) {
        ss.setSpan(new AbsoluteSizeSpan(sp2px(spSize)), start, end, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
    }

    /**
     * 设置字体大小
     *
     * @param ss
     * @param start 开始位置（包含）
     * @param end   结束位置（不包含）
     */
    @Deprecated
    public static void setStringColor(SpannableString ss, int start, int end, int color, Context context) {
        ss.setSpan(new ForegroundColorSpan(context.getResources().getColor(color)), start, end, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
    }


}
