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

CREATE TABLE IF NOT EXISTS airport(
    airport_id char(3) PRIMARY KEY,
    name varchar(25) NOT NULL,
    a_city varchar(25) NOT NULL,
    a_country varchar(25) NOT NULL,
    flight_number varchar(6) NOT NULL
);

CREATE TABLE IF NOT EXISTS services(
	service_id int(7) PRIMARY KEY,
    movie varchar(25),
    wifi enum('paid', 'free', 'no'),
    meal varchar(25)
);

CREATE TABLE IF NOT EXISTS employee(
	employee_id int(7) NOT NULL PRIMARY KEY,
    aircraft_id int(7) REFERENCES aircraft,
    aiport_id int(7) REFERENCES airport,
    position_id int(7) NOT NULL REFERENCES position,
    e_first_name varchar(25) NOT NULL,
    e_last_name varchar(25) NOT NULL, 
    date_hired date NOT NULL
);

CREATE TABLE IF NOT EXISTS membership(
	membership_id int(7) NOT NULL PRIMARY KEY,
    discount int(5),
    customer_id int(7) NOT NULL REFERENCES customer,
    m_type varchar(8) NOT NULL
);

CREATE TABLE IF NOT EXISTS customer(
	customer_id int(7) NOT NULL PRIMARY KEY,
    c_first_name varchar(25) NOT NULL,
    c_last_name varchar(25) NOT NULL,
    email varchar(25) NOT NULL,
    passport bit(1),
    street varchar(25) NOT NULL,
    c_city varchar(25) NOT NULL,
    c_state varchar(25) NOT NULL,
    c_country varchar(25) NOT NULL,
    contact_id varchar(25) NOT NULL,
    reservation_id int(7) NOT NULL REFERENCES reservation
);
