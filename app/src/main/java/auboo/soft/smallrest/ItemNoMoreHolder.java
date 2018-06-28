package auboo.soft.smallrest;

import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import auboo.soft.smallrest.databinding.LoadingPullOnFinishBinding;
import me.drakeet.multitype.ItemViewBinder;

/**
 * Created by amos on 2018/6/27.
 */

public class ItemNoMoreHolder extends ItemViewBinder<String, ItemNoMoreHolder.ViewHolder> {

    @NonNull
    @Override
    protected ViewHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        LoadingPullOnFinishBinding root = DataBindingUtil.inflate(inflater, R.layout.loading_pull_on_finish, parent, false);
        return new ViewHolder(root);
    }

    @Override
    protected void onBindViewHolder(@NonNull ViewHolder holder, @NonNull String item) {

    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        LoadingPullOnFinishBinding root;

        ViewHolder(LoadingPullOnFinishBinding root) {
            super(root.getRoot());
            this.root = root;
        }

        public LoadingPullOnFinishBinding getRoot() {
            return root;
        }
    }
}
