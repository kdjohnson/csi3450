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
    name text NOT NULL
);

CREATE TABLE IF NOT EXISTS contact (
    contact_id serial PRIMARY KEY,
    ct_first_name text NOT NULL,
    ct_last_name text NOT NULL,
    ct_phone_number numeric(10) NOT NULL,
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
    method text NOT NULL
);
    
CREATE TABLE IF NOT EXISTS reservation (
    reservation_id serial PRIMARY KEY,
    luggage_weight numeric(2) NOT NULL,
    seat_number varchar(4) NOT NULL,
    accommodations text,
    aircraft_id serial references aircraft,
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

DROP TYPE IF EXISTS wifi_enum CASCADE;
CREATE TYPE wifi_enum AS ENUM ('paid' , 'free', 'no');

CREATE TABLE IF NOT EXISTS services (
    service_id serial PRIMARY KEY,
    movie text,
    wifi wifi_enum,
    meal text
);

CREATE TABLE IF NOT EXISTS employee (
    employee_id serial PRIMARY KEY,
    aircraft_id serial REFERENCES aircraft,
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
    reservation_id serial REFERENCES reservation
);

CREATE TABLE IF NOT EXISTS membership (
    membership_id serial PRIMARY KEY,
    discount numeric(5),
    customer_id serial REFERENCES customer,
    m_type text NOT NULL
);

