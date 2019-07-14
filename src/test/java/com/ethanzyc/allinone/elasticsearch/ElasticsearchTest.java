package com.ethanzyc.allinone.elasticsearch;

import com.alibaba.fastjson.JSON;
import org.elasticsearch.action.DocWriteResponse;
import org.elasticsearch.action.admin.indices.create.CreateIndexRequest;
import org.elasticsearch.action.admin.indices.create.CreateIndexResponse;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequest;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.support.master.AcknowledgedResponse;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.IndicesClient;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.rest.RestStatus;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author ethan
 * @date 2019/7/14 22:10
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ElasticsearchTest {

    @Autowired
    RestHighLevelClient restHighClient;

    @Autowired
    RestClient restClient;

    //删除索引库
    @Test
    public void testDeleteIndex() throws IOException {
        //删除索引请求对象
        DeleteIndexRequest deleteIndexRequest = new DeleteIndexRequest("test_index_table"); //删除索引
        RequestOptions options = RequestOptions.DEFAULT;
        AcknowledgedResponse deleteIndexResponse = restHighClient.indices().delete(deleteIndexRequest, options); //删除索引响应结果
        boolean acknowledged = deleteIndexResponse.isAcknowledged();
        System.out.println(acknowledged);
        assert acknowledged;
    }

    //创建索引库
    @Test
    public void testCreateIndex() throws IOException {
        //创建索引请求对象，并设置索引名称
        CreateIndexRequest createIndexRequest = new CreateIndexRequest("test_index_table");
        //设置索引参数
        createIndexRequest.settings(Settings.builder().put("number_of_shards", 1)
                .put("number_of_replicas", 0));
        //设置映射
        createIndexRequest.mapping("doc", "{\n" +
                "    \"properties\": {\n" +
                "        \"description\": {\n" +
                "            \"type\": \"text\",\n" +
                "            \"analyzer\": \"ik_max_word\",\n" +
                "            \"search_analyzer\": \"ik_smart\"\n" +
                "        },\n" +
                "        \"name\": {\n" +
                "            \"type\": \"text\",\n" +
                "            \"analyzer\": \"ik_max_word\",\n" +
                "            \"search_analyzer\": \"ik_smart\"\n" +
                "        },\n" +
                "        \"pic\": {\n" +
                "            \"type\": \"text\",\n" +
                "            \"index\": false\n" +
                "        },\n" +
                "        \"price\": {\n" +
                "            \"type\": \"float\"\n" +
                "        },\n" +
                "        \"studymodel\": {\n" +
                "            \"type\": \"keyword\"\n" +
                "        },\n" +
                "        \"timestamp\": {\n" +
                "            \"type\": \"date\",\n" +
                "            \"format\": \"yyyy‐MM‐dd HH:mm:ss||yyyy‐MM‐dd||epoch_millis\"\n" +
                "        }\n" +
                "    }\n" +
                "}", XContentType.JSON);
        //创建索引操作客户端
        IndicesClient indices = restHighClient.indices();
        //创建响应对象
        CreateIndexResponse createIndexResponse = indices.create(createIndexRequest, RequestOptions.DEFAULT); //得到响应结果
        boolean acknowledged = createIndexResponse.isAcknowledged();
        System.out.println(acknowledged);
    }

    //添加文档
    @Test
    public void testAddDoc() throws IOException { //准备json数据
        Map<String, Object> jsonMap = new HashMap<>();
        jsonMap.put("name", "spring cloud实战");
        jsonMap.put("description", "本课程主要从四个章节进行讲解: 1.微服务架构入门 2.spring cloud基础入门 3.实战Spring Boot 4.注册中心eureka。");
        jsonMap.put("studymodel", "201001");
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy‐MM‐dd HH:mm:ss");
        jsonMap.put("timestamp", dateFormat.format(new Date()));
        jsonMap.put("price", 5.6f);
        //索引请求对象
        IndexRequest indexRequest = new IndexRequest("test_index_table", "doc"); //指定索引文档内容
        indexRequest.source(jsonMap);
        //索引响应对象
        IndexResponse indexResponse = restHighClient.index(indexRequest, RequestOptions.DEFAULT);
        //获取响应结果
        DocWriteResponse.Result result = indexResponse.getResult();
        System.out.println(result);
    }

    //查询文档
    @Test
    public void getDoc() throws IOException {
        GetRequest getRequest = new GetRequest(
                "test_index_table",
                "doc",
                "PwH08GsBwBBlYcBO7OAj");
        GetResponse getResponse = restHighClient.get(getRequest, RequestOptions.DEFAULT);
        boolean exists = getResponse.isExists();
        Map<String, Object> sourceAsMap = getResponse.getSourceAsMap();
        System.out.println(sourceAsMap);
    }

    //更新文档
    @Test
    public void updateDoc() throws IOException {
        UpdateRequest updateRequest = new UpdateRequest("test_index_table", "doc",
                "PwH08GsBwBBlYcBO7OAj");
//        Map<String, String> map = new HashMap<>();
//        map.put("name", "spring cloud实战1");
//        map.put("studymodel", "201002");
//        String jsonStr= JSON.toJSONString(map);
        updateRequest.doc("name", "spring cloud实战1");
        UpdateResponse update = restHighClient.update(updateRequest, RequestOptions.DEFAULT);
        RestStatus status = update.status();
        System.out.println(status);
    }

    @Test
    public void testDelDoc() throws IOException { //删除文档id
        String id = "PgHp8GsBwBBlYcBOouAU";
        //删除索引请求对象
        DeleteRequest deleteRequest = new DeleteRequest("test_index_table", "doc", id); //响应对象
        DeleteResponse deleteResponse = restHighClient.delete(deleteRequest, RequestOptions.DEFAULT); //获取响应结果
        DocWriteResponse.Result result = deleteResponse.getResult();
        System.out.println(result);
    }
}
