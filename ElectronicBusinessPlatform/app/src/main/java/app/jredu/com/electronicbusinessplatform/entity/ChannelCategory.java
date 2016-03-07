package app.jredu.com.electronicbusinessplatform.entity;

/**
 * Created by Administrator on 2015/10/14 0014.
 * 第一界面导航栏实体
 */
public class ChannelCategory {

    private int  channel_id;
    private String channel_title;

    public int getChannel_id() {
        return channel_id;
    }

    public void setChannel_id(int channel_id) {
        this.channel_id = channel_id;
    }

    public String getChannel_title() {
        return channel_title;
    }

    public void setChannel_title(String channel_title) {
        this.channel_title = channel_title;
    }

    public ChannelCategory(int channel_id, String channel_title) {
        this.channel_id = channel_id;
        this.channel_title = channel_title;
    }

    public ChannelCategory() {
        super();
    }
}
