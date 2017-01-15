CREATE DATABASE PHARMACY_MERHY
GO
USE PHARMACY_MERHY
GO
CREATE TABLE Tipo(
	idtipo int  NOT NULL,
	nombres varchar(50) NOT NULL,
	primary key(idtipo)
)
go 

CREATE TABLE producto (
  id_producto int NOT NULL identity(1,1),
  nombre_producto varchar(100) NOT NULL,
  idtipo int not null,
  precio float NOT NULL,
  caducidad date NOT NULL,
  existencia int NOT NULL,
  descripcion varchar(150) NOT NULL,
  especificaciones varchar(150) NOT NULL,
  PRIMARY KEY (id_producto),
  foreign key (idtipo) references tipo(idtipo)
)
GO
CREATE TABLE Cliente(
	id_cliente int NOT NULL identity(1,1),
	nombres varchar(50) NOT NULL,
	direccion varchar(50) NOT NULL,
	primary key(id_cliente)
)
go
CREATE TABLE usuario (
  id_usuario int NOT NULL IDENTITY(1,1),
  nombre varchar(50) NOT NULL,
  apellido_paterno varchar(50) NOT NULL,
  apellido_materno varchar(50) NOT NULL,
  dni char(8)not null,
  usuario varchar(25) NOT NULL,
  password varchar(22) NOT NULL,
  nivel int NOT NULL,
  PRIMARY KEY (Id_usuario)
)
GO
create table tipocomprobante(
id_tipocomprobante int,
comprobante varchar(50),
primary key (id_tipocomprobante)
)
go
 CREATE TABLE COMPROBANTE (
ID_COMPROBANTE		CHAR(7)		NOT NULL,--PK
id_tipocomprobante	INT			NOT NULL,
ID_CLIENTE			INT			NOT NULL,--FK
id_usuario			INT			NOT NULL,--FK		--- CODIGO DE EMPLEADO
PagoTotal			float		not null,
FECHA_P				DATETIME	NOT NULL,--FECHA DE PAGO
PRIMARY KEY(ID_COMPROBANTE),
FOREIGN KEY (id_tipocomprobante) REFERENCES tipocomprobante(id_tipocomprobante),	
FOREIGN KEY (ID_CLIENTE) REFERENCES CLIENTE(id_cliente),
FOREIGN KEY (id_usuario) REFERENCES usuario(id_usuario)	
)
GO

CREATE TABLE DETALLE_COMPROBANTE(
NUM_DETALLE_C	INT			NOT NULL,--PK
ID_COMPROBANTE	CHAR(7)		NOT NULL,--PK
id_producto		int			NOT NULL,--FK
CANTIDAD		int			NOT NULL,
PRECIO			FLOAT		NOT NULL,
PRIMARY KEY(NUM_DETALLE_C,ID_COMPROBANTE),
FOREIGN KEY (id_producto) REFERENCES producto(id_producto)
)		
go
