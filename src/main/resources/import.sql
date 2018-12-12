create table persistent_logins(username tinytext  null, series tinytext null, token tinytext null, last_used timestamp null);

INSERT INTO role (name) VALUES ('ADMIN');
INSERT INTO role (name) VALUES ('USER');

INSERT INTO user (birthday, email, first_name, last_name, login, password, role_id) VALUES ('2009-12-11', 'admin@gmail.com', 'Admin', 'Admin', 'admin', '$2a$10$sOmo6cJZzDOyhVBR8nRfWufRVWLehBzL3O.SfHkpxUTeTrZSnCHNe', 1);
