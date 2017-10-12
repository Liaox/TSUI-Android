package com.zhiyicx.tsuidemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;

import com.zhiyicx.tsui.widget.edittext.TSPrefixEditText;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author Catherine
 * @describe 输入框相关的页面
 * @date 2017/10/12
 * @contact email:648129313@qq.com
 */

public class TSEditTextActivity extends AppCompatActivity {

    @BindView(R.id.edit_pre)
    TSPrefixEditText mEditPre;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ts_edittext);
        ButterKnife.bind(this);
        mEditPre.setStartIndex(3);
        mEditPre.setPreContent("回复：");
        mEditPre.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                 /*监听删除键不删除前缀文字*/
                if (keyEvent.getKeyCode() == KeyEvent.KEYCODE_DEL) {
                    int cursorEnd = mEditPre.getSelectionEnd();
                    String text = String.valueOf(mEditPre.getText()).substring(0, cursorEnd);
                    if (text.length() <= 3)
                        return true;
                }
                return false;
            }
        });
    }
}
