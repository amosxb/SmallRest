package auboo.soft.smallrest.iview.me;

import auboo.soft.smallrest.iview.IView;
import auboo.soft.smallrest.ui.me.bean.JokeBean;

/**
 * 游戏人生view层接口
 * Created by amos on 2018/6/29.
 */

public interface IJokeView extends IView {

    /**
     * 接口返回数据
     * */
    void refreshAdapter(JokeBean jokeBean);
}
