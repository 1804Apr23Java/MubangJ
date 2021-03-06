

CREATE TABLE USERS (
    USER_ID NUMBER(38,0) PRIMARY KEY,
    USER_NAME VARCHAR2(100) UNIQUE NOT NULL,
    USER_PASSWORD VARCHAR2(100) NOT NULL, 
    SUPERUSER VARCHAR2(1) NOT NULL
);
/
--
CREATE TABLE ACCOUNTS (
    USER_ID NUMBER NOT NULL,
    ACCOUNT_NAME VARCHAR2(100) NOT NULL, 
    AMOUNT NUMBER(32,2) DEFAULT 0.00 NOT NULL,
    CONSTRAINT ACCOUNT_PK PRIMARY KEY (USER_ID, ACCOUNT_NAME)
);
/

--BANK_ACCOUNT_ID
CREATE TABLE TRANSACTIONS (
    TRANSACTION_ID NUMBER(38,0) PRIMARY KEY,
    USER_ID NUMBER NOT NULL,
    BANK_ACCOUNT_NAME VARCHAR2(100) NOT NULL, 
    AMOUNT NUMBER(32,2) NOT NULL,
    TRANSACTION_DATE TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
/

CREATE SEQUENCE SQ_USERS 
START WITH 1
INCREMENT BY 1;

CREATE SEQUENCE SQ_TRANSACTIONS
START WITH 1
INCREMENT BY 1;

CREATE OR REPLACE TRIGGER TR_INSERT_USERS
BEFORE INSERT ON USERS
FOR EACH ROW
    BEGIN
        :new.USER_ID := SQ_USERS.NEXTVAL;
    END;
/    

DROP TRIGGER TR_INSERT_TRANSACTIONS;

CREATE OR REPLACE TRIGGER TR_INSERT_TRANSACTIONS
BEFORE INSERT ON TRANSACTIONS
FOR EACH ROW
    BEGIN
        :new.TRANSACTION_ID := SQ_TRANSACTIONS.NEXTVAL;
    END;
/

CREATE OR REPLACE PROCEDURE deleteUserProcedure
(userId IN NUMBER,username IN VARCHAR2, pass IN VARCHAR2)
IS
BEGIN
  DELETE FROM TRANSACTIONS WHERE USER_ID = userId;  
  DELETE FROM ACCOUNTS WHERE USER_NAME = username;
  DELETE FROM USERS WHERE USER_ID = userId;
END;
/

insert into users (USER_NAME, USER_PASSWORD, SUPERUSER) values ('user', 'pass', 'n');




