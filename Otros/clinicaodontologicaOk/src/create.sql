CREATE TABLE IF NOT EXISTS ODONTOLOGO (
ID INTEGER PRIMARY KEY,
NOMBRE varchar(50),
APELLIDO varchar(50),
MATRICULA varchar(50)
);
CREATE TABLE IF NOT EXISTS PACIENTE (
ID INTEGER PRIMARY KEY,
NOMBRE varchar(50),
APELLIDO varchar(50),
DNI varchar(50),
EMAIL varchar(50),
FECHA_INGRESO varchar(50),
ODONTOLOGO_ID integer
);




