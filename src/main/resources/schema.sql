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

CREATE TABLE IF NOT EXISTS contact (
    contact_id serial PRIMARY KEY,
    ct_first_name varchar(25) NOT NULL,
    ct_last_name varchar(25) NOT NULL,
    ct_phone_number numeric(10) NOT NULL,
    ct_email varchar(25) NOT NULL,
    ct_relationship varchar(15)
);
      
CREATE TABLE IF NOT EXISTS job (
    job_id serial PRIMARY KEY,
    job_type varchar(25) NOT NULL,
    salary numeric(6) NOT NULL
);
    
CREATE TABLE IF NOT EXISTS reservation (
    reservation_id serial PRIMARY KEY,
    luggage_weight numeric(2) NOT NULL,
    seat_number varchar(4) NOT NULL,
    accommodations varchar(25),
    aircraft_id serial references aircraft,
    invoice_id serial references payment,
    insurance boolean NOT NULL
);
    
CREATE TABLE IF NOT EXISTS payment (
    invoice_id serial PRIMARY KEY,
    vendor_name varchar(25) NOT NULL,
    vendor_id numeric(7) NOT NULL,
    method varchar(7) NOT NULL
);
    
CREATE TABLE IF NOT EXISTS cancellations (
    reservation_id serial references reservation,
    cancel_date date NOT NULL
);
