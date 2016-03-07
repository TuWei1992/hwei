package app.jredu.com.electronicbusinessplatform.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import app.jredu.com.electronicbusinessplatform.R;
import app.jredu.com.electronicbusinessplatform.adapter.SecondCatagoryAdapter;
import app.jredu.com.electronicbusinessplatform.application.CCApplication;
import app.jredu.com.electronicbusinessplatform.entity.SecondCategorys;
import app.jredu.com.electronicbusinessplatform.util.UtilInfo;

public class ClassifyFragment extends Fragment {


    private RadioGroup rdGp;
    private List<SecondCategorys> mList;
    private List<SecondCategorys> listViewList;
    private ListView listView;
    private SecondCatagoryAdapter adapter;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mList = new ArrayList<>();

    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_classify,null);
        getChannelCategory();
        listViewList=new ArrayList<>();
        rdGp = (RadioGroup)v.findViewById(R.id.rdGp);
        listView = (ListView)v.findViewById(R.id.mListView);
        adapter = new SecondCatagoryAdapter(listViewList,getActivity());
        listView.setAdapter(adapter);


        return v;

    }

    private void getChannelCategory(){
        StringRequest stringRequest = new StringRequest(
                UtilInfo.CLASSIFY_UIL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String s) {
                        try {
                            JSONObject jsonObject =new JSONObject(s);
                            JSONArray jsonArray = jsonObject.getJSONArray("appCategoryList");
                            for(int i=0;i<jsonArray.length();i++){
                                JSONObject item = jsonArray.getJSONObject(i);
                                String name = item.getString("name");
                                //int id = item.getInt("cid");
                                SecondCategorys categorys = new SecondCategorys();
                                categorys.setName(name);
                                JSONArray jsonArray1 = item.getJSONArray("secondCategorys");
                                List<SecondCategorys> list = new ArrayList<>();
                                for (int j=0;j<jsonArray1.length();j++){
                                    JSONObject items = jsonArray1.getJSONObject(j);
                                    String names = items.getString("name");
                                    String picUrl = items.getString("picUrl");
                                    String categoryUrl = items.getString("categoryUrl");
                                    int cid = items.getInt("cid");
                                    list.add(new SecondCategorys(cid,categoryUrl,picUrl,names));
                                }


                                categorys.setSecondCategorysList(list);
                                mList.add(categorys);


                            }
                            listViewList.addAll(mList.get(0).getSecondCategorysList());
                            adapter.notifyDataSetChanged();
                            intiGadioButton();
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }


                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                Toast.makeText(getActivity(),"网络连接失败，请检查网络设置",Toast.LENGTH_SHORT).show();
            }
        }
        );

        CCApplication.getInstance().getRequestQueue().add(stringRequest);

    }
    private void intiGadioButton(){
        rdGp.removeAllViews();
        for(int i=0;i<mList.size();i++){
           RadioButton rgbtn =
                   (RadioButton)LayoutInflater.from(getActivity()).inflate(R.layout.rdbtn, null);
            rgbtn.setId(i);
            rgbtn.setText(mList.get(i).getName());
            rdGp.addView(rgbtn);

        }
        rdGp.check(0);
        rdGp.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                listViewList.clear();
                listViewList.addAll(mList.get(checkedId).getSecondCategorysList());
                adapter.notifyDataSetChanged();
            }
        });


    }


}
