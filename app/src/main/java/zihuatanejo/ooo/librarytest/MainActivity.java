package zihuatanejo.ooo.librarytest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import zihuatanejo.ooo.librarytest.util.DiskCache;
import zihuatanejo.ooo.librarytest.util.ImageLoaderUtil;
import zihuatanejo.ooo.librarytest.util.MemoryCache;

public class MainActivity extends AppCompatActivity {
    ImageLoaderUtil imageLoaderUtil = new ImageLoaderUtil();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //使用内存缓存
        imageLoaderUtil.setImageCache(new MemoryCache());
        //使用SD卡缓存
        imageLoaderUtil.setImageCache(new DiskCache());
    }
}
