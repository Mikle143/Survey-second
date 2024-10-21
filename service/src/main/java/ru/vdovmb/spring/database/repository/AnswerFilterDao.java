package ru.vdovmb.spring.database.repository;

import com.querydsl.core.types.Predicate;
import com.querydsl.jpa.impl.JPAQuery;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import ru.vdovmb.spring.database.dto.AnswerFilter;
import ru.vdovmb.spring.database.entity.Answer;
import ru.vdovmb.spring.database.entity.QAnswer;

import java.util.List;

@Repository
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class AnswerFilterDao {

    private static final AnswerFilterDao INSTANCE = new AnswerFilterDao();

    public static AnswerFilterDao getInstance() {
        return INSTANCE;
    }

    public List<Answer> findAll(Session session) {
        return new JPAQuery<Answer>(session)
                .select(QAnswer.answer)
                .from(QAnswer.answer)
                .fetch();
    }

    public List<Answer> findAnswer(Session session, AnswerFilter answerFilter) {


        Predicate predicate = QPredicate.builder()
                // Фильтрация по названию опроса
                .add(answerFilter.getSurveyName(), name -> (Predicate) QAnswer.answer.surveyQuestionAnswerText.surveyQuestion.survey.name.eq(name))
                // Фильтрация по тексту вопроса
                .add(answerFilter.getQuestionText(), text -> (Predicate) QAnswer.answer.surveyQuestionAnswerText.surveyQuestion.question.questionText.eq(text))
                // Фильтрация по тексту ответа
                //.add(answerFilter.getAnswerText(), text -> QAnswer.answer.surveyQuestionAnswerText.answerText.eq(text))
                .buildAnd();

        return new JPAQuery<>(session)
                .select(QAnswer.answer)
                .from(QAnswer.answer)
                .where(predicate)
                .fetch();
    }
}
