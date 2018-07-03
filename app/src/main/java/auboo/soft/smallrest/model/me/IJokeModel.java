package auboo.soft.smallrest.model.me;

import auboo.soft.smallrest.base.BaseRequestListener;
import auboo.soft.smallrest.ui.me.bean.JokeBean;

/**
 * model层接口
 * Created by amos on 2018/7/3.
 */

public interface IJokeModel {

    void getJokeData(BaseRequestListener<JokeBean> listener);

    void setPage(int page);
}
