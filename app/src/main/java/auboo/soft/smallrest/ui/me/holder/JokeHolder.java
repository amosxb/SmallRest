package auboo.soft.smallrest.ui.me.holder;

import android.content.Context;
import android.support.annotation.NonNull;

import auboo.soft.smallrest.R;
import auboo.soft.smallrest.base.BaseHolder;
import auboo.soft.smallrest.databinding.ItemJokeViewBinding;
import auboo.soft.smallrest.ui.me.bean.JokeBean;

/**
 * 笑话大全holder类
 * Created by amos on 2018/7/3.
 */

public class JokeHolder extends BaseHolder<JokeBean.ResultBean.DataBean, ItemJokeViewBinding> {

    public JokeHolder(Context context) {
        super(context);
    }

    @Override
    protected int itemResId() {
        return R.layout.item_joke_view;
    }

    @Override
    protected void onBindViewHolder1(@NonNull ViewHolder<ItemJokeViewBinding> holder, @NonNull JokeBean.ResultBean.DataBean item) {
        holder.getBinding().tvContent.setText(item.getContent());
        holder.getBinding().tvTime.setText(item.getUpdatetime());
    }
}
