-- Create Database
CREATE DATABASE PetShopWeb
Go
USE PetShopWeb
Go

-- Create User Table
CREATE TABLE Customer(
    CustomerID VARCHAR(10) PRIMARY KEY,
	CustomerName NVARCHAR(255) NOT NULL,
	Password VARCHAR(50) NOT NULL,
	Phone VARCHAR(255) NOT NULL,
    Status VARCHAR(10) NOT NULL,
);
-- Create Pet Table
CREATE TABLE Pet (
    PetID VARCHAR(10) PRIMARY KEY,
    CustomerID VARCHAR(10) NOT NULL,
    PetName VARCHAR(255) NOT NULL,
	PetType VARCHAR(20) NOT NULL,
    Status VARCHAR(10) NOT NULL,
    FOREIGN KEY (CustomerID) REFERENCES Customer(CustomerID)
);

-- Create Service Table
CREATE TABLE Service (
    ServiceID VARCHAR(10) PRIMARY KEY,
    ServiceName VARCHAR(255) NOT NULL,
	Price DECIMAL(10, 2) NOT NULL
);

-- Create Booking Table
CREATE TABLE OrderBooking (
    OrderID VARCHAR(10) PRIMARY KEY,
    PetID VARCHAR(10) NOT NULL,
    CreateDate DATE NOT NULL,
	CheckinDate DATE NOT NULL,
	CheckoutDate DATE NOT NULL,
    Status VARCHAR(10) NOT NULL,
    FOREIGN KEY (PetID) REFERENCES Pet(PetID),
    
);
--Create OrderDetail table
CREATE TABLE OrderDetail(
   OrderID VARCHAR(10),
   ServiceID VARCHAR(10) NOT NULL,
   PRIMARY KEY (OrderID, ServiceID),
   FOREIGN KEY (ServiceID) REFERENCES Service(ServiceID),  
   FOREIGN KEY (OrderID) REFERENCES OrderBooking(OrderID)
);

-- Create Feedback Table
CREATE TABLE Feedback (
    FeedbackID VARCHAR(10) PRIMARY KEY,
    CustomerID VARCHAR(10) NOT NULL,
	OrderID VARCHAR(10) NOT NULL,
    Content NVARCHAR(500) NOT NULL,
    CreateDate DATE NOT NULL,
    FOREIGN KEY (CustomerID) REFERENCES Customer(CustomerID),
	FOREIGN KEY (OrderID) REFERENCES OrderBooking(OrderID)
);
CREATE TABLE Admin(
	UserName NVARCHAR(255) NOT NULL,
	Password VARCHAR(50) NOT NULL,
);

-- Insert data into Customer table
INSERT INTO Customer (CustomerID, CustomerName, Password, Phone, Status)
VALUES
('C172157', N'Nguyễn Trần Hữu Đức', '12345', '0909794147', 'Active'),
('C201725', N'Nguyễn Hoàng Hải', '12345', '5559876543', 'Active'),
('C191003', 'Bob Johnson', '12345', '5557891234', 'Blocked');

-- Insert data into Pet table
INSERT INTO Pet (PetID, CustomerID, PetName, Status)
VALUES
('P001', 'C172157', 'Sue', 'Fit'),
('P002', 'C201725', 'Bo', 'Not Fit');
-- Insert data into Service table
INSERT INTO Service (ServiceID, ServiceName, Price)
VALUES
('1','Pet Training','500.00'),
('2','Pet Cleaning','40.99'),
('3','Pet Vaccination','30.50'),
('4','Pet Play Ground','100.00'),
('5','Pet Stay Care (NORMAL)','50.00'),
('6','Pet Stay Care (VIP)','299.99');