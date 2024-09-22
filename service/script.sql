create table survey
(
    id   serial
        primary key,
    name varchar not null
);

alter table survey
    owner to postgres;

create table question
(
    id             serial
        constraint question_pk
            primary key,
    question_text  varchar           not null,
    answers_number integer default 1 not null
);

alter table question
    owner to postgres;

create table answer_text
(
    id          integer default nextval('answer_id_seq'::regclass) not null
        constraint text_of_the_answer_pk
            primary key,
    answer_text varchar                                            not null
);

alter table answer_text
    owner to postgres;

create table survey_question
(
    survey_id   integer not null
        constraint survey_question_survey_id_fk
            references survey,
    question_id integer not null
        constraint survey_question_question_id_fk
            references question,
    constraint survey_question_pk
        primary key (survey_id, question_id)
);

alter table survey_question
    owner to postgres;

create table survey_question_answer
(
    survey_id      integer not null,
    question_id    integer not null,
    answer_text_id integer not null
        constraint survey_question_answer_text_of_the_answer_id_fk
            references answer_text,
    constraint survey_question_answer_pk
        primary key (survey_id, question_id, answer_text_id),
    constraint survey_question_answer_survey_question_survey_id_question_id_fk
        foreign key (survey_id, question_id) references survey_question
);

alter table survey_question_answer
    owner to postgres;

create table users
(
    user_id  integer default nextval('administrtor_administrtor_id_seq'::regclass) not null
        constraint administrtor_pk
            primary key,
    name     varchar,
    login    varchar                                                               not null
        constraint login_unique
            unique,
    password varchar                                                               not null,
    role     varchar                                                               not null
);

alter table users
    owner to postgres;

create table answer
(
    survey_id        integer not null,
    question_text_id integer not null,
    answer_text_id   integer not null,
    user_id          integer not null
        constraint answer_user_user_id_fk
            references users
            on update cascade on delete cascade,
    constraint answer_pk
        primary key (answer_text_id, survey_id, question_text_id, user_id),
    constraint ans_sur_ques_ans_ques_id_sur_id_text_of_the_answer_id_fk
        foreign key (question_text_id, survey_id, answer_text_id) references survey_question_answer
);

alter table answer
    owner to postgres;


