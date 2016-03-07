package app.jredu.com.electronicbusinessplatform.entity;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by Administrator on 2015/10/15 0015.
 * 点击子类后的
 */
@DatabaseTable(tableName = "checksubclass")
public class CheckSubclass {
    @DatabaseField(id = true)
    int prdId;	//商品的编号
    @DatabaseField
    String prdPath;	//商品的Url路径
    @DatabaseField
    String name;	//商品的名称
    @DatabaseField
    float price;	//商品价格
    @DatabaseField
    String promPrice;	//不知道，猜测为折扣价
    @DatabaseField
    String picUrl;	//图片的地址
    @DatabaseField
    float scoreAverage;	//评分
    @DatabaseField
    int priceMode;
    @DatabaseField
    int skuId;
    @DatabaseField
    String promotionWord;
    @DatabaseField
    boolean prom;
    @DatabaseField
    boolean isInventoryEnough;
    @DatabaseField
    int prdStatus;

    public int getPrdId() {
        return prdId;
    }

    public void setPrdId(int prdId) {
        this.prdId = prdId;
    }

    public int getPrdStatus() {
        return prdStatus;
    }

    public void setPrdStatus(int prdStatus) {
        this.prdStatus = prdStatus;
    }

    public boolean isInventoryEnough() {
        return isInventoryEnough;
    }

    public void setIsInventoryEnough(boolean isInventoryEnough) {
        this.isInventoryEnough = isInventoryEnough;
    }

    public boolean isProm() {
        return prom;
    }

    public void setProm(boolean prom) {
        this.prom = prom;
    }

    public String getPromotionWord() {
        return promotionWord;
    }

    public void setPromotionWord(String promotionWord) {
        this.promotionWord = promotionWord;
    }

    public int getSkuId() {
        return skuId;
    }

    public void setSkuId(int skuId) {
        this.skuId = skuId;
    }

    public int getPriceMode() {
        return priceMode;
    }

    public void setPriceMode(int priceMode) {
        this.priceMode = priceMode;
    }

    public float getScoreAverage() {
        return scoreAverage;
    }

    public void setScoreAverage(float scoreAverage) {
        this.scoreAverage = scoreAverage;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public String getPromPrice() {
        return promPrice;
    }

    public void setPromPrice(String promPrice) {
        this.promPrice = promPrice;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrdPath() {
        return prdPath;
    }

    public void setPrdPath(String prdPath) {
        this.prdPath = prdPath;
    }
}
