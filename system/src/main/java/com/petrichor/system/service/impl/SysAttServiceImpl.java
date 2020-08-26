package com.petrichor.system.service.impl;

import com.example.common.exception.BizException;
import com.github.tobato.fastdfs.domain.StorePath;
import com.petrichor.system.config.fdfs.FdfsUtil;
import com.petrichor.system.entity.SysAtt;
import com.petrichor.system.mapper.SysAttMapper;
import com.petrichor.system.service.SysAttService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.commons.io.FilenameUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;

/**
 * <p>
 * 附件信息表 服务实现类
 * </p>
 *
 * @author yongchen
 * @since 2020-08-24
 */
@Service
public class SysAttServiceImpl extends ServiceImpl<SysAttMapper, SysAtt> implements SysAttService {

    @Resource
    private FdfsUtil fdfsUtil;

    /**
     * @Author: yongchen
     * @Description: 上传单个附件
     * @Date: 9:52 2020/8/25
     * @Param: [file]
     * @return: boolean
     **/
    @Override
    public SysAtt uploadFile(MultipartFile file) {
        if (null == file){
            throw new BizException("上传附件不能为空！");
        }
        String attPath = null;
        try {
            attPath = fdfsUtil.uploadFile(file);
        } catch (IOException e) {
            throw new BizException("附件上传失败！");
        }
        String fileName = file.getOriginalFilename();
        String fileSuffix = fileName.substring(fileName.lastIndexOf("."));
        long size = file.getSize();
        SysAtt sysAtt = new SysAtt();
        sysAtt.setAttName(file.getOriginalFilename());
        sysAtt.setAttPath(attPath);
        sysAtt.setAttSuffix(fileSuffix);
        sysAtt.setAttSize(String.valueOf(size));
        sysAtt.setDelState("0");
        if (save(sysAtt)) {
            return sysAtt;
        }
        return null;
    }
}
