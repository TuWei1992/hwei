package app.jredu.com.electronicbusinessplatform.application;

import android.app.Application;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.nostra13.universalimageloader.cache.disc.impl.UnlimitedDiskCache;
import com.nostra13.universalimageloader.cache.disc.naming.Md5FileNameGenerator;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.download.BaseImageDownloader;

import app.jredu.com.electronicbusinessplatform.utils.CCImageCache;
import app.jredu.com.electronicbusinessplatform.utils.ExectorManager;
import app.jredu.com.electronicbusinessplatform.utils.FileUitlity;

/**
 * Created by Administrator on 2015/10/14 0014.
 */
public class CCApplication extends Application{
    private static CCApplication application;
    private RequestQueue requestQueue;
    private CCImageCache mCache;

    @Override
    public void onCreate() {
        super.onCreate();
        application = this;
        requestQueue = Volley.newRequestQueue(this);

        mCache = new CCImageCache();
        //初始化Uil
        ImageLoaderConfiguration config =new ImageLoaderConfiguration.Builder(this)
                //不要缓存不同尺寸
                .denyCacheImageMultipleSizesInMemory()
                        //下载图片线程的优先级
                .threadPriority(Thread.NORM_PRIORITY-2)
                        //设置下载线程的执行器（线程池）
                .taskExecutor(ExectorManager.getInstance().getExectors())
                        //设置内存缓存的大小
                .memoryCacheSize((int)Runtime.getRuntime().maxMemory()/8)
                        //设置磁盘缓存大小
                .diskCacheSize(50*1024*1024)
                        //设置磁盘缓存文件的命名生成器
                .diskCacheFileNameGenerator(new Md5FileNameGenerator())
                        //设置磁盘缓存的路径
                .discCache(new UnlimitedDiskCache(FileUitlity.getInstance(this).makeDir("imagCache")))
                        //
                .defaultDisplayImageOptions(DisplayImageOptions.createSimple())
                        //设置具体的图片加载器：
                .imageDownloader(new BaseImageDownloader(this, 60*1000, 60*1000))
                        //生成配置信息
                .build();
        ImageLoader.getInstance().init(config);
    }

    public static CCApplication getInstance(){
        return  application;
    }

    public RequestQueue getRequestQueue(){

        return this.requestQueue;

    }
}
