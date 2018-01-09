library ieee;
use ieee.std_logic_1164.all;
use ieee.std_logic_unsigned.all;
entity add16 is
port(
A,B:in std_logic_vector(15 downto 0);
cin: in std_logic;
s:out std_logic_vector(15 downto 0);
cout:out std_logic
);
end add16;
architecture behav of add16 is
signal sint,aa,bb:std_logic_vector(16 downto 0);
begin
aa<='0'&A;
bb<='0'&B;
sint<=aa+bb+cin;
s<=sint(15 downto 0);
cout<=sint(16);
end behav;