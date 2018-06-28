package auboo.soft.smallrest;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import auboo.soft.smallrest.databinding.ItemMainViewBinding;
import me.drakeet.multitype.ItemViewBinder;

/**
 * item holder
 * Created by amos on 2018/6/26.
 */

public class ItemMainHolder extends ItemViewBinder<ItemMainBean, ItemMainHolder.ViewHolder> {

    private Context context;

    public ItemMainHolder(Context context){
        this.context = context;
    }

    @NonNull
    @Override
    protected ViewHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        ItemMainViewBinding root = DataBindingUtil.inflate(inflater, R.layout.item_main_view, parent, false);
        return new ViewHolder(root);
    }

    @Override
    protected void onBindViewHolder(@NonNull ViewHolder holder, @NonNull ItemMainBean item) {
        holder.getRoot().tvName.setText(item.getContent());

        holder.getRoot().getRoot().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                JokeActivity.start(context);
            }
        });
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ItemMainViewBinding root;

        ViewHolder(ItemMainViewBinding root) {
            super(root.getRoot());
            this.root = root;
        }

        public ItemMainViewBinding getRoot() {
            return root;
        }
    }
}
