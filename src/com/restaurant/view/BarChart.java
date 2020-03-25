package com.restaurant.view;

import java.awt.Font;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

class BarChart {
    ChartPanel frame1;
    public static final String driver = "com.mysql.jdbc.Driver";
    public static final String url = "jdbc:mysql://localhost:3306/mydb";
    public static final String user = "root";
    public static final String password = "1492949670";
    //定义操作数据库需要的变量
    static PreparedStatement ps = null;
    static java.sql.Connection ct = null;
    static ResultSet rs = null;
    public  BarChart(int[] price,String[] nianyue){
        CategoryDataset dataset = getDataSet(price,nianyue);
        JFreeChart chart = ChartFactory.createBarChart3D(
                "汐语斋销售分析", // 图表标题
                "月份", // 目录轴的显示标签
                "销售额", // 数值轴的显示标签
                dataset, // 数据集
                PlotOrientation.VERTICAL, // 图表方向：水平、垂直
                true,           // 是否显示图例(对于简单的柱状图必须是false)
                false,          // 是否生成工具
                false           // 是否生成URL链接
        );

        //开始
        CategoryPlot plot=chart.getCategoryPlot();//获取图表区域对象
        CategoryAxis domainAxis=plot.getDomainAxis();         //水平底部列表
        domainAxis.setLabelFont(new Font("楷体",Font.BOLD,14));         //水平底部标题
        domainAxis.setTickLabelFont(new Font("楷体",Font.BOLD,12));  //垂直标题
        ValueAxis rangeAxis=plot.getRangeAxis();//获取柱状
        rangeAxis.setLabelFont(new Font("楷体",Font.BOLD,15));
        chart.getLegend().setItemFont(new Font("楷体", Font.BOLD, 15));
        chart.getTitle().setFont(new Font("楷体",Font.BOLD,20));//设置标题字体

        //结束，解决汉字乱码问题

        frame1=new ChartPanel(chart,true);        //这里也可以用chartFrame,可以直接生成一个独立的Frame

    }
    private static CategoryDataset getDataSet(int[] price,String[] nianyue) {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        for(int i =1;i<=12;i++){
            dataset.addValue(price[i],nianyue[i],nianyue[i]);
        }
        return dataset;
    }
    public ChartPanel getChartPanel(){
        return frame1;
    }
}