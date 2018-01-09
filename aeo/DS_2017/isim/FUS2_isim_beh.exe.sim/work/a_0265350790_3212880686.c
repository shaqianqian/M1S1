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
static const char *ng0 = "/home/parallels/Desktop/DS_2017/FUS2.vhd";
extern char *IEEE_P_2592010699;



static void work_a_0265350790_3212880686_p_0(char *t0)
{
    unsigned char t1;
    char *t2;
    unsigned char t3;
    char *t4;
    char *t5;
    unsigned char t6;
    unsigned char t7;
    char *t8;
    char *t9;
    unsigned char t10;
    char *t11;
    char *t12;
    char *t13;
    char *t14;
    char *t15;
    char *t16;

LAB0:    xsi_set_current_line(22, ng0);
    t2 = (t0 + 2272U);
    t3 = xsi_signal_has_event(t2);
    if (t3 == 1)
        goto LAB5;

LAB6:    t1 = (unsigned char)0;

LAB7:    if (t1 != 0)
        goto LAB2;

LAB4:
LAB3:    t2 = (t0 + 3784);
    *((int *)t2) = 1;

LAB1:    return;
LAB2:    xsi_set_current_line(23, ng0);
    t4 = (t0 + 1032U);
    t8 = *((char **)t4);
    t4 = (t0 + 1352U);
    t9 = *((char **)t4);
    t4 = ((IEEE_P_2592010699) + 4000);
    t10 = xsi_vhdl_greater(t4, t8, 8U, t9, 8U);
    if (t10 != 0)
        goto LAB8;

LAB10:    xsi_set_current_line(27, ng0);
    t2 = (t0 + 1032U);
    t4 = *((char **)t2);
    t2 = (t0 + 3864);
    t5 = (t2 + 56U);
    t8 = *((char **)t5);
    t9 = (t8 + 56U);
    t11 = *((char **)t9);
    memcpy(t11, t4, 8U);
    xsi_driver_first_trans_fast_port(t2);
    xsi_set_current_line(28, ng0);
    t2 = (t0 + 1352U);
    t4 = *((char **)t2);
    t2 = (t0 + 3928);
    t5 = (t2 + 56U);
    t8 = *((char **)t5);
    t9 = (t8 + 56U);
    t11 = *((char **)t9);
    memcpy(t11, t4, 8U);
    xsi_driver_first_trans_fast_port(t2);

LAB9:    xsi_set_current_line(31, ng0);
    t2 = (t0 + 1192U);
    t4 = *((char **)t2);
    t2 = (t0 + 1512U);
    t5 = *((char **)t2);
    t2 = ((IEEE_P_2592010699) + 4000);
    t1 = xsi_vhdl_greater(t2, t4, 8U, t5, 8U);
    if (t1 != 0)
        goto LAB11;

LAB13:    xsi_set_current_line(35, ng0);
    t2 = (t0 + 1192U);
    t4 = *((char **)t2);
    t2 = (t0 + 3992);
    t5 = (t2 + 56U);
    t8 = *((char **)t5);
    t9 = (t8 + 56U);
    t11 = *((char **)t9);
    memcpy(t11, t4, 8U);
    xsi_driver_first_trans_fast_port(t2);
    xsi_set_current_line(36, ng0);
    t2 = (t0 + 1512U);
    t4 = *((char **)t2);
    t2 = (t0 + 4056);
    t5 = (t2 + 56U);
    t8 = *((char **)t5);
    t9 = (t8 + 56U);
    t11 = *((char **)t9);
    memcpy(t11, t4, 8U);
    xsi_driver_first_trans_fast_port(t2);

LAB12:    goto LAB3;

LAB5:    t4 = (t0 + 2312U);
    t5 = *((char **)t4);
    t6 = *((unsigned char *)t5);
    t7 = (t6 == (unsigned char)3);
    t1 = t7;
    goto LAB7;

LAB8:    xsi_set_current_line(24, ng0);
    t11 = (t0 + 1352U);
    t12 = *((char **)t11);
    t11 = (t0 + 3864);
    t13 = (t11 + 56U);
    t14 = *((char **)t13);
    t15 = (t14 + 56U);
    t16 = *((char **)t15);
    memcpy(t16, t12, 8U);
    xsi_driver_first_trans_fast_port(t11);
    xsi_set_current_line(25, ng0);
    t2 = (t0 + 1032U);
    t4 = *((char **)t2);
    t2 = (t0 + 3928);
    t5 = (t2 + 56U);
    t8 = *((char **)t5);
    t9 = (t8 + 56U);
    t11 = *((char **)t9);
    memcpy(t11, t4, 8U);
    xsi_driver_first_trans_fast_port(t2);
    goto LAB9;

LAB11:    xsi_set_current_line(32, ng0);
    t8 = (t0 + 1512U);
    t9 = *((char **)t8);
    t8 = (t0 + 3992);
    t11 = (t8 + 56U);
    t12 = *((char **)t11);
    t13 = (t12 + 56U);
    t14 = *((char **)t13);
    memcpy(t14, t9, 8U);
    xsi_driver_first_trans_fast_port(t8);
    xsi_set_current_line(33, ng0);
    t2 = (t0 + 1192U);
    t4 = *((char **)t2);
    t2 = (t0 + 4056);
    t5 = (t2 + 56U);
    t8 = *((char **)t5);
    t9 = (t8 + 56U);
    t11 = *((char **)t9);
    memcpy(t11, t4, 8U);
    xsi_driver_first_trans_fast_port(t2);
    goto LAB12;

}


extern void work_a_0265350790_3212880686_init()
{
	static char *pe[] = {(void *)work_a_0265350790_3212880686_p_0};
	xsi_register_didat("work_a_0265350790_3212880686", "isim/FUS2_isim_beh.exe.sim/work/a_0265350790_3212880686.didat");
	xsi_register_executes(pe);
}
