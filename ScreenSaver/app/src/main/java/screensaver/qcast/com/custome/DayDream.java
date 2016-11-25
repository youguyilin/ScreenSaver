package screensaver.qcast.com.custome;

import android.content.Context;
import android.net.Uri;
import android.service.dreams.DreamService;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.view.SimpleDraweeView;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;

import screensaver.qcast.com.screensaver.R;

/**
 * Created by user on 2016/11/24.
 */

public class DayDream extends DreamService {
    private final static String TAG = "DreamService";
    private Banner mBanner;
    //系统时间时间提示
    private TextView mTimeTip;
    //图片集合
    private List<String>mImages;
    //标题集合
    private List<String>titles;
    private Object selfTitle;
    private Object image;

    @Override
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    @Override
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        setFullscreen(true);
        setInteractive(true);
        setScreenBright(false);
        setContentView(R.layout.saver_pager);
        mBanner = (Banner) findViewById(R.id.myBanner);
        mTimeTip = (TextView) findViewById(R.id.time_tips);
        getSelfTitle();
        getImage();
        setbannerStyle();
        //启动banner
        mBanner.start();
        Log.e(TAG,"启动dayDream");
        mBanner.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void setbannerStyle() {
       mBanner.setBannerStyle(BannerConfig.NOT_INDICATOR);
        //设置图片加载器
        mBanner.setImageLoader(new FrecsoImageLoader());
        //设置图片集合
        mBanner.setImages(mImages);
        mBanner.setBannerAnimation(Transformer.Accordion);
       // mBanner.setBannerAnimation(Transformer.CubeOut);
        //设置标题集合
        mBanner.setBannerTitles(titles);
        //设置轮播时间
        mBanner.setDelayTime(2500);
        //设置自动播放
        mBanner.isAutoPlay(true);
        //设置指示器位置
        mBanner.setIndicatorGravity(BannerConfig.RIGHT);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onDreamingStarted() {
        super.onDreamingStarted();
    }

    @Override
    public void onDreamingStopped() {
        super.onDreamingStopped();
    }

    public Object getSelfTitle() {
        titles = new ArrayList<String>();
        titles.add("唧唧复唧唧");
        titles.add("木兰当户织");
        titles.add("衣带渐宽终不悔");
        titles.add("为伊消得人憔悴");
        return selfTitle;
    }

    public Object getImage() {
        mImages = new ArrayList<String>();
        mImages.add("res://screensaver.qcast.com.screensaver/"+R.drawable.saver2);
        mImages.add("res://screensaver.qcast.com.screensaver/"+R.drawable.saver3);
        mImages.add("res://screensaver.qcast.com.screensaver/"+R.drawable.girl);
        mImages.add("res://screensaver.qcast.com.screensaver/"+R.drawable.spielberg);
        return image;
    }
    public class FrecsoImageLoader extends ImageLoader {

        @Override
        public void displayImage(Context context, Object path, ImageView imageView) {
            Uri uri = Uri.parse((String) path);
            imageView.setImageURI(uri);
        }

        @Override
        public ImageView createImageView(Context context) {
            SimpleDraweeView draweeView = new SimpleDraweeView(context);
            GenericDraweeHierarchyBuilder builder = new GenericDraweeHierarchyBuilder(getResources());
            GenericDraweeHierarchy hierarchy = builder
                    .setActualImageScaleType(ScalingUtils.ScaleType.FIT_XY)
                    .setPlaceholderImage(getResources().getDrawable(R.drawable.saver1), ScalingUtils.ScaleType.FIT_XY)
                    .setFailureImage(getResources().getDrawable(R.drawable.saver1), ScalingUtils.ScaleType.FIT_XY)
                    .setProgressBarImage(getResources().getDrawable(R.drawable.ic_launcher), ScalingUtils.ScaleType.FIT_XY)
                    .setProgressBarImageScaleType(ScalingUtils.ScaleType.FIT_XY)
                    .build();
            draweeView.setHierarchy(hierarchy);
            return draweeView;
        }
    }
}
