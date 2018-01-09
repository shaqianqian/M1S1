----------------------------------------------------------------------------------
-- Company: 
-- Engineer: 
-- 
-- Create Date:    16:59:22 09/12/2017 
-- Design Name: 
-- Module Name:    calc - Behavioral 
-- Project Name: 
-- Target Devices: 
-- Tool versions: 
-- Description: 
--
-- Dependencies: 
--
-- Revision: 
-- Revision 0.01 - File Created
-- Additional Comments: 
--
----------------------------------------------------------------------------------
library IEEE;
use IEEE.STD_LOGIC_1164.ALL;


entity calc is
    Port ( switches : in  STD_LOGIC_VECTOR (7 downto 0);
	        button: in STD_LOGIC_VECTOR(4 downto 0);
           led : out  STD_LOGIC_VECTOR (7 downto 0);
           sevenseg : out  STD_LOGIC_VECTOR (6 downto 0);
           anodes : out  STD_LOGIC_VECTOR (3 downto 0));
end calc;

architecture Behavioral of calc is

COMPONENT add4
	PORT(
		a : IN std_logic_vector(3 downto 0);
		b : IN std_logic_vector(3 downto 0);          
		sum : OUT std_logic_vector(4 downto 0)
		);
END COMPONENT;

COMPONENT x7seg
	PORT(
		sw : IN std_logic_vector(3 downto 0); 
		mode: in STD_LOGIC_VECTOR (1 downto 0);
		sevenseg : OUT std_logic_vector(6 downto 0)
		);
END COMPONENT;

COMPONENT comp
	PORT(
	A: IN std_logic_vector(3 downto 0); 
   B: IN std_logic_vector(3 downto 0); 
	RESULT: OUT std_logic
	);
END COMPONENT;

COMPONENT parity
   PORT(
	sw: IN std_logic_vector(7 downto 0); 
	RESULT:OUT std_logic
	);
END COMPONENT;

COMPONENT count1
  PORT(
  sw: IN std_logic_vector(7 downto 0); 
  RESULT: OUT STD_LOGIC_VECTOR(3 downto 0)
  );
END COMPONENT;

signal result_add: std_logic_vector(4 downto 0);
signal change_led: std_logic_vector(7 downto 0);

signal result_comp:std_logic;
signal result_parity:std_logic;
signal result_count1:std_logic_vector(3 downto 0);
signal result_mode:std_logic_vector(1 downto 0);

begin
U0: add4 PORT MAP(
		a => switches(3 downto 0),
		b => switches(7 downto 4),
		sum => result_add
	);
   
U1: x7seg PORT MAP(
		sw => change_led(3 downto 0),
		mode=>result_mode,
		sevenseg => sevenseg
	);
U2: comp PORT MAP(
		A => switches(3 downto 0),
		B => switches(7 downto 4),
		RESULT => result_comp
	);	
U3: parity PORT MAP(
		
		sw => switches(7 downto 0),
		RESULT => result_parity
	);	
U4: count1 PORT MAP(
		sw=> switches(7 downto 0),
		RESULT => result_count1
	);	
	
	with button select
	change_led <= ("0000"& switches(3 downto 0)) AND ("0000"& switches( 7 downto 4)) when "00010",
						("0000"& switches(3 downto 0)) OR ("0000"& switches( 7 downto 4)) when "00001",
						("0000"& switches(3 downto 0)) XOR ("0000"&switches(7 downto 4)) when "00011",
						"0000000" & result_comp when "00100",
						"0000000" & result_parity when "01000",
						"0000"&result_count1 when "10000",
						"000" & result_add when OTHERS;	
						
	with button select
		result_mode <= "01" when "00000" | "00010" | "00001" | "00011" | "10000",
				"10" when "00100",
				"11" when "01000",
				"00" when others;
				
						
   led <= change_led;	
	anodes <= "1110";
end Behavioral;
