/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Outil;
import java.awt.Color;  
import java.awt.Font;  
import java.text.DecimalFormat;  
import java.text.NumberFormat;  
 
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;  

import org.jfree.chart.plot.PiePlot3D;  
import org.jfree.chart.title.TextTitle;  
import org.jfree.data.general.DefaultPieDataset;  
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryAxis3D;
import org.jfree.chart.axis.NumberAxis3D;
import org.jfree.chart.axis.NumberTickUnit;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer3D;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author shaqianqian
 */
public class Diagram_algo {
    
public static void main(String[] args) {}
       public static void create_histogram(double negative,double positive,double neutre,String key_word) 
		// TODO Auto-generated method stub
       {DefaultCategoryDataset dataset=new DefaultCategoryDataset();
		//添加数据
	        dataset.addValue(negative, "negative", "");
		dataset.addValue(positive, "positive", "");
                dataset.addValue(neutre, "neutre", "");
	
		
		JFreeChart chart=ChartFactory.createBarChart3D(
				key_word,
				"Feeling",//X轴的标签 
                "Quantité",//Y轴的标签 
                dataset, //图标显示的数据集合
                PlotOrientation.VERTICAL, //图像的显示形式（水平或者垂直）
                true,//是否显示子标题 
                true,//是否生成提示的标签 
                true); //是否生成URL链接		
		       //处理图形上的乱码
				//处理主标题的乱码
				chart.getTitle().setFont(new Font("宋体",Font.BOLD,18));
				//处理子标题乱码
				chart.getLegend().setItemFont(new Font("宋体",Font.BOLD,15));
				//获取图表区域对象
				CategoryPlot categoryPlot = (CategoryPlot)chart.getPlot();
				//获取X轴的对象
				CategoryAxis3D categoryAxis3D = (CategoryAxis3D)categoryPlot.getDomainAxis();
				//获取Y轴的对象
				NumberAxis3D numberAxis3D = (NumberAxis3D)categoryPlot.getRangeAxis();
				//处理X轴上的乱码
				categoryAxis3D.setTickLabelFont(new Font("宋体",Font.BOLD,5));
				//处理X轴外的乱码
				categoryAxis3D.setLabelFont(new Font("宋体",Font.BOLD,15));
				//处理Y轴上的乱码
				numberAxis3D.setTickLabelFont(new Font("宋体",Font.BOLD,15));
				//处理Y轴外的乱码
				numberAxis3D.setLabelFont(new Font("宋体",Font.BOLD,15));
				//处理Y轴上显示的刻度，以10作为1格
				numberAxis3D.setAutoTickUnitSelection(false);
				NumberTickUnit unit = new NumberTickUnit(5);
				numberAxis3D.setTickUnit(unit);
                                //numberAxis3D.setTickLabelsVisible(true);
				//获取绘图区域对象
				categoryAxis3D.setUpperMargin(0.2);//设置柱状体与边缘的距离
                                categoryAxis3D.setLowerMargin(0.2);
                                BarRenderer3D barRenderer3D = (BarRenderer3D)categoryPlot.getRenderer();
				//设置柱形图的宽度
				barRenderer3D.setMaximumBarWidth(0.08);
				//在图形上显示数字
				barRenderer3D.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator());
				barRenderer3D.setBaseItemLabelsVisible(true);
				barRenderer3D.setBaseItemLabelFont(new Font("宋体",Font.BOLD,15));
	                        barRenderer3D.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator()); 
				barRenderer3D.setBaseItemLabelsVisible(true); 
                               barRenderer3D.setBaseItemLabelPaint(Color.black);//设置数值颜色，默认黑色
				//使用ChartFrame对象显示图像
				ChartFrame frame = new ChartFrame("annontion",chart);
				frame.setVisible(true);
				frame.pack();
	}


    
    
    
    
   // public static void main(String[] args)   
    public static void create_camembre(double negative,double positive,double neutre,String key_word) 
    {     
        //设置数据源   
        DefaultPieDataset mDataset = new DefaultPieDataset(); 
        //PieDataset mDataset = GetDataset();
                
        mDataset.setValue(" Negative", negative);   
        mDataset.setValue(" Positive", positive);   
        mDataset.setValue(" Neutre", neutre);  
        //建立图表  
        JFreeChart mChart = ChartFactory.createPieChart3D("Annotations", mDataset, true, true, false);         
          
        ////////////////////整体图表的设置/////////////////////////////////////  
        //设置背景为白色(默认为灰色)  
        mChart.setBackgroundPaint(Color.white);  
        //设置图表题的字体  
        Font mFont = new Font("黑体",Font.CENTER_BASELINE, 20);   
        //设置标题  
        TextTitle mTextTitle = new TextTitle(key_word);  
        mTextTitle.setFont(mFont);  //标题设置字体  
        mChart.setTitle(mTextTitle);    //图表设置标题  
          
        //mChart.setTitle(new TextTitle("项目状态分布", new Font("黑体",Font.CENTER_BASELINE, 20)));  
        //getLegend获取饼图底部图例，并设置字体  
        mChart.getLegend().setItemFont(new Font("宋体", Font.ROMAN_BASELINE, 15));  
        /////////选做设置////////  
        //设置副标题  
        //mChart.addSubtitle(new TextTitle("子标题"));  
        //设置字体边界模糊,默认为true，即模糊  
        //mChart.setTextAntiAlias(false);         
          
        ////////////////////绘制图表及设置///////////////////////////////////  
        PiePlot3D mPiePlot = (PiePlot3D)mChart.getPlot();  
        //以默认方式显示百分比  
        //mPiePlot.setLabelGenerator(new StandardPieSectionLabelGenerator(StandardPieToolTipGenerator.DEFAULT_TOOLTIP_FORMAT));  
        // 图片中显示百分比:自定义方式，{0} 表示选项， {1} 表示数值， {2} 表示所占比例 ,小数点后两位  
          mPiePlot.setLabelGenerator(new StandardPieSectionLabelGenerator("{0}={1}({2})", NumberFormat.getNumberInstance(), new DecimalFormat("0.00%")));  
        // 底部图例显示百分比:自定义方式， {0} 表示选项， {1} 表示数值， {2} 表示所占比例   
        mPiePlot.setLegendLabelGenerator(new StandardPieSectionLabelGenerator("{0}={1}({2})"));  
        // 指定图片的透明度(0.0-1.0)   
        //mPiePlot.setBackgroundImageAlpha(1.0f);  
        // 指定显示的饼图上圆形(false)还椭圆形(true) 默认为true  
        mPiePlot.setCircular(true);  
        //设置饼图标签字体  
        mPiePlot.setLabelFont(new Font("宋体", Font.PLAIN, 15));  
        ////////选做设置///////  
        //设置饼图背景颜色，默认为LIGHT_GRAY  
        mPiePlot.setBackgroundPaint(Color.ORANGE);  
          
          
        //内置对象显示图表  
        ChartFrame mChartFrame = new ChartFrame("Annotion", mChart);  
        mChartFrame.pack();  
        mChartFrame.setVisible(true);  
          
        /*输出图片 
        FileOutputStream fos = null;     
        try { 
            fos = new FileOutputStream("E:\\项目状态分布.jpg"); 
            ChartUtilities.writeChartAsJPEG(fos, mChart, 800, 500); 
            fos.close(); 
            System.out.println("完成！"); 
        } catch (Exception e) { 
            // TODO Auto-generated catch block 
            e.printStackTrace(); 
        } 
        */  
    }  
//    public static PieDataset GetDataset()  
//    {  
//       
//        return mDataset;  
//    }  
}
