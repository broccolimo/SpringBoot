package com.mo.girl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 音神
 * @date 2018/9/17 19:46
 */

//@RestController = @Controller + @ResponseBody
@RestController
@RequestMapping(value = "/hello")
public class HelloController {

    //通过注解把配置文件里边的值注进来
    //@Value("${cupSize}")
    //private String cupSize;

    //属性多的时候用@Value一个一个注不太好
    //写一个类把属性包含进去
    //注这个类即可
    @Autowired
    private GirlProperties girlProperties;

    //经测试 如果method不显式声明的话 无论那种请求方式都能请求到
    //可以使用集合
    @RequestMapping(value = "/say", method = RequestMethod.GET)
    public String say(){
        return "cupSize: " + girlProperties.getCupSize() + ", age: " + girlProperties.getAge();
    }
}
