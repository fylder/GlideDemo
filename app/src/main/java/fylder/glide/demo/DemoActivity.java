package fylder.glide.demo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import fylder.glide.demo.listener.MyProgressListener;
import fylder.glide.demo.listener.MyStreamModelLoader;

public class DemoActivity extends AppCompatActivity {

    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo);
        init();
    }

    void init() {
        imageView = (ImageView) findViewById(R.id.demo_img);

        String url = "http://fylder.me/img/header.jpg";
        Glide.with(this)
                .using(new MyStreamModelLoader(new MyProgressListener() {
                    @Override
                    public void progress(long bytesRead, long contentLength, boolean done) {
                        int p = (int) (100 * bytesRead / contentLength);
                        Log.w("fylder", String.format("%d%%", p));
                    }
                }))
                .load(url)
                .dontAnimate()
                .skipMemoryCache(true)
                .diskCacheStrategy(DiskCacheStrategy.NONE)
                .error(R.mipmap.ic_launcher)
                .into(imageView);
    }


}
