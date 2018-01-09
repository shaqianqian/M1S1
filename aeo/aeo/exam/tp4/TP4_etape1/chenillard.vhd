----------------------------------------------------------------------------------
-- Company: 
-- Engineer: 
-- 
-- Create Date:    18:38:01 10/04/2016 
-- Design Name: 
-- Module Name:    chenillard - Behavioral 
-- Project Name: 
-- Target Devices: 
-- Tool versions: 
-- Description: 
--
-- Dependencies: 
--
-- Revision: 
-- Revision 0.01 - File Created
-- Additional Comments: 
--
----------------------------------------------------------------------------------
library IEEE;
use IEEE.STD_LOGIC_1164.ALL;

-- Uncomment the following library declaration if using
-- arithmetic functions with Signed or Unsigned values
--use IEEE.NUMERIC_STD.ALL;

-- Uncomment the following library declaration if instantiating
-- any Xilinx primitives in this code.
--library UNISIM;
--use UNISIM.VComponents.all;

entity chenillard is
    Port ( clk_entree : in  STD_LOGIC;
           led_sortie : out  STD_LOGIC_VECTOR (7 downto 0));
end chenillard;

architecture Behavioral of chenillard is

	signal clk_sortie : STD_LOGIC;

	component clk_div is
    Port ( clk : in  STD_LOGIC;
           clk_4hz : inout  STD_LOGIC := '0');
	end component;
	
	component shift_vector is
    Port ( clk : in  STD_LOGIC;
           led : out  STD_LOGIC_VECTOR (7 downto 0));
	end component;

begin

	cmp1 : clk_div port map (clk => clk_entree, clk_4hz => clk_sortie);
	cmp2 : shift_vector port map (clk => clk_sortie, led => led_sortie);

end Behavioral;

