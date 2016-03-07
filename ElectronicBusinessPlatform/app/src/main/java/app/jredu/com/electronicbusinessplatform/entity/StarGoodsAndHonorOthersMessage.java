package app.jredu.com.electronicbusinessplatform.entity;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by Administrator on 2015/10/15 0015.
 * 首页的明星商品栏目：
 * 荣耀家族其他成员
 * 通用配件
 */
@DatabaseTable(tableName = "star_honorother_commonFitting")
public class StarGoodsAndHonorOthersMessage {
    @DatabaseField(id = true)
    private String prdId;	//商品id
    @DatabaseField
    private String  skuId;	//商品的skuId
    @DatabaseField
    private String prdName;	//商品名称
    @DatabaseField
    private String prdPicUrl;	//商品图片Url
    @DatabaseField
    private String prdDescription;	//商品简介
    @DatabaseField
    private String prdUnitPrice;	//商品价格
    @DatabaseField
    private int prdStatus;	//商品的状态
    @DatabaseField
    private int isDisplayPrice;	//商品价格是否显示（1:显示；0：不显示）


    public int getIsDisplayPrice() {
        return isDisplayPrice;
    }

    public void setIsDisplayPrice(int isDisplayPrice) {
        this.isDisplayPrice = isDisplayPrice;
    }

    public String getPrdId() {
        return prdId;
    }

    public void setPrdId(String prdId) {
        this.prdId = prdId;
    }

    public String getSkuId() {
        return skuId;
    }

    public void setSkuId(String skuId) {
        this.skuId = skuId;
    }

    public String getPrdPicUrl() {
        return prdPicUrl;
    }

    public void setPrdPicUrl(String prdPicUrl) {
        this.prdPicUrl = prdPicUrl;
    }

    public int getPrdStatus() {
        return prdStatus;
    }

    public void setPrdStatus(int prdStatus) {
        this.prdStatus = prdStatus;
    }

    public String getPrdUnitPrice() {
        return prdUnitPrice;
    }

    public void setPrdUnitPrice(String prdUnitPrice) {
        this.prdUnitPrice = prdUnitPrice;
    }

    public String getPrdDescription() {
        return prdDescription;
    }

    public void setPrdDescription(String prdDescription) {
        this.prdDescription = prdDescription;
    }

    public String getPrdName() {
        return prdName;
    }

    public void setPrdName(String prdName) {
        this.prdName = prdName;
    }
}
