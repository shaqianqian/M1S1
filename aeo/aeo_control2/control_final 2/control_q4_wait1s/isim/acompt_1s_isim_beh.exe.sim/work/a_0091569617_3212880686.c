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
static const char *ng0 = "/home/parallels/Desktop/control_final/control_q5/acompt_1s.vhd";
extern char *IEEE_P_1242562249;

char *ieee_p_1242562249_sub_1006216973935652998_1035706684(char *, char *, char *, char *, int );
unsigned char ieee_p_1242562249_sub_1434214030532789707_1035706684(char *, char *, char *, char *, char *);


static void work_a_0091569617_3212880686_p_0(char *t0)
{
    char t8[16];
    unsigned char t1;
    char *t2;
    unsigned char t3;
    char *t4;
    char *t5;
    unsigned char t6;
    unsigned char t7;
    char *t9;
    char *t10;
    char *t11;
    char *t12;
    char *t13;
    unsigned int t14;
    unsigned int t15;
    int t16;
    char *t17;

LAB0:    xsi_set_current_line(21, ng0);
    t2 = (t0 + 992U);
    t3 = xsi_signal_has_event(t2);
    if (t3 == 1)
        goto LAB5;

LAB6:    t1 = (unsigned char)0;

LAB7:    if (t1 != 0)
        goto LAB2;

LAB4:
LAB3:    t2 = (t0 + 2784);
    *((int *)t2) = 1;

LAB1:    return;
LAB2:    xsi_set_current_line(22, ng0);
    t4 = (t0 + 1488U);
    t9 = *((char **)t4);
    t4 = (t0 + 4520U);
    t10 = ieee_p_1242562249_sub_1006216973935652998_1035706684(IEEE_P_1242562249, t8, t9, t4, 1);
    t11 = (t0 + 1488U);
    t12 = *((char **)t11);
    t11 = (t12 + 0);
    t13 = (t8 + 12U);
    t14 = *((unsigned int *)t13);
    t15 = (1U * t14);
    memcpy(t11, t10, t15);
    xsi_set_current_line(23, ng0);
    t2 = (t0 + 2864);
    t4 = (t2 + 56U);
    t5 = *((char **)t4);
    t9 = (t5 + 56U);
    t10 = *((char **)t9);
    *((unsigned char *)t10) = (unsigned char)2;
    xsi_driver_first_trans_fast_port(t2);
    xsi_set_current_line(24, ng0);
    t2 = (t0 + 1488U);
    t4 = *((char **)t2);
    t2 = (t0 + 4520U);
    t5 = (t0 + 4574);
    t10 = (t8 + 0U);
    t11 = (t10 + 0U);
    *((int *)t11) = 0;
    t11 = (t10 + 4U);
    *((int *)t11) = 3;
    t11 = (t10 + 8U);
    *((int *)t11) = 1;
    t16 = (3 - 0);
    t14 = (t16 * 1);
    t14 = (t14 + 1);
    t11 = (t10 + 12U);
    *((unsigned int *)t11) = t14;
    t1 = ieee_p_1242562249_sub_1434214030532789707_1035706684(IEEE_P_1242562249, t4, t2, t5, t8);
    if (t1 != 0)
        goto LAB8;

LAB10:
LAB9:    goto LAB3;

LAB5:    t4 = (t0 + 1032U);
    t5 = *((char **)t4);
    t6 = *((unsigned char *)t5);
    t7 = (t6 == (unsigned char)3);
    t1 = t7;
    goto LAB7;

LAB8:    xsi_set_current_line(25, ng0);
    t11 = xsi_get_transient_memory(28U);
    memset(t11, 0, 28U);
    t12 = t11;
    memset(t12, (unsigned char)2, 28U);
    t13 = (t0 + 1488U);
    t17 = *((char **)t13);
    t13 = (t17 + 0);
    memcpy(t13, t11, 28U);
    xsi_set_current_line(26, ng0);
    t2 = (t0 + 2864);
    t4 = (t2 + 56U);
    t5 = *((char **)t4);
    t9 = (t5 + 56U);
    t10 = *((char **)t9);
    *((unsigned char *)t10) = (unsigned char)3;
    xsi_driver_first_trans_fast_port(t2);
    goto LAB9;

}


extern void work_a_0091569617_3212880686_init()
{
	static char *pe[] = {(void *)work_a_0091569617_3212880686_p_0};
	xsi_register_didat("work_a_0091569617_3212880686", "isim/acompt_1s_isim_beh.exe.sim/work/a_0091569617_3212880686.didat");
	xsi_register_executes(pe);
}
