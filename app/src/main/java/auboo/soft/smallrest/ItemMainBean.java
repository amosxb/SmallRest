package auboo.soft.smallrest;

/**
 * Created by amos on 2018/6/27.
 */

public class ItemMainBean {

    private String content;

    public ItemMainBean(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    @Override
    public String toString() {
        return "ItemMainBean{" +
                "content='" + content + '\'' +
                '}';
    }
}
