drop TABLE DSE_DBJC_009_FSQINFO;

USE [tiegang]
GO
/****** Object:  Table [dbo].[DSE_DBJC_009_FSQINFO]    Script Date: 2017-2-24 14:37:48 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
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
	[ID] [numeric](18, 0) IDENTITY(1,1) NOT NULL,
 CONSTRAINT [PK_DSE_DBJC_009_FSQINFO] PRIMARY KEY CLUSTERED
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'堤防(段)横断面代码' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'DSE_DBJC_009_FSQINFO', @level2type=N'COLUMN',@level2name=N'BNTRCD'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'x坐标' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'DSE_DBJC_009_FSQINFO', @level2type=N'COLUMN',@level2name=N'X'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'y坐标（防渗墙顶高程）' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'DSE_DBJC_009_FSQINFO', @level2type=N'COLUMN',@level2name=N'TOPY'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'y坐标（防渗墙底高程）' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'DSE_DBJC_009_FSQINFO', @level2type=N'COLUMN',@level2name=N'BUTTOMY'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'防浪墙x' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'DSE_DBJC_009_FSQINFO', @level2type=N'COLUMN',@level2name=N'FLQ_X'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'防浪墙y' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'DSE_DBJC_009_FSQINFO', @level2type=N'COLUMN',@level2name=N'FLQ_Y'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'起点x坐标' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'DSE_DBJC_009_FSQINFO', @level2type=N'COLUMN',@level2name=N'BEGINX'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'起点y坐标' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'DSE_DBJC_009_FSQINFO', @level2type=N'COLUMN',@level2name=N'BEGINY'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'终点x坐标' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'DSE_DBJC_009_FSQINFO', @level2type=N'COLUMN',@level2name=N'EX'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'终点y坐标' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'DSE_DBJC_009_FSQINFO', @level2type=N'COLUMN',@level2name=N'EY'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'备注' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'DSE_DBJC_009_FSQINFO', @level2type=N'COLUMN',@level2name=N'NT'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'渗压防渗墙基本信息表(DSE_DBJC_009_FSQINFO)' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'DSE_DBJC_009_FSQINFO'
GO

USE [tiegang]
GO
/****** Object:  Table [dbo].[DSE_DBJC_005_HYDORIGDATA_EXT]    Script Date: 2017-3-1 11:22:45 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[DSE_DBJC_005_HYDORIGDATA_EXT](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[notest1] [int] NOT NULL,
	[notest2] [int] NOT NULL,
	[j1] [numeric](18, 3) NULL,
	[j2] [numeric](18, 3) NULL,
	[c1] [numeric](18, 3) NULL,
	[c2] [numeric](18, 3) NULL,
	[yqstate] [varchar](50) NULL,
	[alarm] [varchar](50) NULL,
	[Rtime] [datetime] NOT NULL,
	[yc] [nvarchar](50) NULL,
	[history1] [varchar](3000) NULL,
	[flag] [smallint] NULL,
 CONSTRAINT [PK_DSE_DBJC_005_HYDORIGDATA_EXT] PRIMARY KEY CLUSTERED
(
	[notest1] ASC,
	[notest2] ASC,
	[Rtime] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
