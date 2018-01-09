library IEEE;
use IEEE.STD_LOGIC_1164.ALL;

entity random is
generic ( width : integer :=  32 ); 
port (
clk , reset : in std_logic;
enable : in std_logic;
random_num : out std_logic_vector (width-1 downto 0)   --output vector            
);
end random;

architecture Behavioral of random is

signal r : STD_LOGIC_VECTOR (31 downto 0) := x"80000000";
begin

process(clk)
begin
	if clk'event and clk = '1' then
		if reset = '1' then
			r<= x"80000000";
		else
			if enable = '1' then
				r <= (((r(0) xor r(2)) xor r(3)) xor r(4)) & r(31 downto 1);
			end if;
		end if;
	end if;
	random_num <= r;
end process;


end Behavioral;

