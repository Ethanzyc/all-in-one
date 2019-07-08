package com.ethanzyc.allinone.jpa;


import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Select;
import org.springframework.data.repository.CrudRepository;

/**
 * @author ethan
 * @date 2019/7/7 00:07
 */

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete
public interface UserRepository extends CrudRepository<User, Integer> {

}
