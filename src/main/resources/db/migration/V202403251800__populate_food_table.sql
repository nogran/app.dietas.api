INSERT INTO app_dietas.food
(id, "name", grams, carbohydrate, protein, fat, total_calories, company, created_by, created_at)
VALUES
    (nextval('app_dietas.food_seq'::regclass), 'Arroz cru', 100, 70, 7, 1, 317, '', 'carga inicial', CURRENT_TIMESTAMP),
    (nextval('app_dietas.food_seq'::regclass), 'Ovo branco cozido', 1, 0, 3, 3, 39, '', 'carga inicial', CURRENT_TIMESTAMP),
    (nextval('app_dietas.food_seq'::regclass), 'Frango cru', 100, 0.2, 23, 1, 101.8, '', 'carga inicial', CURRENT_TIMESTAMP),
    (nextval('app_dietas.food_seq'::regclass), 'Banha de porco', 0, 0, 0, 10, 90, 'Sadia', 'carga inicial', CURRENT_TIMESTAMP),
    (nextval('app_dietas.food_seq'::regclass), 'Banana prata', 100, 22, 1, 0.2, 93.8, '', 'carga inicial', CURRENT_TIMESTAMP),
    (nextval('app_dietas.food_seq'::regclass), 'Patinho cru', 100, 0, 21.7, 4.5, 127.3, '', 'carga inicial', CURRENT_TIMESTAMP),
    (nextval('app_dietas.food_seq'::regclass), 'Castanha de caju W1', 100, 32.7, 15.3, 46.7, 612.3, '', 'carga inicial', CURRENT_TIMESTAMP),
    (nextval('app_dietas.food_seq'::regclass), 'Nozes quartz extra light', 10, 2, 1, 7, 75, '', '', CURRENT_TIMESTAMP),
    (nextval('app_dietas.food_seq'::regclass), 'Mel - cipó uva', 20, 17, 0, 0, 290, 'Apiário Flores do Cerrado', 'carga inicial', CURRENT_TIMESTAMP),
    (nextval('app_dietas.food_seq'::regclass), 'Batata inglesa sem pele cru', 100, 15.2, 2.04, 0.04, 71, '', 'carga inicial', CURRENT_TIMESTAMP);