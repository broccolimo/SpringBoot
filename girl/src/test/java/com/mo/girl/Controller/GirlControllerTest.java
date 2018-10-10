package com.mo.girl.Controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.MockMvcAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.Assert.*;

/**
 * @author 音神
 * @date 2018/10/10 9:35
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class GirlControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    //用mvn clean package打包时 会自动执行单元测试
    //如若不想执行 用mvn clean package -Dmaven.test.skip=true
    public void getGirlList() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("/girls"))
                //期望状态码
                .andExpect(MockMvcResultMatchers.status().isOk())
                //期望内容
                .andExpect(MockMvcResultMatchers.content().string("abc"))
                ;
    }
}