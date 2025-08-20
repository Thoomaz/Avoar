INSERT INTO tb_airport (id, name, city, state, country, code_iata)
VALUES (1, 'Aeroporto de Congonhas', 'São Paulo', 'SP', 'Brasil', 'CGH');

INSERT INTO tb_airport (id, name, city, state, country, code_iata)
VALUES (2, 'Aeroporto Santos Dumont', 'Rio de Janeiro', 'RJ', 'Brasil', 'SDU');

INSERT INTO tb_airport (id, name, city, state, country, code_iata)
VALUES (3, 'Aeroporto Internacional de Brasília', 'Brasília', 'DF', 'Brasil', 'BSB');

INSERT INTO tb_airport (id, name, city, state, country, code_iata)
VALUES (4, 'Aeroporto Internacional de Salvador', 'Salvador', 'BA', 'Brasil', 'SSA');

-- ========================
-- AIRPLANES
-- ========================
INSERT INTO tb_airplane (id, model, company, quantity_economic, quantity_executive, quantity_first_class)
VALUES (1, 'Boeing 737', 'Gol Linhas Aéreas', 120, 24, 8);

INSERT INTO tb_airplane (id, model, company, quantity_economic, quantity_executive, quantity_first_class)
VALUES (2, 'Airbus A320', 'Latam Airlines', 150, 30, 10);

INSERT INTO tb_airplane (id, model, company, quantity_economic, quantity_executive, quantity_first_class)
VALUES (3, 'Embraer E195-E2', 'Azul Linhas Aéreas', 110, 20, 6);

-- ========================
-- FLIGHTS
-- ========================
INSERT INTO tb_flight (id, departure_date, arrival_date, departure_place, arrival_place,
                       price_economic, price_executive, price_first_class,
                       seat_avaliable_economic, seat_avaliable_executive, seat_avaliable_first_class,
                       airport_takeoff_id, airport_land_id, airplane_id)
VALUES (1, '2025-08-20', '2025-08-20', 'São Paulo', 'Rio de Janeiro',
        300.0, 800.0, 1500.0,
        100, 20, 5,
        1, 2, 1);

INSERT INTO tb_flight (id, departure_date, arrival_date, departure_place, arrival_place,
                       price_economic, price_executive, price_first_class,
                       seat_avaliable_economic, seat_avaliable_executive, seat_avaliable_first_class,
                       airport_takeoff_id, airport_land_id, airplane_id)
VALUES (2, '2025-08-21', '2025-08-21', 'Rio de Janeiro', 'São Paulo',
        320.0, 820.0, 1550.0,
        110, 25, 6,
        2, 1, 2);

INSERT INTO tb_flight (id, departure_date, arrival_date, departure_place, arrival_place,
                       price_economic, price_executive, price_first_class,
                       seat_avaliable_economic, seat_avaliable_executive, seat_avaliable_first_class,
                       airport_takeoff_id, airport_land_id, airplane_id)
VALUES (3, '2025-08-22', '2025-08-22', 'Brasília', 'Salvador',
        400.0, 950.0, 1700.0,
        120, 22, 7,
        3, 4, 3);