CREATE DATABASE idologis;
USE idologis;

CREATE TABLE vente(
	reference SERIAL PRIMARY KEY,
	type varchar(100),
	secteur varchar(100),
	surface int(10),
	chambres int(2),
	surface_terrain int(5),
	classe_energetique varchar(2),
	les_plus text,
	prix int(9)
);


CREATE TABLE location(
	reference int(10) PRIMARY KEY AUTO_INCREMENT,
	type varchar(100),
	secteur varchar(100),
	surface int(10),
	chambres int(2),
	surface_terrain int(5),
	classe_energetique varchar(2),
	les_plus text,
	loyer int(9)
);

CREATE TABLE admin(
	id int(10) PRIMARY KEY AUTO_INCREMENT,
	username varchar(255),
	password varchar(255)
);

INSERT INTO vente VALUES (null, "Pavillon", "Dunkerque", 150, 3, 500, "B", "Piscine", 125900);
INSERT INTO vente VALUES (null, "Appartement", "Calais", 72, 2, 130, "C", "", 53000);

INSERT INTO location VALUES (null, "Pavillon", "Dunkerque", 150, 3, 500, "B", "Piscine", 125900);
INSERT INTO location VALUES (null, "Appartement", "Calais", 72, 2, 130, "C", "", 53000);

INSERT INTO admin VALUES (null, "root", "2dd9d02f75170e9a6d0a4c1083b0ecc7");
INSERT INTO admin VALUES (null, "aurevoir", "2dd9d02f75170e9a6d0a4c1083b0ecc7");
INSERT INTO admin VALUES (null, "r2d2", "2dd9d02f75170e9a6d0a4c1083b0ecc7");
