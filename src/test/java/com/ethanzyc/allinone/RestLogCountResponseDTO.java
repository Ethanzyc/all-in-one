package com.ethanzyc.allinone;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 接口调用统计
 *
 * @author ethan
 * @date 2019/8/24 17:36
 */
@Data
public class RestLogCountResponseDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 调用时间
     */
    private Date callTime;

    private String day;

    /**
     * 接口名称
     */
    private String apiName;

    /**
     * 调用数
     */
    private Integer totalCount;

    /**
     * 成功数
     */
    private Integer successCount;

    /**
     * 失败数
     */
    private Integer failCount;

    /**
     * 成功率
     */
    private BigDecimal successRate;

    /**
     * 接口类型
     */
    private Integer type;
    /**
     * 同步方法
     */
    private String method;

}
