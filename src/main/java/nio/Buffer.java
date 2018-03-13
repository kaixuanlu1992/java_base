package nio;

import java.io.PrintStream;
import java.nio.ByteBuffer;
import java.util.Arrays;

/*
nio是面向buffer的，数据从buffer沿着通道移动到另一个buffer，每个非布尔的基本类型都有一个对应得buffer对象。
buffer对象由有4个属性：capacity[容量]、position[下一个读写位置索引]、limit[第一个不能读写的位置]、mark[标记]
基本API：创建、4个属性的值返回与设置、读写转换、压缩、复制、标记与恢复、比较、批量移动
 */
public class Buffer {
    public static void main(String[] args) {
        testByteBuffer();
    }

    private static void testByteBuffer() {
        ByteBuffer buffer=testBuild();//创建缓冲区
        testCURD(buffer);//缓冲区的基本 操作
    }

    private static void testCURD(ByteBuffer buffer) {
        PrintStream out=new PrintStream(System.out);
        buffer.put((byte)116);
        buffer.put("kaixuanlu".getBytes());
        buffer.put(5,(byte)115);
        out.println("容量："+buffer.capacity()+"位置："+buffer.position()+"上限limit:"+buffer.limit());
        buffer.flip();
        //读写转换buffer.limit(buffer.position()).position(0);
        //buffer.rewind();//读写转换,但是不会改变limit值
        buffer.mark();
        buffer.get();
        buffer.get();
        buffer.compact();
        buffer.position(0);

        while (buffer.hasRemaining())//如果不flip那么position不变，从写变为读，就会读出空字符，但是不会报错；
            // 从读变为写，可能会覆盖部分字节
            out.print((char)buffer.get());
       // buffer.reset();
        out.println(Arrays.toString(buffer.array()));
    }

    //缓冲区两种创建方式：分配和包装，数据存储的位置不同
    private static ByteBuffer testBuild() {
        ByteBuffer buffer=ByteBuffer.allocate(100);
        byte[] buf=new byte[100];
        ByteBuffer buffer1=ByteBuffer.wrap(buf);
        ByteBuffer buffer2=ByteBuffer.wrap(buf,10,50);
        return buffer;
    }
}
