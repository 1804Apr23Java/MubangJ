CREATE TABLE BEAR (
    BEAR_ID INTEGER PRIMARY KEY,
    BEAR_NAME VARCHAR2(100),
    BEAR_BIRTHDATE DATE,
    BEAR_WEIGHT NUMBER(5,2) DEFAULT 200.00,
    BEAR_TYPE_ID INTEGER NOT NULL,
    CAVE_ID INTEGER
);
/

CREATE TABLE BEAR_TYPE (
    BEAR_TYPE_ID INTEGER PRIMARY KEY,
    BEAR_TYPE_NAME VARCHAR(200)
);
/
CREATE TABLE CAVE (
    CAVE_ID INTEGER PRIMARY KEY,
    CAVE_NAME VARCHAR(100),
    MAX_BEARS INTEGER DEFAULT 4
);
/
CREATE TABLE BEHIVE (
    BEEHIVE_ID INTEGER PRIMARY KEY,
    BEHIVE_WEIGHT NUMBER(5,2) DEFAULT 75.00
);
/
CREATE TABLE BEAR_BEEHIVE (
    BEAR_ID INTEGER,
    BEEHIVE_ID INTEGER,
    PRIMARY KEY (BEAR_ID, BEEHIVE_ID)
);
/

-- Foreign Key Constraints

ALTER TABLE BEAR
ADD CONSTRAINT FK_BEAR_BEAR_TYPE
FOREIGN KEY (BEAR_TYPE_ID) REFERENCES BEAR_TYPE(BEAR_TYPE_ID);
/

ALTER TABLE BEAR
ADD CONSTRAINT FK_BEAR_CAVE
FOREIGN KEY (CAVE_ID) REFERENCES CAVE(CAVE_ID);
/

ALTER TABLE BEAR_BEEHIVE
ADD CONSTRAINT FK_BEAR_BEAR_BEEHIVE
FOREIGN KEY (BEAR_ID) REFERENCES BEAR(BEAR_ID);
/

-- Add SOME DATA
INSERT INTO BEAR_TYPE VALUES (1, 'Grizzly');
INSERT INTO BEAR_TYPE(BEAR_TYPE_ID, BEAR_TYPE_NAME) VALUES (2, 'Polar');

INSERT ALL 
INTO CAVE VALUES (1, 'AWESOMECAVE', 9)
INTO CAVE(CAVE_ID, CAVE_NAME) VALUES (2, 'AWESOMECAVE2')
SELECT * FROM DUAL;
/


INSERT INTO BEAR (BEAR_ID, BEAR_NAME, BEAR_BIRTHDATE, BEAR_TYPE_ID, CAVE_ID)
VALUES (3, 'Ferdinand',  TO_DATE ('1987-08-18 00:00:00', 'yyyy-mm-dd hh24:mi:ss'), 1, 2);
INSERT INTO BEAR (BEAR_ID, BEAR_NAME, BEAR_BIRTHDATE, BEAR_TYPE_ID, CAVE_ID)
VALUES (8, 'Ernest',  TO_DATE ('1987-08-18 00:00:00', 'yyyy-mm-dd hh24:mi:ss'), 1, 2);
INSERT INTO BEAR
VALUES (9, 'Elon',  TO_DATE ('2000-02-18 00:00:00', 'yyyy-mm-dd hh24:mi:ss'), 400.00, 2, 1);
INSERT INTO BEAR
VALUES (11, 'Yoda',  TO_DATE ('2000-02-18 00:00:00', 'yyyy-mm-dd hh24:mi:ss'), 450.00, 2, 1);
--SELECT * FROM DUAL;

INSERT ALL
INTO BEAR_BEEHIVE
VALUES (3, );
INTO BEAR_BEEHIVE
VALUES (8, )
INTO BEAR_BEEHIVE 
VALUES (9, )
INTO BEAR_BEEHIVE 
VALUES (11, )
SELECT * FROM BEAR_BEEHIVE;

-- ALTER TABLE

ALTER TABLE BEAR_TYPE 
ADD SURVIVAL_PROCEDURE VARCHAR2(200);
/

-- ADD SOME NEW VALUES FOR ALTERED COLUMN

UPDATE BEAR_TYPE
SET SURVIVAL_PROCEDURE = ‘play dead’
WHERE BEAR_TYPE_ID = 1;
/

UPDATE BEAR_TYPE
SET SURVIVAL_PROCEDUREE = ‘lol none’
WHERE BEAR_TYPE_ID = 2;
/

-- Write a select statement to display bears and corresponding caves in same result set

SELECT b.BEAR_NAME , c.CAVE_NAME
FROM BEAR b
INNER JOIN ON CAVE c WHERE b.CAVE_ID = c.CAVE_ID;

----- triggers

CREATE SEQUENCE SQ_BEAR_PK
START WITH 93
INCREMENT BY 1;
/

CREATE SEQUENCE SQ_CAVE_PK
START WITH 3
INCREMENT BY 1;
/

CREATE SEQUENCE SQ_BEAR_TYPE_PK
START WITH 3
INCREMENT BY 1;
/

CREATE SEQUENCE SQ_BEEHIVE_PK
START WITH 3
INCREMENT BY 1;
/

CREATE OR REPLACE TRIGGER TR_INSERT_BEAR
BEFORE INSERT ON BEAR
FOR EACH ROW
BEGIN
	SELECT SQ_BEAR_PK.NEXTVAL INTO :NEW.BEAR_ID FROM DUAL;
END;
/

-- USE TRIGGERS TO GENERATE PRIMARY KEYS…
INSERT INTO BEAR (BEAR_NAME, BEAR_BIRTHDATE, BEAR_WEIGHT, BEAR_TYPE_ID, CAVE_ID)
VALUES ('Stacy2', TO_DATE('2000-02-18 00:00:00', 'yyyy-mm-dd hh24:mi:ss'), DEFAULT, 2, 2);

-- ADD A CHECK CONSTRAINT ON BEAR_WEIGHT AND BEEHIVE WEIGHT

ALTER TABLE BEAR ADD CONSTRAINT CK_BEAR_WEIGHT_POSITIVE
CHECK (BEAR_WEIGHT > 0);

ALTER TABLE BEHIVE ADD CONSTRAINT CK_BEEHIVE_WEIGHT_POSITIVE
CHECK (BEHIVE_WEIGHT > 0);

-- ADD A UNIQUE CONSTRAINT ON BEAR NAME

ALTER TABLE BEAR ADD CONSTRAINT UQ_BEAR_NAME
UNIQUE (BEAR_NAME);

-- Views

-- How many Bears Per CAVE?
-- NOTE: This uses a system-defined aggregate function 'COUNT'
-- UNDERSTAND THE DIFFERENCE BETWEEN SCALAR AND AGGREGATE FUNCTIONS

CREATE VIEW VW_BEARS_PER_CAVE(CAVE,NUMBEAR)
AS
SELECT CAVE_NAME, COUNT(BEAR_ID)
FROM BEAR, CAVE
WHERE BEAR.CAVE_ID = CAVE.CAVE_ID
GROUP BY CAVE_NAME;

SELECT * FROM VW_BEARS_PER_CAVE;


-- FUNCTIONS

CREATE OR REPLACE FUNCTION FIND_MAX_NUMBER (X IN NUMBER, Y IN NUMBER)
    RETURN NUMBER
    IS Z NUMBER;
    BEGIN
        IF X > Y THEN
        Z := X; -- PL/SQL ASSIGNMENT OPERATOR
        ELSE
        Z := Y;
        END IF;
        RETURN Z;
    END;

DECLARE
FIRST_NUM NUMBER;
SECOND_NUM NUMBER;
MAX_NUM NUMBER;
BEGIN
    FIRST_NUM := 22;
    SECOND_NUM := 42;
    MAX_NUM := FIND_MAX_NUMBER(FIRST_NUM, SECOND_NUM);
    DBMS_OUTPUT.PUT_LINE('MAX: ' || MAX_NUM);
END;

-- STORED PROCEDURES

-- SP WITH A CURSOR AND LOOPING

CREATE OR REPLACE PROCEDURE GET_ALL_BEARS( S OUT SYS_REFCURSOR)
IS
BEGIN
OPEN S FOR
SELECT BEAR_ID, BEAR_NAME FROM BEAR;
END;

DECLARE
S SYS_REFCURSOR ;
SOME_ID BEAR.BEAR_ID%TYPE;
SOME_NAME BEAR.BEAR_NAME%TYPE;
BEGIN
    GET_ALL_BEARS(S);
    LOOP
        FETCH S INTO SOME_ID, SOME_NAME;
        EXIT WHEN S%NOTFOUND; -- BREAK OUT OF LOOP WHEN NO MORE ROWS ARE AVAILABLE
        DBMS_OUTPUT.PUT(SOME_ID|| 'IS CURRENT ID,' || SOME_NAME || 'IS CURRENT NAME')
    END LOOP;
    CLOSE S;
END;

-- FEED_BEAR

CREATE OR REPLACE PROCEDURE FEED_BEAR 
(BEAR_ID IN NUMBER, BEEHIVE_ID IN NUMBER, WEIGHT IN NUMBER)
IS 

BB_EXISTS INTEGER;

BEGIN
    SET TRANSACTION ISOLATION LEVEL SERIALIZABLE;
    
    SELECT COUNT(BEAR_ID) INTO BB_EXISTS FROM BEAR_BEEHIVE BB
        WHERE BB.BEAR_ID = BEAR_ID
        AND BB.BEHIVE_ID = BEEHIVE_ID;
    DBMS_OUTPUT.PUT_LINE(BB_EXISTS);
    IF BB_EXISTS > 0 THEN
    -- DECREASE BEEHIVE WEIGHT
        UPDATE BEEHIVE SET BEEHIVE_WEIGHT = BEEHIVE_WEIGHT - WEIGHT;

    -- INCREASE BEAR WEIGHT
         UPDATE BEAR SET BEAR_WEIGHT = BEAR_WEIGHT + WEIGHT;
         
        DBMS.OUTPUT.PUT_LINE('FED BEAR ' || HONEY_AMT || ' POUNDS OF HONEY');
    ELSE;
    DBMS_OUTPUT.PUT_LINE('FAILED TO FEED BEAR');
    END IF;
    COMMIT;
EXCEPTION;
    WHEN OTHERS THEN
    DBMS_OUTPUT.PUT_LINE('FAILED To FEED BEAR');
    ROLLBACK;
END;

BEGIN
SP_FEED_BEAR(2,3,8)
END;
  
  
DROP USER BEARS CASCADR;
CREATE USER BEARS
IDENTIFIED BY p4ssw0rd
DEFAULT TABLESPACE users
TEMPORARY TABLESPACE temp
QUOTA 10M ON users;