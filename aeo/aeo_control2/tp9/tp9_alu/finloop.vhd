library IEEE;
use IEEE.STD_LOGIC_1164.ALL;

entity finloop is
GENERIC (Mycode : std_logic_vector (10 downto 0):="00000000010");    
    Port ( Tin : in  STD_LOGIC_VECTOR (31 downto 0);
           IPcode : in  STD_LOGIC_VECTOR (10 downto 0);
           Tout : out  STD_LOGIC_VECTOR (31 downto 0));
end finloop;

architecture Behavioral of finloop is

begin	
Tout<= x"FFFFFFFF" when Tin=x"00010000" and Mycode=IPcode else 
		(others=>'Z');
Tout<= x"00000000" when (Tin < x"00010000" OR Tin >x"00010000") and Mycode=IPcode else
		(others=>'Z');
end Behavioral;

