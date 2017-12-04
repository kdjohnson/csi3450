insert into airport values 
('APW', 'Faleolo', 'Apia', 'Samoa'), 
('AKL', 'Auckland Airport', 'Auckland', 'New Zealand'), 
('ASG', 'Ashburton Aerodrome', 'Ashburton', 'New Zealand'), 
('AAU' , 'Asau Airport', 	'Asau',  'Samoa'), 
('AMZ' , 'Ardmore Airport', 'Ardmore' , 'New Zealand'), 
('ADI' , 'Arandis Airport', 'Arandis', 'Namibia') ON CONFLICT (airport_id) DO NOTHING;

insert into airport values 
('CAK', 'Akron–Canton Airport', 'Akron', 'USA'), 
('AKC', 'Akron Fulton International Airport', 'Akron', 'USA'), 
('ABQ', 'Albuquerque International Sunport', 'Albuquerque','USA'), 
('ANC', 'Ted Stevens Anchorage International Airport','Anchorage', 'USA'), 
('ATW', 'Appleton International Airport','Appleton', 'USA'), 
('ATL', 'Hartsfield-Jackson Atlanta International Airport' , 'Atlanta ', 'USA'), 
('ACY', 'Atlantic City International Airport', 'Atlantic City', 'USA') ON CONFLICT (airport_id) DO NOTHING;

insert into flight values
(DEFAULT, 4, 'A20', 1, 'APW', 'CAK', 11, 'on time', 250),
(DEFAULT, 3, 'B30', 2, 'AKL', 'AKC', 13, 'delayed', 300),
(DEFAULT, 3, 'C40', 2, 'ASG', 'ABQ', 15, 'cancelled', 350),
(DEFAULT, 4, 'D15', 1, 'AAU', 'ANC', 17, 'delayed', 400.50),
(DEFAULT, 5, 'C17', 2, 'AMZ', 'ATW', 19, 'on time', 375) ON CONFLICT (flight_number) DO NOTHING;

insert into aircraft values
(DEFAULT, 116000, 1, 7250, 'Boeing 757-200PF'),
(DEFAULT, 575155, 2, 11750, 'Airbus A380'),
(DEFAULT, 116000, 3, 7250, 'Boeing 757-200PF'),
(DEFAULT, 396890, 4, 14427, 'Being 747-400'),
(DEFAULT, 442000, 5, 14816, 'Boeing 747-8') ON CONFLICT (aircraft_id) DO NOTHING;

insert into contact values
(DEFAULT, 'Gjergji', 'Heqimi', '248-555-2222', 'gheqimi@gmail.com', 'Brother'),
(DEFAULT, 'Kajuan', 'Joshnson', '248-222-5555', 'kjohnson@gmail.com', 'Cousin'),
(DEFAULT, 'John', 'Podsiadlik', '248-333-7777', 'jpod@gmail.com', 'Dad'),
(DEFAULT, 'Shital', 'Joshi', '313-222-5555', 'sjoshi@gmail.com', 'Friend'),
(DEFAULT, 'Jane', 'Doe', '313-555-2222', 'jdoe@gmail.com', 'Sister') ON CONFLICT (contact_id) DO NOTHING;

insert into job values
(DEFAULT, 'Flight Attendant', 80000),
(DEFAULT, 'Pilot', 200000),
(DEFAULT, 'Pilot', 200000),
(DEFAULT, 'Passenger Service', 60000),
(DEFAULT, 'Aircraft Inspector', 100000) ON CONFLICT (job_id) DO NOTHING;

insert into payment values
(DEFAULT, 'JP Morgan Chase', 6123456, 'Debit', '1111222233334444', 1000),
(DEFAULT, 'OU Credit Union', 6234567, 'Credit', '2222333344445555', 1250),
(DEFAULT, 'Bank of America', 6345678, 'Credit', '3333444455556666', 750),
(DEFAULT, 'MSU Credit Union', 6456789, 'Debit', '4444555566667777', 300),
(DEFAULT, 'JP Morgan Chase', 6123456, 'Debit', '5555666677778888', 400) ON CONFLICT (invoice_id) DO NOTHING;

insert into reservation values
(DEFAULT, 2, 'A1', 'Wheelchair', 1, 1, '1'),
(DEFAULT, 3, 'B10', 'Custom Meal', 2, 2, '1'),
(DEFAULT, 4, 'C15', '', 3, 3, '0'),
(DEFAULT, 5, 'D20', '', 4, 5, '1'),
(DEFAULT, 6, 'F7', '', 5, 4, '0') ON CONFLICT (reservation_id) DO NOTHING;

insert into services values
(DEFAULT, 'Pulp Fuction', 'no', 'Pizza'),
(DEFAULT, '', 'free', ''),
(DEFAULT, 'Star Wars', 'free', 'Pasta'),
(DEFAULT, 'Star Trek', 'paid', 'Chicken'),
(DEFAULT, '', 'no', 'Chicken') ON CONFLICT (service_id) DO NOTHING;

insert into employee values
(DEFAULT, 1, 'APW', 1, 'Slim', 'Shady', '12/1/2017'),
(DEFAULT, 4, 'AKL', 2, 'Doctor', 'Dre', '7/10/2010'),
(DEFAULT, 3, 'ASG', 3, 'Lil', 'Wayne', '3/2/2007'),
(DEFAULT, 2, 'ASG', 4, 'Taylor', 'Swift', '10/7/1993'),
(DEFAULT, 5, 'AAU', 5, 'Miley', 'Cyrus', '5/19/1997') ON CONFLICT (employee_id) DO NOTHING;

insert into customer values
(DEFAULT, 'Tom', 'Brady', 'tbrady@gmail.com', '1', '12125 Football Dr.', 'Boston', 'Massachusetts', 'USA', 4, 1),
(DEFAULT, 'Matthew', 'Stafford', 'mstafford@gmal.com', '1', '99990 Football Rd.', 'Detroit', 'Michigan', 'USA', 3, 2),
(DEFAULT, 'Aaron', 'Rodgers', 'arodgers@gmail.com', '0', '12121 Football Dr.', 'Green Bay', 'Wisconsin', 'Canada', 2, 3),
(DEFAULT, 'Russel', 'Wilson', 'rwilson@gmail.com', '0', '33331 Football Rd.', 'Seattle', 'Washington', 'USA', 1, 4),
(DEFAULT, 'Cam', 'Newton', 'cnewton@gmail.com', '1', '11110 Superman Dr.', 'Charlotte', 'North Carolina', 'USA', 5, 5) ON CONFLICT (customer_id) DO NOTHING;

insert into membership values
(DEFAULT, 50, 1, 'Silver'),
(DEFAULT, 100, 2, 'Gold'),
(DEFAULT, 100, 3, 'Gold'),
(DEFAULT, 200, 4, 'Platinum'),
(DEFAULT, 200, 5, 'Platinum') ON CONFLICT (membership_id) DO NOTHING;
