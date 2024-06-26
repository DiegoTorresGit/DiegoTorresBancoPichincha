CREATE TABLE BAN_TYPE_ACCOUNT
(
    PK_TC_ID INT AUTO_INCREMENT PRIMARY KEY,
    TYPE     VARCHAR(50) NOT NULL,
    STATE    BOOLEAN     NOT NULL
);
CREATE TABLE BAN_PERSON
(
    PK_PERSON_ID BIGINT AUTO_INCREMENT PRIMARY KEY,
    NAME         VARCHAR(50)  NOT NULL,
    ADDRES       VARCHAR(200) NOT NULL,
    PHONE        VARCHAR(20)  NOT NULL,
    PASSWORD     VARCHAR(50)  NOT NULL,
    STATE        BOOLEAN      NOT NULL
);
CREATE TABLE BAN_CLIENT
(
    PK_CLIENT_ID BIGINT AUTO_INCREMENT PRIMARY KEY,
    DATE         DATE    NOT NULL,
    STATE        BOOLEAN NOT NULL,
    FK_PERSON_ID BIGINT  NOT NULL,
    FOREIGN KEY (FK_PERSON_ID) REFERENCES BAN_PERSON (PK_PERSON_ID)
);
CREATE TABLE BAN_ACCOUNT
(
    PK_ACCOUNT_ID   BIGINT AUTO_INCREMENT PRIMARY KEY,
    NUMBER          BIGINT         NOT NULL,
    STATE           BOOLEAN        NOT NULL,
    FK_CLIENT_ID    BIGINT         NOT NULL,
    INITIAL_BALANCE DECIMAL(18, 2) NOT NULL,
    FK_TC_ID        INT            NOT NULL,
    FOREIGN KEY (FK_TC_ID) REFERENCES BAN_TYPE_ACCOUNT (PK_TC_ID)
);
CREATE TABLE BAN_TRANSACTION
(
    PK_TRANSACTION_ID BIGINT AUTO_INCREMENT PRIMARY KEY,
    DATETIME_TRA          TIMESTAMP      NOT NULL,
    VALUE_TRA             DECIMAL(18, 2) NOT NULL,
    AVAILABLE_BALANCE DECIMAL(18, 2) NOT NULL,
    FK_ACCOUNT_ID     BIGINT         NOT NULL,
    INITIAL_BALANCE   DECIMAL(18, 2) NOT NULL,
    FOREIGN KEY (FK_ACCOUNT_ID) REFERENCES BAN_ACCOUNT (PK_ACCOUNT_ID)
);

INSERT INTO BAN_TYPE_ACCOUNT (TYPE, STATE) VALUES ('AHORROS', TRUE);
INSERT INTO BAN_TYPE_ACCOUNT (TYPE, STATE) VALUES ('CORRIENTE', TRUE);

INSERT INTO BAN_PERSON (NAME, ADDRES, PHONE, PASSWORD, STATE) VALUES ('JOSE LEMA', 'OTAVALA SN Y PRINCIPAL', '09825475', '1234', TRUE);
INSERT INTO BAN_PERSON (NAME, ADDRES, PHONE, PASSWORD, STATE) VALUES ('MARIANELA MONTALVO', 'AMAZONAS Y NNUU', '097548965', '5678', TRUE);
INSERT INTO BAN_PERSON (NAME, ADDRES, PHONE, PASSWORD, STATE) VALUES ('JUAN OSORIO', '13 JUNIO Y EQUINOCCIAL', '098874587', '1245', TRUE);

INSERT INTO BAN_CLIENT (DATE, STATE, FK_PERSON_ID) VALUES ('2024-03-29', TRUE, 1);
INSERT INTO BAN_CLIENT (DATE, STATE, FK_PERSON_ID) VALUES ('2024-03-29', TRUE, 2);
INSERT INTO BAN_CLIENT (DATE, STATE, FK_PERSON_ID) VALUES ('2024-03-29', TRUE, 3);

INSERT INTO BAN_ACCOUNT (NUMBER, FK_TC_ID, STATE, FK_CLIENT_ID, INITIAL_BALANCE) VALUES (225487, 2, TRUE, 2, 100);
INSERT INTO BAN_ACCOUNT (NUMBER, FK_TC_ID, STATE, FK_CLIENT_ID, INITIAL_BALANCE) VALUES (495878, 1, TRUE, 3, 0);
INSERT INTO BAN_ACCOUNT (NUMBER, FK_TC_ID, STATE, FK_CLIENT_ID, INITIAL_BALANCE) VALUES (496825, 1, TRUE, 2, 540);
INSERT INTO BAN_ACCOUNT (NUMBER, FK_TC_ID, STATE, FK_CLIENT_ID, INITIAL_BALANCE) VALUES (585545, 2, TRUE, 1, 1000);

INSERT INTO BAN_TRANSACTION (DATETIME_TRA, VALUE_TRA, AVAILABLE_BALANCE, FK_ACCOUNT_ID, INITIAL_BALANCE) VALUES ('2024-03-30 10:05:12.89', -575.00, 1425.00, 1, 2000);
INSERT INTO BAN_TRANSACTION (DATETIME_TRA, VALUE_TRA, AVAILABLE_BALANCE, FK_ACCOUNT_ID, INITIAL_BALANCE) VALUES ('2024-03-30 10:05:12.10', 100.00, 700.00, 2, 100);
INSERT INTO BAN_TRANSACTION (DATETIME_TRA, VALUE_TRA, AVAILABLE_BALANCE, FK_ACCOUNT_ID, INITIAL_BALANCE) VALUES ('2024-03-30 10:05:12.11', 150.00, 150.00, 3, 0);
INSERT INTO BAN_TRANSACTION (DATETIME_TRA, VALUE_TRA, AVAILABLE_BALANCE, FK_ACCOUNT_ID, INITIAL_BALANCE) VALUES ('2024-03-30 10:05:12.13', -540.00, 0.00, 4, 540);

