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



