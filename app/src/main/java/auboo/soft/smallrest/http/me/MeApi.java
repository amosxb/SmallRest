package auboo.soft.smallrest.http.me;

import auboo.soft.smallrest.constant.HttpConst;
import auboo.soft.smallrest.ui.me.bean.JokeBean;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * 我的模块api
 * Created by amos on 2018/7/3.
 */

public interface MeApi {

    @GET("joke/content/text.php")
    Observable<JokeBean> getJokeData(@Query("page") int page, @Query("pagesize") int pagesize, @Query("key") String key);
}
