package com.example.common.baseclass;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.groups.Default;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @ClassName: BaseEntity
 * @Description: 公共父类
 * @Author: yongchen
 * @Date: 2020/8/5 11:39
 **/
@Data
public class BaseEntity<T> implements Serializable, Cloneable {
    private static final long serialVersionUID = -8813694495536208357L;

    public static final String ID = "id";
    public static final String CREATE_TIME = "create_time";
    public static final String CREATE_USER = "create_user";
    public static final String UPDATE_TIME = "update_time";
    public static final String UPDATE_USER = "update_user";

    @TableId(value = "id", type = IdType.ASSIGN_UUID)
    @ApiModelProperty("主键")
    @NotNull(message = "id不能为空", groups = {BaseEntity.Update.class})
    protected T id;

    @ApiModelProperty("创建时间")
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    protected LocalDateTime createTime;

    @ApiModelProperty("创建人ID")
    @TableField(value = "create_user", fill = FieldFill.INSERT)
    protected T createUser;

    @ApiModelProperty("最后修改时间")
    @TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE)
    protected LocalDateTime updateTime;

    @ApiModelProperty("最后修改人ID")
    @TableField(value = "update_user", fill = FieldFill.INSERT_UPDATE)
    protected T updateUser;

    public BaseEntity() {
    }

    public BaseEntity(T id, LocalDateTime createTime, T createUser, LocalDateTime updateTime, T updateUser) {
        this.id = id;
        this.createTime = createTime;
        this.createUser = createUser;
        this.updateTime = updateTime;
        this.updateUser = updateUser;
    }

    public interface Update extends Default {}
    public interface Save extends Default {}
}
