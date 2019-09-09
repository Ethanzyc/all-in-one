package com.ethanzyc.allinone;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Date;

/**
 * 第三方接口调用记录
 *
 * @author ethan
 * @date 2019/8/24 14:04
 */
@Document(collection = "rest_log")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RestLog implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private String id;
    public static final String ID = "id";

    private Long groupId;
    public static final String GROUP_ID = "groupId";

    /**
     * 第三方系统名
     */
    private String system;
    public static final String SYSTEM = "system";

    /**
     * api名称
     */
    private String apiName;
    public static final String API_NAME = "apiName";

    /**
     * 路径
     */
    private String url;
    public static final String URL = "url";

    /**
     * http请求的参数
     */
    private String restParams;
    public static final String REST_PARAMS = "restParams";

    /**
     * http请求的返回结果
     */
    private String restResult;
    public static final String REST_RESULT = "restResult";

    /**
     * http状态码
     */
    private String statusCode;
    public static final String STATUS_CODE = "statusCode";

    /**
     * 消耗时间
     */
    private Long timeConsuming;
    public static final String TIME_CONSUMING = "timeConsuming";

    /**
     * 请求的时间
     */
    private Date callTime;
    public static final String CALL_TIME = "callTime";

    /**
     * 操作是否成功，不止是请求，是整个流程的
     */
    private Boolean success;
    public static final String SUCCESS = "success";

    /**
     * 调用接口方法位置
     */
    private String methodLocation;
    public static final String METHOD_LOCATION = "methodLocation";

    /**
     * 方法参数，也是重试需要用到的参数
     */
    private String retryParams;
    public static final String RETRY_PARAMS = "retryParams";

    /**
     * 备注，记录一些不影响主流程的异常
     */
    private String remark;
    public static final String REMARK = "remark";

}
