INSERT INTO spring_security_schema.users
(id, created_by, created_on, updated_by, updated_on, "password", username, enabled)
VALUES(1, 'admin', '2022-01-09 17:25:10.271', 'admin', '2022-01-09 17:25:10.271', '12345', 'bill', 1);


INSERT INTO spring_security_schema.authorities
(id, username, authority, created_by, created_on, updated_by, updated_on)
VALUES(1, 'bill', 'read', 'admin', '2022-01-09 21:23:50.779', 'admin', '2022-01-09 21:23:50.779');
INSERT INTO spring_security_schema.authorities
(id, username, authority, created_by, created_on, updated_by, updated_on)
VALUES(2, 'bill', 'write', 'admin', '2022-01-09 21:24:20.457', 'admin', '2022-01-09 21:24:20.457');

