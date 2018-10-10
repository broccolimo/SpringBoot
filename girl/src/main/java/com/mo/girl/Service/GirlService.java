package com.mo.girl.Service;

import com.mo.girl.Entity.Girl;
import com.mo.girl.Enums.ResultEnum;
import com.mo.girl.Exception.GirlException;
import com.mo.girl.Repository.GirlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * @author 音神
 * @date 2018/10/9 11:26
 */

@Service
public class GirlService {

    @Autowired
    private GirlRepository girlRepository;

    /**
     * @Transactional有2个，经测试都能用
     * 在此使用spring框架的，没用javax的
     */
    @Transactional
    public void addTwoGirls(){
        Girl girlA = new Girl();
        girlA.setAge(15);
        girlA.setCupSize("A");
        girlRepository.save(girlA);

        /**
         * 在此验证事务
         * cupSize的长度设置为1
         * 测试girlA是否能插入，若没插入，即为成功
         */
        Girl girlB = new Girl();
        girlB.setAge(18);
        girlB.setCupSize("BB");
        girlRepository.save(girlB);
    }


    /**
     * 根据id获取age, 并通过统一异常处理的方式，输出相应内容
     * @param id
     * @throws GirlException
     */
    public void getAge(Integer id) throws GirlException{
        Girl girl = girlRepository.findById(id).get();
        Integer age = girl.getAge();
        if(age < 13) throw new GirlException(ResultEnum.AGE_LEVEL_1);
        else if(age < 18) throw new GirlException(ResultEnum.AGE_LEVEL_2);
        throw new GirlException(ResultEnum.AGE_LEVEL_3);
    }

    public Girl findOneGirlById(Integer id){
        return girlRepository.findById(id).get();
    }
}
