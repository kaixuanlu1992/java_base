package netty.timeserver_3;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.concurrent.EventExecutorGroup;

import java.io.UnsupportedEncodingException;
import java.util.Date;
//用于网络事件的读写
public class TimeServerHandler extends ChannelInboundHandlerAdapter {

    public void channelRead(ChannelHandlerContext ctx,Object msg) throws UnsupportedEncodingException {
        ByteBuf buf= (ByteBuf) msg;
        byte[] req=new byte[buf.readableBytes()];//readableBytes返回可读字节数
        buf.readBytes(req);
        String body=new String(req,"utf-8");
        System.out.println("the time server receie order:"+body);
        String currentTime="query time order".equalsIgnoreCase(body)?
                new Date(System.currentTimeMillis()).toString():"bad order";
        ByteBuf resp= Unpooled.copiedBuffer(currentTime.getBytes());
        ctx.write(resp);
    }

    public void channelReadComplete(ChannelHandlerContext ctx){
        ctx.flush();
    }

    public void exceptionCaught(ChannelHandlerContext ctx,Throwable cause){
        ctx.close();
    }
}
