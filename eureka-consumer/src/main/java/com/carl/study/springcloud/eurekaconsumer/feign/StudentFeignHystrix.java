package com.carl.study.springcloud.eurekaconsumer.feign;

import com.carl.study.springcloud.projectbasic.pojo.model.Student;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author changez
 * @desc StudentFeign
 * @datetime 2019/8/12 20:16
 */
@Component
@Slf4j
public class StudentFeignHystrix implements StudentFeign {
    @Override
    public Student generageRandomStudent(String name) {
        log.error("error---generageRandomStudent======111111");
        return null;
    }

    @Override
    public Student modifyStudent(Student student) {
        log.error("error---modifyStudent======222222");
        return null;
    }

    @Override
    public Student modifyStudent2(Student student, String ip) {
        log.error("error---modifyStudent2======33333");
        return null;
    }

    @Override
    public Student errorTimeOut() {
        log.error("error---errorTimeOut======444444");
        return new Student().setName("error---");
    }
}
