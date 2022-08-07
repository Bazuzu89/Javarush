package com.javarush.task.task37.task3708.retrievers;

import com.javarush.task.task37.task3708.cache.LRUCache;
import com.javarush.task.task37.task3708.storage.Storage;

public class CachingProxyRetriever implements Retriever {
    OriginalRetriever retriever;
    LRUCache<Long, Object> cache = new LRUCache<>(16);

    public CachingProxyRetriever(Storage storage) {
        retriever = new OriginalRetriever(storage);
    }


    @Override
    public Object retrieve(long id) {
        Object object = null;
        if (cache.find(id) != null) {
            object = cache.find(id);

        } else {
            object = retriever.retrieve(id);
            cache.set(id, object);
        }
        return object;
    }
}
