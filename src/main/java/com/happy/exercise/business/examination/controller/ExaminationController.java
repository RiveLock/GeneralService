package com.happy.exercise.business.examination.controller;

import com.happy.exercise.business.examination.entity.Examination;
import com.happy.exercise.business.examination.entity.dto.QuestionAddDTO;
import com.happy.exercise.business.examination.service.ExaminationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 考题表 前端控制器
 * </p>
 *
 * @author John J
 * @since 2021-06-01
 */
@RestController
@RequestMapping("/examination")
public class ExaminationController {

    @Autowired
    private ExaminationService examinationService;

    @PostMapping("")
    public void add(@RequestBody QuestionAddDTO dto) {
        examinationService.add(dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer id) {
        examinationService.delete(id);
    }

    @PatchMapping("")
    public void questionMotify(@RequestBody Examination examination) {
        examinationService.questionMotify(examination);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Examination>> all() {
        return ResponseEntity.ok(examinationService.all());
    }

}
