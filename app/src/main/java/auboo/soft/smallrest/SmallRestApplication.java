package auboo.soft.smallrest;

import android.support.multidex.MultiDexApplication;

import com.example.http.HttpUtils;

/**
 * Created by amos on 2018/7/3.
 */

public class SmallRestApplication extends MultiDexApplication {

    @Override
    public void onCreate() {
        super.onCreate();
        HttpUtils.getInstance().init(this, true);
    }
}
