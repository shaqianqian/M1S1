 -- ================= new IP ================
library IEEE;
use IEEE.STD_LOGIC_1164.ALL;
use ieee.std_logic_unsigned.all;
entity IPRGB2hexa is
generic ( mycode : STD_LOGIC_VECTOR (10 downto 0):= "00000011100");
   port ( 
   clk : in  STD_LOGIC;
   reset : in  STD_LOGIC:='0';
   Tin : in  STD_LOGIC_VECTOR (31 downto 0);
   Nin : in  STD_LOGIC_VECTOR (31 downto 0);
   N2in : in  STD_LOGIC_VECTOR (31 downto 0);
   Tout : out  STD_LOGIC_VECTOR (31 downto 0);
   Ipcode : in  STD_LOGIC_VECTOR (10 downto 0)
end IPRGB2hexa;
 -- ================= new IP ================
library IEEE;
use IEEE.STD_LOGIC_1164.ALL;
use ieee.std_logic_unsigned.all;
entity IPhexa2RGB is
generic ( mycode : STD_LOGIC_VECTOR (10 downto 0):= "00000011000");
   port ( 
   clk : in  STD_LOGIC;
   reset : in  STD_LOGIC:='0';
   Tin : in  STD_LOGIC_VECTOR (31 downto 0);
   Tout : out  STD_LOGIC_VECTOR (31 downto 0);
   Nout : out  STD_LOGIC_VECTOR (31 downto 0);
   N2out : out  STD_LOGIC_VECTOR (31 downto 0);
   Ipcode : in  STD_LOGIC_VECTOR (10 downto 0)
end IPhexa2RGB;
