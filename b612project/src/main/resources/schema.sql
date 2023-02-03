use happyhouse;

drop table if exists `favorite`;
drop table if exists `memo`;
drop table if exists `board`;
drop table if exists `users`;

CREATE TABLE `users` (
  `id` varchar(40) NOT NULL,
  `pwd` varchar(40) NOT NULL,
  `name` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `address` varchar(40) NOT NULL,
  `tel` varchar(40) NOT NULL,
  `question` varchar(50) NOT NULL,
  `answer` varchar(50) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`),
  CONSTRAINT CHK_Id CHECK (`id` not regexp '[`~!#$%^&*|\'\";:\/?@]'),
  CONSTRAINT CHK_Pwd CHECK (length(`pwd`)>5),
  CONSTRAINT CHK_Tel CHECK (`tel` regexp '[0-9]{3}-[0-9]{4}-[0-9]{4}')
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

insert into users (id, pwd, name, address, tel, question, answer) values ('ssafy', 'ssafypwd', 'ssafy', 'ssafy', '010-0000-0000', 'ssafy 학번은?', '0000000');


drop table if exists environment;

create table environment
(
	facility_name varchar(50) not null,
    license_number varchar(50) not null,
    industry_code int not null,
    industry_name varchar(50) not null,
    inspection_date varchar(10) not null,
    inspection_agency_code varchar(10) not null,
    inspection_agency_code_name varchar(50) not null,
    classification varchar(10) not null,
    y_n varchar(1),
    check_list varchar(50) not null,
    inspection_result varchar(50),
    street_name_address varchar(50),
    address varchar(50)
);

drop table if exists commercial;

create table commercial
(
	commercial_code varchar(50) not null,
    name varchar(50) not null,
    classfication_code varchar(50) not null,
    classfication_name varchar(50) not null,
    sido_code varchar(30) not null,
    sido_name varchar(30) not null,
    dong_code varchar(50) not null,
    dong_name varchar(50) not null,
    street_name_address varchar(50),
    address varchar(50),
    lon float not null,
    lat float not null
);

-- -----------------------------------------------------
-- Table `happyhouse`.`board`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `happyhouse`.`memo` ;
DROP TABLE IF EXISTS `happyhouse`.`board` ;

CREATE TABLE IF NOT EXISTS `happyhouse`.`board` (
  `article_no` INT NOT NULL AUTO_INCREMENT,
  `user_id` VARCHAR(16) NULL DEFAULT NULL,
  `subject` VARCHAR(100) NULL DEFAULT NULL,
  `content` VARCHAR(2000) NULL DEFAULT NULL,
  `hit` INT NULL DEFAULT 0,
  `register_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`article_no`),
  INDEX `board_to_members_user_id_fk` (`user_id` ASC) VISIBLE,
  CONSTRAINT `board_to_members_user_id_fk`
    FOREIGN KEY (`user_id`)
    REFERENCES `happyhouse`.`users` (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 1
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `happyhouse`.`memo`
-- -----------------------------------------------------

CREATE TABLE IF NOT EXISTS `happyhouse`.`memo` (
  `memo_no` INT NOT NULL AUTO_INCREMENT,
  `user_id` VARCHAR(16) NULL DEFAULT NULL,
  `comment` VARCHAR(500) NULL DEFAULT NULL,
  `memo_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `article_no` INT NULL DEFAULT NULL,
  PRIMARY KEY (`memo_no`),
  INDEX `memo_to_board_article_no_fk` (`article_no` ASC) VISIBLE,
  INDEX `memo_to_member_fk_idx` (`user_id` ASC) VISIBLE,
  CONSTRAINT `memo_to_board_article_no_fk`
    FOREIGN KEY (`article_no`)
    REFERENCES `happyhouse`.`board` (`article_no`),
  CONSTRAINT `memo_to_member_user_id_fk`
    FOREIGN KEY (`user_id`)
    REFERENCES `happyhouse`.`users` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 1
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


DROP TABLE IF EXISTS qna;

CREATE TABLE IF NOT EXISTS qna (
  `articleno` INT NOT NULL AUTO_INCREMENT,
  `userid` VARCHAR(16) NULL DEFAULT NULL,
  `subject` VARCHAR(100) NULL DEFAULT NULL,
  `content` VARCHAR(2000) NULL DEFAULT NULL,
  `hit` INT NULL DEFAULT 0,
  `regtime` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`articleno`),
  INDEX `board_to_member_fk` (`userid` ASC) VISIBLE,
  CONSTRAINT `board_to_member_fk`
    FOREIGN KEY (`userid`)
    REFERENCES `happyhouse`.`users` (`id`));
    
    
    
use happyhouse;

alter table users add `joindate` TIMESTAMP not null default current_timestamp;
alter table users add `token` varchar(1000) null default null;



DROP TABLE IF EXISTS `happyhouse`.`memo` ;
DROP TABLE IF EXISTS `happyhouse`.`board` ;

CREATE TABLE IF NOT EXISTS `happyhouse`.`board` (
  `articleno` INT NOT NULL AUTO_INCREMENT,
  `userid` VARCHAR(16) NULL DEFAULT NULL,
  `subject` VARCHAR(100) NULL DEFAULT NULL,
  `content` VARCHAR(2000) NULL DEFAULT NULL,
  `hit` INT NULL DEFAULT 0,
  `regtime` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`articleno`),
  INDEX `board_to_users_fk` (`userid` ASC) VISIBLE,
  CONSTRAINT `board_to_users_fk`
    FOREIGN KEY (`userid`)
    REFERENCES `happyhouse`.`users` (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 1
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


DROP TABLE IF EXISTS `happyhouse`.`question` ;

CREATE TABLE IF NOT EXISTS `happyhouse`.`question` (
  `articleno` INT NOT NULL AUTO_INCREMENT,
  `userid` VARCHAR(16) NULL DEFAULT NULL,
  `subject` VARCHAR(100) NULL DEFAULT NULL,
  `content` VARCHAR(2000) NULL DEFAULT NULL,
  `hit` INT NULL DEFAULT 0,
  `regtime` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`articleno`),
  INDEX `question_to_users_fk` (`userid` ASC) VISIBLE,
  CONSTRAINT `question_to_users_fk`
    FOREIGN KEY (`userid`)
    REFERENCES `happyhouse`.`users` (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 1
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;

DROP TABLE IF EXISTS `happyhouse`.`answer` ;

CREATE TABLE IF NOT EXISTS `happyhouse`.`answer` (
  `articleno` INT NOT NULL AUTO_INCREMENT,
  `refno` INT NOT NULL,
  `userid` VARCHAR(16) NULL DEFAULT NULL,
  `subject` VARCHAR(100) NULL DEFAULT NULL,
  `content` VARCHAR(2000) NULL DEFAULT NULL,
  `likeval` INT NULL DEFAULT 0,
  `regtime` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`articleno`),
  INDEX `answer_to_users_fk` (`userid` ASC) VISIBLE,
  CONSTRAINT `answer_to_users_fk`
    FOREIGN KEY (`userid`)
    REFERENCES `happyhouse`.`users` (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 1
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


CREATE TABLE IF NOT EXISTS `happyhouse`.`news`(
	`title` VARCHAR(200) NULL DEFAULT NULL,
    `originallink` VARCHAR(2000) NULL DEFAULT NULL,
    `link` VARCHAR(2000) NULL DEFAULT NULL,
    `description` VARCHAR(2000) NULL DEFAULT NULL,
    `pubDate` VARCHAR(2000) NULL DEFAULT NULL
)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;

set sql_safe_updates=0;

select * from news;