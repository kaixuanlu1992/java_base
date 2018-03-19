package netty.msgpack;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageDecoder;
import org.msgpack.MessagePack;

import java.util.List;

public class MsgpackDecoder extends MessageToMessageDecoder<ByteBuf> {

    @Override
    protected void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) throws Exception {
        final byte[] array;
        final int length=byteBuf.readableBytes();
        array=new byte[length];
        byteBuf.getBytes(byteBuf.readerIndex(),array,0,length);
        MessagePack msgpack=new MessagePack();
        //使用MessagePack反序列化并将解码后的对象加入到解码列表中
        list.add(msgpack.read(array));
    }
}
