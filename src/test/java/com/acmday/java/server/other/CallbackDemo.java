package com.acmday.java.server.other;

import com.acmday.java.server.component.Caller;
import com.acmday.java.server.services.ICallback;
import com.acmday.java.server.services.IReceiver;
import com.acmday.java.server.services.ISender;
import com.acmday.java.server.services.impl.ReceiverImpl;
import com.acmday.java.server.services.impl.SenderImpl;
import org.junit.jupiter.api.Test;

/**
 * @author acmday.
 * @date 2020/9/17.
 */
public class CallbackDemo {

    @Test
    void call() {
        System.out.println("_______start_______");
        new Caller(new ICallback() {
            @Override
            public void run() {
                System.out.println("Hello acmday! ");
            }
        }).doCall();
        System.out.println("_______end_______");
    }

    /**
     * 同步回调
     */
    @Test
    void callback() {
        IReceiver receiver = new ReceiverImpl();
        ISender sender = new SenderImpl(receiver);
        sender.sendMessage("发送一了一条Kafka消息，offset=100");
    }

    /**
     * 异步回调
     */
    @Test
    void asyncCallback() {

    }
}
