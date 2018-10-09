package com.mo.girl.Repository;

import com.mo.girl.Entity.Girl;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author 音神
 * @date 2018/10/8 23:24
 */

public interface GirlRepository extends JpaRepository<Girl, Integer> {
    //必须严格按这种格式来写
    List<Girl> findByAge(Integer age);
}
