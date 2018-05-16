
-- tables


CREATE TABLE USERS (
    
    USERID INTEGER NOT NULL PRIMARY KEY,
    USERNAME VARCHAR2(25) UNIQUE NOT NULL,
    UPASSWORD VARCHAR2(100) NOT NULL,
    EMAIL VARCHAR2(100) UNIQUE,
    MANAGER NUMBER(1) DEFAULT 0 NOT NULL
);
/

-- not using anymore
--CREATE TABLE MANAGERS (
--    
--    MANAGERID INTEGER NOT NULL PRIMARY KEY,
--    USERNAME VARCHAR2(25) UNIQUE NOT NULL,
--    MPASSWORD VARCHAR2(100) NOT NULL,
--    EMAIL VARCHAR2(100) UNIQUE
--);
--/

CREATE TABLE REIMBURSEMENTS (
    
    REIMBURSEMENTID INTEGER NOT NULL PRIMARY KEY,
    EMPLOYEEID INTEGER NOT NULL,
    IMAGE BLOB,
    STATUS NUMBER(1) NOT NULL,
    DATETIME TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
    CONSTRAINT fk_EMPLOYEE
    FOREIGN KEY (EMPLOYEEID)
    REFERENCES USERS(USERID)
);
/

select * from reimbursements;
/


CREATE TABLE MANAGERDECISION (
    
    MANAGERID INTEGER NOT NULL,
    REIMBURSEMENTID INTEGER NOT NULL,
    DECISION NUMBER(1),
    DATETIME TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
    CONSTRAINT fk_REIMBURSEMENTS
    FOREIGN KEY (REIMBURSEMENTID)
    REFERENCES REIMBURSEMENTS(REIMBURSEMENTID),
    CONSTRAINT fk_MANAGER
    FOREIGN KEY (MANAGERID)
    REFERENCES USERS(USERID),
    CONSTRAINT pk_MANAGERDECISION
    PRIMARY KEY(MANAGERID, REIMBURSEMENTID)
);
/

-- sequences

CREATE SEQUENCE USERS_SQ
    MINVALUE 1
    START WITH 1
    INCREMENT BY 1;
/

 CREATE SEQUENCE REIMBURSEMENTS_SQ
 MINVALUE 1
 START WITH 1 
 INCREMENT BY 1;
 /
 

-- triggers
 
 
CREATE OR REPLACE TRIGGER USERS_TRIG
BEFORE INSERT ON USERS
FOR EACH ROW
BEGIN
	SELECT USERS_SQ.NEXTVAL INTO :NEW.USERID FROM DUAL;
END;
/


CREATE OR REPLACE TRIGGER REIMBURSEMENTR_TRIG
BEFORE INSERT ON REIMBURSEMENTS
FOR EACH ROW
BEGIN
	SELECT REIMBURSEMENTS_SQ.NEXTVAL INTO :NEW.REIMBURSEMENTID FROM DUAL;
END;
/
