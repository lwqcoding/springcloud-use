package com.lvaihua.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * ClassName:CommonResp
 * Package:com.lvaihua.springcloud.entities
 * Description:
 *
 * @Author 吕大帅
 * @Create 2023/7/19  20:02
 * @Version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResp<T> {

    private Integer code;
    private String message;
    private T data;

    public CommonResp(Integer code,String message){
        this(code,message,null);
    }
}
