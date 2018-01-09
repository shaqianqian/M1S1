library IEEE;
use IEEE.STD_LOGIC_1164.ALL;


entity parity is
    Port ( sw : in  STD_LOGIC_VECTOR (7 downto 0);
           RESULT : out  STD_LOGIC
);
end parity;

architecture Behavioral of parity is

begin
	PROCESS(sw)
	VARIABLE bit_parite: STD_LOGIC;
	BEGIN
			bit_parite:= '0';
			FOR bt IN 0 TO 7 LOOP
				bit_parite := bit_parite xor sw(bt);
			END LOOP;
			RESULT <= bit_parite;
	END PROCESS; 
end Behavioral;

