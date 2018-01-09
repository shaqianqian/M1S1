----------------------------------------------------------------------------------
-- Company: 
-- Engineer: 
-- 
-- Create Date:    17:19:15 10/04/2016 
-- Design Name: 
-- Module Name:    shift_vector - Behavioral 
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
use ieee.std_logic_unsigned.all;

-- Uncomment the following library declaration if using
-- arithmetic functions with Signed or Unsigned values
--use IEEE.NUMERIC_STD.ALL;

-- Uncomment the following library declaration if instantiating
-- any Xilinx primitives in this code.
--library UNISIM;
--use UNISIM.VComponents.all;

entity shift_vector is
    Port ( --btn : in  STD_LOGIC_VECTOR (4 downto 0);
           --sw : in  STD_LOGIC_VECTOR (7 downto 0);
           clk : in  STD_LOGIC;
           led : out  STD_LOGIC_VECTOR (7 downto 0));
end shift_vector;

architecture Behavioral of shift_vector is

begin

	process (clk)
	
		variable i : integer := 7;
		variable temp : std_logic_vector (7 downto 0) := "10000000";//һ��ʼled7��
		
	begin
//led7����������ת��led6����֮��led5�������Ƶ�led0�����ַ���led7�����γ�һ����·
		if (clk'event and clk='1') then
			temp(i) := '1';
			if(i = 7) then
				temp(0) := '0';//led7������ǰһ��led0������Ϊ0
			else
				temp(i+1) := '0';//��ǰled������ǰһ��led����������led6������ǰһ��led7������Ϊ0��������i+1Ϊ0��
			end if;
			if(i = 0) then
				i := 7;//�ر�����led0��led7
			else
				i := i - 1;//led7��led6��led5.����
			end if;
		end if;
		
		led <= temp;

	end process ;

end Behavioral;

