package zihuatanejo.ooo.librarytest.util;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.ImageView;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

/**
 * @author Zihuatanejo
 * @e-mail Zihuatanejo@Zihuatanejo.ooo
 * @time 2019/2/12
 */
public class ImageLoaderUtil {
    //图片缓存
    private ImageCache mImageCache = new MemoryCache();
    //线程池，线程数为cpu数量
    private ExecutorService executorService = Executors.newFixedThreadPool
            (Runtime.getRuntime().availableProcessors());

    //注入缓存实现
    public void setImageCache(ImageCache cache) {
        mImageCache = cache;
    }

    public void displayImage(String imgUrl, ImageView imageView) {
        Bitmap bitmap = mImageCache.get(imgUrl);
        if (bitmap != null) {
            imageView.setImageBitmap(bitmap);
            return;
        }
        //图片没缓存，提交线程池中下载图片
        submitLoadRequest(imgUrl, imageView);
    }

    private void submitLoadRequest(final String imageUrl, final ImageView imageView) {
        imageView.setTag(imageUrl);
        executorService.submit(new Runnable() {
            @Override
            public void run() {
                Bitmap bitmap = downLoadImage(imageUrl);
                if (bitmap == null) {
                    return;
                }
                if (imageView.getTag().equals(imageUrl)) {
                    imageView.setImageBitmap(bitmap);
                }
                mImageCache.put(imageUrl, bitmap);
            }
        });
    }

    private Bitmap downLoadImage(String imageUrl) {
        Bitmap bitmap = null;
        try {
            URL url = new URL(imageUrl);
            final HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            bitmap = BitmapFactory.decodeStream(connection.getInputStream());
            connection.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bitmap;
    }
}
