package com.jn.demo;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandler;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.ChannelPipeline;

public class DebugHandler extends ChannelInboundHandlerAdapter {

    public void channelRegistered(ChannelHandlerContext ctx) throws Exception {
        System.out.println(">>>>> ChannelRegistered()");
    }

    /**
     * Calls {@link ChannelHandlerContext#fireChannelUnregistered()} to forward
     * to the next {@link ChannelInboundHandler} in the {@link ChannelPipeline}.
     * <p>
     * Sub-classes may override this method to change behavior.
     */
    @Override
    public void channelUnregistered(ChannelHandlerContext ctx) throws Exception {
        System.out.println(">>>>> channelUnregistered()");
    }


    /**
     * Calls {@link ChannelHandlerContext#fireChannelInactive()} to forward
     * to the next {@link ChannelInboundHandler} in the {@link ChannelPipeline}.
     * <p>
     * Sub-classes may override this method to change behavior.
     */
    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        System.out.println(">>>>> channelInactive()");
    }


    /**
     * Calls {@link ChannelHandlerContext#fireChannelReadComplete()} to forward
     * to the next {@link ChannelInboundHandler} in the {@link ChannelPipeline}.
     * <p>
     * Sub-classes may override this method to change behavior.
     */
    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        System.out.println(">>>>> channelReadComplete()");
    }

    /**
     * Calls {@link ChannelHandlerContext#fireUserEventTriggered(Object)} to forward
     * to the next {@link ChannelInboundHandler} in the {@link ChannelPipeline}.
     * <p>
     * Sub-classes may override this method to change behavior.
     */
    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
        System.out.println(">>>>>>>>>>userEventTriggered()");
    }

    /**
     * Calls {@link ChannelHandlerContext#fireChannelWritabilityChanged()} to forward
     * to the next {@link ChannelInboundHandler} in the {@link ChannelPipeline}.
     * <p>
     * Sub-classes may override this method to change behavior.
     */
    @Override
    public void channelWritabilityChanged(ChannelHandlerContext ctx) throws Exception {
        System.out.println(">>>>>>>channelWritabilityChanged()");
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg)
            throws Exception {
        System.out.println("server receive message :" + msg);
        ctx.channel().writeAndFlush("yes server already accept your message" + msg);
        ctx.channel().writeAndFlush("aswf2w3fasldfjasf" + msg);
        ctx.close();
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println(">>>>>>>>channelActive");
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        System.out.println("exception is general");
    }
}
