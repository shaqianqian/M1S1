library IEEE;
use IEEE.STD_LOGIC_1164.ALL;

entity SSE_2ADD16 is
    Port ( V1 : in  STD_LOGIC_VECTOR (31 downto 0);
           V2 : in  STD_LOGIC_VECTOR (31 downto 0);
           VR : out  STD_LOGIC_VECTOR (31 downto 0));
end SSE_2ADD16;

architecture Behavioral of SSE_2ADD16 is
component add16
port( 
	A  : in std_logic_vector(15 downto 0);
   B  : in std_logic_vector(15 downto 0);
   cin: in std_logic;
   s : out std_logic_vector(15 downto 0);
   cout: out std_logic);
end component;

signal result1:std_logic_vector(15 downto 0);
signal cout1:std_logic;

signal result2:std_logic_vector(15 downto 0);
signal cout2:std_logic;

begin
U1:add16
	port map(
			A=>V1(15 DOWNTO 0),
			B=>V2(15 DOWNTO 0),
			cin=>'0',
			s=>result1,
			cout=>cout1
);
U2:add16
	port map(
			A=>V1(31 DOWNTO 16),
			B=>V2(31 DOWNTO 16),
			cin=>cout1,
			s=>result2,
			cout=>cout2
);

VR<=result2&result1;
end Behavioral;

