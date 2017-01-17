CREATE DATABASE PHARMACY_MERHY
GO
USE PHARMACY_MERHY
GO
CREATE TABLE RUC_PHARMACY(
ID_RUC INT,
RUC VARCHAR(11),
PRIMARY KEY (ID_RUC)
)
GO
INSERT INTO RUC_PHARMACY VALUES (1,'20191716651')
GO
select i=convert(date,getdate())
CREATE TABLE Tipo(
	idtipo int  NOT NULL,
	nombres varchar(50) NOT NULL,
	primary key(idtipo)
)
go 
INSERT INTO Tipo VALUES
(1, 'Analgesicos'),
(2, 'Antibioticos'),
(3,'Antiinflamatorio'),
(4, 'Vitaminicos');
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
insert into producto values ('paracetamol',1,1.50,'15/01/2018',50,'Alivia varios dolores','No apto para embarazadas')
insert into producto values ('bismutol',1,1.50,'15/01/2018',50,'Alivia los dolores de garganta','No apto para menores de 5 a�oss')
insert into producto values ('Eritromicina',1,1.50,'15/01/2018',50,'Elimina los sintomas de la gripe','No apto para menores de 10 a�os')
insert into producto values ('Diclofenaco',2,1.50,'15/01/2018',50,'Alivia el dolor en general','No apto para menores de 10 a�os')
go
select * from usuario
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
  clave varchar(22) NOT NULL,
  cargo varchar (30)NOT NULL,
  PRIMARY KEY (Id_usuario)
)
GO
select * from usuario
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
