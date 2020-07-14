DROP TABLE parkingRest IF EXISTS;

CREATE TABLE parkingRest  (
    nombreParking VARCHAR(20),
    plazasCoches INT,
    plazasMotos INT,
    plazasBicicletas INT,
    color VARCHAR(20)
);