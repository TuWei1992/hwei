package app.jredu.com.electronicbusinessplatform.db;

import java.util.ArrayList;
import java.util.List;

import app.jredu.com.electronicbusinessplatform.entity.ChannelCategory;

/**
 * Created by Administrator on 2015/10/14 0014.
 */
public class ChannelData {
    private List<ChannelCategory> list;
    public ChannelData(){
        super();
        list = new ArrayList<>();
        list.add(new ChannelCategory(0,"首页"));
        list.add(new ChannelCategory(1,"荣耀"));
        list.add(new ChannelCategory(2,"分类"));
        list.add(new ChannelCategory(3,"我的"));
    }

    public List<ChannelCategory> getChannel(){
        return list;
    }

}
