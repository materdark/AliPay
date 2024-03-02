package com.example.alipay.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.alipay.pojo.PaymentInfo;
import com.example.alipay.service.PaymentInfoService;
import com.example.alipay.mapper.PaymentInfoMapper;
import org.springframework.stereotype.Service;

/**
* @author chenz
* @description 针对表【t_payment_info】的数据库操作Service实现
* @createDate 2024-03-03 14:15:03
*/
@Service
public class PaymentInfoServiceImpl extends ServiceImpl<PaymentInfoMapper, PaymentInfo>
    implements PaymentInfoService{

}




