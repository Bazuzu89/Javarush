package com.javarush.task.task37.task3707;

import java.util.*;
import java.io.*;

public class AmigoSet<E> extends AbstractSet<E> implements Serializable, Cloneable, Set<E> {
    private static final Object PRESENT = new Object();
    private transient HashMap<E, Object> map;


    public AmigoSet() {
        this.map = new HashMap<>();
    }

    public AmigoSet(Collection<? extends E> collection) {
        int capacity = (int) Math.ceil(Math.max(16, collection.size() / .75f));
        this.map = new HashMap<>(capacity);
        this.addAll(collection);
    }



    @Override
    public Iterator<E> iterator() {
        return map.keySet().iterator();
    }

    @Override
    public int size() {
        return map.size();
    }

    public boolean add(E e)  {
        if (map.put(e, PRESENT) != null) {
            return false;
        }
        return true;
    }

    public boolean isEmpty() {
        return map.isEmpty();
    }

    public boolean contains(Object o) {
        return map.keySet().contains(o);
    }

    public void clear() {
        map.clear();
    }

    public boolean remove(Object o) {
        return map.keySet().remove(o);
    }



    public AmigoSet<E> clone() throws InternalError {
        try {
            AmigoSet<E> newAmigoSet = (AmigoSet<E>) super.clone();
            newAmigoSet.map = (HashMap<E, Object>) this.map.clone();
            return newAmigoSet;
        } catch (Exception e) {
            throw new InternalError();
        }
    }

    private void writeObject(ObjectOutputStream oos) throws IOException {
        oos.defaultWriteObject();
        int capacity = HashMapReflectionHelper.callHiddenMethod(map, "capacity");
       float loadFactor = HashMapReflectionHelper.callHiddenMethod(map, "loadFactor");
       oos.writeInt(capacity);
       oos.writeFloat(loadFactor);
       oos.writeInt(map.size());
       for (E element : map.keySet()) {
           oos.writeObject(element);
       }
    }

    private void readObject(ObjectInputStream ois) throws ClassNotFoundException, IOException {
        ois.defaultReadObject();
        int capacity = ois.readInt();
        float loadFactor = ois.readFloat();
        map = new HashMap<>(capacity, loadFactor);
        int size = ois.readInt();
        for (int i = 0; i < size; i++) {
            map.put((E) ois.readObject(), PRESENT);
        }
    }

    /* @Override
    public boolean equals(Object o) {
        AmigoSet<E> set = (AmigoSet<E>) o;

        return this.map.keySet().equals(set.map.keySet());
    } */
}
