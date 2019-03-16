-- Generado por Oracle SQL Developer Data Modeler 18.4.0.339.1532
--   en:        2019-02-27 12:50:53 COT
--   sitio:      Oracle Database 11g
--   tipo:      Oracle Database 11g



CREATE TABLE categoria (
    idcategoria   INTEGER NOT NULL,
    categoria     VARCHAR2(20)
);

ALTER TABLE categoria ADD CONSTRAINT categoria_pk PRIMARY KEY ( idcategoria );

CREATE TABLE juego (
    idjuego                 INTEGER NOT NULL,
    nombrejuego             VARCHAR2(30),
    categoria_idcategoria   INTEGER NOT NULL
);

ALTER TABLE juego ADD CONSTRAINT juego_pk PRIMARY KEY ( idjuego );

CREATE TABLE opcion (
    idopcion              INTEGER,
    textoopcion           VARCHAR2(50),
    respuestacorrecta     CHAR(1),
    pregunta_idpregunta   INTEGER NOT NULL
);

CREATE TABLE persona (
    idpersona                   INTEGER NOT NULL,
    nombre                      VARCHAR2(20),
    apellido                    VARCHAR2(30),
    usuario                     VARCHAR2(15),
    contrasena                  VARCHAR2(15),
    tipopersona_idtipopersona   INTEGER NOT NULL
);

ALTER TABLE persona ADD CONSTRAINT persona_pk PRIMARY KEY ( idpersona );

CREATE TABLE pregunta (
    idpregunta      INTEGER NOT NULL,
    textopregunta   VARCHAR2(120),
    test_idtest     INTEGER NOT NULL
);

ALTER TABLE pregunta ADD CONSTRAINT pregunta_pk PRIMARY KEY ( idpregunta );

CREATE TABLE puntaje (
    idpuntaje           INTEGER NOT NULL,
    puntaje             INTEGER,
    juego_idjuego       INTEGER NOT NULL,
    persona_idpersona   INTEGER NOT NULL
);

ALTER TABLE puntaje ADD CONSTRAINT puntaje_pk PRIMARY KEY ( idpuntaje );

CREATE TABLE realiza (
    test_idtest         INTEGER NOT NULL,
    persona_idpersona   INTEGER NOT NULL
);

ALTER TABLE realiza ADD CONSTRAINT realiza_pk PRIMARY KEY ( test_idtest,
                                                            persona_idpersona );

CREATE TABLE revisa (
    persona_idpersona   INTEGER NOT NULL,
    test_idtest         INTEGER NOT NULL
);

ALTER TABLE revisa ADD CONSTRAINT revisa_pk PRIMARY KEY ( persona_idpersona,
                                                          test_idtest );

CREATE TABLE test (
    idtest                  INTEGER NOT NULL,
    resultado               INTEGER,
    categoria_idcategoria   INTEGER NOT NULL
);

ALTER TABLE test ADD CONSTRAINT test_pk PRIMARY KEY ( idtest );

CREATE TABLE tipopersona (
    idtipopersona   INTEGER NOT NULL,
    tipopersona     VARCHAR2(30)
);

ALTER TABLE tipopersona ADD CONSTRAINT tipopersona_pk PRIMARY KEY ( idtipopersona );

ALTER TABLE juego
    ADD CONSTRAINT juego_categoria_fk FOREIGN KEY ( categoria_idcategoria )
        REFERENCES categoria ( idcategoria );

ALTER TABLE opcion
    ADD CONSTRAINT opcion_pregunta_fk FOREIGN KEY ( pregunta_idpregunta )
        REFERENCES pregunta ( idpregunta );

ALTER TABLE persona
    ADD CONSTRAINT persona_tipopersona_fk FOREIGN KEY ( tipopersona_idtipopersona )
        REFERENCES tipopersona ( idtipopersona );

ALTER TABLE pregunta
    ADD CONSTRAINT pregunta_test_fk FOREIGN KEY ( test_idtest )
        REFERENCES test ( idtest );

ALTER TABLE puntaje
    ADD CONSTRAINT puntaje_juego_fk FOREIGN KEY ( juego_idjuego )
        REFERENCES juego ( idjuego );

ALTER TABLE puntaje
    ADD CONSTRAINT puntaje_persona_fk FOREIGN KEY ( persona_idpersona )
        REFERENCES persona ( idpersona );

ALTER TABLE realiza
    ADD CONSTRAINT realiza_persona_fk FOREIGN KEY ( persona_idpersona )
        REFERENCES persona ( idpersona );

ALTER TABLE realiza
    ADD CONSTRAINT realiza_test_fk FOREIGN KEY ( test_idtest )
        REFERENCES test ( idtest );

ALTER TABLE revisa
    ADD CONSTRAINT revisa_persona_fk FOREIGN KEY ( persona_idpersona )
        REFERENCES persona ( idpersona );

ALTER TABLE revisa
    ADD CONSTRAINT revisa_test_fk FOREIGN KEY ( test_idtest )
        REFERENCES test ( idtest );

ALTER TABLE test
    ADD CONSTRAINT test_categoria_fk FOREIGN KEY ( categoria_idcategoria )
        REFERENCES categoria ( idcategoria );



-- Informe de Resumen de Oracle SQL Developer Data Modeler: 
-- 
-- CREATE TABLE                            10
-- CREATE INDEX                             0
-- ALTER TABLE                             20
-- CREATE VIEW                              0
-- ALTER VIEW                               0
-- CREATE PACKAGE                           0
-- CREATE PACKAGE BODY                      0
-- CREATE PROCEDURE                         0
-- CREATE FUNCTION                          0
-- CREATE TRIGGER                           0
-- ALTER TRIGGER                            0
-- CREATE COLLECTION TYPE                   0
-- CREATE STRUCTURED TYPE                   0
-- CREATE STRUCTURED TYPE BODY              0
-- CREATE CLUSTER                           0
-- CREATE CONTEXT                           0
-- CREATE DATABASE                          0
-- CREATE DIMENSION                         0
-- CREATE DIRECTORY                         0
-- CREATE DISK GROUP                        0
-- CREATE ROLE                              0
-- CREATE ROLLBACK SEGMENT                  0
-- CREATE SEQUENCE                          0
-- CREATE MATERIALIZED VIEW                 0
-- CREATE MATERIALIZED VIEW LOG             0
-- CREATE SYNONYM                           0
-- CREATE TABLESPACE                        0
-- CREATE USER                              0
-- 
-- DROP TABLESPACE                          0
-- DROP DATABASE                            0
-- 
-- REDACTION POLICY                         0
-- 
-- ORDS DROP SCHEMA                         0
-- ORDS ENABLE SCHEMA                       0
-- ORDS ENABLE OBJECT                       0
-- 
-- ERRORS                                   0
-- WARNINGS                                 0
