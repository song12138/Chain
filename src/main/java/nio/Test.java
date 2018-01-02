package nio;

import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.concurrent.Executors;

/**
 * Created by paul on 2017/12/19.
 */
public class Test {

    public static void main(String[] args) throws Exception {
        RandomAccessFile fromFile=new RandomAccessFile("d:/test.txt", "rw");
        RandomAccessFile toFile = new RandomAccessFile("d:/test2.txt", "rw");
        FileChannel fromChannel = fromFile.getChannel();
        FileChannel toChannel = toFile.getChannel();
        long position = 0;
        long count = fromChannel.size();
        fromChannel.transferTo(position, count, toChannel);
    }

}
