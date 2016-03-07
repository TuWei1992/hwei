package app.jredu.com.electronicbusinessplatform.entity;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2015/10/15 0015.
 * 分类 包括大类和子类
 */
@DatabaseTable(tableName = "secondCategorys")
public class SecondCategorys {
    @DatabaseField(id = true)
    int cid;	//ID
    @DatabaseField
    String name;	//大类的名称
    @DatabaseField
    String picUrl;	//大类的图片
    @DatabaseField
    String categoryUrl;	//点击大类显示的网页

    public SecondCategorys(int cid, String categoryUrl, String picUrl, String name) {
        this.cid = cid;
        this.categoryUrl = categoryUrl;
        this.picUrl = picUrl;
        this.name = name;
    }

    public SecondCategorys() {

    }


    private List<SecondCategorys> secondCategorysList =new ArrayList<>();

    public List<SecondCategorys> getSecondCategorysList() {
        return secondCategorysList;
    }

    public void setSecondCategorysList(List<SecondCategorys> secondCategorysList) {
        this.secondCategorysList.addAll(secondCategorysList);
    }

    public String getCategoryUrl() {
        return categoryUrl;
    }

    public void setCategoryUrl(String categoryUrl) {
        this.categoryUrl = categoryUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }
}
