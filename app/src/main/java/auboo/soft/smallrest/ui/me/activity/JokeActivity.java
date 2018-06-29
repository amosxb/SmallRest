package auboo.soft.smallrest.ui.me.activity;

import android.content.Context;
import android.content.Intent;

import auboo.soft.smallrest.R;
import auboo.soft.smallrest.base.BaseCommonActivity;
import auboo.soft.smallrest.databinding.ActivityJokeBinding;

/**
 * 笑话大全
 * Created by amos on 2018/6/28.
 */

public class JokeActivity extends BaseCommonActivity<ActivityJokeBinding> {

    public static void start(Context context) {
        context.startActivity(new Intent(context, JokeActivity.class));
    }

    @Override
    protected String setTitle() {
        return "笑话大全";
    }

    @Override
    protected int getResId() {
        return R.layout.activity_joke;
    }

    @Override
    protected void initEvent() {

    }

    @Override
    protected void initView() {

    }
}
