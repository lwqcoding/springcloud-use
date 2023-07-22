package com.lvaihua.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * ClassName:Payment
 * Package:com.lvaihua.springcloud.entities
 * Description:
 *
 * @Author 吕大帅
 * @Create 2023/7/19  20:01
 * @Version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payment implements Serializable {

    private Long id;
    private String serial;

}
