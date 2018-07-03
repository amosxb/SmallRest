package auboo.soft.smallrest.model.me;

import android.util.Log;

import com.example.http.HttpUtils;

import auboo.soft.smallrest.base.BaseRequestListener;
import auboo.soft.smallrest.constant.HttpConst;
import auboo.soft.smallrest.http.BuildFactory;
import auboo.soft.smallrest.http.me.MeApi;
import auboo.soft.smallrest.ui.me.bean.JokeBean;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * 笑话大全获取网络数据层，M层只做网络访问、获取数据库等
 * Created by amos on 2018/7/3.
 */

public class JokeModelImpl implements IJokeModel {

    public static final String TAG = JokeModelImpl.class.getSimpleName();

    private int mPage;

    public JokeModelImpl() {
        //这里可以传递参数等数据
    }

    @Override
    public void setPage(int page) {
        this.mPage = page;
    }

    /**
     * 获取笑话大全数据信息
     *
     * @param listener 回调接口
     */
    @Override
    public void getJokeData(BaseRequestListener<JokeBean> listener) {
        BuildFactory.getInstance().create(MeApi.class, HttpConst.JUHE_DATA_URL).getJokeData(mPage, 20, HttpConst.JUHE_APP_KEY)
                .subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<JokeBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.v(TAG, "error-------->" + e.fillInStackTrace());
                        listener.onFailure();
                    }

                    @Override
                    public void onNext(JokeBean jokeBean) {
                        Log.v(TAG, "next--------->" + jokeBean.getError_code());
                        if (jokeBean.getReason().equals("Success")) {
                            listener.onSuccess(jokeBean);
                        } else {
                            listener.onFailure(jokeBean.getReason());
                        }
                    }
                });
    }
}
