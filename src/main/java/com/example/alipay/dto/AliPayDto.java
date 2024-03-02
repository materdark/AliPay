package com.example.alipay.dto;

import lombok.Data;

@Data
public class AliPayDto {
    private String traceNo;
    private double totalAmount;
    private String subject;
    private String alipayTraceNo;
}
