use test1;
go

/* select stuff and give it an index, group it by name */
--select 
--	row_number() 
--		over(partition by [name] order by [year] desc) as [Index]
--	, * 
--from PopularityInfo
--go

/* inset new values into the db */
--insert into PopularityInfo ([name], [year], NumberOfUsers) --values ('C++', 2017, 123000)
--select top 1 [name], 2017, NumberOfUsers from PopularityInfo
--go

/* rank the results, so order them and then number them in that order */
--select 
--	rank() 
--		over(order by NumberOfUsers desc) as [Index]
--	, * 
--from PopularityInfo
--go

/* order the langs by name, giving the same number to identical langs */
--select 
--	dense_rank() 
--		over(order by [name]) as [Index]
--	, * 
--from PopularityInfo
--go

/* output next results in later rows */
--select *, lead(NumberOfUsers, 1) over (partition by [name] order by NumberOfUsers) as [Next Year]
--from PopularityInfo
--go

/* output prev results in later rows */
--select *, lag(NumberOfUsers, 1) over (partition by [name] order by NumberOfUsers) as [Previous Year]
--from PopularityInfo
--go

/* output prev results in later rows */
--select *, lag([name], 1) over (order by [name]) as [Previous language]
--from PopularityInfo
--go

/* strictly divide the output into n groups */
--select *, ntile(3) over (order by [name])
--from PopularityInfo
--go

/* use exists to replace multiple in statements */
--with temptable ([NumberOfUsers], [year]) as (
--	select 300000, 2019
--	union all
--	select 123000, 2019
--	)
--select *
--from PopularityInfo
--where NumberOfUsers in (
--	select NumberOfUsers from temptable
--) and [year] in (
--	select [year] from temptable
--)
--go

/* declare a variable and read it */
declare @i INT = 100;
select @i
set @i = 3
select @i
--set @i += 1
--select @i

/* using if statements */
if (@i = 3) begin print 'good' end else begin print 'bad' end

/* using loops */
while (@i < 500)
begin
	print @i
	set @i *= @i
end