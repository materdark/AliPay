package com.example.alipay.service;

import com.example.alipay.enums.OrderStatus;
import com.example.alipay.pojo.OrderInfo;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author chenz
* @description 针对表【t_order_info】的数据库操作Service
* @createDate 2024-03-03 14:15:03
*/
public interface OrderInfoService extends IService<OrderInfo> {
    /**
     * 保存订单
     */
    OrderInfo createOrderByProductId(Long productId);

    /**
     * 缓存二维码
     */
    void saveCodeUrl(String orderNo, String codeUrl);

    /**
     * 查询订单列表并按照创建时间降序返回
     */
    List<OrderInfo> listOrderByCreateTimeDesc();

    /**
     * 更新订单支付状态
     */
    void updateStatusByOrderNo(String orderNo, OrderStatus orderStatus);

    /**
     * 根据订单号获取订单状态
     */
    String getOrderStatus(String orderNo);

    /**
     * 找出创建超过minutes分钟并且未支付的订单
     */
    List<OrderInfo> getNoPayOrderByDuration(int minutes, String payType);

    /**
     * 根据订单号查订单
     */
    OrderInfo getOrderByOrderNo(String orderNo);

}
