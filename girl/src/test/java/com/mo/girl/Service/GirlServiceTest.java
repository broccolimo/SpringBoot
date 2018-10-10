package com.mo.girl.Service;

import com.mo.girl.Entity.Girl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * @author 音神
 * @date 2018/10/9 22:34
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class GirlServiceTest {

    @Autowired
    private GirlService girlService;

    @Test
    public void findOneGirlById() {
        Girl girl = girlService.findOneGirlById(14);
        Assert.assertEquals(new Integer(23), girl.getAge());
    }
}