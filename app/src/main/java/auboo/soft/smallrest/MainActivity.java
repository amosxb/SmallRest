package auboo.soft.smallrest;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.lcodecore.tkrefreshlayout.RefreshListenerAdapter;
import com.lcodecore.tkrefreshlayout.TwinklingRefreshLayout;

import auboo.soft.smallrest.databinding.ActivityMainBinding;
import me.drakeet.multitype.Items;
import me.drakeet.multitype.MultiTypeAdapter;

public class MainActivity extends AppCompatActivity {

    private Items mItems;
    private MultiTypeAdapter mMultiAdapter;
    private ActivityMainBinding mainBinding;
    private int mCurCount = 30;
    private int countPage = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        initView();
        initData();
        initEvent();
    }

    private void initEvent() {

        mainBinding.tklRefresh.setOnRefreshListener(new RefreshListenerAdapter() {
            @Override
            public void onLoadMore(TwinklingRefreshLayout refreshLayout) {
                super.onLoadMore(refreshLayout);

                mainBinding.tklRefresh.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        mainBinding.tklRefresh.finishLoadmore();
                        loadMore();
                    }
                }, 1000);
            }
        });


        mainBinding.rvList.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);

                boolean isFlag = isSlideToBottom(mainBinding.rvList);
                Toast.makeText(MainActivity.this, isFlag + "", Toast.LENGTH_SHORT).show();
            }
        });
    }


    /**
     * 判断是否滑动到底部
     */
    public boolean isSlideToBottom(RecyclerView recyclerView) {
        if (recyclerView == null) return false;
        if (recyclerView.computeVerticalScrollExtent() + recyclerView.computeVerticalScrollOffset()
                >= recyclerView.computeVerticalScrollRange())
            return true;
        Log.i("mainActivity", "computeVerticalScrollExtent=" + mainBinding.rvList.computeVerticalScrollExtent() + "---->"
                + "computeVerticalScrollOffset=" + mainBinding.rvList.computeVerticalScrollOffset());
        return false;
    }

    private void initView() {
        mItems = new Items();
        mMultiAdapter = new MultiTypeAdapter(mItems);
        mMultiAdapter.register(ItemMainBean.class, new ItemMainHolder(this));
        mMultiAdapter.register(String.class, new ItemNoMoreHolder());
        mainBinding.rvList.setLayoutManager(new LinearLayoutManager(this));
        mainBinding.rvList.setHasFixedSize(true);
        mainBinding.rvList.setAdapter(mMultiAdapter);

        mainBinding.tklRefresh.setAutoLoadMore(true);
        mainBinding.tklRefresh.setEnableLoadmore(true);
        mainBinding.tklRefresh.setEnableRefresh(false);
        mainBinding.tklRefresh.setEnableOverScroll(false);
        mainBinding.tklRefresh.setBottomView(new BaiduBottomView(this));
        mainBinding.tklRefresh.setBottomHeight(44);
    }

    private void initData() {
        for (int i = 0; i < 30; i++) {
            mItems.add(new ItemMainBean("哈哈哈哈哈" + i));
        }
        mMultiAdapter.notifyDataSetChanged();
    }

    private void loadMore() {
        if (countPage >= 5) {
            mainBinding.tklRefresh.setEnableLoadmore(false);
            mItems.add("");
            mMultiAdapter.notifyDataSetChanged();
            return;
        }

        for (int i = 0; i < 10; i++) {
            mItems.add(new ItemMainBean("哈哈哈" + (mCurCount + i)));
        }
        mCurCount += 10;
        countPage++;
        mMultiAdapter.notifyDataSetChanged();
    }
}
