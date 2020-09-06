package com.acmday.java.server.collection;

import org.junit.jupiter.api.Test;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author acmday.
 * @date 2020/8/31.
 */
public class MapDemo {

    @Test
    public void hTable() {
        Hashtable<String, String> hashtable = new Hashtable<>();
        hashtable.put(null, null);
    }

    @Test
    public void conMap() {
        ConcurrentHashMap hMap = new ConcurrentHashMap<>();
        hMap.put("1", "1");
        hMap.get("1");
    }

    @Test
    public void hMap() {
        Map<String, String> map = new HashMap<>(8);
        map.put(null, null);
    }
}
