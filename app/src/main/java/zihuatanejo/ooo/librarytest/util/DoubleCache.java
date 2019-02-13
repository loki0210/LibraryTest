package zihuatanejo.ooo.librarytest.util;

import android.graphics.Bitmap;

/**
 * @author Zihuatanejo
 * @e-mail Zihuatanejo@Zihuatanejo.ooo
 * @time 2019/2/13
 */
//双缓存

public class DoubleCache implements ImageCache {
    ImageCache memoryCache = new MemoryCache();
    ImageCache mDiskCache = new DiskCache();

    //先从内存缓存获取，若是没有再从sd
    @Override
    public Bitmap get(String url) {
        Bitmap bitmap = memoryCache.get(url);
        if (bitmap == null) {
            bitmap = mDiskCache.get(url);
        }
        return bitmap;
    }

    //将图片缓存到sd卡中
    @Override
    public void put(String url, Bitmap bmp) {
        mDiskCache.put(url, bmp);
        mDiskCache.put(url, bmp);
    }
}
