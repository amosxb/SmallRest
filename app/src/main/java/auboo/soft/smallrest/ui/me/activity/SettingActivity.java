package auboo.soft.smallrest.ui.me.activity;

import android.content.Context;
import android.content.Intent;

import auboo.soft.smallrest.R;
import auboo.soft.smallrest.base.BaseCommonActivity;
import auboo.soft.smallrest.databinding.ActivitySettingBinding;

/**
 * 设置界面
 * Created by amos on 2018/6/28.
 */

public class SettingActivity extends BaseCommonActivity<ActivitySettingBinding> {

    public static void start(Context context) {
        context.startActivity(new Intent(context, SettingActivity.class));
    }

    @Override
    protected String setTitle() {
        return "设置";
    }

    @Override
    protected int getResId() {
        return -1;
    }

    @Override
    protected void initEvent() {

    }

    @Override
    protected void initView() {

    }
}
