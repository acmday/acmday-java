package com.acmday.java.server.services.impl;

import com.acmday.java.server.services.IReceiver;
import com.acmday.java.server.services.ISender;

/**
 * @author acmday.
 * @date 2020/9/18.
 */
public class ReceiverImpl implements IReceiver {
    @Override
    public void handleMessage(ISender sender, String message) {
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Receiver收到消息,消息内容为："+message);
        sender.receiverResult("消息已经处理成功，请发送下一条消息！");
    }
}
