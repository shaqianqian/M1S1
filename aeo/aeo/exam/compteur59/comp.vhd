library IEEE;
use IEEE.STD_LOGIC_1164.ALL;
use ieee.std_logic_unsigned.all;
use IEEE.NUMERIC_STD.ALL;
use ieee.std_logic_arith.all;

entity comp is
port(
clk:in std_logic;
data_out:out std_logic_vector(15 downto 0)
);
end comp;

architecture Behavioral of comp is

begin
process(clk)
variable data:std_logic_vector(15 downto 0):=(others=>'0');
variable a:integer:=0;
variable b:integer:=0;
variable c:integer:=0;
variable d:integer:=0;
begin
 if clk'event and clk='1' then
		if d<9 then
		d:=d+1;
		end if;
 end if;	
		data_out<=conv_std_logic_vector(a, 4)&
		conv_std_logic_vector(b, 4)&
		conv_std_logic_vector(c, 4)&conv_std_logic_vector(d, 4);
		
end process;
end Behavioral;

