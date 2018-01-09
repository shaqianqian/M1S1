----------------------------------------------------------------------------------
-- Company: 
-- Engineer: 
-- 
-- Create Date:    16:17:27 10/04/2016 
-- Design Name: 
-- Module Name:    fpd - Behavioral 
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

entity fpd is
GENERIC (init_value: STD_Logic  := '0');
    Port ( d : in  STD_LOGIC;
           q : out  STD_LOGIC := init_value;
           clk : in  STD_LOGIC);
end fpd;

architecture Behavioral of fpd is

begin

	process (clk)
	begin

		 if (clk'event and clk='1') then
			q <= d;
		 end if ;

	end process ;

end Behavioral;

