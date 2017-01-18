package fylder.glide.demo.listener;

/**
 * Created by fylder on 2017/1/18.
 */

public interface MyProgressListener {

    void progress(long bytesRead, long contentLength, boolean done);

}
