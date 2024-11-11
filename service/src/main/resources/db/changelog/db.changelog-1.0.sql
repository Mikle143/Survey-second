--liquibase formatted sql

--changeset vdovmb:1
CREATE TABLE public.survey
(
    id   SERIAL PRIMARY KEY,
    name VARCHAR NOT NULL
);

--changeset vdovmb:2
CREATE TABLE public.question
(
    id             SERIAL PRIMARY KEY,
    question_text  VARCHAR           NOT NULL,
    answers_number INTEGER DEFAULT 1 NOT NULL
);

--changeset vdovmb:3
CREATE TABLE public.answer_text
(
    id          SERIAL PRIMARY KEY,
    answer_text VARCHAR NOT NULL
);

--changeset vdovmb:4
CREATE TABLE public.survey_question
(
    id          SERIAL PRIMARY KEY,
    survey_id   INTEGER NOT NULL REFERENCES public.survey (id) ON DELETE CASCADE,
    question_id INTEGER NOT NULL REFERENCES public.question (id) ON DELETE CASCADE
);

--changeset vdovmb:5
CREATE TABLE public.survey_question_answer_text
(
    id                 SERIAL PRIMARY KEY,
    answer_text_id     INTEGER NOT NULL REFERENCES public.answer_text (id) ON DELETE CASCADE,
    survey_question_id INTEGER NOT NULL REFERENCES public.survey_question (id) ON DELETE CASCADE
);

--changeset vdovmb:6
CREATE TABLE public.users
(
    id       SERIAL PRIMARY KEY,
    name     VARCHAR,
    login    VARCHAR NOT NULL UNIQUE,
    password VARCHAR NOT NULL,
    role     VARCHAR
);

--changeset vdovmb:7
CREATE TABLE public.answer
(
    id                             SERIAL PRIMARY KEY,
    user_id                        INTEGER NOT NULL REFERENCES public.users (id) ON DELETE CASCADE,
    survey_question_answer_text_id INTEGER REFERENCES public.survey_question_answer_text (id) ON DELETE CASCADE
);