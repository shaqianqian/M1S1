library IEEE;
use IEEE.STD_LOGIC_1164.ALL;

entity fsm is
    Port ( data : in  STD_LOGIC_VECTOR (15 downto 0);
           clk : in  STD_LOGIC;
			  anodes : out STD_LOGIC_VECTOR (3 downto 0);
			  sw : out STD_LOGIC_VECTOR (3 downto 0) );
end fsm;

architecture Behavioral of fsm is

   type state_type is (st1_digit1, st2_digit2, st3_digit3, st4_digit4); 
   signal state, next_state : state_type;

begin

	SYNC_PROC: process (clk)
   begin
      if (clk'event and clk = '1') then
			state <= next_state;     
      end if;
   end process;
 
   --MOORE State-Machine - Outputs based on state only
   OUTPUT_DECODE: process (state)
   begin
      case (state) is
         when st1_digit1 =>
				anodes <= "1110";
				sw <= data(3 downto 0);
			when st2_digit2 =>
				anodes <= "1101";
				sw <= data(7 downto 4);
			when st3_digit3 =>
				anodes <= "1011";
				sw <= data(11 downto 8);
			when st4_digit4 =>
				anodes <= "0111";
				sw <= data(15 downto 12);
		end case;
   end process;
 
   NEXT_STATE_DECODE: process (state)
   begin
      --declare default state for next_state to avoid latches
      next_state <= state;  --default is to stay in current state
      case (state) is
         when st1_digit1 =>
              next_state <= st2_digit2;
         when st2_digit2 =>
			  next_state <= st3_digit3;
         when st3_digit3 =>
              next_state <= st4_digit4;
         when st4_digit4 =>
			  next_state <= st1_digit1;
      end case;      
   end process;

end Behavioral;