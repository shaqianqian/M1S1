 -- ================= new IP ================
library IEEE;
use IEEE.STD_LOGIC_1164.ALL;
use ieee.std_logic_unsigned.all;
entity IPrdm is
generic ( mycode : STD_LOGIC_VECTOR (10 downto 0):= "00000010000");
   port ( 
   clk : in  STD_LOGIC;
   reset : in  STD_LOGIC:='0';
   Tout : out  STD_LOGIC_VECTOR (31 downto 0);
   Nout : out  STD_LOGIC_VECTOR (31 downto 0);
   Ipcode : in  STD_LOGIC_VECTOR (10 downto 0)
end IPrdm;
 -- ================= new IP ================
library IEEE;
use IEEE.STD_LOGIC_1164.ALL;
use ieee.std_logic_unsigned.all;
entity IPsquare2 is
generic ( mycode : STD_LOGIC_VECTOR (10 downto 0):= "00000010100");
   port ( 
   clk : in  STD_LOGIC;
   reset : in  STD_LOGIC:='0';
   Tin : in  STD_LOGIC_VECTOR (31 downto 0);
   Nin : in  STD_LOGIC_VECTOR (31 downto 0);
   Tout : out  STD_LOGIC_VECTOR (31 downto 0);
   Ipcode : in  STD_LOGIC_VECTOR (10 downto 0)
end IPsquare2;
 -- ================= new IP ================
library IEEE;
use IEEE.STD_LOGIC_1164.ALL;
use ieee.std_logic_unsigned.all;
entity IPcomparateur is
generic ( mycode : STD_LOGIC_VECTOR (10 downto 0):= "00000000000");
   port ( 
   clk : in  STD_LOGIC;
   reset : in  STD_LOGIC:='0';
   Tin : in  STD_LOGIC_VECTOR (31 downto 0);
   Tout : out  STD_LOGIC_VECTOR (31 downto 0);
   Ipcode : in  STD_LOGIC_VECTOR (10 downto 0)
end IPcomparateur;
 -- ================= new IP ================
library IEEE;
use IEEE.STD_LOGIC_1164.ALL;
use ieee.std_logic_unsigned.all;
entity IPfinloop is
generic ( mycode : STD_LOGIC_VECTOR (10 downto 0):= "00000000010");
   port ( 
   clk : in  STD_LOGIC;
   reset : in  STD_LOGIC:='0';
   Tin : in  STD_LOGIC_VECTOR (31 downto 0);
   Tout : out  STD_LOGIC_VECTOR (31 downto 0);
   Ipcode : in  STD_LOGIC_VECTOR (10 downto 0)
end IPfinloop;
 -- ================= new IP ================
library IEEE;
use IEEE.STD_LOGIC_1164.ALL;
use ieee.std_logic_unsigned.all;
entity IPaddself is
generic ( mycode : STD_LOGIC_VECTOR (10 downto 0):= "00000000011");
   port ( 
   clk : in  STD_LOGIC;
   reset : in  STD_LOGIC:='0';
   Tin : in  STD_LOGIC_VECTOR (31 downto 0);
   Tout : out  STD_LOGIC_VECTOR (31 downto 0);
   Ipcode : in  STD_LOGIC_VECTOR (10 downto 0)
end IPaddself;
