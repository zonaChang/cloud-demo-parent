package com.carl.study.springcloud.eurekaconsumer.controller;

import com.carl.study.springcloud.eurekaconsumer.feign.StudentFeign;
import com.carl.study.springcloud.projectbasic.pojo.model.Student;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author changez
 * @desc
 * @datetime 2019/8/12 18:52
 */
@RestController
@RequestMapping("/student")
@Slf4j
public class StudentController {

//    @Autowired
    @Resource
    private StudentFeign studentFeign;

    @GetMapping("/generate-student")
    public Object generateStudent(String name){
        log.info("start invoke provider");
        Student student = studentFeign.generageRandomStudent(name);
        log.info("consumer----generateStudent, result={}", student);
        return student;
    }

    @PostMapping("/modify")
    public Object modifyStudent(@RequestBody Student student) {
        student = studentFeign.modifyStudent(student);
        return student;
    }

    @PostMapping("/modify-ip")
    public Object modifyStudentIP(@RequestBody Student student) {
        student = studentFeign.modifyStudent2(student, "0.0.0.0");
        return student;
    }

    @GetMapping("/error-timeout")
    public Object errorTimeOut(){
        Object obj = studentFeign.errorTimeOut();
        return obj;
    }
}
