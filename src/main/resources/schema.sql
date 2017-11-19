CREATE TABLE IF NOT EXISTS flight (
    flight_number serial PRIMARY KEY,
    terminal_number integer NOT NULL,
    gate varchar(5) NOT NULL,
    routing integer,
    arrival varchar(5) NOT NULL,
    departing  varchar(5) NOT NULL
);

CREATE TABLE IF NOT EXISTS aircraft (
    aircraft_id serial PRIMARY KEY,
    capacity numeric,
    delayed boolean,
    flight_number serial REFERENCES flight,
    routing_range numeric NOT NULL,
    name varchar(25)
);
