package com.example.alipay.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * @TableName t_order_info
 */
@TableName(value ="t_order_info")
@Data
public class OrderInfo implements Serializable {
    private Long id;

    private String title;//订单标题

    private String orderNo;//商户订单编号

    private Long userId;//用户id

    private Long productId;//支付产品id

    private Integer totalFee;//订单金额(分)

    private String codeUrl;//订单二维码连接

    private String orderStatus;//订单状态

    private Date createTime;//建立时间

    private Date updateTime;//更新时间


    private static final long serialVersionUID = 1L;
}