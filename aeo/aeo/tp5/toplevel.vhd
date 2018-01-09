library IEEE;
use IEEE.STD_LOGIC_1164.ALL;
--du btn<3> au btn<0>
--btn<4> pour reset
--Enable190 est pour le clk.
--On rajouter chenillard part
entity toplevel is
Port( 
btn : in  STD_LOGIC_VECTOR (4 downto 0);
sw : in  STD_LOGIC_VECTOR (7 downto 0);
clk : in  STD_LOGIC;
led : out  STD_LOGIC_VECTOR (7 downto 0)
);
end toplevel;

architecture Behavioral of toplevel is

signal button0 : STD_LOGIC;
signal button1 : STD_LOGIC;
signal button2 : STD_LOGIC;
signal button3 : STD_LOGIC;
signal reset_button4 : STD_LOGIC;
signal chenillard: STD_LOGIC_VECTOR(7 DOWNTO 0);
signal e : STD_LOGIC;

component Enable190
Port( 
clk : in  STD_LOGIC;
reset : in  STD_LOGIC;
E190, clk190 : out  STD_LOGIC
);
end component;

component btn_pulse
Port( 
inp : in  STD_LOGIC;
outp : out  STD_LOGIC;
e : in  STD_LOGIC;
clk : in  STD_LOGIC
);
end component;

component moore
Port( 
button : in  STD_LOGIC_VECTOR(3 downto 0);
reset : in  STD_LOGIC;
clk : in STD_LOGIC;
switches : in STD_LOGIC_VECTOR(7 downto 0);
chenillard: in STD_LOGIC_VECTOR(7 downto 0);
led : out  STD_LOGIC_VECTOR (7 downto 0)
);
end component;


component tp4 
    Port ( clk_entree : in  STD_LOGIC;
           led_sortie : out  STD_LOGIC_VECTOR(7 downto 0));
end component;


begin

UE: Enable190 
port map(
clk => clk,
reset => reset_button4,
E190 => e,
clk190 => open
);
	
FSM: moore 
port map(
button => button3 & button2 & button1 & button0,
reset => reset_button4,
clk => clk,
switches=> sw,
chenillard=>chenillard,
led => led
);

	
U_CE: btn_pulse 
port map(
inp => btn(4),
outp => reset_button4,
e => E,
clk => clk
);
	
U0: btn_pulse 
port map(
inp => btn(0),
outp => button0,
e => E,
clk => clk
);
	
U1: btn_pulse 
port map(
inp => btn(1),
outp => button1,
e => E,
clk => clk
);

U2: btn_pulse 
port map(
inp => btn(2),
outp => button2,
e => E,
clk => clk
);
	
U3: btn_pulse 
port map(
inp => btn(3),
outp => button3,
e => E,
clk => clk
);

U4: tp4
port map(
clk_entree => clk,
led_sortie => chenillard
);

end Behavioral;