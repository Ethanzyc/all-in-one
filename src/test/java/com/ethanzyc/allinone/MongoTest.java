package com.ethanzyc.allinone;

import com.ethanzyc.allinone.data.mongo.Student;
import com.ethanzyc.allinone.data.mongo.StudentDao;
import com.ethanzyc.allinone.thread.TestThread;
import com.mongodb.BasicDBObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationOperation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ethan
 * @date 2019/6/12 14:04
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MongoTest {
    @Autowired
    StudentDao studentDao;
    @Autowired
    MongoTemplate mongoTemplate;

    @Test
    public void testInsert() {
        Student add = studentDao.add(Student.builder().nickName("ethan1").realName("ZHUYUCHEN").age(23).build());
        System.out.println(add);
    }

    @Test
    public void testQuery2GroupBy() {
        List<AggregationOperation> operations = new ArrayList<>();
        operations.add(Aggregation.project("callTime", "apiName").andExpression("callTime").dateAsFormattedString("%Y-%m-%d").as("day"));

        operations.add(Aggregation.group(RestLog.API_NAME, "day").count().as("totalCount").max("day").as("day").first(RestLog.API_NAME).as("apiName"));
//        operations.add(Aggregation.project("callTime", "totalCount", "apiName"));
//        operations.add(Aggregation.sort(Sort.Direction.DESC, "callTime"));
        Aggregation agg = Aggregation.newAggregation(operations);
        AggregationResults<RestLogCountResponseDTO> results = mongoTemplate.aggregate(agg, RestLog.class, RestLogCountResponseDTO.class);

        List<RestLogCountResponseDTO> mappedResults = results.getMappedResults();

        System.out.println(mappedResults);
    }

}
