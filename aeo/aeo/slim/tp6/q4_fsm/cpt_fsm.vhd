library IEEE;
use IEEE.STD_LOGIC_1164.ALL;
use IEEE.STD_LOGIC_unsigned.ALL;
USE ieee.numeric_std.ALL; 


entity cpt_fsm is
	port (
	switch:in std_logic_vector(2 downto 0);
	clk:in std_logic;
	send: out std_logic_vector(1 downto 0);
	chenillard_data: inout std_logic_vector(15 downto 0);
	chenillard_led:inout std_logic_vector(1 downto 0);
	data_out:out std_logic_vector(15 downto 0);
	led_sortie:out std_logic_vector(1 downto 0)
	);
	end cpt_fsm;

architecture Behavioral of cpt_fsm is

  type state_type is (init,state1,state2);  
  signal state, next_state: state_type ;  
  signal correct:std_logic_vector(1 downto 0);
  signal led1:std_logic_vector(1 downto 0):="00";
  signal led2:std_logic_vector(1 downto 0):="00";
  signal data_output:std_logic_vector(15 downto 0):=X"0000";
  begin
  process1: process (clk,switch)  
  begin  
      if (clk'Event and clk = '1') then
         if switch(2)='1' then
            state <= init;
         elsif switch="001" or switch="010" then
				 state <= next_state;
			else
				 state<=init;
			end if;
			led_sortie<=correct;
      end if;	 
  end process process1; 
 
  process2 : process (state,switch)  
  begin  
	next_state <= state;
	if switch = "000" then
		next_state <= state;
	elsif switch(2)='1' then
		next_state <= init;
	else
		case state is  
				 when init => if switch="001" then  
									next_state <= state1;
								  elsif switch="010" then   
									next_state<=state2;
								  else					
									next_state <= init;
								  end if; 
				when state1 => next_state<=state1;
				when state2 => next_state <= state2;  
								
    end case; 
	end if;
end process process2; 
 
process3 : process (state)
variable cpt : integer:=0;
  begin  
      if state=init then
		  send<="00";	  
		  correct <="00";
		  data_out<=X"0000";
		elsif state=state1 then
		  send<="01";
		  correct <=chenillard_led;
		  data_out<=chenillard_data;
      elsif state=state2 then
		  send<="10";
		  correct<=chenillard_led;
		  data_out<=chenillard_data;
      end if;  
end process process3; 

end Behavioral;