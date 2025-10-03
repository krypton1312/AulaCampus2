create table socios (
codsocio int(4),
nombre varchar(30),
apellidos varchar(60),
direccion varchar(50),
telefono varchar(12),
poblacion varchar(15)
);

create table peliculas(
codpelicula int(4),
titulo varchar(50),
tema varchar(20),
duracion int(3),
precio decimal(4,2)
);


create table alquiler(
codalquiler int(4),
codpelicula int(4),
codsocio int(4),
fechaalquiler date,
dias int(2)
);


alter table socios add constraint socios_pk primary key(codsocio);
alter table peliculas add constraint peliculas_pk primary key(codpelicula);
alter table alquiler add constraint alquiler_pk primary key(codalquiler);
alter table alquiler add constraint alquiler_socios_fk foreign key(codsocio) references socios(codsocio) on delete cascade;
alter table alquiler add constraint alquiler_peliculas_fk foreign key(codpelicula) references peliculas (codpelicula) on delete cascade;

insert into socios values (1274,'Luis','Sánchez Aguado','Colón, 31','3657432','Valencia');
insert into socios values (1794,'Manuel','García Roble','Gran Vía, 78','3958472','Valencia');
insert into socios values (2365,'Eva','Prats Ruíz','Ercilla, 8','3568976','Valencia');
insert into socios values (3860,'Sergio','Oliver Perís','Salinas, 5','3456789','Xátiva');
insert into socios values (4101,'Jaime','Navarro Lard','Magallanes, 21','3242413','Utiel');
insert into socios values (4289,'Elisa','García Olmos','Juan de Mena. 11','3948372','Gandía');
insert into socios values (5320,'Pedro','Lorenzo Fernández','Sueca, 45','3234888','Valencia');
insert into socios values (6532,'Vicente','Tamarit Valls','Mirador, 3','3087689','Utiel');
insert into socios values (7932,'Daniel','López Pérez','Monte Mayor, 42','3232387','Gandía');
insert into socios values (8129,'Sonia','Sastre Vives','Carteros, 23','3927472','Xátiva');




insert into peliculas values (100,'Casper','Comedia',124,2);
insert into peliculas values (115,'El libro de la Selva','Aventuras',132,2);
insert into peliculas values (123,'Batman Forever','Aventuras',98,3);
insert into peliculas values (146,'Rob Roy','Drama',113,1);
insert into peliculas values (159,'Historias del Kronen','Drama',105,1);
insert into peliculas values (214,'Cadena Perpetua','Drama',90,1);
insert into peliculas values (307,'Estallido','Intriga',140,3);
insert into peliculas values (452,'Un indio en París','Comedia',95,1);
insert into peliculas values (492,'Circulo de amigos','Drama',112,2);
insert into peliculas values (560,'Antes de Amanecer','Comedia',97,1);
insert into peliculas values (663,'El guardián de las palabras','Aventuras',121,2);
insert into peliculas values (712,'Quiz Show','Intriga',110,2);
insert into peliculas values (789,'Dos tontos muy tontos','Comedia',134,3);
insert into peliculas values (883,'La Mascara','Comedia',142,3);
insert into peliculas values (901,'Suspiros de España (y Portugal)','Comedia',92,1);
insert into peliculas values (919,'Double Dragon','Aventuras',103,2);
insert into peliculas values (924,'El Primer Caballero','Aventuras',101,3);
insert into peliculas values (936,'Congo','Intriga',130,3);
insert into peliculas values (949,'Water World','Aventuras',121,2);
insert into peliculas values (967,'Desperado','Aventuras',108,3);
insert into peliculas values (980,'Causa Justa','Intriga',113,3);
insert into peliculas values (1020,'Toy Story','Aventuras',104,3);
insert into peliculas values (1032,'Las dos caras de la verdad','Intriga',123,3);
insert into peliculas values (1040,'Misión Imposible','Aventuras',136,3);
insert into peliculas values (1052,'Un loco a domicilio','Comedia',110,2);
insert into peliculas values (1065,'Como conquistar Hollywood','Comedia',95,2);
insert into peliculas values (1072,'Tres Deseos','Drama',112,3);
insert into peliculas values (1083,'Cautivos','Drama',127,1);
insert into peliculas values (1090,'Días de Fortuna','Drama',133,3);
insert into peliculas values (1102,'El Presidente y Miss Wade','Comedia',111,1);
insert into peliculas values (1109,'Sabrina y sus amores','Comedia',101,1);
insert into peliculas values (1117,'Una Proposición Indecente','Drama',124,2);
insert into peliculas values (1123,'Una Jaula de Grillos','Comedia',105,3);
insert into peliculas values (1134,'La letra Escarlata','Drama',119,2);
insert into peliculas values (1140,'City Hall','Drama',98,3);
insert into peliculas values (1153,'Two Much','Comedia',103,2);
insert into peliculas values (1162,'Ace Ventura Operación África','Comedia',116,3);
insert into peliculas values (1170,'Todo por un Sueño','Drama',100,1);
insert into peliculas values (1188,'Tierra peligrosa','Aventuras',131,2);
insert into peliculas values (1193,'El informe pelícano','Aventuras',114,1);
insert into peliculas values (1203,'Mr. Jones','Drama',102,1);
insert into peliculas values (1212,'El Abogado del Diablo','Intriga',114,2);
insert into peliculas values (1222,'Eternamente joven','Drama',97,1);
insert into peliculas values (1234,'Ojo por ojo','Drama',115,3);
insert into peliculas values (1241,'Leyendas de Pasión','Drama',141,3);
insert into peliculas values (1253,'Esperando un Respiro','Comedia',103,2);
insert into peliculas values (1267,'La red','Intriga',129,3);
insert into peliculas values (1273,'Eraser','Aventuras',133,3);
insert into peliculas values (1288,'Salto al vacío','Aventuras',100,1);
insert into peliculas values (1295,'Golden Eye','Aventuras',119,2);




insert into alquiler values (1,115,2365,'1995-10-01',2);
insert into alquiler values (2,123,3860,'1995-10-01',3);
insert into alquiler values (3,159,4289,'1995-10-01',1);
insert into alquiler values (4,214,1274,'1995-10-02',2);
insert into alquiler values (5,452,1794,'1995-10-02',1);
insert into alquiler values (6,492,5320,'1995-10-02',2);
insert into alquiler values (7,789,4101,'1995-10-02',3);
insert into alquiler values (8,100,6532,'1995-10-03',2);
insert into alquiler values (9,883,8129,'1995-10-03',2);
insert into alquiler values (10,919,4101,'1995-10-03',2);
insert into alquiler values (11,924,4289,'1995-10-04',1);
insert into alquiler values (12,936,5320,'1995-10-04',2);
insert into alquiler values (13,949,6532,'1995-10-04',3);
insert into alquiler values (14,967,7932,'1995-10-04',2);
insert into alquiler values (15,980,8129,'1995-10-04',1);

