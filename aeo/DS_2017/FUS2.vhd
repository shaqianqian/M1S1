library IEEE;
use IEEE.STD_LOGIC_1164.ALL;

entity FUS2 is
    Port ( X1 : in  STD_LOGIC_VECTOR (7 downto 0);
           X2 : in  STD_LOGIC_VECTOR (7 downto 0);
           Y1 : in  STD_LOGIC_VECTOR (7 downto 0);
           Y2 : in  STD_LOGIC_VECTOR (7 downto 0);
           Z1 : out  STD_LOGIC_VECTOR (7 downto 0);
           Z2 : out  STD_LOGIC_VECTOR (7 downto 0);
           Z3 : out  STD_LOGIC_VECTOR (7 downto 0);
           Z4 : out  STD_LOGIC_VECTOR (7 downto 0);
			  clk: in std_logic
			  );
end FUS2;

architecture Behavioral of FUS2 is

begin
process(clk)
begin
	if clk'event and clk='1' then
		if X1>Y1 THEN
			Z1<=Y1;
			Z2<=X1;
		else
			Z1<=X1;
			Z2<=Y1;
		end if;
		
		if X2>Y2 then
				Z3<=Y2;
				Z4<=X2;
		else
				Z3<=X2;
				Z4<=Y2;
		end if;
	end if;
end process;
end Behavioral;

