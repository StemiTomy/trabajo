DROP TABLE IF EXISTS serie;
DROP TABLE IF EXISTS genero;
DROP TABLE IF EXISTS serie_genero;
DROP TABLE IF EXISTS temporada;
DROP TABLE IF EXISTS capitulo;
DROP TABLE IF EXISTS personaje;
DROP TABLE IF EXISTS actor;
DROP TABLE IF EXISTS actor_personaje;
DROP TABLE IF EXISTS personaje_serie;
DROP TABLE IF EXISTS personaje_capitulo;

CREATE TABLE serie (
    id INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
    titulo VARCHAR(40) NOT NULL UNIQUE,
    anyoInicio DATE NOT NULL,
    sinopsis TEXT NOT NULL
);
CREATE TABLE genero (
    id INT PRIMARY KEY,
    nombre VARCHAR(40) NOT NULL UNIQUE
);
CREATE TABLE serie_genero (
    id_serie INT,
    id_genero INT,
    PRIMARY KEY (id_serie, id_genero),
    FOREIGN KEY (id_serie) REFERENCES serie(id),
    FOREIGN KEY (id_genero) REFERENCES genero(id)
);
CREATE TABLE temporada (
    id INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
    fechaProduccion DATE NOT NULL,
    fechaEstrenoMundial DATE,
    serie_id INT,
    FOREIGN KEY (serie_id) REFERENCES serie(id) ON DELETE CASCADE
);
CREATE TABLE capitulo (
    id INT PRIMARY KEY,
    titulo VARCHAR(50) NOT NULL UNIQUE,
    duracionMins INT,
    sinopsis TEXT NOT NULL,
    temporada_id INT NOT NULL,
    FOREIGN KEY (temporada_id) REFERENCES temporada(id) ON DELETE CASCADE
);
CREATE TABLE actor (
    id INT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL
);
CREATE TABLE personaje (
    id INT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL
);
CREATE TABLE actor_personaje (
    id_actor INT,
    id_personaje INT,
    PRIMARY KEY (id_actor, id_personaje),
    FOREIGN KEY (id_actor) REFERENCES actor(id) ON DELETE CASCADE,
    FOREIGN KEY (id_personaje) REFERENCES personaje(id) ON DELETE CASCADE
);
CREATE TABLE personaje_serie (
    id_personaje INT,
    id_serie INT,
    PRIMARY KEY (id_personaje, id_serie),
    FOREIGN KEY (id_personaje) REFERENCES personaje(id) ON DELETE CASCADE,
    FOREIGN KEY (id_serie) REFERENCES serie(id) ON DELETE CASCADE
);
CREATE TABLE personaje_capitulo (
    id_personaje INT,
    id_capitulo INT,
    PRIMARY KEY (id_personaje, id_capitulo),
    FOREIGN KEY (id_personaje) REFERENCES personaje(id) ON DELETE CASCADE,
    FOREIGN KEY (id_capitulo) REFERENCES capitulo(id) ON DELETE CASCADE
);
