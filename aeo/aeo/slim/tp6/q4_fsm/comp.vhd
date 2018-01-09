library IEEE;
use IEEE.STD_LOGIC_1164.ALL;
use ieee.std_logic_unsigned.all;
use IEEE.NUMERIC_STD.ALL;
use ieee.std_logic_arith.all;

entity comp is
port(
clk:in std_logic;
send:in std_logic_vector(1 downto 0);
data_out:out std_logic_vector(15 downto 0);
led_sortie:out std_logic_vector(1 downto 0)
);
end comp;

architecture Behavioral of comp is

signal led1:std_logic_vector(1 downto 0):="00";
signal led2:std_logic_vector(1 downto 0):="00";
signal led: std_logic_vector(1 downto 0):="00";
signal cpt_3:integer:=0;

shared variable compt:integer:=0;
shared variable a:integer:=0;
shared variable b:integer:=0;
shared variable c:integer:=0;
shared variable d:integer:=0;
shared variable stop:integer:=0;

begin


process(clk)
variable data:std_logic_vector(15 downto 0):=(others=>'0');


begin
	if clk'event and clk='1' then 
	if stop=0 then
	 if (send="01" xor send="10")then
		if d=9 then
				d:=0;
            if c=5 then
					c:=0;
					if b=9 then
						b:=0;
						if a=5 then
							a:=0;
						else
							a:=a+1;
						end if;
					else
						b:=b+1;
					end if;
            else
					c:=c+1;
            end if;
      else
				d:=d+1;
		end if;--end d=9
	 end if;--end send=01 or 10
	else
		a:=0;b:=0;c:=0;d:=0;
	end if;
 end if;	
		data_out<=conv_std_logic_vector(a, 4)&
		conv_std_logic_vector(b, 4)&
		conv_std_logic_vector(c, 4)&conv_std_logic_vector(d, 4);
		
end process;
	 
process(clk,send)
begin
	if clk'event and clk='1' then
	 if send ="01" then
		if compt=3 then -- 4s clock
		   led1<="01";
			led2<="00";
			stop:=1;
		else
			compt:=compt+1;
		end if;
	 elsif send="10" then
		if compt=5 then-- 6s clock
			led2<="10";
			led1<="00";
			stop:=1;
		else
			compt:=compt+1;
		end if;
	 elsif send="00" then
		compt:=0;
		led1<="00";
		led2<="00";
		stop:=0;
	 end if;
	end if;
	led<=led1;
end process;

led_sortie<=led1 or led2;
end Behavioral;