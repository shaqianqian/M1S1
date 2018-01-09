library IEEE;
use IEEE.STD_LOGIC_1164.ALL;
use ieee.std_logic_unsigned.all;
use ieee.std_logic_arith.all;

entity IP_square2 is
	 Generic (Mycode: std_logic_vector(10 downto 0):="00000000001");
    Port ( Tin : in  STD_LOGIC_VECTOR (31 downto 0);
           Nin : in  STD_LOGIC_VECTOR (31 downto 0);
           IPcode : in  STD_LOGIC_VECTOR (10 downto 0);
           Tout : out  STD_LOGIC_VECTOR (31 downto 0));
end IP_square2;

architecture Behavioral of IP_square2 is
component multiply
port(
a:in std_logic_vector(15 downto 0);
b:in std_logic_vector(15 downto 0);
p:out std_logic_vector(31 downto 0)
);
end component;

signal mult1: std_logic_vector(31 downto 0);
signal mult2: std_logic_vector(31 downto 0);
signal somme: std_logic_vector(31 downto 0);

attribute syn_black_box:boolean;
attribute syn_black_box of multiply: component is true;
begin
my_mul16_1 : multiply
		port map (
			a => Tin(15 downto 0),
			b => Nin (15 downto 0),
			p => mult1);
my_mul16_2 : multiply
		port map (
			a => Tin(15 downto 0),
			b => Nin (15 downto 0),
			p => mult2);
somme<=mult1 + mult2;
Tout <= somme when Mycode = IPcode else (others =>'Z');
end Behavioral;
