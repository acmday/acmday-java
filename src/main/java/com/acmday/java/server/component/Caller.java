package com.acmday.java.server.component;

import com.acmday.java.server.services.ICallback;

/**
 * @author acmday.
 * @date 2020/9/17.
 */
public class Caller {

    private ICallback callback;

    public Caller(ICallback callback) {
        this.callback = callback;
    }

    public void doCall() {
        callback.run();
    }
}
