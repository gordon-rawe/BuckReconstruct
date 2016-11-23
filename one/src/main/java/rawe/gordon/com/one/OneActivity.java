package rawe.gordon.com.one;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

/**
 * Created by gordon on 11/22/16.
 */
public class OneActivity extends FragmentActivity {

    private static final String TAG = OneActivity.class.getCanonicalName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_naub);
    }
}
