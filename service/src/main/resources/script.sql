create table public.survey
(
    name varchar                                             not null,
    id   integer default nextval('survey_idd_seq'::regclass) not null
        constraint survey_pk
            primary key
);

alter table public.survey
    owner to postgres;

create table public.question
(
    question_text  varchar                                               not null,
    answers_number integer default 1                                     not null,
    id             integer default nextval('question_idd_seq'::regclass) not null
        constraint question_pk
            primary key
);

alter table public.question
    owner to postgres;

create table public.answer_text
(
    answer_text varchar not null,
    id          serial
        constraint answer_text_pk
            primary key
);

alter table public.answer_text
    owner to postgres;

create table public.survey_question
(
    survey_id   integer                                                      not null
        constraint survey_question_survey_id_fk
            references public.survey,
    question_id integer                                                      not null
        constraint survey_question_question_id_fk
            references public.question,
    id          integer default nextval('survey_question_idd_seq'::regclass) not null
        constraint survey_question_pk
            primary key
);

alter table public.survey_question
    owner to postgres;

create table public.survey_question_answer_text
(
    answer_text_id     integer not null
        constraint survey_question_answer_text_answer_text_id_fk
            references public.answer_text,
    survey_question_id integer not null
        constraint survey_question_answer_text_survey_question_id_fk
            references public.survey_question,
    id                 serial
        constraint survey_question_answer_text_pk
            primary key
);

alter table public.survey_question_answer_text
    owner to postgres;

create table public.users
(
    name     varchar,
    login    varchar not null
        constraint login_unique
            unique,
    password varchar not null,
    role     varchar not null,
    id       serial
        constraint users_pk
            primary key
);

alter table public.users
    owner to postgres;

create table public.answer
(
    user_id                        integer not null
        constraint answer_users_id_fk
            references public.users,
    survey_question_answer_text_id integer
        constraint answer_survey_question_answer_text_id_fk
            references public.survey_question_answer_text,
    id                             serial
        constraint answer_pk
            primary key
);

alter table public.answer
    owner to postgres;

