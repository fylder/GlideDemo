package fylder.glide.demo.listener;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Response;

/**
 * Created by fylder on 2017/1/18.
 */

public class MyProgressInterceptor implements Interceptor {

    MyProgressListener listener;

    public MyProgressInterceptor(MyProgressListener listener) {
        this.listener = listener;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Response originalResponse = chain.proceed(chain.request());
        return originalResponse.newBuilder().body(new MyProgressResponseBody(originalResponse.body(), listener)).build();
    }
}
