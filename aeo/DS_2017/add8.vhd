library ieee;
use ieee.std_logic_1164.all;
use ieee.std_logic_unsigned.all;
entity add8 is
port(
A,B:in std_logic_vector(7 downto 0);
cin: in std_logic;
s:out std_logic_vector(7 downto 0);
cout:out std_logic
);
end add8;
architecture behav of add8 is
signal sint,aa,bb:std_logic_vector(8 downto 0);
begin
aa<='0'&A;
bb<='0'&B;
sint<=aa+bb+cin;
s<=sint(7 downto 0);
cout<=sint(8);
end behav;