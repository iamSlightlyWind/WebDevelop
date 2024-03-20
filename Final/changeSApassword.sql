-- this is to change the sa account password without policy check, since smss doesnt exist on linux
ALTER LOGIN [sa] WITH PASSWORD='123' , CHECK_POLICY = OFF

use Final

select * from users
select * from UserDetails
select * from FriendStatus
select * from MessageGroup
select * from Messages

truncate table messages