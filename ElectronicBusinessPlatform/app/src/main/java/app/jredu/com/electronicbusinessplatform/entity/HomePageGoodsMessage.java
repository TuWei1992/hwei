package app.jredu.com.electronicbusinessplatform.entity;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by Administrator on 2015/10/15 0015.
 * 首页的商品信息
 */
@DatabaseTable(tableName = "homepage_goodsmessage_table")
public class HomePageGoodsMessage {
    @DatabaseField(id=true)
    private int id;
    @DatabaseField
    private String adPrdUrl;//点击商品图片后进入的网页
    @DatabaseField
    private String adPicUrl;//对应的图片地址

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAdPrdUrl() {
        return adPrdUrl;
    }

    public void setAdPrdUrl(String adPrdUrl) {
        this.adPrdUrl = adPrdUrl;
    }

    public String getAdPicUrl() {
        return adPicUrl;
    }

    public void setAdPicUrl(String adPicUrl) {
        this.adPicUrl = adPicUrl;
    }
}
