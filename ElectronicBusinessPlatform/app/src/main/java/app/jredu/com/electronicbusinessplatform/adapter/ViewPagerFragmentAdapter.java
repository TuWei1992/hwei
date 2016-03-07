package app.jredu.com.electronicbusinessplatform.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

import app.jredu.com.electronicbusinessplatform.entity.ChannelCategory;

/**
 * Created by Administrator on 2015/10/14 0014.
 */
public class ViewPagerFragmentAdapter extends FragmentPagerAdapter{
    private List<Fragment> mData;
    private List<ChannelCategory> categories ;

    public ViewPagerFragmentAdapter(FragmentManager fm, List<Fragment> mData,
                                    List<ChannelCategory> categories) {
        super(fm);
        this.mData = mData;
        this.categories = categories;
    }


    @Override
    public Fragment getItem(int position) {
        return this.mData.get(position);
    }

    @Override
    public int getCount() {
        return this.mData.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return this.categories.get(position).getChannel_title();
    }
}
