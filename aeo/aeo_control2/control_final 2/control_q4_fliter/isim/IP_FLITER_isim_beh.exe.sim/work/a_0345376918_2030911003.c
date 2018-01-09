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
static const char *ng0 = "/home/parallels/Desktop/control_final/control_q4_shabi/fsm.vhd";
extern char *IEEE_P_2592010699;



static void work_a_0345376918_2030911003_p_0(char *t0)
{
    unsigned char t1;
    char *t2;
    unsigned char t3;
    char *t4;
    char *t5;
    unsigned char t6;
    unsigned char t7;
    char *t8;
    unsigned char t9;
    unsigned char t10;
    char *t11;
    char *t12;
    char *t13;
    char *t14;

LAB0:    xsi_set_current_line(43, ng0);
    t2 = (t0 + 1312U);
    t3 = xsi_signal_has_event(t2);
    if (t3 == 1)
        goto LAB5;

LAB6:    t1 = (unsigned char)0;

LAB7:    if (t1 != 0)
        goto LAB2;

LAB4:
LAB3:    t2 = (t0 + 4720);
    *((int *)t2) = 1;

LAB1:    return;
LAB2:    xsi_set_current_line(44, ng0);
    t4 = (t0 + 1512U);
    t8 = *((char **)t4);
    t9 = *((unsigned char *)t8);
    t10 = (t9 == (unsigned char)3);
    if (t10 != 0)
        goto LAB8;

LAB10:    xsi_set_current_line(47, ng0);
    t2 = (t0 + 2472U);
    t4 = *((char **)t2);
    t1 = *((unsigned char *)t4);
    t2 = (t0 + 4832);
    t5 = (t2 + 56U);
    t8 = *((char **)t5);
    t11 = (t8 + 56U);
    t12 = *((char **)t11);
    *((unsigned char *)t12) = t1;
    xsi_driver_first_trans_fast(t2);

LAB9:    goto LAB3;

LAB5:    t4 = (t0 + 1352U);
    t5 = *((char **)t4);
    t6 = *((unsigned char *)t5);
    t7 = (t6 == (unsigned char)3);
    t1 = t7;
    goto LAB7;

LAB8:    xsi_set_current_line(45, ng0);
    t4 = (t0 + 4832);
    t11 = (t4 + 56U);
    t12 = *((char **)t11);
    t13 = (t12 + 56U);
    t14 = *((char **)t13);
    *((unsigned char *)t14) = (unsigned char)0;
    xsi_driver_first_trans_fast(t4);
    goto LAB9;

}

static void work_a_0345376918_2030911003_p_1(char *t0)
{
    char t12[16];
    char t13[16];
    char t17[16];
    char *t1;
    char *t2;
    unsigned char t3;
    char *t4;
    char *t5;
    char *t6;
    char *t7;
    char *t8;
    unsigned int t9;
    unsigned int t10;
    unsigned int t11;
    char *t14;
    int t15;
    unsigned int t16;
    char *t18;
    int t19;
    char *t20;
    char *t21;
    char *t22;
    char *t23;
    static char *nl0[] = {&&LAB4, &&LAB4, &&LAB3};

LAB0:    xsi_set_current_line(55, ng0);
    t1 = (t0 + 2632U);
    t2 = *((char **)t1);
    t3 = *((unsigned char *)t2);
    t1 = (char *)((nl0) + t3);
    goto **((char **)t1);

LAB2:    t1 = (t0 + 4736);
    *((int *)t1) = 1;

LAB1:    return;
LAB3:    xsi_set_current_line(57, ng0);
    t4 = (t0 + 4896);
    t5 = (t4 + 56U);
    t6 = *((char **)t5);
    t7 = (t6 + 56U);
    t8 = *((char **)t7);
    *((unsigned char *)t8) = (unsigned char)3;
    xsi_driver_first_trans_fast_port(t4);
    xsi_set_current_line(58, ng0);
    t1 = (t0 + 8003);
    t4 = (t0 + 1032U);
    t5 = *((char **)t4);
    t9 = (31 - 7);
    t10 = (t9 * 1U);
    t11 = (0 + t10);
    t4 = (t5 + t11);
    t7 = ((IEEE_P_2592010699) + 4000);
    t8 = (t13 + 0U);
    t14 = (t8 + 0U);
    *((int *)t14) = 0;
    t14 = (t8 + 4U);
    *((int *)t14) = 23;
    t14 = (t8 + 8U);
    *((int *)t14) = 1;
    t15 = (23 - 0);
    t16 = (t15 * 1);
    t16 = (t16 + 1);
    t14 = (t8 + 12U);
    *((unsigned int *)t14) = t16;
    t14 = (t17 + 0U);
    t18 = (t14 + 0U);
    *((int *)t18) = 7;
    t18 = (t14 + 4U);
    *((int *)t18) = 0;
    t18 = (t14 + 8U);
    *((int *)t18) = -1;
    t19 = (0 - 7);
    t16 = (t19 * -1);
    t16 = (t16 + 1);
    t18 = (t14 + 12U);
    *((unsigned int *)t18) = t16;
    t6 = xsi_base_array_concat(t6, t12, t7, (char)97, t1, t13, (char)97, t4, t17, (char)101);
    t18 = (t0 + 4960);
    t20 = (t18 + 56U);
    t21 = *((char **)t20);
    t22 = (t21 + 56U);
    t23 = *((char **)t22);
    memcpy(t23, t6, 32U);
    xsi_driver_first_trans_fast_port(t18);
    xsi_set_current_line(59, ng0);
    t1 = (t0 + 8027);
    t4 = (t0 + 1032U);
    t5 = *((char **)t4);
    t9 = (31 - 31);
    t10 = (t9 * 1U);
    t11 = (0 + t10);
    t4 = (t5 + t11);
    t7 = ((IEEE_P_2592010699) + 4000);
    t8 = (t13 + 0U);
    t14 = (t8 + 0U);
    *((int *)t14) = 0;
    t14 = (t8 + 4U);
    *((int *)t14) = 7;
    t14 = (t8 + 8U);
    *((int *)t14) = 1;
    t15 = (7 - 0);
    t16 = (t15 * 1);
    t16 = (t16 + 1);
    t14 = (t8 + 12U);
    *((unsigned int *)t14) = t16;
    t14 = (t17 + 0U);
    t18 = (t14 + 0U);
    *((int *)t18) = 31;
    t18 = (t14 + 4U);
    *((int *)t18) = 8;
    t18 = (t14 + 8U);
    *((int *)t18) = -1;
    t19 = (8 - 31);
    t16 = (t19 * -1);
    t16 = (t16 + 1);
    t18 = (t14 + 12U);
    *((unsigned int *)t18) = t16;
    t6 = xsi_base_array_concat(t6, t12, t7, (char)97, t1, t13, (char)97, t4, t17, (char)101);
    t18 = (t0 + 5024);
    t20 = (t18 + 56U);
    t21 = *((char **)t20);
    t22 = (t21 + 56U);
    t23 = *((char **)t22);
    memcpy(t23, t6, 32U);
    xsi_driver_first_trans_fast_port(t18);
    goto LAB2;

LAB4:    xsi_set_current_line(61, ng0);
    t1 = (t0 + 4896);
    t2 = (t1 + 56U);
    t4 = *((char **)t2);
    t5 = (t4 + 56U);
    t6 = *((char **)t5);
    *((unsigned char *)t6) = (unsigned char)2;
    xsi_driver_first_trans_fast_port(t1);
    xsi_set_current_line(63, ng0);
    t1 = xsi_get_transient_memory(32U);
    memset(t1, 0, 32U);
    t2 = t1;
    memset(t2, (unsigned char)4, 32U);
    t4 = (t0 + 4960);
    t5 = (t4 + 56U);
    t6 = *((char **)t5);
    t7 = (t6 + 56U);
    t8 = *((char **)t7);
    memcpy(t8, t1, 32U);
    xsi_driver_first_trans_fast_port(t4);
    xsi_set_current_line(64, ng0);
    t1 = xsi_get_transient_memory(32U);
    memset(t1, 0, 32U);
    t2 = t1;
    memset(t2, (unsigned char)4, 32U);
    t4 = (t0 + 5024);
    t5 = (t4 + 56U);
    t6 = *((char **)t5);
    t7 = (t6 + 56U);
    t8 = *((char **)t7);
    memcpy(t8, t1, 32U);
    xsi_driver_first_trans_fast_port(t4);
    goto LAB2;

}

static void work_a_0345376918_2030911003_p_2(char *t0)
{
    char *t1;
    char *t2;
    unsigned char t3;
    char *t4;
    char *t5;
    char *t6;
    unsigned char t7;
    unsigned int t8;
    char *t9;
    char *t10;
    char *t11;
    char *t12;
    char *t13;
    char *t14;
    char *t15;
    static char *nl0[] = {&&LAB3, &&LAB4, &&LAB5};

LAB0:    xsi_set_current_line(72, ng0);
    t1 = (t0 + 2632U);
    t2 = *((char **)t1);
    t3 = *((unsigned char *)t2);
    t1 = (char *)((nl0) + t3);
    goto **((char **)t1);

LAB2:    t1 = (t0 + 4752);
    *((int *)t1) = 1;

LAB1:    return;
LAB3:    xsi_set_current_line(74, ng0);
    t4 = (t0 + 1192U);
    t5 = *((char **)t4);
    t4 = (t0 + 8035);
    t7 = 1;
    if (11U == 11U)
        goto LAB10;

LAB11:    t7 = 0;

LAB12:    if (t7 != 0)
        goto LAB7;

LAB9:    xsi_set_current_line(77, ng0);
    t1 = (t0 + 5088);
    t2 = (t1 + 56U);
    t4 = *((char **)t2);
    t5 = (t4 + 56U);
    t6 = *((char **)t5);
    *((unsigned char *)t6) = (unsigned char)0;
    xsi_driver_first_trans_fast(t1);

LAB8:    goto LAB2;

LAB4:    xsi_set_current_line(80, ng0);
    t1 = (t0 + 2152U);
    t2 = *((char **)t1);
    t3 = *((unsigned char *)t2);
    t7 = (t3 == (unsigned char)3);
    if (t7 != 0)
        goto LAB16;

LAB18:    xsi_set_current_line(84, ng0);
    t1 = (t0 + 5088);
    t2 = (t1 + 56U);
    t4 = *((char **)t2);
    t5 = (t4 + 56U);
    t6 = *((char **)t5);
    *((unsigned char *)t6) = (unsigned char)1;
    xsi_driver_first_trans_fast(t1);

LAB17:    goto LAB2;

LAB5:    xsi_set_current_line(87, ng0);
    t1 = (t0 + 5088);
    t2 = (t1 + 56U);
    t4 = *((char **)t2);
    t5 = (t4 + 56U);
    t6 = *((char **)t5);
    *((unsigned char *)t6) = (unsigned char)0;
    xsi_driver_first_trans_fast(t1);
    goto LAB2;

LAB6:    xsi_set_current_line(89, ng0);
    t1 = (t0 + 5088);
    t2 = (t1 + 56U);
    t4 = *((char **)t2);
    t5 = (t4 + 56U);
    t6 = *((char **)t5);
    *((unsigned char *)t6) = (unsigned char)0;
    xsi_driver_first_trans_fast(t1);
    goto LAB2;

LAB7:    xsi_set_current_line(75, ng0);
    t11 = (t0 + 5088);
    t12 = (t11 + 56U);
    t13 = *((char **)t12);
    t14 = (t13 + 56U);
    t15 = *((char **)t14);
    *((unsigned char *)t15) = (unsigned char)1;
    xsi_driver_first_trans_fast(t11);
    goto LAB8;

LAB10:    t8 = 0;

LAB13:    if (t8 < 11U)
        goto LAB14;
    else
        goto LAB12;

LAB14:    t9 = (t5 + t8);
    t10 = (t4 + t8);
    if (*((unsigned char *)t9) != *((unsigned char *)t10))
        goto LAB11;

LAB15:    t8 = (t8 + 1);
    goto LAB13;

LAB16:    xsi_set_current_line(82, ng0);
    t1 = (t0 + 5088);
    t4 = (t1 + 56U);
    t5 = *((char **)t4);
    t6 = (t5 + 56U);
    t9 = *((char **)t6);
    *((unsigned char *)t9) = (unsigned char)2;
    xsi_driver_first_trans_fast(t1);
    goto LAB17;

}


extern void work_a_0345376918_2030911003_init()
{
	static char *pe[] = {(void *)work_a_0345376918_2030911003_p_0,(void *)work_a_0345376918_2030911003_p_1,(void *)work_a_0345376918_2030911003_p_2};
	xsi_register_didat("work_a_0345376918_2030911003", "isim/IP_FLITER_isim_beh.exe.sim/work/a_0345376918_2030911003.didat");
	xsi_register_executes(pe);
}
