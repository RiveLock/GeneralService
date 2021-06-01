package com.happy.exercise.business.examination.controller;

import com.happy.exercise.business.examination.entity.UserAnswer;
import com.happy.exercise.business.examination.service.UserAnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 用户回答表 前端控制器
 * </p>
 *
 * @author John J
 * @since 2021-06-01
 */
@RestController
@RequestMapping("/user-answer")
public class UserAnswerController {

    @Autowired
    private UserAnswerService userAnswerService;

    @PutMapping("/choose")
    public ResponseEntity<String> choose(@RequestBody UserAnswer userAnswer) {
        return ResponseEntity.ok(userAnswerService.choose(userAnswer));
    }
}
