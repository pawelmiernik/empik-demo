CREATE TABLE IF NOT EXISTS user_request
(
    id serial not null,
    login varchar2(100),
    request_count int
);