 -- ================= new IP ================
library IEEE;
use IEEE.STD_LOGIC_1164.ALL;
use ieee.std_logic_unsigned.all;
entity IPwait1s is
generic ( mycode : STD_LOGIC_VECTOR (10 downto 0):= "10000011110");
   port ( 
   clk : in  STD_LOGIC;
   reset : in  STD_LOGIC:='0';
   Ipcode : in  STD_LOGIC_VECTOR (10 downto 0)
end IPwait1s;
