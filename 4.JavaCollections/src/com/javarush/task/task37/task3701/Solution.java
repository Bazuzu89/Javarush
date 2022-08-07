package com.javarush.task.task37.task3701;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.function.Consumer;

/* 
Круговой итератор
*/

public class Solution<T> extends ArrayList<T> {
    public static void main(String[] args) {
        Solution<Integer> list = new Solution<>();
        list.add(1);
        list.add(2);
        list.add(3);

        int count = 0;
        for (Integer i : list) {
            //1 2 3 1 2 3 1 2 3 1
            System.out.print(i + " ");
            count++;
            if (count == 10) {
                break;
            }
        }

        for (Integer i : list) {
            if (i == 3) {
                list.iterator().remove();
            }
        }
        for (Integer i : list) {
            //1 2 3 1 2 3 1 2 3 1
            System.out.print(i + " ");
            count++;
            if (count == 10) {
                break;
            }
        }

    }

    public Iterator<T> iterator() {
        return new RoundIterator();
    }

    public class RoundIterator implements Iterator{
        Iterator<T> iterator = Solution.super.iterator();
        int cursor;
        int lastRet = -1;

        @Override
        public boolean hasNext() {
            return size() > 0;
        }

        @Override
        public Object next() throws ConcurrentModificationException {
            int i = cursor;
            if (i >= size()) {
                i = 0;
            }
            Object[] elementData = Solution.this.toArray();
            if (i >= elementData.length) {
                throw new ConcurrentModificationException();
            }
            cursor = i + 1;
            lastRet = i;
            return (T) elementData[i];
        }

        @Override
        public void remove() {
            iterator.remove();
        }

        @Override
        public void forEachRemaining(Consumer action) {
            iterator.forEachRemaining(action);
        }
    }
}
