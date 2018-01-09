library IEEE;
use IEEE.STD_LOGIC_1164.ALL;
use ieee.std_logic_unsigned.all;
use ieee.std_logic_arith.all;
entity IP_ALU is
GENERIC (Mycode : std_logic_vector (10 downto 0):="00000000000");    
Port ( 
				Tin:in  STD_LOGIC_VECTOR (31 downto 0);
           IPcode : in  STD_LOGIC_VECTOR (10 downto 0);
           Tout : out  STD_LOGIC_VECTOR (31 downto 0));
end IP_ALU;

architecture Behavioral of IP_ALU is

begin
		
		Tout<= x"00000000" when Tin>x"00ffe001" and Mycode=IPcode else 
		(others=>'Z');
		Tout<= x"FFFFFFFF" when (Tin<x"00ffe001" or Tin = x"00ffe001")and Mycode=IPcode else
		(others=>'Z');
		
 end Behavioral;

