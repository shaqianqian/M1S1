library IEEE;
use IEEE.STD_LOGIC_1164.ALL;
use ieee.std_logic_unsigned.all;

entity fibogen is
    Port ( clk      : in  STD_LOGIC;
           init     : in  STD_LOGIC;
           fiboout  : out STD_LOGIC_VECTOR (31 downto 0));
 
 attribute clock_signal : string;
 attribute clock_signal of clk : signal is "yes";
end fibogen;

architecture Behavioral of fibogen is
	signal fib, fib2 : std_logic_vector(31 downto 0);
begin

	process(clk)
	begin
		if clk'event and clk='1' then
			if init = '0' then
				fib <= fib2;
				fib2 <= fib + fib2;
			else
				fib <= x"00000001";
				fib2 <= x"00000001";
			end if;
		end if;
	fiboout <= fib2;
	end process;

end Behavioral;
