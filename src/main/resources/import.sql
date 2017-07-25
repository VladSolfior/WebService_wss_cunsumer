INSERT INTO users (name, email, password, spend_per_day) VALUES ('User', 'user@yandex.ru', 'password',1000);
INSERT INTO users (name, email, password, spend_per_day) VALUES ('Admin', 'admin@yandex.ru', '12345',1000);


INSERT INTO user_roles (role, user_id) VALUES ('ROLE_USER', 1);
INSERT INTO user_roles (role, user_id) values ('ROLE_ADMIN', 2);