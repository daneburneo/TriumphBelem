create database triumphdb;

use triumphdb;


create table engines
(
    engine_type          varchar(10) not null,
    engine_cc            integer     not null,
    engine_refrigeration varchar(13) not null,
    engine_id            integer     not null primary key auto_increment

);


create table motorcycles
(

    motorcycle_name  varchar(20)   not null,
    motorcycle_model varchar(20)   not null,
    motorcycle_price decimal(3, 3) not null,
    motorcycle_id    integer       not null primary key auto_increment,
    motorcycle_total integer not null,
    motorcycle_discount decimal not null,
    engine_fk        integer       not null,
    foreign key (engine_fk) references engines (engine_id)

);



create table people
(
    person_id       integer     not null primary key auto_increment,
    person_name     varchar(40) not null,
    person_lastname varchar(40) not null


);
create table contacts
(

    contact_id     integer not null primary key auto_increment,
    contact_number long    not null,
    person_fk      integer not null,
    foreign key (person_fk) references people(person_id)

);

create table reserves
(
    order_id          integer       not null primary key auto_increment,
    order_total_price decimal(7, 2) not null,
    order_date        timestamp     not null,
    person_fk         integer       not null,
    foreign key (person_fk) references people (person_id)
);

create table orders_motorcycles
(

    order_motorcycle integer not null primary key auto_increment,
    order_fk         integer not null,
    motorcycle_fk    integer not null,
    foreign key (order_fk) references reserves (reserve_id),
    foreign key (motorcycle_fk) references motorcycles (motorcycle_id)
);






insert into people (person_id, person_name, person_lastname)
    value (default, 'Luan', 'Santos'),
    (default, 'Danilo', 'Pinho');

select * from people;

delete from people where person_id = 1;

insert into contacts(contact_id, contact_number, person_fk) VALUE (default, 999999, default), (default, 888888, default);



select *
from people;
select *
from contacts;

select *
from people
         join contacts on people.person_id = contacts.person_fk;

insert into reserves(reserve_id, reserve_total_price, reserve_date, person_fk) value (default, 10000, now(), 2), (default, 20000, now(), 3);


insert into motorcycles(motorcycle_name, motorcycle_model, motorcycle_price, engine_fk) value ('Tiger 660', 'Roadster', 60, 5),
    ('Scrambler 1200', 'Modern Classic', 50, 7), ('Triton 660', 'Naked', 40, 5), ('Scrambler 900', 'Modern Classic', 50, 6);

insert into engines(engine_type, engine_cc, engine_refrigeration) VALUE ('double', 600, 'liquid-cooled'), ('triple', 900, 'liquid-cooled'),
    ('dual', 900, 'liquid-cooled'), ('triple', 1200, 'liquid-cooled');

desc motorcycles;

select*
from motorcycles;

select *
from engines;

select *
from reserves_motorcycles;

select *
from people;

desc reserves_motorcycles;

insert into reserves_motorcycles(reserve_fk, motorcycle_fk) VALUE (2, 9);

select distinct *
from people
         join reserves
         join motorcycles
         join reserves_motorcycles on people.person_id = reserves.person_fk and
                                    orders_motorcycles.order_fk = reserves.order_id and
                                    orders_motorcycles.motorcycle_fk = motorcycles.motorcycle_id;



select * from people;

delete from people where person_id = 1;

insert into contacts(contact_id, contact_number, person_fk) VALUE (default, 999999, 2), (default, 888888, 3);



select *
from people;
select *
from contacts;

select *
from people
         join contacts on people.person_id = contacts.person_fk;

insert into reserves(reserve_id, reserve_total_price, reserve_date, person_fk) value (default, 10000, now(), 2), (default, 20000, now(), 3);


insert into motorcycles(motorcycle_name, motorcycle_model, motorcycle_price, engine_fk) value ('Tiger 660', 'Roadster', 600, 5),
    ('Scrambler 1200', 'Modern Classic', 500, 7), ('Triton 660', 'Naked', 400, 5), ('Scrambler 900', 'Modern Classic', 500, 6);

insert into engines(engine_type, engine_cc, engine_refrigeration) VALUE ('double', 600, 'liquid-cooled'), ('triple', 900, 'liquid-cooled'),
    ('dual', 900, 'liquid-cooled'), ('triple', 1200, 'liquid-cooled');

desc motorcycles;

select*
from motorcycles;

select *
from engines;

select *
from reserves_motorcycles;

select *
from people;

desc reserves_motorcycles;

insert into reserves_motorcycles(reserve_fk, motorcycle_fk) VALUE (2, 9);

