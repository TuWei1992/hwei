package app.jredu.com.electronicbusinessplatform.entity;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by Administrator on 2015/10/15 0015.
 * 点击子类后的（获取评价以及好评）
 */
@DatabaseTable(tableName = "evaluation")
public class EvaluationEntity {
    @DatabaseField(id = true)
    private int id;
    @DatabaseField
    private int percent;
    @DatabaseField
    private int times;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTimes() {
        return times;
    }

    public void setTimes(int times) {
        this.times = times;
    }

    public int getPercent() {
        return percent;
    }

    public void setPercent(int percent) {
        this.percent = percent;
    }
}
