----------------------------------------------------------------------------------
-- Company: 
-- Engineer: 
-- 
-- Create Date:    15:57:48 12/05/2017 
-- Design Name: 
-- Module Name:    three - Behavioral 
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

entity three is
Port ( e_1: in  STD_LOGIC_VECTOR (31 downto 0);
       e_2: in  STD_LOGIC_VECTOR (31 downto 0);
		 e_3: in  STD_LOGIC_VECTOR (31 downto 0);
       s_1: out  STD_LOGIC_VECTOR (31 downto 0);
       s_2: out  STD_LOGIC_VECTOR (31 downto 0);
		 s_3: out  STD_LOGIC_VECTOR (31 downto 0)
           
);
end three;

architecture Behavioral of three is
       
component swap is
Port ( e1: in  STD_LOGIC_VECTOR (31 downto 0);
       e2: in  STD_LOGIC_VECTOR (31 downto 0);
       s1: out  STD_LOGIC_VECTOR (31 downto 0);
       s2: out  STD_LOGIC_VECTOR (31 downto 0)
           
);
end component;
threeti: swap


begin


end Behavioral;

