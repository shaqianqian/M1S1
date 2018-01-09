library IEEE;
use IEEE.STD_LOGIC_1164.ALL;
use IEEE.STD_LOGIC_UNSIGNED.ALL; 

entity IP_fibo is
    GENERIC (Mycode     : std_logic_vector(10 downto 0):= "10000000011" );
    Port (  Tin         : in  STD_LOGIC_VECTOR (31 downto 0);
            IPcode      : in  STD_LOGIC_vector (10 downto 0);
				clk         : in  STD_LOGIC;
				reset       : in  STD_LOGIC;
				Tout        : out STD_LOGIC_VECTOR (31 downto 0);
            IPdone      : out STD_LOGIC
    );
attribute clock_signal : string;
attribute clock_signal of clk : signal is "yes";
end IP_fibo;

architecture Behavioral of IP_fibo is

    type state_type is (idle, init, state1,state2,state3,state4); 
    signal state, next_state : state_type; 
    signal start_print:std_logic;
begin

NEXT_STATE_DECODE: process (state, compt, IPcode)
   begin
      next_state <= state;  
      case (state) is
         when idle =>
            if IPcode = Mycode then
               next_state <= init;
				end if;
         when init =>
			     if start_print='1' then
					next_state<=state1;
				  end if;
			when state1=>
				if start_print='1' then
				next_state<=state2;
				end if;
			when state2=>
			   if start_print='1' then
				next_state<=state3;
			   end if;
			when state3=>
				if start_print='1' then
				next_state<=state4;
				end if;
         when state4 =>
				if start_print='1' then
					next_state <= idle;
				end if;
         when others =>
      end case;      
   end process;
	
OUTPUT_DECODE: process (state, fibobus)
   begin
      case state is
				when idle =>
					Tout<=(others=>'0');
				when init =>
					Tout<=(others=>'0');
				when state1 =>
					Tout<=Tin(7 downto 0);
				when state2 =>
					Tout<=Tin(15 downto 8);
				when state3 =>
					Tout<=Tin(23 downto 16);
				when state4 =>
					Tout<=Tin(31 downto 24);
				when others=>
   end case;
   end process;
	
SYNC_PROC: process (clk, reset)
   begin
      if (clk'event and clk = '1') then
				if compt_1s=X"5F5E100" then
						compt_1s:=(others=>'0');
						state <= next_state;
						state_print<='1';
					else
						state_print<='0';
						compt_1s:=compt_1s+1;
					end if;
      end if;
   end process;

end Behavioral;