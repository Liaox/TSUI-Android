# 通用组件 其他View

### 自定义 TSEmptyView  缺省页
#### 使用方法

```
<com.zhiyicx.tsui.widget.view.TSEmptyView
            android:id="@+id/emptyView"
            android:layout_width="match_parent"
            android:layout_height="match_parent"/>
// 设置状态
mEmptyView.setNoDataTip("没有内容");
mEmptyView.setNoNetTipImageId(R.mipmap.nodata);
mEmptyView.setErrorType(TSEmptyView.STATE_NODATA);
```

|state|说明
|:---:|:---:|
|STATE_NETWORK_ERROR|网络异常|
|STATE_NETWORK_LOADING|加载中|
|STATE_NODATA|没有数据|
|STATE_NODATA_ENABLE_CLICK|有点击事件的状态|
|STATE_HIDE_LAYOUT|隐藏缺省页


### 头像控件 TSUserAvatarView
#### 使用方法

```
<com.zhiyicx.tsui.widget.view.TSUserAvatarView
            android:id="@+id/user_avatar"
            android:layout_width="@dimen/head_pic_default"
            android:layout_height="@dimen/head_pic_default"
            android:layout_marginLeft="@dimen/tsui_default_10"
            image:ts_avatare_size="@dimen/head_pic_default"
            android:layout_below="@+id/user_avatar_hint"
            android:src="@mipmap/ic_launcher"/>
            
 // 设置认证的图标
 mUserAvatar1.getIvVerify().setImageResource(R.mipmap.ic_launcher_round);
```

|方法名(包含xml与对外提供的方法)|参数/返回值|说明
|:---:|:---:|:---:|
|ts_avatare_size|dimen|头像大小|
|getIvAvatar|TSFilterImageView|获取头像控件|
|getIvVerify|ImageView|获取认证的控件

### 效果图

![效果](/image/View.gif)