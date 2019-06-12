package com.ethanzyc.allinone.data.mongo;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author ethan
 * @date 2019/6/12 13:31
 */
@Document(collection = "student")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Student {
    @Id
    private long id;
    private String realName;
    private String nickName;
    private int age;
}
