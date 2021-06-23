CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

CREATE TABLE IF NOT EXISTS rates(
    id uuid primary key default uuid_generate_v4(),
    value numeric(4, 2) not null,
    votes_count int not null check ( votes_count >= 0 )
);

CREATE TABLE IF NOT EXISTS movies(
    id uuid primary key default uuid_generate_v4(),
    name varchar(64) not null,
    description varchar(2048) not null,
    director_name varchar(64) not null,
    photo varchar(128) not null,
    rate_id uuid not null,
    constraint rate_id_fk foreign key (rate_id) references rates(id)
);

CREATE TABLE IF NOT EXISTS categories(
    id uuid primary key default uuid_generate_v4(),
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
    id uuid primary key default uuid_generate_v4(),
    message varchar(2048) not null,
    likes_count int not null check ( likes_count >= 0 ),
    dislikes_count int not null check ( dislikes_count >= 0 )
);

CREATE TABLE IF NOT EXISTS movies_reviews(
    id bigserial primary key not null,
    movie_id uuid not null,
    review_id uuid not null,
    constraint movies_categories_movie_id_fk foreign key (movie_id) references movies(id),
    constraint movies_reviews_review_id_fk foreign key (review_id) references reviews(id)
);

