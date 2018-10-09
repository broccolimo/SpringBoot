package com.mo.girl.Controller;

import com.mo.girl.Properties.GirlProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    //@PathVariable的使用
    //这个指的是url本体里的参数 ?之前
    @RequestMapping(value = "/{id1}/sayId1/{id2}", method = RequestMethod.GET)
    public String sayId1(@PathVariable("id1") int id1, @PathVariable("id2") int id2){
        return "id1: " + id1 + ", id2: " + id2;
    }

    //@RequestParam的使用
    //这个指的是url里请求的参数 ?之后
    //int 和 Integer的区别:在没有设定是否必传以及默认值时
    //如果后边url后边只跟?id= 那么Integer会显示id=null 而int则直接返回400
    //如果连?id=都不写 那么二者都直接返回400
    @RequestMapping(value = "/sayId2", method = RequestMethod.GET)
    public String sayId2(@RequestParam(value = "id", required = false, defaultValue = "7777") int id){
        return "id: " + id;
    }

    //@PathVariable和@RequestParam一起使用
    //注意 注解括号里边的变量名和后边声明的变量名 没有任何关系
    //@GetMapping是一种组合注解，起简化作用，类似的也有@PostMapping等注解
    @GetMapping(value = "/{id1}/sayId3/{id2}")
    //@RequestMapping(value = "/{id1}/sayId3/{id2}", method = RequestMethod.GET)
    public String sayId3(@PathVariable("id1") int id2, @PathVariable("id2") int id1,
                         @RequestParam(value = "id", required = false, defaultValue = "777") int id){
        return "id1: " + id2 + ", id2: " + id1 + ", id: " + id;
    }
}
