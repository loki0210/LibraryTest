package zihuatanejo.ooo.librarytest.util;

import android.graphics.Bitmap;
import android.util.LruCache;

/**
 * @author Zihuatanejo
 * @e-mail Zihuatanejo@Zihuatanejo.ooo
 * @time 2019/2/13
 */
public class MemoryCache implements ImageCache {
    private LruCache<String, Bitmap> mMemoryCache;

    public MemoryCache() {
        //初始化LRU缓存
        //其核心思想是“如果数据最近被访问过，那么将来被访问的几率也更高”
    }

    @Override
    public Bitmap get(String url) {
        return mMemoryCache.get(url);
    }

    @Override
    public void put(String url, Bitmap bmp) {
        mMemoryCache.put(url, bmp);
    }

    //SD卡缓存DiskCache类
    public class DiskCache implements ImageCache {
        @Override
        public Bitmap get(String url) {
            return null; //从本地读取该图片
        }

        @Override
        public void put(String url, Bitmap bmp) {

        }
    }
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
}
