package fylder.glide.demo.listener;

import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.model.stream.StreamModelLoader;

/**
 * Created by fylder on 2017/1/18.
 */

public class MyStreamModelLoader implements StreamModelLoader<String> {

    MyProgressListener listener;

    public MyStreamModelLoader(MyProgressListener listener) {
        this.listener = listener;
    }

    @Override
    public DataFetcher getResourceFetcher(String model, int width, int height) {
        return new MyDataFetcher(model, listener);
    }
}
