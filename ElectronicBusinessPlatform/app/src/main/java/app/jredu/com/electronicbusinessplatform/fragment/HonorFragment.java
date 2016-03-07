package app.jredu.com.electronicbusinessplatform.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ListView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import android.os.Handler;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import app.jredu.com.electronicbusinessplatform.GoodsDetailActivity;
import app.jredu.com.electronicbusinessplatform.R;
import app.jredu.com.electronicbusinessplatform.adapter.HonorAdapter;
import app.jredu.com.electronicbusinessplatform.application.CCApplication;
import app.jredu.com.electronicbusinessplatform.entity.HonorPhoneMessage;

import app.jredu.com.electronicbusinessplatform.util.UtilInfo;

public class HonorFragment extends Fragment
        implements PullToRefreshBase.OnRefreshListener2<ListView>,
        AdapterView.OnItemClickListener, AbsListView.OnScrollListener, View.OnClickListener {

    private View view;
    private PullToRefreshListView mListView;
    private List<HonorPhoneMessage> mList;
    private HonorAdapter adapter;
    private ImageButton backToTop;



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.mList = new ArrayList<>();
        this.adapter = new HonorAdapter(mList, getActivity());


    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_honor, null);
        mListView = (PullToRefreshListView) view.findViewById(R.id.mListView);
        backToTop = (ImageButton) view.findViewById(R.id.backToTop);
        backToTop.setOnClickListener(this);
        intiloadDate();
        intiHeadView();
        mListView.setAdapter(adapter);

        mListView.setMode(PullToRefreshBase.Mode.PULL_FROM_START);
        mListView.setOnRefreshListener(this);
        mListView.setOnItemClickListener(this);
        mListView.setOnScrollListener(this);


        return view;
    }


    String prdId = "";
    private void intiloadDate() {

        mListView.setRefreshing();
        StringRequest request = new StringRequest(
                UtilInfo.HONOR_UTIL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String s) {
                        mListView.onRefreshComplete();
                        try {
                            JSONObject jsonObject = new JSONObject(s);
                            JSONObject jsonObject1 = jsonObject.getJSONObject("result");
                            JSONArray jsonArray = jsonObject1.getJSONArray("activityPrds");
                            for (int i = 0; i < jsonArray.length(); i++) {
                                JSONObject item = jsonArray.getJSONObject(i);
                                prdId = item.getString("prdId");
                                String activityTitle = item.getString("activityTitle");
                                String prdUrl = item.getString("prdUrl");
                                String activityPicUrl = item.getString("activityPicUrl");
                                String fittingPicUrl = item.getString("fittingPicUrl");
                                String activityTime = item.getString("activityTime");
                                String activityDescription = item.getString("activityDescription");
                                String fittingTitle = item.getString("fittingTitle");
                                String fittingDescription = item.getString("fittingDescription");

                                HonorPhoneMessage honor = new HonorPhoneMessage();


                                honor.setActivityDescription(activityDescription);
                                honor.setActivityPicUrl(activityPicUrl);
                                honor.setActivityTime(activityTime);
                                honor.setActivityTitle(activityTitle);

                                honor.setFittingDescription(fittingDescription);
                                honor.setFittingPicUrl(fittingPicUrl);
                                honor.setFittingTitle(fittingTitle);

                                honor.setPrdId(prdId);
                                honor.setPrdUrl(prdUrl);
                                //   mList.clear();
                                mList.add(honor);
                                adapter.notifyDataSetChanged();
                            }



                        } catch (JSONException e) {
                            e.printStackTrace();
                        }


                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                Toast.makeText(getActivity(), "网络连接失败，请检查自己的网络设置", Toast.LENGTH_SHORT).show();

            }
        });

        CCApplication.getInstance().getRequestQueue().add(request);

    }

    private ListView lvNews;

    private void intiHeadView() {
        lvNews = mListView.getRefreshableView();
        view = LayoutInflater.from(getActivity()).inflate(R.layout.honor_head_view, null);
        lvNews.addHeaderView(view);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        HonorPhoneMessage honorPhoneMessage = mList.get(position-2);
        Intent intent = new Intent(getActivity(), GoodsDetailActivity.class);
        intent.putExtra("prdId",honorPhoneMessage.getPrdId());
        startActivity(intent);


    }

    @Override
    public void onPullDownToRefresh(PullToRefreshBase<ListView> refreshView) {

    }

    @Override
    public void onPullUpToRefresh(PullToRefreshBase<ListView> refreshView) {

    }

    @Override
    public void onScrollStateChanged(AbsListView view, int scrollState) {

    }


    @Override
    public void onScroll(AbsListView view, int firstVisibleItem,
                         int visibleItemCount, int totalItemCount) {
        backToTop.setVisibility(View.VISIBLE);
        if (firstVisibleItem == 0) {
            backToTop.setVisibility(View.GONE);
        }

    }


    //返回顶部
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.backToTop:
                lvNews.setSelection(0);
                break;
        }
    }
}
