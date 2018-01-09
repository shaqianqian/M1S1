library IEEE;
use IEEE.STD_LOGIC_1164.ALL;
use IEEE.STD_LOGIC_unsigned.ALL;
USE ieee.numeric_std.ALL; 

entity afficheur16bits is
    Port ( 
	   switch : in STD_LOGIC_VECTOR (2 downto 0);
	   led_sortie: out std_logic_vector(1 downto 0);
	   sevenseg_sortie : out  STD_LOGIC_VECTOR (6 downto 0);
           reset : in STD_LOGIC;
           clock : in  STD_LOGIC;
           anodes_sortie : out  STD_LOGIC_VECTOR (3 downto 0)
			  );
end afficheur16bits;

architecture Behavioral of afficheur16bits is

	signal E190_sig : STD_LOGIC;
	signal sw_sig : STD_LOGIC_VECTOR (3 downto 0);
	signal data_sig : STD_LOGIC_VECTOR (15 downto 0):=(others=>'0');
	signal clk_1s_sig:STD_LOGIC;
	--vien de chenillard
   signal sig_led:std_logic_vector(1 downto 0);
	signal sig_data:std_logic_vector(15 downto 0);
	signal send_sig:std_logic_vector(1 downto 0);
	component clkdiv is
	    Port ( clk : in  STD_LOGIC;
				  rst : in  STD_LOGIC;
              E190, clk190 : out  STD_LOGIC
				  );
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
   component calc is
			port(
			clk:in std_logic;
			clk_1s: out std_logic
			);
	end component;
	component cpt_fsm is
	port(
	switch:in std_logic_vector(2 downto 0);
	clk:in std_logic;
	send:out std_logic_vector(1 downto 0);
	chenillard_data:inout std_logic_vector(15 downto 0);
	chenillard_led:inout std_logic_vector(1 downto 0);
	data_out:out std_logic_vector(15 downto 0);
	led_sortie:out std_logic_vector(1 downto 0)
	);
	end component;
	
	component comp is
	port(
		clk:in std_logic;
		send:in std_logic_vector(1 downto 0);
		data_out:out std_logic_vector(15 downto 0);
		led_sortie:out std_logic_vector(1 downto 0)
	);
	end component;
	
begin
	clock_div : clkdiv Port Map (
	clk=>clock,
	rst => reset, 
	E190 => E190_sig, 
	clk190 => open	);
	
	-- On concatène le résultat de switch à son miroir
	final_state_machine: fsm Port Map (
	data => data_sig, 
	clk => E190_sig, 
	anodes => anodes_sortie, 
	sw => sw_sig);
	
	sevenseg : x7seg Port Map (
	sw => sw_sig, 
	sevenseg => sevenseg_sortie);
	
	calculate: calc port map(
	clk=>clock,
	clk_1s=>clk_1s_sig
	);
	
	compt_fsm:cpt_fsm port map(
	switch=>switch,
	send=>send_sig,
	clk=>E190_sig,
	data_out=>data_sig,
	led_sortie=>led_sortie,
	chenillard_data=>sig_data,
	chenillard_led=>sig_led
	);
	compteur:comp port map(
		clk=>clk_1s_sig,
		send=>send_sig,
		data_out=>sig_data,
		led_sortie=>sig_led
	);
end Behavioral;