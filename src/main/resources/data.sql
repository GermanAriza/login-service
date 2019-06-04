INSERT INTO user (id,enabled,password,username) 
VALUES(1,0b1,"$2a$10$Ak82IET4CgS8jxfHz4Rzm.OyQ9lt6NEvfH/RSsR37jqBiLcMrfsZG","admin");

INSERT INTO user (id,enabled,password,username) 
VALUES(2,0b1,"$2a$10$Ak82IET4CgS8jxfHz4Rzm.OyQ9lt6NEvfH/RSsR37jqBiLcMrfsZG","user");

INSERT INTO authority (id,authority) VALUES (1,"ROLE_ADMIN");
INSERT INTO authority (id,authority) VALUES (2,"ROLE_USER");
INSERT INTO authorities_users (usuario_id, authority_id) VALUES (1,1);
INSERT INTO authorities_users (usuario_id, authority_id) VALUES (1,2);
INSERT INTO authorities_users (usuario_id, authority_id) VALUES (2,2);

COMMIT;