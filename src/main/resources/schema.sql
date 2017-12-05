CREATE TABLE IF NOT EXISTS flight (
    flight_number serial PRIMARY KEY,
    aircraft_id serial REFERENCES aircraft,
    terminal_number numeric NOT NULL,
    gate varchar(3) NOT NULL,
    routing integer,
    arrival varchar(3) NOT NULL,
    departing  varchar(3) NOT NULL,
    availability smallint NOT NULL,
    status text NOT NULL,
    cost numeric NOT NULL,
    depart_time timestamp NOT NULL,
    arrival_time timestamp NOT NULL
);

CREATE TABLE IF NOT EXISTS aircraft (
    aircraft_id serial PRIMARY KEY,
    capacity numeric(6),
    routing_range numeric(7) NOT NULL,
    name text NOT NULL
);

CREATE TABLE IF NOT EXISTS contact (
    contact_id serial PRIMARY KEY,
    ct_first_name text NOT NULL,
    ct_last_name text NOT NULL,
    ct_phone_number text NOT NULL,
    ct_email text NOT NULL,
    ct_relationship varchar(15)
);
      
CREATE TABLE IF NOT EXISTS job (
    job_id serial PRIMARY KEY,
    job_type text NOT NULL,
    salary numeric(6) NOT NULL
);

CREATE TABLE IF NOT EXISTS payment (
    invoice_id serial PRIMARY KEY,
    vendor_name text NOT NULL,
    vendor_id numeric(7) NOT NULL,
    method text NOT NULL,
    card_number text NOT NULL,
    cost numeric NOT NULL
);
    
CREATE TABLE IF NOT EXISTS reservation (
    reservation_id serial PRIMARY KEY,
    luggage_weight numeric(2) NOT NULL,
    seat_number varchar(4) NOT NULL,
    accommodations text,
    flight_number serial references flight,
    invoice_id serial references payment,
    insurance boolean NOT NULL
);
    
    
CREATE TABLE IF NOT EXISTS cancellations (
    reservation_id serial references reservation,
    cancel_date date NOT NULL
);

CREATE TABLE IF NOT EXISTS airport (
    airport_id char(3) PRIMARY KEY,
    a_name text NOT NULL,
    a_city text NOT NULL,
    a_country text NOT NULL
);

CREATE TABLE IF NOT EXISTS services (
    service_id serial PRIMARY KEY,
    movie text,
    wifi text,
    meal text
);

CREATE TABLE IF NOT EXISTS employee (
    employee_id serial PRIMARY KEY,
    flight_id numeric(7),
    airport_id char(3) REFERENCES airport,
    job_id serial REFERENCES job,
    e_first_name text NOT NULL,
    e_last_name text NOT NULL, 
    date_hired date NOT NULL
);

CREATE TABLE IF NOT EXISTS customer (
    customer_id serial PRIMARY KEY,
    c_first_name text NOT NULL,
    c_last_name text NOT NULL,
    email text NOT NULL,
    passport boolean,
    street text NOT NULL,
    c_city text NOT NULL,
    c_state text NOT NULL,
    c_country text NOT NULL,
    contact_id text NOT NULL,
    reservation_id serial REFERENCES reservation,
    membership_id serial REFERENCES membership
);

CREATE TABLE IF NOT EXISTS membership (
    membership_id serial PRIMARY KEY,
    discount numeric(5),
    m_type text NOT NULL
);

