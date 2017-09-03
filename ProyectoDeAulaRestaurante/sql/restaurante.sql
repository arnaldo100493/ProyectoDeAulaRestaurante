create database restaurante;
use restaurante;

create table persona(
  identificacionPersona int not null,
  nombre varchar(45) not null,
  apellido varchar(45) not null,
  sexo varchar(45) not null,
  fechaRegistro timestamp not null default current_timestamp,
  primary key(identificacionPersona)
);

create table administrador(
  identificacionPersona int not null,
  usuario varchar(45) not null,
  contrasenia varchar(45) not null,
  foreign key(identificacionPersona) references persona(identificacionPersona)
  on update cascade on delete cascade
); 

create table cliente(
  identificacionPersona int not null,
  nombre varchar(45) not null,
  apellido varchar(45) not null,
  direccion varchar(45) not null,
  telefono varchar(45) not null,
  correo varchar(45) not null,
  sexo varchar(45) not null
); 

create table empleado(
  identificacionPersona int not null,
  empresa varchar(45) not null,
  nitEmpresa varchar(45) not null,
  foreign key(identificacionPersona) references persona(identificacionPersona)
  on update cascade on delete cascade
);

create table producto(
  codigoProducto int not null,
  nombre varchar(45) not null,
  descripcion varchar(45) not null,
  precio int not null,
  cantidad int not null,
  fechaRegistro timestamp not null default current_timestamp,
  primary key(codigoProducto)
);