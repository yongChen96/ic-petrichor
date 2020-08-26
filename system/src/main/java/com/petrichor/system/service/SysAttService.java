package com.petrichor.system.service;

import com.petrichor.system.entity.SysAtt;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.web.multipart.MultipartFile;

/**
 * <p>
 * 附件信息表 服务类
 * </p>
 *
 * @author yongchen
 * @since 2020-08-24
 */
public interface SysAttService extends IService<SysAtt> {

    /**
     * @Author: yongchen
     * @Description: 上传单个附件
     * @Date: 9:52 2020/8/25
     * @Param: [file]
     * @return: SysAtt
     **/
    SysAtt uploadFile(MultipartFile file);

}
