package screensaver.qcast.com.custome;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;

/**
 * Created by user on 2016/11/24.
 */

public class QcastApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(getApplicationContext());
    }
}
