library IEEE;
use IEEE.STD_LOGIC_1164.ALL;

entity chenillard is
    Port ( clk_entree : in  STD_LOGIC;
           led_sortie : out  STD_LOGIC_VECTOR (7 downto 0));
end chenillard;

architecture Behavioral of chenillard is

	signal clk_sortie : STD_LOGIC;

	component clk_1hz is
    Port ( clk : in  STD_LOGIC;
           clk_1hz : inout  STD_LOGIC := '0');
	end component;
	
	component shift_vector is
    Port ( clk : in  STD_LOGIC;
           led : out  STD_LOGIC_VECTOR (7 downto 0));
	end component;

begin

	cmp1 : clk_1hz port map (clk => clk_entree, clk_1hz => clk_sortie);
	cmp2 : shift_vector port map (clk => clk_sortie, led => led_sortie);

end Behavioral;
