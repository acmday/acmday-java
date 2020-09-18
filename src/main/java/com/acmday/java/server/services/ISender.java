package com.acmday.java.server.services;

/**
 * @author acmday.
 * @date 2020/9/18.
 */
public interface ISender {

    void sendMessage(String message);

    void receiverResult(String message);
}
