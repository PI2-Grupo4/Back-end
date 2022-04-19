## Programas Necessários

Para conseguir executar a API, serão necessários os seguintes programas

### JDK

O Kit de Desenvolvimento Java (do inglês Java Development Kit - JDK) é um conjunto de utilitários que
permitem criar sistemas de software para a plataforma Java. É composto por compilador e bibliotecas.
A versão utilizada no projeto é a 11.0.14.1 e pode ser obtida através deste
[`link`](https://www.oracle.com/br/java/technologies/javase/jdk11-archive-downloads.html)

### Maven

A Apache Maven é uma ferramenta de automação de compilação bastante utilizada em projetos Java.
Ela fornece uma forma padronizada de automação, construção e publicação das aplicações, adicionando
qualidade ao produto final. A versão utilizada no projeto é a 3.6.3 e pode ser obtida através deste
[`link`](https://downloads.apache.org/maven/maven-3/3.6.3/binaries/).

### MySQL

O sistema de gerenciamento de banco de dados utilizado pelo projeto é o MySQL, desenvolvida pela Oracle.
O MySQL foi utilizado para a criação de um banco de dados para armazenamento e manipulação de dados,
definindo a relação de cada tabela. A versão utilizada no projeto é a 8.0.28 e pode ser obtida através deste
[`link`](https://dev.mysql.com/downloads/installer/).

### Mosquitto MQTT Broker

O Mosquitto é um tipo de gerenciador de mensagens de código aberto que implementa o protocolo MQTT, ele age
como Broker e possui um host que pode ser utilizado para teste ou pode ser baixado e configurado de acordo
com as preferências do cliente. A versão utilizada no projeto é a 1.6.9 e pode ser obtida através deste
[`link`](https://mosquitto.org/download/).

## Criando o banco de dados

A estrutura do banco de dados deve ser executada no MySQL para que a estrutura utilizada no projeto exista na máquina.
O arquivo application.properties possui configurações iniciais que do usuário que possui acesso ao banco:

- **spring.datasource.username**: Usuário que acessa o banco de dados.
- **spring.datasource.password**: Senha do usuário que acessa o banco de dados.

Para o correto funcionamento do banco, é necessário o preenchimento deste campo como no seguinte exemplo:

```
spring.datasource.username=api_user
spring.datasource.password=api_password
```


```sql
-- -----------------------------------------------------
-- Schema back-end-db
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `back-end-db`;

CREATE SCHEMA `back-end-db`;
USE `back-end-db`;

-- -----------------------------------------------------
-- Table `back-end-db`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `back-end-db`.`user` (
  `user_id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(100) NOT NULL,
  `name` VARCHAR(100) NOT NULL,
  `email` VARCHAR(100) NOT NULL,
  `password` VARCHAR(32) NOT NULL,
  PRIMARY KEY (`user_id`))
ENGINE=InnoDB
AUTO_INCREMENT = 1;

-- -----------------------------------------------------
-- Table `back-end-db`.`equipment`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `back-end-db`.`equipment` (
  `equipment_id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `status` BIT DEFAULT 0,
  `speed` VARCHAR(3) DEFAULT NULL,
  `direction` BIT DEFAULT 0,
  `water_consumption` DECIMAL(5,2) DEFAULT NULL,
  `water_level` INT(3) DEFAULT NULL,
  `battery_level` INT(3) DEFAULT NULL,
  `battery_status` INT(2) DEFAULT NULL,
  `user_id` BIGINT(20) NOT NULL,
  PRIMARY KEY (`equipment_id`)
) 
ENGINE=InnoDB
AUTO_INCREMENT = 1;

ALTER TABLE `equipment` ADD CONSTRAINT FK_EQUIPAMENTO_2
    FOREIGN KEY (user_id)
        REFERENCES `user` (user_id)
        ON DELETE RESTRICT;
```

## Rodando a aplicação

Com o banco de dados já estruturado e o Mosquitto MQTT Broker rodando na máquina acesse a pasta root do projeto e execute
o seguinte comando:

```bash
mvn spring-boot:run
```

A API estará rodando na [porta 8080](http://localhost:8080). E o Mosquitto MQTT Broker na [porta 1883](http://localhost:1883).

## Rotas

**GET: `/api/equipmentInfo?id=`**

Para receber os dado do equipamento.

**PUT: `/api/changeDirection`**

Para alterar a direção do equipamento. Para o equipamento ir para a direita o valor deve ser **true**, caso contrário **false**.

```json
{
    "id": "ID do equipamento",
    "direction": false
}
```

**PUT: `/api/changeSpeed`**

Para alterar a velocidade do equipamento. Possuindo os três modos de velocidade:

- 1 = Low
- 2 = Medium
- 3 = High

```json
{
    "id": "ID do equipamento",
    "speed": 2
}
```

**PUT: `/api/power`**

Para alterar ligar/desligar o equipamento.

- true = Ligado
- false = Desligado

```json
{
    "id": "ID do equipamento",
    "isOn": false
}
```
