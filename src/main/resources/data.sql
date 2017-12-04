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
('1380000', '116000', '2345', '7250', 'Boeing 757-200PF'),
('1381000', '575155', '3456', '11750', 'Airbus A380'),
('1382000', '116000', '4567', '7250', 'Boeing 757-200PF'),
('1383000', '396890', '5678', '14427', 'Being 747-400'),
('1384000', '442000', '6789', '14816', 'Boeing 747-8') ON CONFLICT (aircraft_id) DO NOTHING;

insert into contact values
('2120000', 'Gjergji', 'Heqimi', '2485552222', 'gheqimi@gmail.com', 'Brother'),
('2121000', 'Kajuan', 'Joshnson', '2482225555', 'kjohnson@gmail.com', 'Cousin'),
('2122000', 'John', 'Podsiadlik', '2483337777', 'jpod@gmail.com', 'Dad'),
('2123000', 'Shital', 'Joshi', '3132225555', 'sjoshi@gmail.com', 'Friend'),
('2124000', 'Jane', 'Doe', '3135552222', 'jdoe@gmail.com', 'Sister') ON CONFLICT (contact_id) DO NOTHING;

insert into job values
('4120000', 'Flight Attendant', '80000'),
('4121000', 'Pilot', '200000'),
('4122000', 'Pilot', '200000'),
('4123000', 'Passenger Service', '60000'),
('4124000', 'Aircraft Inspector', '100000') ON CONFLICT (job_id) DO NOTHING;

insert into payment values
('5120000', 'JP Morgan Chase', '6123456', 'Debit', '1111222233334444', '1000'),
('5121000', 'OU Credit Union', '6234567', 'Credit', '2222333344445555', '1250'),
('5122000', 'Bank of America', '6345678', 'Credit', '3333444455556666', '750'),
('5123000', 'MSU Credit Union', '6456789', 'Debit', '4444555566667777', '300'),
('5124000', 'JP Morgan Chase', '6123456', 'Debit', '5555666677778888', '400') ON CONFLICT (invoice_id) DO NOTHING;

insert into reservation values
('6120000', '2', 'A1', 'Wheelchair', '1380000', '5120000', '1'),
('6121000', '3', 'B10', 'Custom Meal', '1380000', '5121000', '1'),
('6122000', '4', 'C15', '', '1381000', '5122000', '0'),
('6123000', '5', 'D20', '', '1382000', '5123000', '1'),
('6124000', '6', 'F7', '', '1383000', '5124000', '0') ON CONFLICT (reservation_id) DO NOTHING;

insert into services values
('7120000', 'Pulp Fuction', 'no', 'Pizza'),
('7121000', '', 'free', ''),
('7122000', 'Star Wars', 'free', 'Pasta'),
('7123000', 'Star Trek', 'paid', 'Chicken'),
('7124000', '', 'no', 'Chicken') ON CONFLICT (service_id) DO NOTHING;

insert into employee values
('8120000', '1380000', 'APW', '4120000', 'Slim', 'Shady', '12/1/2017'),
('8121000', '1381000', 'AKL', '4121000', 'Doctor', 'Dre', '7/10/2010'),
('8122000', '1382000', 'ASG', '4122000', 'Lil', 'Wayne', '3/2/2007'),
('8123000', '1382000', 'ASG', '4123000', 'Taylor', 'Swift', '10/7/1993'),
('8124000', '1383000', 'AAU', '4124000', 'Miley', 'Cyrus', '5/19/1997') ON CONFLICT (employee_id) DO NOTHING;

insert into customer values
('9120000', 'Tom', 'Brady', 'tbrady@gmail.com', '1', '12125 Football Dr.', 'Boston', 'Massachusetts', 'USA', '2121000', '6120000'),
('9121000', 'Matthew', 'Stafford', 'mstafford@gmal.com', '1', '99990 Football Rd.', 'Detroit', 'Michigan', 'USA', '2120000', '6121000'),
('9122000', 'Aaron', 'Rodgers', 'arodgers@gmail.com', '0', '12121 Football Dr.', 'Green Bay', 'Wisconsin', 'Canada', '2122000', '6122000'),
('9123000', 'Russel', 'Wilson', 'rwilson@gmail.com', '0', '33331 Football Rd.', 'Seattle', 'Washington', 'USA', '2120000', '6123000'),
('9124000', 'Cam', 'Newton', 'cnewton@gmail.com', '1', '11110 Superman Dr.', 'Charlotte', 'North Carolina', 'USA', '2123000', '614000') ON CONFLICT (customer_id) DO NOTHING;

insert into membership values
('0120000', '50', '9120000', 'Silver'),
('0121000', '100', '9121000', 'Gold'),
('0122000', '100', '9122000', 'Gold'),
('0123000', '200', '9123000', 'Platinum'),
('0124000', '200', '9124000', 'Platinum') ON CONFLICT (membership_id) DO NOTHING;
