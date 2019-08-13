package com.carl.study.springcloud.eurekaprovider.controller;

import cn.hutool.core.util.RandomUtil;
import com.carl.study.springcloud.projectbasic.pojo.model.Student;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

/**
 * @author changez
 * @desc
 * @datetime 2019/8/12 17:37
 */
@RestController
@RequestMapping("/student")
@Slf4j
public class StudentController {

    private final String PREFIX = "provider---";

    @GetMapping("/random-create")
    public Object randomCreateStudent(String name){

        int count = 0;
//        while (true){
//            try {
//                Thread.sleep(1000);
//                if (count++ > 14) {
//                    break;
//                }
//                log.info(Thread.currentThread().getName()+"-----count==" + count);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }

        Student student = new Student();
        student.setId(System.currentTimeMillis())
                .setName(StringUtils.isBlank(name) ? "name-" : name + "-" + RandomUtil.randomInt(20))
                .setPassword("password-" + RandomUtil.randomInt(20));
        log.info(PREFIX+"randomCreateStudent, result={}", student);
        return student;
    }

    @PostMapping("/modify")
    public Object modifyStudent(@RequestBody Student student){
        log.info(PREFIX+"into modify student={}", student);
//        try {
//            Thread.sleep(10000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        student.setName(student.getName() + "---modify"+RandomUtil.randomInt(20));
        log.info(PREFIX+"out modify student={}", student);
        return student;
    }

    @PostMapping("/modify-ip")
    public Object modifyStudentIP(@RequestBody Student student, String ip){
        log.info(PREFIX+"into modify student={}", student);
        student.setName(student.getName() + "---modify"+RandomUtil.randomInt(20));
        student.setIp(ip+"===ip-address");
        log.info(PREFIX+"out modify student={}", student);
        return student;
    }

    @GetMapping("/error-timeout")
    public Object errorTimeout(){

        try {
            log.info(PREFIX+"into errorTimeout, sleep start...");
            Thread.sleep(10_0000);
            log.info(PREFIX+"into errorTimeout, sleep end...");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new Student();
    }
}
