package app.jredu.com.electronicbusinessplatform.fragment;

import android.support.v4.app.Fragment;

/**
 * Created by Administrator on 2015/10/16 0016.
 */
public abstract  class BaseFragment extends Fragment{
    //用于表示当前fragment是否可见
    protected boolean isVisible;
    public void setUserVisibleHint(boolean isVisibleToUser) {
        // TODO Auto-generated method stub
        super.setUserVisibleHint(isVisibleToUser);
        if(isVisibleToUser){
            isVisible=true;
            lazyLoadData();
        }else{
            isVisible=false;
        }
    }

    public abstract void lazyLoadData();
}
