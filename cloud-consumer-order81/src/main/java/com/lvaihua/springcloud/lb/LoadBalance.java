package com.lvaihua.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * ClassName:LoadBaance
 * Package:com.lvaihua.springcloud.lb
 * Description:
 *
 * @Author 吕大帅
 * @Create 2023/7/21  16:52
 * @Version 1.0
 */
public interface LoadBalance {

    // 获取服务实例
    ServiceInstance instances(List<ServiceInstance> serviceInstances);
}
