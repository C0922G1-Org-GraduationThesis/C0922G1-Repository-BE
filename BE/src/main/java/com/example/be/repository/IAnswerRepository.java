package com.example.be.repository;

import com.example.be.model.Answers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface IAnswerRepository extends JpaRepository<Answers, Long> {
    /**
     * Created by: LanTTN,
     * Date created : 30/03/2023
     * Function : find all answer
     *
     * @param questionId
     */
    @Query(value = "select * from Answers where question_id = :questionId", nativeQuery = true)
    List<Answers> findAll(@Param("questionId") Integer questionId);

    /**
     * Created by: LanTTN,
     * Date created : 30/03/2023
     * Function : save question
     *
     * @param answerContent, questionId, teacherId
     */
    @Modifying
    @Transactional
    @Query(value = "insert into answers(answer_content, question_id, teacher_id) value(:answerContent, :questionId, :teacherId)", nativeQuery = true)
    void save(@Param("answerContent") String answerContent,
              @Param("questionId") Long questionId,
              @Param("teacherId") Long teacherId);
}
