CREATE TABLE IF NOT EXISTS flight (
    flight_number serial PRIMARY KEY,
    terminal_number numeric NOT NULL,
    gate varchar(3) NOT NULL,
    routing integer,
    arrival varchar(3) NOT NULL,
    departing  varchar(3) NOT NULL,
    availability smallint NOT NULL,
    status text NOT NULL,
    cost numeric NOT NULL
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
    csv text NOT NULL,
    method text NOT NULL,
    card_number text NOT NULL,
    cost numeric NOT NULL
);
    
CREATE TABLE IF NOT EXISTS reservation (
    reservation_id serial PRIMARY KEY,
    seat_number int NOT NULL,
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

CREATE TABLE IF NOT EXISTS services (
    service_id serial PRIMARY KEY,
    movie text,
    wifi text,
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

insert into airport (airport_id, a_name, a_city, a_country) values 
('APW', 'Faleolo', 'Apia', 'Samoa'), 
('AKL', 'Auckland Airport', 'Auckland', 'New Zealand'), 
('ASG', 'Ashburton Aerodrome', 'Ashburton', 'New Zealand'), 
('AAU' , 'Asau Airport', 	'Asau',  'Samoa'), 
('AMZ' , 'Ardmore Airport', 'Ardmore' , 'New Zealand'), 
('ADI' , 'Arandis Airport', 'Arandis', 'Namibia'),
('CAK', 'Akron–Canton Airport', 'Akron', 'USA'), 
('AKC', 'Akron Fulton International Airport', 'Akron', 'USA'), 
('ABQ', 'Albuquerque International Sunport', 'Albuquerque','USA'), 
('ANC', 'Ted Stevens Anchorage International Airport','Anchorage', 'USA'), 
('ATW', 'Appleton International Airport','Appleton', 'USA'), 
('ATL', 'Hartsfield-Jackson Atlanta International Airport' , 'Atlanta ', 'USA'), 
('ACY', 'Atlantic City International Airport', 'Atlantic City', 'USA');


insert into flight (terminal_number, gate, routing, arrival, departing, availability, status, cost) values
(4, 'A20', 1, 'APW', 'CAK', 11, 'on time', 250),
(3, 'B30', 2, 'AKL', 'AKC', 13, 'delayed', 300),
(3, 'C40', 2, 'ASG', 'ABQ', 15, 'cancelled', 350),
(4, 'D15', 1, 'AAU', 'ANC', 17, 'delayed', 400.50),
(5, 'C17', 2, 'AMZ', 'ATW', 19, 'on time', 375);

insert into aircraft (capacity, flight_number, routing_range, name) values
(116000, 1, 7250, 'Boeing 757-200PF'),
(575155, 2, 11750, 'Airbus A380'),
(116000, 3, 7250, 'Boeing 757-200PF'),
(396890, 4, 14427, 'Being 747-400'),
(442000, 5, 14816, 'Boeing 747-8');

insert into contact (ct_first_name, ct_last_name, ct_phone_number, ct_email, ct_relationship) values
('Gjergji', 'Heqimi', '248-555-2222', 'gheqimi@gmail.com', 'Brother'),
('Kajuan', 'Joshnson', '248-222-5555', 'kjohnson@gmail.com', 'Cousin'),
('John', 'Podsiadlik', '248-333-7777', 'jpod@gmail.com', 'Dad'),
('Shital', 'Joshi', '313-222-5555', 'sjoshi@gmail.com', 'Friend'),
('Jane', 'Doe', '313-555-2222', 'jdoe@gmail.com', 'Sister');

insert into job (job_type, salary) values
('Flight Attendant', 80000),
('Pilot', 200000),
('Pilot', 200000),
('Passenger Service', 60000),
('Aircraft Inspector', 100000);

insert into payment (vendor_name, csv, method, card_number, cost) values
('JP Morgan Chase', 123, 'Debit', '1111222233334444', 1000),
('OU Credit Union', 345, 'Credit', '2222333344445555', 1250),
('Bank of America', 567, 'Credit', '3333444455556666', 750),
('MSU Credit Union', 789, 'Debit', '4444555566667777', 300),
('JP Morgan Chase', 001, 'Debit', '5555666677778888', 400);

insert into reservation (seat_number, accommodations, aircraft_id, invoice_id, insurance) values
(2, 'Wheelchair', 1, 1, '1'),
(3, 'Custom Meal', 2, 2, '1'),
(4, '', 3, 3, '1'),
(5, '', 4, 5, '1'),
(6, '', 5, 4, '1');

insert into cancellations (reservation_id, cancel_date) values
(1, '12/4/2017'),
(2, '10/7/2012'),
(3, '7/7/2007'),
(4, '10/10/2010');

insert into services (movie, wifi, meal) values
('Pulp Fuction', 'no', 'Pizza'),
('', 'free', ''),
('Star Wars', 'free', 'Pasta'),
('Star Trek', 'paid', 'Chicken'),
('', 'no', 'Chicken');

insert into employee (aircraft_id, airport_id, job_id, e_first_name, e_last_name, date_hired) values
(1, 'APW', 1, 'Slim', 'Shady', '12/1/2017'),
(4, 'AKL', 2, 'Doctor', 'Dre', '7/10/2010'),
(3, 'ASG', 3, 'Lil', 'Wayne', '3/2/2007'),
(2, 'ASG', 4, 'Taylor', 'Swift', '10/7/1993'),
(5, 'AAU', 5, 'Miley', 'Cyrus', '5/19/1997');

insert into customer (c_first_name, c_last_name, email, passport, street, c_city, c_state, c_country, contact_id, reservation_id) values
('Tom', 'Brady', 'tbrady@gmail.com', '1', '12125 Football Dr.', 'Boston', 'Massachusetts', 'USA', 4, 1),
('Matthew', 'Stafford', 'mstafford@gmal.com', '1', '99990 Football Rd.', 'Detroit', 'Michigan', 'USA', 3, 2),
('Aaron', 'Rodgers', 'arodgers@gmail.com', '0', '12121 Football Dr.', 'Green Bay', 'Wisconsin', 'USA', 2, 3),
('Russell', 'Wilson', 'rwilson@gmail.com', '0', '33331 Football Rd.', 'Seattle', 'Washington', 'USA', 1, 4),
('Cam', 'Newton', 'cnewton@gmail.com', '1', '11110 Superman Dr.', 'Charlotte', 'North Carolina', 'USA', 5, 5);

insert into membership (discount, customer_id, m_type) values
(50, 1, 'Silver'),
(100, 2, 'Gold'),
(100, 3, 'Gold'),
(200, 4, 'Platinum'),
(200, 5, 'Platinum');
