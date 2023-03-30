package com.example.be.repository;

import com.example.be.model.Question;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface IQuestionRepository extends JpaRepository<Question, Long> {
    /**
     * Created by: LanTTN,
     * Date created : 30/03/2023
     * Function : find all question
     *
     * @param pageable
     */
    @Query(value = "select * from question ", nativeQuery = true)
    Page<Question> findAllBy(Pageable pageable);

    /**
     * Created by: LanTTN,
     * Date created : 30/03/2023
     * Function : save question
     *
     * @param questionContent, questionTopic, datetime
     */
    @Modifying
    @Transactional
    @Query(value = "insert into question(question_content, question_topic, date_time) value(:questionContent, :questionTopic)", nativeQuery = true)
    void save(@Param("questionContent") String questionContent,
              @Param("questionTopic") String questionTopic);
}
