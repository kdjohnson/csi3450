insert into airport values 
('APW', 'Faleolo', 'Apia', 'Samoa'), 
('AKL', 'Auckland Airport', 'Auckland', 'New Zealand'), 
('ASG', 'Ashburton Aerodrome', 'Ashburton', 'New Zealand'), 
('AAU' , 'Asau Airport', 	'Asau',  'Samoa'), 
('AMZ' , 'Ardmore Airport', 'Ardmore' , 'New Zealand'), 
('ADI' , 'Arandis Airport', 'Arandis', 'Namibia') ON CONFLICT (airport_id) DO NOTHING;

insert into airport values 
( 'CAK', 'Akron–Canton Airport', 'Akron', 'USA'), 
( 'AKC', 'Akron Fulton International Airport', 'Akron', 'USA'), 
('ABQ', 'Albuquerque International Sunport', 'Albuquerque','USA'), 
('ANC',  'Ted Stevens Anchorage International Airport','Anchorage', 'USA'), 
('ATW', 'Appleton International Airport','Appleton',  'USA'), 
('ATL',  'Hartsfield-Jackson Atlanta International Airport' , 'Atlanta ', 'USA'), 
('ACY', 'Atlantic City International Airport', 'Atlantic City', 'USA') ON CONFLICT (airport_id) DO NOTHING;

insert into flight values
(DEFAULT, 4, 'A20', 1, 'APW', 'CAK', 11, 'on time', 250),
(DEFAULT, 3, 'B30', 2, 'AKL', 'AKC', 13, 'delayed', 300),
(DEFAULT, 3, 'C40', 2, 'ASG', 'ABQ', 15, 'cancelled', 350),
(DEFAULT, 4, 'D15', 1, 'AAU', 'ANC', 17, 'delayed', 400.50),
(DEFAULT, 5, 'C17', 2, 'AMZ', 'ATW', 19, 'on time', 375) ON CONFLICT (flight_number) DO NOTHING;
