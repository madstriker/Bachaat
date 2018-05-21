CREATE TABLE tbl_user (
    user_id int PRIMARY KEY AUTO_INCREMENT,
    first_name varchar(50),
    middle_name varchar(50),
    password varchar(70),
    last_name varchar(50),
    mobile_number varchar(50),
    email_address varchar(50),
    address varchar(50),
    activation_code int,
    created_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP ,
    updated_date TIMESTAMP DEFAULT 0 ON UPDATE CURRENT_TIMESTAMP ,
    active boolean DEFAULT FALSE
);