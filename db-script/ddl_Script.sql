create table Teacher (teacher_id int primary key,first_name text,middle_name text,last_name text,dob date,
					 department text,qualification text,address text,email text,mobile text,pass text,conf_pass text);
			
create table Student (student_id int primary key,first_name text,middle_name text,last_name text,dob date,roll_no int,
					 course text,address text,email text,mobile text,pass text,conf_pass text);
					
create table  Login(email text,pass text,conf_pass text,user_type text);
