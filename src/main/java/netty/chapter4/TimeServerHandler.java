package netty.chapter4;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.io.UnsupportedEncodingException;
import java.util.Date;

//用于网络事件的读写
public class TimeServerHandler extends ChannelInboundHandlerAdapter {
    private int counter;

    public void channelRead(ChannelHandlerContext ctx,Object msg) throws UnsupportedEncodingException {
        //ByteBuf buf= (ByteBuf) msg;
        //byte[] req=new byte[buf.readableBytes()];//readableBytes返回可读字节数
        //buf.readBytes(req);
        //String body=new String(req,"utf-8").substring(0,req.length-System.getProperty("line.separator").length());
        String body= (String) msg;
        System.out.println("the time server receie order:"+body+"; the counter is :"+ ++counter);
        String currentTime="query time order".equalsIgnoreCase(body)?
                new Date(System.currentTimeMillis()).toString():"bad order";
        currentTime=currentTime+System.getProperty("line.separator");
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
