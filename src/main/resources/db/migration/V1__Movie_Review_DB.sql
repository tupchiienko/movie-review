CREATE TABLE IF NOT EXISTS directors(
    id bigserial primary key not null,
    name varchar(64) not null
);

CREATE TABLE IF NOT EXISTS rates(
    id bigserial primary key not null,
    value int not null,
    count bigint not null
);

CREATE TABLE IF NOT EXISTS movies(
    id bigserial primary key not null,
    name varchar(64) not null,
    description varchar(2048) not null,
    photo varchar(128) not null,
    director_id bigint not null,
    rate_id bigint not null,
    constraint director_id_fk foreign key (director_id) references directors(id),
    constraint rate_id_fk foreign key (rate_id) references rates(id)
);

CREATE TABLE IF NOT EXISTS categories(
    id bigserial primary key not null,
    name varchar(64) not null
);

CREATE TABLE IF NOT EXISTS movies_categories(
    id bigserial primary key not null,
    movie_id bigint not null,
    category_id bigint not null,
    constraint movies_categories_movie_id_fk foreign key (movie_id) references movies(id),
    constraint movies_categories_category_id_fk foreign key (category_id) references categories(id)
);

CREATE TABLE IF NOT EXISTS reviews(
    id bigserial primary key not null,
    movie_id bigint not null,
    message varchar(2048) not null,
    likes bigint not null,
    dislikes bigint not null,
    constraint reviews_movie_id_fk foreign key (movie_id) references movies(id)
);

