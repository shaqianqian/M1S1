library IEEE;
use IEEE.STD_LOGIC_1164.ALL;

entity IP_RGB2hexa is
GENERIC (Mycode : std_logic_vector(10 downto 0) := "00000011100"); 
	port (
		Tin:  in std_logic_vector (31 downto 0) :=(others =>'Z');
		Nin:  in std_logic_vector (31 downto 0) :=(others =>'Z');
		N2in:  in std_logic_vector (31 downto 0) :=(others =>'Z');
		IPcode : in std_logic_vector (10 downto 0);
		Tout : out std_logic_vector (31 downto 0):=(others =>'Z')
	); 
end IP_RGB2hexa;

architecture Behavioral of IP_RGB2hexa is
COMPONENT RGB2hexa
	PORT(
		R : IN std_logic_vector(7 downto 0);
		G : IN std_logic_vector(7 downto 0);
		B : IN std_logic_vector(7 downto 0);          
		hexa : OUT std_logic_vector(23 downto 0)
		);
	END COMPONENT;
	
	signal hexa_result: std_logic_vector(31 downto 0);

begin
	Inst_RGB2hexa: RGB2hexa PORT MAP(
		R => Tin(7 downto 0),
		G => Nin(7 downto 0),
		B => N2in(7 downto 0),
		hexa => hexa_result(23 downto 0)
	);

	Tout <= hexa_result when ipcode(10 downto 0)= Mycode else (others =>'Z');

end Behavioral;

