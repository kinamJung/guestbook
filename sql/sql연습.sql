select * from GUESTBOOK g;

--insert
insert into GUESTBOOK values( GUESTBOOK_SEQ.nextval, '고길동' ,'1234', 'what up', SYSDATE );


--delete
delete from GUESTBOOK  where no = 2 and password='1234';

--select
select no, name, password, message, to_char(reg_date,'YYYY-MM-DD HH:MI:SS') from GUESTBOOK;

rollback;

commit;