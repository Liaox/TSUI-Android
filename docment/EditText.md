# 通用组件 EditText相关

### 带删除按钮的输入框 TSDeleteEditText
#### 使用方法
```
 <com.zhiyicx.tsui.widget.edittext.TSDeleteEditText
                 android:layout_width="match_parent"
                 android:layout_height="wrap_content"
                 style="@style/style_edit"
                 tools:text="xxxxx">
```


### 有限制长度文字提示的输入框 TSInputLimitView
#### 使用方法
```
 <com.zhiyicx.tsui.widget.edittext.TSInputLimitView
             android:layout_width="match_parent"
             android:layout_height="wrap_content"
             edit:tsLimitSize="20"
             edit:tsShowLimitSize="15"
             edit:tsShowLines="5"
             edit:tsContent_gravity="right"
             edit:tsContent_size="17sp"/>
```

### 密码输入框 TSPasswordEditText
#### 使用方法
```
<com.zhiyicx.tsui.widget.edittext.TSPasswordEditText
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            style="@style/style_edit"
            tools:text="xxxxxxxxx"/>
```

### 信息填写输入框，可以设置是否必填 TSInfoInputEditText
#### 使用方法
```
<com.zhiyicx.tsui.widget.edittext.TSInfoInputEditText
            android:layout_width="match_parent"
            android:layout_height="45dp"
            style="@style/style_edit"
            tools:text="xxxxxxxxxxx"
            edit:tsShowDiver="true"
            edit:tsIsRequired="visiable"
            edit:tsLeftHintText="xxx:"/>
```

|方法名(包含xml与对外提供的方法)|参数/返回值|说明
|:---:|:---:|:---:|
|tsShowDiver|boolean|是否显示分割线
|tsIsRequired|visiable、gone|是否显示必填符号“*”
|tsLeftHintText|string|左边的文字信息，输入的类别提示等
|tsRightHint|string|右边输入框的提示语
|getEditInput()|EditText|可以获取右边输入框对象
|tsRightMaxLines|int|输入框的最大行数


### 带有前缀的输入框 TSPrefixEditText
#### 使用方法
```
<com.zhiyicx.tsui.widget.edittext.TSPrefixEditText
            android:id="@+id/edit_pre"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            tools:text="xxxxxxxxxxx"/>

        mEditPre.setStartIndex(3); // 设置光标的开始位置
        mEditPre.setPreContent("回复："); // 设置前缀内容
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
```