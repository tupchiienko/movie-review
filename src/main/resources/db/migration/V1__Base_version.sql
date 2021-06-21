CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

CREATE TABLE IF NOT EXISTS directors(
    id uuid primary key default uuid_generate_v1(),
    name varchar(64) not null
);

CREATE TABLE IF NOT EXISTS rates(
    id uuid primary key default uuid_generate_v1(),
    value int not null,
    count bigint not null
);

CREATE TABLE IF NOT EXISTS movies(
    id uuid primary key default uuid_generate_v1(),
    name varchar(64) not null,
    description varchar(2048) not null,
    photo varchar(128) not null,
    director_id uuid not null,
    rate_id uuid not null,
    constraint director_id_fk foreign key (director_id) references directors(id),
    constraint rate_id_fk foreign key (rate_id) references rates(id)
);

CREATE TABLE IF NOT EXISTS categories(
    id uuid primary key default uuid_generate_v1(),
    name varchar(64) not null
);

CREATE TABLE IF NOT EXISTS movies_categories(
    id bigserial primary key not null,
    movie_id uuid not null,
    category_id uuid not null,
    constraint movies_categories_movie_id_fk foreign key (movie_id) references movies(id),
    constraint movies_categories_category_id_fk foreign key (category_id) references categories(id)
);

CREATE TABLE IF NOT EXISTS reviews(
    id uuid primary key default uuid_generate_v1(),
    movie_id uuid not null,
    message varchar(2048) not null,
    likes bigint not null,
    dislikes bigint not null,
    constraint reviews_movie_id_fk foreign key (movie_id) references movies(id)
);

