
library IEEE;
use IEEE.STD_LOGIC_1164.ALL;
use IEEE.STD_LOGIC_UNSIGNED.ALL;

entity add4 is
    Port ( A : in  STD_LOGIC_VECTOR (3 downto 0);
           B : in  STD_LOGIC_VECTOR (3 downto 0);
           SUM : out  STD_LOGIC_VECTOR (4 downto 0));
end add4;

architecture Behavioral of add4 is

begin

SUM <=('0'& A) +('0'& B);

end Behavioral;

