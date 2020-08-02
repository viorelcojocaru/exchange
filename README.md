# exchange
initial


### Generate Data Base
Use Postgresql database
### Create table "dictionar_valute"

create table dictionar_valute
(
	id bigserial not null,
	cod_valuta varchar(20) not null
);

create unique index dictionar_valute_cod_valuta_uindex
	on dictionar_valute (cod_valuta);

create unique index dictionar_valute_id_uindex
	on dictionar_valute (id);

alter table dictionar_valute
	add constraint dictionar_valute_pk
		primary key (id);

### Create table "curs_valutar"

create table curs_valutar
(
	id bigserial not null,
	cod_valuta bigint not null
		constraint curs_valutar_dictionar_valute_id_fk
			references dictionar_valute,
	rata int not null,
	curs double precision not null,
	data_curs date not null
);

create unique index curs_valutar_id_uindex
	on curs_valutar (id);

alter table curs_valutar
	add constraint curs_valutar_pk
		primary key (id);
		
### Create table "angajati"		
		
create table angajati
(
	id bigserial not null,
	nume varchar(50) not null
);

create unique index angajati_id_uindex
	on angajati (id);

alter table angajati
	add constraint angajati_pk
		primary key (id);
		
### Create table "numerar"	

create table numerar
(
	id bigserial not null,
	cod_valuta bigint not null
		constraint numerar_dictionar_valute_id_fk
			references dictionar_valute,
	suma int not null,
	data date not null,
	utilizator bigint not null
		constraint numerar_angajati_id_fk
			references angajati
);

create unique index numerar_id_uindex
	on numerar (id);

alter table numerar
	add constraint numerar_pk
		primary key (id);
		
### Create table "schimb_valutar"	
	
create table schimb_valutar
(
	id bigserial not null,
	cod_valuta bigint not null,
	suma_primita double precision not null,
	suma_eliberata double precision,
	data_tranzactiei timestamp
);

create unique index schimb_valutar_id_uindex
	on schimb_valutar (id);

alter table schimb_valutar
	add constraint schimb_valutar_pk
		primary key (id);



### Inserts

INSERT INTO public.dictionar_valute(
        cod_valuta)
    VALUES ('EUR');
INSERT INTO public.dictionar_valute(
	    cod_valuta)
	VALUES ('KZT');
INSERT INTO public.dictionar_valute(
	    cod_valuta)
	VALUES ('JPY');
	
INSERT INTO public.angajati(
            nume)
    VALUES ('oper1');
INSERT INTO public.angajati(
            nume)
    VALUES ('oper2');
    
    
 postman url
 http://localhost:8080/api/add-curs-valutar
 {"codValuta":"EUR","rata":"1","curs":"19.70"}
 
 http://localhost:8080/api/exchange
 {"codValuta":"EUR","cursSchimb":"19.70","sumaPrimita":"100", "sumaEliberata":"1970"}
 
 http://localhost:8080/api/exchange-two
 {"codValuta":"EUR","sumaPrimita":"20"}
 
 http://localhost:8080/api/all/curs-valutar/EUR
 
 http://localhost:8080/api/curs-valutar/EUR
