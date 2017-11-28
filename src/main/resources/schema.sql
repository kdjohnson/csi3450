DROP TYPE status CASCADE;
CREATE TYPE status AS ENUM ('delayed', 'cancelled', 'on time');

CREATE TABLE IF NOT EXISTS flight (
    flight_number serial PRIMARY KEY,
    terminal_number numeric NOT NULL,
    gate varchar(3) NOT NULL,
    routing integer,
    arrival varchar(3) NOT NULL,
    departing  varchar(3) NOT NULL,
    availability smallint NOT NULL,
    s status default 'on time' 
);

CREATE TABLE IF NOT EXISTS aircraft (
    aircraft_id serial PRIMARY KEY,
    capacity numeric(6),
    flight_number serial REFERENCES flight,
    routing_range numeric(7) NOT NULL,
    name varchar(25)
);
