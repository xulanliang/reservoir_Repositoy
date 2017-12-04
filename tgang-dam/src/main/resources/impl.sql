insert into  DSE_DBJC_005_HYDORIGDATA(HYDCD,tm,ORIGDATA)
select t1.设计编号 as HYDCD, Rtime, j1
 from [dam_server_S1].[dbo].[HistoryData] t2,  [dam_server_S1].[dbo].[测点信息] t1 where  notest1 is not null and notest2 is not null
  and Rtime is not null and Rtime < GETDATE() and t2.notest1 = t1.单元号 and t2.notest2 = t1.测点号
and   exists (
select * from (
	select max(id) id from [dam_server_S1].[dbo].[HistoryData] t
 group by convert(varchar(100),t.notest1)+'_'+convert(varchar(100),t.notest2),t.Rtime ) t1 where t1.id=t2.id)



 insert into DSE_DBJC_005_HYDORIGDATA_EXT (id,notest1,notest2,j1,j2,c1,c2,yqstate,alarm,Rtime,yc,history1,flag)
select *
 from [dam_server_S1].[dbo].[HistoryData] t2 where  notest1 is not null and notest2 is not null
  and Rtime is not null and Rtime < GETDATE()
and   exists (
select * from (
	select max(id) id from [dam_server_S1].[dbo].[HistoryData] t
 group by convert(varchar(100),t.notest1)+'_'+convert(varchar(100),t.notest2),t.Rtime ) t1 where t1.id=t2.id)
