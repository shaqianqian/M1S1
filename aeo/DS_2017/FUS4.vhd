library IEEE;
use IEEE.STD_LOGIC_1164.ALL;

entity FUS4 is
    Port ( X1 : in  STD_LOGIC_VECTOR (8 downto 0);
           X2 : in  STD_LOGIC_VECTOR (8 downto 0);
           X3 : in  STD_LOGIC_VECTOR (8 downto 0);
           X4 : in  STD_LOGIC_VECTOR (8 downto 0);
           Y1 : in  STD_LOGIC_VECTOR (8 downto 0);
           Y2 : in  STD_LOGIC_VECTOR (8 downto 0);
           Y3 : in  STD_LOGIC_VECTOR (8 downto 0);
           Y4 : in  STD_LOGIC_VECTOR (8 downto 0);
           Z1 : out  STD_LOGIC_VECTOR (8 downto 0);
           Z2 : out  STD_LOGIC_VECTOR (8 downto 0);
           Z3 : out  STD_LOGIC_VECTOR (8 downto 0);
           Z4 : out  STD_LOGIC_VECTOR (8 downto 0);
           Z5 : out  STD_LOGIC_VECTOR (8 downto 0);
           Z6 : out  STD_LOGIC_VECTOR (8 downto 0);
           Z7 : out  STD_LOGIC_VECTOR (8 downto 0);
           Z8 : out  STD_LOGIC_VECTOR (8 downto 0);
				clk: in std_logic
			  );
end FUS4;

architecture Behavioral of FUS4 is

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
		
		if X3>Y3 then
				Z5<=Y3;
				Z6<=X3;
		else
				Z5<=X3;
				Z6<=Y3;
		end if;
		
		if X4>Y4 then
				Z7<=Y4;
				Z8<=X4;
		else
				Z7<=X4;
				Z8<=Y4;
		end if;

	end if;
end process;

end Behavioral;

