package auboo.soft.smallrest.base;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.ActionBar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.jaeger.library.StatusBarUtil;
import com.trello.rxlifecycle.components.support.RxAppCompatActivity;

import auboo.soft.smallrest.R;
import auboo.soft.smallrest.databinding.ActivityBaseBinding;

/**
 * 基本类
 * Created by amos on 2018/6/28.
 */

public abstract class BaseCommonActivity<SV extends ViewDataBinding> extends RxAppCompatActivity {

    private SV bindingView;
    private ActivityBaseBinding mBaseBinding;
    private View mLoadingView;
    private AnimationDrawable mAnimationDrawable;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getResId());
        initView();
        initEvent();
    }

    @Override
    public void setContentView(@LayoutRes int layoutResID) {
        mBaseBinding
                = DataBindingUtil.inflate(LayoutInflater.from(this), R.layout.activity_base, null, false);
        bindingView = DataBindingUtil.inflate(getLayoutInflater(), layoutResID, null, false);

        // content
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        bindingView.getRoot().setLayoutParams(params);
        RelativeLayout mContainer = mBaseBinding.getRoot().findViewById(R.id.container);
        mContainer.addView(bindingView.getRoot());
        getWindow().setContentView(mBaseBinding.getRoot());

        //设置toolbar
        setToolBar();
        //加载失败布局点击刷新
        mBaseBinding.llErrorRefresh.setOnClickListener(v -> {
            showLoading();
            onRefresh();
        });
        // 设置透明状态栏，兼容4.4
        StatusBarUtil.setColor(this, ContextCompat.getColor(this, R.color.colorTheme), 0);
    }

    protected void setToolBar() {
        setSupportActionBar(mBaseBinding.toolBar.toolBar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            //去除默认Title显示
            actionBar.setDisplayShowTitleEnabled(false);
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeAsUpIndicator(R.drawable.ic_appbar_back);
        }
        mBaseBinding.toolBar.tvToolBarTitle.setText(setTitle());
        mBaseBinding.toolBar.toolBar.setNavigationOnClickListener(v -> onBackPressed());
    }

    protected void showLoading() {
        mLoadingView = ((ViewStub) this.findViewById(R.id.vs_loading)).inflate();
        ImageView iv = mLoadingView.findViewById(R.id.img_progress);

        if (mLoadingView != null && !mLoadingView.isShown()) {
            mLoadingView.setVisibility(View.VISIBLE);
        }
        // 开始动画
        mAnimationDrawable = (AnimationDrawable) iv.getDrawable();
        if (mAnimationDrawable != null) {
            if (!mAnimationDrawable.isRunning()) {
                mAnimationDrawable.start();
            }
        }
        if (bindingView.getRoot().isShown()) {
            bindingView.getRoot().setVisibility(View.GONE);
        }
        if (mBaseBinding.llErrorRefresh.isShown()) {
            mBaseBinding.llErrorRefresh.setVisibility(View.GONE);
        }
    }

    protected void showContentView() {
        if (mLoadingView != null && mLoadingView.isShown()) {
            mLoadingView.setVisibility(View.GONE);
        }
        // 停止动画
        if (mAnimationDrawable != null) {
            if (mAnimationDrawable.isRunning()) {
                mAnimationDrawable.stop();
            }
        }
        if (mBaseBinding.llErrorRefresh.isShown()) {
            mBaseBinding.llErrorRefresh.setVisibility(View.GONE);
        }
        if (!bindingView.getRoot().isShown()) {
            bindingView.getRoot().setVisibility(View.VISIBLE);
        }
    }

    protected void showError() {
        if (mLoadingView != null && mLoadingView.isShown()) {
            mLoadingView.setVisibility(View.GONE);
        }
        // 停止动画
        if (mAnimationDrawable != null) {
            if (mAnimationDrawable.isRunning()) {
                mAnimationDrawable.stop();
            }
        }
        if (!mBaseBinding.llErrorRefresh.isShown()) {
            mBaseBinding.llErrorRefresh.setVisibility(View.VISIBLE);
        }
        if (bindingView.getRoot().isShown()) {
            bindingView.getRoot().setVisibility(View.GONE);
        }
    }
    
    protected void onRefresh() {

    }

    protected abstract String setTitle();

    protected abstract int getResId();

    protected abstract void initEvent();

    protected abstract void initView();
}
