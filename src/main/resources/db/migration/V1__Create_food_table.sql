create sequence app_dietas.food_seq;

create table food
(
    id             BIGINT         NOT NULL PRIMARY KEY DEFAULT NEXTVAL('app_dietas.food_seq'),
    name           VARCHAR(100)   NOT NULL,
    grams          DECIMAL(10, 2) NOT NULL,
    carbohydrate   DECIMAL(10, 2) NOT NULL,
    protein        DECIMAL(10, 2) NOT NULL,
    fat            DECIMAL(10, 2) NOT NULL,
    total_calories DECIMAL(10, 2) NULL,
    created_by     VARCHAR(50)    NOT NULL,
    created_at     timestamp      NOT NULL             DEFAULT current_timestamp,
    updated_by     VARCHAR(50) NULL,
    updated_at     timestamp NULL
);