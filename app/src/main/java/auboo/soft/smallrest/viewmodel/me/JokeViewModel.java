package auboo.soft.smallrest.viewmodel.me;

import android.arch.lifecycle.ViewModel;

import auboo.soft.smallrest.base.BaseRequestListener;
import auboo.soft.smallrest.iview.me.IJokeView;
import auboo.soft.smallrest.model.me.IJokeModel;
import auboo.soft.smallrest.model.me.JokeModelImpl;
import auboo.soft.smallrest.ui.me.bean.JokeBean;
import me.drakeet.multitype.Items;

/**
 * 笑话大全viewModel层
 * Created by amos on 2018/7/3.
 */

public class JokeViewModel extends ViewModel {

    //这里这样设计出于java六大设计模式中的依赖倒置原则
    //高层模块不应该依赖低层模块，二者都应该依赖其抽象；抽象不应该依赖细节；细节应该依赖抽象。
    private IJokeModel mJokeModel;
    private IJokeView mIJokeView;
    private int mPage;

    public JokeViewModel(IJokeView iJokeView) {
        this.mJokeModel = new JokeModelImpl();
        this.mIJokeView = iJokeView;
        loadingData();
    }

    public void loadingData() {
        if (mPage == 0) {
            mIJokeView.loadingView();
        }
        mJokeModel.setPage(mPage);
        mJokeModel.getJokeData(new BaseRequestListener<JokeBean>() {
            @Override
            public void onSuccess(JokeBean jokeBean) {
                mIJokeView.loadSuccessView();
                if (jokeBean != null && jokeBean.getResult() != null && jokeBean.getResult().getData().size() > 0) {
                    mIJokeView.refreshAdapter(jokeBean.getResult());
                }
            }

            @Override
            public void onFailure() {
                mIJokeView.loadingFailure();
                if (mPage > 1) {
                    mPage--;
                }
            }

            @Override
            public void onFailure(String msg) {
                mIJokeView.loadingFailure(msg);
            }
        });
    }

    public int getPage() {
        return mPage;
    }

    public void setPage(int mPage) {
        this.mPage = mPage;
    }
}
