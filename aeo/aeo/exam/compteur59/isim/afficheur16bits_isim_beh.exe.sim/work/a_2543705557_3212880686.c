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

/* This file is designed for use with ISim build 0xfbc00daa */

#define XSI_HIDE_SYMBOL_SPEC true
#include "xsi.h"
#include <memory.h>
#ifdef __GNUC__
#include <stdlib.h>
#else
#include <malloc.h>
#define alloca _alloca
#endif
static const char *ng0 = "/home/parallels/Desktop/TP_controle/compteur59/calc.vhd";
extern char *IEEE_P_3620187407;

char *ieee_p_3620187407_sub_2255506239096166994_3965413181(char *, char *, char *, char *, int );


static void work_a_2543705557_3212880686_p_0(char *t0)
{
    char t11[16];
    unsigned char t1;
    char *t2;
    unsigned char t3;
    char *t4;
    char *t5;
    unsigned char t6;
    unsigned char t7;
    char *t8;
    char *t9;
    char *t10;
    char *t12;
    char *t13;
    int t14;
    unsigned int t15;
    unsigned char t16;
    char *t17;
    char *t18;
    char *t19;
    unsigned int t20;

LAB0:    xsi_set_current_line(21, ng0);
    t2 = (t0 + 992U);
    t3 = xsi_signal_has_event(t2);
    if (t3 == 1)
        goto LAB5;

LAB6:    t1 = (unsigned char)0;

LAB7:    if (t1 != 0)
        goto LAB2;

LAB4:
LAB3:    xsi_set_current_line(30, ng0);
    t2 = (t0 + 1608U);
    t4 = *((char **)t2);
    t1 = *((unsigned char *)t4);
    t2 = (t0 + 2984);
    t5 = (t2 + 56U);
    t8 = *((char **)t5);
    t9 = (t8 + 56U);
    t10 = *((char **)t9);
    *((unsigned char *)t10) = t1;
    xsi_driver_first_trans_fast_port(t2);
    t2 = (t0 + 2904);
    *((int *)t2) = 1;

LAB1:    return;
LAB2:    xsi_set_current_line(22, ng0);
    t4 = (t0 + 1488U);
    t8 = *((char **)t4);
    t4 = (t0 + 4696U);
    t9 = (t0 + 4750);
    t12 = (t11 + 0U);
    t13 = (t12 + 0U);
    *((int *)t13) = 0;
    t13 = (t12 + 4U);
    *((int *)t13) = 27;
    t13 = (t12 + 8U);
    *((int *)t13) = 1;
    t14 = (27 - 0);
    t15 = (t14 * 1);
    t15 = (t15 + 1);
    t13 = (t12 + 12U);
    *((unsigned int *)t13) = t15;
    t16 = ieee_std_logic_unsigned_equal_stdv_stdv(IEEE_P_3620187407, t8, t4, t9, t11);
    if (t16 != 0)
        goto LAB8;

LAB10:    xsi_set_current_line(26, ng0);
    t2 = (t0 + 1608U);
    t4 = *((char **)t2);
    t2 = (t4 + 0);
    *((unsigned char *)t2) = (unsigned char)2;
    xsi_set_current_line(27, ng0);
    t2 = (t0 + 1488U);
    t4 = *((char **)t2);
    t2 = (t0 + 4696U);
    t5 = ieee_p_3620187407_sub_2255506239096166994_3965413181(IEEE_P_3620187407, t11, t4, t2, 1);
    t8 = (t0 + 1488U);
    t9 = *((char **)t8);
    t8 = (t9 + 0);
    t10 = (t11 + 12U);
    t15 = *((unsigned int *)t10);
    t20 = (1U * t15);
    memcpy(t8, t5, t20);

LAB9:    goto LAB3;

LAB5:    t4 = (t0 + 1032U);
    t5 = *((char **)t4);
    t6 = *((unsigned char *)t5);
    t7 = (t6 == (unsigned char)3);
    t1 = t7;
    goto LAB7;

LAB8:    xsi_set_current_line(23, ng0);
    t13 = xsi_get_transient_memory(28U);
    memset(t13, 0, 28U);
    t17 = t13;
    memset(t17, (unsigned char)2, 28U);
    t18 = (t0 + 1488U);
    t19 = *((char **)t18);
    t18 = (t19 + 0);
    memcpy(t18, t13, 28U);
    xsi_set_current_line(24, ng0);
    t2 = (t0 + 1608U);
    t4 = *((char **)t2);
    t2 = (t4 + 0);
    *((unsigned char *)t2) = (unsigned char)3;
    goto LAB9;

}


extern void work_a_2543705557_3212880686_init()
{
	static char *pe[] = {(void *)work_a_2543705557_3212880686_p_0};
	xsi_register_didat("work_a_2543705557_3212880686", "isim/afficheur16bits_isim_beh.exe.sim/work/a_2543705557_3212880686.didat");
	xsi_register_executes(pe);
}
