insert into tool (id, name, link, description) values 
	(1, 
	'Nodejs', 
	'https://nodejs.org/en/', 
	'Designed to build scalable network applications using .js'
	);

insert into tool (id, name, link, description) values 
	(2, 
	'MongoDB', 
	'https://www.mongodb.com/',
	'MongoDB is a general purpose, document-based, distributed database built for modern application developers and for the cloud era'
	);

insert into tag (name, tool_id) values ('server', 1), ('javascript', 1), ('asynchronous', 1), 
('database', 2), ('nosql', 2), ('bigdata', 2), ('document', 2); 
