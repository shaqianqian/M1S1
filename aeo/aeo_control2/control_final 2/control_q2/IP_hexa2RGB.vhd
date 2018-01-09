library IEEE;
use IEEE.STD_LOGIC_1164.ALL;

entity IP_hexa2RGB is
GENERIC (Mycode : std_logic_vector(10 downto 0) := "00000011000"); 
	port (
		Tin:  in std_logic_vector (31 downto 0) :=(others =>'Z');
		IPcode : in std_logic_vector (10 downto 0);
		Tout : out std_logic_vector (31 downto 0):=(others =>'Z');
		Nout:  out std_logic_vector (31 downto 0) :=(others =>'Z');
		N2out:  out std_logic_vector (31 downto 0) :=(others =>'Z')
	); 
end IP_hexa2RGB;
--READ un mot de 32bits from the pile 
--and cast it into 24bits
--then put back 3 mots, chaque mot 8bits 
architecture Behavioral of IP_hexa2RGB is

COMPONENT hexa2RGB
	PORT(
		hexa : IN std_logic_vector(23 downto 0);          
		R : OUT std_logic_vector(7 downto 0);
		G : OUT std_logic_vector(7 downto 0);
		B : OUT std_logic_vector(7 downto 0)
		);
	END COMPONENT;

	signal Red,Green,Blue : std_logic_vector(7 downto 0);

begin

	Inst_hexa2RGB: hexa2RGB PORT MAP(
		hexa => Tin(23 downto 0),
		R=> Red,
		G => Green,
		B => Blue
	);
	
	Tout <= x"000000" & BLUE when ipcode(10 downto 0)= Mycode else (others =>'Z');
	Nout <= x"000000" & Green when ipcode(10 downto 0)= Mycode else (others =>'Z');
	N2out<= x"000000" & RED when ipcode(10 downto 0)= Mycode else (others =>'Z');
end Behavioral;

