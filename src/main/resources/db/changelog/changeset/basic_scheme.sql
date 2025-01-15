create table if not exists video(
    id bigserial primary key,
    title varchar(255) not null,
    description varchar(1024) not null,
    created_at timestamptz not null default current_timestamp,
    updated_at timestamptz not null default current_timestamp,
    url varchar not null
)