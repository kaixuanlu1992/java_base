package netty.msgpack;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

public class EchoClientHandler extends ChannelInboundHandlerAdapter {

    private final int sendNumber;

    /**
     * Creates a client-side handler.
     */
    public EchoClientHandler(int sendNumber) {
        this.sendNumber=sendNumber;
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) {
        UserInfo[] infos=UserInfo();
        for (UserInfo infoE:infos){
            ctx.write(infoE);
        }
        ctx.flush();
    }

    private UserInfo[] UserInfo() {
        UserInfo[] userInfos=new UserInfo[sendNumber];
        UserInfo userInfo=null;
        for (int i=0;i<sendNumber;i++){
            userInfo=new UserInfo();
            userInfo.setAge(i);
            userInfo.setName("ABCDEFG---->"+i);
            userInfos[i]=userInfo;
        }
        return userInfos;
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        System.out.println("Client receive the msgpack message:"+msg);
        ctx.write(msg);
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) {
        ctx.flush();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        // Close the connection when an exception is raised.
        cause.printStackTrace();
        ctx.close();
    }
}
