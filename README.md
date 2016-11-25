# ScreenSaver
android和各种支持互动屏保的电视盒子制作屏保效果
#DreamService接口
主要是通过继承DreamService,扩展实现用户自定义屏保功能；用户只要安装重写该DreamService的apk，那么在其互动屏保设置中
就可以看到自己的自定义屏保，Dreams为系统提供一个灵活多变的展览和陈列显示的屏保。
同Activity一样DreamService也有其自己的生命周期：
1. onAttachedToWindow()
    在这里可以调用setContentView();一些初始化操作
2. onDreamingStarted();这里可以开启一个动画或者其他行为，此时互动屏保已启动。
3. onDreamingStopped();屏保停止，即终止上面启动的动画或行为
4. onDetachedFormWindow();取出一些废弃的资源，如o从hndler或监听这那里
同时接口中的onCreate（）和onDestroy()方法也会被请求，可以使用这些方法来初始化或者释放资源。
同时如何注册该servicei以及查看其它方法，可以参考https://developer.android.com/reference/android/service/dreams/DreamService.html
#实现效果
如果要想实现“DayDream”互动屏保，首先你的设备要支持自定义互动屏保设置，在你安装完以后要能够在你的设备上看到
自定义的保如下图所示，其具体效果，大家可以克隆项目：
 ![Image text](https://raw.githubusercontent.com/youguyilin/ScreenSaver/master/images/aa.jpg)
    
