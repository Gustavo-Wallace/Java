CREATE TABLE `chocolatesbd`.`produto` (
  `id_produto` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NOT NULL,
  `preco` DOUBLE NOT NULL,
  `quantidade` INT NOT NULL,
  `vendedor` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id_produto`));
