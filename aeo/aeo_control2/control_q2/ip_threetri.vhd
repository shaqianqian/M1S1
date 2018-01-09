library IEEE;
use IEEE.STD_LOGIC_1164.ALL;

entity iP_threetri is
GENERIC (Mycode : std_logic_vector(10 downto 0) := "00000011011"); --81a
	port (
		Tin:  in std_logic_vector (31 downto 0) :=(others =>'Z');
		Nin:  in std_logic_vector (31 downto 0) :=(others =>'Z');
		N2in:  in std_logic_vector (31 downto 0) :=(others =>'Z');
		IPcode : in std_logic_vector (10 downto 0);
		Tout : out std_logic_vector (31 downto 0):=(others =>'Z');
		Nout:  out std_logic_vector (31 downto 0) :=(others =>'Z');
		N2out:  out std_logic_vector (31 downto 0) :=(others =>'Z')
	); 
end iP_threetri;
--READ un mot de 32bits from the pile 
--and cast it into 24bits
--then put back 3 mots, chaque mot 8bits 
architecture Behavioral of IP_threetri is

COMPONENT swap
Port ( e1: in  STD_LOGIC_VECTOR (31 downto 0);
       e2: in  STD_LOGIC_VECTOR (31 downto 0);
		   e3: in  STD_LOGIC_VECTOR (31 downto 0);
       s1: out  STD_LOGIC_VECTOR (31 downto 0);
       s2: out  STD_LOGIC_VECTOR (31 downto 0);
		  s3: out  STD_LOGIC_VECTOR (31 downto 0)
           
);
END COMPONENT;

	signal s_1,s_2,s_3 : std_logic_vector(31 downto 0);

begin

	Inst_threetri: swap PORT MAP(
		e1 => Tin(31 downto 0),
		e2 => Nin(31 downto 0),
		e3=>  N2in(31 downto 0),
		S1 => S_1,
		S2=>S_2,
		S3 => S_3
	);
	
	Tout <= S_1 when Mycode = IPcode else (others =>'Z');
	Nout <=S_2 when Mycode = IPcode else (others =>'Z');
	N2out<= S_3 when Mycode = IPcode else (others =>'Z');
 
end Behavioral;
