package d.com.androidjs;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by wangwei on 2017/12/26.
 * 懒加载   主要是让数据在该Fragment可见的时候加载
 * initViews（）初始化View
 * initData();加载网络数据  该方法在fragment可见的时候调用
 */

public abstract class LazyFragment extends Fragment {

    private boolean isFragmentVisible;//是否可见状态
    private boolean isPrepared;//标志位，View已经初始化完成。
    private boolean isFirstLoad = true;//是否第一次加载

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = initViews(inflater, container, savedInstanceState);
        Log.w("TAG", "------->onCreateView--");
        isPrepared = true;
        isFirstLoad = true;
        lazyLoad();
        return view;
    }

    /**
     * 如果是与ViewPager一起使用，调用的是setUserVisibleHint
     *
     * @param isVisibleToUser 是否显示出来了
     */
    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (getUserVisibleHint()) {
            Log.w("TAG", "------->isVisibleToUser----" + getUserVisibleHint());
            isFragmentVisible = true;
            lazyLoad();
        } else {
            isFragmentVisible = false;
        }
    }

    /**
     * 如果是通过FragmentTransaction的show和hide的方法来控制显示，调用的是onHiddenChanged.
     * 若是初始就show的Fragment 为了触发该事件 需要先hide再show
     *
     * @param hidden hidden True if the fragment is now hidden, false if it is not
     *               visible.
     */
    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        if (!hidden) {
            isFragmentVisible = true;
            lazyLoad();
        } else {
            isFragmentVisible = false;
        }
    }

    /**
     * 要实现延迟加载Fragment内容
     */
    protected void lazyLoad() {
        if (isPrepared && isFragmentVisible) {
            if (isFirstLoad) {
                isFirstLoad = false;
                Log.w("TAG", "------->initData----");
                initData();
            }
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        isPrepared = false;
        isFragmentVisible = false;
        isFirstLoad = false;
        Log.w("TAG", "----onDestroy--->");
    }

    protected abstract View initViews(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState);

    protected abstract void initData();

}
