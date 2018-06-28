package auboo.soft.smallrest;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;

/**
 * description:	获取屏幕的尺寸
 * User: shaobing
 * Date: 2016/6/13
 * Time: 11:11
 */
public class DisplayMetricsUtil 
{
	
	public void DisplayMetricsUtil(Activity context)
	{
        DisplayMetrics metric = new DisplayMetrics();
        context.getWindowManager().getDefaultDisplay().getMetrics(metric);
        int width = metric.widthPixels;  // 屏幕宽度（像素）
        int height = metric.heightPixels;  // 屏幕高度（像素）
        float density = metric.density;  // 屏幕密度（0.75 / 1.0 / 1.5）
        int densityDpi = metric.densityDpi;  // 屏幕密度DPI（120 / 160 / 240）
	}
	
	/**
	 *获取屏幕的像素宽度
	 * @param context
	 * @return
	 */
	public static int getDisplayWidth(Context context)
	{
        DisplayMetrics metric = new DisplayMetrics();
		((Activity)context).getWindowManager().getDefaultDisplay().getMetrics(metric);
        int width = metric.widthPixels;  // 屏幕宽度（像素）
        return width;
	}

	public static float getDensity(Context context){
		DisplayMetrics metric = new DisplayMetrics();
		((Activity)context).getWindowManager().getDefaultDisplay().getMetrics(metric);
		return metric.density;
	}

	/**
	 * 获取屏幕像素的高度
	 * @param context
	 * @return
	 */
	public static int getDisplayHeight(Context context)
	{
        DisplayMetrics metric = new DisplayMetrics();
		((Activity)context).getWindowManager().getDefaultDisplay().getMetrics(metric);
        int height = metric.heightPixels;  // 屏幕高度（像素）
        return height;
	}

	/**
	 * 获取状态栏高度
	 *
	 * @param context context
	 * @return 状态栏高度
	 */
	public static int getStatusBarHeight(Context context) {
		// 获得状态栏高度
		int resourceId = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
		return context.getResources().getDimensionPixelSize(resourceId);
	}

	/**
	 * 根据手机的分辨率从 dp 的单位 转成为 px(像素)
	 */
	public static int dip2px(Context context, float dpValue) {
		final float scale = context.getResources().getDisplayMetrics().density;
		return (int) (dpValue * scale + 0.5f);
	}

	/**
	 * 根据手机的分辨率从 px(像素) 的单位 转成为 dp
	 */
	public static int px2dip(Context context, float pxValue) {
		final float scale = context.getResources().getDisplayMetrics().density;
		return (int) (pxValue / scale + 0.5f);
	}

	public int dpToPixels(Context context, float dp) {
		float scale =   context.getResources().getDisplayMetrics().density;
		return (int) (dp * scale + 0.5f);
	}
}
