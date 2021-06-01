package com.happy.exercise.business.examination.controller;

import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 考题内容表 前端控制器
 * </p>
 *
 * @author John J
 * @since 2021-06-01
 */
@RestController
@RequestMapping("/examination-content")
public class ExaminationContentController {


    @PatchMapping("")
    public void contentMotify() {

    }


}
