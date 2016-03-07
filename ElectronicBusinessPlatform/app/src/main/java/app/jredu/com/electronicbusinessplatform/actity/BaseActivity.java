package app.jredu.com.electronicbusinessplatform.actity;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import app.jredu.com.electronicbusinessplatform.utils.AppManager;

/**
 * Created by Administrator on 2015/10/15 0015.
 */
public class BaseActivity extends FragmentActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AppManager.getAppManager().addActivity(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        AppManager.getAppManager().finishActivity(this);
    }
}
