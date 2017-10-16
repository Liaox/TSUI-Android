# 通用组件 PopupWindow相关

### 自定义 TSBasePopupWindow
#### 使用方法
```

```


### 自定义 TSCenterAlertPopWindow 继承自TSBasePopupWindow 中间提示框，带有底部两个按钮
#### 使用方法
```
mCenterAlertPopWindow = TSCenterAlertPopWindow.builder()
                            .with(this)
                            .titleContent("title") // 标题
                            .titleTextStyle(color, textSize) // 标题的颜色以及文字大小
                            .centerContent("content") // 正文内容
                            .centerTextStyle((color, textSize) // 正文的颜色以及文字大小
                            .titleTextStyle(R.color.colorPrimary, 0)
                            .rightTextStyle(R.color.colorAccent, 0)
                            .backgroundAlpha(0.8f) // 背景透明度
                            .buildCenterPopWindowItem1ClickListener(new TSCenterAlertPopWindow.CenterPopWindowItemClickListener() {
                                @Override
                                public void onRightClicked() {
                                    // 点击右边按钮
                                    Toast.makeText(TSPopupWindowActivity.this, "点击右边按钮", Toast.LENGTH_SHORT).show();
                                    mCenterAlertPopWindow.dismiss();
                                }

                                @Override
                                public void onLeftClicked() {
                                    // 点击左边按钮
                                    Toast.makeText(TSPopupWindowActivity.this, "点击左边按钮", Toast.LENGTH_SHORT).show();
                                    mCenterAlertPopWindow.dismiss();
                                }
                            })
                            .build();
                }
mCenterAlertPopWindow.show();
```

### 自定义 TSCenterOnlyPopWindow 继承自TSBasePopupWindow 中间提示框，仅提示，底部有一个按钮，可以隐藏
#### 使用方法
```
mCenterOnlyPopWindow = TSCenterOnlyPopWindow.builder()
                            .with(this)
                            .backgroundAlpha(0.8f)
                            .titleContent("title")
                            .centerContent("content")
                            .isShowBottomButton(false) // 是否显示底部按钮
                            .buildCenterPopWindowItem1ClickListener(new TSCenterOnlyPopWindow.CenterPopWindowItemClickListener() {
                                @Override
                                public void onButtonClick() {
                                    // 点击底部按钮
                                    Toast.makeText(TSPopupWindowActivity.this, "点击底部按钮", Toast.LENGTH_SHORT).show();
                                    mCenterOnlyPopWindow.dismiss();
                                }
                            })
                            .build();
                }
 mCenterOnlyPopWindow.show();
```
