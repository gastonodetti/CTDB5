CREATE TABLE IF NOT EXISTS odontologos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL,
    apellido VARCHAR(50) NOT NULL,
    numeroMatricula VARCHAR(50) NOT NULL
);

INSERT INTO odontologos (nombre, apellido, numeroMatricula) VALUES ('Pepe', 'Pepardo', '123456');
INSERT INTO odontologos (nombre, apellido, numeroMatricula) VALUES ('Pipo', 'Pipardo', '112233');
INSERT INTO odontologos (nombre, apellido, numeroMatricula) VALUES ('Pepa', 'Peparda', '111222');