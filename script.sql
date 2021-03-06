USE [InventoryDb]
GO
/****** Object:  Table [dbo].[Account]    Script Date: 3/16/2018 2:04:31 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Account](
	[AccountId] [bigint] IDENTITY(1,1) NOT NULL,
	[Usename] [varchar](255) NOT NULL,
	[Password] [varchar](255) NOT NULL,
	[FirstName] [nvarchar](255) NULL,
	[LastName] [nvarchar](255) NULL,
	[NumPhone] [varchar](30) NULL,
	[Email] [varchar](255) NULL,
	[InActive] [bit] NOT NULL,
	[Role] [int] NOT NULL,
 CONSTRAINT [PK_Account] PRIMARY KEY CLUSTERED 
(
	[AccountId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Category]    Script Date: 3/16/2018 2:04:31 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Category](
	[CategoryId] [bigint] IDENTITY(1,1) NOT NULL,
	[Name] [nvarchar](500) NOT NULL,
 CONSTRAINT [PK_Category] PRIMARY KEY CLUSTERED 
(
	[CategoryId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[DeliveryBill]    Script Date: 3/16/2018 2:04:31 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[DeliveryBill](
	[DeliveryBillId] [bigint] IDENTITY(1,1) NOT NULL,
	[PartnerId] [bigint] NULL,
	[Datetime] [datetime2](7) NOT NULL,
	[AccountId] [bigint] NULL,
	[Status] [int] NOT NULL,
 CONSTRAINT [PK_DeliveryBill] PRIMARY KEY CLUSTERED 
(
	[DeliveryBillId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[DeliveryBillDetail]    Script Date: 3/16/2018 2:04:32 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[DeliveryBillDetail](
	[DeliveryBillDetailId] [bigint] IDENTITY(1,1) NOT NULL,
	[DeliveryBillId] [bigint] NULL,
	[ProductId] [bigint] NULL,
	[Quantity] [int] NOT NULL,
 CONSTRAINT [PK_DeliveryBillDetail] PRIMARY KEY CLUSTERED 
(
	[DeliveryBillDetailId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Partner]    Script Date: 3/16/2018 2:04:32 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Partner](
	[PartnerId] [bigint] IDENTITY(1,1) NOT NULL,
	[PartnerName] [nvarchar](255) NOT NULL,
	[Description] [nvarchar](500) NULL,
	[Address] [nvarchar](255) NULL,
	[NumPhone] [nvarchar](30) NULL,
	[RepresentFullname] [nvarchar](255) NULL,
 CONSTRAINT [PK_Partner] PRIMARY KEY CLUSTERED 
(
	[PartnerId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Product]    Script Date: 3/16/2018 2:04:32 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Product](
	[ProductId] [bigint] IDENTITY(1,1) NOT NULL,
	[Code] [nvarchar](255) NOT NULL,
	[ProductName] [nvarchar](255) NOT NULL,
	[Description] [nvarchar](500) NULL,
	[Quantity] [int] NOT NULL,
	[Status] [int] NOT NULL,
	[ProductType] [int] NOT NULL,
	[CategoryId] [bigint] NULL,
 CONSTRAINT [PK_Product] PRIMARY KEY CLUSTERED 
(
	[ProductId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Receipt]    Script Date: 3/16/2018 2:04:32 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Receipt](
	[ReceiptId] [bigint] IDENTITY(1,1) NOT NULL,
	[PartnerId] [bigint] NULL,
	[Datetime] [datetime2](7) NOT NULL,
	[AccountId] [bigint] NULL,
	[Status] [int] NOT NULL,
 CONSTRAINT [PK_Receipt] PRIMARY KEY CLUSTERED 
(
	[ReceiptId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[ReceiptDetail]    Script Date: 3/16/2018 2:04:32 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ReceiptDetail](
	[ReceiptDetailId] [bigint] IDENTITY(1,1) NOT NULL,
	[ReceiptId] [bigint] NULL,
	[ProductId] [bigint] NULL,
	[Quantity] [int] NOT NULL,
 CONSTRAINT [PK_ReceiptDetail] PRIMARY KEY CLUSTERED 
(
	[ReceiptDetailId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET IDENTITY_INSERT [dbo].[Category] ON 

INSERT [dbo].[Category] ([CategoryId], [Name]) VALUES (1, N'Văn phòng phẩm')
INSERT [dbo].[Category] ([CategoryId], [Name]) VALUES (2, N'Đồ gia dụng')
INSERT [dbo].[Category] ([CategoryId], [Name]) VALUES (3, N'Đồ điện')
SET IDENTITY_INSERT [dbo].[Category] OFF
SET IDENTITY_INSERT [dbo].[Partner] ON 

INSERT [dbo].[Partner] ([PartnerId], [PartnerName], [Description], [Address], [NumPhone], [RepresentFullname]) VALUES (1, N'Ԁt䌏奔䌠⁐楖慮楍歬', N'Ԁt⸁', N'Ԁt䠃䵃', N'Ԁt》㜹㤱㘲㠱㘲', N'Ԁt丏畧薻⁮쑖溃䄠')
INSERT [dbo].[Partner] ([PartnerId], [PartnerName], [Description], [Address], [NumPhone], [RepresentFullname]) VALUES (2, N'Ԁt䌔奔䌠⁐潌杮桔湡䵨汩k', N'Ԁt⸁', N'Ԁt쐋鎻杮丠楡', N'Ԁt》㤲㜱㤲㜱ㄲ', N'Ԁt丌畧敹⁮慖⁮B')
SET IDENTITY_INSERT [dbo].[Partner] OFF
SET IDENTITY_INSERT [dbo].[Receipt] ON 

INSERT [dbo].[Receipt] ([ReceiptId], [PartnerId], [Datetime], [AccountId], [Status]) VALUES (1, NULL, CAST(N'1970-01-01T07:00:00.0000000' AS DateTime2), NULL, 0)
INSERT [dbo].[Receipt] ([ReceiptId], [PartnerId], [Datetime], [AccountId], [Status]) VALUES (2, NULL, CAST(N'1970-01-01T07:00:00.0000000' AS DateTime2), NULL, 0)
INSERT [dbo].[Receipt] ([ReceiptId], [PartnerId], [Datetime], [AccountId], [Status]) VALUES (3, NULL, CAST(N'1970-01-01T07:00:00.0000000' AS DateTime2), NULL, 0)
SET IDENTITY_INSERT [dbo].[Receipt] OFF
ALTER TABLE [dbo].[Account] ADD  CONSTRAINT [DF_Account_Role]  DEFAULT ((0)) FOR [Role]
GO
ALTER TABLE [dbo].[DeliveryBillDetail] ADD  CONSTRAINT [DF_DeliveryBillDetail_Quantity]  DEFAULT ((0)) FOR [Quantity]
GO
ALTER TABLE [dbo].[Product] ADD  CONSTRAINT [DF_Product_Quantity]  DEFAULT ((0)) FOR [Quantity]
GO
ALTER TABLE [dbo].[Product] ADD  CONSTRAINT [DF_Product_Status]  DEFAULT ((0)) FOR [Status]
GO
ALTER TABLE [dbo].[ReceiptDetail] ADD  CONSTRAINT [DF_ReceiptDetails_Quantity]  DEFAULT ((0)) FOR [Quantity]
GO
ALTER TABLE [dbo].[DeliveryBill]  WITH CHECK ADD  CONSTRAINT [FK_DeliveryBill_Account] FOREIGN KEY([AccountId])
REFERENCES [dbo].[Account] ([AccountId])
GO
ALTER TABLE [dbo].[DeliveryBill] CHECK CONSTRAINT [FK_DeliveryBill_Account]
GO
ALTER TABLE [dbo].[DeliveryBill]  WITH CHECK ADD  CONSTRAINT [FK_DeliveryBill_Account1] FOREIGN KEY([AccountId])
REFERENCES [dbo].[Account] ([AccountId])
GO
ALTER TABLE [dbo].[DeliveryBill] CHECK CONSTRAINT [FK_DeliveryBill_Account1]
GO
ALTER TABLE [dbo].[DeliveryBill]  WITH CHECK ADD  CONSTRAINT [FK_DeliveryBill_Partner] FOREIGN KEY([PartnerId])
REFERENCES [dbo].[Partner] ([PartnerId])
GO
ALTER TABLE [dbo].[DeliveryBill] CHECK CONSTRAINT [FK_DeliveryBill_Partner]
GO
ALTER TABLE [dbo].[DeliveryBillDetail]  WITH CHECK ADD  CONSTRAINT [FK_DeliveryBillDetail_DeliveryBill] FOREIGN KEY([DeliveryBillId])
REFERENCES [dbo].[DeliveryBill] ([DeliveryBillId])
GO
ALTER TABLE [dbo].[DeliveryBillDetail] CHECK CONSTRAINT [FK_DeliveryBillDetail_DeliveryBill]
GO
ALTER TABLE [dbo].[DeliveryBillDetail]  WITH CHECK ADD  CONSTRAINT [FK_DeliveryBillDetail_Product] FOREIGN KEY([ProductId])
REFERENCES [dbo].[Product] ([ProductId])
GO
ALTER TABLE [dbo].[DeliveryBillDetail] CHECK CONSTRAINT [FK_DeliveryBillDetail_Product]
GO
ALTER TABLE [dbo].[Product]  WITH CHECK ADD  CONSTRAINT [FK_Product_Category] FOREIGN KEY([CategoryId])
REFERENCES [dbo].[Category] ([CategoryId])
GO
ALTER TABLE [dbo].[Product] CHECK CONSTRAINT [FK_Product_Category]
GO
ALTER TABLE [dbo].[Receipt]  WITH CHECK ADD  CONSTRAINT [FK_Receipt_Account] FOREIGN KEY([AccountId])
REFERENCES [dbo].[Account] ([AccountId])
GO
ALTER TABLE [dbo].[Receipt] CHECK CONSTRAINT [FK_Receipt_Account]
GO
ALTER TABLE [dbo].[Receipt]  WITH CHECK ADD  CONSTRAINT [FK_Receipt_Partner] FOREIGN KEY([PartnerId])
REFERENCES [dbo].[Partner] ([PartnerId])
GO
ALTER TABLE [dbo].[Receipt] CHECK CONSTRAINT [FK_Receipt_Partner]
GO
ALTER TABLE [dbo].[ReceiptDetail]  WITH CHECK ADD  CONSTRAINT [FK_ReceiptDetail_Product] FOREIGN KEY([ProductId])
REFERENCES [dbo].[Product] ([ProductId])
GO
ALTER TABLE [dbo].[ReceiptDetail] CHECK CONSTRAINT [FK_ReceiptDetail_Product]
GO
ALTER TABLE [dbo].[ReceiptDetail]  WITH CHECK ADD  CONSTRAINT [FK_ReceiptDetail_Receipt] FOREIGN KEY([ReceiptId])
REFERENCES [dbo].[Receipt] ([ReceiptId])
GO
ALTER TABLE [dbo].[ReceiptDetail] CHECK CONSTRAINT [FK_ReceiptDetail_Receipt]
GO
