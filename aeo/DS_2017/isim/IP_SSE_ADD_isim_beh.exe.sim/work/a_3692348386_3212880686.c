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
static const char *ng0 = "/home/parallels/Desktop/DS_2017/SSE_2ADD16.vhd";
extern char *IEEE_P_2592010699;



static void work_a_3692348386_3212880686_p_0(char *t0)
{
    char t4[16];
    char *t1;
    char *t2;
    char *t3;
    char *t5;
    char *t6;
    char *t7;
    char *t8;
    char *t9;
    char *t10;
    char *t11;
    char *t12;
    char *t13;

LAB0:    xsi_set_current_line(44, ng0);

LAB3:    t1 = (t0 + 1832U);
    t2 = *((char **)t1);
    t1 = (t0 + 1512U);
    t3 = *((char **)t1);
    t5 = ((IEEE_P_2592010699) + 4000);
    t6 = (t0 + 5832U);
    t7 = (t0 + 5816U);
    t1 = xsi_base_array_concat(t1, t4, t5, (char)97, t2, t6, (char)97, t3, t7, (char)101);
    t8 = (t0 + 3704);
    t9 = (t8 + 56U);
    t10 = *((char **)t9);
    t11 = (t10 + 56U);
    t12 = *((char **)t11);
    memcpy(t12, t1, 32U);
    xsi_driver_first_trans_fast_port(t8);

LAB2:    t13 = (t0 + 3624);
    *((int *)t13) = 1;

LAB1:    return;
LAB4:    goto LAB2;

}


extern void work_a_3692348386_3212880686_init()
{
	static char *pe[] = {(void *)work_a_3692348386_3212880686_p_0};
	xsi_register_didat("work_a_3692348386_3212880686", "isim/IP_SSE_ADD_isim_beh.exe.sim/work/a_3692348386_3212880686.didat");
	xsi_register_executes(pe);
}
