
-- tables


CREATE TABLE USERS (
    
    USERID INTEGER NOT NULL PRIMARY KEY,
    USERNAME VARCHAR2(25) UNIQUE NOT NULL,
    UPASSWORD VARCHAR2(100) NOT NULL,
    FNAME VARCHAR2(100) NOT NULL,
    LNAME VARCHAR2(100) NOT NULL,
    EMAIL VARCHAR2(100) UNIQUE,
    MANAGERID INTEGER NOT NULL,
    MANAGER NUMBER(2) DEFAULT 0 NOT NULL
);
/

UPDATE USERS SET LNAME = 'Renz' WHERE USERID = 87;
/


--SELECT r.REIMBURSEMENTID, r.EMPLOYEEID, r.MANAGERID, e.FNAME, e.LNAME, m.FNAME AS MANFNAME, m.LNAME AS MANLNAME, r.PURPOSE, r.STATUS, r.AMOUNT, r.DATETIME 
--FROM REIMBURSEMENTS r 
--INNER JOIN USERS e 
--ON r.EMPLOYEEID = e.USERID 
--INNER JOIN USERS m
--ON r.MANAGERID = m.USERID
--WHERE r.EMPLOYEEID = ?;
--/


SELECT e.USERID, e.USERNAME, e.UPASSWORD, e.FNAME, e.LNAME, e.EMAIL, e.MANAGERID, m.FNAME AS MANFNAME, m.LNAME AS MANLNAME, e.MANAGER 
FROM USERS e, USERS m
WHERE e.MANAGERID = m.USERID
AND e.USERID = ?;
/

UPDATE USERS SET MANAGERID = 1 WHERE USERID = 1;
/
commit;

UPDATE REIMBURSEMENTS SET STATUS = 1 WHERE REIMBURSEMENTID = 2;
commit;
/

UPDATE REIMBURSEMENTS SET EMPLOYEEID = 87 WHERE EMPLOYEEID = 1;
/

commit;
/

--ALTER TABLE USERS ADD MANAGERID INTEGER DEFAULT 1 NOT NULL;
--/
--commit;

SELECT r.REIMBURSEMENTID, r.EMPLOYEEID, r.MANAGERID, e.FNAME, e.LNAME, r.PURPOSE, r.IMAGE, r.STATUS, r.AMOUNT, r.DATETIME FROM REIMBURSEMENTS r
INNER JOIN USERS e
ON r.EMPLOYEEID = e.USERID
WHERE r.EMPLOYEEID = 1;
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
    MANAGERID INTEGER NOT NULL,
    PURPOSE VARCHAR2(200) NOT NULL,
    IMAGE BLOB,
    STATUS NUMBER(1) NOT NULL,
    AMOUNT NUMBER(38,2) DEFAULT 0.00,
    DATETIME TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
    CONSTRAINT fk_EMPLOYEE
    FOREIGN KEY (EMPLOYEEID)
    REFERENCES USERS(USERID)
);
/

--ALTER TABLE REIMBURSEMENTS ADD PURPOSE VARCHAR2(200) DEFAULT '?' NOT NULL;
--commit;
--/

--ALTER TABLE REIMBURSEMENTS
--CONSTRAINT fk_EMPLOYEE
--FOREIGN KEY (EMPLOYEEID)
--REFERENCES USERS(USERID)

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

