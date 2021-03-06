



CREATE TABLE ST_ZVARL_B(
	[STCD] [char](8) NOT NULL,
	[MSTM] [datetime] NOT NULL,
	[PTNO] [numeric](4, 0) NOT NULL,
	[RZ] [numeric](7, 3) NOT NULL,
	[W] [numeric](9, 3) NULL,
	[WSFA] [numeric](7, 3) NULL,
	[MODITIME] [datetime] NULL,
 CONSTRAINT [PK_ST_ZVARL_B] PRIMARY KEY NONCLUSTERED
(
	[STCD] ASC,
	[MSTM] ASC,
	[PTNO] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]


SET ANSI_PADDING OFF

EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'测站编码' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'ST_ZVARL_B', @level2type=N'COLUMN',@level2name=N'STCD'

EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'施测时间' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'ST_ZVARL_B', @level2type=N'COLUMN',@level2name=N'MSTM'

EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'点序号' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'ST_ZVARL_B', @level2type=N'COLUMN',@level2name=N'PTNO'

EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'库水位' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'ST_ZVARL_B', @level2type=N'COLUMN',@level2name=N'RZ'

EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'蓄水量单位(106m3)' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'ST_ZVARL_B', @level2type=N'COLUMN',@level2name=N'W'

EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'水面面积单位(km2)' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'ST_ZVARL_B', @level2type=N'COLUMN',@level2name=N'WSFA'

EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'时间戳' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'ST_ZVARL_B', @level2type=N'COLUMN',@level2name=N'MODITIME'

EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'存储水库（湖）的水位和蓄水量之间的相关关系' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'ST_ZVARL_B'




INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1 AS Numeric(4, 0)), CAST(22.590 AS Numeric(7, 3)), CAST(0.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2 AS Numeric(4, 0)), CAST(22.600 AS Numeric(7, 3)), CAST(0.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3 AS Numeric(4, 0)), CAST(22.610 AS Numeric(7, 3)), CAST(0.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(4 AS Numeric(4, 0)), CAST(22.620 AS Numeric(7, 3)), CAST(0.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(5 AS Numeric(4, 0)), CAST(22.630 AS Numeric(7, 3)), CAST(0.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(6 AS Numeric(4, 0)), CAST(22.640 AS Numeric(7, 3)), CAST(0.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(7 AS Numeric(4, 0)), CAST(22.650 AS Numeric(7, 3)), CAST(0.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(8 AS Numeric(4, 0)), CAST(22.660 AS Numeric(7, 3)), CAST(0.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(9 AS Numeric(4, 0)), CAST(22.670 AS Numeric(7, 3)), CAST(0.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(10 AS Numeric(4, 0)), CAST(22.680 AS Numeric(7, 3)), CAST(0.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(11 AS Numeric(4, 0)), CAST(22.690 AS Numeric(7, 3)), CAST(0.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(12 AS Numeric(4, 0)), CAST(22.700 AS Numeric(7, 3)), CAST(0.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(13 AS Numeric(4, 0)), CAST(22.710 AS Numeric(7, 3)), CAST(0.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(14 AS Numeric(4, 0)), CAST(22.720 AS Numeric(7, 3)), CAST(0.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(15 AS Numeric(4, 0)), CAST(22.730 AS Numeric(7, 3)), CAST(0.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(16 AS Numeric(4, 0)), CAST(22.740 AS Numeric(7, 3)), CAST(0.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(17 AS Numeric(4, 0)), CAST(22.750 AS Numeric(7, 3)), CAST(0.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(18 AS Numeric(4, 0)), CAST(22.760 AS Numeric(7, 3)), CAST(0.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(19 AS Numeric(4, 0)), CAST(22.770 AS Numeric(7, 3)), CAST(0.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(20 AS Numeric(4, 0)), CAST(22.780 AS Numeric(7, 3)), CAST(0.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(21 AS Numeric(4, 0)), CAST(22.790 AS Numeric(7, 3)), CAST(0.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(22 AS Numeric(4, 0)), CAST(22.800 AS Numeric(7, 3)), CAST(0.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(23 AS Numeric(4, 0)), CAST(22.810 AS Numeric(7, 3)), CAST(0.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(24 AS Numeric(4, 0)), CAST(22.820 AS Numeric(7, 3)), CAST(0.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(25 AS Numeric(4, 0)), CAST(22.830 AS Numeric(7, 3)), CAST(0.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(26 AS Numeric(4, 0)), CAST(22.840 AS Numeric(7, 3)), CAST(0.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(27 AS Numeric(4, 0)), CAST(22.850 AS Numeric(7, 3)), CAST(0.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(28 AS Numeric(4, 0)), CAST(22.860 AS Numeric(7, 3)), CAST(0.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(29 AS Numeric(4, 0)), CAST(22.870 AS Numeric(7, 3)), CAST(0.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(30 AS Numeric(4, 0)), CAST(22.880 AS Numeric(7, 3)), CAST(0.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(31 AS Numeric(4, 0)), CAST(22.890 AS Numeric(7, 3)), CAST(0.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(32 AS Numeric(4, 0)), CAST(22.900 AS Numeric(7, 3)), CAST(0.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(33 AS Numeric(4, 0)), CAST(22.910 AS Numeric(7, 3)), CAST(0.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(34 AS Numeric(4, 0)), CAST(22.920 AS Numeric(7, 3)), CAST(0.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(35 AS Numeric(4, 0)), CAST(22.930 AS Numeric(7, 3)), CAST(0.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(36 AS Numeric(4, 0)), CAST(22.940 AS Numeric(7, 3)), CAST(0.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(37 AS Numeric(4, 0)), CAST(22.950 AS Numeric(7, 3)), CAST(0.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(38 AS Numeric(4, 0)), CAST(22.960 AS Numeric(7, 3)), CAST(0.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(39 AS Numeric(4, 0)), CAST(22.970 AS Numeric(7, 3)), CAST(0.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(40 AS Numeric(4, 0)), CAST(22.980 AS Numeric(7, 3)), CAST(0.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(41 AS Numeric(4, 0)), CAST(22.990 AS Numeric(7, 3)), CAST(0.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(42 AS Numeric(4, 0)), CAST(23.000 AS Numeric(7, 3)), CAST(0.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(43 AS Numeric(4, 0)), CAST(23.010 AS Numeric(7, 3)), CAST(0.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(44 AS Numeric(4, 0)), CAST(23.020 AS Numeric(7, 3)), CAST(0.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(45 AS Numeric(4, 0)), CAST(23.030 AS Numeric(7, 3)), CAST(0.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(46 AS Numeric(4, 0)), CAST(23.040 AS Numeric(7, 3)), CAST(0.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(47 AS Numeric(4, 0)), CAST(23.050 AS Numeric(7, 3)), CAST(0.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(48 AS Numeric(4, 0)), CAST(23.060 AS Numeric(7, 3)), CAST(0.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(49 AS Numeric(4, 0)), CAST(23.070 AS Numeric(7, 3)), CAST(0.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(50 AS Numeric(4, 0)), CAST(23.080 AS Numeric(7, 3)), CAST(0.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(51 AS Numeric(4, 0)), CAST(23.090 AS Numeric(7, 3)), CAST(0.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(52 AS Numeric(4, 0)), CAST(23.100 AS Numeric(7, 3)), CAST(0.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(53 AS Numeric(4, 0)), CAST(23.110 AS Numeric(7, 3)), CAST(0.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(54 AS Numeric(4, 0)), CAST(23.120 AS Numeric(7, 3)), CAST(0.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(55 AS Numeric(4, 0)), CAST(23.130 AS Numeric(7, 3)), CAST(0.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(56 AS Numeric(4, 0)), CAST(23.140 AS Numeric(7, 3)), CAST(0.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(57 AS Numeric(4, 0)), CAST(23.150 AS Numeric(7, 3)), CAST(0.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(58 AS Numeric(4, 0)), CAST(23.160 AS Numeric(7, 3)), CAST(0.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(59 AS Numeric(4, 0)), CAST(23.170 AS Numeric(7, 3)), CAST(0.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(60 AS Numeric(4, 0)), CAST(23.180 AS Numeric(7, 3)), CAST(0.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(61 AS Numeric(4, 0)), CAST(23.190 AS Numeric(7, 3)), CAST(0.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(62 AS Numeric(4, 0)), CAST(23.200 AS Numeric(7, 3)), CAST(0.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(63 AS Numeric(4, 0)), CAST(23.210 AS Numeric(7, 3)), CAST(0.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(64 AS Numeric(4, 0)), CAST(23.220 AS Numeric(7, 3)), CAST(0.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(65 AS Numeric(4, 0)), CAST(23.230 AS Numeric(7, 3)), CAST(0.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(66 AS Numeric(4, 0)), CAST(23.240 AS Numeric(7, 3)), CAST(0.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(67 AS Numeric(4, 0)), CAST(23.250 AS Numeric(7, 3)), CAST(0.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(68 AS Numeric(4, 0)), CAST(23.260 AS Numeric(7, 3)), CAST(0.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(69 AS Numeric(4, 0)), CAST(23.270 AS Numeric(7, 3)), CAST(0.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(70 AS Numeric(4, 0)), CAST(23.280 AS Numeric(7, 3)), CAST(0.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(71 AS Numeric(4, 0)), CAST(23.290 AS Numeric(7, 3)), CAST(0.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(72 AS Numeric(4, 0)), CAST(23.300 AS Numeric(7, 3)), CAST(0.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(73 AS Numeric(4, 0)), CAST(23.310 AS Numeric(7, 3)), CAST(0.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(74 AS Numeric(4, 0)), CAST(23.320 AS Numeric(7, 3)), CAST(0.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(75 AS Numeric(4, 0)), CAST(23.330 AS Numeric(7, 3)), CAST(0.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(76 AS Numeric(4, 0)), CAST(23.340 AS Numeric(7, 3)), CAST(0.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(77 AS Numeric(4, 0)), CAST(23.350 AS Numeric(7, 3)), CAST(0.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(78 AS Numeric(4, 0)), CAST(23.360 AS Numeric(7, 3)), CAST(0.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(79 AS Numeric(4, 0)), CAST(23.370 AS Numeric(7, 3)), CAST(0.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(80 AS Numeric(4, 0)), CAST(23.380 AS Numeric(7, 3)), CAST(0.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(81 AS Numeric(4, 0)), CAST(23.390 AS Numeric(7, 3)), CAST(0.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(82 AS Numeric(4, 0)), CAST(23.400 AS Numeric(7, 3)), CAST(0.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(83 AS Numeric(4, 0)), CAST(23.410 AS Numeric(7, 3)), CAST(0.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(84 AS Numeric(4, 0)), CAST(23.420 AS Numeric(7, 3)), CAST(0.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(85 AS Numeric(4, 0)), CAST(23.430 AS Numeric(7, 3)), CAST(0.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(86 AS Numeric(4, 0)), CAST(23.440 AS Numeric(7, 3)), CAST(0.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(87 AS Numeric(4, 0)), CAST(23.450 AS Numeric(7, 3)), CAST(0.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(88 AS Numeric(4, 0)), CAST(23.460 AS Numeric(7, 3)), CAST(0.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(89 AS Numeric(4, 0)), CAST(23.470 AS Numeric(7, 3)), CAST(0.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(90 AS Numeric(4, 0)), CAST(23.480 AS Numeric(7, 3)), CAST(0.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(91 AS Numeric(4, 0)), CAST(23.490 AS Numeric(7, 3)), CAST(0.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(92 AS Numeric(4, 0)), CAST(23.500 AS Numeric(7, 3)), CAST(0.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(93 AS Numeric(4, 0)), CAST(23.510 AS Numeric(7, 3)), CAST(0.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(94 AS Numeric(4, 0)), CAST(23.520 AS Numeric(7, 3)), CAST(0.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(95 AS Numeric(4, 0)), CAST(23.530 AS Numeric(7, 3)), CAST(0.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(96 AS Numeric(4, 0)), CAST(23.540 AS Numeric(7, 3)), CAST(0.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(97 AS Numeric(4, 0)), CAST(23.550 AS Numeric(7, 3)), CAST(0.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(98 AS Numeric(4, 0)), CAST(23.560 AS Numeric(7, 3)), CAST(0.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(99 AS Numeric(4, 0)), CAST(23.570 AS Numeric(7, 3)), CAST(0.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(100 AS Numeric(4, 0)), CAST(23.580 AS Numeric(7, 3)), CAST(0.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(101 AS Numeric(4, 0)), CAST(23.590 AS Numeric(7, 3)), CAST(0.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(102 AS Numeric(4, 0)), CAST(23.600 AS Numeric(7, 3)), CAST(0.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(103 AS Numeric(4, 0)), CAST(23.610 AS Numeric(7, 3)), CAST(0.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(104 AS Numeric(4, 0)), CAST(23.620 AS Numeric(7, 3)), CAST(0.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(105 AS Numeric(4, 0)), CAST(23.630 AS Numeric(7, 3)), CAST(0.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(106 AS Numeric(4, 0)), CAST(23.640 AS Numeric(7, 3)), CAST(0.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(107 AS Numeric(4, 0)), CAST(23.650 AS Numeric(7, 3)), CAST(0.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(108 AS Numeric(4, 0)), CAST(23.660 AS Numeric(7, 3)), CAST(0.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(109 AS Numeric(4, 0)), CAST(23.670 AS Numeric(7, 3)), CAST(0.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(110 AS Numeric(4, 0)), CAST(23.680 AS Numeric(7, 3)), CAST(0.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(111 AS Numeric(4, 0)), CAST(23.690 AS Numeric(7, 3)), CAST(0.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(112 AS Numeric(4, 0)), CAST(23.700 AS Numeric(7, 3)), CAST(0.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(113 AS Numeric(4, 0)), CAST(23.710 AS Numeric(7, 3)), CAST(0.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(114 AS Numeric(4, 0)), CAST(23.720 AS Numeric(7, 3)), CAST(0.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(115 AS Numeric(4, 0)), CAST(23.730 AS Numeric(7, 3)), CAST(0.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(116 AS Numeric(4, 0)), CAST(23.740 AS Numeric(7, 3)), CAST(0.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(117 AS Numeric(4, 0)), CAST(23.750 AS Numeric(7, 3)), CAST(0.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(118 AS Numeric(4, 0)), CAST(23.760 AS Numeric(7, 3)), CAST(0.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(119 AS Numeric(4, 0)), CAST(23.770 AS Numeric(7, 3)), CAST(0.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(120 AS Numeric(4, 0)), CAST(23.780 AS Numeric(7, 3)), CAST(0.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(121 AS Numeric(4, 0)), CAST(23.790 AS Numeric(7, 3)), CAST(0.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(122 AS Numeric(4, 0)), CAST(23.800 AS Numeric(7, 3)), CAST(0.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(123 AS Numeric(4, 0)), CAST(23.810 AS Numeric(7, 3)), CAST(0.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(124 AS Numeric(4, 0)), CAST(23.820 AS Numeric(7, 3)), CAST(0.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(125 AS Numeric(4, 0)), CAST(23.830 AS Numeric(7, 3)), CAST(0.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(126 AS Numeric(4, 0)), CAST(23.840 AS Numeric(7, 3)), CAST(0.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(127 AS Numeric(4, 0)), CAST(23.850 AS Numeric(7, 3)), CAST(0.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(128 AS Numeric(4, 0)), CAST(23.860 AS Numeric(7, 3)), CAST(0.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(129 AS Numeric(4, 0)), CAST(23.870 AS Numeric(7, 3)), CAST(0.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(130 AS Numeric(4, 0)), CAST(23.880 AS Numeric(7, 3)), CAST(0.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(131 AS Numeric(4, 0)), CAST(23.890 AS Numeric(7, 3)), CAST(0.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(132 AS Numeric(4, 0)), CAST(23.900 AS Numeric(7, 3)), CAST(0.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(133 AS Numeric(4, 0)), CAST(23.910 AS Numeric(7, 3)), CAST(0.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(134 AS Numeric(4, 0)), CAST(23.920 AS Numeric(7, 3)), CAST(0.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(135 AS Numeric(4, 0)), CAST(23.930 AS Numeric(7, 3)), CAST(0.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(136 AS Numeric(4, 0)), CAST(23.940 AS Numeric(7, 3)), CAST(0.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(137 AS Numeric(4, 0)), CAST(23.950 AS Numeric(7, 3)), CAST(0.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(138 AS Numeric(4, 0)), CAST(23.960 AS Numeric(7, 3)), CAST(0.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(139 AS Numeric(4, 0)), CAST(23.970 AS Numeric(7, 3)), CAST(0.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(140 AS Numeric(4, 0)), CAST(23.980 AS Numeric(7, 3)), CAST(0.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(141 AS Numeric(4, 0)), CAST(23.990 AS Numeric(7, 3)), CAST(0.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(142 AS Numeric(4, 0)), CAST(24.000 AS Numeric(7, 3)), CAST(0.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(143 AS Numeric(4, 0)), CAST(24.010 AS Numeric(7, 3)), CAST(0.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(144 AS Numeric(4, 0)), CAST(24.020 AS Numeric(7, 3)), CAST(0.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(145 AS Numeric(4, 0)), CAST(24.030 AS Numeric(7, 3)), CAST(0.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(146 AS Numeric(4, 0)), CAST(24.040 AS Numeric(7, 3)), CAST(0.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(147 AS Numeric(4, 0)), CAST(24.050 AS Numeric(7, 3)), CAST(0.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(148 AS Numeric(4, 0)), CAST(24.060 AS Numeric(7, 3)), CAST(0.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(149 AS Numeric(4, 0)), CAST(24.070 AS Numeric(7, 3)), CAST(0.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(150 AS Numeric(4, 0)), CAST(24.080 AS Numeric(7, 3)), CAST(0.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(151 AS Numeric(4, 0)), CAST(24.090 AS Numeric(7, 3)), CAST(0.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(152 AS Numeric(4, 0)), CAST(24.100 AS Numeric(7, 3)), CAST(0.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(153 AS Numeric(4, 0)), CAST(24.110 AS Numeric(7, 3)), CAST(0.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(154 AS Numeric(4, 0)), CAST(24.120 AS Numeric(7, 3)), CAST(0.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(155 AS Numeric(4, 0)), CAST(24.130 AS Numeric(7, 3)), CAST(0.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(156 AS Numeric(4, 0)), CAST(24.140 AS Numeric(7, 3)), CAST(0.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(157 AS Numeric(4, 0)), CAST(24.150 AS Numeric(7, 3)), CAST(0.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(158 AS Numeric(4, 0)), CAST(24.160 AS Numeric(7, 3)), CAST(0.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(159 AS Numeric(4, 0)), CAST(24.170 AS Numeric(7, 3)), CAST(0.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(160 AS Numeric(4, 0)), CAST(24.180 AS Numeric(7, 3)), CAST(0.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(161 AS Numeric(4, 0)), CAST(24.190 AS Numeric(7, 3)), CAST(0.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(162 AS Numeric(4, 0)), CAST(24.200 AS Numeric(7, 3)), CAST(0.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(163 AS Numeric(4, 0)), CAST(24.210 AS Numeric(7, 3)), CAST(0.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(164 AS Numeric(4, 0)), CAST(24.220 AS Numeric(7, 3)), CAST(0.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(165 AS Numeric(4, 0)), CAST(24.230 AS Numeric(7, 3)), CAST(0.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(166 AS Numeric(4, 0)), CAST(24.240 AS Numeric(7, 3)), CAST(0.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(167 AS Numeric(4, 0)), CAST(24.250 AS Numeric(7, 3)), CAST(0.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(168 AS Numeric(4, 0)), CAST(24.260 AS Numeric(7, 3)), CAST(0.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(169 AS Numeric(4, 0)), CAST(24.270 AS Numeric(7, 3)), CAST(0.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(170 AS Numeric(4, 0)), CAST(24.280 AS Numeric(7, 3)), CAST(0.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(171 AS Numeric(4, 0)), CAST(24.290 AS Numeric(7, 3)), CAST(0.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(172 AS Numeric(4, 0)), CAST(24.300 AS Numeric(7, 3)), CAST(0.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(173 AS Numeric(4, 0)), CAST(24.310 AS Numeric(7, 3)), CAST(0.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(174 AS Numeric(4, 0)), CAST(24.320 AS Numeric(7, 3)), CAST(0.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(175 AS Numeric(4, 0)), CAST(24.330 AS Numeric(7, 3)), CAST(0.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(176 AS Numeric(4, 0)), CAST(24.340 AS Numeric(7, 3)), CAST(0.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(177 AS Numeric(4, 0)), CAST(24.350 AS Numeric(7, 3)), CAST(0.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(178 AS Numeric(4, 0)), CAST(24.360 AS Numeric(7, 3)), CAST(0.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(179 AS Numeric(4, 0)), CAST(24.370 AS Numeric(7, 3)), CAST(0.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(180 AS Numeric(4, 0)), CAST(24.380 AS Numeric(7, 3)), CAST(0.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(181 AS Numeric(4, 0)), CAST(24.390 AS Numeric(7, 3)), CAST(0.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(182 AS Numeric(4, 0)), CAST(24.400 AS Numeric(7, 3)), CAST(0.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(183 AS Numeric(4, 0)), CAST(24.410 AS Numeric(7, 3)), CAST(0.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(184 AS Numeric(4, 0)), CAST(24.420 AS Numeric(7, 3)), CAST(0.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(185 AS Numeric(4, 0)), CAST(24.430 AS Numeric(7, 3)), CAST(0.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(186 AS Numeric(4, 0)), CAST(24.440 AS Numeric(7, 3)), CAST(0.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(187 AS Numeric(4, 0)), CAST(24.450 AS Numeric(7, 3)), CAST(0.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(188 AS Numeric(4, 0)), CAST(24.460 AS Numeric(7, 3)), CAST(0.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(189 AS Numeric(4, 0)), CAST(24.470 AS Numeric(7, 3)), CAST(0.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(190 AS Numeric(4, 0)), CAST(24.480 AS Numeric(7, 3)), CAST(0.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(191 AS Numeric(4, 0)), CAST(24.490 AS Numeric(7, 3)), CAST(1.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(192 AS Numeric(4, 0)), CAST(24.500 AS Numeric(7, 3)), CAST(1.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(193 AS Numeric(4, 0)), CAST(24.510 AS Numeric(7, 3)), CAST(1.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(194 AS Numeric(4, 0)), CAST(24.520 AS Numeric(7, 3)), CAST(1.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(195 AS Numeric(4, 0)), CAST(24.530 AS Numeric(7, 3)), CAST(1.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(196 AS Numeric(4, 0)), CAST(24.540 AS Numeric(7, 3)), CAST(1.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(197 AS Numeric(4, 0)), CAST(24.550 AS Numeric(7, 3)), CAST(1.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(198 AS Numeric(4, 0)), CAST(24.560 AS Numeric(7, 3)), CAST(1.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(199 AS Numeric(4, 0)), CAST(24.570 AS Numeric(7, 3)), CAST(1.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(200 AS Numeric(4, 0)), CAST(24.580 AS Numeric(7, 3)), CAST(1.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(201 AS Numeric(4, 0)), CAST(24.590 AS Numeric(7, 3)), CAST(1.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(202 AS Numeric(4, 0)), CAST(24.600 AS Numeric(7, 3)), CAST(1.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(203 AS Numeric(4, 0)), CAST(24.610 AS Numeric(7, 3)), CAST(1.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(204 AS Numeric(4, 0)), CAST(24.620 AS Numeric(7, 3)), CAST(1.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(205 AS Numeric(4, 0)), CAST(24.630 AS Numeric(7, 3)), CAST(1.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(206 AS Numeric(4, 0)), CAST(24.640 AS Numeric(7, 3)), CAST(1.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(207 AS Numeric(4, 0)), CAST(24.650 AS Numeric(7, 3)), CAST(1.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(208 AS Numeric(4, 0)), CAST(24.660 AS Numeric(7, 3)), CAST(1.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(209 AS Numeric(4, 0)), CAST(24.670 AS Numeric(7, 3)), CAST(1.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(210 AS Numeric(4, 0)), CAST(24.680 AS Numeric(7, 3)), CAST(1.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(211 AS Numeric(4, 0)), CAST(24.690 AS Numeric(7, 3)), CAST(1.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(212 AS Numeric(4, 0)), CAST(24.700 AS Numeric(7, 3)), CAST(1.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(213 AS Numeric(4, 0)), CAST(24.710 AS Numeric(7, 3)), CAST(1.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(214 AS Numeric(4, 0)), CAST(24.720 AS Numeric(7, 3)), CAST(1.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(215 AS Numeric(4, 0)), CAST(24.730 AS Numeric(7, 3)), CAST(1.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(216 AS Numeric(4, 0)), CAST(24.740 AS Numeric(7, 3)), CAST(1.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(217 AS Numeric(4, 0)), CAST(24.750 AS Numeric(7, 3)), CAST(1.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(218 AS Numeric(4, 0)), CAST(24.760 AS Numeric(7, 3)), CAST(1.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(219 AS Numeric(4, 0)), CAST(24.770 AS Numeric(7, 3)), CAST(1.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(220 AS Numeric(4, 0)), CAST(24.780 AS Numeric(7, 3)), CAST(1.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(221 AS Numeric(4, 0)), CAST(24.790 AS Numeric(7, 3)), CAST(1.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(222 AS Numeric(4, 0)), CAST(24.800 AS Numeric(7, 3)), CAST(1.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(223 AS Numeric(4, 0)), CAST(24.810 AS Numeric(7, 3)), CAST(1.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(224 AS Numeric(4, 0)), CAST(24.820 AS Numeric(7, 3)), CAST(1.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(225 AS Numeric(4, 0)), CAST(24.830 AS Numeric(7, 3)), CAST(1.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(226 AS Numeric(4, 0)), CAST(24.840 AS Numeric(7, 3)), CAST(1.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(227 AS Numeric(4, 0)), CAST(24.850 AS Numeric(7, 3)), CAST(2.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(228 AS Numeric(4, 0)), CAST(24.860 AS Numeric(7, 3)), CAST(2.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(229 AS Numeric(4, 0)), CAST(24.870 AS Numeric(7, 3)), CAST(2.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(230 AS Numeric(4, 0)), CAST(24.880 AS Numeric(7, 3)), CAST(2.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(231 AS Numeric(4, 0)), CAST(24.890 AS Numeric(7, 3)), CAST(2.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(232 AS Numeric(4, 0)), CAST(24.900 AS Numeric(7, 3)), CAST(2.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(233 AS Numeric(4, 0)), CAST(24.910 AS Numeric(7, 3)), CAST(2.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(234 AS Numeric(4, 0)), CAST(24.920 AS Numeric(7, 3)), CAST(2.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(235 AS Numeric(4, 0)), CAST(24.930 AS Numeric(7, 3)), CAST(2.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(236 AS Numeric(4, 0)), CAST(24.940 AS Numeric(7, 3)), CAST(2.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(237 AS Numeric(4, 0)), CAST(24.950 AS Numeric(7, 3)), CAST(2.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(238 AS Numeric(4, 0)), CAST(24.960 AS Numeric(7, 3)), CAST(2.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(239 AS Numeric(4, 0)), CAST(24.970 AS Numeric(7, 3)), CAST(2.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(240 AS Numeric(4, 0)), CAST(24.980 AS Numeric(7, 3)), CAST(2.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(241 AS Numeric(4, 0)), CAST(24.990 AS Numeric(7, 3)), CAST(2.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(242 AS Numeric(4, 0)), CAST(25.000 AS Numeric(7, 3)), CAST(2.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(243 AS Numeric(4, 0)), CAST(25.010 AS Numeric(7, 3)), CAST(2.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(244 AS Numeric(4, 0)), CAST(25.020 AS Numeric(7, 3)), CAST(2.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(245 AS Numeric(4, 0)), CAST(25.030 AS Numeric(7, 3)), CAST(2.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(246 AS Numeric(4, 0)), CAST(25.040 AS Numeric(7, 3)), CAST(2.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(247 AS Numeric(4, 0)), CAST(25.050 AS Numeric(7, 3)), CAST(2.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(248 AS Numeric(4, 0)), CAST(25.060 AS Numeric(7, 3)), CAST(2.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(249 AS Numeric(4, 0)), CAST(25.070 AS Numeric(7, 3)), CAST(2.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(250 AS Numeric(4, 0)), CAST(25.080 AS Numeric(7, 3)), CAST(2.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(251 AS Numeric(4, 0)), CAST(25.090 AS Numeric(7, 3)), CAST(2.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(252 AS Numeric(4, 0)), CAST(25.100 AS Numeric(7, 3)), CAST(3.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(253 AS Numeric(4, 0)), CAST(25.110 AS Numeric(7, 3)), CAST(3.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(254 AS Numeric(4, 0)), CAST(25.120 AS Numeric(7, 3)), CAST(3.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(255 AS Numeric(4, 0)), CAST(25.130 AS Numeric(7, 3)), CAST(3.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(256 AS Numeric(4, 0)), CAST(25.140 AS Numeric(7, 3)), CAST(3.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(257 AS Numeric(4, 0)), CAST(25.150 AS Numeric(7, 3)), CAST(3.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(258 AS Numeric(4, 0)), CAST(25.160 AS Numeric(7, 3)), CAST(3.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(259 AS Numeric(4, 0)), CAST(25.170 AS Numeric(7, 3)), CAST(3.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(260 AS Numeric(4, 0)), CAST(25.180 AS Numeric(7, 3)), CAST(3.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(261 AS Numeric(4, 0)), CAST(25.190 AS Numeric(7, 3)), CAST(3.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(262 AS Numeric(4, 0)), CAST(25.200 AS Numeric(7, 3)), CAST(3.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(263 AS Numeric(4, 0)), CAST(25.210 AS Numeric(7, 3)), CAST(3.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(264 AS Numeric(4, 0)), CAST(25.220 AS Numeric(7, 3)), CAST(3.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(265 AS Numeric(4, 0)), CAST(25.230 AS Numeric(7, 3)), CAST(3.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(266 AS Numeric(4, 0)), CAST(25.240 AS Numeric(7, 3)), CAST(3.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(267 AS Numeric(4, 0)), CAST(25.250 AS Numeric(7, 3)), CAST(4.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(268 AS Numeric(4, 0)), CAST(25.260 AS Numeric(7, 3)), CAST(4.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(269 AS Numeric(4, 0)), CAST(25.270 AS Numeric(7, 3)), CAST(4.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(270 AS Numeric(4, 0)), CAST(25.280 AS Numeric(7, 3)), CAST(4.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(271 AS Numeric(4, 0)), CAST(25.290 AS Numeric(7, 3)), CAST(4.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(272 AS Numeric(4, 0)), CAST(25.300 AS Numeric(7, 3)), CAST(4.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(273 AS Numeric(4, 0)), CAST(25.310 AS Numeric(7, 3)), CAST(4.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(274 AS Numeric(4, 0)), CAST(25.320 AS Numeric(7, 3)), CAST(4.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(275 AS Numeric(4, 0)), CAST(25.330 AS Numeric(7, 3)), CAST(4.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(276 AS Numeric(4, 0)), CAST(25.340 AS Numeric(7, 3)), CAST(4.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(277 AS Numeric(4, 0)), CAST(25.350 AS Numeric(7, 3)), CAST(4.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(278 AS Numeric(4, 0)), CAST(25.360 AS Numeric(7, 3)), CAST(4.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(279 AS Numeric(4, 0)), CAST(25.370 AS Numeric(7, 3)), CAST(4.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(280 AS Numeric(4, 0)), CAST(25.380 AS Numeric(7, 3)), CAST(4.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(281 AS Numeric(4, 0)), CAST(25.390 AS Numeric(7, 3)), CAST(4.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(282 AS Numeric(4, 0)), CAST(25.400 AS Numeric(7, 3)), CAST(4.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(283 AS Numeric(4, 0)), CAST(25.410 AS Numeric(7, 3)), CAST(4.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(284 AS Numeric(4, 0)), CAST(25.420 AS Numeric(7, 3)), CAST(4.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(285 AS Numeric(4, 0)), CAST(25.430 AS Numeric(7, 3)), CAST(4.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(286 AS Numeric(4, 0)), CAST(25.440 AS Numeric(7, 3)), CAST(5.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(287 AS Numeric(4, 0)), CAST(25.450 AS Numeric(7, 3)), CAST(5.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(288 AS Numeric(4, 0)), CAST(25.460 AS Numeric(7, 3)), CAST(5.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(289 AS Numeric(4, 0)), CAST(25.470 AS Numeric(7, 3)), CAST(5.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(290 AS Numeric(4, 0)), CAST(25.480 AS Numeric(7, 3)), CAST(5.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(291 AS Numeric(4, 0)), CAST(25.490 AS Numeric(7, 3)), CAST(6.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(292 AS Numeric(4, 0)), CAST(25.500 AS Numeric(7, 3)), CAST(6.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(293 AS Numeric(4, 0)), CAST(25.510 AS Numeric(7, 3)), CAST(6.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(294 AS Numeric(4, 0)), CAST(25.520 AS Numeric(7, 3)), CAST(6.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(295 AS Numeric(4, 0)), CAST(25.530 AS Numeric(7, 3)), CAST(6.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(296 AS Numeric(4, 0)), CAST(25.540 AS Numeric(7, 3)), CAST(6.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(297 AS Numeric(4, 0)), CAST(25.550 AS Numeric(7, 3)), CAST(6.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(298 AS Numeric(4, 0)), CAST(25.560 AS Numeric(7, 3)), CAST(6.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(299 AS Numeric(4, 0)), CAST(25.570 AS Numeric(7, 3)), CAST(6.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(300 AS Numeric(4, 0)), CAST(25.580 AS Numeric(7, 3)), CAST(6.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(301 AS Numeric(4, 0)), CAST(25.590 AS Numeric(7, 3)), CAST(6.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(302 AS Numeric(4, 0)), CAST(25.600 AS Numeric(7, 3)), CAST(6.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(303 AS Numeric(4, 0)), CAST(25.610 AS Numeric(7, 3)), CAST(6.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(304 AS Numeric(4, 0)), CAST(25.620 AS Numeric(7, 3)), CAST(6.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(305 AS Numeric(4, 0)), CAST(25.630 AS Numeric(7, 3)), CAST(6.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(306 AS Numeric(4, 0)), CAST(25.640 AS Numeric(7, 3)), CAST(6.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(307 AS Numeric(4, 0)), CAST(25.650 AS Numeric(7, 3)), CAST(6.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(308 AS Numeric(4, 0)), CAST(25.660 AS Numeric(7, 3)), CAST(7.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(309 AS Numeric(4, 0)), CAST(25.670 AS Numeric(7, 3)), CAST(7.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(310 AS Numeric(4, 0)), CAST(25.680 AS Numeric(7, 3)), CAST(8.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(311 AS Numeric(4, 0)), CAST(25.690 AS Numeric(7, 3)), CAST(8.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(312 AS Numeric(4, 0)), CAST(25.700 AS Numeric(7, 3)), CAST(8.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(313 AS Numeric(4, 0)), CAST(25.710 AS Numeric(7, 3)), CAST(8.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(314 AS Numeric(4, 0)), CAST(25.720 AS Numeric(7, 3)), CAST(8.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(315 AS Numeric(4, 0)), CAST(25.730 AS Numeric(7, 3)), CAST(8.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(316 AS Numeric(4, 0)), CAST(25.740 AS Numeric(7, 3)), CAST(9.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(317 AS Numeric(4, 0)), CAST(25.750 AS Numeric(7, 3)), CAST(9.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(318 AS Numeric(4, 0)), CAST(25.760 AS Numeric(7, 3)), CAST(9.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(319 AS Numeric(4, 0)), CAST(25.770 AS Numeric(7, 3)), CAST(9.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(320 AS Numeric(4, 0)), CAST(25.780 AS Numeric(7, 3)), CAST(9.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(321 AS Numeric(4, 0)), CAST(25.790 AS Numeric(7, 3)), CAST(10.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(322 AS Numeric(4, 0)), CAST(25.800 AS Numeric(7, 3)), CAST(10.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(323 AS Numeric(4, 0)), CAST(25.810 AS Numeric(7, 3)), CAST(10.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(324 AS Numeric(4, 0)), CAST(25.820 AS Numeric(7, 3)), CAST(10.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(325 AS Numeric(4, 0)), CAST(25.830 AS Numeric(7, 3)), CAST(10.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(326 AS Numeric(4, 0)), CAST(25.840 AS Numeric(7, 3)), CAST(10.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(327 AS Numeric(4, 0)), CAST(25.850 AS Numeric(7, 3)), CAST(11.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(328 AS Numeric(4, 0)), CAST(25.860 AS Numeric(7, 3)), CAST(11.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(329 AS Numeric(4, 0)), CAST(25.870 AS Numeric(7, 3)), CAST(11.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(330 AS Numeric(4, 0)), CAST(25.880 AS Numeric(7, 3)), CAST(11.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(331 AS Numeric(4, 0)), CAST(25.890 AS Numeric(7, 3)), CAST(11.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(332 AS Numeric(4, 0)), CAST(25.900 AS Numeric(7, 3)), CAST(11.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(333 AS Numeric(4, 0)), CAST(25.910 AS Numeric(7, 3)), CAST(12.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(334 AS Numeric(4, 0)), CAST(25.920 AS Numeric(7, 3)), CAST(12.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(335 AS Numeric(4, 0)), CAST(25.930 AS Numeric(7, 3)), CAST(12.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(336 AS Numeric(4, 0)), CAST(25.940 AS Numeric(7, 3)), CAST(12.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(337 AS Numeric(4, 0)), CAST(25.950 AS Numeric(7, 3)), CAST(12.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(338 AS Numeric(4, 0)), CAST(25.960 AS Numeric(7, 3)), CAST(13.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(339 AS Numeric(4, 0)), CAST(25.970 AS Numeric(7, 3)), CAST(13.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(340 AS Numeric(4, 0)), CAST(25.980 AS Numeric(7, 3)), CAST(13.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(341 AS Numeric(4, 0)), CAST(25.990 AS Numeric(7, 3)), CAST(13.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(342 AS Numeric(4, 0)), CAST(26.000 AS Numeric(7, 3)), CAST(13.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(343 AS Numeric(4, 0)), CAST(26.010 AS Numeric(7, 3)), CAST(14.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(344 AS Numeric(4, 0)), CAST(26.020 AS Numeric(7, 3)), CAST(14.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(345 AS Numeric(4, 0)), CAST(26.030 AS Numeric(7, 3)), CAST(14.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(346 AS Numeric(4, 0)), CAST(26.040 AS Numeric(7, 3)), CAST(14.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(347 AS Numeric(4, 0)), CAST(26.050 AS Numeric(7, 3)), CAST(14.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(348 AS Numeric(4, 0)), CAST(26.060 AS Numeric(7, 3)), CAST(14.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(349 AS Numeric(4, 0)), CAST(26.070 AS Numeric(7, 3)), CAST(14.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(350 AS Numeric(4, 0)), CAST(26.080 AS Numeric(7, 3)), CAST(15.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(351 AS Numeric(4, 0)), CAST(26.090 AS Numeric(7, 3)), CAST(15.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(352 AS Numeric(4, 0)), CAST(26.100 AS Numeric(7, 3)), CAST(15.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(353 AS Numeric(4, 0)), CAST(26.110 AS Numeric(7, 3)), CAST(15.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(354 AS Numeric(4, 0)), CAST(26.120 AS Numeric(7, 3)), CAST(15.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(355 AS Numeric(4, 0)), CAST(26.130 AS Numeric(7, 3)), CAST(15.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(356 AS Numeric(4, 0)), CAST(26.140 AS Numeric(7, 3)), CAST(15.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(357 AS Numeric(4, 0)), CAST(26.150 AS Numeric(7, 3)), CAST(16.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(358 AS Numeric(4, 0)), CAST(26.160 AS Numeric(7, 3)), CAST(16.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(359 AS Numeric(4, 0)), CAST(26.170 AS Numeric(7, 3)), CAST(16.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(360 AS Numeric(4, 0)), CAST(26.180 AS Numeric(7, 3)), CAST(16.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(361 AS Numeric(4, 0)), CAST(26.190 AS Numeric(7, 3)), CAST(16.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(362 AS Numeric(4, 0)), CAST(26.200 AS Numeric(7, 3)), CAST(16.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(363 AS Numeric(4, 0)), CAST(26.210 AS Numeric(7, 3)), CAST(16.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(364 AS Numeric(4, 0)), CAST(26.220 AS Numeric(7, 3)), CAST(16.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(365 AS Numeric(4, 0)), CAST(26.230 AS Numeric(7, 3)), CAST(17.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(366 AS Numeric(4, 0)), CAST(26.240 AS Numeric(7, 3)), CAST(17.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(367 AS Numeric(4, 0)), CAST(26.250 AS Numeric(7, 3)), CAST(17.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(368 AS Numeric(4, 0)), CAST(26.260 AS Numeric(7, 3)), CAST(17.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(369 AS Numeric(4, 0)), CAST(26.270 AS Numeric(7, 3)), CAST(17.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(370 AS Numeric(4, 0)), CAST(26.280 AS Numeric(7, 3)), CAST(17.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(371 AS Numeric(4, 0)), CAST(26.290 AS Numeric(7, 3)), CAST(17.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(372 AS Numeric(4, 0)), CAST(26.300 AS Numeric(7, 3)), CAST(17.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(373 AS Numeric(4, 0)), CAST(26.310 AS Numeric(7, 3)), CAST(17.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(374 AS Numeric(4, 0)), CAST(26.320 AS Numeric(7, 3)), CAST(18.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(375 AS Numeric(4, 0)), CAST(26.330 AS Numeric(7, 3)), CAST(18.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(376 AS Numeric(4, 0)), CAST(26.340 AS Numeric(7, 3)), CAST(18.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(377 AS Numeric(4, 0)), CAST(26.350 AS Numeric(7, 3)), CAST(18.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(378 AS Numeric(4, 0)), CAST(26.360 AS Numeric(7, 3)), CAST(18.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(379 AS Numeric(4, 0)), CAST(26.370 AS Numeric(7, 3)), CAST(18.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(380 AS Numeric(4, 0)), CAST(26.380 AS Numeric(7, 3)), CAST(19.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(381 AS Numeric(4, 0)), CAST(26.390 AS Numeric(7, 3)), CAST(19.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(382 AS Numeric(4, 0)), CAST(26.400 AS Numeric(7, 3)), CAST(19.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(383 AS Numeric(4, 0)), CAST(26.410 AS Numeric(7, 3)), CAST(19.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(384 AS Numeric(4, 0)), CAST(26.420 AS Numeric(7, 3)), CAST(19.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(385 AS Numeric(4, 0)), CAST(26.430 AS Numeric(7, 3)), CAST(19.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(386 AS Numeric(4, 0)), CAST(26.440 AS Numeric(7, 3)), CAST(19.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(387 AS Numeric(4, 0)), CAST(26.450 AS Numeric(7, 3)), CAST(19.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(388 AS Numeric(4, 0)), CAST(26.460 AS Numeric(7, 3)), CAST(20.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(389 AS Numeric(4, 0)), CAST(26.470 AS Numeric(7, 3)), CAST(20.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(390 AS Numeric(4, 0)), CAST(26.480 AS Numeric(7, 3)), CAST(20.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(391 AS Numeric(4, 0)), CAST(26.490 AS Numeric(7, 3)), CAST(20.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(392 AS Numeric(4, 0)), CAST(26.500 AS Numeric(7, 3)), CAST(20.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(393 AS Numeric(4, 0)), CAST(26.510 AS Numeric(7, 3)), CAST(20.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(394 AS Numeric(4, 0)), CAST(26.520 AS Numeric(7, 3)), CAST(20.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(395 AS Numeric(4, 0)), CAST(26.530 AS Numeric(7, 3)), CAST(20.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(396 AS Numeric(4, 0)), CAST(26.540 AS Numeric(7, 3)), CAST(20.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(397 AS Numeric(4, 0)), CAST(26.550 AS Numeric(7, 3)), CAST(21.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(398 AS Numeric(4, 0)), CAST(26.560 AS Numeric(7, 3)), CAST(21.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(399 AS Numeric(4, 0)), CAST(26.570 AS Numeric(7, 3)), CAST(21.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(400 AS Numeric(4, 0)), CAST(26.580 AS Numeric(7, 3)), CAST(21.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(401 AS Numeric(4, 0)), CAST(26.590 AS Numeric(7, 3)), CAST(21.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(402 AS Numeric(4, 0)), CAST(26.600 AS Numeric(7, 3)), CAST(21.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(403 AS Numeric(4, 0)), CAST(26.610 AS Numeric(7, 3)), CAST(21.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(404 AS Numeric(4, 0)), CAST(26.620 AS Numeric(7, 3)), CAST(21.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(405 AS Numeric(4, 0)), CAST(26.630 AS Numeric(7, 3)), CAST(21.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(406 AS Numeric(4, 0)), CAST(26.640 AS Numeric(7, 3)), CAST(21.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(407 AS Numeric(4, 0)), CAST(26.650 AS Numeric(7, 3)), CAST(22.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(408 AS Numeric(4, 0)), CAST(26.660 AS Numeric(7, 3)), CAST(22.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(409 AS Numeric(4, 0)), CAST(26.670 AS Numeric(7, 3)), CAST(22.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(410 AS Numeric(4, 0)), CAST(26.680 AS Numeric(7, 3)), CAST(22.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(411 AS Numeric(4, 0)), CAST(26.690 AS Numeric(7, 3)), CAST(23.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(412 AS Numeric(4, 0)), CAST(26.700 AS Numeric(7, 3)), CAST(23.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(413 AS Numeric(4, 0)), CAST(26.710 AS Numeric(7, 3)), CAST(23.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(414 AS Numeric(4, 0)), CAST(26.720 AS Numeric(7, 3)), CAST(24.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(415 AS Numeric(4, 0)), CAST(26.730 AS Numeric(7, 3)), CAST(24.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(416 AS Numeric(4, 0)), CAST(26.740 AS Numeric(7, 3)), CAST(24.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(417 AS Numeric(4, 0)), CAST(26.750 AS Numeric(7, 3)), CAST(24.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(418 AS Numeric(4, 0)), CAST(26.760 AS Numeric(7, 3)), CAST(25.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(419 AS Numeric(4, 0)), CAST(26.770 AS Numeric(7, 3)), CAST(25.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(420 AS Numeric(4, 0)), CAST(26.780 AS Numeric(7, 3)), CAST(25.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(421 AS Numeric(4, 0)), CAST(26.790 AS Numeric(7, 3)), CAST(26.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(422 AS Numeric(4, 0)), CAST(26.800 AS Numeric(7, 3)), CAST(26.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(423 AS Numeric(4, 0)), CAST(26.810 AS Numeric(7, 3)), CAST(26.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(424 AS Numeric(4, 0)), CAST(26.820 AS Numeric(7, 3)), CAST(27.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(425 AS Numeric(4, 0)), CAST(26.830 AS Numeric(7, 3)), CAST(27.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(426 AS Numeric(4, 0)), CAST(26.840 AS Numeric(7, 3)), CAST(27.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(427 AS Numeric(4, 0)), CAST(26.850 AS Numeric(7, 3)), CAST(27.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(428 AS Numeric(4, 0)), CAST(26.860 AS Numeric(7, 3)), CAST(28.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(429 AS Numeric(4, 0)), CAST(26.870 AS Numeric(7, 3)), CAST(28.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(430 AS Numeric(4, 0)), CAST(26.880 AS Numeric(7, 3)), CAST(28.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(431 AS Numeric(4, 0)), CAST(26.890 AS Numeric(7, 3)), CAST(29.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(432 AS Numeric(4, 0)), CAST(26.900 AS Numeric(7, 3)), CAST(29.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(433 AS Numeric(4, 0)), CAST(26.910 AS Numeric(7, 3)), CAST(29.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(434 AS Numeric(4, 0)), CAST(26.920 AS Numeric(7, 3)), CAST(29.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(435 AS Numeric(4, 0)), CAST(26.930 AS Numeric(7, 3)), CAST(30.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(436 AS Numeric(4, 0)), CAST(26.940 AS Numeric(7, 3)), CAST(30.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(437 AS Numeric(4, 0)), CAST(26.950 AS Numeric(7, 3)), CAST(30.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(438 AS Numeric(4, 0)), CAST(26.960 AS Numeric(7, 3)), CAST(30.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(439 AS Numeric(4, 0)), CAST(26.970 AS Numeric(7, 3)), CAST(31.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(440 AS Numeric(4, 0)), CAST(26.980 AS Numeric(7, 3)), CAST(31.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(441 AS Numeric(4, 0)), CAST(26.990 AS Numeric(7, 3)), CAST(31.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(442 AS Numeric(4, 0)), CAST(27.000 AS Numeric(7, 3)), CAST(31.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(443 AS Numeric(4, 0)), CAST(27.010 AS Numeric(7, 3)), CAST(32.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(444 AS Numeric(4, 0)), CAST(27.020 AS Numeric(7, 3)), CAST(32.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(445 AS Numeric(4, 0)), CAST(27.030 AS Numeric(7, 3)), CAST(32.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(446 AS Numeric(4, 0)), CAST(27.040 AS Numeric(7, 3)), CAST(32.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(447 AS Numeric(4, 0)), CAST(27.050 AS Numeric(7, 3)), CAST(33.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(448 AS Numeric(4, 0)), CAST(27.060 AS Numeric(7, 3)), CAST(33.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(449 AS Numeric(4, 0)), CAST(27.070 AS Numeric(7, 3)), CAST(33.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(450 AS Numeric(4, 0)), CAST(27.080 AS Numeric(7, 3)), CAST(33.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(451 AS Numeric(4, 0)), CAST(27.090 AS Numeric(7, 3)), CAST(34.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(452 AS Numeric(4, 0)), CAST(27.100 AS Numeric(7, 3)), CAST(34.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(453 AS Numeric(4, 0)), CAST(27.110 AS Numeric(7, 3)), CAST(35.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(454 AS Numeric(4, 0)), CAST(27.120 AS Numeric(7, 3)), CAST(35.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(455 AS Numeric(4, 0)), CAST(27.130 AS Numeric(7, 3)), CAST(36.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(456 AS Numeric(4, 0)), CAST(27.140 AS Numeric(7, 3)), CAST(36.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(457 AS Numeric(4, 0)), CAST(27.150 AS Numeric(7, 3)), CAST(37.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(458 AS Numeric(4, 0)), CAST(27.160 AS Numeric(7, 3)), CAST(37.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(459 AS Numeric(4, 0)), CAST(27.170 AS Numeric(7, 3)), CAST(38.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(460 AS Numeric(4, 0)), CAST(27.180 AS Numeric(7, 3)), CAST(38.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(461 AS Numeric(4, 0)), CAST(27.190 AS Numeric(7, 3)), CAST(39.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(462 AS Numeric(4, 0)), CAST(27.200 AS Numeric(7, 3)), CAST(39.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(463 AS Numeric(4, 0)), CAST(27.210 AS Numeric(7, 3)), CAST(40.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(464 AS Numeric(4, 0)), CAST(27.220 AS Numeric(7, 3)), CAST(40.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(465 AS Numeric(4, 0)), CAST(27.230 AS Numeric(7, 3)), CAST(41.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(466 AS Numeric(4, 0)), CAST(27.240 AS Numeric(7, 3)), CAST(41.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(467 AS Numeric(4, 0)), CAST(27.250 AS Numeric(7, 3)), CAST(42.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(468 AS Numeric(4, 0)), CAST(27.260 AS Numeric(7, 3)), CAST(42.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(469 AS Numeric(4, 0)), CAST(27.270 AS Numeric(7, 3)), CAST(43.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(470 AS Numeric(4, 0)), CAST(27.280 AS Numeric(7, 3)), CAST(43.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(471 AS Numeric(4, 0)), CAST(27.290 AS Numeric(7, 3)), CAST(44.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(472 AS Numeric(4, 0)), CAST(27.300 AS Numeric(7, 3)), CAST(44.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(473 AS Numeric(4, 0)), CAST(27.310 AS Numeric(7, 3)), CAST(45.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(474 AS Numeric(4, 0)), CAST(27.320 AS Numeric(7, 3)), CAST(45.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(475 AS Numeric(4, 0)), CAST(27.330 AS Numeric(7, 3)), CAST(46.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(476 AS Numeric(4, 0)), CAST(27.340 AS Numeric(7, 3)), CAST(46.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(477 AS Numeric(4, 0)), CAST(27.350 AS Numeric(7, 3)), CAST(47.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(478 AS Numeric(4, 0)), CAST(27.360 AS Numeric(7, 3)), CAST(47.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(479 AS Numeric(4, 0)), CAST(27.370 AS Numeric(7, 3)), CAST(48.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(480 AS Numeric(4, 0)), CAST(27.380 AS Numeric(7, 3)), CAST(48.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(481 AS Numeric(4, 0)), CAST(27.390 AS Numeric(7, 3)), CAST(49.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(482 AS Numeric(4, 0)), CAST(27.400 AS Numeric(7, 3)), CAST(49.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(483 AS Numeric(4, 0)), CAST(27.410 AS Numeric(7, 3)), CAST(50.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(484 AS Numeric(4, 0)), CAST(27.420 AS Numeric(7, 3)), CAST(50.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(485 AS Numeric(4, 0)), CAST(27.430 AS Numeric(7, 3)), CAST(51.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(486 AS Numeric(4, 0)), CAST(27.440 AS Numeric(7, 3)), CAST(51.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(487 AS Numeric(4, 0)), CAST(27.450 AS Numeric(7, 3)), CAST(52.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(488 AS Numeric(4, 0)), CAST(27.460 AS Numeric(7, 3)), CAST(52.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(489 AS Numeric(4, 0)), CAST(27.470 AS Numeric(7, 3)), CAST(53.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(490 AS Numeric(4, 0)), CAST(27.480 AS Numeric(7, 3)), CAST(53.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(491 AS Numeric(4, 0)), CAST(27.490 AS Numeric(7, 3)), CAST(54.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(492 AS Numeric(4, 0)), CAST(27.500 AS Numeric(7, 3)), CAST(54.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(493 AS Numeric(4, 0)), CAST(27.510 AS Numeric(7, 3)), CAST(55.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(494 AS Numeric(4, 0)), CAST(27.520 AS Numeric(7, 3)), CAST(55.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(495 AS Numeric(4, 0)), CAST(27.530 AS Numeric(7, 3)), CAST(55.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(496 AS Numeric(4, 0)), CAST(27.540 AS Numeric(7, 3)), CAST(55.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(497 AS Numeric(4, 0)), CAST(27.550 AS Numeric(7, 3)), CAST(56.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(498 AS Numeric(4, 0)), CAST(27.560 AS Numeric(7, 3)), CAST(56.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(499 AS Numeric(4, 0)), CAST(27.570 AS Numeric(7, 3)), CAST(57.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(500 AS Numeric(4, 0)), CAST(27.580 AS Numeric(7, 3)), CAST(57.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(501 AS Numeric(4, 0)), CAST(27.590 AS Numeric(7, 3)), CAST(58.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(502 AS Numeric(4, 0)), CAST(27.600 AS Numeric(7, 3)), CAST(58.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(503 AS Numeric(4, 0)), CAST(27.610 AS Numeric(7, 3)), CAST(59.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(504 AS Numeric(4, 0)), CAST(27.620 AS Numeric(7, 3)), CAST(59.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(505 AS Numeric(4, 0)), CAST(27.630 AS Numeric(7, 3)), CAST(60.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(506 AS Numeric(4, 0)), CAST(27.640 AS Numeric(7, 3)), CAST(60.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(507 AS Numeric(4, 0)), CAST(27.650 AS Numeric(7, 3)), CAST(61.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(508 AS Numeric(4, 0)), CAST(27.660 AS Numeric(7, 3)), CAST(61.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(509 AS Numeric(4, 0)), CAST(27.670 AS Numeric(7, 3)), CAST(62.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(510 AS Numeric(4, 0)), CAST(27.680 AS Numeric(7, 3)), CAST(62.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(511 AS Numeric(4, 0)), CAST(27.690 AS Numeric(7, 3)), CAST(63.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(512 AS Numeric(4, 0)), CAST(27.700 AS Numeric(7, 3)), CAST(63.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(513 AS Numeric(4, 0)), CAST(27.710 AS Numeric(7, 3)), CAST(64.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(514 AS Numeric(4, 0)), CAST(27.720 AS Numeric(7, 3)), CAST(64.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(515 AS Numeric(4, 0)), CAST(27.730 AS Numeric(7, 3)), CAST(65.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(516 AS Numeric(4, 0)), CAST(27.740 AS Numeric(7, 3)), CAST(65.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(517 AS Numeric(4, 0)), CAST(27.750 AS Numeric(7, 3)), CAST(66.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(518 AS Numeric(4, 0)), CAST(27.760 AS Numeric(7, 3)), CAST(66.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(519 AS Numeric(4, 0)), CAST(27.770 AS Numeric(7, 3)), CAST(67.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(520 AS Numeric(4, 0)), CAST(27.780 AS Numeric(7, 3)), CAST(67.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(521 AS Numeric(4, 0)), CAST(27.790 AS Numeric(7, 3)), CAST(68.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(522 AS Numeric(4, 0)), CAST(27.800 AS Numeric(7, 3)), CAST(68.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(523 AS Numeric(4, 0)), CAST(27.810 AS Numeric(7, 3)), CAST(69.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(524 AS Numeric(4, 0)), CAST(27.820 AS Numeric(7, 3)), CAST(69.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(525 AS Numeric(4, 0)), CAST(27.830 AS Numeric(7, 3)), CAST(70.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(526 AS Numeric(4, 0)), CAST(27.840 AS Numeric(7, 3)), CAST(70.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(527 AS Numeric(4, 0)), CAST(27.850 AS Numeric(7, 3)), CAST(71.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(528 AS Numeric(4, 0)), CAST(27.860 AS Numeric(7, 3)), CAST(71.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(529 AS Numeric(4, 0)), CAST(27.870 AS Numeric(7, 3)), CAST(72.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(530 AS Numeric(4, 0)), CAST(27.880 AS Numeric(7, 3)), CAST(72.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(531 AS Numeric(4, 0)), CAST(27.890 AS Numeric(7, 3)), CAST(73.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(532 AS Numeric(4, 0)), CAST(27.900 AS Numeric(7, 3)), CAST(73.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(533 AS Numeric(4, 0)), CAST(27.910 AS Numeric(7, 3)), CAST(74.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(534 AS Numeric(4, 0)), CAST(27.920 AS Numeric(7, 3)), CAST(74.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(535 AS Numeric(4, 0)), CAST(27.930 AS Numeric(7, 3)), CAST(75.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(536 AS Numeric(4, 0)), CAST(27.940 AS Numeric(7, 3)), CAST(75.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(537 AS Numeric(4, 0)), CAST(27.950 AS Numeric(7, 3)), CAST(76.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(538 AS Numeric(4, 0)), CAST(27.960 AS Numeric(7, 3)), CAST(76.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(539 AS Numeric(4, 0)), CAST(27.970 AS Numeric(7, 3)), CAST(77.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(540 AS Numeric(4, 0)), CAST(27.980 AS Numeric(7, 3)), CAST(77.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(541 AS Numeric(4, 0)), CAST(27.990 AS Numeric(7, 3)), CAST(78.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(542 AS Numeric(4, 0)), CAST(28.000 AS Numeric(7, 3)), CAST(78.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(543 AS Numeric(4, 0)), CAST(28.010 AS Numeric(7, 3)), CAST(79.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(544 AS Numeric(4, 0)), CAST(28.020 AS Numeric(7, 3)), CAST(79.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(545 AS Numeric(4, 0)), CAST(28.030 AS Numeric(7, 3)), CAST(80.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(546 AS Numeric(4, 0)), CAST(28.040 AS Numeric(7, 3)), CAST(80.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(547 AS Numeric(4, 0)), CAST(28.050 AS Numeric(7, 3)), CAST(81.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(548 AS Numeric(4, 0)), CAST(28.060 AS Numeric(7, 3)), CAST(81.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(549 AS Numeric(4, 0)), CAST(28.070 AS Numeric(7, 3)), CAST(82.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(550 AS Numeric(4, 0)), CAST(28.080 AS Numeric(7, 3)), CAST(82.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(551 AS Numeric(4, 0)), CAST(28.090 AS Numeric(7, 3)), CAST(83.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(552 AS Numeric(4, 0)), CAST(28.100 AS Numeric(7, 3)), CAST(83.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(553 AS Numeric(4, 0)), CAST(28.110 AS Numeric(7, 3)), CAST(84.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(554 AS Numeric(4, 0)), CAST(28.120 AS Numeric(7, 3)), CAST(84.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(555 AS Numeric(4, 0)), CAST(28.130 AS Numeric(7, 3)), CAST(85.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(556 AS Numeric(4, 0)), CAST(28.140 AS Numeric(7, 3)), CAST(85.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(557 AS Numeric(4, 0)), CAST(28.150 AS Numeric(7, 3)), CAST(86.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(558 AS Numeric(4, 0)), CAST(28.160 AS Numeric(7, 3)), CAST(86.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(559 AS Numeric(4, 0)), CAST(28.170 AS Numeric(7, 3)), CAST(87.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(560 AS Numeric(4, 0)), CAST(28.180 AS Numeric(7, 3)), CAST(87.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(561 AS Numeric(4, 0)), CAST(28.190 AS Numeric(7, 3)), CAST(88.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(562 AS Numeric(4, 0)), CAST(28.200 AS Numeric(7, 3)), CAST(88.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(563 AS Numeric(4, 0)), CAST(28.210 AS Numeric(7, 3)), CAST(89.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(564 AS Numeric(4, 0)), CAST(28.220 AS Numeric(7, 3)), CAST(90.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(565 AS Numeric(4, 0)), CAST(28.230 AS Numeric(7, 3)), CAST(91.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(566 AS Numeric(4, 0)), CAST(28.240 AS Numeric(7, 3)), CAST(91.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(567 AS Numeric(4, 0)), CAST(28.250 AS Numeric(7, 3)), CAST(92.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(568 AS Numeric(4, 0)), CAST(28.260 AS Numeric(7, 3)), CAST(93.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(569 AS Numeric(4, 0)), CAST(28.270 AS Numeric(7, 3)), CAST(94.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(570 AS Numeric(4, 0)), CAST(28.280 AS Numeric(7, 3)), CAST(94.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(571 AS Numeric(4, 0)), CAST(28.290 AS Numeric(7, 3)), CAST(95.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(572 AS Numeric(4, 0)), CAST(28.300 AS Numeric(7, 3)), CAST(96.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(573 AS Numeric(4, 0)), CAST(28.310 AS Numeric(7, 3)), CAST(97.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(574 AS Numeric(4, 0)), CAST(28.320 AS Numeric(7, 3)), CAST(98.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(575 AS Numeric(4, 0)), CAST(28.330 AS Numeric(7, 3)), CAST(99.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(576 AS Numeric(4, 0)), CAST(28.340 AS Numeric(7, 3)), CAST(99.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(577 AS Numeric(4, 0)), CAST(28.350 AS Numeric(7, 3)), CAST(100.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(578 AS Numeric(4, 0)), CAST(28.360 AS Numeric(7, 3)), CAST(101.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(579 AS Numeric(4, 0)), CAST(28.370 AS Numeric(7, 3)), CAST(102.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(580 AS Numeric(4, 0)), CAST(28.380 AS Numeric(7, 3)), CAST(102.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(581 AS Numeric(4, 0)), CAST(28.390 AS Numeric(7, 3)), CAST(103.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(582 AS Numeric(4, 0)), CAST(28.400 AS Numeric(7, 3)), CAST(104.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(583 AS Numeric(4, 0)), CAST(28.410 AS Numeric(7, 3)), CAST(105.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(584 AS Numeric(4, 0)), CAST(28.420 AS Numeric(7, 3)), CAST(105.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(585 AS Numeric(4, 0)), CAST(28.430 AS Numeric(7, 3)), CAST(106.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(586 AS Numeric(4, 0)), CAST(28.440 AS Numeric(7, 3)), CAST(107.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(587 AS Numeric(4, 0)), CAST(28.450 AS Numeric(7, 3)), CAST(108.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(588 AS Numeric(4, 0)), CAST(28.460 AS Numeric(7, 3)), CAST(108.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(589 AS Numeric(4, 0)), CAST(28.470 AS Numeric(7, 3)), CAST(109.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(590 AS Numeric(4, 0)), CAST(28.480 AS Numeric(7, 3)), CAST(110.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(591 AS Numeric(4, 0)), CAST(28.490 AS Numeric(7, 3)), CAST(111.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(592 AS Numeric(4, 0)), CAST(28.500 AS Numeric(7, 3)), CAST(111.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(593 AS Numeric(4, 0)), CAST(28.510 AS Numeric(7, 3)), CAST(112.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(594 AS Numeric(4, 0)), CAST(28.520 AS Numeric(7, 3)), CAST(113.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(595 AS Numeric(4, 0)), CAST(28.530 AS Numeric(7, 3)), CAST(114.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(596 AS Numeric(4, 0)), CAST(28.540 AS Numeric(7, 3)), CAST(114.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(597 AS Numeric(4, 0)), CAST(28.550 AS Numeric(7, 3)), CAST(115.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(598 AS Numeric(4, 0)), CAST(28.560 AS Numeric(7, 3)), CAST(116.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(599 AS Numeric(4, 0)), CAST(28.570 AS Numeric(7, 3)), CAST(117.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(600 AS Numeric(4, 0)), CAST(28.580 AS Numeric(7, 3)), CAST(117.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(601 AS Numeric(4, 0)), CAST(28.590 AS Numeric(7, 3)), CAST(118.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(602 AS Numeric(4, 0)), CAST(28.600 AS Numeric(7, 3)), CAST(119.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(603 AS Numeric(4, 0)), CAST(28.610 AS Numeric(7, 3)), CAST(120.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(604 AS Numeric(4, 0)), CAST(28.620 AS Numeric(7, 3)), CAST(120.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(605 AS Numeric(4, 0)), CAST(28.630 AS Numeric(7, 3)), CAST(121.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(606 AS Numeric(4, 0)), CAST(28.640 AS Numeric(7, 3)), CAST(122.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(607 AS Numeric(4, 0)), CAST(28.650 AS Numeric(7, 3)), CAST(123.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(608 AS Numeric(4, 0)), CAST(28.660 AS Numeric(7, 3)), CAST(123.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(609 AS Numeric(4, 0)), CAST(28.670 AS Numeric(7, 3)), CAST(124.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(610 AS Numeric(4, 0)), CAST(28.680 AS Numeric(7, 3)), CAST(125.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(611 AS Numeric(4, 0)), CAST(28.690 AS Numeric(7, 3)), CAST(126.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(612 AS Numeric(4, 0)), CAST(28.700 AS Numeric(7, 3)), CAST(126.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(613 AS Numeric(4, 0)), CAST(28.710 AS Numeric(7, 3)), CAST(127.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(614 AS Numeric(4, 0)), CAST(28.720 AS Numeric(7, 3)), CAST(128.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(615 AS Numeric(4, 0)), CAST(28.730 AS Numeric(7, 3)), CAST(129.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(616 AS Numeric(4, 0)), CAST(28.740 AS Numeric(7, 3)), CAST(129.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(617 AS Numeric(4, 0)), CAST(28.750 AS Numeric(7, 3)), CAST(130.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(618 AS Numeric(4, 0)), CAST(28.760 AS Numeric(7, 3)), CAST(131.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(619 AS Numeric(4, 0)), CAST(28.770 AS Numeric(7, 3)), CAST(132.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(620 AS Numeric(4, 0)), CAST(28.780 AS Numeric(7, 3)), CAST(132.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(621 AS Numeric(4, 0)), CAST(28.790 AS Numeric(7, 3)), CAST(133.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(622 AS Numeric(4, 0)), CAST(28.800 AS Numeric(7, 3)), CAST(134.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(623 AS Numeric(4, 0)), CAST(28.810 AS Numeric(7, 3)), CAST(135.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(624 AS Numeric(4, 0)), CAST(28.820 AS Numeric(7, 3)), CAST(135.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(625 AS Numeric(4, 0)), CAST(28.830 AS Numeric(7, 3)), CAST(136.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(626 AS Numeric(4, 0)), CAST(28.840 AS Numeric(7, 3)), CAST(137.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(627 AS Numeric(4, 0)), CAST(28.850 AS Numeric(7, 3)), CAST(138.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(628 AS Numeric(4, 0)), CAST(28.860 AS Numeric(7, 3)), CAST(138.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(629 AS Numeric(4, 0)), CAST(28.870 AS Numeric(7, 3)), CAST(139.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(630 AS Numeric(4, 0)), CAST(28.880 AS Numeric(7, 3)), CAST(140.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(631 AS Numeric(4, 0)), CAST(28.890 AS Numeric(7, 3)), CAST(141.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(632 AS Numeric(4, 0)), CAST(28.900 AS Numeric(7, 3)), CAST(141.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(633 AS Numeric(4, 0)), CAST(28.910 AS Numeric(7, 3)), CAST(142.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(634 AS Numeric(4, 0)), CAST(28.920 AS Numeric(7, 3)), CAST(143.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(635 AS Numeric(4, 0)), CAST(28.930 AS Numeric(7, 3)), CAST(144.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(636 AS Numeric(4, 0)), CAST(28.940 AS Numeric(7, 3)), CAST(144.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(637 AS Numeric(4, 0)), CAST(28.950 AS Numeric(7, 3)), CAST(145.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(638 AS Numeric(4, 0)), CAST(28.960 AS Numeric(7, 3)), CAST(146.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(639 AS Numeric(4, 0)), CAST(28.970 AS Numeric(7, 3)), CAST(147.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(640 AS Numeric(4, 0)), CAST(28.980 AS Numeric(7, 3)), CAST(147.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(641 AS Numeric(4, 0)), CAST(28.990 AS Numeric(7, 3)), CAST(148.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(642 AS Numeric(4, 0)), CAST(29.000 AS Numeric(7, 3)), CAST(149.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(643 AS Numeric(4, 0)), CAST(29.010 AS Numeric(7, 3)), CAST(150.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(644 AS Numeric(4, 0)), CAST(29.020 AS Numeric(7, 3)), CAST(150.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(645 AS Numeric(4, 0)), CAST(29.030 AS Numeric(7, 3)), CAST(151.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(646 AS Numeric(4, 0)), CAST(29.040 AS Numeric(7, 3)), CAST(152.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(647 AS Numeric(4, 0)), CAST(29.050 AS Numeric(7, 3)), CAST(153.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(648 AS Numeric(4, 0)), CAST(29.060 AS Numeric(7, 3)), CAST(153.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(649 AS Numeric(4, 0)), CAST(29.070 AS Numeric(7, 3)), CAST(154.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(650 AS Numeric(4, 0)), CAST(29.080 AS Numeric(7, 3)), CAST(155.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(651 AS Numeric(4, 0)), CAST(29.090 AS Numeric(7, 3)), CAST(156.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(652 AS Numeric(4, 0)), CAST(29.100 AS Numeric(7, 3)), CAST(156.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(653 AS Numeric(4, 0)), CAST(29.110 AS Numeric(7, 3)), CAST(157.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(654 AS Numeric(4, 0)), CAST(29.120 AS Numeric(7, 3)), CAST(158.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(655 AS Numeric(4, 0)), CAST(29.130 AS Numeric(7, 3)), CAST(159.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(656 AS Numeric(4, 0)), CAST(29.140 AS Numeric(7, 3)), CAST(159.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(657 AS Numeric(4, 0)), CAST(29.150 AS Numeric(7, 3)), CAST(160.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(658 AS Numeric(4, 0)), CAST(29.160 AS Numeric(7, 3)), CAST(161.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(659 AS Numeric(4, 0)), CAST(29.170 AS Numeric(7, 3)), CAST(162.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(660 AS Numeric(4, 0)), CAST(29.180 AS Numeric(7, 3)), CAST(162.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(661 AS Numeric(4, 0)), CAST(29.190 AS Numeric(7, 3)), CAST(163.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(662 AS Numeric(4, 0)), CAST(29.200 AS Numeric(7, 3)), CAST(164.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(663 AS Numeric(4, 0)), CAST(29.210 AS Numeric(7, 3)), CAST(165.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(664 AS Numeric(4, 0)), CAST(29.220 AS Numeric(7, 3)), CAST(165.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(665 AS Numeric(4, 0)), CAST(29.230 AS Numeric(7, 3)), CAST(166.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(666 AS Numeric(4, 0)), CAST(29.240 AS Numeric(7, 3)), CAST(167.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(667 AS Numeric(4, 0)), CAST(29.250 AS Numeric(7, 3)), CAST(168.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(668 AS Numeric(4, 0)), CAST(29.260 AS Numeric(7, 3)), CAST(169.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(669 AS Numeric(4, 0)), CAST(29.270 AS Numeric(7, 3)), CAST(170.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(670 AS Numeric(4, 0)), CAST(29.280 AS Numeric(7, 3)), CAST(171.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(671 AS Numeric(4, 0)), CAST(29.290 AS Numeric(7, 3)), CAST(172.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(672 AS Numeric(4, 0)), CAST(29.300 AS Numeric(7, 3)), CAST(173.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(673 AS Numeric(4, 0)), CAST(29.310 AS Numeric(7, 3)), CAST(174.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(674 AS Numeric(4, 0)), CAST(29.320 AS Numeric(7, 3)), CAST(175.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(675 AS Numeric(4, 0)), CAST(29.330 AS Numeric(7, 3)), CAST(176.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(676 AS Numeric(4, 0)), CAST(29.340 AS Numeric(7, 3)), CAST(177.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(677 AS Numeric(4, 0)), CAST(29.350 AS Numeric(7, 3)), CAST(178.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(678 AS Numeric(4, 0)), CAST(29.360 AS Numeric(7, 3)), CAST(179.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(679 AS Numeric(4, 0)), CAST(29.370 AS Numeric(7, 3)), CAST(180.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(680 AS Numeric(4, 0)), CAST(29.380 AS Numeric(7, 3)), CAST(181.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(681 AS Numeric(4, 0)), CAST(29.390 AS Numeric(7, 3)), CAST(182.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(682 AS Numeric(4, 0)), CAST(29.400 AS Numeric(7, 3)), CAST(183.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(683 AS Numeric(4, 0)), CAST(29.410 AS Numeric(7, 3)), CAST(184.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(684 AS Numeric(4, 0)), CAST(29.420 AS Numeric(7, 3)), CAST(185.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(685 AS Numeric(4, 0)), CAST(29.430 AS Numeric(7, 3)), CAST(186.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(686 AS Numeric(4, 0)), CAST(29.440 AS Numeric(7, 3)), CAST(187.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(687 AS Numeric(4, 0)), CAST(29.450 AS Numeric(7, 3)), CAST(188.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(688 AS Numeric(4, 0)), CAST(29.460 AS Numeric(7, 3)), CAST(189.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(689 AS Numeric(4, 0)), CAST(29.470 AS Numeric(7, 3)), CAST(190.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(690 AS Numeric(4, 0)), CAST(29.480 AS Numeric(7, 3)), CAST(191.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(691 AS Numeric(4, 0)), CAST(29.490 AS Numeric(7, 3)), CAST(192.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(692 AS Numeric(4, 0)), CAST(29.500 AS Numeric(7, 3)), CAST(193.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(693 AS Numeric(4, 0)), CAST(29.510 AS Numeric(7, 3)), CAST(194.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(694 AS Numeric(4, 0)), CAST(29.520 AS Numeric(7, 3)), CAST(195.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(695 AS Numeric(4, 0)), CAST(29.530 AS Numeric(7, 3)), CAST(196.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(696 AS Numeric(4, 0)), CAST(29.540 AS Numeric(7, 3)), CAST(197.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(697 AS Numeric(4, 0)), CAST(29.550 AS Numeric(7, 3)), CAST(198.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(698 AS Numeric(4, 0)), CAST(29.560 AS Numeric(7, 3)), CAST(199.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(699 AS Numeric(4, 0)), CAST(29.570 AS Numeric(7, 3)), CAST(200.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(700 AS Numeric(4, 0)), CAST(29.580 AS Numeric(7, 3)), CAST(201.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(701 AS Numeric(4, 0)), CAST(29.590 AS Numeric(7, 3)), CAST(202.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(702 AS Numeric(4, 0)), CAST(29.600 AS Numeric(7, 3)), CAST(203.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(703 AS Numeric(4, 0)), CAST(29.610 AS Numeric(7, 3)), CAST(204.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(704 AS Numeric(4, 0)), CAST(29.620 AS Numeric(7, 3)), CAST(205.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(705 AS Numeric(4, 0)), CAST(29.630 AS Numeric(7, 3)), CAST(206.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(706 AS Numeric(4, 0)), CAST(29.640 AS Numeric(7, 3)), CAST(207.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(707 AS Numeric(4, 0)), CAST(29.650 AS Numeric(7, 3)), CAST(208.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(708 AS Numeric(4, 0)), CAST(29.660 AS Numeric(7, 3)), CAST(209.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(709 AS Numeric(4, 0)), CAST(29.670 AS Numeric(7, 3)), CAST(210.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(710 AS Numeric(4, 0)), CAST(29.680 AS Numeric(7, 3)), CAST(211.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(711 AS Numeric(4, 0)), CAST(29.690 AS Numeric(7, 3)), CAST(212.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(712 AS Numeric(4, 0)), CAST(29.700 AS Numeric(7, 3)), CAST(213.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(713 AS Numeric(4, 0)), CAST(29.710 AS Numeric(7, 3)), CAST(214.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(714 AS Numeric(4, 0)), CAST(29.720 AS Numeric(7, 3)), CAST(215.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(715 AS Numeric(4, 0)), CAST(29.730 AS Numeric(7, 3)), CAST(216.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(716 AS Numeric(4, 0)), CAST(29.740 AS Numeric(7, 3)), CAST(217.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(717 AS Numeric(4, 0)), CAST(29.750 AS Numeric(7, 3)), CAST(218.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(718 AS Numeric(4, 0)), CAST(29.760 AS Numeric(7, 3)), CAST(219.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(719 AS Numeric(4, 0)), CAST(29.770 AS Numeric(7, 3)), CAST(220.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(720 AS Numeric(4, 0)), CAST(29.780 AS Numeric(7, 3)), CAST(221.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(721 AS Numeric(4, 0)), CAST(29.790 AS Numeric(7, 3)), CAST(222.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(722 AS Numeric(4, 0)), CAST(29.800 AS Numeric(7, 3)), CAST(223.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(723 AS Numeric(4, 0)), CAST(29.810 AS Numeric(7, 3)), CAST(224.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(724 AS Numeric(4, 0)), CAST(29.820 AS Numeric(7, 3)), CAST(225.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(725 AS Numeric(4, 0)), CAST(29.830 AS Numeric(7, 3)), CAST(226.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(726 AS Numeric(4, 0)), CAST(29.840 AS Numeric(7, 3)), CAST(227.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(727 AS Numeric(4, 0)), CAST(29.850 AS Numeric(7, 3)), CAST(228.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(728 AS Numeric(4, 0)), CAST(29.860 AS Numeric(7, 3)), CAST(229.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(729 AS Numeric(4, 0)), CAST(29.870 AS Numeric(7, 3)), CAST(230.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(730 AS Numeric(4, 0)), CAST(29.880 AS Numeric(7, 3)), CAST(231.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(731 AS Numeric(4, 0)), CAST(29.890 AS Numeric(7, 3)), CAST(232.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(732 AS Numeric(4, 0)), CAST(29.900 AS Numeric(7, 3)), CAST(233.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(733 AS Numeric(4, 0)), CAST(29.910 AS Numeric(7, 3)), CAST(234.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(734 AS Numeric(4, 0)), CAST(29.920 AS Numeric(7, 3)), CAST(235.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(735 AS Numeric(4, 0)), CAST(29.930 AS Numeric(7, 3)), CAST(236.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(736 AS Numeric(4, 0)), CAST(29.940 AS Numeric(7, 3)), CAST(237.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(737 AS Numeric(4, 0)), CAST(29.950 AS Numeric(7, 3)), CAST(238.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(738 AS Numeric(4, 0)), CAST(29.960 AS Numeric(7, 3)), CAST(239.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(739 AS Numeric(4, 0)), CAST(29.970 AS Numeric(7, 3)), CAST(240.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(740 AS Numeric(4, 0)), CAST(29.980 AS Numeric(7, 3)), CAST(241.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(741 AS Numeric(4, 0)), CAST(29.990 AS Numeric(7, 3)), CAST(242.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(742 AS Numeric(4, 0)), CAST(30.000 AS Numeric(7, 3)), CAST(243.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(743 AS Numeric(4, 0)), CAST(30.010 AS Numeric(7, 3)), CAST(244.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(744 AS Numeric(4, 0)), CAST(30.020 AS Numeric(7, 3)), CAST(245.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(745 AS Numeric(4, 0)), CAST(30.030 AS Numeric(7, 3)), CAST(246.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(746 AS Numeric(4, 0)), CAST(30.040 AS Numeric(7, 3)), CAST(247.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(747 AS Numeric(4, 0)), CAST(30.050 AS Numeric(7, 3)), CAST(248.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(748 AS Numeric(4, 0)), CAST(30.060 AS Numeric(7, 3)), CAST(249.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(749 AS Numeric(4, 0)), CAST(30.070 AS Numeric(7, 3)), CAST(250.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(750 AS Numeric(4, 0)), CAST(30.080 AS Numeric(7, 3)), CAST(251.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(751 AS Numeric(4, 0)), CAST(30.090 AS Numeric(7, 3)), CAST(252.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(752 AS Numeric(4, 0)), CAST(30.100 AS Numeric(7, 3)), CAST(253.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(753 AS Numeric(4, 0)), CAST(30.110 AS Numeric(7, 3)), CAST(254.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(754 AS Numeric(4, 0)), CAST(30.120 AS Numeric(7, 3)), CAST(255.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(755 AS Numeric(4, 0)), CAST(30.130 AS Numeric(7, 3)), CAST(256.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(756 AS Numeric(4, 0)), CAST(30.140 AS Numeric(7, 3)), CAST(257.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(757 AS Numeric(4, 0)), CAST(30.150 AS Numeric(7, 3)), CAST(258.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(758 AS Numeric(4, 0)), CAST(30.160 AS Numeric(7, 3)), CAST(259.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(759 AS Numeric(4, 0)), CAST(30.170 AS Numeric(7, 3)), CAST(260.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(760 AS Numeric(4, 0)), CAST(30.180 AS Numeric(7, 3)), CAST(261.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(761 AS Numeric(4, 0)), CAST(30.190 AS Numeric(7, 3)), CAST(262.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(762 AS Numeric(4, 0)), CAST(30.200 AS Numeric(7, 3)), CAST(263.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(763 AS Numeric(4, 0)), CAST(30.210 AS Numeric(7, 3)), CAST(264.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(764 AS Numeric(4, 0)), CAST(30.220 AS Numeric(7, 3)), CAST(265.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(765 AS Numeric(4, 0)), CAST(30.230 AS Numeric(7, 3)), CAST(267.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(766 AS Numeric(4, 0)), CAST(30.240 AS Numeric(7, 3)), CAST(268.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(767 AS Numeric(4, 0)), CAST(30.250 AS Numeric(7, 3)), CAST(269.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(768 AS Numeric(4, 0)), CAST(30.260 AS Numeric(7, 3)), CAST(270.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(769 AS Numeric(4, 0)), CAST(30.270 AS Numeric(7, 3)), CAST(272.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(770 AS Numeric(4, 0)), CAST(30.280 AS Numeric(7, 3)), CAST(273.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(771 AS Numeric(4, 0)), CAST(30.290 AS Numeric(7, 3)), CAST(274.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(772 AS Numeric(4, 0)), CAST(30.300 AS Numeric(7, 3)), CAST(275.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(773 AS Numeric(4, 0)), CAST(30.310 AS Numeric(7, 3)), CAST(277.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(774 AS Numeric(4, 0)), CAST(30.320 AS Numeric(7, 3)), CAST(278.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(775 AS Numeric(4, 0)), CAST(30.330 AS Numeric(7, 3)), CAST(279.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(776 AS Numeric(4, 0)), CAST(30.340 AS Numeric(7, 3)), CAST(280.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(777 AS Numeric(4, 0)), CAST(30.350 AS Numeric(7, 3)), CAST(282.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(778 AS Numeric(4, 0)), CAST(30.360 AS Numeric(7, 3)), CAST(283.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(779 AS Numeric(4, 0)), CAST(30.370 AS Numeric(7, 3)), CAST(284.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(780 AS Numeric(4, 0)), CAST(30.380 AS Numeric(7, 3)), CAST(285.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(781 AS Numeric(4, 0)), CAST(30.390 AS Numeric(7, 3)), CAST(287.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(782 AS Numeric(4, 0)), CAST(30.400 AS Numeric(7, 3)), CAST(288.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(783 AS Numeric(4, 0)), CAST(30.410 AS Numeric(7, 3)), CAST(289.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(784 AS Numeric(4, 0)), CAST(30.420 AS Numeric(7, 3)), CAST(290.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(785 AS Numeric(4, 0)), CAST(30.430 AS Numeric(7, 3)), CAST(292.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(786 AS Numeric(4, 0)), CAST(30.440 AS Numeric(7, 3)), CAST(293.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(787 AS Numeric(4, 0)), CAST(30.450 AS Numeric(7, 3)), CAST(294.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(788 AS Numeric(4, 0)), CAST(30.460 AS Numeric(7, 3)), CAST(295.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(789 AS Numeric(4, 0)), CAST(30.470 AS Numeric(7, 3)), CAST(297.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(790 AS Numeric(4, 0)), CAST(30.480 AS Numeric(7, 3)), CAST(298.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(791 AS Numeric(4, 0)), CAST(30.490 AS Numeric(7, 3)), CAST(299.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(792 AS Numeric(4, 0)), CAST(30.500 AS Numeric(7, 3)), CAST(300.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(793 AS Numeric(4, 0)), CAST(30.510 AS Numeric(7, 3)), CAST(302.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(794 AS Numeric(4, 0)), CAST(30.520 AS Numeric(7, 3)), CAST(303.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(795 AS Numeric(4, 0)), CAST(30.530 AS Numeric(7, 3)), CAST(304.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(796 AS Numeric(4, 0)), CAST(30.540 AS Numeric(7, 3)), CAST(305.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(797 AS Numeric(4, 0)), CAST(30.550 AS Numeric(7, 3)), CAST(307.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(798 AS Numeric(4, 0)), CAST(30.560 AS Numeric(7, 3)), CAST(308.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(799 AS Numeric(4, 0)), CAST(30.570 AS Numeric(7, 3)), CAST(309.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(800 AS Numeric(4, 0)), CAST(30.580 AS Numeric(7, 3)), CAST(310.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(801 AS Numeric(4, 0)), CAST(30.590 AS Numeric(7, 3)), CAST(312.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(802 AS Numeric(4, 0)), CAST(30.600 AS Numeric(7, 3)), CAST(313.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(803 AS Numeric(4, 0)), CAST(30.610 AS Numeric(7, 3)), CAST(314.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(804 AS Numeric(4, 0)), CAST(30.620 AS Numeric(7, 3)), CAST(315.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(805 AS Numeric(4, 0)), CAST(30.630 AS Numeric(7, 3)), CAST(317.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(806 AS Numeric(4, 0)), CAST(30.640 AS Numeric(7, 3)), CAST(318.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(807 AS Numeric(4, 0)), CAST(30.650 AS Numeric(7, 3)), CAST(319.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(808 AS Numeric(4, 0)), CAST(30.660 AS Numeric(7, 3)), CAST(320.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(809 AS Numeric(4, 0)), CAST(30.670 AS Numeric(7, 3)), CAST(322.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(810 AS Numeric(4, 0)), CAST(30.680 AS Numeric(7, 3)), CAST(323.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(811 AS Numeric(4, 0)), CAST(30.690 AS Numeric(7, 3)), CAST(324.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(812 AS Numeric(4, 0)), CAST(30.700 AS Numeric(7, 3)), CAST(325.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(813 AS Numeric(4, 0)), CAST(30.710 AS Numeric(7, 3)), CAST(327.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(814 AS Numeric(4, 0)), CAST(30.720 AS Numeric(7, 3)), CAST(328.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(815 AS Numeric(4, 0)), CAST(30.730 AS Numeric(7, 3)), CAST(329.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(816 AS Numeric(4, 0)), CAST(30.740 AS Numeric(7, 3)), CAST(330.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(817 AS Numeric(4, 0)), CAST(30.750 AS Numeric(7, 3)), CAST(332.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(818 AS Numeric(4, 0)), CAST(30.760 AS Numeric(7, 3)), CAST(333.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(819 AS Numeric(4, 0)), CAST(30.770 AS Numeric(7, 3)), CAST(334.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(820 AS Numeric(4, 0)), CAST(30.780 AS Numeric(7, 3)), CAST(335.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(821 AS Numeric(4, 0)), CAST(30.790 AS Numeric(7, 3)), CAST(337.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(822 AS Numeric(4, 0)), CAST(30.800 AS Numeric(7, 3)), CAST(338.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(823 AS Numeric(4, 0)), CAST(30.810 AS Numeric(7, 3)), CAST(339.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(824 AS Numeric(4, 0)), CAST(30.820 AS Numeric(7, 3)), CAST(340.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(825 AS Numeric(4, 0)), CAST(30.830 AS Numeric(7, 3)), CAST(342.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(826 AS Numeric(4, 0)), CAST(30.840 AS Numeric(7, 3)), CAST(343.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(827 AS Numeric(4, 0)), CAST(30.850 AS Numeric(7, 3)), CAST(344.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(828 AS Numeric(4, 0)), CAST(30.860 AS Numeric(7, 3)), CAST(345.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(829 AS Numeric(4, 0)), CAST(30.870 AS Numeric(7, 3)), CAST(347.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(830 AS Numeric(4, 0)), CAST(30.880 AS Numeric(7, 3)), CAST(348.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(831 AS Numeric(4, 0)), CAST(30.890 AS Numeric(7, 3)), CAST(349.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(832 AS Numeric(4, 0)), CAST(30.900 AS Numeric(7, 3)), CAST(350.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(833 AS Numeric(4, 0)), CAST(30.910 AS Numeric(7, 3)), CAST(352.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(834 AS Numeric(4, 0)), CAST(30.920 AS Numeric(7, 3)), CAST(353.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(835 AS Numeric(4, 0)), CAST(30.930 AS Numeric(7, 3)), CAST(354.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(836 AS Numeric(4, 0)), CAST(30.940 AS Numeric(7, 3)), CAST(355.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(837 AS Numeric(4, 0)), CAST(30.950 AS Numeric(7, 3)), CAST(357.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(838 AS Numeric(4, 0)), CAST(30.960 AS Numeric(7, 3)), CAST(358.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(839 AS Numeric(4, 0)), CAST(30.970 AS Numeric(7, 3)), CAST(360.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(840 AS Numeric(4, 0)), CAST(30.980 AS Numeric(7, 3)), CAST(361.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(841 AS Numeric(4, 0)), CAST(30.990 AS Numeric(7, 3)), CAST(363.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(842 AS Numeric(4, 0)), CAST(31.000 AS Numeric(7, 3)), CAST(364.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(843 AS Numeric(4, 0)), CAST(31.010 AS Numeric(7, 3)), CAST(366.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(844 AS Numeric(4, 0)), CAST(31.020 AS Numeric(7, 3)), CAST(367.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(845 AS Numeric(4, 0)), CAST(31.030 AS Numeric(7, 3)), CAST(369.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(846 AS Numeric(4, 0)), CAST(31.040 AS Numeric(7, 3)), CAST(370.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(847 AS Numeric(4, 0)), CAST(31.050 AS Numeric(7, 3)), CAST(372.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(848 AS Numeric(4, 0)), CAST(31.060 AS Numeric(7, 3)), CAST(373.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(849 AS Numeric(4, 0)), CAST(31.070 AS Numeric(7, 3)), CAST(375.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(850 AS Numeric(4, 0)), CAST(31.080 AS Numeric(7, 3)), CAST(376.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(851 AS Numeric(4, 0)), CAST(31.090 AS Numeric(7, 3)), CAST(378.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(852 AS Numeric(4, 0)), CAST(31.100 AS Numeric(7, 3)), CAST(379.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(853 AS Numeric(4, 0)), CAST(31.110 AS Numeric(7, 3)), CAST(381.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(854 AS Numeric(4, 0)), CAST(31.120 AS Numeric(7, 3)), CAST(382.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(855 AS Numeric(4, 0)), CAST(31.130 AS Numeric(7, 3)), CAST(384.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(856 AS Numeric(4, 0)), CAST(31.140 AS Numeric(7, 3)), CAST(385.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(857 AS Numeric(4, 0)), CAST(31.150 AS Numeric(7, 3)), CAST(387.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(858 AS Numeric(4, 0)), CAST(31.160 AS Numeric(7, 3)), CAST(388.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(859 AS Numeric(4, 0)), CAST(31.170 AS Numeric(7, 3)), CAST(390.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(860 AS Numeric(4, 0)), CAST(31.180 AS Numeric(7, 3)), CAST(391.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(861 AS Numeric(4, 0)), CAST(31.190 AS Numeric(7, 3)), CAST(393.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(862 AS Numeric(4, 0)), CAST(31.200 AS Numeric(7, 3)), CAST(394.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(863 AS Numeric(4, 0)), CAST(31.210 AS Numeric(7, 3)), CAST(396.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(864 AS Numeric(4, 0)), CAST(31.220 AS Numeric(7, 3)), CAST(397.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(865 AS Numeric(4, 0)), CAST(31.230 AS Numeric(7, 3)), CAST(399.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(866 AS Numeric(4, 0)), CAST(31.240 AS Numeric(7, 3)), CAST(400.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(867 AS Numeric(4, 0)), CAST(31.250 AS Numeric(7, 3)), CAST(402.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(868 AS Numeric(4, 0)), CAST(31.260 AS Numeric(7, 3)), CAST(403.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(869 AS Numeric(4, 0)), CAST(31.270 AS Numeric(7, 3)), CAST(405.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(870 AS Numeric(4, 0)), CAST(31.280 AS Numeric(7, 3)), CAST(406.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(871 AS Numeric(4, 0)), CAST(31.290 AS Numeric(7, 3)), CAST(408.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(872 AS Numeric(4, 0)), CAST(31.300 AS Numeric(7, 3)), CAST(409.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(873 AS Numeric(4, 0)), CAST(31.310 AS Numeric(7, 3)), CAST(411.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(874 AS Numeric(4, 0)), CAST(31.320 AS Numeric(7, 3)), CAST(412.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(875 AS Numeric(4, 0)), CAST(31.330 AS Numeric(7, 3)), CAST(414.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(876 AS Numeric(4, 0)), CAST(31.340 AS Numeric(7, 3)), CAST(415.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(877 AS Numeric(4, 0)), CAST(31.350 AS Numeric(7, 3)), CAST(417.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(878 AS Numeric(4, 0)), CAST(31.360 AS Numeric(7, 3)), CAST(418.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(879 AS Numeric(4, 0)), CAST(31.370 AS Numeric(7, 3)), CAST(420.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(880 AS Numeric(4, 0)), CAST(31.380 AS Numeric(7, 3)), CAST(421.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(881 AS Numeric(4, 0)), CAST(31.390 AS Numeric(7, 3)), CAST(423.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(882 AS Numeric(4, 0)), CAST(31.400 AS Numeric(7, 3)), CAST(424.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(883 AS Numeric(4, 0)), CAST(31.410 AS Numeric(7, 3)), CAST(426.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(884 AS Numeric(4, 0)), CAST(31.420 AS Numeric(7, 3)), CAST(427.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(885 AS Numeric(4, 0)), CAST(31.430 AS Numeric(7, 3)), CAST(429.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(886 AS Numeric(4, 0)), CAST(31.440 AS Numeric(7, 3)), CAST(430.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(887 AS Numeric(4, 0)), CAST(31.450 AS Numeric(7, 3)), CAST(432.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(888 AS Numeric(4, 0)), CAST(31.460 AS Numeric(7, 3)), CAST(433.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(889 AS Numeric(4, 0)), CAST(31.470 AS Numeric(7, 3)), CAST(435.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(890 AS Numeric(4, 0)), CAST(31.480 AS Numeric(7, 3)), CAST(436.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(891 AS Numeric(4, 0)), CAST(31.490 AS Numeric(7, 3)), CAST(438.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(892 AS Numeric(4, 0)), CAST(31.500 AS Numeric(7, 3)), CAST(439.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(893 AS Numeric(4, 0)), CAST(31.510 AS Numeric(7, 3)), CAST(441.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(894 AS Numeric(4, 0)), CAST(31.520 AS Numeric(7, 3)), CAST(442.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(895 AS Numeric(4, 0)), CAST(31.530 AS Numeric(7, 3)), CAST(444.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(896 AS Numeric(4, 0)), CAST(31.540 AS Numeric(7, 3)), CAST(445.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(897 AS Numeric(4, 0)), CAST(31.550 AS Numeric(7, 3)), CAST(447.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(898 AS Numeric(4, 0)), CAST(31.560 AS Numeric(7, 3)), CAST(448.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(899 AS Numeric(4, 0)), CAST(31.570 AS Numeric(7, 3)), CAST(450.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(900 AS Numeric(4, 0)), CAST(31.580 AS Numeric(7, 3)), CAST(451.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(901 AS Numeric(4, 0)), CAST(31.590 AS Numeric(7, 3)), CAST(453.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(902 AS Numeric(4, 0)), CAST(31.600 AS Numeric(7, 3)), CAST(454.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(903 AS Numeric(4, 0)), CAST(31.610 AS Numeric(7, 3)), CAST(456.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(904 AS Numeric(4, 0)), CAST(31.620 AS Numeric(7, 3)), CAST(457.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(905 AS Numeric(4, 0)), CAST(31.630 AS Numeric(7, 3)), CAST(459.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(906 AS Numeric(4, 0)), CAST(31.640 AS Numeric(7, 3)), CAST(460.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(907 AS Numeric(4, 0)), CAST(31.650 AS Numeric(7, 3)), CAST(462.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(908 AS Numeric(4, 0)), CAST(31.660 AS Numeric(7, 3)), CAST(463.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(909 AS Numeric(4, 0)), CAST(31.670 AS Numeric(7, 3)), CAST(465.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(910 AS Numeric(4, 0)), CAST(31.680 AS Numeric(7, 3)), CAST(466.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(911 AS Numeric(4, 0)), CAST(31.690 AS Numeric(7, 3)), CAST(468.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(912 AS Numeric(4, 0)), CAST(31.700 AS Numeric(7, 3)), CAST(469.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(913 AS Numeric(4, 0)), CAST(31.710 AS Numeric(7, 3)), CAST(471.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(914 AS Numeric(4, 0)), CAST(31.720 AS Numeric(7, 3)), CAST(472.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(915 AS Numeric(4, 0)), CAST(31.730 AS Numeric(7, 3)), CAST(474.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(916 AS Numeric(4, 0)), CAST(31.740 AS Numeric(7, 3)), CAST(475.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(917 AS Numeric(4, 0)), CAST(31.750 AS Numeric(7, 3)), CAST(477.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(918 AS Numeric(4, 0)), CAST(31.760 AS Numeric(7, 3)), CAST(478.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(919 AS Numeric(4, 0)), CAST(31.770 AS Numeric(7, 3)), CAST(480.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(920 AS Numeric(4, 0)), CAST(31.780 AS Numeric(7, 3)), CAST(481.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(921 AS Numeric(4, 0)), CAST(31.790 AS Numeric(7, 3)), CAST(483.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(922 AS Numeric(4, 0)), CAST(31.800 AS Numeric(7, 3)), CAST(484.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(923 AS Numeric(4, 0)), CAST(31.810 AS Numeric(7, 3)), CAST(486.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(924 AS Numeric(4, 0)), CAST(31.820 AS Numeric(7, 3)), CAST(487.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(925 AS Numeric(4, 0)), CAST(31.830 AS Numeric(7, 3)), CAST(489.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(926 AS Numeric(4, 0)), CAST(31.840 AS Numeric(7, 3)), CAST(490.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(927 AS Numeric(4, 0)), CAST(31.850 AS Numeric(7, 3)), CAST(492.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(928 AS Numeric(4, 0)), CAST(31.860 AS Numeric(7, 3)), CAST(493.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(929 AS Numeric(4, 0)), CAST(31.870 AS Numeric(7, 3)), CAST(495.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(930 AS Numeric(4, 0)), CAST(31.880 AS Numeric(7, 3)), CAST(496.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(931 AS Numeric(4, 0)), CAST(31.890 AS Numeric(7, 3)), CAST(498.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(932 AS Numeric(4, 0)), CAST(31.900 AS Numeric(7, 3)), CAST(499.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(933 AS Numeric(4, 0)), CAST(31.910 AS Numeric(7, 3)), CAST(501.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(934 AS Numeric(4, 0)), CAST(31.920 AS Numeric(7, 3)), CAST(502.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(935 AS Numeric(4, 0)), CAST(31.930 AS Numeric(7, 3)), CAST(504.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(936 AS Numeric(4, 0)), CAST(31.940 AS Numeric(7, 3)), CAST(505.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(937 AS Numeric(4, 0)), CAST(31.950 AS Numeric(7, 3)), CAST(507.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(938 AS Numeric(4, 0)), CAST(31.960 AS Numeric(7, 3)), CAST(508.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(939 AS Numeric(4, 0)), CAST(31.970 AS Numeric(7, 3)), CAST(510.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(940 AS Numeric(4, 0)), CAST(31.980 AS Numeric(7, 3)), CAST(512.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(941 AS Numeric(4, 0)), CAST(31.990 AS Numeric(7, 3)), CAST(514.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(942 AS Numeric(4, 0)), CAST(32.000 AS Numeric(7, 3)), CAST(515.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(943 AS Numeric(4, 0)), CAST(32.010 AS Numeric(7, 3)), CAST(517.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(944 AS Numeric(4, 0)), CAST(32.020 AS Numeric(7, 3)), CAST(519.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(945 AS Numeric(4, 0)), CAST(32.030 AS Numeric(7, 3)), CAST(521.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(946 AS Numeric(4, 0)), CAST(32.040 AS Numeric(7, 3)), CAST(522.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(947 AS Numeric(4, 0)), CAST(32.050 AS Numeric(7, 3)), CAST(524.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(948 AS Numeric(4, 0)), CAST(32.060 AS Numeric(7, 3)), CAST(526.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(949 AS Numeric(4, 0)), CAST(32.070 AS Numeric(7, 3)), CAST(528.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(950 AS Numeric(4, 0)), CAST(32.080 AS Numeric(7, 3)), CAST(529.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(951 AS Numeric(4, 0)), CAST(32.090 AS Numeric(7, 3)), CAST(531.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(952 AS Numeric(4, 0)), CAST(32.100 AS Numeric(7, 3)), CAST(533.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(953 AS Numeric(4, 0)), CAST(32.110 AS Numeric(7, 3)), CAST(535.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(954 AS Numeric(4, 0)), CAST(32.120 AS Numeric(7, 3)), CAST(536.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(955 AS Numeric(4, 0)), CAST(32.130 AS Numeric(7, 3)), CAST(538.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(956 AS Numeric(4, 0)), CAST(32.140 AS Numeric(7, 3)), CAST(540.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(957 AS Numeric(4, 0)), CAST(32.150 AS Numeric(7, 3)), CAST(542.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(958 AS Numeric(4, 0)), CAST(32.160 AS Numeric(7, 3)), CAST(543.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(959 AS Numeric(4, 0)), CAST(32.170 AS Numeric(7, 3)), CAST(545.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(960 AS Numeric(4, 0)), CAST(32.180 AS Numeric(7, 3)), CAST(547.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(961 AS Numeric(4, 0)), CAST(32.190 AS Numeric(7, 3)), CAST(549.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(962 AS Numeric(4, 0)), CAST(32.200 AS Numeric(7, 3)), CAST(550.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(963 AS Numeric(4, 0)), CAST(32.210 AS Numeric(7, 3)), CAST(552.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(964 AS Numeric(4, 0)), CAST(32.220 AS Numeric(7, 3)), CAST(554.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(965 AS Numeric(4, 0)), CAST(32.230 AS Numeric(7, 3)), CAST(556.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(966 AS Numeric(4, 0)), CAST(32.240 AS Numeric(7, 3)), CAST(557.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(967 AS Numeric(4, 0)), CAST(32.250 AS Numeric(7, 3)), CAST(559.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(968 AS Numeric(4, 0)), CAST(32.260 AS Numeric(7, 3)), CAST(561.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(969 AS Numeric(4, 0)), CAST(32.270 AS Numeric(7, 3)), CAST(563.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(970 AS Numeric(4, 0)), CAST(32.280 AS Numeric(7, 3)), CAST(564.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(971 AS Numeric(4, 0)), CAST(32.290 AS Numeric(7, 3)), CAST(566.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(972 AS Numeric(4, 0)), CAST(32.300 AS Numeric(7, 3)), CAST(568.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(973 AS Numeric(4, 0)), CAST(32.310 AS Numeric(7, 3)), CAST(570.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(974 AS Numeric(4, 0)), CAST(32.320 AS Numeric(7, 3)), CAST(571.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(975 AS Numeric(4, 0)), CAST(32.330 AS Numeric(7, 3)), CAST(573.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(976 AS Numeric(4, 0)), CAST(32.340 AS Numeric(7, 3)), CAST(575.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(977 AS Numeric(4, 0)), CAST(32.350 AS Numeric(7, 3)), CAST(577.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(978 AS Numeric(4, 0)), CAST(32.360 AS Numeric(7, 3)), CAST(578.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(979 AS Numeric(4, 0)), CAST(32.370 AS Numeric(7, 3)), CAST(580.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(980 AS Numeric(4, 0)), CAST(32.380 AS Numeric(7, 3)), CAST(582.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(981 AS Numeric(4, 0)), CAST(32.390 AS Numeric(7, 3)), CAST(584.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(982 AS Numeric(4, 0)), CAST(32.400 AS Numeric(7, 3)), CAST(585.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(983 AS Numeric(4, 0)), CAST(32.410 AS Numeric(7, 3)), CAST(587.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(984 AS Numeric(4, 0)), CAST(32.420 AS Numeric(7, 3)), CAST(589.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(985 AS Numeric(4, 0)), CAST(32.430 AS Numeric(7, 3)), CAST(591.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(986 AS Numeric(4, 0)), CAST(32.440 AS Numeric(7, 3)), CAST(592.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(987 AS Numeric(4, 0)), CAST(32.450 AS Numeric(7, 3)), CAST(594.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(988 AS Numeric(4, 0)), CAST(32.460 AS Numeric(7, 3)), CAST(596.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(989 AS Numeric(4, 0)), CAST(32.470 AS Numeric(7, 3)), CAST(598.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(990 AS Numeric(4, 0)), CAST(32.480 AS Numeric(7, 3)), CAST(599.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(991 AS Numeric(4, 0)), CAST(32.490 AS Numeric(7, 3)), CAST(601.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(992 AS Numeric(4, 0)), CAST(32.500 AS Numeric(7, 3)), CAST(603.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(993 AS Numeric(4, 0)), CAST(32.510 AS Numeric(7, 3)), CAST(605.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(994 AS Numeric(4, 0)), CAST(32.520 AS Numeric(7, 3)), CAST(606.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(995 AS Numeric(4, 0)), CAST(32.530 AS Numeric(7, 3)), CAST(608.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(996 AS Numeric(4, 0)), CAST(32.540 AS Numeric(7, 3)), CAST(610.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(997 AS Numeric(4, 0)), CAST(32.550 AS Numeric(7, 3)), CAST(612.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(998 AS Numeric(4, 0)), CAST(32.560 AS Numeric(7, 3)), CAST(613.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(999 AS Numeric(4, 0)), CAST(32.570 AS Numeric(7, 3)), CAST(615.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1000 AS Numeric(4, 0)), CAST(32.580 AS Numeric(7, 3)), CAST(617.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1001 AS Numeric(4, 0)), CAST(32.590 AS Numeric(7, 3)), CAST(619.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1002 AS Numeric(4, 0)), CAST(32.600 AS Numeric(7, 3)), CAST(620.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1003 AS Numeric(4, 0)), CAST(32.610 AS Numeric(7, 3)), CAST(622.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1004 AS Numeric(4, 0)), CAST(32.620 AS Numeric(7, 3)), CAST(624.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1005 AS Numeric(4, 0)), CAST(32.630 AS Numeric(7, 3)), CAST(626.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1006 AS Numeric(4, 0)), CAST(32.640 AS Numeric(7, 3)), CAST(628.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1007 AS Numeric(4, 0)), CAST(32.650 AS Numeric(7, 3)), CAST(630.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1008 AS Numeric(4, 0)), CAST(32.660 AS Numeric(7, 3)), CAST(632.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1009 AS Numeric(4, 0)), CAST(32.670 AS Numeric(7, 3)), CAST(634.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1010 AS Numeric(4, 0)), CAST(32.680 AS Numeric(7, 3)), CAST(636.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1011 AS Numeric(4, 0)), CAST(32.690 AS Numeric(7, 3)), CAST(638.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1012 AS Numeric(4, 0)), CAST(32.700 AS Numeric(7, 3)), CAST(640.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1013 AS Numeric(4, 0)), CAST(32.710 AS Numeric(7, 3)), CAST(642.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1014 AS Numeric(4, 0)), CAST(32.720 AS Numeric(7, 3)), CAST(644.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1015 AS Numeric(4, 0)), CAST(32.730 AS Numeric(7, 3)), CAST(646.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1016 AS Numeric(4, 0)), CAST(32.740 AS Numeric(7, 3)), CAST(648.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1017 AS Numeric(4, 0)), CAST(32.750 AS Numeric(7, 3)), CAST(650.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1018 AS Numeric(4, 0)), CAST(32.760 AS Numeric(7, 3)), CAST(652.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1019 AS Numeric(4, 0)), CAST(32.770 AS Numeric(7, 3)), CAST(654.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1020 AS Numeric(4, 0)), CAST(32.780 AS Numeric(7, 3)), CAST(656.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1021 AS Numeric(4, 0)), CAST(32.790 AS Numeric(7, 3)), CAST(658.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1022 AS Numeric(4, 0)), CAST(32.800 AS Numeric(7, 3)), CAST(660.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1023 AS Numeric(4, 0)), CAST(32.810 AS Numeric(7, 3)), CAST(662.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1024 AS Numeric(4, 0)), CAST(32.820 AS Numeric(7, 3)), CAST(664.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1025 AS Numeric(4, 0)), CAST(32.830 AS Numeric(7, 3)), CAST(666.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1026 AS Numeric(4, 0)), CAST(32.840 AS Numeric(7, 3)), CAST(668.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1027 AS Numeric(4, 0)), CAST(32.850 AS Numeric(7, 3)), CAST(670.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1028 AS Numeric(4, 0)), CAST(32.860 AS Numeric(7, 3)), CAST(672.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1029 AS Numeric(4, 0)), CAST(32.870 AS Numeric(7, 3)), CAST(674.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1030 AS Numeric(4, 0)), CAST(32.880 AS Numeric(7, 3)), CAST(676.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1031 AS Numeric(4, 0)), CAST(32.890 AS Numeric(7, 3)), CAST(678.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1032 AS Numeric(4, 0)), CAST(32.900 AS Numeric(7, 3)), CAST(680.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1033 AS Numeric(4, 0)), CAST(32.910 AS Numeric(7, 3)), CAST(682.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1034 AS Numeric(4, 0)), CAST(32.920 AS Numeric(7, 3)), CAST(684.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1035 AS Numeric(4, 0)), CAST(32.930 AS Numeric(7, 3)), CAST(686.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1036 AS Numeric(4, 0)), CAST(32.940 AS Numeric(7, 3)), CAST(688.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1037 AS Numeric(4, 0)), CAST(32.950 AS Numeric(7, 3)), CAST(690.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1038 AS Numeric(4, 0)), CAST(32.960 AS Numeric(7, 3)), CAST(692.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1039 AS Numeric(4, 0)), CAST(32.970 AS Numeric(7, 3)), CAST(694.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1040 AS Numeric(4, 0)), CAST(32.980 AS Numeric(7, 3)), CAST(696.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1041 AS Numeric(4, 0)), CAST(32.990 AS Numeric(7, 3)), CAST(698.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1042 AS Numeric(4, 0)), CAST(33.000 AS Numeric(7, 3)), CAST(700.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1043 AS Numeric(4, 0)), CAST(33.010 AS Numeric(7, 3)), CAST(702.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1044 AS Numeric(4, 0)), CAST(33.020 AS Numeric(7, 3)), CAST(704.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1045 AS Numeric(4, 0)), CAST(33.030 AS Numeric(7, 3)), CAST(706.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1046 AS Numeric(4, 0)), CAST(33.040 AS Numeric(7, 3)), CAST(708.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1047 AS Numeric(4, 0)), CAST(33.050 AS Numeric(7, 3)), CAST(710.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1048 AS Numeric(4, 0)), CAST(33.060 AS Numeric(7, 3)), CAST(712.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1049 AS Numeric(4, 0)), CAST(33.070 AS Numeric(7, 3)), CAST(714.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1050 AS Numeric(4, 0)), CAST(33.080 AS Numeric(7, 3)), CAST(716.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1051 AS Numeric(4, 0)), CAST(33.090 AS Numeric(7, 3)), CAST(718.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1052 AS Numeric(4, 0)), CAST(33.100 AS Numeric(7, 3)), CAST(720.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1053 AS Numeric(4, 0)), CAST(33.110 AS Numeric(7, 3)), CAST(722.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1054 AS Numeric(4, 0)), CAST(33.120 AS Numeric(7, 3)), CAST(724.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1055 AS Numeric(4, 0)), CAST(33.130 AS Numeric(7, 3)), CAST(726.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1056 AS Numeric(4, 0)), CAST(33.140 AS Numeric(7, 3)), CAST(728.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1057 AS Numeric(4, 0)), CAST(33.150 AS Numeric(7, 3)), CAST(730.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1058 AS Numeric(4, 0)), CAST(33.160 AS Numeric(7, 3)), CAST(732.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1059 AS Numeric(4, 0)), CAST(33.170 AS Numeric(7, 3)), CAST(734.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1060 AS Numeric(4, 0)), CAST(33.180 AS Numeric(7, 3)), CAST(736.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1061 AS Numeric(4, 0)), CAST(33.190 AS Numeric(7, 3)), CAST(738.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1062 AS Numeric(4, 0)), CAST(33.200 AS Numeric(7, 3)), CAST(740.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1063 AS Numeric(4, 0)), CAST(33.210 AS Numeric(7, 3)), CAST(742.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1064 AS Numeric(4, 0)), CAST(33.220 AS Numeric(7, 3)), CAST(744.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1065 AS Numeric(4, 0)), CAST(33.230 AS Numeric(7, 3)), CAST(746.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1066 AS Numeric(4, 0)), CAST(33.240 AS Numeric(7, 3)), CAST(748.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1067 AS Numeric(4, 0)), CAST(33.250 AS Numeric(7, 3)), CAST(750.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1068 AS Numeric(4, 0)), CAST(33.260 AS Numeric(7, 3)), CAST(752.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1069 AS Numeric(4, 0)), CAST(33.270 AS Numeric(7, 3)), CAST(754.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1070 AS Numeric(4, 0)), CAST(33.280 AS Numeric(7, 3)), CAST(756.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1071 AS Numeric(4, 0)), CAST(33.290 AS Numeric(7, 3)), CAST(758.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1072 AS Numeric(4, 0)), CAST(33.300 AS Numeric(7, 3)), CAST(760.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1073 AS Numeric(4, 0)), CAST(33.310 AS Numeric(7, 3)), CAST(762.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1074 AS Numeric(4, 0)), CAST(33.320 AS Numeric(7, 3)), CAST(764.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1075 AS Numeric(4, 0)), CAST(33.330 AS Numeric(7, 3)), CAST(766.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1076 AS Numeric(4, 0)), CAST(33.340 AS Numeric(7, 3)), CAST(768.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1077 AS Numeric(4, 0)), CAST(33.350 AS Numeric(7, 3)), CAST(770.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1078 AS Numeric(4, 0)), CAST(33.360 AS Numeric(7, 3)), CAST(772.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1079 AS Numeric(4, 0)), CAST(33.370 AS Numeric(7, 3)), CAST(774.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1080 AS Numeric(4, 0)), CAST(33.380 AS Numeric(7, 3)), CAST(776.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1081 AS Numeric(4, 0)), CAST(33.390 AS Numeric(7, 3)), CAST(779.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1082 AS Numeric(4, 0)), CAST(33.400 AS Numeric(7, 3)), CAST(781.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1083 AS Numeric(4, 0)), CAST(33.410 AS Numeric(7, 3)), CAST(783.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1084 AS Numeric(4, 0)), CAST(33.420 AS Numeric(7, 3)), CAST(785.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1085 AS Numeric(4, 0)), CAST(33.430 AS Numeric(7, 3)), CAST(788.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1086 AS Numeric(4, 0)), CAST(33.440 AS Numeric(7, 3)), CAST(790.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1087 AS Numeric(4, 0)), CAST(33.450 AS Numeric(7, 3)), CAST(792.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1088 AS Numeric(4, 0)), CAST(33.460 AS Numeric(7, 3)), CAST(794.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1089 AS Numeric(4, 0)), CAST(33.470 AS Numeric(7, 3)), CAST(797.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1090 AS Numeric(4, 0)), CAST(33.480 AS Numeric(7, 3)), CAST(799.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1091 AS Numeric(4, 0)), CAST(33.490 AS Numeric(7, 3)), CAST(801.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1092 AS Numeric(4, 0)), CAST(33.500 AS Numeric(7, 3)), CAST(803.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1093 AS Numeric(4, 0)), CAST(33.510 AS Numeric(7, 3)), CAST(806.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1094 AS Numeric(4, 0)), CAST(33.520 AS Numeric(7, 3)), CAST(808.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1095 AS Numeric(4, 0)), CAST(33.530 AS Numeric(7, 3)), CAST(810.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1096 AS Numeric(4, 0)), CAST(33.540 AS Numeric(7, 3)), CAST(812.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1097 AS Numeric(4, 0)), CAST(33.550 AS Numeric(7, 3)), CAST(815.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1098 AS Numeric(4, 0)), CAST(33.560 AS Numeric(7, 3)), CAST(817.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1099 AS Numeric(4, 0)), CAST(33.570 AS Numeric(7, 3)), CAST(820.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1100 AS Numeric(4, 0)), CAST(33.580 AS Numeric(7, 3)), CAST(822.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1101 AS Numeric(4, 0)), CAST(33.590 AS Numeric(7, 3)), CAST(825.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1102 AS Numeric(4, 0)), CAST(33.600 AS Numeric(7, 3)), CAST(827.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1103 AS Numeric(4, 0)), CAST(33.610 AS Numeric(7, 3)), CAST(829.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1104 AS Numeric(4, 0)), CAST(33.620 AS Numeric(7, 3)), CAST(831.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1105 AS Numeric(4, 0)), CAST(33.630 AS Numeric(7, 3)), CAST(834.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1106 AS Numeric(4, 0)), CAST(33.640 AS Numeric(7, 3)), CAST(836.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1107 AS Numeric(4, 0)), CAST(33.650 AS Numeric(7, 3)), CAST(838.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1108 AS Numeric(4, 0)), CAST(33.660 AS Numeric(7, 3)), CAST(840.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1109 AS Numeric(4, 0)), CAST(33.670 AS Numeric(7, 3)), CAST(843.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1110 AS Numeric(4, 0)), CAST(33.680 AS Numeric(7, 3)), CAST(845.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1111 AS Numeric(4, 0)), CAST(33.690 AS Numeric(7, 3)), CAST(847.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1112 AS Numeric(4, 0)), CAST(33.700 AS Numeric(7, 3)), CAST(849.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1113 AS Numeric(4, 0)), CAST(33.710 AS Numeric(7, 3)), CAST(852.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1114 AS Numeric(4, 0)), CAST(33.720 AS Numeric(7, 3)), CAST(854.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1115 AS Numeric(4, 0)), CAST(33.730 AS Numeric(7, 3)), CAST(856.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1116 AS Numeric(4, 0)), CAST(33.740 AS Numeric(7, 3)), CAST(858.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1117 AS Numeric(4, 0)), CAST(33.750 AS Numeric(7, 3)), CAST(861.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1118 AS Numeric(4, 0)), CAST(33.760 AS Numeric(7, 3)), CAST(863.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1119 AS Numeric(4, 0)), CAST(33.770 AS Numeric(7, 3)), CAST(866.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1120 AS Numeric(4, 0)), CAST(33.780 AS Numeric(7, 3)), CAST(868.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1121 AS Numeric(4, 0)), CAST(33.790 AS Numeric(7, 3)), CAST(871.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1122 AS Numeric(4, 0)), CAST(33.800 AS Numeric(7, 3)), CAST(873.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1123 AS Numeric(4, 0)), CAST(33.810 AS Numeric(7, 3)), CAST(876.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1124 AS Numeric(4, 0)), CAST(33.820 AS Numeric(7, 3)), CAST(878.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1125 AS Numeric(4, 0)), CAST(33.830 AS Numeric(7, 3)), CAST(881.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1126 AS Numeric(4, 0)), CAST(33.840 AS Numeric(7, 3)), CAST(883.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1127 AS Numeric(4, 0)), CAST(33.850 AS Numeric(7, 3)), CAST(886.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1128 AS Numeric(4, 0)), CAST(33.860 AS Numeric(7, 3)), CAST(888.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1129 AS Numeric(4, 0)), CAST(33.870 AS Numeric(7, 3)), CAST(891.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1130 AS Numeric(4, 0)), CAST(33.880 AS Numeric(7, 3)), CAST(893.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1131 AS Numeric(4, 0)), CAST(33.890 AS Numeric(7, 3)), CAST(896.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1132 AS Numeric(4, 0)), CAST(33.900 AS Numeric(7, 3)), CAST(898.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1133 AS Numeric(4, 0)), CAST(33.910 AS Numeric(7, 3)), CAST(901.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1134 AS Numeric(4, 0)), CAST(33.920 AS Numeric(7, 3)), CAST(903.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1135 AS Numeric(4, 0)), CAST(33.930 AS Numeric(7, 3)), CAST(906.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1136 AS Numeric(4, 0)), CAST(33.940 AS Numeric(7, 3)), CAST(908.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1137 AS Numeric(4, 0)), CAST(33.950 AS Numeric(7, 3)), CAST(911.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1138 AS Numeric(4, 0)), CAST(33.960 AS Numeric(7, 3)), CAST(913.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1139 AS Numeric(4, 0)), CAST(33.970 AS Numeric(7, 3)), CAST(916.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1140 AS Numeric(4, 0)), CAST(33.980 AS Numeric(7, 3)), CAST(918.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1141 AS Numeric(4, 0)), CAST(33.990 AS Numeric(7, 3)), CAST(921.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1142 AS Numeric(4, 0)), CAST(34.000 AS Numeric(7, 3)), CAST(923.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1143 AS Numeric(4, 0)), CAST(34.010 AS Numeric(7, 3)), CAST(926.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1144 AS Numeric(4, 0)), CAST(34.020 AS Numeric(7, 3)), CAST(928.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1145 AS Numeric(4, 0)), CAST(34.030 AS Numeric(7, 3)), CAST(931.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1146 AS Numeric(4, 0)), CAST(34.040 AS Numeric(7, 3)), CAST(933.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1147 AS Numeric(4, 0)), CAST(34.050 AS Numeric(7, 3)), CAST(936.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1148 AS Numeric(4, 0)), CAST(34.060 AS Numeric(7, 3)), CAST(938.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1149 AS Numeric(4, 0)), CAST(34.070 AS Numeric(7, 3)), CAST(941.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1150 AS Numeric(4, 0)), CAST(34.080 AS Numeric(7, 3)), CAST(943.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1151 AS Numeric(4, 0)), CAST(34.090 AS Numeric(7, 3)), CAST(946.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1152 AS Numeric(4, 0)), CAST(34.100 AS Numeric(7, 3)), CAST(948.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1153 AS Numeric(4, 0)), CAST(34.110 AS Numeric(7, 3)), CAST(951.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1154 AS Numeric(4, 0)), CAST(34.120 AS Numeric(7, 3)), CAST(953.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1155 AS Numeric(4, 0)), CAST(34.130 AS Numeric(7, 3)), CAST(956.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1156 AS Numeric(4, 0)), CAST(34.140 AS Numeric(7, 3)), CAST(958.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1157 AS Numeric(4, 0)), CAST(34.150 AS Numeric(7, 3)), CAST(961.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1158 AS Numeric(4, 0)), CAST(34.160 AS Numeric(7, 3)), CAST(963.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1159 AS Numeric(4, 0)), CAST(34.170 AS Numeric(7, 3)), CAST(966.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1160 AS Numeric(4, 0)), CAST(34.180 AS Numeric(7, 3)), CAST(968.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1161 AS Numeric(4, 0)), CAST(34.190 AS Numeric(7, 3)), CAST(971.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1162 AS Numeric(4, 0)), CAST(34.200 AS Numeric(7, 3)), CAST(973.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1163 AS Numeric(4, 0)), CAST(34.210 AS Numeric(7, 3)), CAST(976.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1164 AS Numeric(4, 0)), CAST(34.220 AS Numeric(7, 3)), CAST(978.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1165 AS Numeric(4, 0)), CAST(34.230 AS Numeric(7, 3)), CAST(981.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1166 AS Numeric(4, 0)), CAST(34.240 AS Numeric(7, 3)), CAST(983.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1167 AS Numeric(4, 0)), CAST(34.250 AS Numeric(7, 3)), CAST(986.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1168 AS Numeric(4, 0)), CAST(34.260 AS Numeric(7, 3)), CAST(988.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1169 AS Numeric(4, 0)), CAST(34.270 AS Numeric(7, 3)), CAST(991.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1170 AS Numeric(4, 0)), CAST(34.280 AS Numeric(7, 3)), CAST(993.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1171 AS Numeric(4, 0)), CAST(34.290 AS Numeric(7, 3)), CAST(996.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1172 AS Numeric(4, 0)), CAST(34.300 AS Numeric(7, 3)), CAST(998.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1173 AS Numeric(4, 0)), CAST(34.310 AS Numeric(7, 3)), CAST(1001.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1174 AS Numeric(4, 0)), CAST(34.320 AS Numeric(7, 3)), CAST(1003.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1175 AS Numeric(4, 0)), CAST(34.330 AS Numeric(7, 3)), CAST(1006.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1176 AS Numeric(4, 0)), CAST(34.340 AS Numeric(7, 3)), CAST(1008.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1177 AS Numeric(4, 0)), CAST(34.350 AS Numeric(7, 3)), CAST(1011.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1178 AS Numeric(4, 0)), CAST(34.360 AS Numeric(7, 3)), CAST(1013.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1179 AS Numeric(4, 0)), CAST(34.370 AS Numeric(7, 3)), CAST(1016.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1180 AS Numeric(4, 0)), CAST(34.380 AS Numeric(7, 3)), CAST(1018.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1181 AS Numeric(4, 0)), CAST(34.390 AS Numeric(7, 3)), CAST(1021.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1182 AS Numeric(4, 0)), CAST(34.400 AS Numeric(7, 3)), CAST(1023.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1183 AS Numeric(4, 0)), CAST(34.410 AS Numeric(7, 3)), CAST(1026.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1184 AS Numeric(4, 0)), CAST(34.420 AS Numeric(7, 3)), CAST(1028.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1185 AS Numeric(4, 0)), CAST(34.430 AS Numeric(7, 3)), CAST(1031.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1186 AS Numeric(4, 0)), CAST(34.440 AS Numeric(7, 3)), CAST(1033.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1187 AS Numeric(4, 0)), CAST(34.450 AS Numeric(7, 3)), CAST(1036.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1188 AS Numeric(4, 0)), CAST(34.460 AS Numeric(7, 3)), CAST(1038.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1189 AS Numeric(4, 0)), CAST(34.470 AS Numeric(7, 3)), CAST(1041.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1190 AS Numeric(4, 0)), CAST(34.480 AS Numeric(7, 3)), CAST(1043.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1191 AS Numeric(4, 0)), CAST(34.490 AS Numeric(7, 3)), CAST(1046.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1192 AS Numeric(4, 0)), CAST(34.500 AS Numeric(7, 3)), CAST(1048.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1193 AS Numeric(4, 0)), CAST(34.510 AS Numeric(7, 3)), CAST(1051.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1194 AS Numeric(4, 0)), CAST(34.520 AS Numeric(7, 3)), CAST(1053.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1195 AS Numeric(4, 0)), CAST(34.530 AS Numeric(7, 3)), CAST(1056.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1196 AS Numeric(4, 0)), CAST(34.540 AS Numeric(7, 3)), CAST(1058.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1197 AS Numeric(4, 0)), CAST(34.550 AS Numeric(7, 3)), CAST(1061.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1198 AS Numeric(4, 0)), CAST(34.560 AS Numeric(7, 3)), CAST(1063.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1199 AS Numeric(4, 0)), CAST(34.570 AS Numeric(7, 3)), CAST(1066.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1200 AS Numeric(4, 0)), CAST(34.580 AS Numeric(7, 3)), CAST(1068.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1201 AS Numeric(4, 0)), CAST(34.590 AS Numeric(7, 3)), CAST(1071.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1202 AS Numeric(4, 0)), CAST(34.600 AS Numeric(7, 3)), CAST(1073.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1203 AS Numeric(4, 0)), CAST(34.610 AS Numeric(7, 3)), CAST(1076.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1204 AS Numeric(4, 0)), CAST(34.620 AS Numeric(7, 3)), CAST(1079.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1205 AS Numeric(4, 0)), CAST(34.630 AS Numeric(7, 3)), CAST(1082.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1206 AS Numeric(4, 0)), CAST(34.640 AS Numeric(7, 3)), CAST(1084.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1207 AS Numeric(4, 0)), CAST(34.650 AS Numeric(7, 3)), CAST(1087.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1208 AS Numeric(4, 0)), CAST(34.660 AS Numeric(7, 3)), CAST(1090.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1209 AS Numeric(4, 0)), CAST(34.670 AS Numeric(7, 3)), CAST(1093.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1210 AS Numeric(4, 0)), CAST(34.680 AS Numeric(7, 3)), CAST(1095.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1211 AS Numeric(4, 0)), CAST(34.690 AS Numeric(7, 3)), CAST(1098.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1212 AS Numeric(4, 0)), CAST(34.700 AS Numeric(7, 3)), CAST(1101.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1213 AS Numeric(4, 0)), CAST(34.710 AS Numeric(7, 3)), CAST(1104.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1214 AS Numeric(4, 0)), CAST(34.720 AS Numeric(7, 3)), CAST(1106.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1215 AS Numeric(4, 0)), CAST(34.730 AS Numeric(7, 3)), CAST(1109.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1216 AS Numeric(4, 0)), CAST(34.740 AS Numeric(7, 3)), CAST(1112.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1217 AS Numeric(4, 0)), CAST(34.750 AS Numeric(7, 3)), CAST(1115.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1218 AS Numeric(4, 0)), CAST(34.760 AS Numeric(7, 3)), CAST(1117.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1219 AS Numeric(4, 0)), CAST(34.770 AS Numeric(7, 3)), CAST(1120.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1220 AS Numeric(4, 0)), CAST(34.780 AS Numeric(7, 3)), CAST(1123.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1221 AS Numeric(4, 0)), CAST(34.790 AS Numeric(7, 3)), CAST(1126.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1222 AS Numeric(4, 0)), CAST(34.800 AS Numeric(7, 3)), CAST(1128.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1223 AS Numeric(4, 0)), CAST(34.810 AS Numeric(7, 3)), CAST(1131.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1224 AS Numeric(4, 0)), CAST(34.820 AS Numeric(7, 3)), CAST(1134.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1225 AS Numeric(4, 0)), CAST(34.830 AS Numeric(7, 3)), CAST(1137.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1226 AS Numeric(4, 0)), CAST(34.840 AS Numeric(7, 3)), CAST(1139.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1227 AS Numeric(4, 0)), CAST(34.850 AS Numeric(7, 3)), CAST(1142.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1228 AS Numeric(4, 0)), CAST(34.860 AS Numeric(7, 3)), CAST(1145.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1229 AS Numeric(4, 0)), CAST(34.870 AS Numeric(7, 3)), CAST(1148.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1230 AS Numeric(4, 0)), CAST(34.880 AS Numeric(7, 3)), CAST(1150.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1231 AS Numeric(4, 0)), CAST(34.890 AS Numeric(7, 3)), CAST(1153.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1232 AS Numeric(4, 0)), CAST(34.900 AS Numeric(7, 3)), CAST(1156.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1233 AS Numeric(4, 0)), CAST(34.910 AS Numeric(7, 3)), CAST(1159.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1234 AS Numeric(4, 0)), CAST(34.920 AS Numeric(7, 3)), CAST(1161.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1235 AS Numeric(4, 0)), CAST(34.930 AS Numeric(7, 3)), CAST(1164.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1236 AS Numeric(4, 0)), CAST(34.940 AS Numeric(7, 3)), CAST(1167.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1237 AS Numeric(4, 0)), CAST(34.950 AS Numeric(7, 3)), CAST(1170.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1238 AS Numeric(4, 0)), CAST(34.960 AS Numeric(7, 3)), CAST(1173.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1239 AS Numeric(4, 0)), CAST(34.970 AS Numeric(7, 3)), CAST(1176.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1240 AS Numeric(4, 0)), CAST(34.980 AS Numeric(7, 3)), CAST(1179.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1241 AS Numeric(4, 0)), CAST(34.990 AS Numeric(7, 3)), CAST(1182.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1242 AS Numeric(4, 0)), CAST(35.000 AS Numeric(7, 3)), CAST(1185.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1243 AS Numeric(4, 0)), CAST(35.010 AS Numeric(7, 3)), CAST(1188.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1244 AS Numeric(4, 0)), CAST(35.020 AS Numeric(7, 3)), CAST(1191.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1245 AS Numeric(4, 0)), CAST(35.030 AS Numeric(7, 3)), CAST(1194.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1246 AS Numeric(4, 0)), CAST(35.040 AS Numeric(7, 3)), CAST(1197.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1247 AS Numeric(4, 0)), CAST(35.050 AS Numeric(7, 3)), CAST(1200.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1248 AS Numeric(4, 0)), CAST(35.060 AS Numeric(7, 3)), CAST(1203.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1249 AS Numeric(4, 0)), CAST(35.070 AS Numeric(7, 3)), CAST(1206.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1250 AS Numeric(4, 0)), CAST(35.080 AS Numeric(7, 3)), CAST(1209.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1251 AS Numeric(4, 0)), CAST(35.090 AS Numeric(7, 3)), CAST(1212.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1252 AS Numeric(4, 0)), CAST(35.100 AS Numeric(7, 3)), CAST(1215.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1253 AS Numeric(4, 0)), CAST(35.110 AS Numeric(7, 3)), CAST(1218.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1254 AS Numeric(4, 0)), CAST(35.120 AS Numeric(7, 3)), CAST(1221.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1255 AS Numeric(4, 0)), CAST(35.130 AS Numeric(7, 3)), CAST(1224.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1256 AS Numeric(4, 0)), CAST(35.140 AS Numeric(7, 3)), CAST(1227.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1257 AS Numeric(4, 0)), CAST(35.150 AS Numeric(7, 3)), CAST(1230.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1258 AS Numeric(4, 0)), CAST(35.160 AS Numeric(7, 3)), CAST(1233.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1259 AS Numeric(4, 0)), CAST(35.170 AS Numeric(7, 3)), CAST(1236.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1260 AS Numeric(4, 0)), CAST(35.180 AS Numeric(7, 3)), CAST(1239.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1261 AS Numeric(4, 0)), CAST(35.190 AS Numeric(7, 3)), CAST(1242.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1262 AS Numeric(4, 0)), CAST(35.200 AS Numeric(7, 3)), CAST(1245.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1263 AS Numeric(4, 0)), CAST(35.210 AS Numeric(7, 3)), CAST(1248.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1264 AS Numeric(4, 0)), CAST(35.220 AS Numeric(7, 3)), CAST(1251.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1265 AS Numeric(4, 0)), CAST(35.230 AS Numeric(7, 3)), CAST(1254.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1266 AS Numeric(4, 0)), CAST(35.240 AS Numeric(7, 3)), CAST(1257.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1267 AS Numeric(4, 0)), CAST(35.250 AS Numeric(7, 3)), CAST(1260.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1268 AS Numeric(4, 0)), CAST(35.260 AS Numeric(7, 3)), CAST(1263.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1269 AS Numeric(4, 0)), CAST(35.270 AS Numeric(7, 3)), CAST(1266.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1270 AS Numeric(4, 0)), CAST(35.280 AS Numeric(7, 3)), CAST(1269.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1271 AS Numeric(4, 0)), CAST(35.290 AS Numeric(7, 3)), CAST(1272.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1272 AS Numeric(4, 0)), CAST(35.300 AS Numeric(7, 3)), CAST(1275.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1273 AS Numeric(4, 0)), CAST(35.310 AS Numeric(7, 3)), CAST(1278.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1274 AS Numeric(4, 0)), CAST(35.320 AS Numeric(7, 3)), CAST(1281.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1275 AS Numeric(4, 0)), CAST(35.330 AS Numeric(7, 3)), CAST(1284.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1276 AS Numeric(4, 0)), CAST(35.340 AS Numeric(7, 3)), CAST(1287.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1277 AS Numeric(4, 0)), CAST(35.350 AS Numeric(7, 3)), CAST(1290.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1278 AS Numeric(4, 0)), CAST(35.360 AS Numeric(7, 3)), CAST(1293.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1279 AS Numeric(4, 0)), CAST(35.370 AS Numeric(7, 3)), CAST(1296.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1280 AS Numeric(4, 0)), CAST(35.380 AS Numeric(7, 3)), CAST(1299.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1281 AS Numeric(4, 0)), CAST(35.390 AS Numeric(7, 3)), CAST(1302.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1282 AS Numeric(4, 0)), CAST(35.400 AS Numeric(7, 3)), CAST(1305.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1283 AS Numeric(4, 0)), CAST(35.410 AS Numeric(7, 3)), CAST(1308.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1284 AS Numeric(4, 0)), CAST(35.420 AS Numeric(7, 3)), CAST(1311.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1285 AS Numeric(4, 0)), CAST(35.430 AS Numeric(7, 3)), CAST(1314.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1286 AS Numeric(4, 0)), CAST(35.440 AS Numeric(7, 3)), CAST(1317.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1287 AS Numeric(4, 0)), CAST(35.450 AS Numeric(7, 3)), CAST(1320.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1288 AS Numeric(4, 0)), CAST(35.460 AS Numeric(7, 3)), CAST(1323.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1289 AS Numeric(4, 0)), CAST(35.470 AS Numeric(7, 3)), CAST(1326.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1290 AS Numeric(4, 0)), CAST(35.480 AS Numeric(7, 3)), CAST(1329.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1291 AS Numeric(4, 0)), CAST(35.490 AS Numeric(7, 3)), CAST(1332.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1292 AS Numeric(4, 0)), CAST(35.500 AS Numeric(7, 3)), CAST(1335.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1293 AS Numeric(4, 0)), CAST(35.510 AS Numeric(7, 3)), CAST(1338.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1294 AS Numeric(4, 0)), CAST(35.520 AS Numeric(7, 3)), CAST(1341.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1295 AS Numeric(4, 0)), CAST(35.530 AS Numeric(7, 3)), CAST(1344.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1296 AS Numeric(4, 0)), CAST(35.540 AS Numeric(7, 3)), CAST(1347.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1297 AS Numeric(4, 0)), CAST(35.550 AS Numeric(7, 3)), CAST(1350.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1298 AS Numeric(4, 0)), CAST(35.560 AS Numeric(7, 3)), CAST(1353.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1299 AS Numeric(4, 0)), CAST(35.570 AS Numeric(7, 3)), CAST(1356.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1300 AS Numeric(4, 0)), CAST(35.580 AS Numeric(7, 3)), CAST(1359.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1301 AS Numeric(4, 0)), CAST(35.590 AS Numeric(7, 3)), CAST(1362.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1302 AS Numeric(4, 0)), CAST(35.600 AS Numeric(7, 3)), CAST(1365.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1303 AS Numeric(4, 0)), CAST(35.610 AS Numeric(7, 3)), CAST(1368.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1304 AS Numeric(4, 0)), CAST(35.620 AS Numeric(7, 3)), CAST(1371.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1305 AS Numeric(4, 0)), CAST(35.630 AS Numeric(7, 3)), CAST(1375.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1306 AS Numeric(4, 0)), CAST(35.640 AS Numeric(7, 3)), CAST(1378.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1307 AS Numeric(4, 0)), CAST(35.650 AS Numeric(7, 3)), CAST(1381.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1308 AS Numeric(4, 0)), CAST(35.660 AS Numeric(7, 3)), CAST(1384.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1309 AS Numeric(4, 0)), CAST(35.670 AS Numeric(7, 3)), CAST(1388.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1310 AS Numeric(4, 0)), CAST(35.680 AS Numeric(7, 3)), CAST(1391.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1311 AS Numeric(4, 0)), CAST(35.690 AS Numeric(7, 3)), CAST(1394.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1312 AS Numeric(4, 0)), CAST(35.700 AS Numeric(7, 3)), CAST(1397.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1313 AS Numeric(4, 0)), CAST(35.710 AS Numeric(7, 3)), CAST(1401.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1314 AS Numeric(4, 0)), CAST(35.720 AS Numeric(7, 3)), CAST(1404.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1315 AS Numeric(4, 0)), CAST(35.730 AS Numeric(7, 3)), CAST(1407.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1316 AS Numeric(4, 0)), CAST(35.740 AS Numeric(7, 3)), CAST(1410.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1317 AS Numeric(4, 0)), CAST(35.750 AS Numeric(7, 3)), CAST(1414.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1318 AS Numeric(4, 0)), CAST(35.760 AS Numeric(7, 3)), CAST(1417.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1319 AS Numeric(4, 0)), CAST(35.770 AS Numeric(7, 3)), CAST(1420.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1320 AS Numeric(4, 0)), CAST(35.780 AS Numeric(7, 3)), CAST(1423.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1321 AS Numeric(4, 0)), CAST(35.790 AS Numeric(7, 3)), CAST(1427.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1322 AS Numeric(4, 0)), CAST(35.800 AS Numeric(7, 3)), CAST(1430.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1323 AS Numeric(4, 0)), CAST(35.810 AS Numeric(7, 3)), CAST(1433.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1324 AS Numeric(4, 0)), CAST(35.820 AS Numeric(7, 3)), CAST(1436.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1325 AS Numeric(4, 0)), CAST(35.830 AS Numeric(7, 3)), CAST(1440.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1326 AS Numeric(4, 0)), CAST(35.840 AS Numeric(7, 3)), CAST(1443.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1327 AS Numeric(4, 0)), CAST(35.850 AS Numeric(7, 3)), CAST(1446.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1328 AS Numeric(4, 0)), CAST(35.860 AS Numeric(7, 3)), CAST(1449.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1329 AS Numeric(4, 0)), CAST(35.870 AS Numeric(7, 3)), CAST(1453.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1330 AS Numeric(4, 0)), CAST(35.880 AS Numeric(7, 3)), CAST(1456.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1331 AS Numeric(4, 0)), CAST(35.890 AS Numeric(7, 3)), CAST(1459.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1332 AS Numeric(4, 0)), CAST(35.900 AS Numeric(7, 3)), CAST(1462.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1333 AS Numeric(4, 0)), CAST(35.910 AS Numeric(7, 3)), CAST(1466.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1334 AS Numeric(4, 0)), CAST(35.920 AS Numeric(7, 3)), CAST(1469.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1335 AS Numeric(4, 0)), CAST(35.930 AS Numeric(7, 3)), CAST(1472.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1336 AS Numeric(4, 0)), CAST(35.940 AS Numeric(7, 3)), CAST(1475.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1337 AS Numeric(4, 0)), CAST(35.950 AS Numeric(7, 3)), CAST(1479.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1338 AS Numeric(4, 0)), CAST(35.960 AS Numeric(7, 3)), CAST(1482.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1339 AS Numeric(4, 0)), CAST(35.970 AS Numeric(7, 3)), CAST(1485.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1340 AS Numeric(4, 0)), CAST(35.980 AS Numeric(7, 3)), CAST(1488.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1341 AS Numeric(4, 0)), CAST(35.990 AS Numeric(7, 3)), CAST(1492.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1342 AS Numeric(4, 0)), CAST(36.000 AS Numeric(7, 3)), CAST(1495.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1343 AS Numeric(4, 0)), CAST(36.010 AS Numeric(7, 3)), CAST(1498.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1344 AS Numeric(4, 0)), CAST(36.020 AS Numeric(7, 3)), CAST(1501.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1345 AS Numeric(4, 0)), CAST(36.030 AS Numeric(7, 3)), CAST(1505.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1346 AS Numeric(4, 0)), CAST(36.040 AS Numeric(7, 3)), CAST(1508.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1347 AS Numeric(4, 0)), CAST(36.050 AS Numeric(7, 3)), CAST(1511.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1348 AS Numeric(4, 0)), CAST(36.060 AS Numeric(7, 3)), CAST(1514.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1349 AS Numeric(4, 0)), CAST(36.070 AS Numeric(7, 3)), CAST(1518.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1350 AS Numeric(4, 0)), CAST(36.080 AS Numeric(7, 3)), CAST(1521.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1351 AS Numeric(4, 0)), CAST(36.090 AS Numeric(7, 3)), CAST(1524.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1352 AS Numeric(4, 0)), CAST(36.100 AS Numeric(7, 3)), CAST(1527.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1353 AS Numeric(4, 0)), CAST(36.110 AS Numeric(7, 3)), CAST(1531.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1354 AS Numeric(4, 0)), CAST(36.120 AS Numeric(7, 3)), CAST(1534.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1355 AS Numeric(4, 0)), CAST(36.130 AS Numeric(7, 3)), CAST(1537.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1356 AS Numeric(4, 0)), CAST(36.140 AS Numeric(7, 3)), CAST(1540.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1357 AS Numeric(4, 0)), CAST(36.150 AS Numeric(7, 3)), CAST(1543.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1358 AS Numeric(4, 0)), CAST(36.160 AS Numeric(7, 3)), CAST(1546.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1359 AS Numeric(4, 0)), CAST(36.170 AS Numeric(7, 3)), CAST(1550.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1360 AS Numeric(4, 0)), CAST(36.180 AS Numeric(7, 3)), CAST(1553.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1361 AS Numeric(4, 0)), CAST(36.190 AS Numeric(7, 3)), CAST(1556.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1362 AS Numeric(4, 0)), CAST(36.200 AS Numeric(7, 3)), CAST(1559.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1363 AS Numeric(4, 0)), CAST(36.210 AS Numeric(7, 3)), CAST(1563.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1364 AS Numeric(4, 0)), CAST(36.220 AS Numeric(7, 3)), CAST(1566.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1365 AS Numeric(4, 0)), CAST(36.230 AS Numeric(7, 3)), CAST(1569.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1366 AS Numeric(4, 0)), CAST(36.240 AS Numeric(7, 3)), CAST(1572.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1367 AS Numeric(4, 0)), CAST(36.250 AS Numeric(7, 3)), CAST(1576.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1368 AS Numeric(4, 0)), CAST(36.260 AS Numeric(7, 3)), CAST(1579.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1369 AS Numeric(4, 0)), CAST(36.270 AS Numeric(7, 3)), CAST(1582.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1370 AS Numeric(4, 0)), CAST(36.280 AS Numeric(7, 3)), CAST(1585.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1371 AS Numeric(4, 0)), CAST(36.290 AS Numeric(7, 3)), CAST(1589.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1372 AS Numeric(4, 0)), CAST(36.300 AS Numeric(7, 3)), CAST(1592.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1373 AS Numeric(4, 0)), CAST(36.310 AS Numeric(7, 3)), CAST(1595.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1374 AS Numeric(4, 0)), CAST(36.320 AS Numeric(7, 3)), CAST(1598.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1375 AS Numeric(4, 0)), CAST(36.330 AS Numeric(7, 3)), CAST(1602.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1376 AS Numeric(4, 0)), CAST(36.340 AS Numeric(7, 3)), CAST(1605.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1377 AS Numeric(4, 0)), CAST(36.350 AS Numeric(7, 3)), CAST(1608.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1378 AS Numeric(4, 0)), CAST(36.360 AS Numeric(7, 3)), CAST(1611.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1379 AS Numeric(4, 0)), CAST(36.370 AS Numeric(7, 3)), CAST(1615.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1380 AS Numeric(4, 0)), CAST(36.380 AS Numeric(7, 3)), CAST(1618.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1381 AS Numeric(4, 0)), CAST(36.390 AS Numeric(7, 3)), CAST(1621.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1382 AS Numeric(4, 0)), CAST(36.400 AS Numeric(7, 3)), CAST(1624.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1383 AS Numeric(4, 0)), CAST(36.410 AS Numeric(7, 3)), CAST(1628.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1384 AS Numeric(4, 0)), CAST(36.420 AS Numeric(7, 3)), CAST(1631.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1385 AS Numeric(4, 0)), CAST(36.430 AS Numeric(7, 3)), CAST(1634.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1386 AS Numeric(4, 0)), CAST(36.440 AS Numeric(7, 3)), CAST(1637.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1387 AS Numeric(4, 0)), CAST(36.450 AS Numeric(7, 3)), CAST(1641.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1388 AS Numeric(4, 0)), CAST(36.460 AS Numeric(7, 3)), CAST(1644.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1389 AS Numeric(4, 0)), CAST(36.470 AS Numeric(7, 3)), CAST(1648.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1390 AS Numeric(4, 0)), CAST(36.480 AS Numeric(7, 3)), CAST(1651.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1391 AS Numeric(4, 0)), CAST(36.490 AS Numeric(7, 3)), CAST(1655.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1392 AS Numeric(4, 0)), CAST(36.500 AS Numeric(7, 3)), CAST(1659.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1393 AS Numeric(4, 0)), CAST(36.510 AS Numeric(7, 3)), CAST(1663.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1394 AS Numeric(4, 0)), CAST(36.520 AS Numeric(7, 3)), CAST(1666.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1395 AS Numeric(4, 0)), CAST(36.530 AS Numeric(7, 3)), CAST(1670.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1396 AS Numeric(4, 0)), CAST(36.540 AS Numeric(7, 3)), CAST(1673.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1397 AS Numeric(4, 0)), CAST(36.550 AS Numeric(7, 3)), CAST(1676.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1398 AS Numeric(4, 0)), CAST(36.560 AS Numeric(7, 3)), CAST(1679.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1399 AS Numeric(4, 0)), CAST(36.570 AS Numeric(7, 3)), CAST(1683.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1400 AS Numeric(4, 0)), CAST(36.580 AS Numeric(7, 3)), CAST(1686.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1401 AS Numeric(4, 0)), CAST(36.590 AS Numeric(7, 3)), CAST(1690.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1402 AS Numeric(4, 0)), CAST(36.600 AS Numeric(7, 3)), CAST(1693.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1403 AS Numeric(4, 0)), CAST(36.610 AS Numeric(7, 3)), CAST(1697.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1404 AS Numeric(4, 0)), CAST(36.620 AS Numeric(7, 3)), CAST(1700.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1405 AS Numeric(4, 0)), CAST(36.630 AS Numeric(7, 3)), CAST(1704.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1406 AS Numeric(4, 0)), CAST(36.640 AS Numeric(7, 3)), CAST(1707.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1407 AS Numeric(4, 0)), CAST(36.650 AS Numeric(7, 3)), CAST(1711.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1408 AS Numeric(4, 0)), CAST(36.660 AS Numeric(7, 3)), CAST(1714.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1409 AS Numeric(4, 0)), CAST(36.670 AS Numeric(7, 3)), CAST(1718.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1410 AS Numeric(4, 0)), CAST(36.680 AS Numeric(7, 3)), CAST(1721.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1411 AS Numeric(4, 0)), CAST(36.690 AS Numeric(7, 3)), CAST(1725.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1412 AS Numeric(4, 0)), CAST(36.700 AS Numeric(7, 3)), CAST(1729.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1413 AS Numeric(4, 0)), CAST(36.710 AS Numeric(7, 3)), CAST(1733.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1414 AS Numeric(4, 0)), CAST(36.720 AS Numeric(7, 3)), CAST(1736.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1415 AS Numeric(4, 0)), CAST(36.730 AS Numeric(7, 3)), CAST(1740.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1416 AS Numeric(4, 0)), CAST(36.740 AS Numeric(7, 3)), CAST(1744.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1417 AS Numeric(4, 0)), CAST(36.750 AS Numeric(7, 3)), CAST(1748.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1418 AS Numeric(4, 0)), CAST(36.760 AS Numeric(7, 3)), CAST(1751.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1419 AS Numeric(4, 0)), CAST(36.770 AS Numeric(7, 3)), CAST(1755.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1420 AS Numeric(4, 0)), CAST(36.780 AS Numeric(7, 3)), CAST(1759.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1421 AS Numeric(4, 0)), CAST(36.790 AS Numeric(7, 3)), CAST(1763.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1422 AS Numeric(4, 0)), CAST(36.800 AS Numeric(7, 3)), CAST(1766.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1423 AS Numeric(4, 0)), CAST(36.810 AS Numeric(7, 3)), CAST(1770.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1424 AS Numeric(4, 0)), CAST(36.820 AS Numeric(7, 3)), CAST(1774.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1425 AS Numeric(4, 0)), CAST(36.830 AS Numeric(7, 3)), CAST(1778.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1426 AS Numeric(4, 0)), CAST(36.840 AS Numeric(7, 3)), CAST(1781.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1427 AS Numeric(4, 0)), CAST(36.850 AS Numeric(7, 3)), CAST(1785.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1428 AS Numeric(4, 0)), CAST(36.860 AS Numeric(7, 3)), CAST(1789.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1429 AS Numeric(4, 0)), CAST(36.870 AS Numeric(7, 3)), CAST(1793.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1430 AS Numeric(4, 0)), CAST(36.880 AS Numeric(7, 3)), CAST(1796.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1431 AS Numeric(4, 0)), CAST(36.890 AS Numeric(7, 3)), CAST(1800.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1432 AS Numeric(4, 0)), CAST(36.900 AS Numeric(7, 3)), CAST(1804.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1433 AS Numeric(4, 0)), CAST(36.910 AS Numeric(7, 3)), CAST(1808.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1434 AS Numeric(4, 0)), CAST(36.920 AS Numeric(7, 3)), CAST(1811.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1435 AS Numeric(4, 0)), CAST(36.930 AS Numeric(7, 3)), CAST(1815.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1436 AS Numeric(4, 0)), CAST(36.940 AS Numeric(7, 3)), CAST(1819.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1437 AS Numeric(4, 0)), CAST(36.950 AS Numeric(7, 3)), CAST(1823.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1438 AS Numeric(4, 0)), CAST(36.960 AS Numeric(7, 3)), CAST(1826.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1439 AS Numeric(4, 0)), CAST(36.970 AS Numeric(7, 3)), CAST(1830.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1440 AS Numeric(4, 0)), CAST(36.980 AS Numeric(7, 3)), CAST(1834.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1441 AS Numeric(4, 0)), CAST(36.990 AS Numeric(7, 3)), CAST(1838.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1442 AS Numeric(4, 0)), CAST(37.000 AS Numeric(7, 3)), CAST(1841.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1443 AS Numeric(4, 0)), CAST(37.010 AS Numeric(7, 3)), CAST(1845.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1444 AS Numeric(4, 0)), CAST(37.020 AS Numeric(7, 3)), CAST(1849.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1445 AS Numeric(4, 0)), CAST(37.030 AS Numeric(7, 3)), CAST(1853.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1446 AS Numeric(4, 0)), CAST(37.040 AS Numeric(7, 3)), CAST(1856.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1447 AS Numeric(4, 0)), CAST(37.050 AS Numeric(7, 3)), CAST(1860.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1448 AS Numeric(4, 0)), CAST(37.060 AS Numeric(7, 3)), CAST(1864.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1449 AS Numeric(4, 0)), CAST(37.070 AS Numeric(7, 3)), CAST(1868.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1450 AS Numeric(4, 0)), CAST(37.080 AS Numeric(7, 3)), CAST(1871.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1451 AS Numeric(4, 0)), CAST(37.090 AS Numeric(7, 3)), CAST(1875.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1452 AS Numeric(4, 0)), CAST(37.100 AS Numeric(7, 3)), CAST(1879.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1453 AS Numeric(4, 0)), CAST(37.110 AS Numeric(7, 3)), CAST(1883.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1454 AS Numeric(4, 0)), CAST(37.120 AS Numeric(7, 3)), CAST(1886.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1455 AS Numeric(4, 0)), CAST(37.130 AS Numeric(7, 3)), CAST(1890.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1456 AS Numeric(4, 0)), CAST(37.140 AS Numeric(7, 3)), CAST(1894.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1457 AS Numeric(4, 0)), CAST(37.150 AS Numeric(7, 3)), CAST(1898.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1458 AS Numeric(4, 0)), CAST(37.160 AS Numeric(7, 3)), CAST(1901.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1459 AS Numeric(4, 0)), CAST(37.170 AS Numeric(7, 3)), CAST(1905.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1460 AS Numeric(4, 0)), CAST(37.180 AS Numeric(7, 3)), CAST(1909.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1461 AS Numeric(4, 0)), CAST(37.190 AS Numeric(7, 3)), CAST(1913.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1462 AS Numeric(4, 0)), CAST(37.200 AS Numeric(7, 3)), CAST(1916.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1463 AS Numeric(4, 0)), CAST(37.210 AS Numeric(7, 3)), CAST(1920.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1464 AS Numeric(4, 0)), CAST(37.220 AS Numeric(7, 3)), CAST(1924.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1465 AS Numeric(4, 0)), CAST(37.230 AS Numeric(7, 3)), CAST(1928.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1466 AS Numeric(4, 0)), CAST(37.240 AS Numeric(7, 3)), CAST(1931.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1467 AS Numeric(4, 0)), CAST(37.250 AS Numeric(7, 3)), CAST(1935.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1468 AS Numeric(4, 0)), CAST(37.260 AS Numeric(7, 3)), CAST(1939.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1469 AS Numeric(4, 0)), CAST(37.270 AS Numeric(7, 3)), CAST(1943.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1470 AS Numeric(4, 0)), CAST(37.280 AS Numeric(7, 3)), CAST(1946.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1471 AS Numeric(4, 0)), CAST(37.290 AS Numeric(7, 3)), CAST(1950.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1472 AS Numeric(4, 0)), CAST(37.300 AS Numeric(7, 3)), CAST(1954.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1473 AS Numeric(4, 0)), CAST(37.310 AS Numeric(7, 3)), CAST(1958.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1474 AS Numeric(4, 0)), CAST(37.320 AS Numeric(7, 3)), CAST(1961.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1475 AS Numeric(4, 0)), CAST(37.330 AS Numeric(7, 3)), CAST(1965.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1476 AS Numeric(4, 0)), CAST(37.340 AS Numeric(7, 3)), CAST(1969.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1477 AS Numeric(4, 0)), CAST(37.350 AS Numeric(7, 3)), CAST(1973.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1478 AS Numeric(4, 0)), CAST(37.360 AS Numeric(7, 3)), CAST(1976.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1479 AS Numeric(4, 0)), CAST(37.370 AS Numeric(7, 3)), CAST(1980.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1480 AS Numeric(4, 0)), CAST(37.380 AS Numeric(7, 3)), CAST(1984.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1481 AS Numeric(4, 0)), CAST(37.390 AS Numeric(7, 3)), CAST(1988.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1482 AS Numeric(4, 0)), CAST(37.400 AS Numeric(7, 3)), CAST(1991.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1483 AS Numeric(4, 0)), CAST(37.410 AS Numeric(7, 3)), CAST(1995.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1484 AS Numeric(4, 0)), CAST(37.420 AS Numeric(7, 3)), CAST(1999.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1485 AS Numeric(4, 0)), CAST(37.430 AS Numeric(7, 3)), CAST(2003.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1486 AS Numeric(4, 0)), CAST(37.440 AS Numeric(7, 3)), CAST(2007.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1487 AS Numeric(4, 0)), CAST(37.450 AS Numeric(7, 3)), CAST(2011.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1488 AS Numeric(4, 0)), CAST(37.460 AS Numeric(7, 3)), CAST(2015.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1489 AS Numeric(4, 0)), CAST(37.470 AS Numeric(7, 3)), CAST(2019.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1490 AS Numeric(4, 0)), CAST(37.480 AS Numeric(7, 3)), CAST(2023.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1491 AS Numeric(4, 0)), CAST(37.490 AS Numeric(7, 3)), CAST(2027.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1492 AS Numeric(4, 0)), CAST(37.500 AS Numeric(7, 3)), CAST(2031.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1493 AS Numeric(4, 0)), CAST(37.510 AS Numeric(7, 3)), CAST(2035.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1494 AS Numeric(4, 0)), CAST(37.520 AS Numeric(7, 3)), CAST(2039.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1495 AS Numeric(4, 0)), CAST(37.530 AS Numeric(7, 3)), CAST(2043.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1496 AS Numeric(4, 0)), CAST(37.540 AS Numeric(7, 3)), CAST(2047.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1497 AS Numeric(4, 0)), CAST(37.550 AS Numeric(7, 3)), CAST(2051.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1498 AS Numeric(4, 0)), CAST(37.560 AS Numeric(7, 3)), CAST(2055.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1499 AS Numeric(4, 0)), CAST(37.570 AS Numeric(7, 3)), CAST(2059.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1500 AS Numeric(4, 0)), CAST(37.580 AS Numeric(7, 3)), CAST(2063.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1501 AS Numeric(4, 0)), CAST(37.590 AS Numeric(7, 3)), CAST(2067.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1502 AS Numeric(4, 0)), CAST(37.600 AS Numeric(7, 3)), CAST(2071.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1503 AS Numeric(4, 0)), CAST(37.610 AS Numeric(7, 3)), CAST(2075.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1504 AS Numeric(4, 0)), CAST(37.620 AS Numeric(7, 3)), CAST(2079.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1505 AS Numeric(4, 0)), CAST(37.630 AS Numeric(7, 3)), CAST(2083.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1506 AS Numeric(4, 0)), CAST(37.640 AS Numeric(7, 3)), CAST(2087.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1507 AS Numeric(4, 0)), CAST(37.650 AS Numeric(7, 3)), CAST(2091.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1508 AS Numeric(4, 0)), CAST(37.660 AS Numeric(7, 3)), CAST(2095.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1509 AS Numeric(4, 0)), CAST(37.670 AS Numeric(7, 3)), CAST(2099.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1510 AS Numeric(4, 0)), CAST(37.680 AS Numeric(7, 3)), CAST(2103.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1511 AS Numeric(4, 0)), CAST(37.690 AS Numeric(7, 3)), CAST(2107.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1512 AS Numeric(4, 0)), CAST(37.700 AS Numeric(7, 3)), CAST(2111.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1513 AS Numeric(4, 0)), CAST(37.710 AS Numeric(7, 3)), CAST(2116.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1514 AS Numeric(4, 0)), CAST(37.720 AS Numeric(7, 3)), CAST(2120.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1515 AS Numeric(4, 0)), CAST(37.730 AS Numeric(7, 3)), CAST(2125.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1516 AS Numeric(4, 0)), CAST(37.740 AS Numeric(7, 3)), CAST(2129.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1517 AS Numeric(4, 0)), CAST(37.750 AS Numeric(7, 3)), CAST(2134.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1518 AS Numeric(4, 0)), CAST(37.760 AS Numeric(7, 3)), CAST(2138.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1519 AS Numeric(4, 0)), CAST(37.770 AS Numeric(7, 3)), CAST(2143.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1520 AS Numeric(4, 0)), CAST(37.780 AS Numeric(7, 3)), CAST(2147.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1521 AS Numeric(4, 0)), CAST(37.790 AS Numeric(7, 3)), CAST(2152.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1522 AS Numeric(4, 0)), CAST(37.800 AS Numeric(7, 3)), CAST(2156.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1523 AS Numeric(4, 0)), CAST(37.810 AS Numeric(7, 3)), CAST(2161.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1524 AS Numeric(4, 0)), CAST(37.820 AS Numeric(7, 3)), CAST(2165.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1525 AS Numeric(4, 0)), CAST(37.830 AS Numeric(7, 3)), CAST(2170.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1526 AS Numeric(4, 0)), CAST(37.840 AS Numeric(7, 3)), CAST(2174.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1527 AS Numeric(4, 0)), CAST(37.850 AS Numeric(7, 3)), CAST(2179.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1528 AS Numeric(4, 0)), CAST(37.860 AS Numeric(7, 3)), CAST(2183.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1529 AS Numeric(4, 0)), CAST(37.870 AS Numeric(7, 3)), CAST(2188.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1530 AS Numeric(4, 0)), CAST(37.880 AS Numeric(7, 3)), CAST(2192.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1531 AS Numeric(4, 0)), CAST(37.890 AS Numeric(7, 3)), CAST(2197.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1532 AS Numeric(4, 0)), CAST(37.900 AS Numeric(7, 3)), CAST(2201.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1533 AS Numeric(4, 0)), CAST(37.910 AS Numeric(7, 3)), CAST(2206.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1534 AS Numeric(4, 0)), CAST(37.920 AS Numeric(7, 3)), CAST(2210.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1535 AS Numeric(4, 0)), CAST(37.930 AS Numeric(7, 3)), CAST(2215.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1536 AS Numeric(4, 0)), CAST(37.940 AS Numeric(7, 3)), CAST(2219.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1537 AS Numeric(4, 0)), CAST(37.950 AS Numeric(7, 3)), CAST(2224.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1538 AS Numeric(4, 0)), CAST(37.960 AS Numeric(7, 3)), CAST(2228.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1539 AS Numeric(4, 0)), CAST(37.970 AS Numeric(7, 3)), CAST(2233.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1540 AS Numeric(4, 0)), CAST(37.980 AS Numeric(7, 3)), CAST(2237.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1541 AS Numeric(4, 0)), CAST(37.990 AS Numeric(7, 3)), CAST(2242.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1542 AS Numeric(4, 0)), CAST(38.000 AS Numeric(7, 3)), CAST(2246.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1543 AS Numeric(4, 0)), CAST(38.010 AS Numeric(7, 3)), CAST(2251.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1544 AS Numeric(4, 0)), CAST(38.020 AS Numeric(7, 3)), CAST(2255.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1545 AS Numeric(4, 0)), CAST(38.030 AS Numeric(7, 3)), CAST(2260.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1546 AS Numeric(4, 0)), CAST(38.040 AS Numeric(7, 3)), CAST(2264.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1547 AS Numeric(4, 0)), CAST(38.050 AS Numeric(7, 3)), CAST(2269.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1548 AS Numeric(4, 0)), CAST(38.060 AS Numeric(7, 3)), CAST(2273.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1549 AS Numeric(4, 0)), CAST(38.070 AS Numeric(7, 3)), CAST(2278.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1550 AS Numeric(4, 0)), CAST(38.080 AS Numeric(7, 3)), CAST(2282.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1551 AS Numeric(4, 0)), CAST(38.090 AS Numeric(7, 3)), CAST(2287.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1552 AS Numeric(4, 0)), CAST(38.100 AS Numeric(7, 3)), CAST(2291.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1553 AS Numeric(4, 0)), CAST(38.110 AS Numeric(7, 3)), CAST(2296.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1554 AS Numeric(4, 0)), CAST(38.120 AS Numeric(7, 3)), CAST(2300.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1555 AS Numeric(4, 0)), CAST(38.130 AS Numeric(7, 3)), CAST(2305.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1556 AS Numeric(4, 0)), CAST(38.140 AS Numeric(7, 3)), CAST(2309.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1557 AS Numeric(4, 0)), CAST(38.150 AS Numeric(7, 3)), CAST(2314.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1558 AS Numeric(4, 0)), CAST(38.160 AS Numeric(7, 3)), CAST(2318.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1559 AS Numeric(4, 0)), CAST(38.170 AS Numeric(7, 3)), CAST(2323.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1560 AS Numeric(4, 0)), CAST(38.180 AS Numeric(7, 3)), CAST(2327.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1561 AS Numeric(4, 0)), CAST(38.190 AS Numeric(7, 3)), CAST(2332.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1562 AS Numeric(4, 0)), CAST(38.200 AS Numeric(7, 3)), CAST(2336.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1563 AS Numeric(4, 0)), CAST(38.210 AS Numeric(7, 3)), CAST(2341.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1564 AS Numeric(4, 0)), CAST(38.220 AS Numeric(7, 3)), CAST(2345.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1565 AS Numeric(4, 0)), CAST(38.230 AS Numeric(7, 3)), CAST(2350.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1566 AS Numeric(4, 0)), CAST(38.240 AS Numeric(7, 3)), CAST(2354.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1567 AS Numeric(4, 0)), CAST(38.250 AS Numeric(7, 3)), CAST(2359.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1568 AS Numeric(4, 0)), CAST(38.260 AS Numeric(7, 3)), CAST(2363.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1569 AS Numeric(4, 0)), CAST(38.270 AS Numeric(7, 3)), CAST(2368.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1570 AS Numeric(4, 0)), CAST(38.280 AS Numeric(7, 3)), CAST(2372.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1571 AS Numeric(4, 0)), CAST(38.290 AS Numeric(7, 3)), CAST(2377.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1572 AS Numeric(4, 0)), CAST(38.300 AS Numeric(7, 3)), CAST(2381.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1573 AS Numeric(4, 0)), CAST(38.310 AS Numeric(7, 3)), CAST(2386.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1574 AS Numeric(4, 0)), CAST(38.320 AS Numeric(7, 3)), CAST(2390.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1575 AS Numeric(4, 0)), CAST(38.330 AS Numeric(7, 3)), CAST(2395.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1576 AS Numeric(4, 0)), CAST(38.340 AS Numeric(7, 3)), CAST(2399.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1577 AS Numeric(4, 0)), CAST(38.350 AS Numeric(7, 3)), CAST(2404.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1578 AS Numeric(4, 0)), CAST(38.360 AS Numeric(7, 3)), CAST(2408.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1579 AS Numeric(4, 0)), CAST(38.370 AS Numeric(7, 3)), CAST(2413.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1580 AS Numeric(4, 0)), CAST(38.380 AS Numeric(7, 3)), CAST(2417.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1581 AS Numeric(4, 0)), CAST(38.390 AS Numeric(7, 3)), CAST(2422.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1582 AS Numeric(4, 0)), CAST(38.400 AS Numeric(7, 3)), CAST(2426.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1583 AS Numeric(4, 0)), CAST(38.410 AS Numeric(7, 3)), CAST(2431.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1584 AS Numeric(4, 0)), CAST(38.420 AS Numeric(7, 3)), CAST(2435.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1585 AS Numeric(4, 0)), CAST(38.430 AS Numeric(7, 3)), CAST(2440.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1586 AS Numeric(4, 0)), CAST(38.440 AS Numeric(7, 3)), CAST(2444.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1587 AS Numeric(4, 0)), CAST(38.450 AS Numeric(7, 3)), CAST(2449.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1588 AS Numeric(4, 0)), CAST(38.460 AS Numeric(7, 3)), CAST(2453.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1589 AS Numeric(4, 0)), CAST(38.470 AS Numeric(7, 3)), CAST(2458.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1590 AS Numeric(4, 0)), CAST(38.480 AS Numeric(7, 3)), CAST(2463.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1591 AS Numeric(4, 0)), CAST(38.490 AS Numeric(7, 3)), CAST(2468.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1592 AS Numeric(4, 0)), CAST(38.500 AS Numeric(7, 3)), CAST(2473.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1593 AS Numeric(4, 0)), CAST(38.510 AS Numeric(7, 3)), CAST(2478.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1594 AS Numeric(4, 0)), CAST(38.520 AS Numeric(7, 3)), CAST(2483.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1595 AS Numeric(4, 0)), CAST(38.530 AS Numeric(7, 3)), CAST(2488.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1596 AS Numeric(4, 0)), CAST(38.540 AS Numeric(7, 3)), CAST(2493.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1597 AS Numeric(4, 0)), CAST(38.550 AS Numeric(7, 3)), CAST(2498.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1598 AS Numeric(4, 0)), CAST(38.560 AS Numeric(7, 3)), CAST(2503.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1599 AS Numeric(4, 0)), CAST(38.570 AS Numeric(7, 3)), CAST(2508.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1600 AS Numeric(4, 0)), CAST(38.580 AS Numeric(7, 3)), CAST(2513.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1601 AS Numeric(4, 0)), CAST(38.590 AS Numeric(7, 3)), CAST(2518.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1602 AS Numeric(4, 0)), CAST(38.600 AS Numeric(7, 3)), CAST(2523.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1603 AS Numeric(4, 0)), CAST(38.610 AS Numeric(7, 3)), CAST(2528.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1604 AS Numeric(4, 0)), CAST(38.620 AS Numeric(7, 3)), CAST(2533.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1605 AS Numeric(4, 0)), CAST(38.630 AS Numeric(7, 3)), CAST(2538.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1606 AS Numeric(4, 0)), CAST(38.640 AS Numeric(7, 3)), CAST(2543.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1607 AS Numeric(4, 0)), CAST(38.650 AS Numeric(7, 3)), CAST(2548.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1608 AS Numeric(4, 0)), CAST(38.660 AS Numeric(7, 3)), CAST(2553.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1609 AS Numeric(4, 0)), CAST(38.670 AS Numeric(7, 3)), CAST(2558.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1610 AS Numeric(4, 0)), CAST(38.680 AS Numeric(7, 3)), CAST(2563.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1611 AS Numeric(4, 0)), CAST(38.690 AS Numeric(7, 3)), CAST(2568.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1612 AS Numeric(4, 0)), CAST(38.700 AS Numeric(7, 3)), CAST(2573.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1613 AS Numeric(4, 0)), CAST(38.710 AS Numeric(7, 3)), CAST(2578.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1614 AS Numeric(4, 0)), CAST(38.720 AS Numeric(7, 3)), CAST(2583.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1615 AS Numeric(4, 0)), CAST(38.730 AS Numeric(7, 3)), CAST(2588.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1616 AS Numeric(4, 0)), CAST(38.740 AS Numeric(7, 3)), CAST(2593.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1617 AS Numeric(4, 0)), CAST(38.750 AS Numeric(7, 3)), CAST(2598.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1618 AS Numeric(4, 0)), CAST(38.760 AS Numeric(7, 3)), CAST(2603.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1619 AS Numeric(4, 0)), CAST(38.770 AS Numeric(7, 3)), CAST(2608.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1620 AS Numeric(4, 0)), CAST(38.780 AS Numeric(7, 3)), CAST(2613.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1621 AS Numeric(4, 0)), CAST(38.790 AS Numeric(7, 3)), CAST(2618.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1622 AS Numeric(4, 0)), CAST(38.800 AS Numeric(7, 3)), CAST(2623.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1623 AS Numeric(4, 0)), CAST(38.810 AS Numeric(7, 3)), CAST(2628.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1624 AS Numeric(4, 0)), CAST(38.820 AS Numeric(7, 3)), CAST(2633.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1625 AS Numeric(4, 0)), CAST(38.830 AS Numeric(7, 3)), CAST(2638.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1626 AS Numeric(4, 0)), CAST(38.840 AS Numeric(7, 3)), CAST(2643.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1627 AS Numeric(4, 0)), CAST(38.850 AS Numeric(7, 3)), CAST(2648.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1628 AS Numeric(4, 0)), CAST(38.860 AS Numeric(7, 3)), CAST(2653.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1629 AS Numeric(4, 0)), CAST(38.870 AS Numeric(7, 3)), CAST(2658.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1630 AS Numeric(4, 0)), CAST(38.880 AS Numeric(7, 3)), CAST(2663.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1631 AS Numeric(4, 0)), CAST(38.890 AS Numeric(7, 3)), CAST(2668.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1632 AS Numeric(4, 0)), CAST(38.900 AS Numeric(7, 3)), CAST(2673.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1633 AS Numeric(4, 0)), CAST(38.910 AS Numeric(7, 3)), CAST(2678.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1634 AS Numeric(4, 0)), CAST(38.920 AS Numeric(7, 3)), CAST(2683.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1635 AS Numeric(4, 0)), CAST(38.930 AS Numeric(7, 3)), CAST(2688.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1636 AS Numeric(4, 0)), CAST(38.940 AS Numeric(7, 3)), CAST(2693.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1637 AS Numeric(4, 0)), CAST(38.950 AS Numeric(7, 3)), CAST(2698.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1638 AS Numeric(4, 0)), CAST(38.960 AS Numeric(7, 3)), CAST(2703.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1639 AS Numeric(4, 0)), CAST(38.970 AS Numeric(7, 3)), CAST(2708.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1640 AS Numeric(4, 0)), CAST(38.980 AS Numeric(7, 3)), CAST(2713.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1641 AS Numeric(4, 0)), CAST(38.990 AS Numeric(7, 3)), CAST(2718.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1642 AS Numeric(4, 0)), CAST(39.000 AS Numeric(7, 3)), CAST(2723.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1643 AS Numeric(4, 0)), CAST(39.010 AS Numeric(7, 3)), CAST(2728.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1644 AS Numeric(4, 0)), CAST(39.020 AS Numeric(7, 3)), CAST(2733.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1645 AS Numeric(4, 0)), CAST(39.030 AS Numeric(7, 3)), CAST(2738.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1646 AS Numeric(4, 0)), CAST(39.040 AS Numeric(7, 3)), CAST(2743.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1647 AS Numeric(4, 0)), CAST(39.050 AS Numeric(7, 3)), CAST(2748.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1648 AS Numeric(4, 0)), CAST(39.060 AS Numeric(7, 3)), CAST(2753.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1649 AS Numeric(4, 0)), CAST(39.070 AS Numeric(7, 3)), CAST(2758.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1650 AS Numeric(4, 0)), CAST(39.080 AS Numeric(7, 3)), CAST(2763.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1651 AS Numeric(4, 0)), CAST(39.090 AS Numeric(7, 3)), CAST(2768.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1652 AS Numeric(4, 0)), CAST(39.100 AS Numeric(7, 3)), CAST(2773.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1653 AS Numeric(4, 0)), CAST(39.110 AS Numeric(7, 3)), CAST(2778.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1654 AS Numeric(4, 0)), CAST(39.120 AS Numeric(7, 3)), CAST(2783.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1655 AS Numeric(4, 0)), CAST(39.130 AS Numeric(7, 3)), CAST(2788.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1656 AS Numeric(4, 0)), CAST(39.140 AS Numeric(7, 3)), CAST(2793.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1657 AS Numeric(4, 0)), CAST(39.150 AS Numeric(7, 3)), CAST(2798.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1658 AS Numeric(4, 0)), CAST(39.160 AS Numeric(7, 3)), CAST(2803.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1659 AS Numeric(4, 0)), CAST(39.170 AS Numeric(7, 3)), CAST(2808.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1660 AS Numeric(4, 0)), CAST(39.180 AS Numeric(7, 3)), CAST(2813.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1661 AS Numeric(4, 0)), CAST(39.190 AS Numeric(7, 3)), CAST(2818.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1662 AS Numeric(4, 0)), CAST(39.200 AS Numeric(7, 3)), CAST(2823.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1663 AS Numeric(4, 0)), CAST(39.210 AS Numeric(7, 3)), CAST(2828.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1664 AS Numeric(4, 0)), CAST(39.220 AS Numeric(7, 3)), CAST(2833.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1665 AS Numeric(4, 0)), CAST(39.230 AS Numeric(7, 3)), CAST(2838.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1666 AS Numeric(4, 0)), CAST(39.240 AS Numeric(7, 3)), CAST(2843.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1667 AS Numeric(4, 0)), CAST(39.250 AS Numeric(7, 3)), CAST(2849.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1668 AS Numeric(4, 0)), CAST(39.260 AS Numeric(7, 3)), CAST(2854.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1669 AS Numeric(4, 0)), CAST(39.270 AS Numeric(7, 3)), CAST(2859.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1670 AS Numeric(4, 0)), CAST(39.280 AS Numeric(7, 3)), CAST(2864.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1671 AS Numeric(4, 0)), CAST(39.290 AS Numeric(7, 3)), CAST(2870.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1672 AS Numeric(4, 0)), CAST(39.300 AS Numeric(7, 3)), CAST(2875.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1673 AS Numeric(4, 0)), CAST(39.310 AS Numeric(7, 3)), CAST(2880.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1674 AS Numeric(4, 0)), CAST(39.320 AS Numeric(7, 3)), CAST(2885.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1675 AS Numeric(4, 0)), CAST(39.330 AS Numeric(7, 3)), CAST(2891.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1676 AS Numeric(4, 0)), CAST(39.340 AS Numeric(7, 3)), CAST(2896.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1677 AS Numeric(4, 0)), CAST(39.350 AS Numeric(7, 3)), CAST(2901.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1678 AS Numeric(4, 0)), CAST(39.360 AS Numeric(7, 3)), CAST(2906.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1679 AS Numeric(4, 0)), CAST(39.370 AS Numeric(7, 3)), CAST(2912.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1680 AS Numeric(4, 0)), CAST(39.380 AS Numeric(7, 3)), CAST(2917.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1681 AS Numeric(4, 0)), CAST(39.390 AS Numeric(7, 3)), CAST(2922.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1682 AS Numeric(4, 0)), CAST(39.400 AS Numeric(7, 3)), CAST(2927.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1683 AS Numeric(4, 0)), CAST(39.410 AS Numeric(7, 3)), CAST(2933.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1684 AS Numeric(4, 0)), CAST(39.420 AS Numeric(7, 3)), CAST(2938.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1685 AS Numeric(4, 0)), CAST(39.430 AS Numeric(7, 3)), CAST(2944.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1686 AS Numeric(4, 0)), CAST(39.440 AS Numeric(7, 3)), CAST(2949.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1687 AS Numeric(4, 0)), CAST(39.450 AS Numeric(7, 3)), CAST(2955.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1688 AS Numeric(4, 0)), CAST(39.460 AS Numeric(7, 3)), CAST(2960.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1689 AS Numeric(4, 0)), CAST(39.470 AS Numeric(7, 3)), CAST(2966.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1690 AS Numeric(4, 0)), CAST(39.480 AS Numeric(7, 3)), CAST(2971.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1691 AS Numeric(4, 0)), CAST(39.490 AS Numeric(7, 3)), CAST(2977.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1692 AS Numeric(4, 0)), CAST(39.500 AS Numeric(7, 3)), CAST(2982.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1693 AS Numeric(4, 0)), CAST(39.510 AS Numeric(7, 3)), CAST(2988.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1694 AS Numeric(4, 0)), CAST(39.520 AS Numeric(7, 3)), CAST(2993.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1695 AS Numeric(4, 0)), CAST(39.530 AS Numeric(7, 3)), CAST(2999.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1696 AS Numeric(4, 0)), CAST(39.540 AS Numeric(7, 3)), CAST(3004.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1697 AS Numeric(4, 0)), CAST(39.550 AS Numeric(7, 3)), CAST(3010.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1698 AS Numeric(4, 0)), CAST(39.560 AS Numeric(7, 3)), CAST(3015.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1699 AS Numeric(4, 0)), CAST(39.570 AS Numeric(7, 3)), CAST(3021.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1700 AS Numeric(4, 0)), CAST(39.580 AS Numeric(7, 3)), CAST(3026.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1701 AS Numeric(4, 0)), CAST(39.590 AS Numeric(7, 3)), CAST(3032.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1702 AS Numeric(4, 0)), CAST(39.600 AS Numeric(7, 3)), CAST(3037.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1703 AS Numeric(4, 0)), CAST(39.610 AS Numeric(7, 3)), CAST(3043.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1704 AS Numeric(4, 0)), CAST(39.620 AS Numeric(7, 3)), CAST(3048.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1705 AS Numeric(4, 0)), CAST(39.630 AS Numeric(7, 3)), CAST(3054.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1706 AS Numeric(4, 0)), CAST(39.640 AS Numeric(7, 3)), CAST(3059.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1707 AS Numeric(4, 0)), CAST(39.650 AS Numeric(7, 3)), CAST(3065.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1708 AS Numeric(4, 0)), CAST(39.660 AS Numeric(7, 3)), CAST(3070.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1709 AS Numeric(4, 0)), CAST(39.670 AS Numeric(7, 3)), CAST(3076.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1710 AS Numeric(4, 0)), CAST(39.680 AS Numeric(7, 3)), CAST(3081.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1711 AS Numeric(4, 0)), CAST(39.690 AS Numeric(7, 3)), CAST(3087.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1712 AS Numeric(4, 0)), CAST(39.700 AS Numeric(7, 3)), CAST(3092.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1713 AS Numeric(4, 0)), CAST(39.710 AS Numeric(7, 3)), CAST(3098.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1714 AS Numeric(4, 0)), CAST(39.720 AS Numeric(7, 3)), CAST(3103.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1715 AS Numeric(4, 0)), CAST(39.730 AS Numeric(7, 3)), CAST(3109.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1716 AS Numeric(4, 0)), CAST(39.740 AS Numeric(7, 3)), CAST(3114.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1717 AS Numeric(4, 0)), CAST(39.750 AS Numeric(7, 3)), CAST(3120.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1718 AS Numeric(4, 0)), CAST(39.760 AS Numeric(7, 3)), CAST(3125.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1719 AS Numeric(4, 0)), CAST(39.770 AS Numeric(7, 3)), CAST(3131.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1720 AS Numeric(4, 0)), CAST(39.780 AS Numeric(7, 3)), CAST(3136.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1721 AS Numeric(4, 0)), CAST(39.790 AS Numeric(7, 3)), CAST(3142.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1722 AS Numeric(4, 0)), CAST(39.800 AS Numeric(7, 3)), CAST(3147.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1723 AS Numeric(4, 0)), CAST(39.810 AS Numeric(7, 3)), CAST(3153.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1724 AS Numeric(4, 0)), CAST(39.820 AS Numeric(7, 3)), CAST(3158.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1725 AS Numeric(4, 0)), CAST(39.830 AS Numeric(7, 3)), CAST(3164.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1726 AS Numeric(4, 0)), CAST(39.840 AS Numeric(7, 3)), CAST(3169.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1727 AS Numeric(4, 0)), CAST(39.850 AS Numeric(7, 3)), CAST(3175.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1728 AS Numeric(4, 0)), CAST(39.860 AS Numeric(7, 3)), CAST(3180.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1729 AS Numeric(4, 0)), CAST(39.870 AS Numeric(7, 3)), CAST(3186.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1730 AS Numeric(4, 0)), CAST(39.880 AS Numeric(7, 3)), CAST(3191.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'sy      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1731 AS Numeric(4, 0)), CAST(39.890 AS Numeric(7, 3)), CAST(3197.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1732 AS Numeric(4, 0)), CAST(8.000 AS Numeric(7, 3)), CAST(0.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1733 AS Numeric(4, 0)), CAST(8.010 AS Numeric(7, 3)), CAST(0.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1734 AS Numeric(4, 0)), CAST(8.020 AS Numeric(7, 3)), CAST(0.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1735 AS Numeric(4, 0)), CAST(8.030 AS Numeric(7, 3)), CAST(0.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1736 AS Numeric(4, 0)), CAST(8.040 AS Numeric(7, 3)), CAST(0.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1737 AS Numeric(4, 0)), CAST(8.050 AS Numeric(7, 3)), CAST(0.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1738 AS Numeric(4, 0)), CAST(8.060 AS Numeric(7, 3)), CAST(0.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1739 AS Numeric(4, 0)), CAST(8.070 AS Numeric(7, 3)), CAST(0.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1740 AS Numeric(4, 0)), CAST(8.080 AS Numeric(7, 3)), CAST(0.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1741 AS Numeric(4, 0)), CAST(8.090 AS Numeric(7, 3)), CAST(0.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1742 AS Numeric(4, 0)), CAST(8.100 AS Numeric(7, 3)), CAST(0.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1743 AS Numeric(4, 0)), CAST(8.110 AS Numeric(7, 3)), CAST(0.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1744 AS Numeric(4, 0)), CAST(8.120 AS Numeric(7, 3)), CAST(0.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1745 AS Numeric(4, 0)), CAST(8.130 AS Numeric(7, 3)), CAST(0.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1746 AS Numeric(4, 0)), CAST(8.140 AS Numeric(7, 3)), CAST(0.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1747 AS Numeric(4, 0)), CAST(8.150 AS Numeric(7, 3)), CAST(0.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1748 AS Numeric(4, 0)), CAST(8.160 AS Numeric(7, 3)), CAST(0.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1749 AS Numeric(4, 0)), CAST(8.170 AS Numeric(7, 3)), CAST(0.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1750 AS Numeric(4, 0)), CAST(8.180 AS Numeric(7, 3)), CAST(0.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1751 AS Numeric(4, 0)), CAST(8.190 AS Numeric(7, 3)), CAST(0.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1752 AS Numeric(4, 0)), CAST(8.200 AS Numeric(7, 3)), CAST(0.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1753 AS Numeric(4, 0)), CAST(8.210 AS Numeric(7, 3)), CAST(0.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1754 AS Numeric(4, 0)), CAST(8.220 AS Numeric(7, 3)), CAST(0.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1755 AS Numeric(4, 0)), CAST(8.230 AS Numeric(7, 3)), CAST(0.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1756 AS Numeric(4, 0)), CAST(8.240 AS Numeric(7, 3)), CAST(0.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1757 AS Numeric(4, 0)), CAST(8.250 AS Numeric(7, 3)), CAST(0.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1758 AS Numeric(4, 0)), CAST(8.260 AS Numeric(7, 3)), CAST(0.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1759 AS Numeric(4, 0)), CAST(8.270 AS Numeric(7, 3)), CAST(0.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1760 AS Numeric(4, 0)), CAST(8.280 AS Numeric(7, 3)), CAST(0.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1761 AS Numeric(4, 0)), CAST(8.290 AS Numeric(7, 3)), CAST(0.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1762 AS Numeric(4, 0)), CAST(8.300 AS Numeric(7, 3)), CAST(0.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1763 AS Numeric(4, 0)), CAST(8.310 AS Numeric(7, 3)), CAST(0.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1764 AS Numeric(4, 0)), CAST(8.320 AS Numeric(7, 3)), CAST(0.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1765 AS Numeric(4, 0)), CAST(8.330 AS Numeric(7, 3)), CAST(0.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1766 AS Numeric(4, 0)), CAST(8.340 AS Numeric(7, 3)), CAST(0.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1767 AS Numeric(4, 0)), CAST(8.350 AS Numeric(7, 3)), CAST(0.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1768 AS Numeric(4, 0)), CAST(8.360 AS Numeric(7, 3)), CAST(0.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1769 AS Numeric(4, 0)), CAST(8.370 AS Numeric(7, 3)), CAST(0.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1770 AS Numeric(4, 0)), CAST(8.380 AS Numeric(7, 3)), CAST(0.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1771 AS Numeric(4, 0)), CAST(8.390 AS Numeric(7, 3)), CAST(0.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1772 AS Numeric(4, 0)), CAST(8.400 AS Numeric(7, 3)), CAST(0.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1773 AS Numeric(4, 0)), CAST(8.410 AS Numeric(7, 3)), CAST(0.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1774 AS Numeric(4, 0)), CAST(8.420 AS Numeric(7, 3)), CAST(0.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1775 AS Numeric(4, 0)), CAST(8.430 AS Numeric(7, 3)), CAST(0.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1776 AS Numeric(4, 0)), CAST(8.440 AS Numeric(7, 3)), CAST(0.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1777 AS Numeric(4, 0)), CAST(8.450 AS Numeric(7, 3)), CAST(0.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1778 AS Numeric(4, 0)), CAST(8.460 AS Numeric(7, 3)), CAST(0.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1779 AS Numeric(4, 0)), CAST(8.470 AS Numeric(7, 3)), CAST(0.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1780 AS Numeric(4, 0)), CAST(8.480 AS Numeric(7, 3)), CAST(0.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1781 AS Numeric(4, 0)), CAST(8.490 AS Numeric(7, 3)), CAST(0.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1782 AS Numeric(4, 0)), CAST(8.500 AS Numeric(7, 3)), CAST(0.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1783 AS Numeric(4, 0)), CAST(8.510 AS Numeric(7, 3)), CAST(0.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1784 AS Numeric(4, 0)), CAST(8.520 AS Numeric(7, 3)), CAST(0.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1785 AS Numeric(4, 0)), CAST(8.530 AS Numeric(7, 3)), CAST(0.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1786 AS Numeric(4, 0)), CAST(8.540 AS Numeric(7, 3)), CAST(0.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1787 AS Numeric(4, 0)), CAST(8.550 AS Numeric(7, 3)), CAST(0.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1788 AS Numeric(4, 0)), CAST(8.560 AS Numeric(7, 3)), CAST(0.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1789 AS Numeric(4, 0)), CAST(8.570 AS Numeric(7, 3)), CAST(0.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1790 AS Numeric(4, 0)), CAST(8.580 AS Numeric(7, 3)), CAST(0.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1791 AS Numeric(4, 0)), CAST(8.590 AS Numeric(7, 3)), CAST(0.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1792 AS Numeric(4, 0)), CAST(8.600 AS Numeric(7, 3)), CAST(0.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1793 AS Numeric(4, 0)), CAST(8.610 AS Numeric(7, 3)), CAST(0.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1794 AS Numeric(4, 0)), CAST(8.620 AS Numeric(7, 3)), CAST(0.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1795 AS Numeric(4, 0)), CAST(8.630 AS Numeric(7, 3)), CAST(0.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1796 AS Numeric(4, 0)), CAST(8.640 AS Numeric(7, 3)), CAST(0.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1797 AS Numeric(4, 0)), CAST(8.650 AS Numeric(7, 3)), CAST(0.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1798 AS Numeric(4, 0)), CAST(8.660 AS Numeric(7, 3)), CAST(0.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1799 AS Numeric(4, 0)), CAST(8.670 AS Numeric(7, 3)), CAST(0.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1800 AS Numeric(4, 0)), CAST(8.680 AS Numeric(7, 3)), CAST(0.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1801 AS Numeric(4, 0)), CAST(8.690 AS Numeric(7, 3)), CAST(0.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1802 AS Numeric(4, 0)), CAST(8.700 AS Numeric(7, 3)), CAST(0.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1803 AS Numeric(4, 0)), CAST(8.710 AS Numeric(7, 3)), CAST(0.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1804 AS Numeric(4, 0)), CAST(8.720 AS Numeric(7, 3)), CAST(0.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1805 AS Numeric(4, 0)), CAST(8.730 AS Numeric(7, 3)), CAST(0.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1806 AS Numeric(4, 0)), CAST(8.740 AS Numeric(7, 3)), CAST(0.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1807 AS Numeric(4, 0)), CAST(8.750 AS Numeric(7, 3)), CAST(0.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1808 AS Numeric(4, 0)), CAST(8.760 AS Numeric(7, 3)), CAST(0.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1809 AS Numeric(4, 0)), CAST(8.770 AS Numeric(7, 3)), CAST(0.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1810 AS Numeric(4, 0)), CAST(8.780 AS Numeric(7, 3)), CAST(0.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1811 AS Numeric(4, 0)), CAST(8.790 AS Numeric(7, 3)), CAST(0.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1812 AS Numeric(4, 0)), CAST(8.800 AS Numeric(7, 3)), CAST(0.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1813 AS Numeric(4, 0)), CAST(8.810 AS Numeric(7, 3)), CAST(0.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1814 AS Numeric(4, 0)), CAST(8.820 AS Numeric(7, 3)), CAST(0.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1815 AS Numeric(4, 0)), CAST(8.830 AS Numeric(7, 3)), CAST(0.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1816 AS Numeric(4, 0)), CAST(8.840 AS Numeric(7, 3)), CAST(0.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1817 AS Numeric(4, 0)), CAST(8.850 AS Numeric(7, 3)), CAST(0.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1818 AS Numeric(4, 0)), CAST(8.860 AS Numeric(7, 3)), CAST(0.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1819 AS Numeric(4, 0)), CAST(8.870 AS Numeric(7, 3)), CAST(0.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1820 AS Numeric(4, 0)), CAST(8.880 AS Numeric(7, 3)), CAST(0.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1821 AS Numeric(4, 0)), CAST(8.890 AS Numeric(7, 3)), CAST(0.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1822 AS Numeric(4, 0)), CAST(8.900 AS Numeric(7, 3)), CAST(0.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1823 AS Numeric(4, 0)), CAST(8.910 AS Numeric(7, 3)), CAST(0.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1824 AS Numeric(4, 0)), CAST(8.920 AS Numeric(7, 3)), CAST(0.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1825 AS Numeric(4, 0)), CAST(8.930 AS Numeric(7, 3)), CAST(0.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1826 AS Numeric(4, 0)), CAST(8.940 AS Numeric(7, 3)), CAST(0.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1827 AS Numeric(4, 0)), CAST(8.950 AS Numeric(7, 3)), CAST(0.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1828 AS Numeric(4, 0)), CAST(8.960 AS Numeric(7, 3)), CAST(0.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1829 AS Numeric(4, 0)), CAST(8.970 AS Numeric(7, 3)), CAST(0.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1830 AS Numeric(4, 0)), CAST(8.980 AS Numeric(7, 3)), CAST(0.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1831 AS Numeric(4, 0)), CAST(8.990 AS Numeric(7, 3)), CAST(0.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1832 AS Numeric(4, 0)), CAST(9.000 AS Numeric(7, 3)), CAST(0.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1833 AS Numeric(4, 0)), CAST(9.010 AS Numeric(7, 3)), CAST(0.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1834 AS Numeric(4, 0)), CAST(9.020 AS Numeric(7, 3)), CAST(0.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1835 AS Numeric(4, 0)), CAST(9.030 AS Numeric(7, 3)), CAST(0.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1836 AS Numeric(4, 0)), CAST(9.040 AS Numeric(7, 3)), CAST(0.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1837 AS Numeric(4, 0)), CAST(9.050 AS Numeric(7, 3)), CAST(0.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1838 AS Numeric(4, 0)), CAST(9.060 AS Numeric(7, 3)), CAST(0.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1839 AS Numeric(4, 0)), CAST(9.070 AS Numeric(7, 3)), CAST(0.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1840 AS Numeric(4, 0)), CAST(9.080 AS Numeric(7, 3)), CAST(0.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1841 AS Numeric(4, 0)), CAST(9.090 AS Numeric(7, 3)), CAST(0.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1842 AS Numeric(4, 0)), CAST(9.100 AS Numeric(7, 3)), CAST(0.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1843 AS Numeric(4, 0)), CAST(9.110 AS Numeric(7, 3)), CAST(0.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1844 AS Numeric(4, 0)), CAST(9.120 AS Numeric(7, 3)), CAST(0.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1845 AS Numeric(4, 0)), CAST(9.130 AS Numeric(7, 3)), CAST(0.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1846 AS Numeric(4, 0)), CAST(9.140 AS Numeric(7, 3)), CAST(0.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1847 AS Numeric(4, 0)), CAST(9.150 AS Numeric(7, 3)), CAST(0.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1848 AS Numeric(4, 0)), CAST(9.160 AS Numeric(7, 3)), CAST(0.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1849 AS Numeric(4, 0)), CAST(9.170 AS Numeric(7, 3)), CAST(0.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1850 AS Numeric(4, 0)), CAST(9.180 AS Numeric(7, 3)), CAST(0.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1851 AS Numeric(4, 0)), CAST(9.190 AS Numeric(7, 3)), CAST(0.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1852 AS Numeric(4, 0)), CAST(9.200 AS Numeric(7, 3)), CAST(0.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1853 AS Numeric(4, 0)), CAST(9.210 AS Numeric(7, 3)), CAST(0.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1854 AS Numeric(4, 0)), CAST(9.220 AS Numeric(7, 3)), CAST(0.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1855 AS Numeric(4, 0)), CAST(9.230 AS Numeric(7, 3)), CAST(0.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1856 AS Numeric(4, 0)), CAST(9.240 AS Numeric(7, 3)), CAST(0.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1857 AS Numeric(4, 0)), CAST(9.250 AS Numeric(7, 3)), CAST(0.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1858 AS Numeric(4, 0)), CAST(9.260 AS Numeric(7, 3)), CAST(0.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1859 AS Numeric(4, 0)), CAST(9.270 AS Numeric(7, 3)), CAST(0.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1860 AS Numeric(4, 0)), CAST(9.280 AS Numeric(7, 3)), CAST(0.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1861 AS Numeric(4, 0)), CAST(9.290 AS Numeric(7, 3)), CAST(0.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1862 AS Numeric(4, 0)), CAST(9.300 AS Numeric(7, 3)), CAST(0.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1863 AS Numeric(4, 0)), CAST(9.310 AS Numeric(7, 3)), CAST(0.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1864 AS Numeric(4, 0)), CAST(9.320 AS Numeric(7, 3)), CAST(0.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1865 AS Numeric(4, 0)), CAST(9.330 AS Numeric(7, 3)), CAST(0.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1866 AS Numeric(4, 0)), CAST(9.340 AS Numeric(7, 3)), CAST(0.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1867 AS Numeric(4, 0)), CAST(9.350 AS Numeric(7, 3)), CAST(0.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1868 AS Numeric(4, 0)), CAST(9.360 AS Numeric(7, 3)), CAST(0.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1869 AS Numeric(4, 0)), CAST(9.370 AS Numeric(7, 3)), CAST(0.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1870 AS Numeric(4, 0)), CAST(9.380 AS Numeric(7, 3)), CAST(0.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1871 AS Numeric(4, 0)), CAST(9.390 AS Numeric(7, 3)), CAST(0.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1872 AS Numeric(4, 0)), CAST(9.400 AS Numeric(7, 3)), CAST(0.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1873 AS Numeric(4, 0)), CAST(9.410 AS Numeric(7, 3)), CAST(0.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1874 AS Numeric(4, 0)), CAST(9.420 AS Numeric(7, 3)), CAST(0.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1875 AS Numeric(4, 0)), CAST(9.430 AS Numeric(7, 3)), CAST(1.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1876 AS Numeric(4, 0)), CAST(9.440 AS Numeric(7, 3)), CAST(1.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1877 AS Numeric(4, 0)), CAST(9.450 AS Numeric(7, 3)), CAST(1.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1878 AS Numeric(4, 0)), CAST(9.460 AS Numeric(7, 3)), CAST(1.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1879 AS Numeric(4, 0)), CAST(9.470 AS Numeric(7, 3)), CAST(1.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1880 AS Numeric(4, 0)), CAST(9.480 AS Numeric(7, 3)), CAST(1.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1881 AS Numeric(4, 0)), CAST(9.490 AS Numeric(7, 3)), CAST(1.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1882 AS Numeric(4, 0)), CAST(9.500 AS Numeric(7, 3)), CAST(1.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1883 AS Numeric(4, 0)), CAST(9.510 AS Numeric(7, 3)), CAST(1.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1884 AS Numeric(4, 0)), CAST(9.520 AS Numeric(7, 3)), CAST(1.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1885 AS Numeric(4, 0)), CAST(9.530 AS Numeric(7, 3)), CAST(1.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1886 AS Numeric(4, 0)), CAST(9.540 AS Numeric(7, 3)), CAST(1.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1887 AS Numeric(4, 0)), CAST(9.550 AS Numeric(7, 3)), CAST(1.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1888 AS Numeric(4, 0)), CAST(9.560 AS Numeric(7, 3)), CAST(1.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1889 AS Numeric(4, 0)), CAST(9.570 AS Numeric(7, 3)), CAST(1.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1890 AS Numeric(4, 0)), CAST(9.580 AS Numeric(7, 3)), CAST(1.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1891 AS Numeric(4, 0)), CAST(9.590 AS Numeric(7, 3)), CAST(1.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1892 AS Numeric(4, 0)), CAST(9.600 AS Numeric(7, 3)), CAST(1.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1893 AS Numeric(4, 0)), CAST(9.610 AS Numeric(7, 3)), CAST(1.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1894 AS Numeric(4, 0)), CAST(9.620 AS Numeric(7, 3)), CAST(2.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1895 AS Numeric(4, 0)), CAST(9.630 AS Numeric(7, 3)), CAST(2.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1896 AS Numeric(4, 0)), CAST(9.640 AS Numeric(7, 3)), CAST(2.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1897 AS Numeric(4, 0)), CAST(9.650 AS Numeric(7, 3)), CAST(2.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1898 AS Numeric(4, 0)), CAST(9.660 AS Numeric(7, 3)), CAST(2.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1899 AS Numeric(4, 0)), CAST(9.670 AS Numeric(7, 3)), CAST(2.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1900 AS Numeric(4, 0)), CAST(9.680 AS Numeric(7, 3)), CAST(2.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1901 AS Numeric(4, 0)), CAST(9.690 AS Numeric(7, 3)), CAST(2.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1902 AS Numeric(4, 0)), CAST(9.700 AS Numeric(7, 3)), CAST(2.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1903 AS Numeric(4, 0)), CAST(9.710 AS Numeric(7, 3)), CAST(2.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1904 AS Numeric(4, 0)), CAST(9.720 AS Numeric(7, 3)), CAST(2.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1905 AS Numeric(4, 0)), CAST(9.730 AS Numeric(7, 3)), CAST(3.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1906 AS Numeric(4, 0)), CAST(9.740 AS Numeric(7, 3)), CAST(3.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1907 AS Numeric(4, 0)), CAST(9.750 AS Numeric(7, 3)), CAST(3.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1908 AS Numeric(4, 0)), CAST(9.760 AS Numeric(7, 3)), CAST(3.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1909 AS Numeric(4, 0)), CAST(9.770 AS Numeric(7, 3)), CAST(3.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1910 AS Numeric(4, 0)), CAST(9.780 AS Numeric(7, 3)), CAST(3.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1911 AS Numeric(4, 0)), CAST(9.790 AS Numeric(7, 3)), CAST(3.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1912 AS Numeric(4, 0)), CAST(9.800 AS Numeric(7, 3)), CAST(3.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1913 AS Numeric(4, 0)), CAST(9.810 AS Numeric(7, 3)), CAST(3.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1914 AS Numeric(4, 0)), CAST(9.820 AS Numeric(7, 3)), CAST(3.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1915 AS Numeric(4, 0)), CAST(9.830 AS Numeric(7, 3)), CAST(4.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1916 AS Numeric(4, 0)), CAST(9.840 AS Numeric(7, 3)), CAST(4.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1917 AS Numeric(4, 0)), CAST(9.850 AS Numeric(7, 3)), CAST(4.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1918 AS Numeric(4, 0)), CAST(9.860 AS Numeric(7, 3)), CAST(4.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1919 AS Numeric(4, 0)), CAST(9.870 AS Numeric(7, 3)), CAST(4.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1920 AS Numeric(4, 0)), CAST(9.880 AS Numeric(7, 3)), CAST(4.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1921 AS Numeric(4, 0)), CAST(9.890 AS Numeric(7, 3)), CAST(4.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1922 AS Numeric(4, 0)), CAST(9.900 AS Numeric(7, 3)), CAST(5.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1923 AS Numeric(4, 0)), CAST(9.910 AS Numeric(7, 3)), CAST(5.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1924 AS Numeric(4, 0)), CAST(9.920 AS Numeric(7, 3)), CAST(5.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1925 AS Numeric(4, 0)), CAST(9.930 AS Numeric(7, 3)), CAST(5.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1926 AS Numeric(4, 0)), CAST(9.940 AS Numeric(7, 3)), CAST(5.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1927 AS Numeric(4, 0)), CAST(9.950 AS Numeric(7, 3)), CAST(5.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1928 AS Numeric(4, 0)), CAST(9.960 AS Numeric(7, 3)), CAST(5.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1929 AS Numeric(4, 0)), CAST(9.970 AS Numeric(7, 3)), CAST(6.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1930 AS Numeric(4, 0)), CAST(9.980 AS Numeric(7, 3)), CAST(6.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1931 AS Numeric(4, 0)), CAST(9.990 AS Numeric(7, 3)), CAST(6.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1932 AS Numeric(4, 0)), CAST(10.000 AS Numeric(7, 3)), CAST(6.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1933 AS Numeric(4, 0)), CAST(10.010 AS Numeric(7, 3)), CAST(6.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1934 AS Numeric(4, 0)), CAST(10.020 AS Numeric(7, 3)), CAST(6.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1935 AS Numeric(4, 0)), CAST(10.030 AS Numeric(7, 3)), CAST(7.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1936 AS Numeric(4, 0)), CAST(10.040 AS Numeric(7, 3)), CAST(7.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1937 AS Numeric(4, 0)), CAST(10.050 AS Numeric(7, 3)), CAST(7.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1938 AS Numeric(4, 0)), CAST(10.060 AS Numeric(7, 3)), CAST(7.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1939 AS Numeric(4, 0)), CAST(10.070 AS Numeric(7, 3)), CAST(7.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1940 AS Numeric(4, 0)), CAST(10.080 AS Numeric(7, 3)), CAST(8.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1941 AS Numeric(4, 0)), CAST(10.090 AS Numeric(7, 3)), CAST(8.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1942 AS Numeric(4, 0)), CAST(10.100 AS Numeric(7, 3)), CAST(8.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1943 AS Numeric(4, 0)), CAST(10.110 AS Numeric(7, 3)), CAST(8.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1944 AS Numeric(4, 0)), CAST(10.120 AS Numeric(7, 3)), CAST(8.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1945 AS Numeric(4, 0)), CAST(10.130 AS Numeric(7, 3)), CAST(9.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1946 AS Numeric(4, 0)), CAST(10.140 AS Numeric(7, 3)), CAST(9.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1947 AS Numeric(4, 0)), CAST(10.150 AS Numeric(7, 3)), CAST(9.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1948 AS Numeric(4, 0)), CAST(10.160 AS Numeric(7, 3)), CAST(9.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1949 AS Numeric(4, 0)), CAST(10.170 AS Numeric(7, 3)), CAST(9.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1950 AS Numeric(4, 0)), CAST(10.180 AS Numeric(7, 3)), CAST(10.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1951 AS Numeric(4, 0)), CAST(10.190 AS Numeric(7, 3)), CAST(10.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1952 AS Numeric(4, 0)), CAST(10.200 AS Numeric(7, 3)), CAST(10.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1953 AS Numeric(4, 0)), CAST(10.210 AS Numeric(7, 3)), CAST(10.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1954 AS Numeric(4, 0)), CAST(10.220 AS Numeric(7, 3)), CAST(10.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1955 AS Numeric(4, 0)), CAST(10.230 AS Numeric(7, 3)), CAST(11.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1956 AS Numeric(4, 0)), CAST(10.240 AS Numeric(7, 3)), CAST(11.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1957 AS Numeric(4, 0)), CAST(10.250 AS Numeric(7, 3)), CAST(11.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1958 AS Numeric(4, 0)), CAST(10.260 AS Numeric(7, 3)), CAST(12.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1959 AS Numeric(4, 0)), CAST(10.270 AS Numeric(7, 3)), CAST(12.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1960 AS Numeric(4, 0)), CAST(10.280 AS Numeric(7, 3)), CAST(12.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1961 AS Numeric(4, 0)), CAST(10.290 AS Numeric(7, 3)), CAST(12.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1962 AS Numeric(4, 0)), CAST(10.300 AS Numeric(7, 3)), CAST(13.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1963 AS Numeric(4, 0)), CAST(10.310 AS Numeric(7, 3)), CAST(13.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1964 AS Numeric(4, 0)), CAST(10.320 AS Numeric(7, 3)), CAST(13.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1965 AS Numeric(4, 0)), CAST(10.330 AS Numeric(7, 3)), CAST(13.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1966 AS Numeric(4, 0)), CAST(10.340 AS Numeric(7, 3)), CAST(14.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1967 AS Numeric(4, 0)), CAST(10.350 AS Numeric(7, 3)), CAST(14.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1968 AS Numeric(4, 0)), CAST(10.360 AS Numeric(7, 3)), CAST(14.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1969 AS Numeric(4, 0)), CAST(10.370 AS Numeric(7, 3)), CAST(15.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1970 AS Numeric(4, 0)), CAST(10.380 AS Numeric(7, 3)), CAST(15.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1971 AS Numeric(4, 0)), CAST(10.390 AS Numeric(7, 3)), CAST(15.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1972 AS Numeric(4, 0)), CAST(10.400 AS Numeric(7, 3)), CAST(15.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1973 AS Numeric(4, 0)), CAST(10.410 AS Numeric(7, 3)), CAST(16.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1974 AS Numeric(4, 0)), CAST(10.420 AS Numeric(7, 3)), CAST(16.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1975 AS Numeric(4, 0)), CAST(10.430 AS Numeric(7, 3)), CAST(16.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1976 AS Numeric(4, 0)), CAST(10.440 AS Numeric(7, 3)), CAST(17.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1977 AS Numeric(4, 0)), CAST(10.450 AS Numeric(7, 3)), CAST(17.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1978 AS Numeric(4, 0)), CAST(10.460 AS Numeric(7, 3)), CAST(17.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1979 AS Numeric(4, 0)), CAST(10.470 AS Numeric(7, 3)), CAST(18.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1980 AS Numeric(4, 0)), CAST(10.480 AS Numeric(7, 3)), CAST(18.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1981 AS Numeric(4, 0)), CAST(10.490 AS Numeric(7, 3)), CAST(18.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1982 AS Numeric(4, 0)), CAST(10.500 AS Numeric(7, 3)), CAST(19.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1983 AS Numeric(4, 0)), CAST(10.510 AS Numeric(7, 3)), CAST(19.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1984 AS Numeric(4, 0)), CAST(10.520 AS Numeric(7, 3)), CAST(19.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1985 AS Numeric(4, 0)), CAST(10.530 AS Numeric(7, 3)), CAST(20.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1986 AS Numeric(4, 0)), CAST(10.540 AS Numeric(7, 3)), CAST(20.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1987 AS Numeric(4, 0)), CAST(10.550 AS Numeric(7, 3)), CAST(20.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1988 AS Numeric(4, 0)), CAST(10.560 AS Numeric(7, 3)), CAST(21.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1989 AS Numeric(4, 0)), CAST(10.570 AS Numeric(7, 3)), CAST(21.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1990 AS Numeric(4, 0)), CAST(10.580 AS Numeric(7, 3)), CAST(21.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1991 AS Numeric(4, 0)), CAST(10.590 AS Numeric(7, 3)), CAST(22.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1992 AS Numeric(4, 0)), CAST(10.600 AS Numeric(7, 3)), CAST(22.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1993 AS Numeric(4, 0)), CAST(10.610 AS Numeric(7, 3)), CAST(23.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1994 AS Numeric(4, 0)), CAST(10.620 AS Numeric(7, 3)), CAST(23.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1995 AS Numeric(4, 0)), CAST(10.630 AS Numeric(7, 3)), CAST(23.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1996 AS Numeric(4, 0)), CAST(10.640 AS Numeric(7, 3)), CAST(24.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1997 AS Numeric(4, 0)), CAST(10.650 AS Numeric(7, 3)), CAST(24.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1998 AS Numeric(4, 0)), CAST(10.660 AS Numeric(7, 3)), CAST(25.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(1999 AS Numeric(4, 0)), CAST(10.670 AS Numeric(7, 3)), CAST(25.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2000 AS Numeric(4, 0)), CAST(10.680 AS Numeric(7, 3)), CAST(25.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2001 AS Numeric(4, 0)), CAST(10.690 AS Numeric(7, 3)), CAST(26.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2002 AS Numeric(4, 0)), CAST(10.700 AS Numeric(7, 3)), CAST(26.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2003 AS Numeric(4, 0)), CAST(10.710 AS Numeric(7, 3)), CAST(27.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2004 AS Numeric(4, 0)), CAST(10.720 AS Numeric(7, 3)), CAST(27.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2005 AS Numeric(4, 0)), CAST(10.730 AS Numeric(7, 3)), CAST(28.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2006 AS Numeric(4, 0)), CAST(10.740 AS Numeric(7, 3)), CAST(28.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2007 AS Numeric(4, 0)), CAST(10.750 AS Numeric(7, 3)), CAST(28.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2008 AS Numeric(4, 0)), CAST(10.760 AS Numeric(7, 3)), CAST(29.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2009 AS Numeric(4, 0)), CAST(10.770 AS Numeric(7, 3)), CAST(29.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2010 AS Numeric(4, 0)), CAST(10.780 AS Numeric(7, 3)), CAST(30.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2011 AS Numeric(4, 0)), CAST(10.790 AS Numeric(7, 3)), CAST(30.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2012 AS Numeric(4, 0)), CAST(10.800 AS Numeric(7, 3)), CAST(30.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2013 AS Numeric(4, 0)), CAST(10.810 AS Numeric(7, 3)), CAST(31.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2014 AS Numeric(4, 0)), CAST(10.820 AS Numeric(7, 3)), CAST(31.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2015 AS Numeric(4, 0)), CAST(10.830 AS Numeric(7, 3)), CAST(32.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2016 AS Numeric(4, 0)), CAST(10.840 AS Numeric(7, 3)), CAST(32.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2017 AS Numeric(4, 0)), CAST(10.850 AS Numeric(7, 3)), CAST(33.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2018 AS Numeric(4, 0)), CAST(10.860 AS Numeric(7, 3)), CAST(33.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2019 AS Numeric(4, 0)), CAST(10.870 AS Numeric(7, 3)), CAST(34.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2020 AS Numeric(4, 0)), CAST(10.880 AS Numeric(7, 3)), CAST(34.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2021 AS Numeric(4, 0)), CAST(10.890 AS Numeric(7, 3)), CAST(35.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2022 AS Numeric(4, 0)), CAST(10.900 AS Numeric(7, 3)), CAST(35.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2023 AS Numeric(4, 0)), CAST(10.910 AS Numeric(7, 3)), CAST(36.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2024 AS Numeric(4, 0)), CAST(10.920 AS Numeric(7, 3)), CAST(36.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2025 AS Numeric(4, 0)), CAST(10.930 AS Numeric(7, 3)), CAST(37.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2026 AS Numeric(4, 0)), CAST(10.940 AS Numeric(7, 3)), CAST(37.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2027 AS Numeric(4, 0)), CAST(10.950 AS Numeric(7, 3)), CAST(38.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2028 AS Numeric(4, 0)), CAST(10.960 AS Numeric(7, 3)), CAST(38.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2029 AS Numeric(4, 0)), CAST(10.970 AS Numeric(7, 3)), CAST(39.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2030 AS Numeric(4, 0)), CAST(10.980 AS Numeric(7, 3)), CAST(39.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2031 AS Numeric(4, 0)), CAST(10.990 AS Numeric(7, 3)), CAST(40.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2032 AS Numeric(4, 0)), CAST(11.000 AS Numeric(7, 3)), CAST(40.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2033 AS Numeric(4, 0)), CAST(11.010 AS Numeric(7, 3)), CAST(41.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2034 AS Numeric(4, 0)), CAST(11.020 AS Numeric(7, 3)), CAST(41.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2035 AS Numeric(4, 0)), CAST(11.030 AS Numeric(7, 3)), CAST(42.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2036 AS Numeric(4, 0)), CAST(11.040 AS Numeric(7, 3)), CAST(42.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2037 AS Numeric(4, 0)), CAST(11.050 AS Numeric(7, 3)), CAST(43.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2038 AS Numeric(4, 0)), CAST(11.060 AS Numeric(7, 3)), CAST(43.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2039 AS Numeric(4, 0)), CAST(11.070 AS Numeric(7, 3)), CAST(44.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2040 AS Numeric(4, 0)), CAST(11.080 AS Numeric(7, 3)), CAST(44.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2041 AS Numeric(4, 0)), CAST(11.090 AS Numeric(7, 3)), CAST(45.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2042 AS Numeric(4, 0)), CAST(11.100 AS Numeric(7, 3)), CAST(46.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2043 AS Numeric(4, 0)), CAST(11.110 AS Numeric(7, 3)), CAST(46.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2044 AS Numeric(4, 0)), CAST(11.120 AS Numeric(7, 3)), CAST(47.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2045 AS Numeric(4, 0)), CAST(11.130 AS Numeric(7, 3)), CAST(47.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2046 AS Numeric(4, 0)), CAST(11.140 AS Numeric(7, 3)), CAST(48.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2047 AS Numeric(4, 0)), CAST(11.150 AS Numeric(7, 3)), CAST(48.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2048 AS Numeric(4, 0)), CAST(11.160 AS Numeric(7, 3)), CAST(49.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2049 AS Numeric(4, 0)), CAST(11.170 AS Numeric(7, 3)), CAST(50.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2050 AS Numeric(4, 0)), CAST(11.180 AS Numeric(7, 3)), CAST(50.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2051 AS Numeric(4, 0)), CAST(11.190 AS Numeric(7, 3)), CAST(51.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2052 AS Numeric(4, 0)), CAST(11.200 AS Numeric(7, 3)), CAST(51.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2053 AS Numeric(4, 0)), CAST(11.210 AS Numeric(7, 3)), CAST(52.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2054 AS Numeric(4, 0)), CAST(11.220 AS Numeric(7, 3)), CAST(52.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2055 AS Numeric(4, 0)), CAST(11.230 AS Numeric(7, 3)), CAST(53.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2056 AS Numeric(4, 0)), CAST(11.240 AS Numeric(7, 3)), CAST(54.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2057 AS Numeric(4, 0)), CAST(11.250 AS Numeric(7, 3)), CAST(54.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2058 AS Numeric(4, 0)), CAST(11.260 AS Numeric(7, 3)), CAST(55.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2059 AS Numeric(4, 0)), CAST(11.270 AS Numeric(7, 3)), CAST(56.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2060 AS Numeric(4, 0)), CAST(11.280 AS Numeric(7, 3)), CAST(56.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2061 AS Numeric(4, 0)), CAST(11.290 AS Numeric(7, 3)), CAST(57.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2062 AS Numeric(4, 0)), CAST(11.300 AS Numeric(7, 3)), CAST(57.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2063 AS Numeric(4, 0)), CAST(11.310 AS Numeric(7, 3)), CAST(58.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2064 AS Numeric(4, 0)), CAST(11.320 AS Numeric(7, 3)), CAST(59.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2065 AS Numeric(4, 0)), CAST(11.330 AS Numeric(7, 3)), CAST(59.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2066 AS Numeric(4, 0)), CAST(11.340 AS Numeric(7, 3)), CAST(60.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2067 AS Numeric(4, 0)), CAST(11.350 AS Numeric(7, 3)), CAST(61.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2068 AS Numeric(4, 0)), CAST(11.360 AS Numeric(7, 3)), CAST(61.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2069 AS Numeric(4, 0)), CAST(11.370 AS Numeric(7, 3)), CAST(62.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2070 AS Numeric(4, 0)), CAST(11.380 AS Numeric(7, 3)), CAST(62.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2071 AS Numeric(4, 0)), CAST(11.390 AS Numeric(7, 3)), CAST(63.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2072 AS Numeric(4, 0)), CAST(11.400 AS Numeric(7, 3)), CAST(64.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2073 AS Numeric(4, 0)), CAST(11.410 AS Numeric(7, 3)), CAST(64.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2074 AS Numeric(4, 0)), CAST(11.420 AS Numeric(7, 3)), CAST(65.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2075 AS Numeric(4, 0)), CAST(11.430 AS Numeric(7, 3)), CAST(66.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2076 AS Numeric(4, 0)), CAST(11.440 AS Numeric(7, 3)), CAST(66.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2077 AS Numeric(4, 0)), CAST(11.450 AS Numeric(7, 3)), CAST(67.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2078 AS Numeric(4, 0)), CAST(11.460 AS Numeric(7, 3)), CAST(68.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2079 AS Numeric(4, 0)), CAST(11.470 AS Numeric(7, 3)), CAST(68.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2080 AS Numeric(4, 0)), CAST(11.480 AS Numeric(7, 3)), CAST(69.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2081 AS Numeric(4, 0)), CAST(11.490 AS Numeric(7, 3)), CAST(70.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2082 AS Numeric(4, 0)), CAST(11.500 AS Numeric(7, 3)), CAST(70.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2083 AS Numeric(4, 0)), CAST(11.510 AS Numeric(7, 3)), CAST(71.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2084 AS Numeric(4, 0)), CAST(11.520 AS Numeric(7, 3)), CAST(72.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2085 AS Numeric(4, 0)), CAST(11.530 AS Numeric(7, 3)), CAST(72.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2086 AS Numeric(4, 0)), CAST(11.540 AS Numeric(7, 3)), CAST(73.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2087 AS Numeric(4, 0)), CAST(11.550 AS Numeric(7, 3)), CAST(74.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2088 AS Numeric(4, 0)), CAST(11.560 AS Numeric(7, 3)), CAST(74.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2089 AS Numeric(4, 0)), CAST(11.570 AS Numeric(7, 3)), CAST(75.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2090 AS Numeric(4, 0)), CAST(11.580 AS Numeric(7, 3)), CAST(76.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2091 AS Numeric(4, 0)), CAST(11.590 AS Numeric(7, 3)), CAST(76.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2092 AS Numeric(4, 0)), CAST(11.600 AS Numeric(7, 3)), CAST(77.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2093 AS Numeric(4, 0)), CAST(11.610 AS Numeric(7, 3)), CAST(78.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2094 AS Numeric(4, 0)), CAST(11.620 AS Numeric(7, 3)), CAST(79.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2095 AS Numeric(4, 0)), CAST(11.630 AS Numeric(7, 3)), CAST(79.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2096 AS Numeric(4, 0)), CAST(11.640 AS Numeric(7, 3)), CAST(80.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2097 AS Numeric(4, 0)), CAST(11.650 AS Numeric(7, 3)), CAST(81.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2098 AS Numeric(4, 0)), CAST(11.660 AS Numeric(7, 3)), CAST(81.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2099 AS Numeric(4, 0)), CAST(11.670 AS Numeric(7, 3)), CAST(82.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2100 AS Numeric(4, 0)), CAST(11.680 AS Numeric(7, 3)), CAST(83.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2101 AS Numeric(4, 0)), CAST(11.690 AS Numeric(7, 3)), CAST(84.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2102 AS Numeric(4, 0)), CAST(11.700 AS Numeric(7, 3)), CAST(84.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2103 AS Numeric(4, 0)), CAST(11.710 AS Numeric(7, 3)), CAST(85.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2104 AS Numeric(4, 0)), CAST(11.720 AS Numeric(7, 3)), CAST(86.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2105 AS Numeric(4, 0)), CAST(11.730 AS Numeric(7, 3)), CAST(87.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2106 AS Numeric(4, 0)), CAST(11.740 AS Numeric(7, 3)), CAST(87.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2107 AS Numeric(4, 0)), CAST(11.750 AS Numeric(7, 3)), CAST(88.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2108 AS Numeric(4, 0)), CAST(11.760 AS Numeric(7, 3)), CAST(89.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2109 AS Numeric(4, 0)), CAST(11.770 AS Numeric(7, 3)), CAST(90.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2110 AS Numeric(4, 0)), CAST(11.780 AS Numeric(7, 3)), CAST(90.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2111 AS Numeric(4, 0)), CAST(11.790 AS Numeric(7, 3)), CAST(91.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2112 AS Numeric(4, 0)), CAST(11.800 AS Numeric(7, 3)), CAST(92.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2113 AS Numeric(4, 0)), CAST(11.810 AS Numeric(7, 3)), CAST(93.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2114 AS Numeric(4, 0)), CAST(11.820 AS Numeric(7, 3)), CAST(93.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2115 AS Numeric(4, 0)), CAST(11.830 AS Numeric(7, 3)), CAST(94.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2116 AS Numeric(4, 0)), CAST(11.840 AS Numeric(7, 3)), CAST(95.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2117 AS Numeric(4, 0)), CAST(11.850 AS Numeric(7, 3)), CAST(96.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2118 AS Numeric(4, 0)), CAST(11.860 AS Numeric(7, 3)), CAST(97.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2119 AS Numeric(4, 0)), CAST(11.870 AS Numeric(7, 3)), CAST(97.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2120 AS Numeric(4, 0)), CAST(11.880 AS Numeric(7, 3)), CAST(98.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2121 AS Numeric(4, 0)), CAST(11.890 AS Numeric(7, 3)), CAST(99.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2122 AS Numeric(4, 0)), CAST(11.900 AS Numeric(7, 3)), CAST(100.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2123 AS Numeric(4, 0)), CAST(11.910 AS Numeric(7, 3)), CAST(101.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2124 AS Numeric(4, 0)), CAST(11.920 AS Numeric(7, 3)), CAST(101.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2125 AS Numeric(4, 0)), CAST(11.930 AS Numeric(7, 3)), CAST(102.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2126 AS Numeric(4, 0)), CAST(11.940 AS Numeric(7, 3)), CAST(103.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2127 AS Numeric(4, 0)), CAST(11.950 AS Numeric(7, 3)), CAST(104.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2128 AS Numeric(4, 0)), CAST(11.960 AS Numeric(7, 3)), CAST(105.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2129 AS Numeric(4, 0)), CAST(11.970 AS Numeric(7, 3)), CAST(106.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2130 AS Numeric(4, 0)), CAST(11.980 AS Numeric(7, 3)), CAST(106.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2131 AS Numeric(4, 0)), CAST(11.990 AS Numeric(7, 3)), CAST(107.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2132 AS Numeric(4, 0)), CAST(12.000 AS Numeric(7, 3)), CAST(108.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2133 AS Numeric(4, 0)), CAST(12.010 AS Numeric(7, 3)), CAST(109.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2134 AS Numeric(4, 0)), CAST(12.020 AS Numeric(7, 3)), CAST(110.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2135 AS Numeric(4, 0)), CAST(12.030 AS Numeric(7, 3)), CAST(111.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2136 AS Numeric(4, 0)), CAST(12.040 AS Numeric(7, 3)), CAST(111.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2137 AS Numeric(4, 0)), CAST(12.050 AS Numeric(7, 3)), CAST(112.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2138 AS Numeric(4, 0)), CAST(12.060 AS Numeric(7, 3)), CAST(113.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2139 AS Numeric(4, 0)), CAST(12.070 AS Numeric(7, 3)), CAST(114.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2140 AS Numeric(4, 0)), CAST(12.080 AS Numeric(7, 3)), CAST(115.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2141 AS Numeric(4, 0)), CAST(12.090 AS Numeric(7, 3)), CAST(116.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2142 AS Numeric(4, 0)), CAST(12.100 AS Numeric(7, 3)), CAST(116.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2143 AS Numeric(4, 0)), CAST(12.110 AS Numeric(7, 3)), CAST(117.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2144 AS Numeric(4, 0)), CAST(12.120 AS Numeric(7, 3)), CAST(118.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2145 AS Numeric(4, 0)), CAST(12.130 AS Numeric(7, 3)), CAST(119.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2146 AS Numeric(4, 0)), CAST(12.140 AS Numeric(7, 3)), CAST(120.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2147 AS Numeric(4, 0)), CAST(12.150 AS Numeric(7, 3)), CAST(121.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2148 AS Numeric(4, 0)), CAST(12.160 AS Numeric(7, 3)), CAST(122.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2149 AS Numeric(4, 0)), CAST(12.170 AS Numeric(7, 3)), CAST(123.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2150 AS Numeric(4, 0)), CAST(12.180 AS Numeric(7, 3)), CAST(124.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2151 AS Numeric(4, 0)), CAST(12.190 AS Numeric(7, 3)), CAST(124.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2152 AS Numeric(4, 0)), CAST(12.200 AS Numeric(7, 3)), CAST(125.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2153 AS Numeric(4, 0)), CAST(12.210 AS Numeric(7, 3)), CAST(126.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2154 AS Numeric(4, 0)), CAST(12.220 AS Numeric(7, 3)), CAST(127.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2155 AS Numeric(4, 0)), CAST(12.230 AS Numeric(7, 3)), CAST(128.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2156 AS Numeric(4, 0)), CAST(12.240 AS Numeric(7, 3)), CAST(129.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2157 AS Numeric(4, 0)), CAST(12.250 AS Numeric(7, 3)), CAST(130.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2158 AS Numeric(4, 0)), CAST(12.260 AS Numeric(7, 3)), CAST(131.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2159 AS Numeric(4, 0)), CAST(12.270 AS Numeric(7, 3)), CAST(132.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2160 AS Numeric(4, 0)), CAST(12.280 AS Numeric(7, 3)), CAST(133.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2161 AS Numeric(4, 0)), CAST(12.290 AS Numeric(7, 3)), CAST(134.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2162 AS Numeric(4, 0)), CAST(12.300 AS Numeric(7, 3)), CAST(135.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2163 AS Numeric(4, 0)), CAST(12.310 AS Numeric(7, 3)), CAST(135.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2164 AS Numeric(4, 0)), CAST(12.320 AS Numeric(7, 3)), CAST(136.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2165 AS Numeric(4, 0)), CAST(12.330 AS Numeric(7, 3)), CAST(137.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2166 AS Numeric(4, 0)), CAST(12.340 AS Numeric(7, 3)), CAST(138.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2167 AS Numeric(4, 0)), CAST(12.350 AS Numeric(7, 3)), CAST(139.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2168 AS Numeric(4, 0)), CAST(12.360 AS Numeric(7, 3)), CAST(140.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2169 AS Numeric(4, 0)), CAST(12.370 AS Numeric(7, 3)), CAST(141.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2170 AS Numeric(4, 0)), CAST(12.380 AS Numeric(7, 3)), CAST(142.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2171 AS Numeric(4, 0)), CAST(12.390 AS Numeric(7, 3)), CAST(143.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2172 AS Numeric(4, 0)), CAST(12.400 AS Numeric(7, 3)), CAST(144.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2173 AS Numeric(4, 0)), CAST(12.410 AS Numeric(7, 3)), CAST(145.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2174 AS Numeric(4, 0)), CAST(12.420 AS Numeric(7, 3)), CAST(146.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2175 AS Numeric(4, 0)), CAST(12.430 AS Numeric(7, 3)), CAST(147.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2176 AS Numeric(4, 0)), CAST(12.440 AS Numeric(7, 3)), CAST(148.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2177 AS Numeric(4, 0)), CAST(12.450 AS Numeric(7, 3)), CAST(149.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2178 AS Numeric(4, 0)), CAST(12.460 AS Numeric(7, 3)), CAST(150.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2179 AS Numeric(4, 0)), CAST(12.470 AS Numeric(7, 3)), CAST(151.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2180 AS Numeric(4, 0)), CAST(12.480 AS Numeric(7, 3)), CAST(152.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2181 AS Numeric(4, 0)), CAST(12.490 AS Numeric(7, 3)), CAST(153.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2182 AS Numeric(4, 0)), CAST(12.500 AS Numeric(7, 3)), CAST(154.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2183 AS Numeric(4, 0)), CAST(12.510 AS Numeric(7, 3)), CAST(155.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2184 AS Numeric(4, 0)), CAST(12.520 AS Numeric(7, 3)), CAST(156.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2185 AS Numeric(4, 0)), CAST(12.530 AS Numeric(7, 3)), CAST(157.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2186 AS Numeric(4, 0)), CAST(12.540 AS Numeric(7, 3)), CAST(158.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2187 AS Numeric(4, 0)), CAST(12.550 AS Numeric(7, 3)), CAST(159.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2188 AS Numeric(4, 0)), CAST(12.560 AS Numeric(7, 3)), CAST(160.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2189 AS Numeric(4, 0)), CAST(12.570 AS Numeric(7, 3)), CAST(161.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2190 AS Numeric(4, 0)), CAST(12.580 AS Numeric(7, 3)), CAST(162.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2191 AS Numeric(4, 0)), CAST(12.590 AS Numeric(7, 3)), CAST(163.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2192 AS Numeric(4, 0)), CAST(12.600 AS Numeric(7, 3)), CAST(164.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2193 AS Numeric(4, 0)), CAST(12.610 AS Numeric(7, 3)), CAST(165.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2194 AS Numeric(4, 0)), CAST(12.620 AS Numeric(7, 3)), CAST(166.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2195 AS Numeric(4, 0)), CAST(12.630 AS Numeric(7, 3)), CAST(167.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2196 AS Numeric(4, 0)), CAST(12.640 AS Numeric(7, 3)), CAST(168.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2197 AS Numeric(4, 0)), CAST(12.650 AS Numeric(7, 3)), CAST(169.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2198 AS Numeric(4, 0)), CAST(12.660 AS Numeric(7, 3)), CAST(171.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2199 AS Numeric(4, 0)), CAST(12.670 AS Numeric(7, 3)), CAST(172.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2200 AS Numeric(4, 0)), CAST(12.680 AS Numeric(7, 3)), CAST(173.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2201 AS Numeric(4, 0)), CAST(12.690 AS Numeric(7, 3)), CAST(174.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2202 AS Numeric(4, 0)), CAST(12.700 AS Numeric(7, 3)), CAST(175.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2203 AS Numeric(4, 0)), CAST(12.710 AS Numeric(7, 3)), CAST(176.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2204 AS Numeric(4, 0)), CAST(12.720 AS Numeric(7, 3)), CAST(177.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2205 AS Numeric(4, 0)), CAST(12.730 AS Numeric(7, 3)), CAST(178.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2206 AS Numeric(4, 0)), CAST(12.740 AS Numeric(7, 3)), CAST(179.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2207 AS Numeric(4, 0)), CAST(12.750 AS Numeric(7, 3)), CAST(180.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2208 AS Numeric(4, 0)), CAST(12.760 AS Numeric(7, 3)), CAST(181.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2209 AS Numeric(4, 0)), CAST(12.770 AS Numeric(7, 3)), CAST(182.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2210 AS Numeric(4, 0)), CAST(12.780 AS Numeric(7, 3)), CAST(183.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2211 AS Numeric(4, 0)), CAST(12.790 AS Numeric(7, 3)), CAST(184.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2212 AS Numeric(4, 0)), CAST(12.800 AS Numeric(7, 3)), CAST(185.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2213 AS Numeric(4, 0)), CAST(12.810 AS Numeric(7, 3)), CAST(187.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2214 AS Numeric(4, 0)), CAST(12.820 AS Numeric(7, 3)), CAST(188.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2215 AS Numeric(4, 0)), CAST(12.830 AS Numeric(7, 3)), CAST(189.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2216 AS Numeric(4, 0)), CAST(12.840 AS Numeric(7, 3)), CAST(190.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2217 AS Numeric(4, 0)), CAST(12.850 AS Numeric(7, 3)), CAST(191.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2218 AS Numeric(4, 0)), CAST(12.860 AS Numeric(7, 3)), CAST(192.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2219 AS Numeric(4, 0)), CAST(12.870 AS Numeric(7, 3)), CAST(193.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2220 AS Numeric(4, 0)), CAST(12.880 AS Numeric(7, 3)), CAST(195.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2221 AS Numeric(4, 0)), CAST(12.890 AS Numeric(7, 3)), CAST(196.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2222 AS Numeric(4, 0)), CAST(12.900 AS Numeric(7, 3)), CAST(197.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2223 AS Numeric(4, 0)), CAST(12.910 AS Numeric(7, 3)), CAST(198.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2224 AS Numeric(4, 0)), CAST(12.920 AS Numeric(7, 3)), CAST(199.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2225 AS Numeric(4, 0)), CAST(12.930 AS Numeric(7, 3)), CAST(200.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2226 AS Numeric(4, 0)), CAST(12.940 AS Numeric(7, 3)), CAST(202.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2227 AS Numeric(4, 0)), CAST(12.950 AS Numeric(7, 3)), CAST(203.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2228 AS Numeric(4, 0)), CAST(12.960 AS Numeric(7, 3)), CAST(204.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2229 AS Numeric(4, 0)), CAST(12.970 AS Numeric(7, 3)), CAST(205.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2230 AS Numeric(4, 0)), CAST(12.980 AS Numeric(7, 3)), CAST(206.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2231 AS Numeric(4, 0)), CAST(12.990 AS Numeric(7, 3)), CAST(208.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2232 AS Numeric(4, 0)), CAST(13.000 AS Numeric(7, 3)), CAST(209.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2233 AS Numeric(4, 0)), CAST(13.010 AS Numeric(7, 3)), CAST(210.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2234 AS Numeric(4, 0)), CAST(13.020 AS Numeric(7, 3)), CAST(211.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2235 AS Numeric(4, 0)), CAST(13.030 AS Numeric(7, 3)), CAST(212.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2236 AS Numeric(4, 0)), CAST(13.040 AS Numeric(7, 3)), CAST(214.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2237 AS Numeric(4, 0)), CAST(13.050 AS Numeric(7, 3)), CAST(215.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2238 AS Numeric(4, 0)), CAST(13.060 AS Numeric(7, 3)), CAST(216.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2239 AS Numeric(4, 0)), CAST(13.070 AS Numeric(7, 3)), CAST(217.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2240 AS Numeric(4, 0)), CAST(13.080 AS Numeric(7, 3)), CAST(218.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2241 AS Numeric(4, 0)), CAST(13.090 AS Numeric(7, 3)), CAST(220.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2242 AS Numeric(4, 0)), CAST(13.100 AS Numeric(7, 3)), CAST(221.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2243 AS Numeric(4, 0)), CAST(13.110 AS Numeric(7, 3)), CAST(222.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2244 AS Numeric(4, 0)), CAST(13.120 AS Numeric(7, 3)), CAST(223.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2245 AS Numeric(4, 0)), CAST(13.130 AS Numeric(7, 3)), CAST(225.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2246 AS Numeric(4, 0)), CAST(13.140 AS Numeric(7, 3)), CAST(226.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2247 AS Numeric(4, 0)), CAST(13.150 AS Numeric(7, 3)), CAST(227.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2248 AS Numeric(4, 0)), CAST(13.160 AS Numeric(7, 3)), CAST(229.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2249 AS Numeric(4, 0)), CAST(13.170 AS Numeric(7, 3)), CAST(230.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2250 AS Numeric(4, 0)), CAST(13.180 AS Numeric(7, 3)), CAST(231.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2251 AS Numeric(4, 0)), CAST(13.190 AS Numeric(7, 3)), CAST(233.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2252 AS Numeric(4, 0)), CAST(13.200 AS Numeric(7, 3)), CAST(234.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2253 AS Numeric(4, 0)), CAST(13.210 AS Numeric(7, 3)), CAST(235.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2254 AS Numeric(4, 0)), CAST(13.220 AS Numeric(7, 3)), CAST(236.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2255 AS Numeric(4, 0)), CAST(13.230 AS Numeric(7, 3)), CAST(238.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2256 AS Numeric(4, 0)), CAST(13.240 AS Numeric(7, 3)), CAST(239.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2257 AS Numeric(4, 0)), CAST(13.250 AS Numeric(7, 3)), CAST(240.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2258 AS Numeric(4, 0)), CAST(13.260 AS Numeric(7, 3)), CAST(242.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2259 AS Numeric(4, 0)), CAST(13.270 AS Numeric(7, 3)), CAST(243.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2260 AS Numeric(4, 0)), CAST(13.280 AS Numeric(7, 3)), CAST(244.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2261 AS Numeric(4, 0)), CAST(13.290 AS Numeric(7, 3)), CAST(246.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2262 AS Numeric(4, 0)), CAST(13.300 AS Numeric(7, 3)), CAST(247.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2263 AS Numeric(4, 0)), CAST(13.310 AS Numeric(7, 3)), CAST(248.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2264 AS Numeric(4, 0)), CAST(13.320 AS Numeric(7, 3)), CAST(250.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2265 AS Numeric(4, 0)), CAST(13.330 AS Numeric(7, 3)), CAST(251.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2266 AS Numeric(4, 0)), CAST(13.340 AS Numeric(7, 3)), CAST(252.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2267 AS Numeric(4, 0)), CAST(13.350 AS Numeric(7, 3)), CAST(254.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2268 AS Numeric(4, 0)), CAST(13.360 AS Numeric(7, 3)), CAST(255.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2269 AS Numeric(4, 0)), CAST(13.370 AS Numeric(7, 3)), CAST(257.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2270 AS Numeric(4, 0)), CAST(13.380 AS Numeric(7, 3)), CAST(258.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2271 AS Numeric(4, 0)), CAST(13.390 AS Numeric(7, 3)), CAST(259.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2272 AS Numeric(4, 0)), CAST(13.400 AS Numeric(7, 3)), CAST(261.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2273 AS Numeric(4, 0)), CAST(13.410 AS Numeric(7, 3)), CAST(262.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2274 AS Numeric(4, 0)), CAST(13.420 AS Numeric(7, 3)), CAST(264.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2275 AS Numeric(4, 0)), CAST(13.430 AS Numeric(7, 3)), CAST(265.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2276 AS Numeric(4, 0)), CAST(13.440 AS Numeric(7, 3)), CAST(266.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2277 AS Numeric(4, 0)), CAST(13.450 AS Numeric(7, 3)), CAST(268.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2278 AS Numeric(4, 0)), CAST(13.460 AS Numeric(7, 3)), CAST(269.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2279 AS Numeric(4, 0)), CAST(13.470 AS Numeric(7, 3)), CAST(271.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2280 AS Numeric(4, 0)), CAST(13.480 AS Numeric(7, 3)), CAST(272.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2281 AS Numeric(4, 0)), CAST(13.490 AS Numeric(7, 3)), CAST(273.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2282 AS Numeric(4, 0)), CAST(13.500 AS Numeric(7, 3)), CAST(275.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2283 AS Numeric(4, 0)), CAST(13.510 AS Numeric(7, 3)), CAST(276.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2284 AS Numeric(4, 0)), CAST(13.520 AS Numeric(7, 3)), CAST(278.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2285 AS Numeric(4, 0)), CAST(13.530 AS Numeric(7, 3)), CAST(279.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2286 AS Numeric(4, 0)), CAST(13.540 AS Numeric(7, 3)), CAST(281.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2287 AS Numeric(4, 0)), CAST(13.550 AS Numeric(7, 3)), CAST(282.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2288 AS Numeric(4, 0)), CAST(13.560 AS Numeric(7, 3)), CAST(284.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2289 AS Numeric(4, 0)), CAST(13.570 AS Numeric(7, 3)), CAST(285.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2290 AS Numeric(4, 0)), CAST(13.580 AS Numeric(7, 3)), CAST(287.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2291 AS Numeric(4, 0)), CAST(13.590 AS Numeric(7, 3)), CAST(288.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2292 AS Numeric(4, 0)), CAST(13.600 AS Numeric(7, 3)), CAST(290.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2293 AS Numeric(4, 0)), CAST(13.610 AS Numeric(7, 3)), CAST(291.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2294 AS Numeric(4, 0)), CAST(13.620 AS Numeric(7, 3)), CAST(293.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2295 AS Numeric(4, 0)), CAST(13.630 AS Numeric(7, 3)), CAST(294.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2296 AS Numeric(4, 0)), CAST(13.640 AS Numeric(7, 3)), CAST(296.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2297 AS Numeric(4, 0)), CAST(13.650 AS Numeric(7, 3)), CAST(297.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2298 AS Numeric(4, 0)), CAST(13.660 AS Numeric(7, 3)), CAST(299.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2299 AS Numeric(4, 0)), CAST(13.670 AS Numeric(7, 3)), CAST(300.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2300 AS Numeric(4, 0)), CAST(13.680 AS Numeric(7, 3)), CAST(302.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2301 AS Numeric(4, 0)), CAST(13.690 AS Numeric(7, 3)), CAST(303.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2302 AS Numeric(4, 0)), CAST(13.700 AS Numeric(7, 3)), CAST(305.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2303 AS Numeric(4, 0)), CAST(13.710 AS Numeric(7, 3)), CAST(307.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2304 AS Numeric(4, 0)), CAST(13.720 AS Numeric(7, 3)), CAST(308.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2305 AS Numeric(4, 0)), CAST(13.730 AS Numeric(7, 3)), CAST(310.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2306 AS Numeric(4, 0)), CAST(13.740 AS Numeric(7, 3)), CAST(311.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2307 AS Numeric(4, 0)), CAST(13.750 AS Numeric(7, 3)), CAST(313.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2308 AS Numeric(4, 0)), CAST(13.760 AS Numeric(7, 3)), CAST(315.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2309 AS Numeric(4, 0)), CAST(13.770 AS Numeric(7, 3)), CAST(316.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2310 AS Numeric(4, 0)), CAST(13.780 AS Numeric(7, 3)), CAST(318.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2311 AS Numeric(4, 0)), CAST(13.790 AS Numeric(7, 3)), CAST(319.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2312 AS Numeric(4, 0)), CAST(13.800 AS Numeric(7, 3)), CAST(321.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2313 AS Numeric(4, 0)), CAST(13.810 AS Numeric(7, 3)), CAST(323.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2314 AS Numeric(4, 0)), CAST(13.820 AS Numeric(7, 3)), CAST(324.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2315 AS Numeric(4, 0)), CAST(13.830 AS Numeric(7, 3)), CAST(326.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2316 AS Numeric(4, 0)), CAST(13.840 AS Numeric(7, 3)), CAST(327.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2317 AS Numeric(4, 0)), CAST(13.850 AS Numeric(7, 3)), CAST(329.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2318 AS Numeric(4, 0)), CAST(13.860 AS Numeric(7, 3)), CAST(331.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2319 AS Numeric(4, 0)), CAST(13.870 AS Numeric(7, 3)), CAST(332.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2320 AS Numeric(4, 0)), CAST(13.880 AS Numeric(7, 3)), CAST(334.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2321 AS Numeric(4, 0)), CAST(13.890 AS Numeric(7, 3)), CAST(335.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2322 AS Numeric(4, 0)), CAST(13.900 AS Numeric(7, 3)), CAST(337.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2323 AS Numeric(4, 0)), CAST(13.910 AS Numeric(7, 3)), CAST(339.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2324 AS Numeric(4, 0)), CAST(13.920 AS Numeric(7, 3)), CAST(340.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2325 AS Numeric(4, 0)), CAST(13.930 AS Numeric(7, 3)), CAST(342.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2326 AS Numeric(4, 0)), CAST(13.940 AS Numeric(7, 3)), CAST(344.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2327 AS Numeric(4, 0)), CAST(13.950 AS Numeric(7, 3)), CAST(345.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2328 AS Numeric(4, 0)), CAST(13.960 AS Numeric(7, 3)), CAST(347.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2329 AS Numeric(4, 0)), CAST(13.970 AS Numeric(7, 3)), CAST(349.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2330 AS Numeric(4, 0)), CAST(13.980 AS Numeric(7, 3)), CAST(351.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2331 AS Numeric(4, 0)), CAST(13.990 AS Numeric(7, 3)), CAST(352.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2332 AS Numeric(4, 0)), CAST(14.000 AS Numeric(7, 3)), CAST(354.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2333 AS Numeric(4, 0)), CAST(14.010 AS Numeric(7, 3)), CAST(356.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2334 AS Numeric(4, 0)), CAST(14.020 AS Numeric(7, 3)), CAST(357.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2335 AS Numeric(4, 0)), CAST(14.030 AS Numeric(7, 3)), CAST(359.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2336 AS Numeric(4, 0)), CAST(14.040 AS Numeric(7, 3)), CAST(361.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2337 AS Numeric(4, 0)), CAST(14.050 AS Numeric(7, 3)), CAST(362.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2338 AS Numeric(4, 0)), CAST(14.060 AS Numeric(7, 3)), CAST(364.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2339 AS Numeric(4, 0)), CAST(14.070 AS Numeric(7, 3)), CAST(366.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2340 AS Numeric(4, 0)), CAST(14.080 AS Numeric(7, 3)), CAST(368.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2341 AS Numeric(4, 0)), CAST(14.090 AS Numeric(7, 3)), CAST(369.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2342 AS Numeric(4, 0)), CAST(14.100 AS Numeric(7, 3)), CAST(371.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2343 AS Numeric(4, 0)), CAST(14.110 AS Numeric(7, 3)), CAST(373.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2344 AS Numeric(4, 0)), CAST(14.120 AS Numeric(7, 3)), CAST(374.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2345 AS Numeric(4, 0)), CAST(14.130 AS Numeric(7, 3)), CAST(376.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2346 AS Numeric(4, 0)), CAST(14.140 AS Numeric(7, 3)), CAST(378.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2347 AS Numeric(4, 0)), CAST(14.150 AS Numeric(7, 3)), CAST(380.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2348 AS Numeric(4, 0)), CAST(14.160 AS Numeric(7, 3)), CAST(382.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2349 AS Numeric(4, 0)), CAST(14.170 AS Numeric(7, 3)), CAST(383.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2350 AS Numeric(4, 0)), CAST(14.180 AS Numeric(7, 3)), CAST(385.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2351 AS Numeric(4, 0)), CAST(14.190 AS Numeric(7, 3)), CAST(387.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2352 AS Numeric(4, 0)), CAST(14.200 AS Numeric(7, 3)), CAST(389.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2353 AS Numeric(4, 0)), CAST(14.210 AS Numeric(7, 3)), CAST(391.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2354 AS Numeric(4, 0)), CAST(14.220 AS Numeric(7, 3)), CAST(392.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2355 AS Numeric(4, 0)), CAST(14.230 AS Numeric(7, 3)), CAST(394.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2356 AS Numeric(4, 0)), CAST(14.240 AS Numeric(7, 3)), CAST(396.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2357 AS Numeric(4, 0)), CAST(14.250 AS Numeric(7, 3)), CAST(398.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2358 AS Numeric(4, 0)), CAST(14.260 AS Numeric(7, 3)), CAST(399.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2359 AS Numeric(4, 0)), CAST(14.270 AS Numeric(7, 3)), CAST(401.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2360 AS Numeric(4, 0)), CAST(14.280 AS Numeric(7, 3)), CAST(403.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2361 AS Numeric(4, 0)), CAST(14.290 AS Numeric(7, 3)), CAST(405.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2362 AS Numeric(4, 0)), CAST(14.300 AS Numeric(7, 3)), CAST(407.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2363 AS Numeric(4, 0)), CAST(14.310 AS Numeric(7, 3)), CAST(408.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2364 AS Numeric(4, 0)), CAST(14.320 AS Numeric(7, 3)), CAST(410.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2365 AS Numeric(4, 0)), CAST(14.330 AS Numeric(7, 3)), CAST(412.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2366 AS Numeric(4, 0)), CAST(14.340 AS Numeric(7, 3)), CAST(414.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2367 AS Numeric(4, 0)), CAST(14.350 AS Numeric(7, 3)), CAST(416.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2368 AS Numeric(4, 0)), CAST(14.360 AS Numeric(7, 3)), CAST(418.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2369 AS Numeric(4, 0)), CAST(14.370 AS Numeric(7, 3)), CAST(420.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2370 AS Numeric(4, 0)), CAST(14.380 AS Numeric(7, 3)), CAST(422.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2371 AS Numeric(4, 0)), CAST(14.390 AS Numeric(7, 3)), CAST(423.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2372 AS Numeric(4, 0)), CAST(14.400 AS Numeric(7, 3)), CAST(425.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2373 AS Numeric(4, 0)), CAST(14.410 AS Numeric(7, 3)), CAST(427.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2374 AS Numeric(4, 0)), CAST(14.420 AS Numeric(7, 3)), CAST(429.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2375 AS Numeric(4, 0)), CAST(14.430 AS Numeric(7, 3)), CAST(431.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2376 AS Numeric(4, 0)), CAST(14.440 AS Numeric(7, 3)), CAST(433.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2377 AS Numeric(4, 0)), CAST(14.450 AS Numeric(7, 3)), CAST(435.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2378 AS Numeric(4, 0)), CAST(14.460 AS Numeric(7, 3)), CAST(437.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2379 AS Numeric(4, 0)), CAST(14.470 AS Numeric(7, 3)), CAST(438.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2380 AS Numeric(4, 0)), CAST(14.480 AS Numeric(7, 3)), CAST(440.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2381 AS Numeric(4, 0)), CAST(14.490 AS Numeric(7, 3)), CAST(442.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2382 AS Numeric(4, 0)), CAST(14.500 AS Numeric(7, 3)), CAST(444.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2383 AS Numeric(4, 0)), CAST(14.510 AS Numeric(7, 3)), CAST(446.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2384 AS Numeric(4, 0)), CAST(14.520 AS Numeric(7, 3)), CAST(448.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2385 AS Numeric(4, 0)), CAST(14.530 AS Numeric(7, 3)), CAST(450.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2386 AS Numeric(4, 0)), CAST(14.540 AS Numeric(7, 3)), CAST(452.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2387 AS Numeric(4, 0)), CAST(14.550 AS Numeric(7, 3)), CAST(454.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2388 AS Numeric(4, 0)), CAST(14.560 AS Numeric(7, 3)), CAST(456.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2389 AS Numeric(4, 0)), CAST(14.570 AS Numeric(7, 3)), CAST(458.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2390 AS Numeric(4, 0)), CAST(14.580 AS Numeric(7, 3)), CAST(460.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2391 AS Numeric(4, 0)), CAST(14.590 AS Numeric(7, 3)), CAST(462.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2392 AS Numeric(4, 0)), CAST(14.600 AS Numeric(7, 3)), CAST(464.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2393 AS Numeric(4, 0)), CAST(14.610 AS Numeric(7, 3)), CAST(466.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2394 AS Numeric(4, 0)), CAST(14.620 AS Numeric(7, 3)), CAST(468.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2395 AS Numeric(4, 0)), CAST(14.630 AS Numeric(7, 3)), CAST(470.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2396 AS Numeric(4, 0)), CAST(14.640 AS Numeric(7, 3)), CAST(472.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2397 AS Numeric(4, 0)), CAST(14.650 AS Numeric(7, 3)), CAST(474.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2398 AS Numeric(4, 0)), CAST(14.660 AS Numeric(7, 3)), CAST(476.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2399 AS Numeric(4, 0)), CAST(14.670 AS Numeric(7, 3)), CAST(478.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2400 AS Numeric(4, 0)), CAST(14.680 AS Numeric(7, 3)), CAST(480.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2401 AS Numeric(4, 0)), CAST(14.690 AS Numeric(7, 3)), CAST(482.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2402 AS Numeric(4, 0)), CAST(14.700 AS Numeric(7, 3)), CAST(484.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2403 AS Numeric(4, 0)), CAST(14.710 AS Numeric(7, 3)), CAST(486.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2404 AS Numeric(4, 0)), CAST(14.720 AS Numeric(7, 3)), CAST(488.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2405 AS Numeric(4, 0)), CAST(14.730 AS Numeric(7, 3)), CAST(490.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2406 AS Numeric(4, 0)), CAST(14.740 AS Numeric(7, 3)), CAST(492.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2407 AS Numeric(4, 0)), CAST(14.750 AS Numeric(7, 3)), CAST(494.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2408 AS Numeric(4, 0)), CAST(14.760 AS Numeric(7, 3)), CAST(496.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2409 AS Numeric(4, 0)), CAST(14.770 AS Numeric(7, 3)), CAST(498.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2410 AS Numeric(4, 0)), CAST(14.780 AS Numeric(7, 3)), CAST(500.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2411 AS Numeric(4, 0)), CAST(14.790 AS Numeric(7, 3)), CAST(502.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2412 AS Numeric(4, 0)), CAST(14.800 AS Numeric(7, 3)), CAST(504.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2413 AS Numeric(4, 0)), CAST(14.810 AS Numeric(7, 3)), CAST(506.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2414 AS Numeric(4, 0)), CAST(14.820 AS Numeric(7, 3)), CAST(508.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2415 AS Numeric(4, 0)), CAST(14.830 AS Numeric(7, 3)), CAST(510.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2416 AS Numeric(4, 0)), CAST(14.840 AS Numeric(7, 3)), CAST(512.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2417 AS Numeric(4, 0)), CAST(14.850 AS Numeric(7, 3)), CAST(514.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2418 AS Numeric(4, 0)), CAST(14.860 AS Numeric(7, 3)), CAST(516.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2419 AS Numeric(4, 0)), CAST(14.870 AS Numeric(7, 3)), CAST(519.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2420 AS Numeric(4, 0)), CAST(14.880 AS Numeric(7, 3)), CAST(521.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2421 AS Numeric(4, 0)), CAST(14.890 AS Numeric(7, 3)), CAST(523.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2422 AS Numeric(4, 0)), CAST(14.900 AS Numeric(7, 3)), CAST(525.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2423 AS Numeric(4, 0)), CAST(14.910 AS Numeric(7, 3)), CAST(527.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2424 AS Numeric(4, 0)), CAST(14.920 AS Numeric(7, 3)), CAST(529.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2425 AS Numeric(4, 0)), CAST(14.930 AS Numeric(7, 3)), CAST(531.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2426 AS Numeric(4, 0)), CAST(14.940 AS Numeric(7, 3)), CAST(533.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2427 AS Numeric(4, 0)), CAST(14.950 AS Numeric(7, 3)), CAST(535.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2428 AS Numeric(4, 0)), CAST(14.960 AS Numeric(7, 3)), CAST(538.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2429 AS Numeric(4, 0)), CAST(14.970 AS Numeric(7, 3)), CAST(540.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2430 AS Numeric(4, 0)), CAST(14.980 AS Numeric(7, 3)), CAST(542.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2431 AS Numeric(4, 0)), CAST(14.990 AS Numeric(7, 3)), CAST(544.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2432 AS Numeric(4, 0)), CAST(15.000 AS Numeric(7, 3)), CAST(546.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2433 AS Numeric(4, 0)), CAST(15.010 AS Numeric(7, 3)), CAST(548.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2434 AS Numeric(4, 0)), CAST(15.020 AS Numeric(7, 3)), CAST(550.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2435 AS Numeric(4, 0)), CAST(15.030 AS Numeric(7, 3)), CAST(553.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2436 AS Numeric(4, 0)), CAST(15.040 AS Numeric(7, 3)), CAST(555.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2437 AS Numeric(4, 0)), CAST(15.050 AS Numeric(7, 3)), CAST(557.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2438 AS Numeric(4, 0)), CAST(15.060 AS Numeric(7, 3)), CAST(559.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2439 AS Numeric(4, 0)), CAST(15.070 AS Numeric(7, 3)), CAST(561.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2440 AS Numeric(4, 0)), CAST(15.080 AS Numeric(7, 3)), CAST(563.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2441 AS Numeric(4, 0)), CAST(15.090 AS Numeric(7, 3)), CAST(565.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2442 AS Numeric(4, 0)), CAST(15.100 AS Numeric(7, 3)), CAST(568.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2443 AS Numeric(4, 0)), CAST(15.110 AS Numeric(7, 3)), CAST(570.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2444 AS Numeric(4, 0)), CAST(15.120 AS Numeric(7, 3)), CAST(572.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2445 AS Numeric(4, 0)), CAST(15.130 AS Numeric(7, 3)), CAST(574.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2446 AS Numeric(4, 0)), CAST(15.140 AS Numeric(7, 3)), CAST(576.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2447 AS Numeric(4, 0)), CAST(15.150 AS Numeric(7, 3)), CAST(579.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2448 AS Numeric(4, 0)), CAST(15.160 AS Numeric(7, 3)), CAST(581.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2449 AS Numeric(4, 0)), CAST(15.170 AS Numeric(7, 3)), CAST(583.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2450 AS Numeric(4, 0)), CAST(15.180 AS Numeric(7, 3)), CAST(585.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2451 AS Numeric(4, 0)), CAST(15.190 AS Numeric(7, 3)), CAST(588.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2452 AS Numeric(4, 0)), CAST(15.200 AS Numeric(7, 3)), CAST(590.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2453 AS Numeric(4, 0)), CAST(15.210 AS Numeric(7, 3)), CAST(592.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2454 AS Numeric(4, 0)), CAST(15.220 AS Numeric(7, 3)), CAST(594.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2455 AS Numeric(4, 0)), CAST(15.230 AS Numeric(7, 3)), CAST(596.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2456 AS Numeric(4, 0)), CAST(15.240 AS Numeric(7, 3)), CAST(599.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2457 AS Numeric(4, 0)), CAST(15.250 AS Numeric(7, 3)), CAST(601.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2458 AS Numeric(4, 0)), CAST(15.260 AS Numeric(7, 3)), CAST(603.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2459 AS Numeric(4, 0)), CAST(15.270 AS Numeric(7, 3)), CAST(605.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2460 AS Numeric(4, 0)), CAST(15.280 AS Numeric(7, 3)), CAST(608.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2461 AS Numeric(4, 0)), CAST(15.290 AS Numeric(7, 3)), CAST(610.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2462 AS Numeric(4, 0)), CAST(15.300 AS Numeric(7, 3)), CAST(612.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2463 AS Numeric(4, 0)), CAST(15.310 AS Numeric(7, 3)), CAST(614.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2464 AS Numeric(4, 0)), CAST(15.320 AS Numeric(7, 3)), CAST(617.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2465 AS Numeric(4, 0)), CAST(15.330 AS Numeric(7, 3)), CAST(619.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2466 AS Numeric(4, 0)), CAST(15.340 AS Numeric(7, 3)), CAST(621.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2467 AS Numeric(4, 0)), CAST(15.350 AS Numeric(7, 3)), CAST(624.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2468 AS Numeric(4, 0)), CAST(15.360 AS Numeric(7, 3)), CAST(626.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2469 AS Numeric(4, 0)), CAST(15.370 AS Numeric(7, 3)), CAST(628.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2470 AS Numeric(4, 0)), CAST(15.380 AS Numeric(7, 3)), CAST(630.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2471 AS Numeric(4, 0)), CAST(15.390 AS Numeric(7, 3)), CAST(633.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2472 AS Numeric(4, 0)), CAST(15.400 AS Numeric(7, 3)), CAST(635.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2473 AS Numeric(4, 0)), CAST(15.410 AS Numeric(7, 3)), CAST(637.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2474 AS Numeric(4, 0)), CAST(15.420 AS Numeric(7, 3)), CAST(640.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2475 AS Numeric(4, 0)), CAST(15.430 AS Numeric(7, 3)), CAST(642.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2476 AS Numeric(4, 0)), CAST(15.440 AS Numeric(7, 3)), CAST(644.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2477 AS Numeric(4, 0)), CAST(15.450 AS Numeric(7, 3)), CAST(647.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2478 AS Numeric(4, 0)), CAST(15.460 AS Numeric(7, 3)), CAST(649.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2479 AS Numeric(4, 0)), CAST(15.470 AS Numeric(7, 3)), CAST(651.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2480 AS Numeric(4, 0)), CAST(15.480 AS Numeric(7, 3)), CAST(654.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2481 AS Numeric(4, 0)), CAST(15.490 AS Numeric(7, 3)), CAST(656.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2482 AS Numeric(4, 0)), CAST(15.500 AS Numeric(7, 3)), CAST(658.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2483 AS Numeric(4, 0)), CAST(15.510 AS Numeric(7, 3)), CAST(661.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2484 AS Numeric(4, 0)), CAST(15.520 AS Numeric(7, 3)), CAST(663.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2485 AS Numeric(4, 0)), CAST(15.530 AS Numeric(7, 3)), CAST(666.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2486 AS Numeric(4, 0)), CAST(15.540 AS Numeric(7, 3)), CAST(668.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2487 AS Numeric(4, 0)), CAST(15.550 AS Numeric(7, 3)), CAST(670.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2488 AS Numeric(4, 0)), CAST(15.560 AS Numeric(7, 3)), CAST(673.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2489 AS Numeric(4, 0)), CAST(15.570 AS Numeric(7, 3)), CAST(675.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2490 AS Numeric(4, 0)), CAST(15.580 AS Numeric(7, 3)), CAST(678.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2491 AS Numeric(4, 0)), CAST(15.590 AS Numeric(7, 3)), CAST(680.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2492 AS Numeric(4, 0)), CAST(15.600 AS Numeric(7, 3)), CAST(682.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2493 AS Numeric(4, 0)), CAST(15.610 AS Numeric(7, 3)), CAST(685.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2494 AS Numeric(4, 0)), CAST(15.620 AS Numeric(7, 3)), CAST(687.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2495 AS Numeric(4, 0)), CAST(15.630 AS Numeric(7, 3)), CAST(690.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2496 AS Numeric(4, 0)), CAST(15.640 AS Numeric(7, 3)), CAST(692.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2497 AS Numeric(4, 0)), CAST(15.650 AS Numeric(7, 3)), CAST(694.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2498 AS Numeric(4, 0)), CAST(15.660 AS Numeric(7, 3)), CAST(697.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2499 AS Numeric(4, 0)), CAST(15.670 AS Numeric(7, 3)), CAST(699.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2500 AS Numeric(4, 0)), CAST(15.680 AS Numeric(7, 3)), CAST(702.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2501 AS Numeric(4, 0)), CAST(15.690 AS Numeric(7, 3)), CAST(704.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2502 AS Numeric(4, 0)), CAST(15.700 AS Numeric(7, 3)), CAST(707.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2503 AS Numeric(4, 0)), CAST(15.710 AS Numeric(7, 3)), CAST(709.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2504 AS Numeric(4, 0)), CAST(15.720 AS Numeric(7, 3)), CAST(712.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2505 AS Numeric(4, 0)), CAST(15.730 AS Numeric(7, 3)), CAST(714.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2506 AS Numeric(4, 0)), CAST(15.740 AS Numeric(7, 3)), CAST(717.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2507 AS Numeric(4, 0)), CAST(15.750 AS Numeric(7, 3)), CAST(719.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2508 AS Numeric(4, 0)), CAST(15.760 AS Numeric(7, 3)), CAST(722.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2509 AS Numeric(4, 0)), CAST(15.770 AS Numeric(7, 3)), CAST(724.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2510 AS Numeric(4, 0)), CAST(15.780 AS Numeric(7, 3)), CAST(727.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2511 AS Numeric(4, 0)), CAST(15.790 AS Numeric(7, 3)), CAST(729.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2512 AS Numeric(4, 0)), CAST(15.800 AS Numeric(7, 3)), CAST(732.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2513 AS Numeric(4, 0)), CAST(15.810 AS Numeric(7, 3)), CAST(734.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2514 AS Numeric(4, 0)), CAST(15.820 AS Numeric(7, 3)), CAST(737.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2515 AS Numeric(4, 0)), CAST(15.830 AS Numeric(7, 3)), CAST(739.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2516 AS Numeric(4, 0)), CAST(15.840 AS Numeric(7, 3)), CAST(742.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2517 AS Numeric(4, 0)), CAST(15.850 AS Numeric(7, 3)), CAST(745.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2518 AS Numeric(4, 0)), CAST(15.860 AS Numeric(7, 3)), CAST(747.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2519 AS Numeric(4, 0)), CAST(15.870 AS Numeric(7, 3)), CAST(750.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2520 AS Numeric(4, 0)), CAST(15.880 AS Numeric(7, 3)), CAST(752.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2521 AS Numeric(4, 0)), CAST(15.890 AS Numeric(7, 3)), CAST(755.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2522 AS Numeric(4, 0)), CAST(15.900 AS Numeric(7, 3)), CAST(757.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2523 AS Numeric(4, 0)), CAST(15.910 AS Numeric(7, 3)), CAST(760.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2524 AS Numeric(4, 0)), CAST(15.920 AS Numeric(7, 3)), CAST(763.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2525 AS Numeric(4, 0)), CAST(15.930 AS Numeric(7, 3)), CAST(765.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2526 AS Numeric(4, 0)), CAST(15.940 AS Numeric(7, 3)), CAST(768.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2527 AS Numeric(4, 0)), CAST(15.950 AS Numeric(7, 3)), CAST(770.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2528 AS Numeric(4, 0)), CAST(15.960 AS Numeric(7, 3)), CAST(773.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2529 AS Numeric(4, 0)), CAST(15.970 AS Numeric(7, 3)), CAST(776.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2530 AS Numeric(4, 0)), CAST(15.980 AS Numeric(7, 3)), CAST(778.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2531 AS Numeric(4, 0)), CAST(15.990 AS Numeric(7, 3)), CAST(781.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2532 AS Numeric(4, 0)), CAST(16.000 AS Numeric(7, 3)), CAST(784.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2533 AS Numeric(4, 0)), CAST(16.010 AS Numeric(7, 3)), CAST(786.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2534 AS Numeric(4, 0)), CAST(16.020 AS Numeric(7, 3)), CAST(789.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2535 AS Numeric(4, 0)), CAST(16.030 AS Numeric(7, 3)), CAST(792.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2536 AS Numeric(4, 0)), CAST(16.040 AS Numeric(7, 3)), CAST(794.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2537 AS Numeric(4, 0)), CAST(16.050 AS Numeric(7, 3)), CAST(797.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2538 AS Numeric(4, 0)), CAST(16.060 AS Numeric(7, 3)), CAST(800.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2539 AS Numeric(4, 0)), CAST(16.070 AS Numeric(7, 3)), CAST(802.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2540 AS Numeric(4, 0)), CAST(16.080 AS Numeric(7, 3)), CAST(805.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2541 AS Numeric(4, 0)), CAST(16.090 AS Numeric(7, 3)), CAST(808.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2542 AS Numeric(4, 0)), CAST(16.100 AS Numeric(7, 3)), CAST(810.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2543 AS Numeric(4, 0)), CAST(16.110 AS Numeric(7, 3)), CAST(813.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2544 AS Numeric(4, 0)), CAST(16.120 AS Numeric(7, 3)), CAST(816.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2545 AS Numeric(4, 0)), CAST(16.130 AS Numeric(7, 3)), CAST(819.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2546 AS Numeric(4, 0)), CAST(16.140 AS Numeric(7, 3)), CAST(821.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2547 AS Numeric(4, 0)), CAST(16.150 AS Numeric(7, 3)), CAST(824.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2548 AS Numeric(4, 0)), CAST(16.160 AS Numeric(7, 3)), CAST(827.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2549 AS Numeric(4, 0)), CAST(16.170 AS Numeric(7, 3)), CAST(830.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2550 AS Numeric(4, 0)), CAST(16.180 AS Numeric(7, 3)), CAST(832.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2551 AS Numeric(4, 0)), CAST(16.190 AS Numeric(7, 3)), CAST(835.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2552 AS Numeric(4, 0)), CAST(16.200 AS Numeric(7, 3)), CAST(838.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2553 AS Numeric(4, 0)), CAST(16.210 AS Numeric(7, 3)), CAST(841.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2554 AS Numeric(4, 0)), CAST(16.220 AS Numeric(7, 3)), CAST(844.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2555 AS Numeric(4, 0)), CAST(16.230 AS Numeric(7, 3)), CAST(846.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2556 AS Numeric(4, 0)), CAST(16.240 AS Numeric(7, 3)), CAST(849.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2557 AS Numeric(4, 0)), CAST(16.250 AS Numeric(7, 3)), CAST(852.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2558 AS Numeric(4, 0)), CAST(16.260 AS Numeric(7, 3)), CAST(855.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2559 AS Numeric(4, 0)), CAST(16.270 AS Numeric(7, 3)), CAST(857.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2560 AS Numeric(4, 0)), CAST(16.280 AS Numeric(7, 3)), CAST(860.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2561 AS Numeric(4, 0)), CAST(16.290 AS Numeric(7, 3)), CAST(863.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2562 AS Numeric(4, 0)), CAST(16.300 AS Numeric(7, 3)), CAST(866.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2563 AS Numeric(4, 0)), CAST(16.310 AS Numeric(7, 3)), CAST(869.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2564 AS Numeric(4, 0)), CAST(16.320 AS Numeric(7, 3)), CAST(872.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2565 AS Numeric(4, 0)), CAST(16.330 AS Numeric(7, 3)), CAST(874.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2566 AS Numeric(4, 0)), CAST(16.340 AS Numeric(7, 3)), CAST(877.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2567 AS Numeric(4, 0)), CAST(16.350 AS Numeric(7, 3)), CAST(880.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2568 AS Numeric(4, 0)), CAST(16.360 AS Numeric(7, 3)), CAST(883.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2569 AS Numeric(4, 0)), CAST(16.370 AS Numeric(7, 3)), CAST(886.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2570 AS Numeric(4, 0)), CAST(16.380 AS Numeric(7, 3)), CAST(889.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2571 AS Numeric(4, 0)), CAST(16.390 AS Numeric(7, 3)), CAST(892.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2572 AS Numeric(4, 0)), CAST(16.400 AS Numeric(7, 3)), CAST(895.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2573 AS Numeric(4, 0)), CAST(16.410 AS Numeric(7, 3)), CAST(897.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2574 AS Numeric(4, 0)), CAST(16.420 AS Numeric(7, 3)), CAST(900.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2575 AS Numeric(4, 0)), CAST(16.430 AS Numeric(7, 3)), CAST(903.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2576 AS Numeric(4, 0)), CAST(16.440 AS Numeric(7, 3)), CAST(906.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2577 AS Numeric(4, 0)), CAST(16.450 AS Numeric(7, 3)), CAST(909.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2578 AS Numeric(4, 0)), CAST(16.460 AS Numeric(7, 3)), CAST(912.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2579 AS Numeric(4, 0)), CAST(16.470 AS Numeric(7, 3)), CAST(915.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2580 AS Numeric(4, 0)), CAST(16.480 AS Numeric(7, 3)), CAST(918.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2581 AS Numeric(4, 0)), CAST(16.490 AS Numeric(7, 3)), CAST(921.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2582 AS Numeric(4, 0)), CAST(16.500 AS Numeric(7, 3)), CAST(924.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2583 AS Numeric(4, 0)), CAST(16.510 AS Numeric(7, 3)), CAST(927.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2584 AS Numeric(4, 0)), CAST(16.520 AS Numeric(7, 3)), CAST(930.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2585 AS Numeric(4, 0)), CAST(16.530 AS Numeric(7, 3)), CAST(933.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2586 AS Numeric(4, 0)), CAST(16.540 AS Numeric(7, 3)), CAST(936.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2587 AS Numeric(4, 0)), CAST(16.550 AS Numeric(7, 3)), CAST(939.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2588 AS Numeric(4, 0)), CAST(16.560 AS Numeric(7, 3)), CAST(942.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2589 AS Numeric(4, 0)), CAST(16.570 AS Numeric(7, 3)), CAST(945.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2590 AS Numeric(4, 0)), CAST(16.580 AS Numeric(7, 3)), CAST(947.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2591 AS Numeric(4, 0)), CAST(16.590 AS Numeric(7, 3)), CAST(950.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2592 AS Numeric(4, 0)), CAST(16.600 AS Numeric(7, 3)), CAST(953.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2593 AS Numeric(4, 0)), CAST(16.610 AS Numeric(7, 3)), CAST(957.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2594 AS Numeric(4, 0)), CAST(16.620 AS Numeric(7, 3)), CAST(960.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2595 AS Numeric(4, 0)), CAST(16.630 AS Numeric(7, 3)), CAST(963.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2596 AS Numeric(4, 0)), CAST(16.640 AS Numeric(7, 3)), CAST(966.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2597 AS Numeric(4, 0)), CAST(16.650 AS Numeric(7, 3)), CAST(969.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2598 AS Numeric(4, 0)), CAST(16.660 AS Numeric(7, 3)), CAST(972.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2599 AS Numeric(4, 0)), CAST(16.670 AS Numeric(7, 3)), CAST(975.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2600 AS Numeric(4, 0)), CAST(16.680 AS Numeric(7, 3)), CAST(978.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2601 AS Numeric(4, 0)), CAST(16.690 AS Numeric(7, 3)), CAST(981.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2602 AS Numeric(4, 0)), CAST(16.700 AS Numeric(7, 3)), CAST(984.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2603 AS Numeric(4, 0)), CAST(16.710 AS Numeric(7, 3)), CAST(987.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2604 AS Numeric(4, 0)), CAST(16.720 AS Numeric(7, 3)), CAST(990.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2605 AS Numeric(4, 0)), CAST(16.730 AS Numeric(7, 3)), CAST(993.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2606 AS Numeric(4, 0)), CAST(16.740 AS Numeric(7, 3)), CAST(996.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2607 AS Numeric(4, 0)), CAST(16.750 AS Numeric(7, 3)), CAST(999.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2608 AS Numeric(4, 0)), CAST(16.760 AS Numeric(7, 3)), CAST(1002.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2609 AS Numeric(4, 0)), CAST(16.770 AS Numeric(7, 3)), CAST(1006.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2610 AS Numeric(4, 0)), CAST(16.780 AS Numeric(7, 3)), CAST(1009.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2611 AS Numeric(4, 0)), CAST(16.790 AS Numeric(7, 3)), CAST(1012.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2612 AS Numeric(4, 0)), CAST(16.800 AS Numeric(7, 3)), CAST(1015.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2613 AS Numeric(4, 0)), CAST(16.810 AS Numeric(7, 3)), CAST(1018.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2614 AS Numeric(4, 0)), CAST(16.820 AS Numeric(7, 3)), CAST(1021.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2615 AS Numeric(4, 0)), CAST(16.830 AS Numeric(7, 3)), CAST(1024.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2616 AS Numeric(4, 0)), CAST(16.840 AS Numeric(7, 3)), CAST(1028.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2617 AS Numeric(4, 0)), CAST(16.850 AS Numeric(7, 3)), CAST(1031.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2618 AS Numeric(4, 0)), CAST(16.860 AS Numeric(7, 3)), CAST(1034.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2619 AS Numeric(4, 0)), CAST(16.870 AS Numeric(7, 3)), CAST(1037.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2620 AS Numeric(4, 0)), CAST(16.880 AS Numeric(7, 3)), CAST(1040.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2621 AS Numeric(4, 0)), CAST(16.890 AS Numeric(7, 3)), CAST(1043.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2622 AS Numeric(4, 0)), CAST(16.900 AS Numeric(7, 3)), CAST(1047.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2623 AS Numeric(4, 0)), CAST(16.910 AS Numeric(7, 3)), CAST(1050.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2624 AS Numeric(4, 0)), CAST(16.920 AS Numeric(7, 3)), CAST(1053.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2625 AS Numeric(4, 0)), CAST(16.930 AS Numeric(7, 3)), CAST(1056.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2626 AS Numeric(4, 0)), CAST(16.940 AS Numeric(7, 3)), CAST(1059.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2627 AS Numeric(4, 0)), CAST(16.950 AS Numeric(7, 3)), CAST(1063.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2628 AS Numeric(4, 0)), CAST(16.960 AS Numeric(7, 3)), CAST(1066.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2629 AS Numeric(4, 0)), CAST(16.970 AS Numeric(7, 3)), CAST(1069.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2630 AS Numeric(4, 0)), CAST(16.980 AS Numeric(7, 3)), CAST(1072.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2631 AS Numeric(4, 0)), CAST(16.990 AS Numeric(7, 3)), CAST(1075.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2632 AS Numeric(4, 0)), CAST(17.000 AS Numeric(7, 3)), CAST(1079.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2633 AS Numeric(4, 0)), CAST(17.010 AS Numeric(7, 3)), CAST(1082.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2634 AS Numeric(4, 0)), CAST(17.020 AS Numeric(7, 3)), CAST(1085.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2635 AS Numeric(4, 0)), CAST(17.030 AS Numeric(7, 3)), CAST(1089.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2636 AS Numeric(4, 0)), CAST(17.040 AS Numeric(7, 3)), CAST(1092.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2637 AS Numeric(4, 0)), CAST(17.050 AS Numeric(7, 3)), CAST(1095.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2638 AS Numeric(4, 0)), CAST(17.060 AS Numeric(7, 3)), CAST(1098.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2639 AS Numeric(4, 0)), CAST(17.070 AS Numeric(7, 3)), CAST(1102.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2640 AS Numeric(4, 0)), CAST(17.080 AS Numeric(7, 3)), CAST(1105.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2641 AS Numeric(4, 0)), CAST(17.090 AS Numeric(7, 3)), CAST(1108.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2642 AS Numeric(4, 0)), CAST(17.100 AS Numeric(7, 3)), CAST(1111.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2643 AS Numeric(4, 0)), CAST(17.110 AS Numeric(7, 3)), CAST(1115.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2644 AS Numeric(4, 0)), CAST(17.120 AS Numeric(7, 3)), CAST(1118.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2645 AS Numeric(4, 0)), CAST(17.130 AS Numeric(7, 3)), CAST(1121.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2646 AS Numeric(4, 0)), CAST(17.140 AS Numeric(7, 3)), CAST(1125.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2647 AS Numeric(4, 0)), CAST(17.150 AS Numeric(7, 3)), CAST(1128.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2648 AS Numeric(4, 0)), CAST(17.160 AS Numeric(7, 3)), CAST(1131.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2649 AS Numeric(4, 0)), CAST(17.170 AS Numeric(7, 3)), CAST(1135.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2650 AS Numeric(4, 0)), CAST(17.180 AS Numeric(7, 3)), CAST(1138.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2651 AS Numeric(4, 0)), CAST(17.190 AS Numeric(7, 3)), CAST(1142.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2652 AS Numeric(4, 0)), CAST(17.200 AS Numeric(7, 3)), CAST(1145.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2653 AS Numeric(4, 0)), CAST(17.210 AS Numeric(7, 3)), CAST(1148.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2654 AS Numeric(4, 0)), CAST(17.220 AS Numeric(7, 3)), CAST(1152.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2655 AS Numeric(4, 0)), CAST(17.230 AS Numeric(7, 3)), CAST(1155.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2656 AS Numeric(4, 0)), CAST(17.240 AS Numeric(7, 3)), CAST(1159.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2657 AS Numeric(4, 0)), CAST(17.250 AS Numeric(7, 3)), CAST(1162.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2658 AS Numeric(4, 0)), CAST(17.260 AS Numeric(7, 3)), CAST(1165.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2659 AS Numeric(4, 0)), CAST(17.270 AS Numeric(7, 3)), CAST(1169.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2660 AS Numeric(4, 0)), CAST(17.280 AS Numeric(7, 3)), CAST(1172.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2661 AS Numeric(4, 0)), CAST(17.290 AS Numeric(7, 3)), CAST(1176.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2662 AS Numeric(4, 0)), CAST(17.300 AS Numeric(7, 3)), CAST(1179.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2663 AS Numeric(4, 0)), CAST(17.310 AS Numeric(7, 3)), CAST(1182.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2664 AS Numeric(4, 0)), CAST(17.320 AS Numeric(7, 3)), CAST(1186.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2665 AS Numeric(4, 0)), CAST(17.330 AS Numeric(7, 3)), CAST(1189.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2666 AS Numeric(4, 0)), CAST(17.340 AS Numeric(7, 3)), CAST(1193.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2667 AS Numeric(4, 0)), CAST(17.350 AS Numeric(7, 3)), CAST(1196.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2668 AS Numeric(4, 0)), CAST(17.360 AS Numeric(7, 3)), CAST(1200.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2669 AS Numeric(4, 0)), CAST(17.370 AS Numeric(7, 3)), CAST(1203.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2670 AS Numeric(4, 0)), CAST(17.380 AS Numeric(7, 3)), CAST(1207.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2671 AS Numeric(4, 0)), CAST(17.390 AS Numeric(7, 3)), CAST(1210.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2672 AS Numeric(4, 0)), CAST(17.400 AS Numeric(7, 3)), CAST(1213.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2673 AS Numeric(4, 0)), CAST(17.410 AS Numeric(7, 3)), CAST(1217.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2674 AS Numeric(4, 0)), CAST(17.420 AS Numeric(7, 3)), CAST(1221.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2675 AS Numeric(4, 0)), CAST(17.430 AS Numeric(7, 3)), CAST(1224.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2676 AS Numeric(4, 0)), CAST(17.440 AS Numeric(7, 3)), CAST(1228.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2677 AS Numeric(4, 0)), CAST(17.450 AS Numeric(7, 3)), CAST(1231.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2678 AS Numeric(4, 0)), CAST(17.460 AS Numeric(7, 3)), CAST(1235.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2679 AS Numeric(4, 0)), CAST(17.470 AS Numeric(7, 3)), CAST(1238.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2680 AS Numeric(4, 0)), CAST(17.480 AS Numeric(7, 3)), CAST(1242.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2681 AS Numeric(4, 0)), CAST(17.490 AS Numeric(7, 3)), CAST(1246.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2682 AS Numeric(4, 0)), CAST(17.500 AS Numeric(7, 3)), CAST(1249.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2683 AS Numeric(4, 0)), CAST(17.510 AS Numeric(7, 3)), CAST(1253.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2684 AS Numeric(4, 0)), CAST(17.520 AS Numeric(7, 3)), CAST(1256.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2685 AS Numeric(4, 0)), CAST(17.530 AS Numeric(7, 3)), CAST(1260.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2686 AS Numeric(4, 0)), CAST(17.540 AS Numeric(7, 3)), CAST(1263.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2687 AS Numeric(4, 0)), CAST(17.550 AS Numeric(7, 3)), CAST(1267.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2688 AS Numeric(4, 0)), CAST(17.560 AS Numeric(7, 3)), CAST(1270.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2689 AS Numeric(4, 0)), CAST(17.570 AS Numeric(7, 3)), CAST(1274.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2690 AS Numeric(4, 0)), CAST(17.580 AS Numeric(7, 3)), CAST(1278.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2691 AS Numeric(4, 0)), CAST(17.590 AS Numeric(7, 3)), CAST(1281.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2692 AS Numeric(4, 0)), CAST(17.600 AS Numeric(7, 3)), CAST(1285.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2693 AS Numeric(4, 0)), CAST(17.610 AS Numeric(7, 3)), CAST(1288.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2694 AS Numeric(4, 0)), CAST(17.620 AS Numeric(7, 3)), CAST(1292.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2695 AS Numeric(4, 0)), CAST(17.630 AS Numeric(7, 3)), CAST(1296.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2696 AS Numeric(4, 0)), CAST(17.640 AS Numeric(7, 3)), CAST(1299.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2697 AS Numeric(4, 0)), CAST(17.650 AS Numeric(7, 3)), CAST(1303.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2698 AS Numeric(4, 0)), CAST(17.660 AS Numeric(7, 3)), CAST(1307.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2699 AS Numeric(4, 0)), CAST(17.670 AS Numeric(7, 3)), CAST(1311.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2700 AS Numeric(4, 0)), CAST(17.680 AS Numeric(7, 3)), CAST(1314.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2701 AS Numeric(4, 0)), CAST(17.690 AS Numeric(7, 3)), CAST(1318.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2702 AS Numeric(4, 0)), CAST(17.700 AS Numeric(7, 3)), CAST(1322.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2703 AS Numeric(4, 0)), CAST(17.710 AS Numeric(7, 3)), CAST(1325.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2704 AS Numeric(4, 0)), CAST(17.720 AS Numeric(7, 3)), CAST(1329.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2705 AS Numeric(4, 0)), CAST(17.730 AS Numeric(7, 3)), CAST(1333.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2706 AS Numeric(4, 0)), CAST(17.740 AS Numeric(7, 3)), CAST(1336.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2707 AS Numeric(4, 0)), CAST(17.750 AS Numeric(7, 3)), CAST(1340.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2708 AS Numeric(4, 0)), CAST(17.760 AS Numeric(7, 3)), CAST(1344.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2709 AS Numeric(4, 0)), CAST(17.770 AS Numeric(7, 3)), CAST(1347.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2710 AS Numeric(4, 0)), CAST(17.780 AS Numeric(7, 3)), CAST(1351.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2711 AS Numeric(4, 0)), CAST(17.790 AS Numeric(7, 3)), CAST(1354.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2712 AS Numeric(4, 0)), CAST(17.800 AS Numeric(7, 3)), CAST(1358.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2713 AS Numeric(4, 0)), CAST(17.810 AS Numeric(7, 3)), CAST(1362.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2714 AS Numeric(4, 0)), CAST(17.820 AS Numeric(7, 3)), CAST(1366.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2715 AS Numeric(4, 0)), CAST(17.830 AS Numeric(7, 3)), CAST(1370.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2716 AS Numeric(4, 0)), CAST(17.840 AS Numeric(7, 3)), CAST(1373.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2717 AS Numeric(4, 0)), CAST(17.850 AS Numeric(7, 3)), CAST(1377.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2718 AS Numeric(4, 0)), CAST(17.860 AS Numeric(7, 3)), CAST(1381.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2719 AS Numeric(4, 0)), CAST(17.870 AS Numeric(7, 3)), CAST(1385.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2720 AS Numeric(4, 0)), CAST(17.880 AS Numeric(7, 3)), CAST(1389.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2721 AS Numeric(4, 0)), CAST(17.890 AS Numeric(7, 3)), CAST(1393.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2722 AS Numeric(4, 0)), CAST(17.900 AS Numeric(7, 3)), CAST(1396.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2723 AS Numeric(4, 0)), CAST(17.910 AS Numeric(7, 3)), CAST(1400.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2724 AS Numeric(4, 0)), CAST(17.920 AS Numeric(7, 3)), CAST(1404.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2725 AS Numeric(4, 0)), CAST(17.930 AS Numeric(7, 3)), CAST(1408.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2726 AS Numeric(4, 0)), CAST(17.940 AS Numeric(7, 3)), CAST(1411.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2727 AS Numeric(4, 0)), CAST(17.950 AS Numeric(7, 3)), CAST(1415.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2728 AS Numeric(4, 0)), CAST(17.960 AS Numeric(7, 3)), CAST(1419.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2729 AS Numeric(4, 0)), CAST(17.970 AS Numeric(7, 3)), CAST(1423.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2730 AS Numeric(4, 0)), CAST(17.980 AS Numeric(7, 3)), CAST(1427.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2731 AS Numeric(4, 0)), CAST(17.990 AS Numeric(7, 3)), CAST(1430.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2732 AS Numeric(4, 0)), CAST(18.000 AS Numeric(7, 3)), CAST(1434.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2733 AS Numeric(4, 0)), CAST(18.010 AS Numeric(7, 3)), CAST(1438.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2734 AS Numeric(4, 0)), CAST(18.020 AS Numeric(7, 3)), CAST(1442.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2735 AS Numeric(4, 0)), CAST(18.030 AS Numeric(7, 3)), CAST(1446.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2736 AS Numeric(4, 0)), CAST(18.040 AS Numeric(7, 3)), CAST(1450.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2737 AS Numeric(4, 0)), CAST(18.050 AS Numeric(7, 3)), CAST(1454.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2738 AS Numeric(4, 0)), CAST(18.060 AS Numeric(7, 3)), CAST(1458.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2739 AS Numeric(4, 0)), CAST(18.070 AS Numeric(7, 3)), CAST(1462.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2740 AS Numeric(4, 0)), CAST(18.080 AS Numeric(7, 3)), CAST(1466.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2741 AS Numeric(4, 0)), CAST(18.090 AS Numeric(7, 3)), CAST(1470.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2742 AS Numeric(4, 0)), CAST(18.100 AS Numeric(7, 3)), CAST(1474.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2743 AS Numeric(4, 0)), CAST(18.110 AS Numeric(7, 3)), CAST(1477.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2744 AS Numeric(4, 0)), CAST(18.120 AS Numeric(7, 3)), CAST(1481.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2745 AS Numeric(4, 0)), CAST(18.130 AS Numeric(7, 3)), CAST(1485.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2746 AS Numeric(4, 0)), CAST(18.140 AS Numeric(7, 3)), CAST(1489.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2747 AS Numeric(4, 0)), CAST(18.150 AS Numeric(7, 3)), CAST(1493.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2748 AS Numeric(4, 0)), CAST(18.160 AS Numeric(7, 3)), CAST(1497.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2749 AS Numeric(4, 0)), CAST(18.170 AS Numeric(7, 3)), CAST(1501.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2750 AS Numeric(4, 0)), CAST(18.180 AS Numeric(7, 3)), CAST(1505.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2751 AS Numeric(4, 0)), CAST(18.190 AS Numeric(7, 3)), CAST(1508.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2752 AS Numeric(4, 0)), CAST(18.200 AS Numeric(7, 3)), CAST(1512.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2753 AS Numeric(4, 0)), CAST(18.210 AS Numeric(7, 3)), CAST(1516.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2754 AS Numeric(4, 0)), CAST(18.220 AS Numeric(7, 3)), CAST(1520.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2755 AS Numeric(4, 0)), CAST(18.230 AS Numeric(7, 3)), CAST(1525.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2756 AS Numeric(4, 0)), CAST(18.240 AS Numeric(7, 3)), CAST(1529.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2757 AS Numeric(4, 0)), CAST(18.250 AS Numeric(7, 3)), CAST(1533.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2758 AS Numeric(4, 0)), CAST(18.260 AS Numeric(7, 3)), CAST(1537.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2759 AS Numeric(4, 0)), CAST(18.270 AS Numeric(7, 3)), CAST(1541.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2760 AS Numeric(4, 0)), CAST(18.280 AS Numeric(7, 3)), CAST(1545.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2761 AS Numeric(4, 0)), CAST(18.290 AS Numeric(7, 3)), CAST(1549.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2762 AS Numeric(4, 0)), CAST(18.300 AS Numeric(7, 3)), CAST(1553.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2763 AS Numeric(4, 0)), CAST(18.310 AS Numeric(7, 3)), CAST(1557.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2764 AS Numeric(4, 0)), CAST(18.320 AS Numeric(7, 3)), CAST(1561.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2765 AS Numeric(4, 0)), CAST(18.330 AS Numeric(7, 3)), CAST(1565.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2766 AS Numeric(4, 0)), CAST(18.340 AS Numeric(7, 3)), CAST(1569.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2767 AS Numeric(4, 0)), CAST(18.350 AS Numeric(7, 3)), CAST(1573.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2768 AS Numeric(4, 0)), CAST(18.360 AS Numeric(7, 3)), CAST(1577.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2769 AS Numeric(4, 0)), CAST(18.370 AS Numeric(7, 3)), CAST(1581.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2770 AS Numeric(4, 0)), CAST(18.380 AS Numeric(7, 3)), CAST(1585.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2771 AS Numeric(4, 0)), CAST(18.390 AS Numeric(7, 3)), CAST(1589.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2772 AS Numeric(4, 0)), CAST(18.400 AS Numeric(7, 3)), CAST(1593.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2773 AS Numeric(4, 0)), CAST(18.410 AS Numeric(7, 3)), CAST(1597.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2774 AS Numeric(4, 0)), CAST(18.420 AS Numeric(7, 3)), CAST(1602.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2775 AS Numeric(4, 0)), CAST(18.430 AS Numeric(7, 3)), CAST(1606.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2776 AS Numeric(4, 0)), CAST(18.440 AS Numeric(7, 3)), CAST(1610.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2777 AS Numeric(4, 0)), CAST(18.450 AS Numeric(7, 3)), CAST(1614.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2778 AS Numeric(4, 0)), CAST(18.460 AS Numeric(7, 3)), CAST(1618.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2779 AS Numeric(4, 0)), CAST(18.470 AS Numeric(7, 3)), CAST(1623.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2780 AS Numeric(4, 0)), CAST(18.480 AS Numeric(7, 3)), CAST(1627.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2781 AS Numeric(4, 0)), CAST(18.490 AS Numeric(7, 3)), CAST(1631.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2782 AS Numeric(4, 0)), CAST(18.500 AS Numeric(7, 3)), CAST(1635.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2783 AS Numeric(4, 0)), CAST(18.510 AS Numeric(7, 3)), CAST(1639.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2784 AS Numeric(4, 0)), CAST(18.520 AS Numeric(7, 3)), CAST(1643.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2785 AS Numeric(4, 0)), CAST(18.530 AS Numeric(7, 3)), CAST(1648.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2786 AS Numeric(4, 0)), CAST(18.540 AS Numeric(7, 3)), CAST(1652.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2787 AS Numeric(4, 0)), CAST(18.550 AS Numeric(7, 3)), CAST(1656.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2788 AS Numeric(4, 0)), CAST(18.560 AS Numeric(7, 3)), CAST(1660.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2789 AS Numeric(4, 0)), CAST(18.570 AS Numeric(7, 3)), CAST(1664.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2790 AS Numeric(4, 0)), CAST(18.580 AS Numeric(7, 3)), CAST(1668.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2791 AS Numeric(4, 0)), CAST(18.590 AS Numeric(7, 3)), CAST(1672.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2792 AS Numeric(4, 0)), CAST(18.600 AS Numeric(7, 3)), CAST(1676.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2793 AS Numeric(4, 0)), CAST(18.610 AS Numeric(7, 3)), CAST(1681.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2794 AS Numeric(4, 0)), CAST(18.620 AS Numeric(7, 3)), CAST(1685.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2795 AS Numeric(4, 0)), CAST(18.630 AS Numeric(7, 3)), CAST(1689.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2796 AS Numeric(4, 0)), CAST(18.640 AS Numeric(7, 3)), CAST(1694.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2797 AS Numeric(4, 0)), CAST(18.650 AS Numeric(7, 3)), CAST(1698.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2798 AS Numeric(4, 0)), CAST(18.660 AS Numeric(7, 3)), CAST(1702.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2799 AS Numeric(4, 0)), CAST(18.670 AS Numeric(7, 3)), CAST(1707.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2800 AS Numeric(4, 0)), CAST(18.680 AS Numeric(7, 3)), CAST(1711.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2801 AS Numeric(4, 0)), CAST(18.690 AS Numeric(7, 3)), CAST(1715.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2802 AS Numeric(4, 0)), CAST(18.700 AS Numeric(7, 3)), CAST(1720.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2803 AS Numeric(4, 0)), CAST(18.710 AS Numeric(7, 3)), CAST(1724.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2804 AS Numeric(4, 0)), CAST(18.720 AS Numeric(7, 3)), CAST(1728.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2805 AS Numeric(4, 0)), CAST(18.730 AS Numeric(7, 3)), CAST(1732.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2806 AS Numeric(4, 0)), CAST(18.740 AS Numeric(7, 3)), CAST(1737.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2807 AS Numeric(4, 0)), CAST(18.750 AS Numeric(7, 3)), CAST(1741.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2808 AS Numeric(4, 0)), CAST(18.760 AS Numeric(7, 3)), CAST(1745.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2809 AS Numeric(4, 0)), CAST(18.770 AS Numeric(7, 3)), CAST(1749.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2810 AS Numeric(4, 0)), CAST(18.780 AS Numeric(7, 3)), CAST(1754.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2811 AS Numeric(4, 0)), CAST(18.790 AS Numeric(7, 3)), CAST(1758.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2812 AS Numeric(4, 0)), CAST(18.800 AS Numeric(7, 3)), CAST(1762.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2813 AS Numeric(4, 0)), CAST(18.810 AS Numeric(7, 3)), CAST(1767.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2814 AS Numeric(4, 0)), CAST(18.820 AS Numeric(7, 3)), CAST(1771.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2815 AS Numeric(4, 0)), CAST(18.830 AS Numeric(7, 3)), CAST(1775.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2816 AS Numeric(4, 0)), CAST(18.840 AS Numeric(7, 3)), CAST(1780.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2817 AS Numeric(4, 0)), CAST(18.850 AS Numeric(7, 3)), CAST(1784.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2818 AS Numeric(4, 0)), CAST(18.860 AS Numeric(7, 3)), CAST(1789.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2819 AS Numeric(4, 0)), CAST(18.870 AS Numeric(7, 3)), CAST(1793.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2820 AS Numeric(4, 0)), CAST(18.880 AS Numeric(7, 3)), CAST(1798.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2821 AS Numeric(4, 0)), CAST(18.890 AS Numeric(7, 3)), CAST(1802.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2822 AS Numeric(4, 0)), CAST(18.900 AS Numeric(7, 3)), CAST(1806.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2823 AS Numeric(4, 0)), CAST(18.910 AS Numeric(7, 3)), CAST(1811.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2824 AS Numeric(4, 0)), CAST(18.920 AS Numeric(7, 3)), CAST(1815.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2825 AS Numeric(4, 0)), CAST(18.930 AS Numeric(7, 3)), CAST(1820.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2826 AS Numeric(4, 0)), CAST(18.940 AS Numeric(7, 3)), CAST(1824.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2827 AS Numeric(4, 0)), CAST(18.950 AS Numeric(7, 3)), CAST(1828.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2828 AS Numeric(4, 0)), CAST(18.960 AS Numeric(7, 3)), CAST(1833.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2829 AS Numeric(4, 0)), CAST(18.970 AS Numeric(7, 3)), CAST(1837.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2830 AS Numeric(4, 0)), CAST(18.980 AS Numeric(7, 3)), CAST(1842.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2831 AS Numeric(4, 0)), CAST(18.990 AS Numeric(7, 3)), CAST(1846.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2832 AS Numeric(4, 0)), CAST(19.000 AS Numeric(7, 3)), CAST(1850.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2833 AS Numeric(4, 0)), CAST(19.010 AS Numeric(7, 3)), CAST(1855.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2834 AS Numeric(4, 0)), CAST(19.020 AS Numeric(7, 3)), CAST(1859.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2835 AS Numeric(4, 0)), CAST(19.030 AS Numeric(7, 3)), CAST(1864.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2836 AS Numeric(4, 0)), CAST(19.040 AS Numeric(7, 3)), CAST(1868.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2837 AS Numeric(4, 0)), CAST(19.050 AS Numeric(7, 3)), CAST(1873.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2838 AS Numeric(4, 0)), CAST(19.060 AS Numeric(7, 3)), CAST(1878.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2839 AS Numeric(4, 0)), CAST(19.070 AS Numeric(7, 3)), CAST(1882.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2840 AS Numeric(4, 0)), CAST(19.080 AS Numeric(7, 3)), CAST(1887.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2841 AS Numeric(4, 0)), CAST(19.090 AS Numeric(7, 3)), CAST(1891.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2842 AS Numeric(4, 0)), CAST(19.100 AS Numeric(7, 3)), CAST(1896.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2843 AS Numeric(4, 0)), CAST(19.110 AS Numeric(7, 3)), CAST(1900.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2844 AS Numeric(4, 0)), CAST(19.120 AS Numeric(7, 3)), CAST(1905.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2845 AS Numeric(4, 0)), CAST(19.130 AS Numeric(7, 3)), CAST(1909.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2846 AS Numeric(4, 0)), CAST(19.140 AS Numeric(7, 3)), CAST(1914.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2847 AS Numeric(4, 0)), CAST(19.150 AS Numeric(7, 3)), CAST(1918.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2848 AS Numeric(4, 0)), CAST(19.160 AS Numeric(7, 3)), CAST(1923.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2849 AS Numeric(4, 0)), CAST(19.170 AS Numeric(7, 3)), CAST(1927.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2850 AS Numeric(4, 0)), CAST(19.180 AS Numeric(7, 3)), CAST(1932.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2851 AS Numeric(4, 0)), CAST(19.190 AS Numeric(7, 3)), CAST(1936.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2852 AS Numeric(4, 0)), CAST(19.200 AS Numeric(7, 3)), CAST(1941.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2853 AS Numeric(4, 0)), CAST(19.210 AS Numeric(7, 3)), CAST(1945.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2854 AS Numeric(4, 0)), CAST(19.220 AS Numeric(7, 3)), CAST(1950.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2855 AS Numeric(4, 0)), CAST(19.230 AS Numeric(7, 3)), CAST(1955.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2856 AS Numeric(4, 0)), CAST(19.240 AS Numeric(7, 3)), CAST(1959.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2857 AS Numeric(4, 0)), CAST(19.250 AS Numeric(7, 3)), CAST(1964.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2858 AS Numeric(4, 0)), CAST(19.260 AS Numeric(7, 3)), CAST(1969.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2859 AS Numeric(4, 0)), CAST(19.270 AS Numeric(7, 3)), CAST(1973.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2860 AS Numeric(4, 0)), CAST(19.280 AS Numeric(7, 3)), CAST(1978.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2861 AS Numeric(4, 0)), CAST(19.290 AS Numeric(7, 3)), CAST(1983.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2862 AS Numeric(4, 0)), CAST(19.300 AS Numeric(7, 3)), CAST(1987.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2863 AS Numeric(4, 0)), CAST(19.310 AS Numeric(7, 3)), CAST(1992.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2864 AS Numeric(4, 0)), CAST(19.320 AS Numeric(7, 3)), CAST(1997.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2865 AS Numeric(4, 0)), CAST(19.330 AS Numeric(7, 3)), CAST(2001.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2866 AS Numeric(4, 0)), CAST(19.340 AS Numeric(7, 3)), CAST(2006.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2867 AS Numeric(4, 0)), CAST(19.350 AS Numeric(7, 3)), CAST(2010.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2868 AS Numeric(4, 0)), CAST(19.360 AS Numeric(7, 3)), CAST(2015.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2869 AS Numeric(4, 0)), CAST(19.370 AS Numeric(7, 3)), CAST(2020.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2870 AS Numeric(4, 0)), CAST(19.380 AS Numeric(7, 3)), CAST(2024.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2871 AS Numeric(4, 0)), CAST(19.390 AS Numeric(7, 3)), CAST(2029.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2872 AS Numeric(4, 0)), CAST(19.400 AS Numeric(7, 3)), CAST(2034.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2873 AS Numeric(4, 0)), CAST(19.410 AS Numeric(7, 3)), CAST(2038.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2874 AS Numeric(4, 0)), CAST(19.420 AS Numeric(7, 3)), CAST(2043.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2875 AS Numeric(4, 0)), CAST(19.430 AS Numeric(7, 3)), CAST(2048.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2876 AS Numeric(4, 0)), CAST(19.440 AS Numeric(7, 3)), CAST(2053.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2877 AS Numeric(4, 0)), CAST(19.450 AS Numeric(7, 3)), CAST(2058.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2878 AS Numeric(4, 0)), CAST(19.460 AS Numeric(7, 3)), CAST(2062.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2879 AS Numeric(4, 0)), CAST(19.470 AS Numeric(7, 3)), CAST(2067.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2880 AS Numeric(4, 0)), CAST(19.480 AS Numeric(7, 3)), CAST(2072.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2881 AS Numeric(4, 0)), CAST(19.490 AS Numeric(7, 3)), CAST(2077.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2882 AS Numeric(4, 0)), CAST(19.500 AS Numeric(7, 3)), CAST(2081.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2883 AS Numeric(4, 0)), CAST(19.510 AS Numeric(7, 3)), CAST(2086.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2884 AS Numeric(4, 0)), CAST(19.520 AS Numeric(7, 3)), CAST(2091.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2885 AS Numeric(4, 0)), CAST(19.530 AS Numeric(7, 3)), CAST(2096.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2886 AS Numeric(4, 0)), CAST(19.540 AS Numeric(7, 3)), CAST(2100.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2887 AS Numeric(4, 0)), CAST(19.550 AS Numeric(7, 3)), CAST(2105.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2888 AS Numeric(4, 0)), CAST(19.560 AS Numeric(7, 3)), CAST(2110.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2889 AS Numeric(4, 0)), CAST(19.570 AS Numeric(7, 3)), CAST(2115.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2890 AS Numeric(4, 0)), CAST(19.580 AS Numeric(7, 3)), CAST(2119.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2891 AS Numeric(4, 0)), CAST(19.590 AS Numeric(7, 3)), CAST(2124.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2892 AS Numeric(4, 0)), CAST(19.600 AS Numeric(7, 3)), CAST(2129.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2893 AS Numeric(4, 0)), CAST(19.610 AS Numeric(7, 3)), CAST(2134.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2894 AS Numeric(4, 0)), CAST(19.620 AS Numeric(7, 3)), CAST(2139.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2895 AS Numeric(4, 0)), CAST(19.630 AS Numeric(7, 3)), CAST(2144.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2896 AS Numeric(4, 0)), CAST(19.640 AS Numeric(7, 3)), CAST(2148.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2897 AS Numeric(4, 0)), CAST(19.650 AS Numeric(7, 3)), CAST(2153.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2898 AS Numeric(4, 0)), CAST(19.660 AS Numeric(7, 3)), CAST(2158.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2899 AS Numeric(4, 0)), CAST(19.670 AS Numeric(7, 3)), CAST(2163.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2900 AS Numeric(4, 0)), CAST(19.680 AS Numeric(7, 3)), CAST(2168.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2901 AS Numeric(4, 0)), CAST(19.690 AS Numeric(7, 3)), CAST(2173.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2902 AS Numeric(4, 0)), CAST(19.700 AS Numeric(7, 3)), CAST(2178.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2903 AS Numeric(4, 0)), CAST(19.710 AS Numeric(7, 3)), CAST(2183.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2904 AS Numeric(4, 0)), CAST(19.720 AS Numeric(7, 3)), CAST(2188.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2905 AS Numeric(4, 0)), CAST(19.730 AS Numeric(7, 3)), CAST(2193.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2906 AS Numeric(4, 0)), CAST(19.740 AS Numeric(7, 3)), CAST(2197.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2907 AS Numeric(4, 0)), CAST(19.750 AS Numeric(7, 3)), CAST(2202.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2908 AS Numeric(4, 0)), CAST(19.760 AS Numeric(7, 3)), CAST(2207.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2909 AS Numeric(4, 0)), CAST(19.770 AS Numeric(7, 3)), CAST(2212.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2910 AS Numeric(4, 0)), CAST(19.780 AS Numeric(7, 3)), CAST(2217.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2911 AS Numeric(4, 0)), CAST(19.790 AS Numeric(7, 3)), CAST(2222.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2912 AS Numeric(4, 0)), CAST(19.800 AS Numeric(7, 3)), CAST(2227.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2913 AS Numeric(4, 0)), CAST(19.810 AS Numeric(7, 3)), CAST(2232.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2914 AS Numeric(4, 0)), CAST(19.820 AS Numeric(7, 3)), CAST(2237.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2915 AS Numeric(4, 0)), CAST(19.830 AS Numeric(7, 3)), CAST(2242.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2916 AS Numeric(4, 0)), CAST(19.840 AS Numeric(7, 3)), CAST(2247.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2917 AS Numeric(4, 0)), CAST(19.850 AS Numeric(7, 3)), CAST(2252.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2918 AS Numeric(4, 0)), CAST(19.860 AS Numeric(7, 3)), CAST(2257.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2919 AS Numeric(4, 0)), CAST(19.870 AS Numeric(7, 3)), CAST(2262.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2920 AS Numeric(4, 0)), CAST(19.880 AS Numeric(7, 3)), CAST(2267.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2921 AS Numeric(4, 0)), CAST(19.890 AS Numeric(7, 3)), CAST(2272.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2922 AS Numeric(4, 0)), CAST(19.900 AS Numeric(7, 3)), CAST(2277.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2923 AS Numeric(4, 0)), CAST(19.910 AS Numeric(7, 3)), CAST(2282.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2924 AS Numeric(4, 0)), CAST(19.920 AS Numeric(7, 3)), CAST(2287.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2925 AS Numeric(4, 0)), CAST(19.930 AS Numeric(7, 3)), CAST(2292.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2926 AS Numeric(4, 0)), CAST(19.940 AS Numeric(7, 3)), CAST(2297.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2927 AS Numeric(4, 0)), CAST(19.950 AS Numeric(7, 3)), CAST(2302.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2928 AS Numeric(4, 0)), CAST(19.960 AS Numeric(7, 3)), CAST(2307.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2929 AS Numeric(4, 0)), CAST(19.970 AS Numeric(7, 3)), CAST(2312.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2930 AS Numeric(4, 0)), CAST(19.980 AS Numeric(7, 3)), CAST(2317.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2931 AS Numeric(4, 0)), CAST(19.990 AS Numeric(7, 3)), CAST(2322.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2932 AS Numeric(4, 0)), CAST(20.000 AS Numeric(7, 3)), CAST(2327.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2933 AS Numeric(4, 0)), CAST(20.010 AS Numeric(7, 3)), CAST(2332.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2934 AS Numeric(4, 0)), CAST(20.020 AS Numeric(7, 3)), CAST(2338.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2935 AS Numeric(4, 0)), CAST(20.030 AS Numeric(7, 3)), CAST(2343.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2936 AS Numeric(4, 0)), CAST(20.040 AS Numeric(7, 3)), CAST(2348.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2937 AS Numeric(4, 0)), CAST(20.050 AS Numeric(7, 3)), CAST(2353.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2938 AS Numeric(4, 0)), CAST(20.060 AS Numeric(7, 3)), CAST(2358.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2939 AS Numeric(4, 0)), CAST(20.070 AS Numeric(7, 3)), CAST(2364.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2940 AS Numeric(4, 0)), CAST(20.080 AS Numeric(7, 3)), CAST(2369.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2941 AS Numeric(4, 0)), CAST(20.090 AS Numeric(7, 3)), CAST(2374.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2942 AS Numeric(4, 0)), CAST(20.100 AS Numeric(7, 3)), CAST(2379.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2943 AS Numeric(4, 0)), CAST(20.110 AS Numeric(7, 3)), CAST(2384.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2944 AS Numeric(4, 0)), CAST(20.120 AS Numeric(7, 3)), CAST(2389.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2945 AS Numeric(4, 0)), CAST(20.130 AS Numeric(7, 3)), CAST(2395.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2946 AS Numeric(4, 0)), CAST(20.140 AS Numeric(7, 3)), CAST(2400.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2947 AS Numeric(4, 0)), CAST(20.150 AS Numeric(7, 3)), CAST(2405.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2948 AS Numeric(4, 0)), CAST(20.160 AS Numeric(7, 3)), CAST(2410.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2949 AS Numeric(4, 0)), CAST(20.170 AS Numeric(7, 3)), CAST(2415.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2950 AS Numeric(4, 0)), CAST(20.180 AS Numeric(7, 3)), CAST(2420.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2951 AS Numeric(4, 0)), CAST(20.190 AS Numeric(7, 3)), CAST(2425.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2952 AS Numeric(4, 0)), CAST(20.200 AS Numeric(7, 3)), CAST(2431.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2953 AS Numeric(4, 0)), CAST(20.210 AS Numeric(7, 3)), CAST(2436.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2954 AS Numeric(4, 0)), CAST(20.220 AS Numeric(7, 3)), CAST(2441.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2955 AS Numeric(4, 0)), CAST(20.230 AS Numeric(7, 3)), CAST(2447.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2956 AS Numeric(4, 0)), CAST(20.240 AS Numeric(7, 3)), CAST(2452.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2957 AS Numeric(4, 0)), CAST(20.250 AS Numeric(7, 3)), CAST(2457.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2958 AS Numeric(4, 0)), CAST(20.260 AS Numeric(7, 3)), CAST(2463.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2959 AS Numeric(4, 0)), CAST(20.270 AS Numeric(7, 3)), CAST(2468.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2960 AS Numeric(4, 0)), CAST(20.280 AS Numeric(7, 3)), CAST(2473.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2961 AS Numeric(4, 0)), CAST(20.290 AS Numeric(7, 3)), CAST(2479.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2962 AS Numeric(4, 0)), CAST(20.300 AS Numeric(7, 3)), CAST(2484.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2963 AS Numeric(4, 0)), CAST(20.310 AS Numeric(7, 3)), CAST(2489.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2964 AS Numeric(4, 0)), CAST(20.320 AS Numeric(7, 3)), CAST(2495.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2965 AS Numeric(4, 0)), CAST(20.330 AS Numeric(7, 3)), CAST(2500.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2966 AS Numeric(4, 0)), CAST(20.340 AS Numeric(7, 3)), CAST(2505.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2967 AS Numeric(4, 0)), CAST(20.350 AS Numeric(7, 3)), CAST(2510.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2968 AS Numeric(4, 0)), CAST(20.360 AS Numeric(7, 3)), CAST(2516.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2969 AS Numeric(4, 0)), CAST(20.370 AS Numeric(7, 3)), CAST(2521.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2970 AS Numeric(4, 0)), CAST(20.380 AS Numeric(7, 3)), CAST(2526.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2971 AS Numeric(4, 0)), CAST(20.390 AS Numeric(7, 3)), CAST(2532.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2972 AS Numeric(4, 0)), CAST(20.400 AS Numeric(7, 3)), CAST(2537.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2973 AS Numeric(4, 0)), CAST(20.410 AS Numeric(7, 3)), CAST(2542.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2974 AS Numeric(4, 0)), CAST(20.420 AS Numeric(7, 3)), CAST(2548.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2975 AS Numeric(4, 0)), CAST(20.430 AS Numeric(7, 3)), CAST(2553.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2976 AS Numeric(4, 0)), CAST(20.440 AS Numeric(7, 3)), CAST(2559.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2977 AS Numeric(4, 0)), CAST(20.450 AS Numeric(7, 3)), CAST(2564.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2978 AS Numeric(4, 0)), CAST(20.460 AS Numeric(7, 3)), CAST(2570.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2979 AS Numeric(4, 0)), CAST(20.470 AS Numeric(7, 3)), CAST(2575.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2980 AS Numeric(4, 0)), CAST(20.480 AS Numeric(7, 3)), CAST(2581.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2981 AS Numeric(4, 0)), CAST(20.490 AS Numeric(7, 3)), CAST(2586.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2982 AS Numeric(4, 0)), CAST(20.500 AS Numeric(7, 3)), CAST(2592.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2983 AS Numeric(4, 0)), CAST(20.510 AS Numeric(7, 3)), CAST(2597.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2984 AS Numeric(4, 0)), CAST(20.520 AS Numeric(7, 3)), CAST(2603.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2985 AS Numeric(4, 0)), CAST(20.530 AS Numeric(7, 3)), CAST(2608.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2986 AS Numeric(4, 0)), CAST(20.540 AS Numeric(7, 3)), CAST(2614.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2987 AS Numeric(4, 0)), CAST(20.550 AS Numeric(7, 3)), CAST(2619.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2988 AS Numeric(4, 0)), CAST(20.560 AS Numeric(7, 3)), CAST(2625.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2989 AS Numeric(4, 0)), CAST(20.570 AS Numeric(7, 3)), CAST(2630.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2990 AS Numeric(4, 0)), CAST(20.580 AS Numeric(7, 3)), CAST(2635.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2991 AS Numeric(4, 0)), CAST(20.590 AS Numeric(7, 3)), CAST(2641.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2992 AS Numeric(4, 0)), CAST(20.600 AS Numeric(7, 3)), CAST(2646.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2993 AS Numeric(4, 0)), CAST(20.610 AS Numeric(7, 3)), CAST(2652.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2994 AS Numeric(4, 0)), CAST(20.620 AS Numeric(7, 3)), CAST(2658.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2995 AS Numeric(4, 0)), CAST(20.630 AS Numeric(7, 3)), CAST(2663.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2996 AS Numeric(4, 0)), CAST(20.640 AS Numeric(7, 3)), CAST(2669.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2997 AS Numeric(4, 0)), CAST(20.650 AS Numeric(7, 3)), CAST(2674.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2998 AS Numeric(4, 0)), CAST(20.660 AS Numeric(7, 3)), CAST(2680.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(2999 AS Numeric(4, 0)), CAST(20.670 AS Numeric(7, 3)), CAST(2686.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3000 AS Numeric(4, 0)), CAST(20.680 AS Numeric(7, 3)), CAST(2691.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3001 AS Numeric(4, 0)), CAST(20.690 AS Numeric(7, 3)), CAST(2697.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3002 AS Numeric(4, 0)), CAST(20.700 AS Numeric(7, 3)), CAST(2703.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3003 AS Numeric(4, 0)), CAST(20.710 AS Numeric(7, 3)), CAST(2708.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3004 AS Numeric(4, 0)), CAST(20.720 AS Numeric(7, 3)), CAST(2714.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3005 AS Numeric(4, 0)), CAST(20.730 AS Numeric(7, 3)), CAST(2719.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3006 AS Numeric(4, 0)), CAST(20.740 AS Numeric(7, 3)), CAST(2725.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3007 AS Numeric(4, 0)), CAST(20.750 AS Numeric(7, 3)), CAST(2731.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3008 AS Numeric(4, 0)), CAST(20.760 AS Numeric(7, 3)), CAST(2736.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3009 AS Numeric(4, 0)), CAST(20.770 AS Numeric(7, 3)), CAST(2742.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3010 AS Numeric(4, 0)), CAST(20.780 AS Numeric(7, 3)), CAST(2748.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3011 AS Numeric(4, 0)), CAST(20.790 AS Numeric(7, 3)), CAST(2753.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3012 AS Numeric(4, 0)), CAST(20.800 AS Numeric(7, 3)), CAST(2759.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3013 AS Numeric(4, 0)), CAST(20.810 AS Numeric(7, 3)), CAST(2765.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3014 AS Numeric(4, 0)), CAST(20.820 AS Numeric(7, 3)), CAST(2770.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3015 AS Numeric(4, 0)), CAST(20.830 AS Numeric(7, 3)), CAST(2776.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3016 AS Numeric(4, 0)), CAST(20.840 AS Numeric(7, 3)), CAST(2782.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3017 AS Numeric(4, 0)), CAST(20.850 AS Numeric(7, 3)), CAST(2788.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3018 AS Numeric(4, 0)), CAST(20.860 AS Numeric(7, 3)), CAST(2793.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3019 AS Numeric(4, 0)), CAST(20.870 AS Numeric(7, 3)), CAST(2799.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3020 AS Numeric(4, 0)), CAST(20.880 AS Numeric(7, 3)), CAST(2805.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3021 AS Numeric(4, 0)), CAST(20.890 AS Numeric(7, 3)), CAST(2811.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3022 AS Numeric(4, 0)), CAST(20.900 AS Numeric(7, 3)), CAST(2817.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3023 AS Numeric(4, 0)), CAST(20.910 AS Numeric(7, 3)), CAST(2822.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3024 AS Numeric(4, 0)), CAST(20.920 AS Numeric(7, 3)), CAST(2828.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3025 AS Numeric(4, 0)), CAST(20.930 AS Numeric(7, 3)), CAST(2834.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3026 AS Numeric(4, 0)), CAST(20.940 AS Numeric(7, 3)), CAST(2840.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3027 AS Numeric(4, 0)), CAST(20.950 AS Numeric(7, 3)), CAST(2845.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3028 AS Numeric(4, 0)), CAST(20.960 AS Numeric(7, 3)), CAST(2851.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3029 AS Numeric(4, 0)), CAST(20.970 AS Numeric(7, 3)), CAST(2857.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3030 AS Numeric(4, 0)), CAST(20.980 AS Numeric(7, 3)), CAST(2863.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3031 AS Numeric(4, 0)), CAST(20.990 AS Numeric(7, 3)), CAST(2869.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3032 AS Numeric(4, 0)), CAST(21.000 AS Numeric(7, 3)), CAST(2874.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3033 AS Numeric(4, 0)), CAST(21.010 AS Numeric(7, 3)), CAST(2880.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3034 AS Numeric(4, 0)), CAST(21.020 AS Numeric(7, 3)), CAST(2886.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3035 AS Numeric(4, 0)), CAST(21.030 AS Numeric(7, 3)), CAST(2892.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3036 AS Numeric(4, 0)), CAST(21.040 AS Numeric(7, 3)), CAST(2898.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3037 AS Numeric(4, 0)), CAST(21.050 AS Numeric(7, 3)), CAST(2904.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3038 AS Numeric(4, 0)), CAST(21.060 AS Numeric(7, 3)), CAST(2910.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3039 AS Numeric(4, 0)), CAST(21.070 AS Numeric(7, 3)), CAST(2916.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3040 AS Numeric(4, 0)), CAST(21.080 AS Numeric(7, 3)), CAST(2922.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3041 AS Numeric(4, 0)), CAST(21.090 AS Numeric(7, 3)), CAST(2928.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3042 AS Numeric(4, 0)), CAST(21.100 AS Numeric(7, 3)), CAST(2934.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3043 AS Numeric(4, 0)), CAST(21.110 AS Numeric(7, 3)), CAST(2940.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3044 AS Numeric(4, 0)), CAST(21.120 AS Numeric(7, 3)), CAST(2946.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3045 AS Numeric(4, 0)), CAST(21.130 AS Numeric(7, 3)), CAST(2951.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3046 AS Numeric(4, 0)), CAST(21.140 AS Numeric(7, 3)), CAST(2957.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3047 AS Numeric(4, 0)), CAST(21.150 AS Numeric(7, 3)), CAST(2963.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3048 AS Numeric(4, 0)), CAST(21.160 AS Numeric(7, 3)), CAST(2969.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3049 AS Numeric(4, 0)), CAST(21.170 AS Numeric(7, 3)), CAST(2975.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3050 AS Numeric(4, 0)), CAST(21.180 AS Numeric(7, 3)), CAST(2981.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3051 AS Numeric(4, 0)), CAST(21.190 AS Numeric(7, 3)), CAST(2987.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3052 AS Numeric(4, 0)), CAST(21.200 AS Numeric(7, 3)), CAST(2993.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3053 AS Numeric(4, 0)), CAST(21.210 AS Numeric(7, 3)), CAST(2999.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3054 AS Numeric(4, 0)), CAST(21.220 AS Numeric(7, 3)), CAST(3005.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3055 AS Numeric(4, 0)), CAST(21.230 AS Numeric(7, 3)), CAST(3011.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3056 AS Numeric(4, 0)), CAST(21.240 AS Numeric(7, 3)), CAST(3017.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3057 AS Numeric(4, 0)), CAST(21.250 AS Numeric(7, 3)), CAST(3023.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3058 AS Numeric(4, 0)), CAST(21.260 AS Numeric(7, 3)), CAST(3029.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3059 AS Numeric(4, 0)), CAST(21.270 AS Numeric(7, 3)), CAST(3035.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3060 AS Numeric(4, 0)), CAST(21.280 AS Numeric(7, 3)), CAST(3042.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3061 AS Numeric(4, 0)), CAST(21.290 AS Numeric(7, 3)), CAST(3048.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3062 AS Numeric(4, 0)), CAST(21.300 AS Numeric(7, 3)), CAST(3054.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3063 AS Numeric(4, 0)), CAST(21.310 AS Numeric(7, 3)), CAST(3060.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3064 AS Numeric(4, 0)), CAST(21.320 AS Numeric(7, 3)), CAST(3066.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3065 AS Numeric(4, 0)), CAST(21.330 AS Numeric(7, 3)), CAST(3072.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3066 AS Numeric(4, 0)), CAST(21.340 AS Numeric(7, 3)), CAST(3078.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3067 AS Numeric(4, 0)), CAST(21.350 AS Numeric(7, 3)), CAST(3084.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3068 AS Numeric(4, 0)), CAST(21.360 AS Numeric(7, 3)), CAST(3090.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3069 AS Numeric(4, 0)), CAST(21.370 AS Numeric(7, 3)), CAST(3096.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3070 AS Numeric(4, 0)), CAST(21.380 AS Numeric(7, 3)), CAST(3102.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3071 AS Numeric(4, 0)), CAST(21.390 AS Numeric(7, 3)), CAST(3109.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3072 AS Numeric(4, 0)), CAST(21.400 AS Numeric(7, 3)), CAST(3115.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3073 AS Numeric(4, 0)), CAST(21.410 AS Numeric(7, 3)), CAST(3121.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3074 AS Numeric(4, 0)), CAST(21.420 AS Numeric(7, 3)), CAST(3127.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3075 AS Numeric(4, 0)), CAST(21.430 AS Numeric(7, 3)), CAST(3133.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3076 AS Numeric(4, 0)), CAST(21.440 AS Numeric(7, 3)), CAST(3140.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3077 AS Numeric(4, 0)), CAST(21.450 AS Numeric(7, 3)), CAST(3146.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3078 AS Numeric(4, 0)), CAST(21.460 AS Numeric(7, 3)), CAST(3152.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3079 AS Numeric(4, 0)), CAST(21.470 AS Numeric(7, 3)), CAST(3158.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3080 AS Numeric(4, 0)), CAST(21.480 AS Numeric(7, 3)), CAST(3164.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3081 AS Numeric(4, 0)), CAST(21.490 AS Numeric(7, 3)), CAST(3171.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3082 AS Numeric(4, 0)), CAST(21.500 AS Numeric(7, 3)), CAST(3177.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3083 AS Numeric(4, 0)), CAST(21.510 AS Numeric(7, 3)), CAST(3183.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3084 AS Numeric(4, 0)), CAST(21.520 AS Numeric(7, 3)), CAST(3189.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3085 AS Numeric(4, 0)), CAST(21.530 AS Numeric(7, 3)), CAST(3196.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3086 AS Numeric(4, 0)), CAST(21.540 AS Numeric(7, 3)), CAST(3202.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3087 AS Numeric(4, 0)), CAST(21.550 AS Numeric(7, 3)), CAST(3208.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3088 AS Numeric(4, 0)), CAST(21.560 AS Numeric(7, 3)), CAST(3214.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3089 AS Numeric(4, 0)), CAST(21.570 AS Numeric(7, 3)), CAST(3221.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3090 AS Numeric(4, 0)), CAST(21.580 AS Numeric(7, 3)), CAST(3227.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3091 AS Numeric(4, 0)), CAST(21.590 AS Numeric(7, 3)), CAST(3233.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3092 AS Numeric(4, 0)), CAST(21.600 AS Numeric(7, 3)), CAST(3240.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3093 AS Numeric(4, 0)), CAST(21.610 AS Numeric(7, 3)), CAST(3246.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3094 AS Numeric(4, 0)), CAST(21.620 AS Numeric(7, 3)), CAST(3252.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3095 AS Numeric(4, 0)), CAST(21.630 AS Numeric(7, 3)), CAST(3259.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3096 AS Numeric(4, 0)), CAST(21.640 AS Numeric(7, 3)), CAST(3265.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3097 AS Numeric(4, 0)), CAST(21.650 AS Numeric(7, 3)), CAST(3271.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3098 AS Numeric(4, 0)), CAST(21.660 AS Numeric(7, 3)), CAST(3278.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3099 AS Numeric(4, 0)), CAST(21.670 AS Numeric(7, 3)), CAST(3284.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3100 AS Numeric(4, 0)), CAST(21.680 AS Numeric(7, 3)), CAST(3290.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3101 AS Numeric(4, 0)), CAST(21.690 AS Numeric(7, 3)), CAST(3296.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3102 AS Numeric(4, 0)), CAST(21.700 AS Numeric(7, 3)), CAST(3303.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3103 AS Numeric(4, 0)), CAST(21.710 AS Numeric(7, 3)), CAST(3309.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3104 AS Numeric(4, 0)), CAST(21.720 AS Numeric(7, 3)), CAST(3316.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3105 AS Numeric(4, 0)), CAST(21.730 AS Numeric(7, 3)), CAST(3322.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3106 AS Numeric(4, 0)), CAST(21.740 AS Numeric(7, 3)), CAST(3329.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3107 AS Numeric(4, 0)), CAST(21.750 AS Numeric(7, 3)), CAST(3335.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3108 AS Numeric(4, 0)), CAST(21.760 AS Numeric(7, 3)), CAST(3342.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3109 AS Numeric(4, 0)), CAST(21.770 AS Numeric(7, 3)), CAST(3348.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3110 AS Numeric(4, 0)), CAST(21.780 AS Numeric(7, 3)), CAST(3354.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3111 AS Numeric(4, 0)), CAST(21.790 AS Numeric(7, 3)), CAST(3361.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3112 AS Numeric(4, 0)), CAST(21.800 AS Numeric(7, 3)), CAST(3367.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3113 AS Numeric(4, 0)), CAST(21.810 AS Numeric(7, 3)), CAST(3374.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3114 AS Numeric(4, 0)), CAST(21.820 AS Numeric(7, 3)), CAST(3380.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3115 AS Numeric(4, 0)), CAST(21.830 AS Numeric(7, 3)), CAST(3387.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3116 AS Numeric(4, 0)), CAST(21.840 AS Numeric(7, 3)), CAST(3393.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3117 AS Numeric(4, 0)), CAST(21.850 AS Numeric(7, 3)), CAST(3400.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3118 AS Numeric(4, 0)), CAST(21.860 AS Numeric(7, 3)), CAST(3406.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3119 AS Numeric(4, 0)), CAST(21.870 AS Numeric(7, 3)), CAST(3412.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3120 AS Numeric(4, 0)), CAST(21.880 AS Numeric(7, 3)), CAST(3419.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3121 AS Numeric(4, 0)), CAST(21.890 AS Numeric(7, 3)), CAST(3425.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3122 AS Numeric(4, 0)), CAST(21.900 AS Numeric(7, 3)), CAST(3432.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3123 AS Numeric(4, 0)), CAST(21.910 AS Numeric(7, 3)), CAST(3438.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3124 AS Numeric(4, 0)), CAST(21.920 AS Numeric(7, 3)), CAST(3445.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3125 AS Numeric(4, 0)), CAST(21.930 AS Numeric(7, 3)), CAST(3452.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3126 AS Numeric(4, 0)), CAST(21.940 AS Numeric(7, 3)), CAST(3458.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3127 AS Numeric(4, 0)), CAST(21.950 AS Numeric(7, 3)), CAST(3465.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3128 AS Numeric(4, 0)), CAST(21.960 AS Numeric(7, 3)), CAST(3471.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3129 AS Numeric(4, 0)), CAST(21.970 AS Numeric(7, 3)), CAST(3478.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3130 AS Numeric(4, 0)), CAST(21.980 AS Numeric(7, 3)), CAST(3485.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3131 AS Numeric(4, 0)), CAST(21.990 AS Numeric(7, 3)), CAST(3491.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3132 AS Numeric(4, 0)), CAST(22.000 AS Numeric(7, 3)), CAST(3498.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3133 AS Numeric(4, 0)), CAST(22.010 AS Numeric(7, 3)), CAST(3504.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3134 AS Numeric(4, 0)), CAST(22.020 AS Numeric(7, 3)), CAST(3511.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3135 AS Numeric(4, 0)), CAST(22.030 AS Numeric(7, 3)), CAST(3517.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3136 AS Numeric(4, 0)), CAST(22.040 AS Numeric(7, 3)), CAST(3524.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3137 AS Numeric(4, 0)), CAST(22.050 AS Numeric(7, 3)), CAST(3531.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3138 AS Numeric(4, 0)), CAST(22.060 AS Numeric(7, 3)), CAST(3537.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3139 AS Numeric(4, 0)), CAST(22.070 AS Numeric(7, 3)), CAST(3544.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3140 AS Numeric(4, 0)), CAST(22.080 AS Numeric(7, 3)), CAST(3550.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3141 AS Numeric(4, 0)), CAST(22.090 AS Numeric(7, 3)), CAST(3557.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3142 AS Numeric(4, 0)), CAST(22.100 AS Numeric(7, 3)), CAST(3564.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3143 AS Numeric(4, 0)), CAST(22.110 AS Numeric(7, 3)), CAST(3570.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3144 AS Numeric(4, 0)), CAST(22.120 AS Numeric(7, 3)), CAST(3577.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3145 AS Numeric(4, 0)), CAST(22.130 AS Numeric(7, 3)), CAST(3584.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3146 AS Numeric(4, 0)), CAST(22.140 AS Numeric(7, 3)), CAST(3591.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3147 AS Numeric(4, 0)), CAST(22.150 AS Numeric(7, 3)), CAST(3597.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3148 AS Numeric(4, 0)), CAST(22.160 AS Numeric(7, 3)), CAST(3604.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3149 AS Numeric(4, 0)), CAST(22.170 AS Numeric(7, 3)), CAST(3611.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3150 AS Numeric(4, 0)), CAST(22.180 AS Numeric(7, 3)), CAST(3617.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3151 AS Numeric(4, 0)), CAST(22.190 AS Numeric(7, 3)), CAST(3624.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3152 AS Numeric(4, 0)), CAST(22.200 AS Numeric(7, 3)), CAST(3631.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3153 AS Numeric(4, 0)), CAST(22.210 AS Numeric(7, 3)), CAST(3638.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3154 AS Numeric(4, 0)), CAST(22.220 AS Numeric(7, 3)), CAST(3644.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3155 AS Numeric(4, 0)), CAST(22.230 AS Numeric(7, 3)), CAST(3651.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3156 AS Numeric(4, 0)), CAST(22.240 AS Numeric(7, 3)), CAST(3658.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3157 AS Numeric(4, 0)), CAST(22.250 AS Numeric(7, 3)), CAST(3665.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3158 AS Numeric(4, 0)), CAST(22.260 AS Numeric(7, 3)), CAST(3671.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3159 AS Numeric(4, 0)), CAST(22.270 AS Numeric(7, 3)), CAST(3678.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3160 AS Numeric(4, 0)), CAST(22.280 AS Numeric(7, 3)), CAST(3685.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3161 AS Numeric(4, 0)), CAST(22.290 AS Numeric(7, 3)), CAST(3692.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3162 AS Numeric(4, 0)), CAST(22.300 AS Numeric(7, 3)), CAST(3698.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3163 AS Numeric(4, 0)), CAST(22.310 AS Numeric(7, 3)), CAST(3705.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3164 AS Numeric(4, 0)), CAST(22.320 AS Numeric(7, 3)), CAST(3712.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3165 AS Numeric(4, 0)), CAST(22.330 AS Numeric(7, 3)), CAST(3719.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3166 AS Numeric(4, 0)), CAST(22.340 AS Numeric(7, 3)), CAST(3726.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3167 AS Numeric(4, 0)), CAST(22.350 AS Numeric(7, 3)), CAST(3733.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3168 AS Numeric(4, 0)), CAST(22.360 AS Numeric(7, 3)), CAST(3739.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3169 AS Numeric(4, 0)), CAST(22.370 AS Numeric(7, 3)), CAST(3746.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3170 AS Numeric(4, 0)), CAST(22.380 AS Numeric(7, 3)), CAST(3753.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3171 AS Numeric(4, 0)), CAST(22.390 AS Numeric(7, 3)), CAST(3760.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3172 AS Numeric(4, 0)), CAST(22.400 AS Numeric(7, 3)), CAST(3767.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3173 AS Numeric(4, 0)), CAST(22.410 AS Numeric(7, 3)), CAST(3774.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3174 AS Numeric(4, 0)), CAST(22.420 AS Numeric(7, 3)), CAST(3781.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3175 AS Numeric(4, 0)), CAST(22.430 AS Numeric(7, 3)), CAST(3788.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3176 AS Numeric(4, 0)), CAST(22.440 AS Numeric(7, 3)), CAST(3794.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3177 AS Numeric(4, 0)), CAST(22.450 AS Numeric(7, 3)), CAST(3801.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3178 AS Numeric(4, 0)), CAST(22.460 AS Numeric(7, 3)), CAST(3808.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3179 AS Numeric(4, 0)), CAST(22.470 AS Numeric(7, 3)), CAST(3815.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3180 AS Numeric(4, 0)), CAST(22.480 AS Numeric(7, 3)), CAST(3822.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3181 AS Numeric(4, 0)), CAST(22.490 AS Numeric(7, 3)), CAST(3829.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3182 AS Numeric(4, 0)), CAST(22.500 AS Numeric(7, 3)), CAST(3836.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3183 AS Numeric(4, 0)), CAST(22.510 AS Numeric(7, 3)), CAST(3843.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3184 AS Numeric(4, 0)), CAST(22.520 AS Numeric(7, 3)), CAST(3850.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3185 AS Numeric(4, 0)), CAST(22.530 AS Numeric(7, 3)), CAST(3857.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3186 AS Numeric(4, 0)), CAST(22.540 AS Numeric(7, 3)), CAST(3864.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3187 AS Numeric(4, 0)), CAST(22.550 AS Numeric(7, 3)), CAST(3871.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3188 AS Numeric(4, 0)), CAST(22.560 AS Numeric(7, 3)), CAST(3878.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3189 AS Numeric(4, 0)), CAST(22.570 AS Numeric(7, 3)), CAST(3885.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3190 AS Numeric(4, 0)), CAST(22.580 AS Numeric(7, 3)), CAST(3892.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3191 AS Numeric(4, 0)), CAST(22.590 AS Numeric(7, 3)), CAST(3899.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3192 AS Numeric(4, 0)), CAST(22.600 AS Numeric(7, 3)), CAST(3906.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3193 AS Numeric(4, 0)), CAST(22.610 AS Numeric(7, 3)), CAST(3913.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3194 AS Numeric(4, 0)), CAST(22.620 AS Numeric(7, 3)), CAST(3920.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3195 AS Numeric(4, 0)), CAST(22.630 AS Numeric(7, 3)), CAST(3927.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3196 AS Numeric(4, 0)), CAST(22.640 AS Numeric(7, 3)), CAST(3934.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3197 AS Numeric(4, 0)), CAST(22.650 AS Numeric(7, 3)), CAST(3941.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3198 AS Numeric(4, 0)), CAST(22.660 AS Numeric(7, 3)), CAST(3948.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3199 AS Numeric(4, 0)), CAST(22.670 AS Numeric(7, 3)), CAST(3955.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3200 AS Numeric(4, 0)), CAST(22.680 AS Numeric(7, 3)), CAST(3962.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3201 AS Numeric(4, 0)), CAST(22.690 AS Numeric(7, 3)), CAST(3969.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3202 AS Numeric(4, 0)), CAST(22.700 AS Numeric(7, 3)), CAST(3976.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3203 AS Numeric(4, 0)), CAST(22.710 AS Numeric(7, 3)), CAST(3983.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3204 AS Numeric(4, 0)), CAST(22.720 AS Numeric(7, 3)), CAST(3990.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3205 AS Numeric(4, 0)), CAST(22.730 AS Numeric(7, 3)), CAST(3997.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3206 AS Numeric(4, 0)), CAST(22.740 AS Numeric(7, 3)), CAST(4004.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3207 AS Numeric(4, 0)), CAST(22.750 AS Numeric(7, 3)), CAST(4011.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3208 AS Numeric(4, 0)), CAST(22.760 AS Numeric(7, 3)), CAST(4018.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3209 AS Numeric(4, 0)), CAST(22.770 AS Numeric(7, 3)), CAST(4025.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3210 AS Numeric(4, 0)), CAST(22.780 AS Numeric(7, 3)), CAST(4033.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3211 AS Numeric(4, 0)), CAST(22.790 AS Numeric(7, 3)), CAST(4040.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3212 AS Numeric(4, 0)), CAST(22.800 AS Numeric(7, 3)), CAST(4047.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3213 AS Numeric(4, 0)), CAST(22.810 AS Numeric(7, 3)), CAST(4054.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3214 AS Numeric(4, 0)), CAST(22.820 AS Numeric(7, 3)), CAST(4061.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3215 AS Numeric(4, 0)), CAST(22.830 AS Numeric(7, 3)), CAST(4068.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3216 AS Numeric(4, 0)), CAST(22.840 AS Numeric(7, 3)), CAST(4075.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3217 AS Numeric(4, 0)), CAST(22.850 AS Numeric(7, 3)), CAST(4082.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3218 AS Numeric(4, 0)), CAST(22.860 AS Numeric(7, 3)), CAST(4090.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3219 AS Numeric(4, 0)), CAST(22.870 AS Numeric(7, 3)), CAST(4097.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3220 AS Numeric(4, 0)), CAST(22.880 AS Numeric(7, 3)), CAST(4104.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3221 AS Numeric(4, 0)), CAST(22.890 AS Numeric(7, 3)), CAST(4111.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3222 AS Numeric(4, 0)), CAST(22.900 AS Numeric(7, 3)), CAST(4118.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3223 AS Numeric(4, 0)), CAST(22.910 AS Numeric(7, 3)), CAST(4125.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3224 AS Numeric(4, 0)), CAST(22.920 AS Numeric(7, 3)), CAST(4133.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3225 AS Numeric(4, 0)), CAST(22.930 AS Numeric(7, 3)), CAST(4140.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3226 AS Numeric(4, 0)), CAST(22.940 AS Numeric(7, 3)), CAST(4147.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3227 AS Numeric(4, 0)), CAST(22.950 AS Numeric(7, 3)), CAST(4154.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3228 AS Numeric(4, 0)), CAST(22.960 AS Numeric(7, 3)), CAST(4162.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3229 AS Numeric(4, 0)), CAST(22.970 AS Numeric(7, 3)), CAST(4169.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3230 AS Numeric(4, 0)), CAST(22.980 AS Numeric(7, 3)), CAST(4176.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3231 AS Numeric(4, 0)), CAST(22.990 AS Numeric(7, 3)), CAST(4184.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3232 AS Numeric(4, 0)), CAST(23.000 AS Numeric(7, 3)), CAST(4191.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3233 AS Numeric(4, 0)), CAST(23.010 AS Numeric(7, 3)), CAST(4198.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3234 AS Numeric(4, 0)), CAST(23.020 AS Numeric(7, 3)), CAST(4205.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3235 AS Numeric(4, 0)), CAST(23.030 AS Numeric(7, 3)), CAST(4213.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3236 AS Numeric(4, 0)), CAST(23.040 AS Numeric(7, 3)), CAST(4220.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3237 AS Numeric(4, 0)), CAST(23.050 AS Numeric(7, 3)), CAST(4227.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3238 AS Numeric(4, 0)), CAST(23.060 AS Numeric(7, 3)), CAST(4234.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3239 AS Numeric(4, 0)), CAST(23.070 AS Numeric(7, 3)), CAST(4241.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3240 AS Numeric(4, 0)), CAST(23.080 AS Numeric(7, 3)), CAST(4249.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3241 AS Numeric(4, 0)), CAST(23.090 AS Numeric(7, 3)), CAST(4256.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3242 AS Numeric(4, 0)), CAST(23.100 AS Numeric(7, 3)), CAST(4263.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3243 AS Numeric(4, 0)), CAST(23.110 AS Numeric(7, 3)), CAST(4271.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3244 AS Numeric(4, 0)), CAST(23.120 AS Numeric(7, 3)), CAST(4278.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3245 AS Numeric(4, 0)), CAST(23.130 AS Numeric(7, 3)), CAST(4285.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3246 AS Numeric(4, 0)), CAST(23.140 AS Numeric(7, 3)), CAST(4293.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3247 AS Numeric(4, 0)), CAST(23.150 AS Numeric(7, 3)), CAST(4300.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3248 AS Numeric(4, 0)), CAST(23.160 AS Numeric(7, 3)), CAST(4308.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3249 AS Numeric(4, 0)), CAST(23.170 AS Numeric(7, 3)), CAST(4315.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3250 AS Numeric(4, 0)), CAST(23.180 AS Numeric(7, 3)), CAST(4322.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3251 AS Numeric(4, 0)), CAST(23.190 AS Numeric(7, 3)), CAST(4330.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3252 AS Numeric(4, 0)), CAST(23.200 AS Numeric(7, 3)), CAST(4337.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3253 AS Numeric(4, 0)), CAST(23.210 AS Numeric(7, 3)), CAST(4345.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3254 AS Numeric(4, 0)), CAST(23.220 AS Numeric(7, 3)), CAST(4352.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3255 AS Numeric(4, 0)), CAST(23.230 AS Numeric(7, 3)), CAST(4359.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3256 AS Numeric(4, 0)), CAST(23.240 AS Numeric(7, 3)), CAST(4367.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3257 AS Numeric(4, 0)), CAST(23.250 AS Numeric(7, 3)), CAST(4374.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3258 AS Numeric(4, 0)), CAST(23.260 AS Numeric(7, 3)), CAST(4381.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3259 AS Numeric(4, 0)), CAST(23.270 AS Numeric(7, 3)), CAST(4389.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3260 AS Numeric(4, 0)), CAST(23.280 AS Numeric(7, 3)), CAST(4396.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3261 AS Numeric(4, 0)), CAST(23.290 AS Numeric(7, 3)), CAST(4403.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3262 AS Numeric(4, 0)), CAST(23.300 AS Numeric(7, 3)), CAST(4411.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3263 AS Numeric(4, 0)), CAST(23.310 AS Numeric(7, 3)), CAST(4418.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3264 AS Numeric(4, 0)), CAST(23.320 AS Numeric(7, 3)), CAST(4426.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3265 AS Numeric(4, 0)), CAST(23.330 AS Numeric(7, 3)), CAST(4433.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3266 AS Numeric(4, 0)), CAST(23.340 AS Numeric(7, 3)), CAST(4441.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3267 AS Numeric(4, 0)), CAST(23.350 AS Numeric(7, 3)), CAST(4448.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3268 AS Numeric(4, 0)), CAST(23.360 AS Numeric(7, 3)), CAST(4456.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3269 AS Numeric(4, 0)), CAST(23.370 AS Numeric(7, 3)), CAST(4463.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3270 AS Numeric(4, 0)), CAST(23.380 AS Numeric(7, 3)), CAST(4471.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3271 AS Numeric(4, 0)), CAST(23.390 AS Numeric(7, 3)), CAST(4478.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3272 AS Numeric(4, 0)), CAST(23.400 AS Numeric(7, 3)), CAST(4486.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3273 AS Numeric(4, 0)), CAST(23.410 AS Numeric(7, 3)), CAST(4494.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3274 AS Numeric(4, 0)), CAST(23.420 AS Numeric(7, 3)), CAST(4501.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3275 AS Numeric(4, 0)), CAST(23.430 AS Numeric(7, 3)), CAST(4509.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3276 AS Numeric(4, 0)), CAST(23.440 AS Numeric(7, 3)), CAST(4516.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3277 AS Numeric(4, 0)), CAST(23.450 AS Numeric(7, 3)), CAST(4524.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3278 AS Numeric(4, 0)), CAST(23.460 AS Numeric(7, 3)), CAST(4531.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3279 AS Numeric(4, 0)), CAST(23.470 AS Numeric(7, 3)), CAST(4539.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3280 AS Numeric(4, 0)), CAST(23.480 AS Numeric(7, 3)), CAST(4546.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3281 AS Numeric(4, 0)), CAST(23.490 AS Numeric(7, 3)), CAST(4554.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3282 AS Numeric(4, 0)), CAST(23.500 AS Numeric(7, 3)), CAST(4561.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3283 AS Numeric(4, 0)), CAST(23.510 AS Numeric(7, 3)), CAST(4569.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3284 AS Numeric(4, 0)), CAST(23.520 AS Numeric(7, 3)), CAST(4576.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3285 AS Numeric(4, 0)), CAST(23.530 AS Numeric(7, 3)), CAST(4584.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3286 AS Numeric(4, 0)), CAST(23.540 AS Numeric(7, 3)), CAST(4592.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3287 AS Numeric(4, 0)), CAST(23.550 AS Numeric(7, 3)), CAST(4599.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3288 AS Numeric(4, 0)), CAST(23.560 AS Numeric(7, 3)), CAST(4607.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3289 AS Numeric(4, 0)), CAST(23.570 AS Numeric(7, 3)), CAST(4615.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3290 AS Numeric(4, 0)), CAST(23.580 AS Numeric(7, 3)), CAST(4622.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3291 AS Numeric(4, 0)), CAST(23.590 AS Numeric(7, 3)), CAST(4630.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3292 AS Numeric(4, 0)), CAST(23.600 AS Numeric(7, 3)), CAST(4638.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3293 AS Numeric(4, 0)), CAST(23.610 AS Numeric(7, 3)), CAST(4645.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3294 AS Numeric(4, 0)), CAST(23.620 AS Numeric(7, 3)), CAST(4653.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3295 AS Numeric(4, 0)), CAST(23.630 AS Numeric(7, 3)), CAST(4661.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3296 AS Numeric(4, 0)), CAST(23.640 AS Numeric(7, 3)), CAST(4668.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3297 AS Numeric(4, 0)), CAST(23.650 AS Numeric(7, 3)), CAST(4676.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3298 AS Numeric(4, 0)), CAST(23.660 AS Numeric(7, 3)), CAST(4684.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3299 AS Numeric(4, 0)), CAST(23.670 AS Numeric(7, 3)), CAST(4691.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3300 AS Numeric(4, 0)), CAST(23.680 AS Numeric(7, 3)), CAST(4699.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3301 AS Numeric(4, 0)), CAST(23.690 AS Numeric(7, 3)), CAST(4707.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3302 AS Numeric(4, 0)), CAST(23.700 AS Numeric(7, 3)), CAST(4714.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3303 AS Numeric(4, 0)), CAST(23.710 AS Numeric(7, 3)), CAST(4722.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3304 AS Numeric(4, 0)), CAST(23.720 AS Numeric(7, 3)), CAST(4730.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3305 AS Numeric(4, 0)), CAST(23.730 AS Numeric(7, 3)), CAST(4738.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3306 AS Numeric(4, 0)), CAST(23.740 AS Numeric(7, 3)), CAST(4746.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3307 AS Numeric(4, 0)), CAST(23.750 AS Numeric(7, 3)), CAST(4753.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3308 AS Numeric(4, 0)), CAST(23.760 AS Numeric(7, 3)), CAST(4761.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3309 AS Numeric(4, 0)), CAST(23.770 AS Numeric(7, 3)), CAST(4769.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3310 AS Numeric(4, 0)), CAST(23.780 AS Numeric(7, 3)), CAST(4777.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3311 AS Numeric(4, 0)), CAST(23.790 AS Numeric(7, 3)), CAST(4785.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3312 AS Numeric(4, 0)), CAST(23.800 AS Numeric(7, 3)), CAST(4792.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3313 AS Numeric(4, 0)), CAST(23.810 AS Numeric(7, 3)), CAST(4800.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3314 AS Numeric(4, 0)), CAST(23.820 AS Numeric(7, 3)), CAST(4808.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3315 AS Numeric(4, 0)), CAST(23.830 AS Numeric(7, 3)), CAST(4816.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3316 AS Numeric(4, 0)), CAST(23.840 AS Numeric(7, 3)), CAST(4824.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3317 AS Numeric(4, 0)), CAST(23.850 AS Numeric(7, 3)), CAST(4832.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3318 AS Numeric(4, 0)), CAST(23.860 AS Numeric(7, 3)), CAST(4840.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3319 AS Numeric(4, 0)), CAST(23.870 AS Numeric(7, 3)), CAST(4847.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3320 AS Numeric(4, 0)), CAST(23.880 AS Numeric(7, 3)), CAST(4855.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3321 AS Numeric(4, 0)), CAST(23.890 AS Numeric(7, 3)), CAST(4863.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3322 AS Numeric(4, 0)), CAST(23.900 AS Numeric(7, 3)), CAST(4871.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3323 AS Numeric(4, 0)), CAST(23.910 AS Numeric(7, 3)), CAST(4879.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3324 AS Numeric(4, 0)), CAST(23.920 AS Numeric(7, 3)), CAST(4887.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3325 AS Numeric(4, 0)), CAST(23.930 AS Numeric(7, 3)), CAST(4895.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3326 AS Numeric(4, 0)), CAST(23.940 AS Numeric(7, 3)), CAST(4903.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3327 AS Numeric(4, 0)), CAST(23.950 AS Numeric(7, 3)), CAST(4911.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3328 AS Numeric(4, 0)), CAST(23.960 AS Numeric(7, 3)), CAST(4919.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3329 AS Numeric(4, 0)), CAST(23.970 AS Numeric(7, 3)), CAST(4927.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3330 AS Numeric(4, 0)), CAST(23.980 AS Numeric(7, 3)), CAST(4935.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3331 AS Numeric(4, 0)), CAST(23.990 AS Numeric(7, 3)), CAST(4943.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3332 AS Numeric(4, 0)), CAST(24.000 AS Numeric(7, 3)), CAST(4951.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3333 AS Numeric(4, 0)), CAST(24.010 AS Numeric(7, 3)), CAST(4959.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3334 AS Numeric(4, 0)), CAST(24.020 AS Numeric(7, 3)), CAST(4967.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3335 AS Numeric(4, 0)), CAST(24.030 AS Numeric(7, 3)), CAST(4975.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3336 AS Numeric(4, 0)), CAST(24.040 AS Numeric(7, 3)), CAST(4983.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3337 AS Numeric(4, 0)), CAST(24.050 AS Numeric(7, 3)), CAST(4991.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3338 AS Numeric(4, 0)), CAST(24.060 AS Numeric(7, 3)), CAST(4999.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3339 AS Numeric(4, 0)), CAST(24.070 AS Numeric(7, 3)), CAST(5007.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3340 AS Numeric(4, 0)), CAST(24.080 AS Numeric(7, 3)), CAST(5015.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3341 AS Numeric(4, 0)), CAST(24.090 AS Numeric(7, 3)), CAST(5023.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3342 AS Numeric(4, 0)), CAST(24.100 AS Numeric(7, 3)), CAST(5031.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3343 AS Numeric(4, 0)), CAST(24.110 AS Numeric(7, 3)), CAST(5039.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3344 AS Numeric(4, 0)), CAST(24.120 AS Numeric(7, 3)), CAST(5047.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3345 AS Numeric(4, 0)), CAST(24.130 AS Numeric(7, 3)), CAST(5056.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3346 AS Numeric(4, 0)), CAST(24.140 AS Numeric(7, 3)), CAST(5064.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3347 AS Numeric(4, 0)), CAST(24.150 AS Numeric(7, 3)), CAST(5072.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3348 AS Numeric(4, 0)), CAST(24.160 AS Numeric(7, 3)), CAST(5080.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3349 AS Numeric(4, 0)), CAST(24.170 AS Numeric(7, 3)), CAST(5088.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3350 AS Numeric(4, 0)), CAST(24.180 AS Numeric(7, 3)), CAST(5097.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3351 AS Numeric(4, 0)), CAST(24.190 AS Numeric(7, 3)), CAST(5105.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3352 AS Numeric(4, 0)), CAST(24.200 AS Numeric(7, 3)), CAST(5113.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3353 AS Numeric(4, 0)), CAST(24.210 AS Numeric(7, 3)), CAST(5121.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3354 AS Numeric(4, 0)), CAST(24.220 AS Numeric(7, 3)), CAST(5129.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3355 AS Numeric(4, 0)), CAST(24.230 AS Numeric(7, 3)), CAST(5137.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3356 AS Numeric(4, 0)), CAST(24.240 AS Numeric(7, 3)), CAST(5145.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3357 AS Numeric(4, 0)), CAST(24.250 AS Numeric(7, 3)), CAST(5154.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3358 AS Numeric(4, 0)), CAST(24.260 AS Numeric(7, 3)), CAST(5162.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3359 AS Numeric(4, 0)), CAST(24.270 AS Numeric(7, 3)), CAST(5170.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3360 AS Numeric(4, 0)), CAST(24.280 AS Numeric(7, 3)), CAST(5178.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3361 AS Numeric(4, 0)), CAST(24.290 AS Numeric(7, 3)), CAST(5186.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3362 AS Numeric(4, 0)), CAST(24.300 AS Numeric(7, 3)), CAST(5194.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3363 AS Numeric(4, 0)), CAST(24.310 AS Numeric(7, 3)), CAST(5203.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3364 AS Numeric(4, 0)), CAST(24.320 AS Numeric(7, 3)), CAST(5211.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3365 AS Numeric(4, 0)), CAST(24.330 AS Numeric(7, 3)), CAST(5219.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3366 AS Numeric(4, 0)), CAST(24.340 AS Numeric(7, 3)), CAST(5228.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3367 AS Numeric(4, 0)), CAST(24.350 AS Numeric(7, 3)), CAST(5236.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3368 AS Numeric(4, 0)), CAST(24.360 AS Numeric(7, 3)), CAST(5244.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3369 AS Numeric(4, 0)), CAST(24.370 AS Numeric(7, 3)), CAST(5253.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3370 AS Numeric(4, 0)), CAST(24.380 AS Numeric(7, 3)), CAST(5261.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3371 AS Numeric(4, 0)), CAST(24.390 AS Numeric(7, 3)), CAST(5270.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3372 AS Numeric(4, 0)), CAST(24.400 AS Numeric(7, 3)), CAST(5278.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3373 AS Numeric(4, 0)), CAST(24.410 AS Numeric(7, 3)), CAST(5286.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3374 AS Numeric(4, 0)), CAST(24.420 AS Numeric(7, 3)), CAST(5295.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3375 AS Numeric(4, 0)), CAST(24.430 AS Numeric(7, 3)), CAST(5303.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3376 AS Numeric(4, 0)), CAST(24.440 AS Numeric(7, 3)), CAST(5311.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3377 AS Numeric(4, 0)), CAST(24.450 AS Numeric(7, 3)), CAST(5320.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3378 AS Numeric(4, 0)), CAST(24.460 AS Numeric(7, 3)), CAST(5328.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3379 AS Numeric(4, 0)), CAST(24.470 AS Numeric(7, 3)), CAST(5336.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3380 AS Numeric(4, 0)), CAST(24.480 AS Numeric(7, 3)), CAST(5345.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3381 AS Numeric(4, 0)), CAST(24.490 AS Numeric(7, 3)), CAST(5353.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3382 AS Numeric(4, 0)), CAST(24.500 AS Numeric(7, 3)), CAST(5361.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3383 AS Numeric(4, 0)), CAST(24.510 AS Numeric(7, 3)), CAST(5370.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3384 AS Numeric(4, 0)), CAST(24.520 AS Numeric(7, 3)), CAST(5378.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3385 AS Numeric(4, 0)), CAST(24.530 AS Numeric(7, 3)), CAST(5387.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3386 AS Numeric(4, 0)), CAST(24.540 AS Numeric(7, 3)), CAST(5395.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3387 AS Numeric(4, 0)), CAST(24.550 AS Numeric(7, 3)), CAST(5404.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3388 AS Numeric(4, 0)), CAST(24.560 AS Numeric(7, 3)), CAST(5412.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3389 AS Numeric(4, 0)), CAST(24.570 AS Numeric(7, 3)), CAST(5421.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3390 AS Numeric(4, 0)), CAST(24.580 AS Numeric(7, 3)), CAST(5429.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3391 AS Numeric(4, 0)), CAST(24.590 AS Numeric(7, 3)), CAST(5438.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3392 AS Numeric(4, 0)), CAST(24.600 AS Numeric(7, 3)), CAST(5446.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3393 AS Numeric(4, 0)), CAST(24.610 AS Numeric(7, 3)), CAST(5455.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3394 AS Numeric(4, 0)), CAST(24.620 AS Numeric(7, 3)), CAST(5463.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3395 AS Numeric(4, 0)), CAST(24.630 AS Numeric(7, 3)), CAST(5472.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3396 AS Numeric(4, 0)), CAST(24.640 AS Numeric(7, 3)), CAST(5480.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3397 AS Numeric(4, 0)), CAST(24.650 AS Numeric(7, 3)), CAST(5489.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3398 AS Numeric(4, 0)), CAST(24.660 AS Numeric(7, 3)), CAST(5497.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3399 AS Numeric(4, 0)), CAST(24.670 AS Numeric(7, 3)), CAST(5506.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3400 AS Numeric(4, 0)), CAST(24.680 AS Numeric(7, 3)), CAST(5514.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3401 AS Numeric(4, 0)), CAST(24.690 AS Numeric(7, 3)), CAST(5523.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3402 AS Numeric(4, 0)), CAST(24.700 AS Numeric(7, 3)), CAST(5531.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3403 AS Numeric(4, 0)), CAST(24.710 AS Numeric(7, 3)), CAST(5540.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3404 AS Numeric(4, 0)), CAST(24.720 AS Numeric(7, 3)), CAST(5549.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3405 AS Numeric(4, 0)), CAST(24.730 AS Numeric(7, 3)), CAST(5557.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3406 AS Numeric(4, 0)), CAST(24.740 AS Numeric(7, 3)), CAST(5566.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3407 AS Numeric(4, 0)), CAST(24.750 AS Numeric(7, 3)), CAST(5575.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3408 AS Numeric(4, 0)), CAST(24.760 AS Numeric(7, 3)), CAST(5583.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3409 AS Numeric(4, 0)), CAST(24.770 AS Numeric(7, 3)), CAST(5592.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3410 AS Numeric(4, 0)), CAST(24.780 AS Numeric(7, 3)), CAST(5601.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3411 AS Numeric(4, 0)), CAST(24.790 AS Numeric(7, 3)), CAST(5610.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3412 AS Numeric(4, 0)), CAST(24.800 AS Numeric(7, 3)), CAST(5618.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3413 AS Numeric(4, 0)), CAST(24.810 AS Numeric(7, 3)), CAST(5627.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3414 AS Numeric(4, 0)), CAST(24.820 AS Numeric(7, 3)), CAST(5636.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3415 AS Numeric(4, 0)), CAST(24.830 AS Numeric(7, 3)), CAST(5644.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3416 AS Numeric(4, 0)), CAST(24.840 AS Numeric(7, 3)), CAST(5653.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3417 AS Numeric(4, 0)), CAST(24.850 AS Numeric(7, 3)), CAST(5661.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3418 AS Numeric(4, 0)), CAST(24.860 AS Numeric(7, 3)), CAST(5670.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3419 AS Numeric(4, 0)), CAST(24.870 AS Numeric(7, 3)), CAST(5679.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3420 AS Numeric(4, 0)), CAST(24.880 AS Numeric(7, 3)), CAST(5687.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3421 AS Numeric(4, 0)), CAST(24.890 AS Numeric(7, 3)), CAST(5696.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3422 AS Numeric(4, 0)), CAST(24.900 AS Numeric(7, 3)), CAST(5705.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3423 AS Numeric(4, 0)), CAST(24.910 AS Numeric(7, 3)), CAST(5714.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3424 AS Numeric(4, 0)), CAST(24.920 AS Numeric(7, 3)), CAST(5722.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3425 AS Numeric(4, 0)), CAST(24.930 AS Numeric(7, 3)), CAST(5731.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3426 AS Numeric(4, 0)), CAST(24.940 AS Numeric(7, 3)), CAST(5740.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3427 AS Numeric(4, 0)), CAST(24.950 AS Numeric(7, 3)), CAST(5749.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3428 AS Numeric(4, 0)), CAST(24.960 AS Numeric(7, 3)), CAST(5758.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3429 AS Numeric(4, 0)), CAST(24.970 AS Numeric(7, 3)), CAST(5767.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3430 AS Numeric(4, 0)), CAST(24.980 AS Numeric(7, 3)), CAST(5776.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3431 AS Numeric(4, 0)), CAST(24.990 AS Numeric(7, 3)), CAST(5785.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3432 AS Numeric(4, 0)), CAST(25.000 AS Numeric(7, 3)), CAST(5793.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3433 AS Numeric(4, 0)), CAST(25.010 AS Numeric(7, 3)), CAST(5802.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3434 AS Numeric(4, 0)), CAST(25.020 AS Numeric(7, 3)), CAST(5811.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3435 AS Numeric(4, 0)), CAST(25.030 AS Numeric(7, 3)), CAST(5820.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3436 AS Numeric(4, 0)), CAST(25.040 AS Numeric(7, 3)), CAST(5829.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3437 AS Numeric(4, 0)), CAST(25.050 AS Numeric(7, 3)), CAST(5837.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3438 AS Numeric(4, 0)), CAST(25.060 AS Numeric(7, 3)), CAST(5846.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3439 AS Numeric(4, 0)), CAST(25.070 AS Numeric(7, 3)), CAST(5855.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3440 AS Numeric(4, 0)), CAST(25.080 AS Numeric(7, 3)), CAST(5864.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3441 AS Numeric(4, 0)), CAST(25.090 AS Numeric(7, 3)), CAST(5873.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3442 AS Numeric(4, 0)), CAST(25.100 AS Numeric(7, 3)), CAST(5881.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3443 AS Numeric(4, 0)), CAST(25.110 AS Numeric(7, 3)), CAST(5890.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3444 AS Numeric(4, 0)), CAST(25.120 AS Numeric(7, 3)), CAST(5900.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3445 AS Numeric(4, 0)), CAST(25.130 AS Numeric(7, 3)), CAST(5909.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3446 AS Numeric(4, 0)), CAST(25.140 AS Numeric(7, 3)), CAST(5918.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3447 AS Numeric(4, 0)), CAST(25.150 AS Numeric(7, 3)), CAST(5927.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3448 AS Numeric(4, 0)), CAST(25.160 AS Numeric(7, 3)), CAST(5936.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3449 AS Numeric(4, 0)), CAST(25.170 AS Numeric(7, 3)), CAST(5945.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3450 AS Numeric(4, 0)), CAST(25.180 AS Numeric(7, 3)), CAST(5954.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3451 AS Numeric(4, 0)), CAST(25.190 AS Numeric(7, 3)), CAST(5963.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3452 AS Numeric(4, 0)), CAST(25.200 AS Numeric(7, 3)), CAST(5972.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3453 AS Numeric(4, 0)), CAST(25.210 AS Numeric(7, 3)), CAST(5981.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3454 AS Numeric(4, 0)), CAST(25.220 AS Numeric(7, 3)), CAST(5990.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3455 AS Numeric(4, 0)), CAST(25.230 AS Numeric(7, 3)), CAST(5999.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3456 AS Numeric(4, 0)), CAST(25.240 AS Numeric(7, 3)), CAST(6008.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3457 AS Numeric(4, 0)), CAST(25.250 AS Numeric(7, 3)), CAST(6017.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3458 AS Numeric(4, 0)), CAST(25.260 AS Numeric(7, 3)), CAST(6026.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3459 AS Numeric(4, 0)), CAST(25.270 AS Numeric(7, 3)), CAST(6035.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3460 AS Numeric(4, 0)), CAST(25.280 AS Numeric(7, 3)), CAST(6044.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3461 AS Numeric(4, 0)), CAST(25.290 AS Numeric(7, 3)), CAST(6053.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3462 AS Numeric(4, 0)), CAST(25.300 AS Numeric(7, 3)), CAST(6062.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3463 AS Numeric(4, 0)), CAST(25.310 AS Numeric(7, 3)), CAST(6071.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3464 AS Numeric(4, 0)), CAST(25.320 AS Numeric(7, 3)), CAST(6080.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3465 AS Numeric(4, 0)), CAST(25.330 AS Numeric(7, 3)), CAST(6089.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3466 AS Numeric(4, 0)), CAST(25.340 AS Numeric(7, 3)), CAST(6099.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3467 AS Numeric(4, 0)), CAST(25.350 AS Numeric(7, 3)), CAST(6108.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3468 AS Numeric(4, 0)), CAST(25.360 AS Numeric(7, 3)), CAST(6117.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3469 AS Numeric(4, 0)), CAST(25.370 AS Numeric(7, 3)), CAST(6126.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3470 AS Numeric(4, 0)), CAST(25.380 AS Numeric(7, 3)), CAST(6136.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3471 AS Numeric(4, 0)), CAST(25.390 AS Numeric(7, 3)), CAST(6145.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3472 AS Numeric(4, 0)), CAST(25.400 AS Numeric(7, 3)), CAST(6154.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3473 AS Numeric(4, 0)), CAST(25.410 AS Numeric(7, 3)), CAST(6163.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3474 AS Numeric(4, 0)), CAST(25.420 AS Numeric(7, 3)), CAST(6173.000 AS Numeric(9, 3)), NULL, NULL)

INSERT [dbo].[ST_ZVARL_B] ([STCD], [MSTM], [PTNO], [RZ], [W], [WSFA], [MODITIME]) VALUES (N'tg      ', CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(3475 AS Numeric(4, 0)), CAST(25.430 AS Numeric(7, 3)), CAST(6182.000 AS Numeric(9, 3)), NULL, NULL)


GO
CREATE TABLE [dbo].[DSE_DBJC_005_HYDORIGDATA](
	[HYDCD] [varchar](16) NOT NULL,
	[TM] [datetime] NOT NULL,
	[ORIGDATA] [numeric](12, 2) NULL,
	[JCL] [varchar](200) NULL,
	[OTDESC] [varchar](200) NULL,
	[GATTYPE] [varchar](1) NULL,
	[NT] [varchar](200) NULL,
	[CALCDATA] [numeric](12, 2) NULL,
 CONSTRAINT [pk_fh] PRIMARY KEY CLUSTERED
(
	[HYDCD] ASC,
	[TM] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'渗压位移原始数据表' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'DSE_DBJC_005_HYDORIGDATA'
GO

CREATE TABLE [dbo].[DSE_MONITORING_POINTS](
	[BNTRCD] [varchar](12) NOT NULL,
	[POINTCD] [varchar](12) NOT NULL,
	[POINT] [varchar](40) NULL,
	[PTYPE] [char](1) NULL,
	[CATEGORY] [char](1) NULL,
 CONSTRAINT [PK_DSE_MONITORING_POINTS] PRIMARY KEY CLUSTERED 
(
	[POINTCD] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]


SET ANSI_PADDING OFF

/****** Object:  Table [dbo].[TB0201_RSCMIN_044]    Script Date: 2016-12-22 11:06:20 ******/
SET ANSI_NULLS ON

SET QUOTED_IDENTIFIER ON

SET ANSI_PADDING ON

CREATE TABLE [dbo].[TB0201_RSCMIN_044](
	[ENNMCD] [varchar](16) NOT NULL,
	[ENNM] [varchar](40) NULL,
	[INFNDT] [datetime] NULL,
	[ADUNCD] [varchar](12) NULL,
	[ADUNNM] [varchar](100) NULL,
	[DMSTATPL] [varchar](80) NULL,
	[BLDT] [datetime] NULL,
	[ENCL] [varchar](10) NULL,
	[LVBSLV] [varchar](40) NULL,
	[DLBLP] [varchar](40) NULL,
	[RSCCI] [varchar](4000) NULL,
	[EXQS] [varchar](4000) NULL,
	[RM] [varchar](4000) NULL,
	[DEPMA] [varchar](50) NULL,
	[MACANU] [numeric](4, 0) NULL,
	[STNEASS] [numeric](8, 2) NULL,
	[RUMAFE] [numeric](8, 0) NULL,
	[LREFE] [numeric](8, 2) NULL,
	[DEPRFE] [numeric](8, 2) NULL,
	[INWAFE] [numeric](8, 2) NULL,
	[INPOFE] [numeric](8, 2) NULL,
	[MUOPIN] [numeric](8, 2) NULL,
	[MAFUN] [varchar](100) NULL,
	[VIRAR] [numeric](8, 2) NULL,
	[VIREDAR] [numeric](8, 2) NULL,
	[MAPRRA] [numeric](8, 2) NULL,
	[CONGLAR] [numeric](8, 2) NULL,
	[ATID] [varchar](18) NULL,
	[SDFL] [varchar](50) NULL,
	[RMA] [varchar](256) NULL,
	[MDPS] [varchar](30) NULL,
	[MDDT] [datetime] NULL,
	[ADDVCD] [varchar](20) NULL,
	[ADUNADD] [varchar](100) NULL,
	[ADUNZIP] [varchar](6) NULL,
	[ADUNFAX] [varchar](100) NULL,
	[ADUNTEL] [varchar](100) NULL,
	[DEPMACD] [varchar](12) NULL,
	[DEPMAADD] [varchar](100) NULL,
	[DEPMAZIP] [varchar](6) NULL,
	[DEPMAFAX] [varchar](100) NULL,
	[DEPMATEL] [varchar](100) NULL,
	[ADMINNM] [varchar](50) NULL,
	[ADMINTEL] [varchar](100) NULL,
	[PRODNM] [varchar](50) NULL,
	[PRODTEL] [varchar](100) NULL,
	[SKILLNM] [varchar](50) NULL,
	[SKILLTEL] [varchar](100) NULL,
	[SAFETYNM] [varchar](50) NULL,
	[SAFETYTEL] [varchar](100) NULL,
 CONSTRAINT [PK_TB0201_RSCMIN_044] PRIMARY KEY CLUSTERED 
(
	[ENNMCD] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]


SET ANSI_PADDING OFF

/****** Object:  Table [dbo].[TB0401_DKCMIN_044]    Script Date: 2016-12-22 11:06:20 ******/
SET ANSI_NULLS ON

SET QUOTED_IDENTIFIER ON

SET ANSI_PADDING ON

CREATE TABLE [dbo].[TB0401_DKCMIN_044](
	[ENNMCD] [varchar](16) NOT NULL,
	[ENNM] [varchar](40) NOT NULL,
	[PROJCD] [varchar](16) NOT NULL,
	[INFNDT] [datetime] NULL,
	[ADUNCD] [varchar](12) NULL,
	[ADUNNM] [varchar](100) NULL,
	[DKCL] [varchar](8) NULL,
	[ERBSIN] [varchar](2) NULL,
	[ERDSIN] [varchar](2) NULL,
	[LVBSLV] [varchar](40) NULL,
	[DLBLP] [varchar](40) NULL,
	[ININ] [varchar](4000) NULL,
	[ATID] [varchar](18) NULL,
	[SDFL] [varchar](50) NULL,
	[RMA] [varchar](256) NULL,
	[MDPS] [varchar](30) NULL,
	[MDDT] [datetime] NULL,
 CONSTRAINT [PK_TB0401_DKCMIN_044_1] PRIMARY KEY CLUSTERED 
(
	[ENNMCD] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]


SET ANSI_PADDING OFF

/****** Object:  Table [dbo].[TB0404_BNBDCRPR_044]    Script Date: 2016-12-22 11:06:20 ******/
SET ANSI_NULLS ON

SET QUOTED_IDENTIFIER ON

SET ANSI_PADDING ON

CREATE TABLE [dbo].[TB0404_BNBDCRPR_044](
	[ENNMCD] [varchar](16) NOT NULL,
	[BNTRCD] [varchar](12) NOT NULL,
	[BNTR] [varchar](40) NULL,
	[SRDT] [datetime] NULL,
	[JMDS] [numeric](7, 1) NULL,
	[SRPNEL] [numeric](8, 3) NULL,
	[ATID] [varchar](18) NULL,
	[SDFL] [varchar](50) NULL,
	[RMA] [varchar](256) NULL,
	[MDPS] [varchar](30) NULL,
	[MDDT] [datetime] NULL,
 CONSTRAINT [PK_TB0404_BNBDCRPR_044_1] PRIMARY KEY CLUSTERED 
(
	[BNTRCD] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]


SET ANSI_PADDING OFF

EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'堤防(段)横断面代码 ' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'DSE_MONITORING_POINTS', @level2type=N'COLUMN',@level2name=N'BNTRCD'

EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'测点编号' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'DSE_MONITORING_POINTS', @level2type=N'COLUMN',@level2name=N'POINTCD'

EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'测点名称' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'DSE_MONITORING_POINTS', @level2type=N'COLUMN',@level2name=N'POINT'

EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'测点类型  0：自动采集 1：人工采集' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'DSE_MONITORING_POINTS', @level2type=N'COLUMN',@level2name=N'PTYPE'

EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'监控类型' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'DSE_MONITORING_POINTS', @level2type=N'COLUMN',@level2name=N'CATEGORY'

EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'水库名称代码' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'TB0201_RSCMIN_044', @level2type=N'COLUMN',@level2name=N'ENNMCD'

EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'水库名称' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'TB0201_RSCMIN_044', @level2type=N'COLUMN',@level2name=N'ENNM'

EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'资料截止日期' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'TB0201_RSCMIN_044', @level2type=N'COLUMN',@level2name=N'INFNDT'

EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'管理单位代码' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'TB0201_RSCMIN_044', @level2type=N'COLUMN',@level2name=N'ADUNCD'

EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'管理单位名称' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'TB0201_RSCMIN_044', @level2type=N'COLUMN',@level2name=N'ADUNNM'

EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'坝址所在地点' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'TB0201_RSCMIN_044', @level2type=N'COLUMN',@level2name=N'DMSTATPL'

EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'建成日期' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'TB0201_RSCMIN_044', @level2type=N'COLUMN',@level2name=N'BLDT'

EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'工程等别' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'TB0201_RSCMIN_044', @level2type=N'COLUMN',@level2name=N'ENCL'

EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'水准基面' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'TB0201_RSCMIN_044', @level2type=N'COLUMN',@level2name=N'LVBSLV'

EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'假定水准基面位置' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'TB0201_RSCMIN_044', @level2type=N'COLUMN',@level2name=N'DLBLP'

EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'水库枢纽建筑物组成' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'TB0201_RSCMIN_044', @level2type=N'COLUMN',@level2name=N'RSCCI'

EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'存在问题' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'TB0201_RSCMIN_044', @level2type=N'COLUMN',@level2name=N'EXQS'

EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'备注' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'TB0201_RSCMIN_044', @level2type=N'COLUMN',@level2name=N'RM'

EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'主管部门' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'TB0201_RSCMIN_044', @level2type=N'COLUMN',@level2name=N'DEPMA'

EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'管理职工人数单位(人)' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'TB0201_RSCMIN_044', @level2type=N'COLUMN',@level2name=N'MACANU'

EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'固定资产净值单位(万元)' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'TB0201_RSCMIN_044', @level2type=N'COLUMN',@level2name=N'STNEASS'

EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'运行管理费单位(万元)' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'TB0201_RSCMIN_044', @level2type=N'COLUMN',@level2name=N'RUMAFE'

EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'大修理费单位(万元)' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'TB0201_RSCMIN_044', @level2type=N'COLUMN',@level2name=N'LREFE'

EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'折旧费单位(万元)' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'TB0201_RSCMIN_044', @level2type=N'COLUMN',@level2name=N'DEPRFE'

EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'水费收入单位(万元)' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'TB0201_RSCMIN_044', @level2type=N'COLUMN',@level2name=N'INWAFE'

EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'电费收入单位(万元)' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'TB0201_RSCMIN_044', @level2type=N'COLUMN',@level2name=N'INPOFE'

EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'多种经营收入单位(万元)' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'TB0201_RSCMIN_044', @level2type=N'COLUMN',@level2name=N'MUOPIN'

EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'主要功能' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'TB0201_RSCMIN_044', @level2type=N'COLUMN',@level2name=N'MAFUN'

EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'应绿化面积单位(亩)' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'TB0201_RSCMIN_044', @level2type=N'COLUMN',@level2name=N'VIRAR'

EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'已绿化面积单位(亩)' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'TB0201_RSCMIN_044', @level2type=N'COLUMN',@level2name=N'VIREDAR'

EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'管理保护范围单位(亩)' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'TB0201_RSCMIN_044', @level2type=N'COLUMN',@level2name=N'MAPRRA'

EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'确权土地面积单位(亩)' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'TB0201_RSCMIN_044', @level2type=N'COLUMN',@level2name=N'CONGLAR'

EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'流水号' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'TB0201_RSCMIN_044', @level2type=N'COLUMN',@level2name=N'ATID'

EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'发送标示位' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'TB0201_RSCMIN_044', @level2type=N'COLUMN',@level2name=N'SDFL'

EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'备用字段' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'TB0201_RSCMIN_044', @level2type=N'COLUMN',@level2name=N'RMA'

EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'修改人' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'TB0201_RSCMIN_044', @level2type=N'COLUMN',@level2name=N'MDPS'

EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'修改日期' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'TB0201_RSCMIN_044', @level2type=N'COLUMN',@level2name=N'MDDT'

EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'行政区代码' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'TB0201_RSCMIN_044', @level2type=N'COLUMN',@level2name=N'ADDVCD'

EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'管理单位地址' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'TB0201_RSCMIN_044', @level2type=N'COLUMN',@level2name=N'ADUNADD'

EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'管理单位邮政编码' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'TB0201_RSCMIN_044', @level2type=N'COLUMN',@level2name=N'ADUNZIP'

EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'管理单位传真' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'TB0201_RSCMIN_044', @level2type=N'COLUMN',@level2name=N'ADUNFAX'

EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'管理单位联系电话' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'TB0201_RSCMIN_044', @level2type=N'COLUMN',@level2name=N'ADUNTEL'

EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'主管部门代码' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'TB0201_RSCMIN_044', @level2type=N'COLUMN',@level2name=N'DEPMACD'

EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'主管部门地址' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'TB0201_RSCMIN_044', @level2type=N'COLUMN',@level2name=N'DEPMAADD'

EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'主管部门邮政编码' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'TB0201_RSCMIN_044', @level2type=N'COLUMN',@level2name=N'DEPMAZIP'

EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'主管部门传真' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'TB0201_RSCMIN_044', @level2type=N'COLUMN',@level2name=N'DEPMAFAX'

EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'主管部门联系电话' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'TB0201_RSCMIN_044', @level2type=N'COLUMN',@level2name=N'DEPMATEL'

EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'防汛行政责任人' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'TB0201_RSCMIN_044', @level2type=N'COLUMN',@level2name=N'ADMINNM'

EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'防汛行政责任人电话' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'TB0201_RSCMIN_044', @level2type=N'COLUMN',@level2name=N'ADMINTEL'

EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'安全生产责任人' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'TB0201_RSCMIN_044', @level2type=N'COLUMN',@level2name=N'PRODNM'

EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'安全生产责任人电话' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'TB0201_RSCMIN_044', @level2type=N'COLUMN',@level2name=N'PRODTEL'

EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'防汛技术责任人' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'TB0201_RSCMIN_044', @level2type=N'COLUMN',@level2name=N'SKILLNM'

EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'防汛技术责任人电话' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'TB0201_RSCMIN_044', @level2type=N'COLUMN',@level2name=N'SKILLTEL'

EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'专职安全管理员' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'TB0201_RSCMIN_044', @level2type=N'COLUMN',@level2name=N'SAFETYNM'

EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'专职安全管理员电话' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'TB0201_RSCMIN_044', @level2type=N'COLUMN',@level2name=N'SAFETYTEL'

EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'水库一般信息表' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'TB0201_RSCMIN_044'

EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'堤防(段)名称代码' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'TB0401_DKCMIN_044', @level2type=N'COLUMN',@level2name=N'ENNMCD'

EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'堤防(段)名称' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'TB0401_DKCMIN_044', @level2type=N'COLUMN',@level2name=N'ENNM'

EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'所属工程名称代码' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'TB0401_DKCMIN_044', @level2type=N'COLUMN',@level2name=N'PROJCD'

EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'资料截止日期' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'TB0401_DKCMIN_044', @level2type=N'COLUMN',@level2name=N'INFNDT'

EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'管理单位代码' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'TB0401_DKCMIN_044', @level2type=N'COLUMN',@level2name=N'ADUNCD'

EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'管理单位名称' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'TB0401_DKCMIN_044', @level2type=N'COLUMN',@level2name=N'ADUNNM'

EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'堤防(段)级别' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'TB0401_DKCMIN_044', @level2type=N'COLUMN',@level2name=N'DKCL'

EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'地震基本烈度单位(度)' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'TB0401_DKCMIN_044', @level2type=N'COLUMN',@level2name=N'ERBSIN'

EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'地震设计烈度单位(度)' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'TB0401_DKCMIN_044', @level2type=N'COLUMN',@level2name=N'ERDSIN'

EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'水准基面' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'TB0401_DKCMIN_044', @level2type=N'COLUMN',@level2name=N'LVBSLV'

EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'假定水准基面位置' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'TB0401_DKCMIN_044', @level2type=N'COLUMN',@level2name=N'DLBLP'

EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'情况介绍' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'TB0401_DKCMIN_044', @level2type=N'COLUMN',@level2name=N'ININ'

EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'流水号' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'TB0401_DKCMIN_044', @level2type=N'COLUMN',@level2name=N'ATID'

EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'发送标示位' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'TB0401_DKCMIN_044', @level2type=N'COLUMN',@level2name=N'SDFL'

EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'备用字段' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'TB0401_DKCMIN_044', @level2type=N'COLUMN',@level2name=N'RMA'

EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'修改人' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'TB0401_DKCMIN_044', @level2type=N'COLUMN',@level2name=N'MDPS'

EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'修改日期' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'TB0401_DKCMIN_044', @level2type=N'COLUMN',@level2name=N'MDDT'

EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'堤防(段)一般信息表' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'TB0401_DKCMIN_044'

EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'堤防(段)名称代码' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'TB0404_BNBDCRPR_044', @level2type=N'COLUMN',@level2name=N'ENNMCD'

EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'堤防(段)横断面代码' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'TB0404_BNBDCRPR_044', @level2type=N'COLUMN',@level2name=N'BNTRCD'

EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'堤防(段)横断面名称' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'TB0404_BNBDCRPR_044', @level2type=N'COLUMN',@level2name=N'BNTR'

EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'测量日期' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'TB0404_BNBDCRPR_044', @level2type=N'COLUMN',@level2name=N'SRDT'

EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'起点距' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'TB0404_BNBDCRPR_044', @level2type=N'COLUMN',@level2name=N'JMDS'

EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'测点高程' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'TB0404_BNBDCRPR_044', @level2type=N'COLUMN',@level2name=N'SRPNEL'

EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'流水号' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'TB0404_BNBDCRPR_044', @level2type=N'COLUMN',@level2name=N'ATID'

EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'发送标示位' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'TB0404_BNBDCRPR_044', @level2type=N'COLUMN',@level2name=N'SDFL'

EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'备用字段' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'TB0404_BNBDCRPR_044', @level2type=N'COLUMN',@level2name=N'RMA'

EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'修改人' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'TB0404_BNBDCRPR_044', @level2type=N'COLUMN',@level2name=N'MDPS'

EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'修改日期' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'TB0404_BNBDCRPR_044', @level2type=N'COLUMN',@level2name=N'MDDT'

EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'堤防(段)横断面表' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'TB0404_BNBDCRPR_044'



/****** Object:  Table [dbo].[DSE_DBJC_005_HYDREALDATA]    Script Date: 2016-12-23 10:41:21 ******/
SET ANSI_NULLS ON

SET QUOTED_IDENTIFIER ON

SET ANSI_PADDING ON

CREATE TABLE [dbo].[DSE_DBJC_005_HYDREALDATA](
	[HYDCD] [varchar](16) NOT NULL,
	[TM] [datetime] NULL,
	[ORIGDATA] [numeric](12, 2) NULL,
	[JCL] [varchar](200) NULL,
	[OTDESC] [varchar](200) NULL,
	[GATTYPE] [varchar](1) NULL,
	[NT] [varchar](200) NULL,
	[CALCDATA] [numeric](12, 2) NULL,
 CONSTRAINT [PK_DSE_DBJC_005_HYDREALDATA] PRIMARY KEY CLUSTERED 
(
	[HYDCD] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]


SET ANSI_PADDING OFF

/****** Object:  Table [dbo].[DSE_DBJC_009_CXCDINFO]    Script Date: 2016-12-23 10:41:21 ******/
SET ANSI_NULLS ON

SET QUOTED_IDENTIFIER ON

SET ANSI_PADDING ON

CREATE TABLE [dbo].[DSE_DBJC_009_CXCDINFO](
	[BNTRCD] [varchar](12) NOT NULL,
	[XWIDTH] [numeric](6, 2) NULL,
	[YHEIGHT] [numeric](6, 2) NULL,
	[NT] [varchar](20) NULL,
	[SN] [numeric](16, 0) NOT NULL,
 CONSTRAINT [PK_DSE_DBJC_009_CXCDINFO] PRIMARY KEY CLUSTERED 
(
	[SN] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]


SET ANSI_PADDING OFF

/****** Object:  Table [dbo].[DSE_DBJC_009_FSQINFO]    Script Date: 2016-12-23 10:41:21 ******/
SET ANSI_NULLS ON

SET QUOTED_IDENTIFIER ON

SET ANSI_PADDING ON

CREATE TABLE [dbo].[DSE_DBJC_009_FSQINFO](
	[BNTRCD] [varchar](12) NOT NULL,
	[X] [numeric](8, 2) NULL,
	[TOPY] [numeric](8, 2) NULL,
	[BUTTOMY] [numeric](8, 2) NULL,
	[FLQ_X] [numeric](8, 2) NULL,
	[FLQ_Y] [numeric](8, 2) NULL,
	[BEGINX] [numeric](8, 2) NULL,
	[BEGINY] [numeric](8, 2) NULL,
	[EX] [numeric](8, 2) NULL,
	[EY] [numeric](8, 2) NULL,
	[NT] [varchar](20) NULL,
 CONSTRAINT [PK_DSE_DBJC_009_FSQINFO] PRIMARY KEY CLUSTERED 
(
	[BNTRCD] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]


SET ANSI_PADDING OFF

/****** Object:  Table [dbo].[DSE_MONITORING_OP_POINTS]    Script Date: 2016-12-23 10:41:21 ******/
SET ANSI_NULLS ON

SET QUOTED_IDENTIFIER ON

SET ANSI_PADDING ON

CREATE TABLE [dbo].[DSE_MONITORING_OP_POINTS](
	[POINTCD] [varchar](12) NOT NULL,
	[CXCD] [varchar](16) NULL,
	[JCXCD] [varchar](16) NULL,
	[HYDNAME] [varchar](30) NULL,
	[HYDLC] [varchar](50) NULL,
	[DNBDTP] [varchar](1) NULL,
	[PPTOPEL] [numeric](8, 3) NULL,
	[PPBTMEL] [numeric](8, 3) NULL,
	[SORTIDX] [numeric](3, 0) NULL,
	[XLABEL] [numeric](12, 2) NULL,
	[YLABEL] [numeric](12, 2) NULL,
	[SETDATE] [datetime] NULL,
	[STDATE] [datetime] NULL,
	[ORIGZ] [numeric](8, 3) NULL,
	[ORIGLZ] [numeric](8, 3) NULL,
	[ORIGTEMP] [numeric](8, 2) NULL,
	[ORIGDATA] [numeric](8, 3) NULL,
	[DESCR] [varchar](200) NULL,
	[NT] [varchar](30) NULL,
 CONSTRAINT [PK_DSE_MONITORING_OP_POINTS] PRIMARY KEY CLUSTERED 
(
	[POINTCD] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]


SET ANSI_PADDING OFF

/****** Object:  Table [dbo].[DSE_ST_RSVR_REAL]    Script Date: 2016-12-23 10:41:21 ******/
SET ANSI_NULLS ON

SET QUOTED_IDENTIFIER ON

SET ANSI_PADDING ON

CREATE TABLE [dbo].[DSE_ST_RSVR_REAL](
	[STCD] [char](8) NOT NULL,
	[TM] [datetime] NOT NULL,
	[RZ] [numeric](7, 3) NULL,
	[INQ] [numeric](9, 3) NULL,
	[W] [numeric](9, 3) NULL,
	[BLRZ] [numeric](7, 3) NULL,
	[OTQ] [numeric](9, 3) NULL,
	[RWCHRCD] [char](1) NULL,
	[RWPTN] [char](1) NULL,
	[INQDR] [numeric](5, 2) NULL,
	[MSQMT] [char](1) NULL,
 CONSTRAINT [PK_DSE_ST_RSVR_REAL] PRIMARY KEY CLUSTERED 
(
	[STCD] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]


SET ANSI_PADDING OFF

/****** Object:  Table [dbo].[DSE_STBPRP_M_ENNM]    Script Date: 2016-12-23 10:41:21 ******/
SET ANSI_NULLS ON

SET QUOTED_IDENTIFIER ON

SET ANSI_PADDING ON

CREATE TABLE [dbo].[DSE_STBPRP_M_ENNM](
	[DBCD] [numeric](16, 0) NOT NULL,
	[STCD] [char](8) NULL,
	[ENNMCD] [varchar](16) NULL,
 CONSTRAINT [PK_DSE_STBPRP_M_ENNM] PRIMARY KEY CLUSTERED 
(
	[DBCD] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]


SET ANSI_PADDING OFF

/****** Object:  Table [dbo].[ST_RSVRFSR_B]    Script Date: 2016-12-23 10:41:21 ******/
SET ANSI_NULLS ON

SET QUOTED_IDENTIFIER ON

SET ANSI_PADDING ON

CREATE TABLE [dbo].[ST_RSVRFSR_B](
	[STCD] [char](8) NOT NULL,
	[BGMD] [char](4) NOT NULL,
	[EDMD] [char](4) NOT NULL,
	[FSLTDZ] [numeric](7, 3) NULL,
	[FSLTDW] [numeric](9, 3) NULL,
	[FSTP] [char](1) NULL,
	[MODITIME] [datetime] NULL,
 CONSTRAINT [PK_ST_RSVRFSR_B] PRIMARY KEY CLUSTERED 
(
	[STCD] ASC,
	[BGMD] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]


SET ANSI_PADDING OFF

EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'测点编号' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'DSE_DBJC_005_HYDREALDATA', @level2type=N'COLUMN',@level2name=N'HYDCD'

EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'采集时间' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'DSE_DBJC_005_HYDREALDATA', @level2type=N'COLUMN',@level2name=N'TM'

EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'监测值' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'DSE_DBJC_005_HYDREALDATA', @level2type=N'COLUMN',@level2name=N'ORIGDATA'

EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'监测量' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'DSE_DBJC_005_HYDREALDATA', @level2type=N'COLUMN',@level2name=N'JCL'

EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'其他' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'DSE_DBJC_005_HYDREALDATA', @level2type=N'COLUMN',@level2name=N'OTDESC'

EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'采集方式(0:自动,1:人工)' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'DSE_DBJC_005_HYDREALDATA', @level2type=N'COLUMN',@level2name=N'GATTYPE'

EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'备注' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'DSE_DBJC_005_HYDREALDATA', @level2type=N'COLUMN',@level2name=N'NT'

EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'计算值' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'DSE_DBJC_005_HYDREALDATA', @level2type=N'COLUMN',@level2name=N'CALCDATA'

EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'渗压位移实时数据表(DSE_DBJC_005_HYDREALDATA)' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'DSE_DBJC_005_HYDREALDATA'

EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'堤防(段)横断面代码' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'DSE_DBJC_009_CXCDINFO', @level2type=N'COLUMN',@level2name=N'BNTRCD'

EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'X坐标' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'DSE_DBJC_009_CXCDINFO', @level2type=N'COLUMN',@level2name=N'XWIDTH'

EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Y坐标' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'DSE_DBJC_009_CXCDINFO', @level2type=N'COLUMN',@level2name=N'YHEIGHT'

EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'备注' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'DSE_DBJC_009_CXCDINFO', @level2type=N'COLUMN',@level2name=N'NT'

EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'渗压测线测点连接关系表(DSE_DBJC_009_CXCDINFO)' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'DSE_DBJC_009_CXCDINFO'

EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'堤防(段)横断面代码' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'DSE_DBJC_009_FSQINFO', @level2type=N'COLUMN',@level2name=N'BNTRCD'

EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'x坐标' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'DSE_DBJC_009_FSQINFO', @level2type=N'COLUMN',@level2name=N'X'

EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'y坐标（防渗墙顶高程）' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'DSE_DBJC_009_FSQINFO', @level2type=N'COLUMN',@level2name=N'TOPY'

EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'y坐标（防渗墙底高程）' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'DSE_DBJC_009_FSQINFO', @level2type=N'COLUMN',@level2name=N'BUTTOMY'

EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'防浪墙x' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'DSE_DBJC_009_FSQINFO', @level2type=N'COLUMN',@level2name=N'FLQ_X'

EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'防浪墙y' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'DSE_DBJC_009_FSQINFO', @level2type=N'COLUMN',@level2name=N'FLQ_Y'

EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'起点x坐标' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'DSE_DBJC_009_FSQINFO', @level2type=N'COLUMN',@level2name=N'BEGINX'

EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'起点y坐标' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'DSE_DBJC_009_FSQINFO', @level2type=N'COLUMN',@level2name=N'BEGINY'

EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'终点x坐标' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'DSE_DBJC_009_FSQINFO', @level2type=N'COLUMN',@level2name=N'EX'

EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'终点y坐标' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'DSE_DBJC_009_FSQINFO', @level2type=N'COLUMN',@level2name=N'EY'

EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'备注' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'DSE_DBJC_009_FSQINFO', @level2type=N'COLUMN',@level2name=N'NT'

EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'渗压防渗墙基本信息表(DSE_DBJC_009_FSQINFO)' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'DSE_DBJC_009_FSQINFO'

EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'测点编码' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'DSE_MONITORING_OP_POINTS', @level2type=N'COLUMN',@level2name=N'POINTCD'

EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'测线编号' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'DSE_MONITORING_OP_POINTS', @level2type=N'COLUMN',@level2name=N'CXCD'

EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'监测项目编号' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'DSE_MONITORING_OP_POINTS', @level2type=N'COLUMN',@level2name=N'JCXCD'

EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'测点名称' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'DSE_MONITORING_OP_POINTS', @level2type=N'COLUMN',@level2name=N'HYDNAME'

EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'测点位置' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'DSE_MONITORING_OP_POINTS', @level2type=N'COLUMN',@level2name=N'HYDLC'

EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'坝基坝体类型(1：坝体,2：坝基)' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'DSE_MONITORING_OP_POINTS', @level2type=N'COLUMN',@level2name=N'DNBDTP'

EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'管口高程' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'DSE_MONITORING_OP_POINTS', @level2type=N'COLUMN',@level2name=N'PPTOPEL'

EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'管底高程' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'DSE_MONITORING_OP_POINTS', @level2type=N'COLUMN',@level2name=N'PPBTMEL'

EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'排序号' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'DSE_MONITORING_OP_POINTS', @level2type=N'COLUMN',@level2name=N'SORTIDX'

EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'坐标x(m)' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'DSE_MONITORING_OP_POINTS', @level2type=N'COLUMN',@level2name=N'XLABEL'

EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'坐标y(m)' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'DSE_MONITORING_OP_POINTS', @level2type=N'COLUMN',@level2name=N'YLABEL'

EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'埋设日期' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'DSE_MONITORING_OP_POINTS', @level2type=N'COLUMN',@level2name=N'SETDATE'

EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'始测日期' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'DSE_MONITORING_OP_POINTS', @level2type=N'COLUMN',@level2name=N'STDATE'

EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'始测库水位(m)' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'DSE_MONITORING_OP_POINTS', @level2type=N'COLUMN',@level2name=N'ORIGZ'

EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'始测下游水位(m)' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'DSE_MONITORING_OP_POINTS', @level2type=N'COLUMN',@level2name=N'ORIGLZ'

EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'始测气温(℃)' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'DSE_MONITORING_OP_POINTS', @level2type=N'COLUMN',@level2name=N'ORIGTEMP'

EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'始测读数' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'DSE_MONITORING_OP_POINTS', @level2type=N'COLUMN',@level2name=N'ORIGDATA'

EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'说明' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'DSE_MONITORING_OP_POINTS', @level2type=N'COLUMN',@level2name=N'DESCR'

EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'备注' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'DSE_MONITORING_OP_POINTS', @level2type=N'COLUMN',@level2name=N'NT'

EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'渗压测点基本信息扩展表(DSE_MONITORING_OP_POINTS)' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'DSE_MONITORING_OP_POINTS'

EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'测站编码' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'DSE_ST_RSVR_REAL', @level2type=N'COLUMN',@level2name=N'STCD'

EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'时间' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'DSE_ST_RSVR_REAL', @level2type=N'COLUMN',@level2name=N'TM'

EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'库上水位单位(m)' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'DSE_ST_RSVR_REAL', @level2type=N'COLUMN',@level2name=N'RZ'

EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'入库流量单位(m3/s)' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'DSE_ST_RSVR_REAL', @level2type=N'COLUMN',@level2name=N'INQ'

EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'蓄水量单位(103m3)' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'DSE_ST_RSVR_REAL', @level2type=N'COLUMN',@level2name=N'W'

EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'库下水位单位(m)' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'DSE_ST_RSVR_REAL', @level2type=N'COLUMN',@level2name=N'BLRZ'

EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'出库流量单位(m3/s)' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'DSE_ST_RSVR_REAL', @level2type=N'COLUMN',@level2name=N'OTQ'

EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'库水特征码' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'DSE_ST_RSVR_REAL', @level2type=N'COLUMN',@level2name=N'RWCHRCD'

EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'库水水势' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'DSE_ST_RSVR_REAL', @level2type=N'COLUMN',@level2name=N'RWPTN'

EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'入流时段长' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'DSE_ST_RSVR_REAL', @level2type=N'COLUMN',@level2name=N'INQDR'

EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'测流方法' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'DSE_ST_RSVR_REAL', @level2type=N'COLUMN',@level2name=N'MSQMT'

EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'水库实时水情表表结构 ' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'DSE_ST_RSVR_REAL'

EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'测站与工程的映射关系表' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'DSE_STBPRP_M_ENNM'

EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'测站编码' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'ST_RSVRFSR_B', @level2type=N'COLUMN',@level2name=N'STCD'

EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'开始月日' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'ST_RSVRFSR_B', @level2type=N'COLUMN',@level2name=N'BGMD'

EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'结束月日' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'ST_RSVRFSR_B', @level2type=N'COLUMN',@level2name=N'EDMD'

EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'汛限水位单位(m)' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'ST_RSVRFSR_B', @level2type=N'COLUMN',@level2name=N'FSLTDZ'

EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'汛限库容单位(万m3)' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'ST_RSVRFSR_B', @level2type=N'COLUMN',@level2name=N'FSLTDW'

EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'汛期类别' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'ST_RSVRFSR_B', @level2type=N'COLUMN',@level2name=N'FSTP'

EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'时间戳' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'ST_RSVRFSR_B', @level2type=N'COLUMN',@level2name=N'MODITIME'

EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'库(湖)站汛限水位表 ' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'ST_RSVRFSR_B'


go
--根据水库查询断面信息
 creatE VIEW [dbo].[V_RSC_M_BNTR]  AS     SELECT  t1.ENNMCD, t1.ENNM, t3.BNTR, t3.BNTRCD     FROM    dbo.TB0201_RSCMIN_044 AS t1             INNER JOIN dbo.TB0401_DKCMIN_044 AS t2 ON t1.ENNMCD = t2.PROJCD             INNER JOIN dbo.TB0404_BNBDCRPR_044 AS t3 ON t2.ENNMCD = t3.ENNMCD 

 go
--渗压历史表触发到实时表
 create TRIGGER [dbo].[TRIG_HIS_TO_REAL] ON [dbo].[DSE_DBJC_005_HYDORIGDATA]

AFTER INSERT,DELETE,UPDATE
AS
BEGIN

	   DECLARE @HYDCD varchar(16) --测点编号
       DECLARE @TM    datetime    --采集时间
       DECLARE @ORIGDATA   numeric(12,2) --监测值
       DECLARE @JCL   varchar(200) --监测量
       DECLARE @OTDESC varchar(200) --其他
       DECLARE @GATTYPE varchar(1) --采集方式(0:自动,1:人工)
       DECLARE @NT   varchar(200) --备注
       DECLARE @CALCDATA    numeric(12,2) --计算值
       
       
       
		 --新增或者修改
	IF EXISTS ( SELECT 1 FROM INSERTED )  
		BEGIN
			
			--新增
			IF NOT EXISTS ( SELECT 1 FROM DELETED )  
				BEGIN
				    SELECT @HYDCD=HYDCD, @TM=tm,@ORIGDATA=ORIGDATA,@JCL=JCL,@OTDESC=OTDESC,@GATTYPE=GATTYPE,@NT=NT,@CALCDATA=CALCDATA FROM INSERTED
					DELETE DSE_DBJC_005_HYDREALDATA WHERE hydcd=@HYDCD;
				    insert into DSE_DBJC_005_HYDREALDATA values(@HYDCD,@TM,@ORIGDATA,@JCL,@OTDESC,@GATTYPE,@NT,@CALCDATA);
				END
			-- 修改	
			ELSE IF EXISTS ( SELECT 1 FROM DELETED ) 
				BEGIN
				    SELECT @HYDCD=HYDCD, @TM=tm,@ORIGDATA=ORIGDATA,@JCL=JCL,@OTDESC=OTDESC,@GATTYPE=GATTYPE,@NT=NT,@CALCDATA=CALCDATA FROM INSERTED
				    UPDATE DSE_DBJC_005_HYDREALDATA set ORIGDATA=@ORIGDATA,JCL=@JCL,OTDESC=@OTDESC,GATTYPE=@GATTYPE,NT=@NT,CALCDATA=@CALCDATA WHERE  tm=@TM and hydcd=@HYDCD;
				END	
	
		end 
	--删除	
	ELSE IF EXISTS ( SELECT 1 FROM DELETED )
		BEGIN
		SELECT @HYDCD=HYDCD, @TM=tm,@ORIGDATA=ORIGDATA,@JCL=JCL,@OTDESC=OTDESC,@GATTYPE=GATTYPE,@NT=NT,@CALCDATA=CALCDATA FROM DELETED
		      DELETE DSE_DBJC_005_HYDREALDATA WHERE  tm=@TM and hydcd=@HYDCD;
		   
		END   

END
