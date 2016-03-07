package app.jredu.com.electronicbusinessplatform;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Toast;

import app.jredu.com.electronicbusinessplatform.entity.HonorPhoneMessage;

public class GoodsDetailActivity extends AppCompatActivity {


    String prdId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goods_detail);
        Intent intent = super.getIntent();
        if (intent!=null) {
            prdId =intent.getStringExtra("prdId");
        //    Toast.makeText(this,prdId,Toast.LENGTH_LONG).show();

        }
        intiWebView();

        intiActionBar();

    }
    private WebView webView;
    private void intiWebView(){
        webView = (WebView)findViewById(R.id.goodsDetail);
        WebSettings webSettings = webView.getSettings();
        webSettings.setDefaultTextEncodingName("UTF-8");
        webView.loadUrl("http://mw.vmall.com/product/"+prdId+".html?prdId="+prdId+"&page=productDetail");

    }

    private ActionBar actionBar;
    private void intiActionBar(){
        actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setTitle("商品详情");

    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        if (id == android.R.id.home) {
            finish();
        }

        return super.onOptionsItemSelected(item);
    }
}
