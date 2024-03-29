package com.ethanzyc.allinone;

import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.csource.common.NameValuePair;
import org.csource.fastdfs.*;
import org.junit.Test;
import org.springframework.core.io.ClassPathResource;

/**
 * @author ethan
 * @date 2019/7/11 07:54
 */
@Slf4j
public class FastDFSTest {

    /**
     * 上传文件
     *
     * @throws Exception
     */
    @Test
    public void testUpload() throws Exception {

        try {
            String filePath = new ClassPathResource("fastdfs-client.properties").getFile().getAbsolutePath();
            ;
            ClientGlobal.init(filePath);
            val trackerClient = new TrackerClient();
            val trackerServer = trackerClient.getConnection();
            val storageServer = trackerClient.getStoreStorage(trackerServer);
            System.out.println(storageServer);
        } catch (Exception e) {
            log.error("FastDFS Client Init Fail!", e);
        }

//        ClientGlobal.initByProperties("fastdfs-client.properties");
//        System.out.println("network_timeout=" + ClientGlobal.g_network_timeout + "ms");
//        System.out.println("charset=" + ClientGlobal.g_charset);
//        //创建客户端
//        TrackerClient tc = new TrackerClient();
//        //连接tracker Server
//        TrackerServer ts = tc.getConnection();
//        if (ts == null) {
//            System.out.println("getConnection return null");
//            return;
//        }
//        //获取一个storage server
//        StorageServer ss = tc.getStoreStorage(ts);
//        if (ss == null) {
//            System.out.println("getStoreStorage return null");
//        }
//        //创建一个storage存储客户端
//        StorageClient1 sc1 = new StorageClient1(ts, ss);
//        NameValuePair[] meta_list = null; //new NameValuePair[0];
//        String item = "/Users/ethan/Pictures/a.jpg";
//        String fileid;
//        fileid = sc1.upload_file1(item, "jpg", meta_list);
//        System.out.println("Upload local file " + item + " ok, fileid=" + fileid);
    }
}
