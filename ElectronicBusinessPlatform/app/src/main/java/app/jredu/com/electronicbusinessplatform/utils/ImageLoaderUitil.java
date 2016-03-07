package app.jredu.com.electronicbusinessplatform.utils;

import android.widget.ImageView;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.display.FadeInBitmapDisplayer;

import app.jredu.com.electronicbusinessplatform.R;

/**
 * Created by Administrator on 2015/10/14 0014.
 * 图片加载
 */
public class ImageLoaderUitil {
    private static DisplayImageOptions options =new DisplayImageOptions.Builder()
            //下载过程中显示的图片
            .showImageOnLoading(R.mipmap.ic_launcher)
                    //下载失败时显示的图片
            .showImageOnFail(R.mipmap.ic_launcher)
                    //uri为空的时候显示的图片
            .showImageForEmptyUri(R.mipmap.ic_launcher)
                    //是否进行内存缓存
            .cacheInMemory(true)
                    //
            .cacheOnDisk(true)
                    //
                    //bitmapConfig(Bitmap.Config.RGB_565)
            .resetViewBeforeLoading(true)
            .imageScaleType(ImageScaleType.EXACTLY_STRETCHED)
            .displayer(new FadeInBitmapDisplayer(200))
                    //RoundedBitmapDisplayer
            .build();

    //file://

    public static void display(String url,ImageView imageView){
        ImageLoader
                .getInstance().displayImage(url, imageView, options);
    }
}
