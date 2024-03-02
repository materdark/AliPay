/*
 * @author yangjiewei
 * @date 2022/8/17 22:02
 */
package com.example.alipay.utils;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.HashMap;
import java.util.Map;

@Data
@Accessors(chain = true) // 当该值为 true 时，对应字段的 setter 方法调用后，会返回当前对象
public class Result {

    /**
     * 响应码 响应消息 数据
     */
    private Integer code;
    private String message;
    private Map<String, Object> data = new HashMap<>();

    public static Result ok(){
        Result result = new Result();
        result.setCode(0);
        result.setMessage("成功");
        return result;
    }

    public static Result error(){
        Result result = new Result();
        result.setCode(-1);
        result.setMessage("失败");
        return result;
    }

    public Result data(String key, Object value){
        this.data.put(key, value);
        return this;
    }
}
