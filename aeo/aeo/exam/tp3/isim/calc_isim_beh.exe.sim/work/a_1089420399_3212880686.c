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
static const char *ng0 = "/home/l3/sha/Bureau/TP2/parite.vhd";
extern char *IEEE_P_2592010699;

unsigned char ieee_p_2592010699_sub_3488768497506413324_503743352(char *, unsigned char , unsigned char );


static void work_a_1089420399_3212880686_p_0(char *t0)
{
    char *t1;
    char *t2;
    int t3;
    int t4;
    char *t5;
    char *t6;
    unsigned char t7;
    char *t8;
    int t9;
    int t10;
    unsigned int t11;
    unsigned int t12;
    unsigned int t13;
    char *t14;
    unsigned char t15;
    unsigned char t16;
    char *t17;
    char *t18;

LAB0:    xsi_set_current_line(17, ng0);
    t1 = (t0 + 1488U);
    t2 = *((char **)t1);
    t1 = (t2 + 0);
    *((unsigned char *)t1) = (unsigned char)2;
    xsi_set_current_line(18, ng0);
    t1 = (t0 + 4361);
    *((int *)t1) = 0;
    t2 = (t0 + 4365);
    *((int *)t2) = 7;
    t3 = 0;
    t4 = 7;

LAB2:    if (t3 <= t4)
        goto LAB3;

LAB5:    xsi_set_current_line(21, ng0);
    t1 = (t0 + 1488U);
    t2 = *((char **)t1);
    t7 = *((unsigned char *)t2);
    t1 = (t0 + 2864);
    t5 = (t1 + 56U);
    t6 = *((char **)t5);
    t8 = (t6 + 56U);
    t14 = *((char **)t8);
    *((unsigned char *)t14) = t7;
    xsi_driver_first_trans_fast_port(t1);
    t1 = (t0 + 2784);
    *((int *)t1) = 1;

LAB1:    return;
LAB3:    xsi_set_current_line(19, ng0);
    t5 = (t0 + 1488U);
    t6 = *((char **)t5);
    t7 = *((unsigned char *)t6);
    t5 = (t0 + 1032U);
    t8 = *((char **)t5);
    t5 = (t0 + 4361);
    t9 = *((int *)t5);
    t10 = (t9 - 7);
    t11 = (t10 * -1);
    xsi_vhdl_check_range_of_index(7, 0, -1, *((int *)t5));
    t12 = (1U * t11);
    t13 = (0 + t12);
    t14 = (t8 + t13);
    t15 = *((unsigned char *)t14);
    t16 = ieee_p_2592010699_sub_3488768497506413324_503743352(IEEE_P_2592010699, t7, t15);
    t17 = (t0 + 1488U);
    t18 = *((char **)t17);
    t17 = (t18 + 0);
    *((unsigned char *)t17) = t16;

LAB4:    t1 = (t0 + 4361);
    t3 = *((int *)t1);
    t2 = (t0 + 4365);
    t4 = *((int *)t2);
    if (t3 == t4)
        goto LAB5;

LAB6:    t9 = (t3 + 1);
    t3 = t9;
    t5 = (t0 + 4361);
    *((int *)t5) = t3;
    goto LAB2;

}


extern void work_a_1089420399_3212880686_init()
{
	static char *pe[] = {(void *)work_a_1089420399_3212880686_p_0};
	xsi_register_didat("work_a_1089420399_3212880686", "isim/calc_isim_beh.exe.sim/work/a_1089420399_3212880686.didat");
	xsi_register_executes(pe);
}
