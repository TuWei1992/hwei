package app.jredu.com.electronicbusinessplatform;


import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.BaseAdapter;

import com.astuetz.PagerSlidingTabStrip;

import java.util.ArrayList;
import java.util.List;

import app.jredu.com.electronicbusinessplatform.actity.BaseActivity;
import app.jredu.com.electronicbusinessplatform.adapter.ViewPagerFragmentAdapter;
import app.jredu.com.electronicbusinessplatform.db.ChannelData;
import app.jredu.com.electronicbusinessplatform.entity.ChannelCategory;
import app.jredu.com.electronicbusinessplatform.fragment.ClassifyFragment;
import app.jredu.com.electronicbusinessplatform.fragment.HomePagerFragment;
import app.jredu.com.electronicbusinessplatform.fragment.HonorFragment;
import app.jredu.com.electronicbusinessplatform.fragment.MineFragment;
/**
 *主Activity
 */

public class MainActivity extends BaseActivity {

    private PagerSlidingTabStrip tabs;

    private ViewPager viewPager;

    private List<ChannelCategory> channelCategories = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tabs = (PagerSlidingTabStrip)findViewById(R.id.tabs);
        viewPager = (ViewPager)findViewById(R.id.viewPager);
        getChannelData();
        intiViewPager();

    }

    private ChannelData channelData;
    private void getChannelData() {
        channelData = new ChannelData();
        channelCategories.addAll(channelData.getChannel());
    }

    private void intiViewPager(){
        List<Fragment> fragments = new ArrayList<>();
        fragments.add(new HomePagerFragment());
        fragments.add(new HonorFragment());
        fragments.add(new ClassifyFragment());
        fragments.add(new MineFragment());

        ViewPagerFragmentAdapter adapter =
                new ViewPagerFragmentAdapter(getSupportFragmentManager(),fragments,channelCategories);
        viewPager.setAdapter(adapter);
        tabs.setViewPager(viewPager);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
