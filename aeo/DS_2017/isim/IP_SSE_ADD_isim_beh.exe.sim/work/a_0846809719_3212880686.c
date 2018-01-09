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
static const char *ng0 = "/home/parallels/Desktop/DS_2017/SSE_ADD.vhd";
extern char *IEEE_P_3620187407;

char *ieee_p_3620187407_sub_1496620905533649268_3965413181(char *, char *, char *, char *, char *, char *);


static void work_a_0846809719_3212880686_p_0(char *t0)
{
    char *t1;
    char *t2;
    char *t3;
    char *t4;
    int t5;
    char *t6;
    char *t7;
    int t8;
    char *t9;
    char *t10;
    char *t11;
    char *t12;
    char *t13;
    char *t14;
    char *t15;

LAB0:    t1 = (t0 + 3264U);
    t2 = *((char **)t1);
    if (t2 == 0)
        goto LAB2;

LAB3:    goto *t2;

LAB2:    xsi_set_current_line(43, ng0);
    t2 = (t0 + 1352U);
    t3 = *((char **)t2);
    t2 = (t0 + 6284);
    t5 = xsi_mem_cmp(t2, t3, 2U);
    if (t5 == 1)
        goto LAB5;

LAB8:    t6 = (t0 + 6286);
    t8 = xsi_mem_cmp(t6, t3, 2U);
    if (t8 == 1)
        goto LAB6;

LAB9:
LAB7:    xsi_set_current_line(44, ng0);
    t2 = (t0 + 6292);
    t4 = (t0 + 3928);
    t6 = (t4 + 56U);
    t7 = *((char **)t6);
    t9 = (t7 + 56U);
    t10 = *((char **)t9);
    memcpy(t10, t2, 2U);
    xsi_driver_first_trans_fast(t4);

LAB4:    xsi_set_current_line(43, ng0);

LAB13:    t2 = (t0 + 3832);
    *((int *)t2) = 1;
    *((char **)t1) = &&LAB14;

LAB1:    return;
LAB5:    xsi_set_current_line(44, ng0);
    t9 = (t0 + 6288);
    t11 = (t0 + 3928);
    t12 = (t11 + 56U);
    t13 = *((char **)t12);
    t14 = (t13 + 56U);
    t15 = *((char **)t14);
    memcpy(t15, t9, 2U);
    xsi_driver_first_trans_fast(t11);
    goto LAB4;

LAB6:    xsi_set_current_line(44, ng0);
    t2 = (t0 + 6290);
    t4 = (t0 + 3928);
    t6 = (t4 + 56U);
    t7 = *((char **)t6);
    t9 = (t7 + 56U);
    t10 = *((char **)t9);
    memcpy(t10, t2, 2U);
    xsi_driver_first_trans_fast(t4);
    goto LAB4;

LAB10:;
LAB11:    t3 = (t0 + 3832);
    *((int *)t3) = 0;
    goto LAB2;

LAB12:    goto LAB11;

LAB14:    goto LAB12;

}

static void work_a_0846809719_3212880686_p_1(char *t0)
{
    char t11[16];
    char *t1;
    char *t2;
    char *t3;
    char *t4;
    int t5;
    char *t6;
    int t7;
    char *t8;
    char *t9;
    char *t10;
    unsigned int t12;
    unsigned int t13;

LAB0:    xsi_set_current_line(50, ng0);
    t1 = xsi_get_transient_memory(32U);
    memset(t1, 0, 32U);
    t2 = t1;
    memset(t2, (unsigned char)2, 32U);
    t3 = (t0 + 2288U);
    t4 = *((char **)t3);
    t3 = (t4 + 0);
    memcpy(t3, t1, 32U);
    xsi_set_current_line(51, ng0);
    t1 = (t0 + 1672U);
    t2 = *((char **)t1);
    t1 = (t0 + 6294);
    t5 = xsi_mem_cmp(t1, t2, 2U);
    if (t5 == 1)
        goto LAB3;

LAB6:    t4 = (t0 + 6296);
    t7 = xsi_mem_cmp(t4, t2, 2U);
    if (t7 == 1)
        goto LAB4;

LAB7:
LAB5:    xsi_set_current_line(57, ng0);
    t1 = (t0 + 1032U);
    t2 = *((char **)t1);
    t1 = (t0 + 5984U);
    t3 = (t0 + 1192U);
    t4 = *((char **)t3);
    t3 = (t0 + 6000U);
    t6 = ieee_p_3620187407_sub_1496620905533649268_3965413181(IEEE_P_3620187407, t11, t2, t1, t4, t3);
    t8 = (t0 + 2288U);
    t9 = *((char **)t8);
    t8 = (t9 + 0);
    t10 = (t11 + 12U);
    t12 = *((unsigned int *)t10);
    t13 = (1U * t12);
    memcpy(t8, t6, t13);

LAB2:    t1 = (t0 + 3848);
    *((int *)t1) = 1;

LAB1:    return;
LAB3:    xsi_set_current_line(53, ng0);
    t8 = (t0 + 1832U);
    t9 = *((char **)t8);
    t8 = (t0 + 2288U);
    t10 = *((char **)t8);
    t8 = (t10 + 0);
    memcpy(t8, t9, 32U);
    goto LAB2;

LAB4:    xsi_set_current_line(55, ng0);
    t1 = (t0 + 1992U);
    t2 = *((char **)t1);
    t1 = (t0 + 2288U);
    t3 = *((char **)t1);
    t1 = (t3 + 0);
    memcpy(t1, t2, 32U);
    goto LAB2;

LAB8:;
}


extern void work_a_0846809719_3212880686_init()
{
	static char *pe[] = {(void *)work_a_0846809719_3212880686_p_0,(void *)work_a_0846809719_3212880686_p_1};
	xsi_register_didat("work_a_0846809719_3212880686", "isim/IP_SSE_ADD_isim_beh.exe.sim/work/a_0846809719_3212880686.didat");
	xsi_register_executes(pe);
}
