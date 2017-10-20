package com.zhiyicx.tsui.utils;

import android.content.Context;

/**
 * @Describe 转换相关工具类
 * @Author Jungle68
 * @Date 2016/12/15
 * @Contact 335891510@qq.com
 */

public class TSConvertUtils {

    private TSConvertUtils() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    /**
     * dp 转 px
     *
     * @param dpValue dp值
     * @return px值
     */
    public static int dp2px(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

    /**
     * px 转 dp
     *
     * @param pxValue px值
     * @return dp值
     */
    public static int px2dp(Context context, float pxValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);
    }

    /**
     * sp 转 px
     *
     * @param spValue sp值
     * @return px值
     */
    public static int sp2px(Context context, float spValue) {
        final float fontScale = context.getResources().getDisplayMetrics().scaledDensity;
        return (int) (spValue * fontScale + 0.5f);
    }

    /**
     * px 转 sp
     *
     * @param pxValue px值
     * @return sp值
     */
    public static int px2sp(Context context, float pxValue) {
        final float fontScale = context.getResources().getDisplayMetrics().scaledDensity;
        return (int) (pxValue / fontScale + 0.5f);
    }

    /**
     * 替换 emoji 长度 =1
     *
     * @param str
     * @return
     */
    public static int stringLengthDealForEmoji(CharSequence str) {
        int emojiLength = emojiStrLength(str);
        return (str.length() - emojiLength) + stringEmojiCount(str);
    }

    /**
     * @param str
     * @return 一个 emoji 占两个字，通过长度返回个数
     */
    public static int stringEmojiCount(CharSequence str) {
        int emojiLenght = emojiStrLength(str);
        return emojiLenght / 2;
    }

    /**
     * @param str
     * @return 字符串中 emoji 字符长度
     */
    public static int emojiStrLength(CharSequence str) {
        int emojiLenght = 0;
        int len = str.length();
        for (int i = 0; i < len; i++) {
            if (isEmojiCharacter(str.charAt(i))) {
                emojiLenght++;
            }
        }
        return emojiLenght;
    }

    /**
     * emoji 所占的长度
     * @param emojiNUm emoji 个数
     * @return
     */
    public static int emojiStrLength(int emojiNUm) {
        return 2*emojiNUm;
    }

    private static boolean isEmojiCharacter(char codePoint) {
        return !(codePoint == 0x0 || codePoint == 0x9 || codePoint == 0xA || codePoint == 0xD || codePoint >= 0x20 && codePoint <= 0xD7FF ||
                codePoint >= 0xE000 && codePoint <= 0xFFFD);
    }

}
