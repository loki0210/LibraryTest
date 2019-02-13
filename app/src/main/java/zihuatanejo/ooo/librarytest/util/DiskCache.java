package zihuatanejo.ooo.librarytest.util;

import android.graphics.Bitmap;

/**
 * @author Zihuatanejo
 * @e-mail Zihuatanejo@Zihuatanejo.ooo
 * @time 2019/2/13
 */
public class DiskCache implements ImageCache {
    //SD卡缓存DiskCache类

    public DiskCache() {

    }

    @Override
    public Bitmap get(String url) {
        return null; //从本地读取该图片
    }

    @Override
    public void put(String url, Bitmap bmp) {

    }
}
