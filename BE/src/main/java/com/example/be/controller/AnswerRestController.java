package com.example.be.controller;

import com.example.be.dto.AnswerDto;
import com.example.be.model.Answers;
import com.example.be.service.IAnswerService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/answers")
public class AnswerRestController {
    @Autowired
    private IAnswerService iAnswerService;

    /**
     * Created by: LanTTN,
     * Date created : 29/03/2023
     * Function : show answer by question_id
     *
     * @param questionId
     * @return HttpStatus.OK if result is not erroror HttpStatus.NO_CONTENT if no content
     */
    @GetMapping("")
    public ResponseEntity<?> showAnswer(@RequestParam Integer questionId) {
        List<Answers> answersList = iAnswerService.findAll(questionId);
        if (answersList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(answersList, HttpStatus.OK);
    }

    /**
     * Created by: LanTTN,
     * Date created : 29/03/2023
     * Function : create answer by id
     *
     * @param answersDto
     * @return HttpStatus.CREATED if result is not error or HttpStatus.BAD_REQUEST if result is error
     */
    @PostMapping("/save-answer")
    public ResponseEntity<?> saveAnswer(@RequestBody AnswerDto answersDto) {
        LocalDateTime localDateTime = LocalDateTime.now();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String dateTimeFormat = localDateTime.format(format);
        answersDto.setDateTime(dateTimeFormat);
        try {
            Answers answers = new Answers();
            BeanUtils.copyProperties(answersDto, answers);
            iAnswerService.save(answersDto.getAnswerContent(), answersDto.getQuestion().getQuestionId(), answersDto.getTeacher().getTeacherId());
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
