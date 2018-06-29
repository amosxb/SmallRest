package auboo.soft.smallrest.iview;

/**
 * view层基础接口，所有的view层类必须继承该接口
 * Created by amos on 2018/6/29.
 */

public interface IView {

    /**
     * 显示正在加载布局
     */
    void showLoading();

    /**
     * 隐藏正在加载布局
     */
    void cancelLoading();
}
