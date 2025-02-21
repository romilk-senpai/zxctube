CREATE TABLE user_data
(
    id           serial PRIMARY KEY,
    uuid         VARCHAR(64),
    display_name VARCHAR(64),
    email        VARCHAR(64),
    avatar_uuid  VARCHAR(64),
    keycloak_uuid  VARCHAR(64),
    create_date  timestamp default now(), -- Дата создания записи в бд
    update_date  timestamp
);

CREATE TABLE video
(
    id                 serial PRIMARY KEY,
    uuid               VARCHAR(64),
    video_file_uuid    VARCHAR(64),
    video_preview_uuid VARCHAR(64),
    author_uuid        VARCHAR(64),
    video_title        VARCHAR(64),
    video_description  VARCHAR(64),
    create_date        timestamp default now(), -- Дата создания записи в бд
    update_date        timestamp
);

create table credentials
(
    id          serial PRIMARY KEY,
    uuid        VARCHAR(64),
    user_uuid   VARCHAR(64),
    email       VARCHAR(64),
    password    VARCHAR(64),
    token       VARCHAR(64),
    token_expire_time timestamp,
    create_date timestamp default now(), -- Дата создания записи в бд
    update_date timestamp
)