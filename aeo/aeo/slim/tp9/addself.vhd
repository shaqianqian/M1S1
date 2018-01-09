library IEEE;
use IEEE.STD_LOGIC_1164.ALL;
use ieee.std_logic_unsigned.all;
use ieee.std_logic_arith.all;

entity addself is
GENERIC (Mycode : std_logic_vector (10 downto 0):="00000000011");    
        Port ( Tin : in  STD_LOGIC_VECTOR (31 downto 0);
           IPcode : in  STD_LOGIC_VECTOR (10 downto 0);
           Tout : out  STD_LOGIC_VECTOR (31 downto 0));
end addself;

architecture Behavioral of addself is

begin
		Tout<= x"00000001"+Tin when Mycode=IPcode else 
		(others=>'Z');
end Behavioral;

