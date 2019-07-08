package com.ethanzyc.allinone.jpa;

import lombok.Data;
import lombok.ToString;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

/**
 * @author ethan
 * @Entity This tells Hibernate to make a table out of this class
 * @date 2019/7/7 00:06
 */

@Entity(name = "user_info")
@ToString
@Data
@EntityListeners(AuditingEntityListener.class)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;

    private String email;

    /**
     * @CreatedBy/@CreatedDate/@LastModifiedDate/@LastModifiedBy: 作用是在这个对象对数据库有插入更新的时候更新时间和操作人，
     * 需要配置的有：
     * 1.实体类加 @EntityListeners(AuditingEntityListener.class)
     * 2.启动类 @EnableJpaAuditing
     * 3.JpaConfig 类中的 getCurrentAuditor 方法：用来返回更新人
     * <p>
     * 总结：更新时间可以在数据库用 DEFAULT CURRENT_TIMESTAMP，但需要
     */
    @CreatedDate
    @Column(updatable = false, nullable = false)
    private Date createdDate;

    @CreatedBy
    @Column(updatable = false, nullable = false)
    private Integer createdBy;

    @LastModifiedDate
    @Column(nullable = false)
    private Date lastModifiedDate;

    @LastModifiedBy
    @Column(nullable = false)
    private Integer lastModifiedBy;

}
