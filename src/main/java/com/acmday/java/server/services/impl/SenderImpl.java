package com.acmday.java.server.services.impl;

import com.acmday.java.server.services.IReceiver;
import com.acmday.java.server.services.ISender;

/**
 * @author acmday.
 * @date 2020/9/18.
 */
public class SenderImpl implements ISender {

    private IReceiver receiver;

    public SenderImpl(IReceiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void sendMessage(String message) {
        receiver.handleMessage(this, message);
    }

    @Override
    public void receiverResult(String message) {
        System.out.println("Sender收到回复,消息内容为：" + message);
    }
}
