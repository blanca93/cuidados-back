CREATE SEQUENCE parent_sequence;--

CREATE TABLE parents(
  id       NUMBER(20)   NOT NULL,
  parentname VARCHAR2(50) NOT NULL,
  primary key (id)
);--

CREATE TRIGGER parent_trigger
BEFORE INSERT ON parents REFERENCING NEW AS NEW OLD AS OLD
FOR EACH ROW
  DECLARE
    Var NUMBER;
  BEGIN
    SELECT parent_sequence.NEXTVAL INTO Var FROM dual;
    :NEW.id := Var;
  EXCEPTION
    WHEN OTHERS THEN
      RAISE;
END;;--

CREATE SEQUENCE cuidado_sequence;--

CREATE TABLE cuidados(
  id       NUMBER(20)   NOT NULL,
  parent NUMBER(20) NOT NULL,
  caretaker NUMBER(20) NOT NULL,
  beginning TIMESTAMP NOT NULL,
  duration NUMBER(20) NOT NULL,
  description VARCHAR2(150),
  primary key (id),
  foreign key (parent) references parents(id),
  foreign key (caretaker) references parents(id)
);--

CREATE TRIGGER cuidado_trigger
BEFORE INSERT ON cuidados REFERENCING NEW AS NEW OLD AS OLD
FOR EACH ROW
  DECLARE
    Var NUMBER;
  BEGIN
    SELECT cuidado_sequence.NEXTVAL INTO Var FROM dual;
    :NEW.id := Var;
  EXCEPTION
    WHEN OTHERS THEN
      RAISE;
END;;--