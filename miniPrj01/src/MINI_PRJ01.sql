DROP SEQUENCE SQC_P_INFO;

CREATE SEQUENCE SQC_P_INFO;

DROP TABLE PERSONAL_INFORMATION CASCADE CONSTRAINTS;

CREATE TABLE PERSONAL_INFORMATION
(   
    NO                      NUMBER              CONSTRAINT PK_P_NO        PRIMARY KEY    
    , AFFILIATION           VARCHAR2(100)       CONSTRAINT NN_P_AF        NOT NULL
    , NAME                  VARCHAR2(50)        CONSTRAINT NN_P_NAME      NOT NULL
    , ARMY_NUM              VARCHAR2(100)       CONSTRAINT NN_P_NUM       NOT NULL    CONSTRAINT UQ_P_NUM   UNIQUE
    , RANK                  VARCHAR2(100)       CONSTRAINT NN_P_RANK        NOT NULL
    , ADDRESS               VARCHAR2(100)       CONSTRAINT NN_P_ADD       NOT NULL    CONSTRAINT UQ_P_ADD   UNIQUE   
    , ACADEMIC_BACKGROUND   VARCHAR2(100)       CONSTRAINT NN_P_AC_BACK   NOT NULL   
    , HOBBY                 VARCHAR2(200)       
    , SPECIAL_NOTE          VARCHAR2(200)       
    , FAMILY                VARCHAR2(100)       
    , FAMILY_PHONE_NUBER    VARCHAR2(50)        
    , ARMY_JOIN_YN          CHAR(1)             CONSTRAINT NN_P_JOIN_YN   NOT NULL
);

DROP SEQUENCE SQC_M;

CREATE SEQUENCE SQC_M;

DROP TABLE MEMBERS CASCADE CONSTRAINTS;

CREATE TABLE MEMBERS
(   
    NO              NUMBER              CONSTRAINT PK_M_NO      PRIMARY KEY
    , ID            VARCHAR2(50)        CONSTRAINT NN_M_ID      NOT NULL        CONSTRAINT UQ_ID    UNIQUE
    , PWD           VARCHAR2(50)        CONSTRAINT NN_M_PWD     NOT NULL                
    , NAME          VARCHAR2(50)        CONSTRAINT NN_M_NAME    NOT NULL            
    , RANK          VARCHAR2(50)         CONSTRAINT NN_M_RANK    NOT NULL
    , ARMY_NUM              VARCHAR2(100)       CONSTRAINT NN_M_NUM       NOT NULL    CONSTRAINT UQ_M_NUM   UNIQUE
    , SIGN_UP_YN    CHAR(1)             DEFAULT 'N'             CONSTRAINT NN_M_SIGN_YN NOT NULL
);

DROP TABLE MASTER CASCADE CONSTRAINTS;

CREATE TABLE MASTER
(
    ID          VARCHAR(50)     CONSTRAINT NN_MASTER_ID        NOT NULL 
    , PWD1      VARCHAR(50)     CONSTRAINT NN_MASTER_PWD1      NOT NULL
    , PWD2      VARCHAR(50)     CONSTRAINT NN_MASTER_PWD2      NOT NULL
);

INSERT INTO MASTER(ID, PWD1, PWD2) VALUES('KBIN9919', 1234, 5678);