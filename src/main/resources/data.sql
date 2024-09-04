-- tabla sector --
INSERT IGNORE INTO `SECTOR` set `id` = '1', `descripcion`='Municipal', `nombre`= 'Municipal';

--tabla unidad --
INSERT IGNORE INTO `UNIDAD` SET `id`='1', `descripcion`='Unidad', `nombre`='Unidad', `fechaCreacion`='2024-09-03 16:20:10';
INSERT IGNORE INTO `UNIDAD` SET `id`='2', `descripcion`='Metros', `nombre`='Metro(s)', `fechaCreacion`='2024-09-03 16:20:10';
INSERT IGNORE INTO `UNIDAD` SET `id`='3', `descripcion`='Litros', `nombre`='Litro(s)', `fechaCreacion`='2024-09-03 16:20:10';
INSERT IGNORE INTO `UNIDAD` SET `id`='4', `descripcion`='Kilos', `nombre`='Kilo(s)', `fechaCreacion`='2024-09-03 16:20:10';
INSERT IGNORE INTO `UNIDAD` SET `id`='5', `descripcion`='Metros Cuadrados', `nombre`='Metro(s) Cuadrado(s)', `fechaCreacion`='2024-09-03 16:20:10';

--tabla tipo dependencia--
INSERT IGNORE INTO `TIPO_DEPENDENCIA` set `id`= '1', `descripcion`='Dirección', `nombre`='Dirección';
INSERT IGNORE INTO `TIPO_DEPENDENCIA` set `id`= '2', `descripcion`='Departamento', `nombre`='Departamento';
INSERT IGNORE INTO `TIPO_DEPENDENCIA` set `id`= '3', `descripcion`='Oficina', `nombre`='Oficina';
INSERT IGNORE INTO `TIPO_DEPENDENCIA` set `id`= '4', `descripcion`='Programa', `nombre`='Programa';
INSERT IGNORE INTO `TIPO_DEPENDENCIA` set `id`= '5', `descripcion`='Unidad', `nombre`='Unidad';

--tabla dependencia--
INSERT IGNORE INTO `DEPENDENCIA` SET `id`='1', `codigo`='ALC', `descripcion`='Comm', `estado`='1', `fechaCreacion`='2024-06-28 16:20:10',
                             `nombre`='ALCALDIA', `timbre`='alcaldia.png', `SECTOR_id`='1', `TIPO_DEPENDENCIA_id`='1';

INSERT IGNORE INTO `DEPENDENCIA` SET `id`='2', `codigo`='ADM', `descripcion`='Comm', `estado`='1', `fechaCreacion`='2024-06-28 16:20:10',
                             `nombre`='ADMINISTRACIÓN MUNICIPAL', `timbre`='adminMuni.png', `SECTOR_id`='1', `TIPO_DEPENDENCIA_id`='1';

INSERT IGNORE INTO `DEPENDENCIA` SET `id`='3', `codigo`='INF', `descripcion`='Comm', `estado`='1', `fechaCreacion`='2024-06-28 16:20:10',
                             `nombre`='INFORMATICA', `timbre`='informatica.png', `SECTOR_id`='1', `TIPO_DEPENDENCIA_id`='2'; 

INSERT IGNORE INTO `DEPENDENCIA` SET `id`='4', `codigo`='OML', `descripcion`='Comm', `estado`='1', `fechaCreacion`='2024-06-28 16:20:10',
                             `nombre`='OMIL', `timbre`='omil.png', `SECTOR_id`='1', `TIPO_DEPENDENCIA_id`='3';                             
--tabla tipo cargo--
INSERT  IGNORE INTO `TIPO_PUESTO` set `id`= '1', `descripcion`='Jefatura', `nombre`='Jefatura';
INSERT  IGNORE INTO `TIPO_PUESTO` set `id`= '2', `descripcion`='Subrogancia', `nombre`='Subrogancia';
INSERT  IGNORE INTO `TIPO_PUESTO` set `id`= '3', `descripcion`='Administrativo', `nombre`='Administrativo';

--tabla puesto-
INSERT  IGNORE INTO `PUESTO` set `id`= '1',`nombre`='Alcalde', `funciones`='Fimar', `fechaCreacion`='2024-06-28 16:20:10', `fechaTermino`='null', `requerido`=1, `estado`='1', `DEPENDENCIA_id`='1', `TIPO_PUESTO_id`='1';
INSERT  IGNORE INTO `PUESTO` set `id`= '2',`nombre`='Administrador', `funciones`='Mandar', `fechaCreacion`='2024-06-28 16:20:10', `fechaTermino`='null', `requerido`=1, `estado`='1', `DEPENDENCIA_id`='2', `TIPO_PUESTO_id`='1';

--tabla moneda-
INSERT IGNORE INTO `MONEDA` SET `id` = 1 , `codigo`= 'CLP', `decimales` = 0, `descripcion` = 'Moneda en Chile', `nombre`='CLP' , `fechaCreacion`='2024-09-03 16:20:10';
INSERT IGNORE INTO `MONEDA` SET `id` = 2 , `codigo`= 'UTM', `decimales` = 2, `descripcion` = 'Unidad Tributaria Mensual', `nombre`='UTM' , `fechaCreacion`='2024-09-03 16:20:10';
INSERT IGNORE INTO `MONEDA` SET `id` = 3 , `codigo`= 'USD', `decimales` = 0, `descripcion` = 'Dolares Estadounidenses', `nombre`='USD' , `fechaCreacion`='2024-09-03 16:20:10';

--tabla tipo mecanismo de compra--

INSERT IGNORE INTO `CLASIFICACION_COMPRA` SET `id`='1', `descripcion`= 'Trato Directo', `nombre`='Trato Directo' , `fechaCreacion`='2024-09-03 16:20:10';
INSERT IGNORE INTO `CLASIFICACION_COMPRA` SET `id`='2', `descripcion`= 'Compra Agile', `nombre`='Compra Agile', `fechaCreacion`='2024-09-03 16:20:10';
INSERT IGNORE INTO `CLASIFICACION_COMPRA` SET `id`='3', `descripcion`= 'Convenio Marco', `nombre`='Convenio Marco', `fechaCreacion`='2024-09-03 16:20:10';
INSERT IGNORE INTO `CLASIFICACION_COMPRA` SET `id`='4', `descripcion`= 'Licitación Pública', `nombre`='Licitación Pública', `fechaCreacion`='2024-09-03 16:20:10';
INSERT IGNORE INTO `CLASIFICACION_COMPRA` SET `id`='4', `descripcion`= 'Licitación Privada', `nombre`='Licitación Privada', `fechaCreacion`='2024-09-03 16:20:10';
INSERT IGNORE INTO `CLASIFICACION_COMPRA` SET `id`='4', `descripcion`= 'Licitación Privada', `nombre`='Licitación Privada', `fechaCreacion`='2024-09-03 16:20:10';

--tabla mecanismo de compra--

INSERT IGNORE INTO `MECANISMO_COMPRA`SET `id`='1', `comentario`='Commentary', `monto_maximo`='30', `monto_minimo`='1', `fechaCreacion`='2024-09-03 16:20:10',
                                         `nombre`='Compra Agile <=30 UTM', `CLASIFICACION_COMPRA_ID`='1',`MONEDA_id`='1';

--tabla funcionario --

INSERT IGNORE INTO `FUNCIONARIO` SET`id`='1', `apellidos`='apellidos', `correo`='admin@nescorp.cl', `dni`='12345678',
                    `estado` ='1', `fechaCreacion`='2024-08-26 16:20:10', `nacimiento`='1994-02-12', `nombres`='Administrado SGD';
-- tabla usuario --

INSERT  IGNORE INTO `USUARIO`SET `id`='1', `estado`='1', `fechaCreacion`='2024-06-28 16:20:10',
                                            `password`='$2a$10$7yZd6FKtXmTzh3ajC4c1AOUiPyigUHGO0iFG1AmJms4OcOClb7FJq', 
                                            `role`='ADMIN', `FUNCIONARIO_id`='1';

-- tabla cargo --
INSERT IGNORE INTO `CARGO` SET `id`='1', `nombre`='Alcalde',`descripcion`='Com', `estado`='1', `fechaCreacion`='2024-09-03 16:20:10',
                        `fechaTermino`=null, `titular`= 1, `FUNCIONARIO_id`='1', `PUESTO_id`='1';  

-- tabla requisito--
INSERT IGNORE INTO `REQUISITO` SET `id`='1', `descripcion`='Documento Legal', `extensiones`='.pdf', `formatoBase`='ruta.doc', `nombre`='Cotizacion', `cantidad`=1, `obligatorio`=1, `MECANISMO_COMPRA_id`=1, `fechaCreacion`='2024-09-03 16:20:10' ;                             

                                           