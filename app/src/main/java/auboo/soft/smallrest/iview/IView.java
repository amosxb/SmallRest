package auboo.soft.smallrest.iview;

/**
 * view层基础接口，所有的view层类必须继承该接口
 * Created by amos on 2018/6/29.
 */

public interface IView {

    /**
     * 开始请求，显示正在加载布局回调
     */
    void loadingView();

    /**
     * 显示请求成功后回调
     */
    void loadSuccessView();

    /**
     * 加载失败回调
     */
    void loadingFailure();
}
