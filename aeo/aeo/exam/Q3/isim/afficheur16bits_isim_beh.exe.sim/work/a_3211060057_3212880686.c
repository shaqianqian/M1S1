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
static const char *ng0 = "/home/parallels/Desktop/TP_controle/compteur59/comp.vhd";
extern char *IEEE_P_3499444699;
extern char *IEEE_P_2592010699;

char *ieee_p_3499444699_sub_17544701978858283880_3536714472(char *, char *, int , int );


static void work_a_3211060057_3212880686_p_0(char *t0)
{
    char t15[16];
    char t16[16];
    char t17[16];
    char t18[16];
    char t22[16];
    char t24[16];
    char t29[16];
    unsigned char t1;
    char *t2;
    unsigned char t3;
    char *t4;
    char *t5;
    unsigned char t6;
    unsigned char t7;
    char *t8;
    int t9;
    unsigned char t10;
    char *t11;
    int t12;
    int t13;
    char *t14;
    char *t19;
    char *t20;
    char *t21;
    char *t23;
    char *t25;
    char *t26;
    int t27;
    char *t28;
    char *t30;
    char *t31;
    unsigned int t32;
    char *t33;
    unsigned int t34;
    unsigned int t35;
    char *t36;
    unsigned int t37;
    unsigned int t38;
    char *t39;
    unsigned int t40;
    unsigned int t41;
    char *t42;
    char *t43;
    char *t44;
    char *t45;
    char *t46;

LAB0:    xsi_set_current_line(24, ng0);
    t2 = (t0 + 992U);
    t3 = xsi_signal_has_event(t2);
    if (t3 == 1)
        goto LAB5;

LAB6:    t1 = (unsigned char)0;

LAB7:    if (t1 != 0)
        goto LAB2;

LAB4:
LAB3:    xsi_set_current_line(29, ng0);
    t2 = (t0 + 1608U);
    t4 = *((char **)t2);
    t9 = *((int *)t4);
    t2 = ieee_p_3499444699_sub_17544701978858283880_3536714472(IEEE_P_3499444699, t15, t9, 4);
    t5 = (t0 + 1728U);
    t8 = *((char **)t5);
    t12 = *((int *)t8);
    t5 = ieee_p_3499444699_sub_17544701978858283880_3536714472(IEEE_P_3499444699, t16, t12, 4);
    t14 = ((IEEE_P_2592010699) + 4000);
    t11 = xsi_base_array_concat(t11, t17, t14, (char)97, t2, t15, (char)97, t5, t16, (char)101);
    t19 = (t0 + 1848U);
    t20 = *((char **)t19);
    t13 = *((int *)t20);
    t19 = ieee_p_3499444699_sub_17544701978858283880_3536714472(IEEE_P_3499444699, t18, t13, 4);
    t23 = ((IEEE_P_2592010699) + 4000);
    t21 = xsi_base_array_concat(t21, t22, t23, (char)97, t11, t17, (char)97, t19, t18, (char)101);
    t25 = (t0 + 1968U);
    t26 = *((char **)t25);
    t27 = *((int *)t26);
    t25 = ieee_p_3499444699_sub_17544701978858283880_3536714472(IEEE_P_3499444699, t24, t27, 4);
    t30 = ((IEEE_P_2592010699) + 4000);
    t28 = xsi_base_array_concat(t28, t29, t30, (char)97, t21, t22, (char)97, t25, t24, (char)101);
    t31 = (t15 + 12U);
    t32 = *((unsigned int *)t31);
    t32 = (t32 * 1U);
    t33 = (t16 + 12U);
    t34 = *((unsigned int *)t33);
    t34 = (t34 * 1U);
    t35 = (t32 + t34);
    t36 = (t18 + 12U);
    t37 = *((unsigned int *)t36);
    t37 = (t37 * 1U);
    t38 = (t35 + t37);
    t39 = (t24 + 12U);
    t40 = *((unsigned int *)t39);
    t40 = (t40 * 1U);
    t41 = (t38 + t40);
    t1 = (16U != t41);
    if (t1 == 1)
        goto LAB11;

LAB12:    t42 = (t0 + 3344);
    t43 = (t42 + 56U);
    t44 = *((char **)t43);
    t45 = (t44 + 56U);
    t46 = *((char **)t45);
    memcpy(t46, t28, 16U);
    xsi_driver_first_trans_fast_port(t42);
    t2 = (t0 + 3264);
    *((int *)t2) = 1;

LAB1:    return;
LAB2:    xsi_set_current_line(25, ng0);
    t4 = (t0 + 1608U);
    t8 = *((char **)t4);
    t9 = *((int *)t8);
    t10 = (t9 < 9);
    if (t10 != 0)
        goto LAB8;

LAB10:
LAB9:    goto LAB3;

LAB5:    t4 = (t0 + 1032U);
    t5 = *((char **)t4);
    t6 = *((unsigned char *)t5);
    t7 = (t6 == (unsigned char)3);
    t1 = t7;
    goto LAB7;

LAB8:    xsi_set_current_line(26, ng0);
    t4 = (t0 + 1608U);
    t11 = *((char **)t4);
    t12 = *((int *)t11);
    t13 = (t12 + 1);
    t4 = (t0 + 1608U);
    t14 = *((char **)t4);
    t4 = (t14 + 0);
    *((int *)t4) = t13;
    goto LAB9;

LAB11:    xsi_size_not_matching(16U, t41, 0);
    goto LAB12;

}


extern void work_a_3211060057_3212880686_init()
{
	static char *pe[] = {(void *)work_a_3211060057_3212880686_p_0};
	xsi_register_didat("work_a_3211060057_3212880686", "isim/afficheur16bits_isim_beh.exe.sim/work/a_3211060057_3212880686.didat");
	xsi_register_executes(pe);
}
