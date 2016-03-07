package app.jredu.com.electronicbusinessplatform.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

import app.jredu.com.electronicbusinessplatform.R;
import app.jredu.com.electronicbusinessplatform.entity.HonorPhoneMessage;
import app.jredu.com.electronicbusinessplatform.utils.ImageLoaderUitil;

/**
 * Created by Administrator on 2015/10/15 0015.
 */
public class HonorAdapter extends BaseAdapter{

    private List<HonorPhoneMessage> mData;
    private Context context;


    public HonorAdapter(List<HonorPhoneMessage> mData, Context context) {
        this.mData = mData;
        this.context = context;
    }

    private int count =3;

    @Override
    public int getItemViewType(int position) {

        return mData.get(position).getType();
    }

    @Override
    public int getViewTypeCount() {
        return count;
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

    public class ViewHolder{
        public ImageView activityPicUrl,fittingPicUrl,prdPicUrl,status_type;
        public TextView activityTime,activityDescription,fittingTitle,fittingDescription,
                prdName,prdDescription;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        HonorPhoneMessage honor = mData.get(position);
        int style = getItemViewType(position);
        ViewHolder viewHolder = null;

        if (convertView==null) {
            viewHolder = new ViewHolder();

            switch (style){
                case 0:
                    convertView = LayoutInflater.from(context).inflate(R.layout.honor_items1,null);
                    viewHolder.activityPicUrl = (ImageView)convertView.findViewById(R.id.activityPicUrl);
                    viewHolder.fittingPicUrl = (ImageView)convertView.findViewById(R.id.fittingPicUrl);
                    viewHolder.activityTime = (TextView)convertView.findViewById(R.id.activityTime);
                    viewHolder.activityDescription = (TextView)convertView.findViewById(R.id.activityDescription);
                    viewHolder.fittingTitle=(TextView)convertView.findViewById(R.id.fittingTitle);
                    viewHolder.fittingDescription = (TextView)convertView.findViewById(R.id.fittingDescription);
                    break;
                case 1:

                    convertView = LayoutInflater.from(context).inflate(R.layout.honor_items2,null);
                    viewHolder.prdPicUrl = (ImageView)convertView.findViewById(R.id.prdPicUrl);
                    viewHolder.status_type = (ImageView)convertView.findViewById(R.id.status_type);
                    viewHolder.prdName = (TextView)convertView.findViewById(R.id.prdName);
                    viewHolder.prdDescription = (TextView)convertView.findViewById(R.id.prdDescription);

                    break;
                case 2:
                    break;
                default:
                    break;

            }
            convertView.setTag(viewHolder);

        }else{
            viewHolder = (ViewHolder)convertView.getTag();

        }
        switch (style){
            case 0:
                viewHolder.activityTime.setText(honor.getActivityTime());
                viewHolder.activityDescription.setText(honor.getActivityDescription());
                viewHolder.fittingTitle.setText(honor.getFittingTitle());
                viewHolder.fittingDescription.setText(honor.getFittingDescription());
                ImageLoaderUitil.display(honor.getActivityPicUrl(), viewHolder.activityPicUrl);
                ImageLoaderUitil.display(honor.getFittingPicUrl(),viewHolder.fittingPicUrl);
                break;
            case 1:
                viewHolder.prdName.setText(honor.getOthersMessage().getPrdName());
                viewHolder.prdDescription.setText(honor.getOthersMessage().getPrdDescription());
                ImageLoaderUitil.display(honor.getOthersMessage().getPrdPicUrl(),viewHolder.prdPicUrl);
                break;
            case 2:
                break;
            default:
                break;
        }


        return convertView;
    }
}
