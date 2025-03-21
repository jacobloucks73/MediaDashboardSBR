create table aggdata
(
    user_id      bigint    not null comment 'References the user this data belongs to.'
        primary key,
    json_data    json      not null comment 'Aggregated data stored as JSON.',
    last_updated timestamp not null comment 'The last time the data was updated/refreshed.'
)
    comment 'This table caches or stores aggregated social media data for each user. Can store the data as JSON for flexibility.';

create table users
(
    Username   varchar(255) not null comment 'chosen username for users ',
    ID         bigint       not null comment 'ID of users'
        primary key,
    email      varchar(255) not null comment 'stored email for profile',
    role       varchar(20)  not null comment 'Admin/user/customer/etc...',
    Password   varchar(255) not null comment 'hashed password for user',
    Created_At timestamp    not null comment 'When the user account was created ',
    Updated_At timestamp    not null comment 'When the profile was updated '
);

create table social
(
    ID            bigint       not null comment '	Unique identifier for the social account record.'
        primary key,
    user_id       bigint       not null comment 'Foreign key referencing users.id',
    provider      varchar(50)  not null comment 'The social platform (e.g., ''X'', ''Instagram'').',
    external_id   varchar(100) not null comment 'The unique identifier from the social platform.',
    access_token  varchar(255) not null comment 'The token used to access the social media API.',
    refresh_token varchar(255) null comment 'Token to refresh access (if applicable).',
    created_at    timestamp    not null comment 'Record creation timestamp.',
    updated_at    timestamp    not null comment 'Record update timestamp.',
    constraint Social_users_ID_fk
        foreign key (user_id) references users (ID)
)
    comment 'This table tracks the social media accounts that a user has linked to the aggregator.';

