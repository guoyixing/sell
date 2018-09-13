package com.gyx.service.impl;

import com.gyx.dataobject.Id;
import com.gyx.dataobject.OrderDetail;
import com.gyx.repository.IdRepository;
import com.gyx.service.IdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * 商品service
 *
 * @author gyx
 * @date 2018-05-29 10:50
 * @since 1.0.0
 */
@Service
public class IdServiceImpl implements IdService {
    @Autowired
    private IdRepository idRepository;
    @Autowired
    private ThreadPoolTaskExecutor taskExecutor;

    @Override
    public void save() {

        List<Id> list = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            Id id = new Id();
            id.setId(i);
            list.add(id);
        }
        long l = System.currentTimeMillis();
        for (int j = 0; j < 10; j++) {
            taskExecutor.execute(() -> idRepository.save(list));
        }
        long time = System.currentTimeMillis() - l;
        System.out.println(time);
    }

}
