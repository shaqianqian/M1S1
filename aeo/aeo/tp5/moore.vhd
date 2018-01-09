library IEEE;
use IEEE.STD_LOGIC_1164.ALL;
use IEEE.STD_LOGIC_unsigned.ALL;

--moore is a state machine which is used to read the state and eat it
--if the state can be eaten, the code is recgnise;
--compare the order of button pressed with the switches by 2
entity moore is
	port (
			button : in std_logic_vector(3 downto 0);
			switches : in std_logic_vector(7 downto 0);
			reset : in std_logic;		
			clk : in std_logic;
			--on rajoute chenillard dans moore
			chenillard:in std_logic_vector(7 downto 0);
			led : out std_logic_vector(7 downto 0)
);
end moore;

architecture Behavioral of moore is
--we need 5 state, state0 is state initial
--state4 is state fini
--read and eat a pair of switches, roll to the next state
--when it turns to state4, the order of button pressed is correct
  type state_type is (state0,state1,state2,state3,state4);  
  signal state, next_state: state_type ;  
  signal output: std_logic_vector(7 downto 0) := "00000000";

begin
--process1 is used to control the clk
 SYNC_PROC: process (clk) 
 variable count : std_logic_vector(27 downto 0) := (others => '0');
  begin  
      if (clk'event and clk = '1') then
         if (reset = '1') then
            state <= state0;
         else
				state <= next_state;
			end if;
--if the code is read to state4,
--it will stop at state4 until press reset  
			if state= state4 then
			   --all part will s'eteindre par lui même
				
				if (reset = '1') then
            state <= state0;
				end if;
				--else
				--state <= state4;
				if count = X"BEBC200" then
					count:= (others => '0');
					state <= state0;
				else
					count:= count + 1;
				end if;
				
			end if;
--use output tester the affichage of the diffirent state
			led <= output;
      end if;	 
  end process; 
 
--process2 is to control the affichage and tester
--si on utilise seulement 2 led, on ne peut affichier chaque etat diffirent
--donc on utilise 8 led pour tester
--if the order of the pression of button all go with the set by switch
--all the led will allume.

OUTPUT_DECODE: process (state)  
  begin   
		    if state=state0 then 
				output<= "00000000" ;
          elsif state=state1 then 
				output<= "00000001" ;
          elsif state=state2 then 
				output<= "00000011" ;
          elsif state=state3 then 
				output<= "00000111" ;
          elsif state=state4  then 
				output<= chenillard ;
      end if; 
end process;

--process3 is to control the next_state, if there is the error, change to state initial 
NEXT_STATE_DECODE: process (state, button, reset,switches)  
variable switch_signal : std_logic_vector(1 downto 0) := "00";
variable btn_signal : std_logic_vector(1 downto 0) := "00";

  begin  
		next_state <= state;
	if button = "0000" then
		next_state <= state;
	elsif reset='1' then
		next_state <= state0;
	else
	  case button is
			when "0001" =>
				btn_signal := "00";--btn<0>
				
			when "0010" =>
				btn_signal := "01";--btn<1>

			when "0100" =>
				btn_signal := "10";--btn<2>
		
			when "1000" =>
				btn_signal := "11";--btn<3>
	
			when others =>
				btn_signal := "00";
		
		end case;
		case state is
--if the right sw<1> sw<0> == the value of the but which is first pressed
--the state change from state0 to state1, and led<0> allumé		
				when state0 =>  switch_signal := switches(1) & switches(0);
								if switch_signal = btn_signal then  
									next_state <= state1;  
								end if;   
--if the right sw<3> sw<2> == the value of the but which is second pressed
--the state change from state1 to state2, and led <1><0> allumé	
				when state1 =>  switch_signal := switches(3) & switches(2);
				          if switch_signal = btn_signal then  
									next_state <= state2;
								else					
									next_state <= state0;
								end if; 
--if the right sw<5> sw<4> == the value of the but which is third pressed
--the state change from state2 to state3, and led <2><1><0> allumé
				when state2 =>  switch_signal := switches(5) & switches(4);
				          if switch_signal = btn_signal then  
									next_state <= state3;
								else					
									next_state <= state0;
								end if;
--if the right sw<7> sw<6> == the value of the but which is fourth pressed
--the state change from state3 to state4 which is etat fini , and all led allumé
				when state3 =>  switch_signal := switches(7) & switches(6);
				          if switch_signal = btn_signal then  
									next_state <= state4;
								else					
									next_state <= state0;
								end if; 
				when state4 => next_state <= state0;  

    end case; 
	end if;
end process; 
end Behavioral;