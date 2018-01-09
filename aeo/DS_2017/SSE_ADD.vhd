library IEEE;
use IEEE.STD_LOGIC_1164.ALL;
use ieee.std_logic_unsigned.all;
entity SSE_ADD is
    Port ( V3 : in  STD_LOGIC_VECTOR (31 downto 0);
           V4 : in  STD_LOGIC_VECTOR (31 downto 0);
			  btn: in std_logic_vector(1 downto 0);
           VRK : out  STD_LOGIC_VECTOR (31 downto 0));
end SSE_ADD;

architecture Behavioral of SSE_ADD is
component SSE_2ADD16
port( 
	V1  : in std_logic_vector(31 downto 0);
   V2: in std_logic_vector(31 downto 0);
   VR : out std_logic_vector(31 downto 0));
end component;
component SSE_4ADD8
port( 
	V1  : in std_logic_vector(31 downto 0);
   V2: in std_logic_vector(31 downto 0);
   VR : out std_logic_vector(31 downto 0));
end component;

signal result1:std_logic_vector(31 downto 0):=(others=>'0');
signal result2:std_logic_vector(31 downto 0):=(others=>'0');
signal result:std_logic_vector(31 downto 0):=(others=>'0');

begin
SSE_1:SSE_2ADD16
	port map(
			V1=>V3,
			V2=>V4,
			VR=>result1
);
SSE_2:SSE_4ADD8
	port map(
			V1=>V3,
			V2=>V4,
			VR=>result2
);
	
	With btn select 
			result<=result1 when "01",
					  result2 when "10",
					  V3+V4 when others;
	VRK<=result;
	
end Behavioral;

