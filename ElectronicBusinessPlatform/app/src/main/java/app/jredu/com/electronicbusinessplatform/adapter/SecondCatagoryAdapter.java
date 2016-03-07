package app.jredu.com.electronicbusinessplatform.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import app.jredu.com.electronicbusinessplatform.R;
import app.jredu.com.electronicbusinessplatform.entity.SecondCategorys;
import app.jredu.com.electronicbusinessplatform.utils.ImageLoaderUitil;

/**
 * Created by Administrator on 2015/10/20 0020.
 */
public class SecondCatagoryAdapter extends BaseAdapter{

    private List<SecondCategorys> mData;
    private Context mContext;

    public SecondCatagoryAdapter(List<SecondCategorys> mData, Context mContext) {
        this.mData = mData;
        this.mContext = mContext;
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public Object getItem(int position) {
        return mData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public class  ViewHolder{
        private TextView name;
        private ImageView picUrl;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (convertView==null) {
            viewHolder = new ViewHolder();
            convertView = LayoutInflater.from(mContext)
                    .inflate(R.layout.secondcategory_item,null);
            viewHolder.name = (TextView)convertView.findViewById(R.id.secondName);
            viewHolder.picUrl = (ImageView)convertView.findViewById(R.id.secondImage);

            convertView.setTag(viewHolder);

        }else{
            viewHolder = (ViewHolder)convertView.getTag();
        }

        SecondCategorys categorys = mData.get(position);
        viewHolder.name.setText(categorys.getName());
        ImageLoaderUitil.display(categorys.getPicUrl(),viewHolder.picUrl);

        return convertView;
    }
}
