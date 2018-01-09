library IEEE;
use IEEE.STD_LOGIC_1164.ALL;

entity IP_Rdm is  
GENERIC (Mycode : std_logic_vector(10 downto 0) := "00000010000"); 
port ( 
clk , reset : in std_logic; 
IPcode : in std_logic_vector (10 downto 0);
Tout : out std_logic_vector (31 downto 0);
Nout : out std_logic_vector(31 downto 0)
); 
end IP_Rdm;
architecture Behavioral of IP_Rdm is
component random
	generic(width:integer:=32);
	port (
	clk , reset : in std_logic;
	enable : in std_logic;
	random_num : out std_logic_vector (31 downto 0)   --output vector            
	);
end component;

signal enable : std_logic;
signal qbus:std_logic_vector(31 downto 0);
begin
myRandom: random 
generic map(width=>32)
PORT MAP(
		clk => clk,
		reset => reset,
		enable => enable,
		random_num => qbus
	);

enable <= '1' when IPcode(10 downto 0)= Mycode else '0';		
--
Tout <= x"00000" &qbus(11 downto 0) when IPcode(10 downto 0)= Mycode else (others =>'Z');
Nout <= x"00000" &qbus(23 downto 12) when IPcode(10 downto 0)= Mycode else (others =>'Z');

end Behavioral;
