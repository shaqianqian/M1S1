library IEEE;
use IEEE.STD_LOGIC_1164.ALL;

entity afficheur16bits is
    Port ( switch : in STD_LOGIC_VECTOR (7 downto 0);
			  sevenseg_sortie : out  STD_LOGIC_VECTOR (6 downto 0);
           clock : in  STD_LOGIC;
           anodes_sortie : out  STD_LOGIC_VECTOR (3 downto 0));
end afficheur16bits;

architecture Behavioral of afficheur16bits is

	signal E190_sig : STD_LOGIC;
	signal sw_sig : STD_LOGIC_VECTOR (3 downto 0);
	signal data_sig : STD_LOGIC_VECTOR (15 downto 0);

   component clk_div is
    Port ( clk : in  STD_LOGIC;
           clk_4hz: out  STD_LOGIC);
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

	E190: clk_div Port Map (clk => clock, clk_4hz => E190_sig);
	
	-- On concatène le résultat de switch à son miroir
	data_sig <= switch(4)&switch(5)&switch(6)&switch(7)&switch(3 downto 0)&switch(0)&switch(1)&switch(2)&switch(3)& switch(7 downto 4);
	
	U_fsm : fsm Port Map (data => data_sig, clk => E190_sig, anodes => anodes_sortie, sw => sw_sig);
	
	U_x7seg : x7seg Port Map (sw => sw_sig, sevenseg => sevenseg_sortie);

end Behavioral;