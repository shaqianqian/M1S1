library IEEE;
use IEEE.STD_LOGIC_1164.ALL;
use IEEE.std_logic_unsigned.all;
use IEEE.std_logic_arith.all;

entity IP_mul16 is
	GENERIC (Mycode : std_logic_vector(10 downto 0):="00000000000" );
    Port ( 
				Tin : in  STD_LOGIC_VECTOR (31 downto 0);
           Nin : in  STD_LOGIC_VECTOR (31 downto 0);
           IPcode : in  STD_LOGIC_vector(10 downto 0) ;
           Tout : out  STD_LOGIC_VECTOR (31 downto 0));
end IP_mul16;

architecture Behavioral of IP_mul16 is
component multiply
	port (
	a: in std_logic_vector(15 downto 0);
	b: in std_logic_vector(15 downto 0);
	p: out std_logic_vector(31 downto 0));
end component;
signal mult : std_logic_vector (31 downto 0) ;

-- Synplicity black box declaration
attribute syn_black_box : boolean;
attribute syn_black_box of multiply: component is true;
begin
my_mul16 : multiply
		port map (
			a => Tin(15 downto 0),
			b => Nin (15 downto 0),
			p => mult);
Tout <= mult when Mycode = IPcode else (others =>'Z');

end Behavioral;