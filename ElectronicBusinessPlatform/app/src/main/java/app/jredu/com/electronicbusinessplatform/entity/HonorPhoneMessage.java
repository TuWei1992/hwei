package app.jredu.com.electronicbusinessplatform.entity;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.io.Serializable;

/**
 * Created by Administrator on 2015/10/15 0015.
 * 荣耀的各种手机信息：
 */
@DatabaseTable(tableName = "honor_phone_message")
public class HonorPhoneMessage implements Serializable{
    @DatabaseField(id = true)
    private String  prdId;	//商品编号
    @DatabaseField
    private String prdUrl;	//点击商品后进入的网页
    @DatabaseField
    private String activityTime;	//活动开始时间
    @DatabaseField
    private String activityTitle;	//活动的标题
    @DatabaseField
    private String activityDescription;	//活动的详细内容
    @DatabaseField
    private int activityStatus;	//活动的状态
    @DatabaseField
    private String activityPicUrl;	//活动的展示图片
    @DatabaseField
    private String fittingPicUrl;	//下面配件的小图片
    @DatabaseField
    private int combSkuId;	//配件的水平编号
    @DatabaseField
    private String fittingTitle;	//商品的标题
    @DatabaseField
    private String fittingDescription;	//商品的详细显示

    private StarGoodsAndHonorOthersMessage othersMessage;//荣耀家族其他成员、通用配件的entity

    private int type;//决定items的类型  已知有3个类型

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public StarGoodsAndHonorOthersMessage getOthersMessage() {
        return othersMessage;
    }

    public void setOthersMessage(StarGoodsAndHonorOthersMessage othersMessage) {
        this.othersMessage = othersMessage;
    }

    public String  getPrdId() {
        return prdId;
    }

    public void setPrdId(String  prdId) {
        this.prdId = prdId;
    }

    public String getActivityTime() {
        return activityTime;
    }

    public void setActivityTime(String activityTime) {
        this.activityTime = activityTime;
    }

    public int getCombSkuId() {
        return combSkuId;
    }

    public void setCombSkuId(int combSkuId) {
        this.combSkuId = combSkuId;
    }

    public String getFittingDescription() {
        return fittingDescription;
    }

    public void setFittingDescription(String fittingDescription) {
        this.fittingDescription = fittingDescription;
    }

    public String getFittingTitle() {
        return fittingTitle;
    }

    public void setFittingTitle(String fittingTitle) {
        this.fittingTitle = fittingTitle;
    }

    public String getFittingPicUrl() {
        return fittingPicUrl;
    }

    public void setFittingPicUrl(String fittingPicUrl) {
        this.fittingPicUrl = fittingPicUrl;
    }

    public int getActivityStatus() {
        return activityStatus;
    }

    public void setActivityStatus(int activityStatus) {
        this.activityStatus = activityStatus;
    }

    public String getActivityPicUrl() {
        return activityPicUrl;
    }

    public void setActivityPicUrl(String activityPicUrl) {
        this.activityPicUrl = activityPicUrl;
    }

    public String getActivityDescription() {
        return activityDescription;
    }

    public void setActivityDescription(String activityDescription) {
        this.activityDescription = activityDescription;
    }

    public String getActivityTitle() {
        return activityTitle;
    }

    public void setActivityTitle(String activityTitle) {
        this.activityTitle = activityTitle;
    }

    public String getPrdUrl() {
        return prdUrl;
    }

    public void setPrdUrl(String prdUrl) {
        this.prdUrl = prdUrl;
    }
}
