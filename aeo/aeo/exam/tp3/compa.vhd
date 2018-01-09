
library IEEE;
use IEEE.STD_LOGIC_1164.ALL;

entity comp is
port(
A : in  STD_LOGIC_VECTOR (3 downto 0);
B : in  STD_LOGIC_VECTOR (3 downto 0);
RESULT : out  STD_LOGIC
);
end comp;

architecture Behavioral of comp is

begin
RESULT <= '1' when A=B
          else '0';

end Behavioral;

