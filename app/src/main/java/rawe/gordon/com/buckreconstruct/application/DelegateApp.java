package rawe.gordon.com.buckreconstruct.application;

import com.facebook.buck.android.support.exopackage.ExopackageApplication;

/**
 * Created by gordon on 11/22/16.
 */
public class DelegateApp extends ExopackageApplication {

    public DelegateApp() {
        super("rawe.gordon.com.buckreconstruct.application.RealApp", true);
    }
}
