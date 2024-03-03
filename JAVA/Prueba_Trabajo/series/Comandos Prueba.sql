SELECT * FROM serie;
SELECT * FROM temporada;
SELECT * FROM capitulo;

INSERT INTO temporada (fechaProduccion, fechaEstrenoMundial, serie_id) VALUES ('2023-03-01', '2023-03-01', 1);
INSERT INTO capitulo (titulo, duracionMins, sinopsis, temporada_id) VALUES
("Titlo cap 1", 60, "Este capítulo va de que el protagonista empieza una aventura.", 1);