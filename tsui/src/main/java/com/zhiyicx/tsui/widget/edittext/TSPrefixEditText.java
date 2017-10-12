package com.zhiyicx.tsui.widget.edittext;

import android.content.Context;
import android.support.v7.widget.AppCompatEditText;
import android.text.Selection;
import android.util.AttributeSet;

import com.zhiyicx.tsui.R;

/**
 * @author Catherine
 * @describe 带有前缀文字的输入框，目前还有一个全部复制会复制到前缀文字的问题，不过仔细想想，都是全部复制了，没毛病啊╮(╯▽╰)╭
 * eg:  回复TA：xxxxxxx
 *      xxxxxxxxxxxxxxx
 * @date 2017/10/12
 * @contact email:648129313@qq.com
 */

public class TSPrefixEditText extends AppCompatEditText {

    private int mStartIndex = 0; // 光标可以选中的开始位
    private String mPreContent; // 前缀的内容

    public TSPrefixEditText(Context context) {
        this(context, null);
    }

    public TSPrefixEditText(Context context, AttributeSet attrs) {
        this(context, attrs, R.attr.editTextStyle);
    }

    public TSPrefixEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean onTextContextMenuItem(int id) {
        if (id == android.R.id.selectAll) {
            // 全部选中：当除了前缀之外还有文字才有操作
            if (getEditableText().length() > mStartIndex) {
                Selection.setSelection(getEditableText(), mStartIndex, getEditableText().length());
            }
            return true;
        }
        return super.onTextContextMenuItem(id);
    }

    @Override
    protected void onSelectionChanged(int selStart, int selEnd) {
        super.onSelectionChanged(selStart, selEnd);
        // 当选中的起始位置超过设置的开始位置时，强制从开始位置开始选中
        if (selStart < mStartIndex) {
            Selection.setSelection(getEditableText(), mStartIndex, selEnd);
        }
    }

//    @Override
//    public Editable getText() {
//        return super.getText().delete(0, mStartIndex);
//    }

    /**
     * 设置起始位置
     *
     * @param startIndex 光标开始的位置
     */
    public void setStartIndex(int startIndex) {
        this.mStartIndex = startIndex;
    }

    /**
     * 设置前缀的内容，使用这个方法会清空当前的内容
     *
     * @param preContent 前缀
     */
    public void setPreContent(String preContent) {
        this.mPreContent = preContent;
        setText(preContent);
    }
}
