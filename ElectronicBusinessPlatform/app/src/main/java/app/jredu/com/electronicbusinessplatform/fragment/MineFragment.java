package app.jredu.com.electronicbusinessplatform.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import app.jredu.com.electronicbusinessplatform.R;

public class MineFragment extends Fragment {
    private WebView webView;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_mine, null);
        webView = (WebView)v.findViewById(R.id.webViews);
        WebSettings webSettings = webView.getSettings();
        webSettings.setDefaultTextEncodingName("UTF-8");
    //    webView.setWebChromeClient(new WebChromeClient());//
     //   webView.setWebViewClient(new WebViewClient());//
        webView.loadUrl("http://mw.vmall.com/personal/?clientVersion=33");
        return v;
    }
}
