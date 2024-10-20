package ru.vdovmb.dao;

import lombok.Cleanup;
import lombok.experimental.UtilityClass;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import ru.vdovmb.entity.Answer;
import ru.vdovmb.entity.AnswerText;
import ru.vdovmb.entity.Question;
import ru.vdovmb.entity.Role;
import ru.vdovmb.entity.Survey;
import ru.vdovmb.entity.SurveyQuestion;
import ru.vdovmb.entity.SurveyQuestionAnswerText;
import ru.vdovmb.entity.User;

@UtilityClass
public class TestDataImporter {

    public void importData(SessionFactory sessionFactory) {
        @Cleanup Session session = sessionFactory.openSession();

        Survey survey1 = saveSurvey(session, "Survey1");
        Survey survey2 = saveSurvey(session, "Survey2");
        Question question1 = saveQuestion(session, "1Question", 1);
        Question question2 = saveQuestion(session, "2Question", 1);
        Question question5 = saveQuestion(session, "5Question", 1);
        SurveyQuestion surveyQuestion1 = saveSurveyQuestion(session, survey1, question1);
        SurveyQuestion surveyQuestion2 = saveSurveyQuestion(session, survey1, question2);
        SurveyQuestion surveyQuestion3 = saveSurveyQuestion(session, survey1, question5);
        AnswerText answerText1 = saveAnswerText(session, "aText1");
        AnswerText answerText2 = saveAnswerText(session, "aText2");
        AnswerText answerText3 = saveAnswerText(session, "aText3");
        SurveyQuestionAnswerText surveyQuestionAnswerText1 = saveSurveyQuestionAnswerText(session, surveyQuestion1, answerText1);
        SurveyQuestionAnswerText surveyQuestionAnswerText2 = saveSurveyQuestionAnswerText(session, surveyQuestion1, answerText2);
        SurveyQuestionAnswerText surveyQuestionAnswerText3 = saveSurveyQuestionAnswerText(session, surveyQuestion2, answerText1);
        SurveyQuestionAnswerText surveyQuestionAnswerText4 = saveSurveyQuestionAnswerText(session, surveyQuestion2, answerText2);
        SurveyQuestionAnswerText surveyQuestionAnswerText5 = saveSurveyQuestionAnswerText(session, surveyQuestion3, answerText1);
        SurveyQuestionAnswerText surveyQuestionAnswerText6 = saveSurveyQuestionAnswerText(session, surveyQuestion3, answerText2);
        SurveyQuestionAnswerText surveyQuestionAnswerText7 = saveSurveyQuestionAnswerText(session, surveyQuestion3, answerText3);
        User user1 = saveUser(session, "name1", "login1", "password1", Role.GUEST);
        User user2 = saveUser(session, "name2", "login2", "password2", Role.ADMIN);
        Answer answer1 = saveAnswer(session, surveyQuestionAnswerText1, user1);
        Answer answer2 = saveAnswer(session, surveyQuestionAnswerText3, user1);
        Answer answer3 = saveAnswer(session, surveyQuestionAnswerText1, user2);
        Answer answer4 = saveAnswer(session, surveyQuestionAnswerText4, user2);
        Answer answer5 = saveAnswer(session, surveyQuestionAnswerText2, user2);
    }

    private static Answer saveAnswer(Session session, SurveyQuestionAnswerText surveyQuestionAnswerText, User user) {
        Answer answer = Answer.builder()
                .surveyQuestionAnswerText(surveyQuestionAnswerText)
                .user(user)
                .build();
        session.save(answer);
        return answer;
    }

    private static User saveUser(Session session, String name, String login, String password, Role role) {
        User user = User.builder()
                .name(name)
                .login(login)
                .password(password)
                .role(role)
                .build();
        session.save(user);
        return user;
    }

    private static SurveyQuestionAnswerText saveSurveyQuestionAnswerText(Session session, SurveyQuestion surveyQuestion1, AnswerText answerText) {
        SurveyQuestionAnswerText surveyQuestionAnswerText = SurveyQuestionAnswerText.builder()
                .surveyQuestion(surveyQuestion1)
                .answerText(answerText)
                .build();
        session.save(surveyQuestionAnswerText);
        return surveyQuestionAnswerText;
    }

    private static AnswerText saveAnswerText(Session session, String aText) {
        AnswerText answerText = AnswerText.builder()
                .answerText(aText)
                .build();
        session.save(answerText);
        return answerText;
    }

    private static SurveyQuestion saveSurveyQuestion(Session session, Survey survey, Question question) {
        SurveyQuestion surveyQuestion = SurveyQuestion.builder()
                .survey(survey)
                .question(question)
                .build();
        session.save(surveyQuestion);
        return surveyQuestion;
    }

    private static Question saveQuestion(Session session, String q_text, Integer answerNumber) {
        Question question = Question.builder()
                .questionText(q_text)
                .answersNumber(answerNumber)
                .build();
        session.save(question);
        return question;
    }

    private static Survey saveSurvey(Session session, String surveyName) {
        Survey survey = Survey.builder()
                .name(surveyName)
                .build();
        session.save(survey);
        return survey;
    }
}
