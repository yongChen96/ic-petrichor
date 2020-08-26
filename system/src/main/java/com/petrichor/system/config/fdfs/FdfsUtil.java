package com.petrichor.system.config.fdfs;

import com.github.tobato.fastdfs.conn.FdfsWebServer;
import com.github.tobato.fastdfs.domain.StorePath;
import com.github.tobato.fastdfs.exception.FdfsUnsupportStorePathException;
import com.github.tobato.fastdfs.proto.storage.DownloadByteArray;
import com.github.tobato.fastdfs.service.FastFileStorageClient;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.*;
import java.nio.charset.Charset;

/**
 * @ClassName: FdfsUtil
 * @Description: 文件上传工具类
 * @Author: yongchen
 * @Date: 2020/8/25 10:00
 **/
@Component
public class FdfsUtil {

    @Resource
    private FastFileStorageClient storageClient;
    @Resource
    private FdfsWebServer fdfsWebServer;

    /**
     * MultipartFile类型的文件上传ַ
     * @param file 文件对象
     * @return 文件访问地址
     * @throws IOException
     */
    public String uploadFile(MultipartFile file) throws IOException {
        StorePath storePath = storageClient.uploadFile(file.getInputStream(),file.getSize(), FilenameUtils.getExtension(file.getOriginalFilename()),null);
        return getResAccessUrl(storePath);
    }

    /**
     * 普通的文件上传
     * @param file 文件对象
     * @return 文件访问地址
     * @throws IOException
     */
    public String uploadFile(File file) throws FileNotFoundException {
        FileInputStream inputStream = new FileInputStream (file);
        StorePath storePath = storageClient.uploadFile(inputStream,file.length(), FilenameUtils.getExtension(file.getName()),null);
        return getResAccessUrl(storePath);
    }

    /**
     * 带输入流形式的文件上传
     *
     * @param is
     * @param size
     * @param fileName
     * @return
     */
    public String uploadFileStream(InputStream is, long size, String fileName) {
        StorePath path = storageClient.uploadFile(is, size, fileName, null);
        return getResAccessUrl(path);
    }

    /**
     * 将一段字符串生成一个文件上传
     * @param content 文件内容
     * @param fileExtension
     * @return 文件访问地址
     */
    public String uploadFile(String content, String fileExtension) {
        byte[] buff = content.getBytes(Charset.forName("UTF-8"));
        ByteArrayInputStream stream = new ByteArrayInputStream(buff);
        StorePath storePath = storageClient.uploadFile(stream,buff.length, fileExtension,null);
        return getResAccessUrl(storePath);
    }

    /**
     * 封装图片完整URL地址
     * @Param: [storePath]
     * @return: java.lang.String
     **/
    private String getResAccessUrl(StorePath storePath) {
        String fileUrl = fdfsWebServer.getWebServerUrl() + "/" + storePath.getFullPath();
        return fileUrl;
    }

    /**
     * 下载文件
     * @param fileUrl 文件url
     * @return
     */
    public byte[]  download(String fileUrl) {
        String group = fileUrl.substring(0, fileUrl.indexOf("/"));
        String path = fileUrl.substring(fileUrl.indexOf("/") + 1);
        byte[] bytes = storageClient.downloadFile(group, path, new DownloadByteArray());
        return bytes;
    }

    /**
     * 删除文件
     * @param fileUrl 文件访问地址
     * @return
     */
    public void deleteFile(String fileUrl) {
        if (StringUtils.isEmpty(fileUrl)) {
            return;
        }
        try {
            StorePath storePath = StorePath.praseFromUrl(fileUrl);
            storageClient.deleteFile(storePath.getGroup(), storePath.getPath());
        } catch (FdfsUnsupportStorePathException e) {
            e.getMessage();
        }
    }

}
