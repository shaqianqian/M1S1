library IEEE;
use IEEE.STD_LOGIC_1164.ALL;
use IEEE.NUMERIC_STD.ALL;

entity acompt_1s is
    Port ( clk : in  STD_LOGIC;
           clk_1hz : INout  STD_LOGIC := '0'
			  );
end acompt_1s;

architecture Behavioral of acompt_1s is

begin

	process (clk)
	
		variable compt : unsigned(27 downto 0) := (others => '0');
	
		begin
		
			if (clk'event and clk='1') then
			  compt := compt + 1;
			  clk_1hz <= '0';
					if compt = x"FFFFFF0" then
					compt := (others => '0');
					clk_1hz <= '1';
					end if;
			end if;
	
	end process;

end Behavioral;