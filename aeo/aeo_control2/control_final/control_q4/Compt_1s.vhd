library IEEE;
use IEEE.STD_LOGIC_1164.ALL;
use IEEE.NUMERIC_STD.ALL;

entity clk_1s is
    Port ( clk : in  STD_LOGIC;
           clk_1hz : inout  STD_LOGIC := '0'
			  
			  );
end clk_1s; 
	
architecture Behavioral of clk_1s is

begin

	process (clk)
	
		variable compt : unsigned(27 downto 0) := (others => '0');
	
		begin
		
			if (clk'event and clk='1') then
				compt := compt + 1;
				if compt = X"2FAF080" then
					if clk_1hz = '0' then
						clk_1hz <= '1';
					else
						clk_1hz <= '0';
					end if;
					compt := (others => '0');
					end if;
			end if;
	
	end process;

end Behavioral;