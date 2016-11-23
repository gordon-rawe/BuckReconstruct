package rawe.gordon.com.buckreconstruct.application;

import android.app.Application;
import android.util.Log;

import com.facebook.buck.android.support.exopackage.DefaultApplicationLike;

import rawe.gordon.com.buckreconstruct.BuildConfig;

/**
 * Created by gordon on 16/11/23.
 */
public class RealApp extends DefaultApplicationLike {

    private static final String TAG = "RealApp";

    public RealApp() {
    }

    public RealApp(Application application) {
        super(application);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "onCreate: " + BuildConfig.PARA_TWO);
    }
}
