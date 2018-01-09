library IEEE;
use IEEE.STD_LOGIC_1164.ALL;
use IEEE.STD_LOGIC_unsigned.ALL;
USE ieee.numeric_std.ALL; 

entity cpt is
    Port ( 
			  clk:in std_logic;
           data_out : out  STD_LOGIC_VECTOR (15 downto 0)
);
end cpt;


architecture Behavioral of cpt is

signal data :std_logic_vector(15 downto 0):=(others=>'0');
begin
  process1:process (clk)  
  variable cpt : std_logic_vector(27 downto 0) := (others => '0');
  variable increase:	std_logic:='0';
  
  begin  
      if (clk'Event and clk = '1') then
				if cpt = X"5f5e100" then -- 5f5e100 pour 1 second
					cpt := (others => '0');
					increase:='1';
				else
					cpt := cpt + 1;
				end if;
		end if;
		data_out<= data;	 
  end process process1; 
  
  process2:process()
  variable a:std_logic_vector(3 downto 0);
  variable b:std_logic_vector(3 downto 0);
  variable c:std_logic_vector(3 downto 0);
  variable c:std_logic_vector(3 downto 0);  
  begin
  
  end process process2;
  
end Behavioral; 

--if b=9 then
--          b<="0000";
--          if a=5 then
--             a<="0000";
--            else
--             a<=a+'1';
--            end if;
--        else
--         b<=b+'1';
--        end if;
  --  end if;
    --end process;
    --carry_out<='1' when (a=5 and b=9) else
      --            '0';
 --   cnt_hi<=a;
   -- cnt_lo<=b;
--end a;