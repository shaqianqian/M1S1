library IEEE;
use IEEE.STD_LOGIC_1164.ALL;
entity SSE_4ADD8 is
    Port ( V1 : in  STD_LOGIC_VECTOR (31 downto 0);
           V2 : in  STD_LOGIC_VECTOR (31 downto 0);
           VR : out  STD_LOGIC_VECTOR (31 downto 0));
end SSE_4ADD8;

architecture Behavioral of SSE_4ADD8 is
component add8
port( 
	A  : in std_logic_vector(7 downto 0);
   B  : in std_logic_vector(7 downto 0);
   cin: in std_logic;
   s : out std_logic_vector(7 downto 0);
   cout: out std_logic);
end component;

signal result1:std_logic_vector(7 downto 0);
signal cout1:std_logic;

signal result2:std_logic_vector(7 downto 0);
signal cout2:std_logic;

signal result3:std_logic_vector(7 downto 0);
signal cout3:std_logic;

signal result4:std_logic_vector(7 downto 0);
signal cout4:std_logic;

begin
U1:add8
	port map(
			A=>V1(7 DOWNTO 0),
			B=>V2(7 DOWNTO 0),
			cin=>'0',
			s=>result1,
			cout=>cout1
);
U2:add8
	port map(
			A=>V1(15 DOWNTO 8),
			B=>V2(15 DOWNTO 8),
			cin=>cout1,
			s=>result2,
			cout=>cout2
);
U3:add8
	port map(
			A=>V1(23 DOWNTO 16),
			B=>V2(23 DOWNTO 16),
			cin=>cout2,
			s=>result3,
			cout=>cout3
);
U4:add8
	port map(
			A=>V1(31 DOWNTO 24),
			B=>V2(31 DOWNTO 24),
			cin=>cout3,
			s=>result4,
			cout=>cout4
);
VR<=result4&result3&result2&result1;
end Behavioral;

