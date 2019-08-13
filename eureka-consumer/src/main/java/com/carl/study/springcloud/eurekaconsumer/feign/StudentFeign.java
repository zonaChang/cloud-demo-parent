package com.carl.study.springcloud.eurekaconsumer.feign;

import com.carl.study.springcloud.projectbasic.pojo.model.Student;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author changez
 * @desc
 * feign调用, 参数前面不指定@RequestParam或@RequestBody时, 默认为@RequestBody
 * @datetime 2019/8/12 17:52
 */
// @FeignClient 注解中有一个primary属性,该值为true, 所以配合hystrix时, 虽然有两个StudentFeign类型的bean在ioc中, 依然可以准确注入
@FeignClient(value = "cloud-eureka-provider", fallback = StudentFeignHystrix.class)
public interface StudentFeign {

    @GetMapping("/student/random-create")
    Student generageRandomStudent(@RequestParam("name") String name);

    /**
     * post请求时, 参数前可以不加@RequestBody, 默认为@RequestBody
     * @param student
     * @return
     */
    @PostMapping("/student/modify")
    Student modifyStudent(Student student);

    /**
     * 多个参数时, 只能有一个参数添加@RequestBody(或者只能有一个参数前不加修饰) 后续的参数需要加@RequestParam参数, 否则会报错: Method has too many Body parameters
     * @param student
     * @param ip
     * @return
     */
    @PostMapping("/student/modify-ip")
    Student modifyStudent2(Student student, @RequestParam String ip);

    @GetMapping("/error-timeout")
    Student errorTimeOut();
}
