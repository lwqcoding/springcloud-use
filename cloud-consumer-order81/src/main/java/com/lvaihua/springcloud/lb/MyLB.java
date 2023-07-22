package com.lvaihua.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * ClassName:MyLB
 * Package:com.lvaihua.springcloud.lb
 * Description:
 *
 * @Author 吕大帅
 * @Create 2023/7/21  16:55
 * @Version 1.0
 */
@Component
public class MyLB implements LoadBalance{

    // 定义自增长值
    private AtomicInteger atomicInteger = new AtomicInteger(0);

    // 获取访问次数
    private final int getServiceIndex(){
        int current;
        int next;

        do {
            current = this.atomicInteger.get(); // 将增长值赋给当前值
            next = current >= 2147483647 ? 0 : current + 1; // 访问次数判断
        }while (!this.atomicInteger.compareAndSet(current,next)); // 自旋锁成功为止
        System.out.println("*****第几次访问next:" + next);
        return next;
    }

    @Override
    public ServiceInstance instances(List<ServiceInstance> serviceInstances) {

        // 用公式 访问次数 % 集群总数 = 实际调用服务的下标值
        int index = getServiceIndex() % serviceInstances.size();

        return serviceInstances.get(index); // 返回被选中服务提供者实例
    }

}
