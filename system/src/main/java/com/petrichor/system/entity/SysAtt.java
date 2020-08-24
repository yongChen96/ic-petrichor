package com.petrichor.system.entity;

import com.example.common.baseclass.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 附件信息表
 * </p>
 *
 * @author yongchen
 * @since 2020-08-24
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("t_sys_att")
@ApiModel(value="SysAtt对象", description="附件信息表")
public class SysAtt extends BaseEntity<String> {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "业务主键")
    @TableField("business_id")
    private String businessId;

    @ApiModelProperty(value = "附件名称")
    @TableField("att_name")
    private String attName;

    @ApiModelProperty(value = "附件存储地址")
    @TableField("att_path")
    private String attPath;

    @ApiModelProperty(value = "附件大小")
    @TableField("att_size")
    private String attSize;

    @ApiModelProperty(value = "附件后缀")
    @TableField("att_suffix")
    private String attSuffix;

    @ApiModelProperty(value = "附件类型(1:图片;2:视频;3:音频;4:文档;5:其他)")
    @TableField("att_type")
    private String attType;

    @ApiModelProperty(value = "删除标识（0：否  1：是）")
    @TableField("del_state")
    private String delState;


}
