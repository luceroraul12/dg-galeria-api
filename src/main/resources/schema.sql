--creo tabla para saber las cantidades de los paquetes
create table packages(
	id bigserial unique not null primary key,
	description varchar not null,
	amount int not null default 1
);



--creo una tabla para tener las relaciones de paquetes con categorias
create table brand_category_has_package(
	id bigserial not null unique primary key,
	package_id int not null,
	brand_category_id int not null,
	constraint package_fk foreign key (package_id) references packages(id),
	constraint category_fk foreign key (brand_category_id) references brand_category(id)
);



