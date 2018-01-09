
library IEEE;
use IEEE.STD_LOGIC_1164.ALL;
use ieee.std_logic_unsigned.all;
use IEEE.NUMERIC_STD.ALL;
entity calc is
Port(
clk:in std_logic;
clk_1s:out std_logic
);
end calc;

architecture Behavioral of calc is

begin

process(clk)
--variable haha :std_logic_vector(15 downto 0) := (others=>'0');
variable compt : std_logic_vector(27 downto 0) := (others => '0');
variable clk_variable: std_logic:='0';
begin
	if (clk'event and clk='1') then
		if compt=X"5F5E100" then
				compt:=(others=>'0');
			   clk_variable:='1';
		else
			clk_variable:='0';
			compt:=compt+1;
		end if;
	end if;
	clk_1s<=clk_variable;
end process;
end Behavioral;
