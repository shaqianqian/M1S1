
library IEEE;
use IEEE.STD_LOGIC_1164.ALL; 
use ieee.std_logic_arith.all;
entity count1 is
    Port ( sw : in  STD_LOGIC_VECTOR (7 downto 0);
           RESULT : out  STD_LOGIC_VECTOR (3 downto 0)
);
end count1;

architecture Behavioral of count1 is

begin

	PROCESS(sw)
	VARIABLE nombre_1 : INTEGER;
	BEGIN
			nombre_1 := 0;
			FOR bt IN 0 TO 7 LOOP
				if sw(bt) = '1' then nombre_1:= nombre_1 + 1; 
				end if;
			END LOOP;
			RESULT <= conv_std_logic_vector(nombre_1, 4);
	END PROCESS; 


end Behavioral;

