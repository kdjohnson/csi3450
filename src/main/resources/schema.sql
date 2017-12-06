CREATE TABLE IF NOT EXISTS aircraft (
    aircraft_id serial PRIMARY KEY,
    capacity numeric(6),
    routing_range numeric(7) NOT NULL,
    name text NOT NULL
);

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
    depart_time text NOT NULL,
    arrival_time text NOT NULL
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

CREATE TABLE IF NOT EXISTS membership (
    membership_id serial PRIMARY KEY,
    discount numeric(5),
    m_type text NOT NULL
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
    contact_id serial REFERENCES contact,
    reservation_id serial REFERENCES reservation,
    membership_id serial REFERENCES membership
);

insert into airport (airport_id, a_name, a_city, a_country) values 
('APW', 'Faleolo', 'Apia', 'Samoa'), 
('AKL', 'Auckland Airport', 'Auckland', 'New Zealand'), 
('ASG', 'Ashburton Aerodrome', 'Ashburton', 'New Zealand'), 
('AAU' , 'Asau Airport', 	'Asau',  'Samoa'), 
('AMZ' , 'Ardmore Airport', 'Ardmore' , 'New Zealand'), 
('ADI' , 'Arandis Airport', 'Arandis', 'Namibia'), 
('CAK', 'Akron-Canton Airport', 'Akron', 'USA'), 
('AKC', 'Akron Fulton International Airport', 'Akron', 'USA'), 
('ABQ', 'Albuquerque International Sunport', 'Albuquerque','USA'), 
('ANC', 'Ted Stevens Anchorage International Airport','Anchorage', 'USA'), 
('ATW', 'Appleton International Airport','Appleton', 'USA'), 
('ATL', 'Hartsfield-Jackson Atlanta International Airport' , 'Atlanta ', 'USA'), 
('ACY', 'Atlantic City International Airport', 'Atlantic City', 'USA');

insert into aircraft (capacity,routing_range, name) values
(116000, 7250, 'Boeing 757-200PF'),
(575155, 11750, 'Airbus A380'),
(116000, 7250, 'Boeing 757-200PF'),
(396890, 14427, 'Boeing 747-400'),
(442000, 14816, 'Boeing 747-8'),
(442000, 14816, 'Boeing 747-8'),
(396890, 14427, 'Boeing 747-400'),
(116000, 7250, 'Boeing 757-200PF'),
(575155, 11750, 'Airbus A380'),
(575155, 11750, 'Airbus A380');

insert into flight (aircraft_id, terminal_number, gate, routing, arrival, departing, availability, status, cost, depart_time, arrival_time) values
(1, 4, 'A20', 1, 'APW', 'CAK', 11, 'on time', 250, '12/5/2017 17:00', '12/6/2017 20:00'),
(2, 3, 'B30', 2, 'AKL', 'AKC', 13, 'delayed', 300, '12/6/2017 19:00', '12/7/2017 1:00'),
(3, 3, 'C40', 2, 'ASG', 'ABQ', 15, 'cancelled', 350, '12/8/2017 20:00', '12/8/2017 23:00'),
(4, 4, 'D15', 1, 'AAU', 'ANC', 17, 'delayed', 400.50, '12/25/2017 14:00', '12/26/2017 23:00'),
(5, 5, 'C17', 2, 'AMZ', 'ATW', 19, 'on time', 375, '12/30/2017 6:00', '12/31/2017 5:00'),
(6, 2, 'A15', 1, 'ACY', 'ATW', 10, 'on time', 1000, '1/1/2018 7:00', '1/1/2018 14:00'),
(7, 3, 'C7', 2, 'ACY', 'ANC', 7, 'delayed', 1200, '1/3/2018 12:00', '1/4/2018 1:00'),
(8, 2, 'D12', 1, 'ADI', 'AMZ', 12, 'on time', 1200, '1/4/2018 13:00', '1/4/2018 20:00'),
(9, 5, 'C17', 2, 'APW', 'CAK', 15, 'delayed', 1000, '3/2/2018 14:00', '3/3/2018 1:00'),
(10, 4, 'B20', 2, 'ABQ', 'ANC', 13, 'on time', 900, '5/5/2018 15:00', '5/5/2018 23:00');

insert into contact (ct_first_name, ct_last_name, ct_phone_number, ct_email, ct_relationship) values
('Gjergji', 'Heqimi', '248-555-2222', 'gheqimi@gmail.com', 'Brother'),
('Kajuan', 'Joshnson', '248-222-5555', 'kjohnson@gmail.com', 'Cousin'),
('John', 'Podsiadlik', '248-333-7777', 'jpod@gmail.com', 'Dad'),
('Shital', 'Joshi', '313-222-5555', 'sjoshi@gmail.com', 'Friend'),
('Jane', 'Doe', '313-555-2222', 'jdoe@gmail.com', 'Sister'),
('John', 'Doe', '313-777-6666', 'jodoe@gmail.com', 'Cousin'),
('Mynameis', 'What', '313-888-7777', 'mynameis@gmail.com', 'Brother'),
('Star', 'Bucks', '717-777-7777', 'starbucks@gmail.com', 'Friend'),
('Chart', 'Wells', '248-123-4567', 'chartwells@gmail.com', 'Friend'),
('Ice', 'Tea', '717-333-3333', 'icetea@gmail.com', 'Friend');

insert into job (job_type, salary) values
('Flight Attendant', 80000),
('Pilot', 200000),
('Pilot', 200000),
('Passenger Service', 60000),
('Aircraft Inspector', 100000),
('Aircraft Inspector', 100000),
('Pilot', 250000),
('Clerk', 70000),
('Clerk', 70000),
('Flight Attendant', 80000);

insert into payment (vendor_name, csv, method, card_number, cost) values
('JP Morgan Chase', '123', 'Debit', '1111222233334444', 1000),
('OU Credit Union', '345', 'Credit', '2222333344445555', 1250),
('Bank of America', '456', 'Credit', '3333444455556666', 750),
('MSU Credit Union', '567', 'Debit', '4444555566667777', 300),
('JP Morgan Chase', '789', 'Debit', '5555666677778888', 400),
('JP Morgan Chase', '001', 'Credit', '6666777788889999', 1000),
('Bank of America', '002', 'Debit', '7777888899990000', 1200),
('OU Credit Union', '003', 'Debit', '0000111122223333', 1300),
('MSU Credit Union', '004', 'Cash', '0000111100001111', 1250),
('UofM Credit Union', '005', 'Cash', '1111000011110000', 1200);

insert into reservation (seat_number, accommodations, flight_number, invoice_id, insurance) values
(2, 'Wheelchair', 1, 1, '1'),
(3, 'Custom Meal', 2, 2, '1'),
(4, '', 3, 3, '0'),
(5, '', 4, 5, '1'),
(7, '', 5, 4, '0'),
(8, 'Custom Meal', 6, 6, '1'),
(10, 'Wheelchair', 7, 7, '0'),
(11, '', 8, 8, '0'),
(12, '', 9, 9, '1'),
(17, '', 10, 10, '1');

insert into cancellations (reservation_id, cancel_date) values
(1, '12/4/2017'),
(2, '10/7/2012'),
(3, '7/7/2007'),
(4, '10/10/2010'),
(5, '1/1/2018'),
(6, '7/7/2017'),
(7, '7/10/2017');


insert into services (movie, wifi, meal) values
('Pulp Fuction', 'no', 'Pizza'),
('', 'free', ''),
('Star Wars', 'free', 'Pasta'),
('Star Trek', 'paid', 'Chicken'),
('', 'no', 'Chicken'),
('', 'no', 'Pasta'),
('Batman', 'free', 'Pasta'),
('Superman', 'paid', 'Chicken'),
('Batman V. Superman', 'paid', 'Chicken'),
('Game of Thrones', 'free', 'Pizza');

insert into employee (flight_id, airport_id, job_id, e_first_name, e_last_name, date_hired)  values
(1, 'APW', 1, 'Slim', 'Shady', '12/1/2017'),
(4, 'AKL', 2, 'Doctor', 'Dre', '7/10/2010'),
(3, 'ASG', 3, 'Lil', 'Wayne', '3/2/2007'),
(2, 'ASG', 4, 'Taylor', 'Swift', '10/7/1993'),
(5, 'AAU', 5, 'Miley', 'Cyrus', '5/19/1997'),
(6, 'CAK', 6, 'Hello', 'World', '12/4/2017'),
(7, 'AKC', 7, 'MyName', 'Is', '12/5/2017'),
(8, 'AKC', 8, 'Matt', 'Damon', '10/10/2013'),
(9, 'ANC', 9, 'George', 'Clooney', '3/15/2013'),
(10, 'ATL', 10, 'Brad', 'Pitt', '4/14/2013');

insert into membership (discount, m_type) values
(50, 'Silver'),
(100, 'Gold'),
(100, 'Gold'),
(200, 'Platinum'),
(200, 'Platinum'),
(0, 'Bronze'),
(0, 'Bronze'),
(50, 'Silver'),
(100, 'Gold'),
(200, 'Platinum');

insert into customer (c_first_name, c_last_name, email, passport, street, c_city, c_state, c_country, contact_id, reservation_id, membership_id) values
('Tom', 'Brady', 'tbrady@gmail.com', '1', '12125 Football Dr.', 'Boston', 'Massachusetts', 'USA', 4, 1, 1),
('Matthew', 'Stafford', 'mstafford@gmal.com', '1', '99990 Football Rd.', 'Detroit', 'Michigan', 'USA', 3, 2, 2),
('Aaron', 'Rodgers', 'arodgers@gmail.com', '0', '12121 Football Dr.', 'Green Bay', 'Wisconsin', 'USA', 2, 3, 3),
('Russell', 'Wilson', 'rwilson@gmail.com', '0', '33331 Football Rd.', 'Seattle', 'Washington', 'USA', 1, 4, 4),
('Cam', 'Newton', 'cnewton@gmail.com', '1', '11110 Superman Dr.', 'Charlotte', 'North Carolina', 'USA', 5, 5, 5),
('Calvin', 'Johson', 'cjohson@gmail.com', '1', '81810 Megatron Dr.', 'Atlanta', 'Georgia', 'USA', 6, 6, 6),
('Marvin', 'Jones', 'cjones@gmail.com', '1', '11000 Beast Rd.', 'Los Angelos', 'California', 'USA', 7, 7, 7),
('Golden', 'Tate', 'gtate@gmail.com', '0', '15150 Notre Dame Dr.', 'Seattle', 'Washington', 'USA', 8, 8, 8),
('Julio', 'Jones', 'jjones@gmail.com', '0', '77777 Falcons Rd.', 'Mountgomery', 'Alabama', 'USA', 9, 9, 9),
('Odell', 'Beckham Jr.', 'obeckham@gmail.com', '1', '13130 Broadway', 'New York City', 'New York', 'USA', 10, 10, 10);


