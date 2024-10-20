package ru.vdovmb.dto;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class AnswerFilter {
    String surveyName;
    String questionText;
    String answerText;
}
