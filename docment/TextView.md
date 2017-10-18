# 通用组件 TextView

### 自定义 TSDrawableSizeTextView  可以设置 drawable 大小的 TextView
#### 使用方法

```
<com.zhiyicx.tsui.widget.textview.TSDrawableSizeTextView
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:padding="@dimen/tsui_default_10"
            android:text="@string/ts_hint_drawable_size_textview"
            android:gravity="center"
            android:drawableLeft="@mipmap/ic_launcher_round"
            tv:tsCompoundDrawableWidth="20dp"
            tv:tsCompoundDrawableHeight="20dp"/>
```

|方法名(包含xml与对外提供的方法)|参数/返回值|说明
|:---:|:---:|:---:|
|tsCompoundDrawableWidth|dimension|图片宽|
|tsCompoundDrawableHeight|dimension|图片高|


### 带图标的 TSIconTextView
#### 使用方法

```
    <com.zhiyicx.tsui.widget.textview.TSIconTextView
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            tv:tsIconDirection="TOP"
            tv:tsIconGap="10dp"
            tv:tsIcon="@mipmap/ic_launcher"
            tv:tsIconHeight="40dp"
            tv:tsIconWidth="40dp"
            tv:tsIconText="可以设置位置与图片宽高间距的TextView"
            tv:tsIconTextColor="@color/tsui_config_color_gray_4"
            tv:tsIconTextSize="@dimen/tsui_text_size_14"/>
```

|方法名(包含xml与对外提供的方法)|参数/返回值|说明
|:---:|:---:|:---:|
|tsIconDirection|TOD、BOTTOM、LEFT、RIGHT|图片位置|
|tsIconGap|dimension|图文间距|
|tsIcon|res|图片资源|
|tsIconHeight|dimen|图片高
|tsIconWidth|dimen|图片宽
|tsIconText|string|文字内容
|tsIconTextColor|color|文字颜色
|tsIconTextSize|dimension|文字大小

### 可以展开与收起的 TSExpandableTextView
#### 使用方法
```
    <com.zhiyicx.tsui.widget.textview.TSExpandableTextView
                android:layout_width="match_parent"
                android:layout_height="wrap_content"
                android:textSize="@dimen/tsui_text_size_14"
                android:textColor="@color/tsui_config_color_gray_4"
                android:layout_marginTop="@dimen/tsui_default_10"
                android:text="@string/tsui_hint_expend_textview"
                tv:tsToExpandHintColor="@color/tsui_default_color"
                tv:tsToShrinkHintColor="@color/tsui_default_color"/>
```

|方法名(包含xml与对外提供的方法)|参数/返回值|说明
|:---:|:---:|:---:|
|tsMaxLinesOnShrink|int|最高行数|
|tsIsNeedShrink|Boolean|是否需要收起|
|tsToExpandHint|string|展开文字|
|tsToShrinkHint|string|收起文字|
|tsToExpandHintShow|Boolean|是否显示展开按钮|
|tsToShrinkHintShow|Boolean|是否显示收起按钮|
|tsToExpandHintColor|color|展开文字颜色|
|tsToShrinkHintColor|color|收起文字颜色|
|tsToExpandHintColorBgPressed|color|展开文字点击颜色|
|tsToShrinkHintColorBgPressed|color|收起文字点击颜色|


### 效果图

![效果](/image/TextView.gif)