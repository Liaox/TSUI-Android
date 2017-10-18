# 通用组件 工具类Utils

### TSColorPhrase  设置文字颜色
#### 使用方法

```
CharSequence chars = TSColorPhrase.from("I'm<Chinese>,I love <China>").
                                                            withSeparator("<>").
                                                            innerColor(0xFFE6454A).
                                                            outerColor(0xFF666666).
                                                            format();
```

### TSDeviceUtils 设备相关
#### API
PS:emm 剩下的自己探索吧……

|方法名|参数|返回值|说明
|:---:|:---:|:---:|:---:|
|showSystemShareOption|Context context, String title, String url||打开系统的分享|
|isExitsSdcard||Boolean|是否有SD卡|
|getStatuBarHeight||int|获取状态栏高度|
|getScreenWidth||int|获取屏幕宽度|
|getScreenHeight||int|获取屏幕高度|
|getDisplayMetrics||DisplayMetrics|获得屏幕密度|
|uninstallApk|Context context, String packageName||卸载软件|
|isPackageExist||Boolean|当前的包是否存在|
|openApp|Context context, String packageName||开启 app|
|isAppAlive|Context context, String packageName|Boolean|判断应用是否已经启动|
|getVersionCode|Context context|int|获取版本号|
|getVersionCode|Context context, String packageName|int|获取指定包名应用的版本号|
|getVersionName|Context context|String|获取版本名|
|installAPK|Context context, File file||安装应用|
|openDial|Context context, String number||拨打电话|
|openSMS|Context context, String smsBody, String tel||发短信|
|openAppDetail|Context context||进入app设置详情页面|
|isZhCN|Context context|Boolean|是否是中文语言|


### TSStatusBarUtils 状态栏相关
#### API
|方法名|参数|返回值|说明
|:---:|:---:|:---:|:---:|
|transparencyBar|Activity activity||设置当前页面为沉浸式。PS：targetAPI19|
|statusBarLightMode|Activity activity||设置状态栏黑色字体图标，适配4.4以上版本MIUIV、Flyme和6.0以上版本其他Android|
|statusBarDarkMode|Activity activity||设置状态栏白色字体图标，适配4.4以上版本MIUIV、Flyme和6.0以上版本其他Android|
|statusBarLightMode|Activity activity, int type||设置状态栏白色字体图标，适配4.4以上版本MIUIV、Flyme和6.0以上版本其他Android, type     1:MIUUI 2:Flyme 3:android6.0|
|StatusBarDarkMode|Activity activity, int type||清除MIUI或flyme或6.0以上版本状态栏黑色字体，适配4.4以上版本MIUIV、Flyme和6.0以上版本其他Android, type     1:MIUUI 2:Flyme 3:android6.0|
|FlymeSetStatusBarLightMode|Window window, boolean dark|Boolean|设置状态栏图标为深色和魅族特定的文字风格,可以用来判断是否为Flyme用户|
|MIUISetStatusBarLightMode|Window window, boolean dark|Boolean|设置状态栏字体图标为深色，需要MIUIV6以上|


### TSConvertUtils 转换工具类
#### API
|方法名|参数|返回值|说明
|:---:|:---:|:---:|:---:|
|dp2px|Context context, float dpValue|int|dp 转 px|
|px2dp|Context context, float dpValue|int|px 转 dp|
|sp2px|Context context, float dpValue|int|sp 转 px|
|px2sp|Context context, float dpValue|int|px 转 sp|


### TSTimeUtils 时间工具类
#### API
|方法名|参数|返回值|说明
|:---:|:---:|:---:|:---:|
|millis2String|long millis|String|将时间戳转为时间字符串，转换默认时区|
|handleDetailTime|String timestr|String|获取友好的时间显示格式，详情查看代码|
|getCurrentZeroTime||long|获取当前 0 时区的时间戳|
|getCurrentZeroTimeStr||string|获取当前 0 时区的时间字符串|
|getDifferenceDays|long timesamp|int|输入时间和当前时间间隔的天数|
|getYear|long timesamp|int|通过时间戳获取年 yyyy|
|getStandardTimeWithYear|long timesamp|String|通过时间戳获取 yyyy-MM-dd HH:mm|
|getYearMonthDay|long timesamp|String|通过时间戳获取 yyyy-MM-dd|
|getStandardTimeWithDate|long timesamp|String|通过时间戳获取 MM-dd HH:mm|
|getStandardTimeWithHour|long timesamp|String|通过时间戳获取 HH:mm|
|getStandardTimeWithMothAndDay|long timesamp|String|通过时间戳获取 MM-dd|
|getStandardTimeWithMothAndDayOne|long timesamp|String|通过时间戳获取 dd,M 月|
|getStandardTimeWithMinAndSec|long timesamp|String|通过时间戳获取 mm:ss|
|string2_ToDya_Yesterday_Week|String timeStr|String|获取时间 对应 星期几|
|string2MillisDefaultLocal|String time|long|将时间字符串转为时间戳|

### 效果

![youtube](/image/Utils.gif)






