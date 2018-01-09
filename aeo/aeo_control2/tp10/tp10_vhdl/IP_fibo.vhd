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

    type state_type is (idle, starting, finish); 
    signal state, next_state : state_type;
    --switch TIN
    signal compt, compt_i : std_logic_vector (7 downto 0);
	 --the mark of state controller
    signal init_i : std_logic;
	 signal IPdone_i : std_logic;  
	 --the result of fibogen calculation
    signal fibobus : std_logic_vector (31 downto 0);
    --It is useless but prof asked in the picture
    signal Tout_i : std_logic_vector(31 downto 0);
    COMPONENT fibogen
PORT(
	clk : IN std_logic;
	init : IN std_logic;          
	fiboout : OUT std_logic_vector(31 downto 0)
);
    END COMPONENT;

begin

	Inst_fibogen: fibogen PORT MAP(
	clk => clk,
	init => init_i,
	fiboout => fibobus 
);
--The clk keep on calculate, we don't have the time to read very result. At the same time we need to control the fibo
-- That's the reason why we use fsm : to make every calculated result stop.
-- For exemple, if the input(IP_TIN) is 5, we calculte 3 times fibo(compt). and we affichier the result
--we need a signal mark the finished state to control when to affichier the result.(IP_done)
--we need a signal mark the idle state to init the fibogen, and stop the fibogen.


--this process is used to control the state and calculation of fibo not to be disturbed by clock.
SYNC_PROC: process (clk, reset) 
   begin
      if (clk'event and clk = '1') then
		--if reset is clicked, all will be turned into 0 
         if (reset = '1') then
            state <= idle;
            IPdone  <= '0';
				compt<= x"00";
				Tout <= (others=> 'Z');
         else
		--the result will be affichie only if the ipdone signal =1 and copy the compt times last to compt
            state <= next_state;
				compt<= compt_i;
            IPdone <= IPdone_i;	
				if IPdone_i = '1' then
					Tout <= fibobus;
				else
					Tout <= (others=> 'Z');
				end if ;	
			end if;        
      end if;
   end process;
	
--this process is used to control init
--1.when we start and stop calculate fibo by fibogen
--2.when it is to affichier the result of calculation one 7segdup
OUTPUT_DECODE: process (state)
   begin
      IPdone_i <= '0';
      Tout_i <= (others=>'0');
      init_i <= '0';
      case state is
--when state is idle, we prepared the initialization, we intialize the fib1 and fib2=1 in fibogen 
			when idle =>
				init_i <= '1';
--when state is finished, we changed the signal of ip_done_1 to 1,affichier the tout_i signal.
			when finish =>
				IPdone_i <= '1';
				Tout_i<=fibobus;
			when others => 
      end case;
   end process;
	
--This process is used to controled the state change,
--if the ip_code is correct, 
NEXT_STATE_DECODE: process (state, compt, IPcode)
   begin

      next_state <= state;  
      compt_i <= x"00";
      case (state) is
-- for the state idle, we need to change the state to starting, start calculate fibo and readin the TIN
         when idle =>
            if IPcode = Mycode then
               next_state <= starting;
					compt_i <= Tin(7 downto 0);
				end if;
--if the compt come to 3,the calculte finished, we change the state.if it is bigger than 3,every clk time, we decrease 1
         when starting =>
            if compt = x"03" then
               next_state <= finish ;
				else 
					compt_i <= compt - 1 ;
            end if;
--fix the result.
         when finish =>
            next_state <= idle;
         when others =>
            next_state <= idle;
      end case;      
   end process;
	

	


end Behavioral;