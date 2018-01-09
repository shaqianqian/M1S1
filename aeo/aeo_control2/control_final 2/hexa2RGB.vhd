library IEEE;
use IEEE.STD_LOGIC_1164.ALL;
--Put 24bits mot into 8bits mot
entity hexa2RGB is 
Port ( hexa : in  STD_LOGIC_VECTOR (23 downto 0);
           R: out  STD_LOGIC_VECTOR (7 downto 0);
           G : out  STD_LOGIC_VECTOR (7 downto 0);
           B : out  STD_LOGIC_VECTOR (7 downto 0)
);
end hexa2RGB;

architecture Behavioral of hexa2RGB is
   
begin
	R <= hexa(23 downto 16);
	G <= hexa(15 downto 8);
	B <= hexa(7 downto 0);
end Behavioral;

