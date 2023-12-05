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
	Role VARCHAR(10)NOT NULL,
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
	Price DECIMAL(10, 2) NOT NULL,
	Status VARCHAR(20) NULL,
);

-- Create Booking Table
CREATE TABLE OrderBooking (
    OrderID int PRIMARY KEY identity(1,1),
    PetID VARCHAR(10) NOT NULL,
    CreateDate DATE NOT NULL,
	Total money,
	CheckinDate DATE,
	CheckoutDate DATE,
    Status VARCHAR(10) NOT NULL,
    FOREIGN KEY (PetID) REFERENCES Pet(PetID),
    
);
--Create OrderDetail table
CREATE TABLE OrderDetail(
   DetailID int PRIMARY KEY identity(1,1),
   OrderID int,
   ServiceID VARCHAR(10) NOT NULL,
   Duration int,
   FOREIGN KEY (ServiceID) REFERENCES Service(ServiceID),  
   FOREIGN KEY (OrderID) REFERENCES OrderBooking(OrderID)
);

-- Create Feedback Table
CREATE TABLE Feedback (
    FeedbackID int PRIMARY KEY identity(1,1),
    CustomerID VARCHAR(10) NOT NULL,
	OrderID int NOT NULL,
    Content NVARCHAR(500),
	Reply NVARCHAR(500),
    CreateDate DATE NOT NULL,
    FOREIGN KEY (CustomerID) REFERENCES Customer(CustomerID),
	FOREIGN KEY (OrderID) REFERENCES OrderBooking(OrderID)
);


-- Insert data into Customer table
INSERT INTO Customer (CustomerID, CustomerName, Password, Phone,Role,Status)
VALUES
('C172157', N'Nguyễn Trần Hữu Đức', '12345', '0909794147','Cus','Active'),
('C201725', N'Nguyễn Hoàng Hải', '12345', '5559876543','Cus', 'Active'),
('C191003', N'Bob Johnson', '12345', '5557891234','Cus', 'Blocked'),
('A000001', N'Nguyễn Hoàng Hải', '12345', '5559876543','Admin', 'Active');

-- Insert data into Pet table
INSERT INTO Pet (PetID, CustomerID, PetName,PetType, Status)
VALUES
('P001', 'C172157', 'Sue','Cat', 'Fit'),
('P002', 'C201725', 'Bo','Dog', 'Not Fit');
-- Insert data into Service table
INSERT INTO Service (ServiceID, ServiceName, Price, Status)
VALUES
('1','Pet Training','500.00','Available'),
('2','Pet Cleaning','40.99','Available'),
('3','Pet Vaccination','30.50','Available'),
('4','Pet Play Ground','100.00','Available'),
('5','Pet Stay Care (NORMAL)','50.00','Available'),
('6','Pet Stay Care (VIP)','299.99','Available'),
('7','Pet Treatment','150.00','Disable');