library IEEE;
use IEEE.STD_LOGIC_1164.ALL;
use IEEE.STD_LOGIC_UNSIGNED.ALL; 

entity IP_FLITER is
    GENERIC (Mycode     : std_logic_vector(10 downto 0):= "10000011110" );
    Port (  Tin         : in  STD_LOGIC_VECTOR (31 downto 0);
            IPcode      : in  STD_LOGIC_vector (10 downto 0);
				clk         : in  STD_LOGIC;
				reset       : in  STD_LOGIC;
				IPdone		: out STD_LOGIC;
				Tout        : out STD_LOGIC_VECTOR (31 downto 0)
);
attribute clock_signal : string;
attribute clock_signal of clk : signal is "yes";
end IP_FLITER;

architecture Behavioral of IP_FLITER is
    type state_type is (idle,init,state1,state2,state3,state4); 
    signal state, next_state : state_type; 
    signal IPdone_i : std_logic; 
	 signal Tout_i:std_logic_vector(7 downto 0);
begin
NEXT_STATE_DECODE: process (state, IPcode)
   begin
      next_state <= state;  
      case (state) is
         when idle =>
            if IPcode = Mycode then
               next_state <= init;
				end if;
         when init =>
               next_state <= state1 ;
			when state1=>
					next_state <= state2;
			when state2=>
					next_state <= state3;
			when state3=>
					next_state <=state4;
         when state4 =>
            next_state <= idle;
         when others =>
            next_state <= idle;
      end case;      
   end process;
	
OUTPUT_DECODE: process (state)
   begin
      IPdone_i <= '0';
      case state is
	when idle=>
		Tout_i<=(others=>'0');
	when init=>
		Tout_i<=Tin(7 downto 0);
	when state1=>
		Tout_i<=Tin(15 downto 8);
	when state2=>
		Tout_i<=Tin(23 downto 16);
	when state3=>
		Tout_i<= Tin(31 downto 24);
	when state4 =>
	   
      IPdone_i<= '1';
        when others => 
      end case;
   end process;
	
SYNC_PROC: process (clk, reset,Tout_i)
   begin
      if (clk'event and clk = '1') then
         if (reset = '1') then
            state <= idle;
            IPdone  <= '0';
				Tout <= (others=> 'Z');
         else
            state <= next_state;
            IPdone <= IPdone_i;
				
				if IPdone_i = '1' then
					Tout <= x"00000000";
				else
					Tout <= x"000000"&Tout_i;
				end if ;
			end if;        
      end if;
   end process;

end Behavioral;