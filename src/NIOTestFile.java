//import java.lang.reflect.Array;
//import java.util.ArrayList;
//import java.util.Deque;
//import java.util.ArrayDeque;;

// 本题为考试多行输入输出规范示例，无需提交，不计分。

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Pattern;

public class NIOTestFile {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String content = sc.next();
        //正则表达式，用于匹配非数字串，+号用于匹配出多个非数字串
        String regEx = "[^0-9]+";
        Pattern pattern = Pattern.compile(regEx);
        //用定义好的正则表达式拆分字符串，，把字符串中的数字留出来
        String[] cs = pattern.split(content);
        System.out.println(Arrays.toString(cs));

    }

    @Test
    public void test() {
        FileInputStream fis = null;
        FileOutputStream fos = null;
        FileChannel inChannel = null;
        FileChannel outChannel = null;

        try {
            fis = new FileInputStream("test.txt");
            fos = new FileOutputStream("test2.txt");

            inChannel = fis.getChannel();
            outChannel = fos.getChannel();

            ByteBuffer buf = ByteBuffer.allocate(1024);
            int read = 0;
            while ((read = inChannel.read(buf)) != -1) {
                buf.flip();
                outChannel.write(buf);
                buf.clear();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (inChannel != null) {
                try {
                    inChannel.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (outChannel != null) {
                try {
                    outChannel.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
