insert into accommodation (name, address, place, category, num_persons, rate) values ('Youth hostel', 'Petrinjska 77', 'Zagreb', 3, 6, 0)
insert into accommodation (name, address, place, category, num_persons, rate) values ('Sheraton', 'Polgar Andrasa 1', 'Novi Sad', 4, 10, 0)
insert into accommodation (name, address, place, category, num_persons, rate) values ('Hotel Moskva', 'Terazije 20', 'Beograd', 4, 11, 0)
insert into accommodation (name, address, place, category, num_persons, rate) values ('Hotel Narvik', 'Trg srpskih dobrovoljaca 24', 'Kikinda', 3, 8, 0)

insert into end_user (name, last_name, address, status, email, password) values ('Pera', 'Peric', 'Svetosavska', 1, 'pera', 'pass')
insert into end_user (name, last_name, address, status) values ('Dragan', 'Dragic', 'Srpskocrkvena', 0)
insert into agent (name, last_name, number, address, username, password) values ('Jova', 'Jovic', '1', 'Fruskogorska', 'a', 'a')

insert into reservation(accommodation_id, status, end_user_id, date_from, date_to) values (1, 1, 1, '2018-10-27', '2018-10-31')
--insert into reservation(accommodation_id, status, end_user_id) values (1, 1, 1)

/*
insert into extra(name) value ('TV')
insert into extra(name) value ('Klima')
insert into extra(name) value ('WiFi')*/
insert into admin (username, password) values ('admin', 'admin')

insert into comment(content, status) value ('komentar 1', 0)
insert into comment(content, status) value ('komentar 2', 0)
insert into comment(content, status) value ('komentar 3', 1)