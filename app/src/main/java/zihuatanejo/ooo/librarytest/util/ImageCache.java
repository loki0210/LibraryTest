package zihuatanejo.ooo.librarytest.util;

import android.graphics.Bitmap;

/**
 * @author Zihuatanejo
 * @e-mail Zihuatanejo@Zihuatanejo.ooo
 * @time 2019/2/13
 */
public interface ImageCache {
    public Bitmap get(String url);

    public void put(String url, Bitmap bmp);
}
