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
static const char *ng0 = "/home/parallels/Desktop/DS_2017/SSE_4ADD8.vhd";
extern char *IEEE_P_2592010699;



static void work_a_2059075150_3212880686_p_0(char *t0)
{
    char t4[16];
    char t10[16];
    char t15[16];
    char *t1;
    char *t2;
    char *t3;
    char *t5;
    char *t6;
    char *t7;
    char *t8;
    char *t9;
    char *t11;
    char *t12;
    char *t13;
    char *t14;
    char *t16;
    char *t17;
    char *t18;
    char *t19;
    char *t20;
    char *t21;
    char *t22;
    char *t23;

LAB0:    xsi_set_current_line(64, ng0);

LAB3:    t1 = (t0 + 2472U);
    t2 = *((char **)t1);
    t1 = (t0 + 2152U);
    t3 = *((char **)t1);
    t5 = ((IEEE_P_2592010699) + 4000);
    t6 = (t0 + 6912U);
    t7 = (t0 + 6896U);
    t1 = xsi_base_array_concat(t1, t4, t5, (char)97, t2, t6, (char)97, t3, t7, (char)101);
    t8 = (t0 + 1832U);
    t9 = *((char **)t8);
    t11 = ((IEEE_P_2592010699) + 4000);
    t12 = (t0 + 6880U);
    t8 = xsi_base_array_concat(t8, t10, t11, (char)97, t1, t4, (char)97, t9, t12, (char)101);
    t13 = (t0 + 1512U);
    t14 = *((char **)t13);
    t16 = ((IEEE_P_2592010699) + 4000);
    t17 = (t0 + 6864U);
    t13 = xsi_base_array_concat(t13, t15, t16, (char)97, t8, t10, (char)97, t14, t17, (char)101);
    t18 = (t0 + 4344);
    t19 = (t18 + 56U);
    t20 = *((char **)t19);
    t21 = (t20 + 56U);
    t22 = *((char **)t21);
    memcpy(t22, t13, 32U);
    xsi_driver_first_trans_fast_port(t18);

LAB2:    t23 = (t0 + 4264);
    *((int *)t23) = 1;

LAB1:    return;
LAB4:    goto LAB2;

}


extern void work_a_2059075150_3212880686_init()
{
	static char *pe[] = {(void *)work_a_2059075150_3212880686_p_0};
	xsi_register_didat("work_a_2059075150_3212880686", "isim/IP_SSE_ADD_isim_beh.exe.sim/work/a_2059075150_3212880686.didat");
	xsi_register_executes(pe);
}
