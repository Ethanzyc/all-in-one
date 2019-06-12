package com.ethanzyc.allinone.data.mongo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author ethan
 * @date 2019/6/12 13:50
 */
@Repository
public class StudentDao {
    @Autowired
    private MongoTemplate mongoTemplate;

    public Student add(Student student) {
        return mongoTemplate.insert(student);

    }

    public void update(Student student) {
        mongoTemplate.save(student);
    }

    public void delete(Long id) {
        Query query = new Query();
        query.addCriteria(Criteria.where("_id").is(id));
        mongoTemplate.remove(query, Student.class);
    }

    public Student findAuthor(Long id) {
        return mongoTemplate.findById(id, Student.class);
    }

    public List<Student> findAuthorList() {
        Query query = new Query();
        return mongoTemplate.find(query, Student.class);
    }
}
