library IEEE;
use IEEE.STD_LOGIC_1164.ALL;
use ieee.std_logic_unsigned.all;


entity shift_vector is
    Port ( --btn : in  STD_LOGIC;
           sw : in  STD_LOGIC_VECTOR (7 downto 0);
           clk : in  STD_LOGIC;
           led : out  STD_LOGIC_VECTOR (7 downto 0));
end shift_vector;

architecture Behavioral of shift_vector is

begin

	process (clk, sw)
	
		variable i : integer := 7;
		variable temp : std_logic_vector (7 downto 0) := "10000000";
		variable sens : std_logic := '0';
		
	begin

		if (clk'event and clk='1') then
			
			temp(i) := '0';
			
			if (sw(i) = '1') then
				if (sens = '0') then
					sens := '1';
				else
					sens := '0';
				end if;
			end if;
			
			if (sens = '0') then
				if (i = 0) then
					temp(7) := '1';
					i := 7;
				else
					temp(i-1) := '1';
					i := i-1;
				end if;
			else
				if (i = 7) then
					temp(0) := '1';
					i := 0;
				else
					temp(i+1) := '1';
					i := i+1;
				end if;
			end if;
			
			led <= temp;
			
		end if;

	end process ;

end Behavioral;
