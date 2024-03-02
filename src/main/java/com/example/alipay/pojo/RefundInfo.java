package com.example.alipay.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * @TableName t_refund_info
 */
@TableName(value ="t_refund_info")
@Data
public class RefundInfo implements Serializable {
    private Long id;

    private String orderNo;

    private String refundNo;

    private String refundId;

    private Integer totalFee;

    private Integer refund;

    private String reason;

    private String refundStatus;

    private String contentReturn;

    private String contentNotify;

    private Date createTime;

    private Date updateTime;

    private static final long serialVersionUID = 1L;
}