package auboo.soft.smallrest;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.trello.rxlifecycle.components.support.RxAppCompatActivity;

import auboo.soft.smallrest.databinding.ActivityMainBinding;
import auboo.soft.smallrest.ui.bbs.fragment.BbsFragment;
import auboo.soft.smallrest.ui.find.fragment.FindFragment;
import auboo.soft.smallrest.ui.me.fragment.MeFragment;
import auboo.soft.smallrest.ui.store.fragment.StoreFragment;

public class MainActivity extends RxAppCompatActivity {

    public static final int TAB_FIND = 1;
    public static final int TAB_STORE = 2;
    public static final int TAB_BBS = 3;
    public static final int TAB_ME = 4;

    private ActivityMainBinding mainBinding;
    private Fragment mFindFragment;
    private Fragment mStoreFragment;
    private Fragment mBbsFragment;
    private Fragment mMeFragment;

    //用于对Fragment进行管理
    private FragmentManager mFragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        mFragmentManager = getSupportFragmentManager();
        if (savedInstanceState == null) {
            setSelectTab(TAB_FIND);
        }
        initEvent();
    }

    private void initEvent() {
        mainBinding.rgMainRadio.setOnCheckedChangeListener((group, checkedId) -> {
            switch (checkedId) {
                case R.id.rb_find:
                    setSelectTab(TAB_FIND);
                    break;
                case R.id.rb_store:
                    setSelectTab(TAB_STORE);
                    break;
                case R.id.rb_bbs:
                    setSelectTab(TAB_BBS);
                    break;
                case R.id.rb_me:
                    setSelectTab(TAB_ME);
                    break;
            }
        });
    }


    /**
     * 设置选中的Tab页
     *
     * @param index Tab页的索引
     */
    private void setSelectTab(int index) {
//        if (index == TAB_MINE) {
//            if (!ActivitySkipUtils.getInstance().checkIsLogin(this)) {
//                return;
//            }
//        }

        // 开启一个Fragment事务
        FragmentTransaction transaction = mFragmentManager.beginTransaction();
        // 先隐藏掉所有的Fragment，以防止有多个Fragment显示在界面上的情况
        hideFragments(transaction);
        switch (index) {
            case TAB_FIND:
                if (null == mFindFragment) {
                    // 如果为空，则创建一个并添加到界面上
                    mFindFragment = new FindFragment();
                    transaction.add(R.id.flyt_read, mFindFragment);
                } else {
                    // 如果不为空，则直接将它显示出来
                    transaction.show(mFindFragment);
                }
                break;
            case TAB_STORE:
                if (null == mStoreFragment) {
                    mStoreFragment = new StoreFragment();
                    transaction.add(R.id.flyt_read, mStoreFragment);
                } else {
                    transaction.show(mStoreFragment);
                }
                break;
            case TAB_BBS:
                if (null == mBbsFragment) {
                    mBbsFragment = new BbsFragment();
                    transaction.add(R.id.flyt_read, mBbsFragment);
                } else {
                    transaction.show(mBbsFragment);
                }
                break;
            case TAB_ME:
                if (null == mMeFragment) {
                    mMeFragment = new MeFragment();
                    transaction.add(R.id.flyt_read, mMeFragment);
                } else {
                    transaction.show(mMeFragment);
                }
                break;
            default:
                break;
        }
        transaction.commit();
    }


    /**
     * 将所有Tab页的Fragment都置为隐藏状态。
     *
     * @param transaction 用于对Fragment执行操作的事务
     */
    private void hideFragments(FragmentTransaction transaction) {
        try {
            if (null != mFindFragment) {
                transaction.hide(mFindFragment);
            }
            if (null != mStoreFragment) {
                transaction.hide(mStoreFragment);
            }
            if (null != mBbsFragment) {
                transaction.hide(mBbsFragment);
            }
            if (null != mMeFragment) {
                transaction.hide(mMeFragment);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
