package org.ijiangtao.tech.jsd.spring.boot.jsdspringbootstart.repository;

import org.ijiangtao.tech.jsd.spring.boot.jsdspringbootstart.model.Start;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class StartRepository {

    private static final ConcurrentMap<Integer, Start> startRepo = new ConcurrentHashMap<>();

    private static final AtomicInteger indexGenerator = new AtomicInteger();

    public Start save(Start start) {
        int indexNow=indexGenerator.getAndIncrement();
        start.setIndex(indexNow);
        return startRepo.put(indexNow, start);
    }

    public Start delete(int index){
        return startRepo.remove(index);
    }

    public List<Start> getAll() {
        Set<Integer> keySet = startRepo.keySet();
        List<Start> list = new ArrayList<>();
        for (Integer key : keySet) {
            list.add(startRepo.get(key));
        }
        return list;
    }

}
