package netty.basic;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;

public class BytebufTest {
    public static void main(String[] args) {
        bufCURD();
    }

    private static void bufCURD() {
        ByteBuf buf= Unpooled.buffer(128);
        buf.writeBytes("i am kaixuan lu".getBytes());
        System.out.println(buf.capacity()+""+buf.readerIndex()+""+buf.writerIndex());
        System.out.println(buf.getInt(1));

    }

}
