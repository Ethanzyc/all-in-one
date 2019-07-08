package com.ethanzyc.allinone.jpa;


import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

/**
 * @author ethan
 * @date 2019/7/7 00:07
 */

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete
@Mapper
public interface UserMapper {

    @Select("select * from user_info")
    Page<User> getUser();
}
