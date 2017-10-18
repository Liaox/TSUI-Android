package com.zhiyicx.tsuidemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.zhiyicx.tsui.widget.button.TSLoadingButton;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * @author Catherine
 * @describe 按钮相关的demo
 * @date 2017/10/11
 * @contact email:648129313@qq.com
 */

public class TSButtonActivity extends AppCompatActivity {

    @BindView(R.id.tsLoadingBtn)
    TSLoadingButton mTsLoadingBtn;

    private boolean isOpen = false;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ts_button);
        ButterKnife.bind(this);
        mTsLoadingBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mTsLoadingBtn.handleAnimation(!isOpen);
                isOpen = !isOpen;
            }
        });
    }

    @OnClick({R.id.btn_change})
    public void onClick(View view){
        switch (view.getId()){
            case R.id.btn_change:
                mTsLoadingBtn.setAnimationRes(R.drawable.frame_loading_grey);
                break;
            default:
        }
    }
}
