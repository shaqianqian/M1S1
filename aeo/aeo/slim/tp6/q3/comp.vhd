library IEEE;
use IEEE.STD_LOGIC_1164.ALL;
use ieee.std_logic_unsigned.all;
use IEEE.NUMERIC_STD.ALL;
use ieee.std_logic_arith.all;

entity comp is
port(
clk:in std_logic;
-----switch_reset:in std_logic;
data_out:out std_logic_vector(15 downto 0);
led_sortie:out std_logic_vector(1 downto 0);
start1:in std_logic;
start:in std_logic
);
end comp;

architecture Behavioral of comp is
signal stop:std_logic:='0';

shared variable compt:integer:=0;
shared variable data:std_logic_vector(15 downto 0):=(others=>'0');

begin
process(clk,start,start1)

variable c:integer:=0;
variable d:integer:=0;

begin
   
	if clk'event and clk='1'  then 
--10 modele	
		if start = '1' and start1 = '0'then
		 if stop='1' then
        
		    led_sortie(0)<='1';
		else ----stop=0
		    led_sortie(0)<='0';
		 if d=9 then
				d:=0;
            if c=5 then
					c:=0;
					
            else
					c:=c+1;
            end if;
          else
				d:=d+1;
		  end if;--end compt time
      
		  if d=3 then	
			 stop<='1';
		 end if;
		 
		end if;--end modele 10
     	
	   data:="00000000"&conv_std_logic_vector(c, 4)&conv_std_logic_vector(d, 4);
	   data_out<=data;
--modele 01
   elsif start = '0' and start1 = '1' then
		 if stop='1' then

		    led_sortie(1)<='1';
		
		 else ----stop=0
	
		    led_sortie(1)<='0';
			 if d=9 then
				 d:=0;
            if c=5 then
					c:=0;
            else
					c:=c+1;
            end if;
          else
				d:=d+1;
		    end if;--end compt time
      
		    if d=5 then
				stop<='1';
			 end if;
		end if;--end stop0
     	
	   data:="00000000"&conv_std_logic_vector(c, 4)&conv_std_logic_vector(d, 4);
	   data_out<=data;
	
	elsif start = '0' and start1 = '0' then 
	-----------------------liang ge start dou mei yong 
	    c:=0;
		 d:=0;
		 led_sortie(1)<='0';
		  led_sortie(0)<='0'; 
	   data:="00000000"&conv_std_logic_vector(c, 4)&conv_std_logic_vector(d, 4);
	   data_out<=data;
	   compt:=0;
		stop<='0';
	
	end if;
	
 end if;--end clk	
 
end process;

end Behavioral;