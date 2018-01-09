library ieee ;
use ieee.std_logic_1164.all;


entity IP_FLITER is  
	GENERIC (Mycode     : std_logic_vector(10 downto 0):= "10000011110" );
port(                              
	IPcode:		in STD_LOGIC_VECTOR(10 downto 0);                
	clk:		in std_logic;
	reset:		in std_logic;
	IPdone:		out std_logic
); 
	attribute clock_signal : string;
	attribute clock_signal of clk : signal is "yes";        
end IP_FLITER;

-----------------------------------------------------
architecture FSM of IP_FLITER is                                                                                                    

 signal compt_result:std_logic; 
 signal xixi_haha:std_logic_vector(7 downto 0):=(others=>'0');
  COMPONENT acompt_1s
     PORT( clk : IN STD_LOGIC; 
          clk_1hz : INOUT STD_LOGIC
			);
   END COMPONENT;


    type state_type is (idle, starting, finish);
    signal next_state, state: state_type;
                                       
begin    
   clk_1s: acompt_1s PORT MAP(
			clk => clk, 
			clk_1hz=> compt_result
   );

SYNCHRO: process(clk, reset)
    begin
if (clk'event and clk='1') then
  if (reset='1') then
       state <= idle;
  else
		state <= next_state;
   end if;
 end if;

end process;        

Next_output: process(state)
begin
case state is
     when finish => 
			IPDone  <= '1';  
     when others =>
			IPDone <= '0';
			--If there si multiple driver error, use 'z' not '0'
end case;

end process;


next_node : process (IPcode, compt_result)
begin
case state is
     when idle => 
			if Ipcode =  Mycode then
				 next_state <= starting;
			else             
				 next_state <= idle;
			end if;
     when starting =>
         if  compt_result='1'
			then
				 next_state <= finish;  
			else 
				 next_state <= starting; 
        end if; 
     when finish => 
			next_state <= idle;
     when others =>  
			next_state <= idle;
end case;

end process;

end FSM;

