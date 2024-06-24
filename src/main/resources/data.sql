-- tabla sector --
INSERT IGNORE INTO `sector` set `id` = '1', `descripcion`='Municipal', `nombre`= 'Municipal';

--tabla unidad --
INSERT IGNORE INTO `unidad` SET `id`='1', `descripcion`='Unidad Tributaria Mensual', `nombre`='UTM';

--tabla tipo dependencia--
INSERT IGNORE INTO `tipo_dependencia` set `id`= '1', `descripcion`='Dirección', `nombre`='Dirección';

--tabla dependencia--
INSERT IGNORE INTO `dependencia` SET `id`='1', `codigo`='ALC', `descripcion`='Comm', `estado`='1', `fechaCreacion`='2024-06-28 16:20:10',
                             `nombre`='ALCALDIA', `timbre`='alcaldia.png', `SECTOR_id`='1', `TIPO_DEPENDENCIA_id`='1';
                             
--tabla tipo cargo--
INSERT  IGNORE INTO `tipo_cargo`set `id`= '1', `descripcion`='Jefatura', `nombre`='Jefatura';

--tabla tipo mecanismo de compra--

INSERT IGNORE INTO `tipo_mecanismo_compra` SET `id`='1', `descripcion`= 'Compra Agile', `nombre`='Compra Agile';

--tabla mecanismo de compra--

INSERT IGNORE INTO `mecanismo_compra`SET `id`='1', `comentario`='Commentary', `monto_maximo`='30', `monto_minimo`='1',
                                         `nombre`='Compra Agile <=30 UTM', `TIPO_MECANISMO_COMPRA_ID`='1',`UNIDAD_id`='1';

--tabla funcionario --

INSERT IGNORE INTO `funcionario` SET`id`='1', `apellidos`='Rojas Andrade', `correo`='alcaldia@email.com', `dni`='12345678',
                    `estado` ='1', `fechaCreacion`='2024-06-28 16:20:10', `nacimiento`='1994-02-12', `nombres`='Juan Raul ';
-- tabla usuario --

INSERT  IGNORE INTO `usuario`SET `id`='1', `estado`='1', `fechaCreacion`='2024-06-28 16:20:10',
                                            `password`='$2a$10$7yZd6FKtXmTzh3ajC4c1AOUiPyigUHGO0iFG1AmJms4OcOClb7FJq', 
                                            `role`='ADMIN', `FUNCIONARIO_id`='1';

--tabla cargo--
INSERT IGNORE INTO `cargo` SET `id`='1', `descripcion`='Com', `estado`='1', `fechaCreacion`='2024-06-28 16:20:10',
                        `fechaTermino`=null, `nombre`='Alcalde', `titular`= 1, `vigencia`=1, `DEPENDENCIA_id`='1',
                         `FUNCIONARIO_id`='1', `TIPO_CARGO_id`='1';                                            

                                           

                                           