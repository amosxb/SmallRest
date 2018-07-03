package auboo.soft.smallrest.base;

/**
 * 请求完成后的回调，通常用于v层请求完后的回调
 * Created by amos on 2018/7/3.
 */

public interface BaseRequestListener<T> {

    /**
     * 请求成功后回调
     */
    void onSuccess(T t);

    /**
     * 请求失败回调不带参数
     */
    void onFailure();

    /**
     * 请求失败后回调
     */
    void onFailure(String msg);
}
