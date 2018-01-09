/**********************************************************************/
/*   ____  ____                                                       */
/*  /   /\/   /                                                       */
/* /___/  \  /                                                        */
/* \   \   \/                                                       */
/*  \   \        Copyright (c) 2003-2009 Xilinx, Inc.                */
/*  /   /          All Right Reserved.                                 */
/* /---/   /\                                                         */
/* \   \  /  \                                                      */
/*  \___\/\___\                                                    */
/***********************************************************************/

/* This file is designed for use with ISim build 0x9ca8bed6 */

#define XSI_HIDE_SYMBOL_SPEC true
#include "xsi.h"
#include <memory.h>
#ifdef __GNUC__
#include <stdlib.h>
#else
#include <malloc.h>
#define alloca _alloca
#endif
static const char *ng0 = "/home/parallels/Desktop/tp9/IP_ALU.vhd";
extern char *IEEE_P_3620187407;

unsigned char ieee_p_3620187407_sub_1366267000076357978_3965413181(char *, char *, char *, char *, char *);


static void work_a_0858538683_3212880686_p_0(char *t0)
{
    unsigned char t1;
    char *t2;
    char *t3;
    char *t4;
    char *t5;
    unsigned char t6;
    char *t7;
    char *t9;
    char *t10;
    char *t11;
    unsigned char t12;
    char *t13;
    char *t15;
    char *t16;
    char *t17;
    char *t18;
    char *t19;
    char *t20;
    char *t21;
    char *t22;
    char *t23;
    char *t24;
    char *t25;
    char *t26;
    char *t27;

LAB0:    xsi_set_current_line(17, ng0);
    t2 = (t0 + 1032U);
    t3 = *((char **)t2);
    t2 = (t0 + 5168U);
    t4 = (t0 + 1192U);
    t5 = *((char **)t4);
    t4 = (t0 + 5184U);
    t6 = ieee_std_logic_unsigned_equal_stdv_stdv(IEEE_P_3620187407, t3, t2, t5, t4);
    if (t6 == 1)
        goto LAB5;

LAB6:    t1 = (unsigned char)0;

LAB7:    if (t1 != 0)
        goto LAB3;

LAB4:
LAB8:    t20 = xsi_get_transient_memory(32U);
    memset(t20, 0, 32U);
    t21 = t20;
    memset(t21, (unsigned char)4, 32U);
    t22 = (t0 + 3448);
    t23 = (t22 + 56U);
    t24 = *((char **)t23);
    t25 = (t24 + 56U);
    t26 = *((char **)t25);
    memcpy(t26, t20, 32U);
    xsi_driver_first_trans_fast_port(t22);

LAB2:    t27 = (t0 + 3352);
    *((int *)t27) = 1;

LAB1:    return;
LAB3:    t13 = (t0 + 5337);
    t15 = (t0 + 3448);
    t16 = (t15 + 56U);
    t17 = *((char **)t16);
    t18 = (t17 + 56U);
    t19 = *((char **)t18);
    memcpy(t19, t13, 32U);
    xsi_driver_first_trans_fast_port(t15);
    goto LAB2;

LAB5:    t7 = (t0 + 5326);
    t9 = (t0 + 5152U);
    t10 = (t0 + 1352U);
    t11 = *((char **)t10);
    t10 = (t0 + 5200U);
    t12 = ieee_std_logic_unsigned_equal_stdv_stdv(IEEE_P_3620187407, t7, t9, t11, t10);
    t1 = t12;
    goto LAB7;

LAB9:    goto LAB2;

}

static void work_a_0858538683_3212880686_p_1(char *t0)
{
    unsigned char t1;
    unsigned char t2;
    char *t3;
    char *t4;
    char *t5;
    char *t6;
    unsigned char t7;
    char *t8;
    char *t9;
    char *t10;
    char *t11;
    unsigned char t12;
    char *t13;
    char *t15;
    char *t16;
    char *t17;
    unsigned char t18;
    char *t19;
    char *t21;
    char *t22;
    char *t23;
    char *t24;
    char *t25;
    char *t26;
    char *t27;
    char *t28;
    char *t29;
    char *t30;
    char *t31;
    char *t32;
    char *t33;

LAB0:    xsi_set_current_line(19, ng0);
    t3 = (t0 + 1032U);
    t4 = *((char **)t3);
    t3 = (t0 + 5168U);
    t5 = (t0 + 1192U);
    t6 = *((char **)t5);
    t5 = (t0 + 5184U);
    t7 = ieee_std_logic_unsigned_greater_stdv_stdv(IEEE_P_3620187407, t4, t3, t6, t5);
    if (t7 == 1)
        goto LAB8;

LAB9:    t8 = (t0 + 1032U);
    t9 = *((char **)t8);
    t8 = (t0 + 5168U);
    t10 = (t0 + 1192U);
    t11 = *((char **)t10);
    t10 = (t0 + 5184U);
    t12 = ieee_p_3620187407_sub_1366267000076357978_3965413181(IEEE_P_3620187407, t9, t8, t11, t10);
    t2 = t12;

LAB10:    if (t2 == 1)
        goto LAB5;

LAB6:    t1 = (unsigned char)0;

LAB7:    if (t1 != 0)
        goto LAB3;

LAB4:
LAB11:    t26 = xsi_get_transient_memory(32U);
    memset(t26, 0, 32U);
    t27 = t26;
    memset(t27, (unsigned char)4, 32U);
    t28 = (t0 + 3512);
    t29 = (t28 + 56U);
    t30 = *((char **)t29);
    t31 = (t30 + 56U);
    t32 = *((char **)t31);
    memcpy(t32, t26, 32U);
    xsi_driver_first_trans_fast_port(t28);

LAB2:    t33 = (t0 + 3368);
    *((int *)t33) = 1;

LAB1:    return;
LAB3:    t19 = (t0 + 5380);
    t21 = (t0 + 3512);
    t22 = (t21 + 56U);
    t23 = *((char **)t22);
    t24 = (t23 + 56U);
    t25 = *((char **)t24);
    memcpy(t25, t19, 32U);
    xsi_driver_first_trans_fast_port(t21);
    goto LAB2;

LAB5:    t13 = (t0 + 5369);
    t15 = (t0 + 5152U);
    t16 = (t0 + 1352U);
    t17 = *((char **)t16);
    t16 = (t0 + 5200U);
    t18 = ieee_std_logic_unsigned_equal_stdv_stdv(IEEE_P_3620187407, t13, t15, t17, t16);
    t1 = t18;
    goto LAB7;

LAB8:    t2 = (unsigned char)1;
    goto LAB10;

LAB12:    goto LAB2;

}


extern void work_a_0858538683_3212880686_init()
{
	static char *pe[] = {(void *)work_a_0858538683_3212880686_p_0,(void *)work_a_0858538683_3212880686_p_1};
	xsi_register_didat("work_a_0858538683_3212880686", "isim/IP_ALU_isim_beh.exe.sim/work/a_0858538683_3212880686.didat");
	xsi_register_executes(pe);
}
