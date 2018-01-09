library IEEE;
use IEEE.STD_LOGIC_1164.ALL;

entity IP_SSE_ADD is
GENERIC (Mycode : std_logic_vector(10 downto 0) :="00000010010"); 
	port (
		Tin:  in std_logic_vector (31 downto 0) :=(others =>'Z');
		Nin:  in std_logic_vector (31 downto 0) :=(others =>'Z');
		IPcode : in std_logic_vector (10 downto 0);
		Tout : out std_logic_vector (31 downto 0):=(others =>'Z')
	); 
end IP_SSE_ADD;

architecture Behavioral of IP_SSE_ADD is
COMPONENT SSE_ADD
	PORT(
		V3 : IN std_logic_vector(31 downto 0);
		V4: IN std_logic_vector(31 downto 0);
		btn: in std_logic_vector(1 downto 0);
		VRK : OUT std_logic_vector(31 downto 0)
		);
	END COMPONENT;
	
	signal VR_result: std_logic_vector(31 downto 0);
	signal mode:std_logic_vector(1 downto 0);
begin
	Inst_SSE_ADD: SSE_ADD PORT MAP(
		V3 => Tin,
		V4 => Nin,
		btn=> ipcode(1 downto 0),
		VRK => VR_result
	);
	mode<=ipcode(1 downto 0);
	Tout <= VR_result when ipcode(10 downto 0)= Mycode else (others =>'Z');

end Behavioral;
