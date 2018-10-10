package com.mo.girl.Controller;

import com.mo.girl.Entity.Girl;
import com.mo.girl.Entity.Result;
import com.mo.girl.Repository.GirlRepository;
import com.mo.girl.Service.GirlService;
import com.mo.girl.Utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * @author 音神
 * @date 2018/9/18 17:14
 */

@RestController
public class GirlController {

    @Autowired
    private GirlRepository girlRepository;

    @Autowired
    private GirlService girlService;

    /**
     * 查询所有女生列表
     * @return
     */
    @GetMapping("/girls")
    public List<Girl> getGirlList(){
        return girlRepository.findAll();
    }

    /**
     * 创建一个女生
     * @return
     */
    @PostMapping("/girls")
    public Result<Girl> addGirl(@Valid Girl girl, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            //这里的异常和切面的afterReturning触发的异常是两回事
            return ResultUtil.failure(1, bindingResult.getFieldError().getDefaultMessage());
        }
        girl.setCupSize(girl.getCupSize());
        girl.setAge(girl.getAge());
        girl.setMoney(girl.getMoney());
        return ResultUtil.success(girlRepository.save(girl));
    }

    /**
     * 根据id查询一个女生
     *
     * jpa 1.11.9使用findOne(id)
     * jpa 2.0.5使用findById(id).get()
     * @param id
     * @return
     */
    @GetMapping("/girls/{id}")
    public Girl getAGirlById(@PathVariable("id") Integer id){
        return girlRepository.findById(id).get();
    }

    /**
     * 根据id更新一个女生
     *
     * @param id
     * @param cupSize
     * @param age
     * @return
     */
    @PutMapping("/girls/{id}")
    public Girl updateAGirlById(@PathVariable("id") Integer id,
                                @RequestParam("cupSize") String cupSize,
                                @RequestParam("age") Integer age){
        Girl girl = new Girl();
        girl.setId(id);
        girl.setCupSize(cupSize);
        girl.setAge(age);
        return girlRepository.save(girl);
    }

    /**
     * 根据id删除一个女生
     * @param id
     */
    @DeleteMapping("girls/{id}")
    public void deleteAGirlById(@PathVariable("id") Integer id){
        girlRepository.deleteById(id);
    }

    @GetMapping("/girls/age/{age}")
    public List<Girl> findGirlsByAge(@PathVariable("age") Integer age){
        return girlRepository.findByAge(age);
    }

    @PostMapping("/girls/addTwoGirls")
    public void addTwoGirls(){
        girlService.addTwoGirls();
    }

    @GetMapping("/girls/getAge/{id}")
    public void getAge(@PathVariable("id") Integer id) throws Exception{
        girlService.getAge(id);
    }
}
