/****** Script for SelectTopNRows command from SSMS  ******/
SELECT TOP 1000 [OrderID]
      ,[PetID]
      ,[CreateDate]
      ,[CheckinDate]
      ,[CheckoutDate]
      ,[Status]
  FROM [PetShopWeb].[dbo].[OrderBooking]

  SELECT  ob.OrderID, PetName, CustomerName, Phone, s2.ServiceName, ob.CreateDate, ob.CheckinDate, ob.CheckoutDate, ob.Status
  FROM [dbo].[OrderBooking] ob
  JOIN [dbo].[OrderDetail] od ON ob.OrderID=od.OrderID
  JOIN [dbo].[Pet] p ON p.PetID=ob.PetID
  JOIN [dbo].[Customer] c ON c.CustomerID=p.CustomerID
  JOIN [dbo].[Service2] s2 ON s2.ServiceID=od.ServiceID


  SELECT  *
  FROM [dbo].[OrderBooking] ob
  JOIN [dbo].[OrderDetail] od ON ob.OrderID=od.OrderID
  JOIN [dbo].[Pet] p ON p.PetID=ob.PetID
  JOIN [dbo].[Customer] c ON c.CustomerID=p.CustomerID
  JOIN [dbo].[Service] s2 ON s2.ServiceID=od.ServiceID