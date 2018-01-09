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
static const char *ng0 = "/home/l3/sha/Bureau/TP2/count1.vhd";
extern char *IEEE_P_3499444699;

char *ieee_p_3499444699_sub_17544701978858283880_3536714472(char *, char *, int , int );


static void work_a_2553508987_3212880686_p_0(char *t0)
{
    char t20[16];
    char *t1;
    char *t2;
    int t3;
    int t4;
    char *t5;
    char *t6;
    int t7;
    int t8;
    unsigned int t9;
    unsigned int t10;
    unsigned int t11;
    char *t12;
    unsigned char t13;
    unsigned char t14;
    char *t15;
    char *t16;
    int t17;
    int t18;
    char *t19;

LAB0:    xsi_set_current_line(18, ng0);
    t1 = (t0 + 1488U);
    t2 = *((char **)t1);
    t1 = (t2 + 0);
    *((int *)t1) = 0;
    xsi_set_current_line(19, ng0);
    t1 = (t0 + 4396);
    *((int *)t1) = 0;
    t2 = (t0 + 4400);
    *((int *)t2) = 7;
    t3 = 0;
    t4 = 7;

LAB2:    if (t3 <= t4)
        goto LAB3;

LAB5:    xsi_set_current_line(23, ng0);
    t1 = (t0 + 1488U);
    t2 = *((char **)t1);
    t3 = *((int *)t2);
    t1 = ieee_p_3499444699_sub_17544701978858283880_3536714472(IEEE_P_3499444699, t20, t3, 4);
    t5 = (t0 + 2864);
    t6 = (t5 + 56U);
    t12 = *((char **)t6);
    t15 = (t12 + 56U);
    t16 = *((char **)t15);
    memcpy(t16, t1, 4U);
    xsi_driver_first_trans_fast_port(t5);
    t1 = (t0 + 2784);
    *((int *)t1) = 1;

LAB1:    return;
LAB3:    xsi_set_current_line(20, ng0);
    t5 = (t0 + 1032U);
    t6 = *((char **)t5);
    t5 = (t0 + 4396);
    t7 = *((int *)t5);
    t8 = (t7 - 7);
    t9 = (t8 * -1);
    xsi_vhdl_check_range_of_index(7, 0, -1, *((int *)t5));
    t10 = (1U * t9);
    t11 = (0 + t10);
    t12 = (t6 + t11);
    t13 = *((unsigned char *)t12);
    t14 = (t13 == (unsigned char)3);
    if (t14 != 0)
        goto LAB6;

LAB8:
LAB7:
LAB4:    t1 = (t0 + 4396);
    t3 = *((int *)t1);
    t2 = (t0 + 4400);
    t4 = *((int *)t2);
    if (t3 == t4)
        goto LAB5;

LAB9:    t7 = (t3 + 1);
    t3 = t7;
    t5 = (t0 + 4396);
    *((int *)t5) = t3;
    goto LAB2;

LAB6:    xsi_set_current_line(20, ng0);
    t15 = (t0 + 1488U);
    t16 = *((char **)t15);
    t17 = *((int *)t16);
    t18 = (t17 + 1);
    t15 = (t0 + 1488U);
    t19 = *((char **)t15);
    t15 = (t19 + 0);
    *((int *)t15) = t18;
    goto LAB7;

}


extern void work_a_2553508987_3212880686_init()
{
	static char *pe[] = {(void *)work_a_2553508987_3212880686_p_0};
	xsi_register_didat("work_a_2553508987_3212880686", "isim/calc_isim_beh.exe.sim/work/a_2553508987_3212880686.didat");
	xsi_register_executes(pe);
}
