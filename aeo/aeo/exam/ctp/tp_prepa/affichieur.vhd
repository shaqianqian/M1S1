library IEEE;
use IEEE.STD_LOGIC_1164.ALL;

-- Uncomment the following library declaration if using
-- arithmetic functions with Signed or Unsigned values
--use IEEE.NUMERIC_STD.ALL;

-- Uncomment the following library declaration if instantiating
-- any Xilinx primitives in this code.
--library UNISIM;
--use UNISIM.VComponents.all;

entity afficheur16bits is
    Port ( switch : in STD_LOGIC_VECTOR (7 downto 0);
			  sevenseg_sortie : out  STD_LOGIC_VECTOR (6 downto 0);
           reset : in STD_LOGIC;
           clock : in  STD_LOGIC;
           anodes_sortie : out  STD_LOGIC_VECTOR (3 downto 0));
end afficheur16bits;

architecture Behavioral of afficheur16bits is

	signal E190_sig : STD_LOGIC;
	signal sw_sig : STD_LOGIC_VECTOR (3 downto 0);
	signal data_sig : STD_LOGIC_VECTOR (15 downto 0);

   component clkdiv is
    Port ( clk : in  STD_LOGIC;
           rst : in  STD_LOGIC;
           E190, clk190 : out  STD_LOGIC);
	end component;
	
	component fsm is
    Port ( data : in  STD_LOGIC_VECTOR (15 downto 0);
           clk : in  STD_LOGIC;
			  anodes : out STD_LOGIC_VECTOR (3 downto 0);
			  sw : out STD_LOGIC_VECTOR (3 downto 0) );
	end component;
	
	component x7seg is
   Port ( sw : in  STD_LOGIC_VECTOR (3 downto 0);
		    sevenseg : out  STD_LOGIC_VECTOR (6 downto 0));
	end component;

begin

	clockdiv : clkdiv Port Map (clk => clock, rst => reset, E190 => E190_sig, clk190 => open);
	
	-- On concatène le résultat de switch à son miroir
	data_sig <= switch(3 downto 0) & switch(7 downto 4) & switch;
	
	finite_state_machine : fsm Port Map (data => data_sig, clk => E190_sig, anodes => anodes_sortie, sw => sw_sig);
	
	sept_segments : x7seg Port Map (sw => sw_sig, sevenseg => sevenseg_sortie);

end Behavioral;
