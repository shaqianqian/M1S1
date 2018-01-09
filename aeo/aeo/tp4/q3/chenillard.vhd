library IEEE;
use IEEE.STD_LOGIC_1164.ALL;


entity chenillard is
    Port ( clk_entree : in  STD_LOGIC;
			  sw_entree : in  STD_LOGIC_VECTOR (7 downto 0);
           led_sortie : out  STD_LOGIC_VECTOR (7 downto 0));
end chenillard;

architecture Behavioral of chenillard is

	signal clk_sortie : STD_LOGIC;

	component clk_div is
    Port ( clk : in  STD_LOGIC;
           clk_4hz : inout  STD_LOGIC := '0');
	end component;
	
	component shift_vector is
    Port ( sw : in  STD_LOGIC_VECTOR (7 downto 0);
			  clk : in  STD_LOGIC;
           led : out  STD_LOGIC_VECTOR (7 downto 0));
	end component;

begin

	U1 : clk_div port map (clk => clk_entree, clk_4hz => clk_sortie);
	U2 : shift_vector port map (sw => sw_entree, clk => clk_sortie, led => led_sortie);

end Behavioral;
