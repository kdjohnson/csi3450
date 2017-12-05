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

insert into aircraft values
(1, 116000, 7250, 'Boeing 757-200PF'),
(2, 575155, 11750, 'Airbus A380'),
(3, 116000, 7250, 'Boeing 757-200PF'),
(4, 396890, 14427, 'Being 747-400'),
(5, 442000, 14816, 'Boeing 747-8') ON CONFLICT (aircraft_id) DO NOTHING;

insert into flight values
(1, 1, 4, 'A20', 1, 'APW', 'CAK', 11, 'on time', 250, '12/5/2017 17:00', '12/6/2017 20:00'),
(2, 2, 3, 'B30', 2, 'AKL', 'AKC', 13, 'delayed', 300, '12/6/2017 19:00', '12/7/2017 1:00'),
(3, 3, 3, 'C40', 2, 'ASG', 'ABQ', 15, 'cancelled', 350, '12/8/2017 20:00', '12/8/2017 23:00'),
(4, 4, 4, 'D15', 1, 'AAU', 'ANC', 17, 'delayed', 400.50, '12/25/2017 14:00', '12/26/2017 23:00'),
(5, 5, 5, 'C17', 2, 'AMZ', 'ATW', 19, 'on time', 375, '12/30/2017 6:00', '12/31/2017 5:00') ON CONFLICT (flight_number) DO NOTHING;

insert into contact values
(1, 'Gjergji', 'Heqimi', '248-555-2222', 'gheqimi@gmail.com', 'Brother'),
(2, 'Kajuan', 'Joshnson', '248-222-5555', 'kjohnson@gmail.com', 'Cousin'),
(3, 'John', 'Podsiadlik', '248-333-7777', 'jpod@gmail.com', 'Dad'),
(4, 'Shital', 'Joshi', '313-222-5555', 'sjoshi@gmail.com', 'Friend'),
(5, 'Jane', 'Doe', '313-555-2222', 'jdoe@gmail.com', 'Sister') ON CONFLICT (contact_id) DO NOTHING;

insert into job values
(1, 'Flight Attendant', 80000),
(2, 'Pilot', 200000),
(3, 'Pilot', 200000),
(4, 'Passenger Service', 60000),
(5, 'Aircraft Inspector', 100000) ON CONFLICT (job_id) DO NOTHING;

insert into payment values
(1, 'JP Morgan Chase', 6123456, 'Debit', '1111222233334444', 1000),
(2, 'OU Credit Union', 6234567, 'Credit', '2222333344445555', 1250),
(3, 'Bank of America', 6345678, 'Credit', '3333444455556666', 750),
(4, 'MSU Credit Union', 6456789, 'Debit', '4444555566667777', 300),
(5, 'JP Morgan Chase', 6123456, 'Debit', '5555666677778888', 400) ON CONFLICT (invoice_id) DO NOTHING;

insert into reservation values
(1, 2, 'A1', 'Wheelchair', 1, 1, '1'),
(2, 3, 'B10', 'Custom Meal', 2, 2, '1'),
(3, 4, 'C15', '', 3, 3, '0'),
(4, 5, 'D20', '', 4, 5, '1'),
(5, 6, 'F7', '', 5, 4, '0') ON CONFLICT (reservation_id) DO NOTHING;

insert into cancellations values
(1, '12/4/2017'),
(2, '10/7/2012'),
(3, '7/7/2007'),
(4, '10/10/2010');

insert into services values
(1, 'Pulp Fuction', 'no', 'Pizza'),
(2, '', 'free', ''),
(3, 'Star Wars', 'free', 'Pasta'),
(4, 'Star Trek', 'paid', 'Chicken'),
(5, '', 'no', 'Chicken') ON CONFLICT (service_id) DO NOTHING;

insert into employee values
(1, 1, 'APW', 1, 'Slim', 'Shady', '12/1/2017'),
(2, 4, 'AKL', 2, 'Doctor', 'Dre', '7/10/2010'),
(3, 3, 'ASG', 3, 'Lil', 'Wayne', '3/2/2007'),
(4, 2, 'ASG', 4, 'Taylor', 'Swift', '10/7/1993'),
(5, 5, 'AAU', 5, 'Miley', 'Cyrus', '5/19/1997') ON CONFLICT (employee_id) DO NOTHING;

insert into membership values
(1, 50, 'Silver'),
(2, 100, 'Gold'),
(3, 100, 'Gold'),
(4, 200, 'Platinum'),
(5, 200, 'Platinum') ON CONFLICT (membership_id) DO NOTHING;

insert into customer values
(1, 'Tom', 'Brady', 'tbrady@gmail.com', '1', '12125 Football Dr.', 'Boston', 'Massachusetts', 'USA', 4, 1, 1),
(2, 'Matthew', 'Stafford', 'mstafford@gmal.com', '1', '99990 Football Rd.', 'Detroit', 'Michigan', 'USA', 3, 2, 2),
(3, 'Aaron', 'Rodgers', 'arodgers@gmail.com', '0', '12121 Football Dr.', 'Green Bay', 'Wisconsin', 'USA', 2, 3, 3),
(4, 'Russell', 'Wilson', 'rwilson@gmail.com', '0', '33331 Football Rd.', 'Seattle', 'Washington', 'USA', 1, 4, 4),
(5, 'Cam', 'Newton', 'cnewton@gmail.com', '1', '11110 Superman Dr.', 'Charlotte', 'North Carolina', 'USA', 5, 5, 5) ON CONFLICT (customer_id) DO NOTHING;
