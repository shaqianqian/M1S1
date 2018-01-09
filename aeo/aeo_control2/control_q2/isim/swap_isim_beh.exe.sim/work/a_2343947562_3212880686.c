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
static const char *ng0 = "/home/parallels/Desktop/aeo_control2/control_final 2/control_q2/swap.vhd";
extern char *IEEE_P_2592010699;



static void work_a_2343947562_3212880686_p_0(char *t0)
{
    unsigned char t1;
    char *t2;
    char *t3;
    char *t4;
    unsigned char t5;
    char *t6;
    char *t7;
    char *t8;
    unsigned char t9;
    char *t10;
    char *t11;
    char *t12;
    unsigned char t13;
    char *t14;
    char *t15;
    char *t16;
    char *t17;
    char *t18;
    char *t19;

LAB0:    xsi_set_current_line(48, ng0);
    t2 = (t0 + 1352U);
    t3 = *((char **)t2);
    t2 = (t0 + 1032U);
    t4 = *((char **)t2);
    t2 = ((IEEE_P_2592010699) + 4000);
    t5 = xsi_vhdl_greaterEqual(t2, t3, 32U, t4, 32U);
    if (t5 == 1)
        goto LAB5;

LAB6:    t1 = (unsigned char)0;

LAB7:    if (t1 != 0)
        goto LAB2;

LAB4:    t2 = (t0 + 1192U);
    t3 = *((char **)t2);
    t2 = (t0 + 1032U);
    t4 = *((char **)t2);
    t2 = ((IEEE_P_2592010699) + 4000);
    t5 = xsi_vhdl_greaterEqual(t2, t3, 32U, t4, 32U);
    if (t5 == 1)
        goto LAB13;

LAB14:    t1 = (unsigned char)0;

LAB15:    if (t1 != 0)
        goto LAB11;

LAB12:    t2 = (t0 + 1032U);
    t3 = *((char **)t2);
    t2 = (t0 + 1192U);
    t4 = *((char **)t2);
    t2 = ((IEEE_P_2592010699) + 4000);
    t5 = xsi_vhdl_greaterEqual(t2, t3, 32U, t4, 32U);
    if (t5 == 1)
        goto LAB21;

LAB22:    t1 = (unsigned char)0;

LAB23:    if (t1 != 0)
        goto LAB19;

LAB20:
LAB3:    t2 = (t0 + 3304);
    *((int *)t2) = 1;

LAB1:    return;
LAB2:    xsi_set_current_line(50, ng0);
    t10 = (t0 + 1032U);
    t11 = *((char **)t10);
    t10 = (t0 + 1192U);
    t12 = *((char **)t10);
    t10 = ((IEEE_P_2592010699) + 4000);
    t13 = xsi_vhdl_lessthan(t10, t11, 32U, t12, 32U);
    if (t13 != 0)
        goto LAB8;

LAB10:    xsi_set_current_line(55, ng0);
    t2 = (t0 + 1352U);
    t3 = *((char **)t2);
    t2 = (t0 + 3384);
    t4 = (t2 + 56U);
    t6 = *((char **)t4);
    t7 = (t6 + 56U);
    t8 = *((char **)t7);
    memcpy(t8, t3, 32U);
    xsi_driver_first_trans_fast_port(t2);
    xsi_set_current_line(56, ng0);
    t2 = (t0 + 1032U);
    t3 = *((char **)t2);
    t2 = (t0 + 3448);
    t4 = (t2 + 56U);
    t6 = *((char **)t4);
    t7 = (t6 + 56U);
    t8 = *((char **)t7);
    memcpy(t8, t3, 32U);
    xsi_driver_first_trans_fast_port(t2);
    xsi_set_current_line(57, ng0);
    t2 = (t0 + 1192U);
    t3 = *((char **)t2);
    t2 = (t0 + 3512);
    t4 = (t2 + 56U);
    t6 = *((char **)t4);
    t7 = (t6 + 56U);
    t8 = *((char **)t7);
    memcpy(t8, t3, 32U);
    xsi_driver_first_trans_fast_port(t2);

LAB9:    goto LAB3;

LAB5:    t6 = (t0 + 1352U);
    t7 = *((char **)t6);
    t6 = (t0 + 1192U);
    t8 = *((char **)t6);
    t6 = ((IEEE_P_2592010699) + 4000);
    t9 = xsi_vhdl_greaterEqual(t6, t7, 32U, t8, 32U);
    t1 = t9;
    goto LAB7;

LAB8:    xsi_set_current_line(51, ng0);
    t14 = (t0 + 1352U);
    t15 = *((char **)t14);
    t14 = (t0 + 3384);
    t16 = (t14 + 56U);
    t17 = *((char **)t16);
    t18 = (t17 + 56U);
    t19 = *((char **)t18);
    memcpy(t19, t15, 32U);
    xsi_driver_first_trans_fast_port(t14);
    xsi_set_current_line(52, ng0);
    t2 = (t0 + 1192U);
    t3 = *((char **)t2);
    t2 = (t0 + 3448);
    t4 = (t2 + 56U);
    t6 = *((char **)t4);
    t7 = (t6 + 56U);
    t8 = *((char **)t7);
    memcpy(t8, t3, 32U);
    xsi_driver_first_trans_fast_port(t2);
    xsi_set_current_line(53, ng0);
    t2 = (t0 + 1032U);
    t3 = *((char **)t2);
    t2 = (t0 + 3512);
    t4 = (t2 + 56U);
    t6 = *((char **)t4);
    t7 = (t6 + 56U);
    t8 = *((char **)t7);
    memcpy(t8, t3, 32U);
    xsi_driver_first_trans_fast_port(t2);
    goto LAB9;

LAB11:    xsi_set_current_line(63, ng0);
    t10 = (t0 + 1032U);
    t11 = *((char **)t10);
    t10 = (t0 + 1352U);
    t12 = *((char **)t10);
    t10 = ((IEEE_P_2592010699) + 4000);
    t13 = xsi_vhdl_lessthan(t10, t11, 32U, t12, 32U);
    if (t13 != 0)
        goto LAB16;

LAB18:    xsi_set_current_line(68, ng0);
    t2 = (t0 + 1192U);
    t3 = *((char **)t2);
    t2 = (t0 + 3384);
    t4 = (t2 + 56U);
    t6 = *((char **)t4);
    t7 = (t6 + 56U);
    t8 = *((char **)t7);
    memcpy(t8, t3, 32U);
    xsi_driver_first_trans_fast_port(t2);
    xsi_set_current_line(69, ng0);
    t2 = (t0 + 1032U);
    t3 = *((char **)t2);
    t2 = (t0 + 3448);
    t4 = (t2 + 56U);
    t6 = *((char **)t4);
    t7 = (t6 + 56U);
    t8 = *((char **)t7);
    memcpy(t8, t3, 32U);
    xsi_driver_first_trans_fast_port(t2);
    xsi_set_current_line(70, ng0);
    t2 = (t0 + 1352U);
    t3 = *((char **)t2);
    t2 = (t0 + 3512);
    t4 = (t2 + 56U);
    t6 = *((char **)t4);
    t7 = (t6 + 56U);
    t8 = *((char **)t7);
    memcpy(t8, t3, 32U);
    xsi_driver_first_trans_fast_port(t2);

LAB17:    goto LAB3;

LAB13:    t6 = (t0 + 1192U);
    t7 = *((char **)t6);
    t6 = (t0 + 1352U);
    t8 = *((char **)t6);
    t6 = ((IEEE_P_2592010699) + 4000);
    t9 = xsi_vhdl_greaterEqual(t6, t7, 32U, t8, 32U);
    t1 = t9;
    goto LAB15;

LAB16:    xsi_set_current_line(64, ng0);
    t14 = (t0 + 1192U);
    t15 = *((char **)t14);
    t14 = (t0 + 3384);
    t16 = (t14 + 56U);
    t17 = *((char **)t16);
    t18 = (t17 + 56U);
    t19 = *((char **)t18);
    memcpy(t19, t15, 32U);
    xsi_driver_first_trans_fast_port(t14);
    xsi_set_current_line(65, ng0);
    t2 = (t0 + 1352U);
    t3 = *((char **)t2);
    t2 = (t0 + 3448);
    t4 = (t2 + 56U);
    t6 = *((char **)t4);
    t7 = (t6 + 56U);
    t8 = *((char **)t7);
    memcpy(t8, t3, 32U);
    xsi_driver_first_trans_fast_port(t2);
    xsi_set_current_line(66, ng0);
    t2 = (t0 + 1032U);
    t3 = *((char **)t2);
    t2 = (t0 + 3512);
    t4 = (t2 + 56U);
    t6 = *((char **)t4);
    t7 = (t6 + 56U);
    t8 = *((char **)t7);
    memcpy(t8, t3, 32U);
    xsi_driver_first_trans_fast_port(t2);
    goto LAB17;

LAB19:    xsi_set_current_line(75, ng0);
    t10 = (t0 + 1192U);
    t11 = *((char **)t10);
    t10 = (t0 + 1352U);
    t12 = *((char **)t10);
    t10 = ((IEEE_P_2592010699) + 4000);
    t13 = xsi_vhdl_lessthan(t10, t11, 32U, t12, 32U);
    if (t13 != 0)
        goto LAB24;

LAB26:    xsi_set_current_line(80, ng0);
    t2 = (t0 + 1032U);
    t3 = *((char **)t2);
    t2 = (t0 + 3384);
    t4 = (t2 + 56U);
    t6 = *((char **)t4);
    t7 = (t6 + 56U);
    t8 = *((char **)t7);
    memcpy(t8, t3, 32U);
    xsi_driver_first_trans_fast_port(t2);
    xsi_set_current_line(81, ng0);
    t2 = (t0 + 1192U);
    t3 = *((char **)t2);
    t2 = (t0 + 3448);
    t4 = (t2 + 56U);
    t6 = *((char **)t4);
    t7 = (t6 + 56U);
    t8 = *((char **)t7);
    memcpy(t8, t3, 32U);
    xsi_driver_first_trans_fast_port(t2);
    xsi_set_current_line(82, ng0);
    t2 = (t0 + 1352U);
    t3 = *((char **)t2);
    t2 = (t0 + 3512);
    t4 = (t2 + 56U);
    t6 = *((char **)t4);
    t7 = (t6 + 56U);
    t8 = *((char **)t7);
    memcpy(t8, t3, 32U);
    xsi_driver_first_trans_fast_port(t2);

LAB25:    goto LAB3;

LAB21:    t6 = (t0 + 1032U);
    t7 = *((char **)t6);
    t6 = (t0 + 1352U);
    t8 = *((char **)t6);
    t6 = ((IEEE_P_2592010699) + 4000);
    t9 = xsi_vhdl_greaterEqual(t6, t7, 32U, t8, 32U);
    t1 = t9;
    goto LAB23;

LAB24:    xsi_set_current_line(76, ng0);
    t14 = (t0 + 1032U);
    t15 = *((char **)t14);
    t14 = (t0 + 3384);
    t16 = (t14 + 56U);
    t17 = *((char **)t16);
    t18 = (t17 + 56U);
    t19 = *((char **)t18);
    memcpy(t19, t15, 32U);
    xsi_driver_first_trans_fast_port(t14);
    xsi_set_current_line(77, ng0);
    t2 = (t0 + 1352U);
    t3 = *((char **)t2);
    t2 = (t0 + 3448);
    t4 = (t2 + 56U);
    t6 = *((char **)t4);
    t7 = (t6 + 56U);
    t8 = *((char **)t7);
    memcpy(t8, t3, 32U);
    xsi_driver_first_trans_fast_port(t2);
    xsi_set_current_line(78, ng0);
    t2 = (t0 + 1192U);
    t3 = *((char **)t2);
    t2 = (t0 + 3512);
    t4 = (t2 + 56U);
    t6 = *((char **)t4);
    t7 = (t6 + 56U);
    t8 = *((char **)t7);
    memcpy(t8, t3, 32U);
    xsi_driver_first_trans_fast_port(t2);
    goto LAB25;

}


extern void work_a_2343947562_3212880686_init()
{
	static char *pe[] = {(void *)work_a_2343947562_3212880686_p_0};
	xsi_register_didat("work_a_2343947562_3212880686", "isim/swap_isim_beh.exe.sim/work/a_2343947562_3212880686.didat");
	xsi_register_executes(pe);
}
