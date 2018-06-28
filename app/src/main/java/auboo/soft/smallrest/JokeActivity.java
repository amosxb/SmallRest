package auboo.soft.smallrest;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;

import auboo.soft.smallrest.base.BaseActivity;
import auboo.soft.smallrest.databinding.ActivityJokeBinding;

/**
 * 笑话大全
 * Created by amos on 2018/6/28.
 */

public class JokeActivity extends BaseActivity<ActivityJokeBinding> {

    public static void start(Context context) {
        context.startActivity(new Intent(context, JokeActivity.class));
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke);

    }

    @Override
    protected String setTitle() {
        return getResources().getString(R.string.joke_tool_bar_title);
    }

    @Override
    protected void initEvent() {

    }
}
