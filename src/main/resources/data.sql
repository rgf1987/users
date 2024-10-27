--INSERT USUARIOS

INSERT INTO USUARIO_BOX (NOMBRE, APELLIDO1, APELLIDO2, DNI) VALUES
('Ruben', 'Gonzalez', 'Fernandez', '77360344M'),
('Cristina', 'Avila', 'Rodriguez', '11454535Y'),
('Higinio', 'Arnaldo', 'Sariego', '57732627M'),
('Juanjo', 'Ramos', 'Peña', '85812006H'),
('Rebeca', 'Modino', 'Estrada', '99845601W'),
('Cristian', 'Benjumea', 'Davila', '65711286X'),
('Alicia', 'Delgado', 'Gonzalez', '26393907G');


-- INSERT TIPOS DE TARIFA
-- Insert para un tipo de tarifa estándar
INSERT INTO TIPO_TARIFA (CODIGO, DESCRIPCION, PRECIO, NUMERO_WODS, NUMERO_OPENS)
VALUES 
('BASIC', 'Tarifa básica para usuarios principiantes', '30.00', '12', '2'),
('PREMIUM', 'Tarifa premium para acceso ilimitado', '70.00', 'UNLIMITED', 'UNLIMITED'),
('WKND', 'Tarifa especial para fines de semana', '20.00', '8', '0');