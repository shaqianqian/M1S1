----------------------------------------------------------------------------------
-- Company: 
-- Engineer: 
-- 
-- Create Date:    18:03:42 10/04/2016 
-- Design Name: 
-- Module Name:    clk_div - Behavioral 
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
use IEEE.NUMERIC_STD.ALL;

-- Uncomment the following library declaration if instantiating
-- any Xilinx primitives in this code.
--library UNISIM;
--use UNISIM.VComponents.all;

entity clk_div is
    Port ( clk : in  STD_LOGIC;
           clk_4hz : inout  STD_LOGIC := '0');
end clk_div;

architecture Behavioral of clk_div is

begin
//将时钟周期分为4hz（25000000）
	process (clk)
	
		variable compt : unsigned(23 downto 0) := (others => '0');
	
		begin
		
			if (clk'event and clk='1') then
				compt := compt + 1;
				if compt = X"BEBC20" then
					if clk_4hz = '0' then
						clk_4hz <= '1';//满12500000，原来0变成1
					else
						clk_4hz <= '0';//满12500000，原来1变成0
					end if;
					compt := (others => '0');//完成一个周期，重置compt，开始下一周期的计数
				end if;
			end if;
	
	end process;

end Behavioral;

