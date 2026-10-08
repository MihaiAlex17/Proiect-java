CREATE DATABASE IF NOT EXISTS food_delivery;
USE food_delivery;

CREATE TABLE IF NOT EXISTS client (
                                      id INT AUTO_INCREMENT PRIMARY KEY,
                                      nume VARCHAR(100) NOT NULL,
    email VARCHAR(100),
    adresa VARCHAR(200)
    );

CREATE TABLE IF NOT EXISTS localuri (
                                        id INT AUTO_INCREMENT PRIMARY KEY,
                                        nume VARCHAR(100) NOT NULL,
    tip VARCHAR(50),
    rating DOUBLE,
    adresa VARCHAR(200)
    );

CREATE TABLE IF NOT EXISTS produs (
                                      id INT AUTO_INCREMENT PRIMARY KEY,
                                      nume VARCHAR(100) NOT NULL,
                                      pret DOUBLE,
                                      categorie VARCHAR(50),
                                      gramaj INT,
                                      id_local INT,
                                      FOREIGN KEY (id_local) REFERENCES localuri(id) ON DELETE CASCADE
);


CREATE TABLE IF NOT EXISTS comanda (
                                       id INT AUTO_INCREMENT PRIMARY KEY,
                                       id_client INT,
                                       id_local INT,
                                       total DOUBLE,
                                       status VARCHAR(50),
    FOREIGN KEY (id_client) REFERENCES client(id) ON DELETE SET NULL,
    FOREIGN KEY (id_local) REFERENCES localuri(id) ON DELETE SET NULL
    );

CREATE TABLE IF NOT EXISTS curier (
                                      id INT PRIMARY KEY,
                                      nume VARCHAR(100),
                                      email VARCHAR(100),
                                      vehicul VARCHAR(50)
);


