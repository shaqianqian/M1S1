library IEEE;
use IEEE.STD_LOGIC_1164.ALL;
use IEEE.NUMERIC_STD.ALL;

entity clk_div is
    Port ( clk : in  STD_LOGIC;
           clk_4hz : inout  STD_LOGIC := '0');
end clk_div;

architecture Behavioral of clk_div is

begin

	process (clk)
	
		variable compt : unsigned(23 downto 0) := (others => '0');
	
		begin
		
			if (clk'event and clk='1') then
				compt := compt + 1;
				if compt = X"BEBC20" then
					if clk_4hz = '0' then
						clk_4hz <= '1';
					else
						clk_4hz <= '0';
					end if;
					compt := (others => '0');
				end if;
			end if;
	
	end process;

end Behavioral;
