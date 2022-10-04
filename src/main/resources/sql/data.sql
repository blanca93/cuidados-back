INSERT INTO parents (parentname) VALUES ('Ada Lovelace');--
INSERT INTO parents (parentname) VALUES ('Alan Turing');--
INSERT INTO parents (parentname) VALUES ('Ángela Ruiz Robles');--
INSERT INTO parents (parentname) VALUES ('Hedy Lamarr');--

INSERT INTO cuidados (parent, caretaker, beginning, duration, description) VALUES (1, 2, TIMESTAMP '2020-08-17 17:00:00', 90, 'Ada quería ir al cine');--
INSERT INTO cuidados (parent, caretaker, beginning, duration, description) VALUES (2, 3, TIMESTAMP '2020-08-16 20:00:00', 150, 'Alan tenía cena de trabajo');--
INSERT INTO cuidados (parent, caretaker, beginning, duration) VALUES (4, 3, TIMESTAMP '2020-08-16 15:00:00', 90);--
INSERT INTO cuidados (parent, caretaker, beginning, duration) VALUES (3, 4, TIMESTAMP '2020-08-15 18:30:00', 120);--