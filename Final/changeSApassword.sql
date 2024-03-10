-- this is to change the sa account password without policy check, since smss doesnt exist on linux
ALTER LOGIN [sa] WITH PASSWORD='sa' , CHECK_POLICY = OFF