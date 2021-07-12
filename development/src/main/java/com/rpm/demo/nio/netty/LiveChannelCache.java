package com.rpm.demo.nio.netty;

import io.netty.channel.Channel;
import io.netty.util.concurrent.ScheduledFuture;
/**
 * @Author Piming Ren
 * @Date 2021/3/17 16:46
 * @Version 1.0
 */
public class LiveChannelCache {


    private Channel channel;
    private ScheduledFuture scheduledFuture;

    public LiveChannelCache(Channel channel, ScheduledFuture scheduledFuture) {
        this.channel = channel;
        this.scheduledFuture = scheduledFuture;
    }

    public Channel getChannel() {
        return channel;
    }

    public void setChannel(Channel channel) {
        this.channel = channel;
    }

    public ScheduledFuture getScheduledFuture() {
        return scheduledFuture;
    }

    public void setScheduledFuture(ScheduledFuture scheduledFuture) {
        this.scheduledFuture = scheduledFuture;
    }
}
