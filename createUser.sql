 -- Drop database if it exists
********************************************************************************/
DROP USER guest2 CASCADE;


/*******************************************************************************
   Create database
********************************************************************************/
CREATE USER guest2
IDENTIFIED BY p4ssw0rd
DEFAULT TABLESPACE users
TEMPORARY TABLESPACE temp
QUOTA 10M ON users;

GRANT connect to guest2;
GRANT resource to guest2;
GRANT create session TO guest2;
GRANT create table TO guest2;
GRANT create view TO guest2;



--conn chinook/p4ssw0rd

