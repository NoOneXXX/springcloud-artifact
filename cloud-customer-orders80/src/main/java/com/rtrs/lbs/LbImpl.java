package com.rtrs.lbs;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Component
public class LbImpl implements ILoabBalances{

    private AtomicInteger atomicInteger = new AtomicInteger(0);

    /***
     * 这个接口的调用不是很理解
     * 后面的controller调用的时候 读取自己主机的网络适配器是错的
     * 这个我不想去调整了 如果你的机子安装了虚拟机 那么虚拟机会自动的给你安装一个网络适配器
     * 这个网络适配器被虚拟机改了 自己调整我还没有找可以调整的地方
     * @return
     */
    public final int getAndIncreament(){
        int current;
        int next;
        do{
            current = this.atomicInteger.get();
            next = current > 2147483647 ? 0 :current + 1;
        }while (!this.atomicInteger.compareAndSet(current, next));
        System.out.println("****what time to view, counter next****:" + next);
        return next;
    }

    @Override
    public ServiceInstance instances(List<ServiceInstance> isntances) {
        int index = getAndIncreament() % isntances.size();
        return isntances.get(index);
    }
}
