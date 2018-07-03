package auboo.soft.smallrest.ui.me.activity;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;

import java.util.concurrent.TimeUnit;

import auboo.soft.smallrest.R;
import auboo.soft.smallrest.base.BaseCommonActivity;
import auboo.soft.smallrest.databinding.ActivityJokeBinding;
import auboo.soft.smallrest.iview.me.IJokeView;
import auboo.soft.smallrest.ui.me.bean.JokeBean;
import auboo.soft.smallrest.ui.me.holder.JokeHolder;
import auboo.soft.smallrest.view.LoadMoreDelegate;
import auboo.soft.smallrest.viewmodel.me.JokeViewModel;
import me.drakeet.multitype.Items;
import me.drakeet.multitype.MultiTypeAdapter;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;

/**
 * 笑话大全
 * Created by amos on 2018/6/28.
 */

public class JokeActivity extends BaseCommonActivity<ActivityJokeBinding> implements IJokeView, LoadMoreDelegate.LoadMoreSubject {

    private MultiTypeAdapter multiTypeAdapter;
    private Items mItems;
    private JokeViewModel mJokeViewModel;

    public static void start(Context context) {
        context.startActivity(new Intent(context, JokeActivity.class));
    }

    @Override
    protected String setTitle() {
        return getString(R.string.joke_tool_bar_title);
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
        initAttr();
        mJokeViewModel = new JokeViewModel(this);
    }

    private void initAttr() {
        mItems = new Items();
        multiTypeAdapter = new MultiTypeAdapter(mItems);
        multiTypeAdapter.register(JokeBean.ResultBean.DataBean.class, new JokeHolder(this));
        bindingView.rvJoke.setHasFixedSize(true);
        bindingView.rvJoke.setLayoutManager(new LinearLayoutManager(this));
        bindingView.rvJoke.setAdapter(multiTypeAdapter);

        LoadMoreDelegate loadMoreDelegate = new LoadMoreDelegate(this);
        loadMoreDelegate.attach(bindingView.rvJoke);
    }

    @Override
    public void loadingView() {
        showLoading();
    }

    @Override
    public void loadSuccessView() {
        showContentView();
    }

    @Override
    public void refreshAdapter(JokeBean.ResultBean resultBean) {
        mItems.addAll(resultBean.getData());
        multiTypeAdapter.notifyDataSetChanged();
    }

    @Override
    public void loadingFailure() {
        showError();
    }

    @Override
    public void loadingFailure(String msg) {
        showErrorMsg(msg);
    }

    @Override
    public boolean isLoading() {
        return false;
    }

    @Override
    protected void onRefresh() {
        super.onRefresh();

    }

    @Override
    public void onLoadMore() {
        int page = mJokeViewModel.getPage();
        page++;
        mJokeViewModel.setPage(page);
        Observable.timer(1000, TimeUnit.MILLISECONDS, AndroidSchedulers.mainThread()).subscribe(aLong -> mJokeViewModel.loadingData());
    }
}
