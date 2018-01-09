
library IEEE;
use IEEE.STD_LOGIC_1164.ALL;
--put 3bits mot into un mot de 24bits mot
entity RGB2hexa is
Port ( 
			  R: in  STD_LOGIC_VECTOR (7 downto 0);
           G : in  STD_LOGIC_VECTOR (7 downto 0);
           B : in  STD_LOGIC_VECTOR (7 downto 0);
           hexa : out  STD_LOGIC_VECTOR (23 downto 0)
);
end RGB2hexa;

architecture Behavioral of RGB2hexa is

begin

	hexa <= R&G&B;

end Behavioral;

