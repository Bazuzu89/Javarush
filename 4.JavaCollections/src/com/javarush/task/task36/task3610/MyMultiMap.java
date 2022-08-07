package com.javarush.task.task36.task3610;

import java.io.Serializable;
import java.util.*;

public class MyMultiMap<K, V> extends HashMap<K, V> implements Cloneable, Serializable {
    static final long serialVersionUID = 123456789L;
    private HashMap<K, List<V>> map;
    private int repeatCount;

    public MyMultiMap(int repeatCount) {
        this.repeatCount = repeatCount;
        map = new HashMap<>();
    }

    @Override
    public int size() {
        int size = 0;
        for (List<V> list : map.values()) {
            size = size + list.size();
        }
        //напишите тут ваш код
        return size;
    }

    @Override
    public V put(K key, V value) {
        V valueToReturn;
        if (map.get(key) == null) {
            ArrayList<V> arrayListValue = new ArrayList<V>();
            map.put(key, arrayListValue);
            arrayListValue.add(value);
            valueToReturn = null;
        } else {
            List<V> keyList = map.get(key);
            if (keyList.size() == 0) {
                valueToReturn = null;
            } else {
                valueToReturn = keyList.get(keyList.size() - 1);
            }
            if (keyList.size() < repeatCount) {
                keyList.add(value);
            } else if (keyList.size() == repeatCount) {
                keyList.remove(0);
                keyList.add(value);
            }
        }
        return valueToReturn;
        //напишите тут ваш код
    }

    @Override
    public V remove(Object key) {
        V objToReturn = null;
        if (!map.containsKey(key)) {
            objToReturn = null;
        } else {
            List<V> list = map.get(key);
            if (list.size() == 0) {
                map.remove(key);
            } else {
                objToReturn = list.remove(0);
                if (list.size() == 0) {
                    map.remove(key);
                }
            }
        }
        return objToReturn;
        //напишите тут ваш код
    }

    @Override
    public Set<K> keySet() {
        return map.keySet();
        //напишите тут ваш код
    }

    @Override
    public Collection<V> values() {
        ArrayList<V> resultArrayList = new ArrayList<>();
        for (K key : map.keySet()) {
            List<V> list = map.get(key);
            if (list.size() > 0) {
                for (int i = 0; i < list.size(); i++) {
                    resultArrayList.add(list.get(i));
                }
            }
        }
        return resultArrayList;
        //напишите тут ваш код
    }

    @Override
    public boolean containsKey(Object key) {
        return map.keySet().contains(key);
        //напишите тут ваш код
    }

    @Override
    public boolean containsValue(Object value) {
        boolean containsValue = false;
        for (K key : map.keySet()) {
            List<V> list = map.get(key);
            if (list.contains(value)) {
                containsValue = true;
                break;
            }
            //напишите тут ваш код
        }
        return containsValue;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        for (Map.Entry<K, List<V>> entry : map.entrySet()) {
            sb.append(entry.getKey());
            sb.append("=");
            for (V v : entry.getValue()) {
                sb.append(v);
                sb.append(", ");
            }
        }
        String substring = sb.substring(0, sb.length() - 2);
        return substring + "}";
    }
}