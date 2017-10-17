# 通用组件 Button

### 自定义 TSCombinationButton  组合控件，图片-文字-图片
#### 使用方法

```
<com.zhiyicx.tsui.widget.button.TSCombinationButton
            android:layout_width="match_parent"
            android:layout_height="45dp"
            android:layout_marginTop="@dimen/tsui_default_10"
            btn:tsLeftText="TSCombinationButton"
            btn:tsRightText="123"
            btn:tsLeftTextColor="@android:color/holo_green_light"/>
```

|方法名(包含xml与对外提供的方法)|参数/返回值|说明
|:---:|:---:|:---:|
|tsLeftImage|id|左边图片|
|tsRightImage|id|右边图片|
|tsLeftText|string|左边文字|
|tsRightText|string|右边文字|
|tsLeftTextColor|color|左边文字颜色|
|tsRightTextColor|color|右边文字颜色|
|tsShowLine|Boolean|是否显示分割线|
|tsDividerLeftMargin、tsDividerRightMargin|dimension|分割线左右间距|
|tsLeftTextLeftPadding|dimension|左边文字左边的间距
|getCombinedButtonRightTextView()|TextView|获取右边的TextView
|getCombinedButtonImgRight()|ImageView|获取右边的图片控件
|getRightText()|string|获取右侧文字内容


### 涵盖加载动画的 TSLoadingButton
#### 使用方法

```
<com.zhiyicx.tsui.widget.button.TSLoadingButton
            android:id="@+id/tsLoadingBtn"
            android:layout_width="200dp"
            android:layout_height="wrap_content"
            android:layout_marginTop="@dimen/tsui_default_10"
            btn:tsText="点击"
            btn:tsTextColor="#801B88EE"/>
```

|方法名(包含xml与对外提供的方法)|参数/返回值|说明
|:---:|:---:|:---:|
|tsText|string|按钮文字|
|tsTextColor|color|按钮文字颜色|
|tsLoadingView|id|加载的动画资源|
|handleAnimation()|Boolean|控制动画