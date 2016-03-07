package app.jredu.com.electronicbusinessplatform.utils;

import android.graphics.Bitmap;
import android.support.v4.util.LruCache;

import com.android.volley.toolbox.ImageLoader;

/**
 * Created by Administrator on 2015/10/14 0014.
 * 定义图片缓存区并实现接口
 */
public class CCImageCache implements ImageLoader.ImageCache{

    //自定义空间大小
    private int maxSize=1024*1024*10;
    //开辟内存区域，并提供算法
    private LruCache<String, Bitmap> mCache
            =new LruCache<String, Bitmap>(maxSize){

        //计算图片大小
        @Override
        protected int sizeOf(String key, Bitmap value) {
            // TODO Auto-generated method stub
            return value.getRowBytes()*value.getHeight();
        }

    };
    //取图片
    @Override
    public Bitmap getBitmap(String s) {
        return this.mCache.get(s);
    }
    //放图片
    @Override
    public void putBitmap(String s, Bitmap bitmap) {
        this.mCache.put(s,bitmap);
    }
}
