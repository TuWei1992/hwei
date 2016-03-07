package app.jredu.com.electronicbusinessplatform.utils;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2015/10/14 0014.
 *  StringPostRequest请求网址
 */
public class StringPostRequest extends StringRequest{

    public StringPostRequest(int method, String url, Response.Listener<String> listener,
                             Response.ErrorListener errorListener) {
        super(method, url, listener, errorListener);
        // TODO Auto-generated constructor stub
        initMap();
    }


    public StringPostRequest( String url, Response.Listener<String> listener,
                              Response.ErrorListener errorListener) {
        super(Request.Method.POST, url, listener, errorListener);
        initMap();
    }


    private Map<String,String> params;
    private void initMap(){
        params=new HashMap<String,String>();
    }

    //返回post需要提交的参数
    @Override
    protected Map<String, String> getParams() throws AuthFailureError {
        // TODO Auto-generated method stub
        return params;
    }

    public void putParams(String key,String values){
        this.params.put(key, values);
    }
}
