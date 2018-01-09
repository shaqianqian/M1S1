----------------------------------------------------------------------------------
-- Company: 
-- Engineer: 
-- 
-- Create Date:    17:19:15 10/04/2016 
-- Design Name: 
-- Module Name:    shift_vector - Behavioral 
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
use ieee.std_logic_unsigned.all;

-- Uncomment the following library declaration if using
-- arithmetic functions with Signed or Unsigned values
--use IEEE.NUMERIC_STD.ALL;

-- Uncomment the following library declaration if instantiating
-- any Xilinx primitives in this code.
--library UNISIM;
--use UNISIM.VComponents.all;

entity shift_vector is
    Port ( --btn : in  STD_LOGIC_VECTOR (4 downto 0);
           --sw : in  STD_LOGIC_VECTOR (7 downto 0);
           clk : in  STD_LOGIC;
           led : out  STD_LOGIC_VECTOR (7 downto 0));
end shift_vector;

architecture Behavioral of shift_vector is

begin

	process (clk)
	
		variable i : integer := 7;
		variable temp : std_logic_vector (7 downto 0) := "10000000";//一开始led7亮
		
	begin
//led7亮完立刻跳转到led6亮，之后led5亮，类推到led0亮，又返回led7亮，形成一个回路
		if (clk'event and clk='1') then
			temp(i) := '1';
			if(i = 7) then
				temp(0) := '0';//led7亮，它前一个led0不亮，为0
			else
				temp(i+1) := '0';//当前led亮，它前一个led不亮（假设led6亮，它前一个led7不亮，为0，所以是i+1为0）
			end if;
			if(i = 0) then
				i := 7;//特别设置led0到led7
			else
				i := i - 1;//led7到led6到led5.。。
			end if;
		end if;
		
		led <= temp;

	end process ;

end Behavioral;

