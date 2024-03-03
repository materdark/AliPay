package com.example.alipay.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.alipay.api.response.AlipayTradePagePayResponse;
import com.example.alipay.enums.PayType;
import com.example.alipay.pojo.OrderInfo;
import com.example.alipay.service.AliPayService;
import com.example.alipay.service.OrderInfoService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Service
@Slf4j
public class AliPayServiceImpl  implements AliPayService {
    @Resource
    private OrderInfoService orderInfoService;
    @Resource
    private Environment config;
    @Resource
    private AlipayClient alipayClient;
    @Transactional // 允许回滚
    @Override
    public String tradeCreate(Long productId) {
        try {
            // 1.日志记录
            log.info("生成订单");
            OrderInfo orderInfo = orderInfoService.createOrderByProductId(productId);

            // 2.构造参数 包括公共参数和接口参数
            AlipayTradePagePayRequest request = new AlipayTradePagePayRequest();
            // 支付成功之后支付宝跳转到我们商户的页面
//            request.setReturnUrl(config.getProperty("alipay.return-url"));
//            // 配置需要的公共请求参数
//            // 支付完成后，支付宝向商户发起异步通知的地址
//            request.setNotifyUrl(config.getProperty("alipay.notify-url"));
            // 组装当前业务下单所需要的参数 https://opendocs.alipay.com/open/028r8t?scene=22#%E5%93%8D%E5%BA%94%E5%8F%82%E6%95%B0_2
            JSONObject bizContent = new JSONObject();
            bizContent.put("out_trade_no", orderInfo.getOrderNo());
            BigDecimal total = new BigDecimal(orderInfo.getTotalFee().toString()).divide(new BigDecimal("100")); // 这里单位是元
            bizContent.put("total_amount", total);
            bizContent.put("subject", orderInfo.getTitle());
            bizContent.put("product_code", "FAST_INSTANT_TRADE_PAY");

            request.setBizContent(bizContent.toString());

            // 3.调用支付宝下单接口
            AlipayTradePagePayResponse response = alipayClient.pageExecute(request);
            if (response.isSuccess()) {
                log.info("调用成功，返回结果是:{}", response.getBody());
                return response.getBody();
            }
            log.info("调用失败，返回码:{}，具体信息是:{}", response.getCode(), response.getMsg());
            throw new RuntimeException();
        } catch (AlipayApiException e) {
            e.printStackTrace();
            throw new RuntimeException("创建支付交易失败");
        }
    }
}
