package netty.chapter4;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.util.logging.Logger;

public class TimeClientHandler extends ChannelInboundHandlerAdapter {

    private static final Logger logger = Logger
            .getLogger(TimeClientHandler.class.getName());
    private int counter;
    private byte[] req;

    /**
     * Creates a client-side handler.
     */
    public TimeClientHandler() {
        req = ("QUERY TIME ORDER"+System.getProperty("line.separator")).getBytes();
    }

    /*
     * 当客户端和服务端TCP链路简历成功之后,Netty的NIO线路会调用channelActive方法,发送查询时间的指令给服务器
     */
    @Override
    public void channelActive(ChannelHandlerContext ctx) {
        ByteBuf message=null;
        for (int i=0;i<100;i++){
            message=Unpooled.buffer(req.length);
            message.writeBytes(req);
            ctx.writeAndFlush(message);// 调用 writeAndFlush 方法将请求消息发送给服务端
        }
    }

    /**
     * 当服务端返回应答消息时,channelRead 方法被调用
     */
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg)
            throws Exception {

       /* ByteBuf buf = (ByteBuf) msg;
        byte[] req = new byte[buf.readableBytes()];
        buf.readBytes(req);
        String body = new String(req, "UTF-8");*/
        String body= (String) msg;
        System.out.println("Now is : " + body+"; the counter is :"+ ++counter);
    }

    /**
     * 发生异常时，打印异常日志，释放客户端资源
     */
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        // 当发生异常时，打印异常日志，释放客户端资源
        logger.warning("Unexpected exception from downstream : "
                + cause.getMessage());
        ctx.close();
    }
}