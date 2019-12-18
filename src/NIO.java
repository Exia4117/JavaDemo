import org.junit.Test;

import java.io.IOException;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.nio.channels.FileChannel.MapMode;

public class NIO {
    @Test
    public void directMap() throws IOException {
        long start = System.currentTimeMillis();
        FileChannel inChannel = FileChannel.open(Paths.get("test.txt"), StandardOpenOption.READ);
        FileChannel outChannel = FileChannel.open(Paths.get("test3.txt"),StandardOpenOption.READ,StandardOpenOption.WRITE,StandardOpenOption.CREATE);

        MappedByteBuffer inMap = inChannel.map(MapMode.READ_ONLY,0,inChannel.size());
        MappedByteBuffer outMap = outChannel.map(MapMode.READ_WRITE,0,inChannel.size());

        byte[] dst = new byte[inMap.limit()];
        inMap.get(dst);
        outMap.put(dst);

        inChannel.close();
        outChannel.close();

        long end = System.currentTimeMillis();
        System.out.println("Time Interval: " + (end - start) + "ms");

    }
}
