package com.ethanzyc.allinone;

import com.mongodb.client.gridfs.GridFSBucket;
import com.mongodb.client.gridfs.GridFSDownloadStream;
import com.mongodb.client.gridfs.model.GridFSFile;
import org.apache.commons.io.IOUtils;
import org.bson.types.ObjectId;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.gridfs.GridFsResource;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import static org.springframework.core.io.ResourceLoader.CLASSPATH_URL_PREFIX;

/**
 * @author ethan
 * @date 2019/6/27 00:01
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class GridFsTest {
    @Autowired
    GridFsTemplate gridFsTemplate;

    @Autowired
    GridFSBucket gridFSBucket;

    @Test
    public void testSave() throws FileNotFoundException {
        File file = ResourceUtils.getFile(CLASSPATH_URL_PREFIX + "1234");
        FileInputStream fileInputStream = new FileInputStream(file);
        ObjectId objectId = gridFsTemplate.store(fileInputStream, "12345");
        System.out.println(objectId);
    }

    @Test
    public void queryFile() throws IOException {
        String fileId = "5d13984d2b3c8c17bdc41b7d"; //根据id查询文件
        GridFSFile gridFSFile =
                gridFsTemplate.findOne(Query.query(Criteria.where("_id").is(fileId))); //打开下载流对象
        GridFSDownloadStream gridFSDownloadStream =
                gridFSBucket.openDownloadStream(gridFSFile.getObjectId());
        //创建gridFsResource，用于获取流对象
        GridFsResource gridFsResource = new GridFsResource(gridFSFile, gridFSDownloadStream); //获取流中的数据
        String s = IOUtils.toString(gridFsResource.getInputStream(), "GBK");
        System.out.println(s);
    }

    //删除文件
    @Test
    public void testDelFile() throws IOException {
        //根据文件id删除fs.files和fs.chunks中的记录
        gridFsTemplate.delete(Query.query(Criteria.where("_id").is("5d13984d2b3c8c17bdc41b7d")));
    }
}
