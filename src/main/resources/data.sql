------------ insert user ------------
insert into TBL_USER (id, name, token)
values (1, 'admin', 'admin-token'),
       (2, 'user', 'user-token');
------------ insert providers ------------
insert into TBL_PROVIDER (id, provider_name, address)
values (1, 'prodiver1', 'tehran'),
       (2, 'provider2', 'alborz');
------------ insert products ------------
insert into TBL_PRODUCT (id, name, enabled, average_rate, comment_type, vote_type, provider_id)
values (1, 'product1', 1, 3, 0, 0, 1),
       (2, 'product2', 1, 0, 0, 0, 1),
       (3, 'product3', 1, 2, 0, 0, 1),
       (4, 'product4', 1, 5, 0, 0, 2),
       (5, 'product5', 1, 1, 0, 0, 1),
       (6, 'product6', 1, 2, 0, 0, 2);
------------ insert comments ------------
insert into TBL_COMMENT (id, title, comment, status, product_id, user_id)
values (1, 'title1', 'comment1', 0, 1, 1),
       (2, 'title2', 'comment2', 1, 1, 2),
       (3, 'title3', 'comment3', 1, 1, 1),
       (4, 'title4', 'comment4', 2, 2, 2),
       (5, 'title5', 'comment5', 1, 3, 1),
       (6, 'title6', 'comment6', 1, 3, 1);
------------ insert votes ------------
insert into TBL_VOTE (id, rating, status, product_id, user_id)
values (1, 2, 0, 1, 1),
       (2, 3, 1, 1, 2),
       (3, 1, 1, 1, 1),
       (4, 4, 2, 2, 2),
       (5, 5, 1, 3, 1),
       (6, 3, 1, 3, 1);