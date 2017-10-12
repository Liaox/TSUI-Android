package com.zhiyicx.tsuidemo.bean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * @author Catherine
 * @describe
 * @date 2017/10/12
 * @contact email:648129313@qq.com
 */

public class CateBean implements Parcelable{

    private String title;

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.title);
    }

    public CateBean() {
    }

    protected CateBean(Parcel in) {
        this.title = in.readString();
    }

    public static final Creator<CateBean> CREATOR = new Creator<CateBean>() {
        @Override
        public CateBean createFromParcel(Parcel source) {
            return new CateBean(source);
        }

        @Override
        public CateBean[] newArray(int size) {
            return new CateBean[size];
        }
    };
}
