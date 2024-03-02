package com.example.alipay.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * @TableName t_payment_info
 */
@TableName(value ="t_payment_info")
@Data
public class PaymentInfo implements Serializable {
    private Long id;

    private String orderNo;

    private String transactionId;

    private String paymentType;

    private String tradeType;

    private String tradeState;

    private Integer payerTotal;

    private String content;

    private Date createTime;

    private Date updateTime;

    private static final long serialVersionUID = 1L;
}