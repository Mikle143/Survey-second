package ru.vdovmb.dao;

import com.querydsl.core.types.Predicate;
import com.querydsl.jpa.impl.JPAQuery;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.hibernate.Session;
import ru.vdovmb.dto.AnswerFilter;
import ru.vdovmb.entity.Answer;
import ru.vdovmb.entity.QAnswer;

import java.util.List;

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

        Predicate Predicate = QPredicate.builder()
                // Фильтрация по названию опроса
                .add(answerFilter.getSurveyName(), name -> (java.util.function.Predicate) QAnswer.answer.surveyQuestionAnswerText.surveyQuestion.survey.name.eq(name))
                // Фильтрация по тексту вопроса
                .add(answerFilter.getQuestionText(), text -> (java.util.function.Predicate) QAnswer.answer.surveyQuestionAnswerText.surveyQuestion.question.questionText.eq(text))
                // Фильтрация по тексту ответа
                //.add(answerFilter.getAnswerText(), text -> (java.util.function.Predicate) QAnswer.answer.surveyQuestionAnswerText.answerText.answerText.eq(text))
                .buildAnd();

        return new JPAQuery<>(session)
                .select(QAnswer.answer)
                .from(QAnswer.answer)
                .where(Predicate)
                .fetch();
    }

}