package auboo.soft.smallrest;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.ImageView;

import com.lcodecore.tkrefreshlayout.IBottomView;

/**
 * Created by amos on 2018/6/26.
 */

public class BaiduBottomView implements IBottomView {


    private Context mContext;
    private ImageView mIv;

    public BaiduBottomView(Context context) {
        this.mContext = context;
    }

    @Override
    public View getView() {
        View view = LayoutInflater.from(mContext).inflate(R.layout.loading_pull_on, null);
        view.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));

        mIv = view.findViewById(R.id.iv_arrow);
        return view;
    }

    @Override
    public void onPullingUp(float fraction, float maxBottomHeight, float bottomHeight) {

    }

    @Override
    public void startAnim(float maxBottomHeight, float bottomHeight) {
        MyYAnimation myYAnimation = new MyYAnimation();
        myYAnimation.setRepeatCount(Animation.INFINITE);
        mIv.startAnimation(myYAnimation);
    }

    @Override
    public void onPullReleasing(float fraction, float maxBottomHeight, float bottomHeight) {

    }

    @Override
    public void onFinish() {

    }

    @Override
    public void reset() {

    }
}
