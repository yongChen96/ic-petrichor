package com.petrichor.system.entity;

import com.example.common.baseclass.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableName;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author yongchen
 * @since 2020-08-21
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("t_sys_log")
@ApiModel(value="SysLog对象", description="")
public class SysLog extends BaseEntity<Long> {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "IP地址")
    @TableField("ip")
    private String ip;

    @ApiModelProperty(value = "日志类型")
    @TableField("type")
    private String type;

    @ApiModelProperty(value = "操作人")
    @TableField("user_name")
    private String userName;

    @ApiModelProperty(value = "操作描述")
    @TableField("description")
    private String description;

    @ApiModelProperty(value = "类路径")
    @TableField("class_path")
    private String classPath;

    @ApiModelProperty(value = "请求方法")
    @TableField("action_method")
    private String actionMethod;

    @ApiModelProperty(value = "请求uri")
    @TableField("uri")
    private String uri;

    @ApiModelProperty(value = "请求方法")
    @TableField("method")
    private String method;

    @ApiModelProperty(value = "开始时间")
    @TableField("start_time")
    private LocalDateTime startTime;

    @ApiModelProperty(value = "完成时间")
    @TableField("finish_time")
    private LocalDateTime finishTime;

    @ApiModelProperty(value = "浏览器")
    @TableField("ua")
    private String ua;

    @ApiModelProperty(value = "删除标识（0：否  1：是）")
    @TableField("del_state")
    private String delState;


}
