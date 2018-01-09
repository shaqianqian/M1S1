

COMPONENT IP_FLITER
	GENERIC (Mycode : std_logic_vector (10 downto 0));
	PORT(
		clk : IN std_logic;
		reset : in std_logic;
		IPcode : IN std_logic_vector(10 downto 0);
		IPdone : out std_logic
		);
	END COMPONENT;	

 

Mfliter : if genM_fliter = '1' generate
	Inst_IPfliter: IP_FLITER
		generic map (Mycode =>IPfliter)
		PORT MAP(
		clk=>clock,
		reset => reset,
		IPcode => Icode,
		IPdone => IPdft
	);	
end generate Mfliter;

