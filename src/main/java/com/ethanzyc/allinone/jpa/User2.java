package com.ethanzyc.allinone.jpa;

import lombok.*;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @author ethan
 * @Entity This tells Hibernate to make a table out of this class
 * @date 2019/7/7 00:06
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User2 implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer age;

    private String userName;

    private String userEmail;


}
