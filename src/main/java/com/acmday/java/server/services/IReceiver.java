package com.acmday.java.server.services;

/**
 * @author acmday.
 * @date 2020/9/18.
 */
public interface IReceiver {
    void handleMessage(ISender sender, String message);
}
