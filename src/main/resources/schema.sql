DROP TYPE IF EXISTS status CASCADE;
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

CREATE TABLE IF NOT EXISTS airport(
    airport_id char(3) PRIMARY KEY,
    a_name varchar(25) NOT NULL,
    a_city varchar(25) NOT NULL,
    a_country varchar(25) NOT NULL,
    flight_number varchar(6) NOT NULL
);

DROP TYPE IF EXISTS wifi_enum CASCADE;
CREATE TYPE wifi_enum AS ENUM ('paid' , 'free', 'no');

CREATE TABLE IF NOT EXISTS services(
	service_id serial PRIMARY KEY,
    movie varchar(25),
    wifi wifi_enum,
    meal varchar(25)
);

CREATE TABLE IF NOT EXISTS employee(
	employee_id serial PRIMARY KEY,
    aircraft_id serial REFERENCES aircraft,
    aiport_id serial REFERENCES airport,
    job_id serial REFERENCES position,
    e_first_name varchar(25) NOT NULL,
    e_last_name varchar(25) NOT NULL, 
    date_hired date NOT NULL
);

CREATE TABLE IF NOT EXISTS membership(
	membership_id serial PRIMARY KEY,
    discount int(5),
    customer_id serial REFERENCES customer,
    m_type varchar(8) NOT NULL
);

CREATE TABLE IF NOT EXISTS customer(
	customer_id serial PRIMARY KEY,
    c_first_name varchar(25) NOT NULL,
    c_last_name varchar(25) NOT NULL,
    email varchar(25) NOT NULL,
    passport bit(1),
    street varchar(25) NOT NULL,
    c_city varchar(25) NOT NULL,
    c_state varchar(25) NOT NULL,
    c_country varchar(25) NOT NULL,
    contact_id varchar(25) NOT NULL,
    reservation_id serial REFERENCES reservation
);
