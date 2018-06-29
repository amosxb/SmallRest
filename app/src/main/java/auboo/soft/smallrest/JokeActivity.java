package auboo.soft.smallrest;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

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
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke);

    }

    @Override
    protected String setTitle() {
        return getResources().getString(R.string.joke_tool_bar_title);
    }
}
