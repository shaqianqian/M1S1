library IEEE;
use IEEE.STD_LOGIC_1164.ALL;
use IEEE.STD_LOGIC_UNSIGNED.ALL; 

entity IP_FLITER is
    GENERIC (Mycode     : std_logic_vector(10 downto 0):= "10000011110" );
    Port (  Tin         : in  STD_LOGIC_VECTOR (31 downto 0);
            IPcode      : in  STD_LOGIC_vector (10 downto 0);
				clk         : in  STD_LOGIC;
				reset       : in  STD_LOGIC;
				IPdone		: out STD_LOGIC;
				Tout        : out STD_LOGIC_VECTOR (31 downto 0)
);

end IP_FLITER;
