package auboo.soft.smallrest.http;

import com.example.http.HttpUtils;

/**
 * 工具类
 * Created by amos on 2018/7/3.
 */

public class BuildFactory {

    private static BuildFactory instance;

    public static BuildFactory getInstance() {
        if (instance == null) {
            synchronized (com.example.http.utils.BuildFactory.class) {
                if (instance == null) {
                    instance = new BuildFactory();
                }
            }
        }
        return instance;
    }

    public <T> T create(Class<T> a, String type) {
        return HttpUtils.getInstance().getBuilder(type).build().create(a);
    }
}
