package com.atguigu.yygh.common.utils;

import com.spire.pdf.FileFormat;
import com.spire.pdf.PdfDocument;
import com.spire.pdf.PdfPageBase;
import com.spire.pdf.fields.*;
import com.spire.pdf.graphics.*;

import java.awt.Color;
import java.awt.Font;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

public class AddFormFieldsToPdf {
    public static void main(String[] args) throws Exception {

        //创建PdfDocument对象，并添加页面
        PdfDocument doc = new PdfDocument();
        PdfPageBase page = doc.getPages().add();

        //初始化位置变量
        float baseX = 100;
        float baseY = 0;

        //创建画刷对象
        PdfSolidBrush brush1 = new PdfSolidBrush(new PdfRGBColor(Color.BLUE));
        PdfSolidBrush brush2 = new PdfSolidBrush(new PdfRGBColor(Color.black));
        PdfSolidBrush brush3 = new PdfSolidBrush(new PdfRGBColor(Color.RED));

        //创建TrueType字体
        PdfTrueTypeFont font= new PdfTrueTypeFont(new Font("等线",Font.PLAIN, 10),true);
        PdfTrueTypeFont font1= new PdfTrueTypeFont(new Font("等线",Font.PLAIN, 20),true);

        //添加文本框
        String text = "";//添加文本
        page.getCanvas().drawString(text, font, brush2, new Point2D.Float(60, 80));//在PDF中绘制文字
        page.getCanvas().drawString("大数据授权协议",font1, brush2,  new Point2D.Float(200, 40));
        page.getCanvas().drawString("确认人：",font, brush2,  new Point2D.Float(320, 600));
        page.getCanvas().drawString("身份证号码：",font, brush2,  new Point2D.Float(320, 615));
        page.getCanvas().drawString("确认日期：",font, brush2,  new Point2D.Float(320, 630));
        Rectangle2D.Float tbxBounds = new Rectangle2D.Float(380, 600 , 150, 15);//创建Rectangle2D对象
        PdfTextBoxField textBox = new PdfTextBoxField(page, "TextBox");//创建文本框对象
        textBox.setBounds(tbxBounds);//设置文本框的Bounds
//        textBox.setText("刘兴");//填充文本框
        textBox.setFont(font);//应用文本框的字体
        Rectangle2D.Float tbxBounds1 = new Rectangle2D.Float(380, 615 , 150, 15);//创建Rectangle2D对象
        PdfTextBoxField textBox1 = new PdfTextBoxField(page, "TextBox");//创建文本框对象
        textBox1.setBounds(tbxBounds1);//设置文本框的Bounds
//        textBox.setText("刘兴");//填充文本框
        textBox1.setFont(font);//应用文本框的字体
        Rectangle2D.Float tbxBounds2 = new Rectangle2D.Float(380, 630 , 150, 15);//创建Rectangle2D对象
        PdfTextBoxField textBox2 = new PdfTextBoxField(page, "TextBox");//创建文本框对象
        textBox2.setBounds(tbxBounds2);//设置文本框的Bounds
//        textBox.setText("刘兴");//填充文本框
        textBox2.setFont(font);//应用文本框的字体
        doc.getForm().getFields().add(textBox);//添加文本框到PDF域的集合
        doc.getForm().getFields().add(textBox1);//添加文本框到PDF域的集合
        doc.getForm().getFields().add(textBox2);//添加文本框到PDF域的集合
//        baseY +=25;

//        //添加复选框
//        page.getCanvas().drawString("所在院系：", font, brush1, new Point2D.Float(0, baseY));
//        java.awt.geom.Rectangle2D.Float rec1 = new java.awt.geom.Rectangle2D.Float(baseX, baseY, 15, 15);
//        PdfCheckBoxField checkBoxField = new PdfCheckBoxField(page, "CheckBox1");//创建第一个复选框对象
//        checkBoxField.setBounds(rec1);
//        checkBoxField.setChecked(false);//填充复选框
//        page.getCanvas().drawString("经管系", font, brush2, new Point2D.Float(baseX + 20, baseY));
//        java.awt.geom.Rectangle2D.Float rec2 = new java.awt.geom.Rectangle2D.Float(baseX + 70, baseY, 15, 15);
//        PdfCheckBoxField checkBoxField1 = new PdfCheckBoxField(page, "CheckBox2");//创建第二个复选框对象
//        checkBoxField1.setBounds(rec2);
//        checkBoxField1.setChecked(true);//填充复选框
//        page.getCanvas().drawString("创新班", font,  brush2, new Point2D.Float(baseX+90, baseY));
//        doc.getForm().getFields().add(checkBoxField);//添加复选框到PDF
//        baseY += 25;
//
//        //添加列表框
//        page.getCanvas().drawString("录取批次：", font, brush1, new Point2D.Float(0, baseY));
//        java.awt.geom.Rectangle2D.Float rec = new java.awt.geom.Rectangle2D.Float(baseX, baseY, 150, 50);
//        PdfListBoxField listBoxField = new PdfListBoxField(page, "ListBox");//创建列表框对象
//        listBoxField.getItems().add(new PdfListFieldItem("第一批次", "item1"));
//        listBoxField.getItems().add(new PdfListFieldItem("第二批次", "item2"));
//        listBoxField.getItems().add(new PdfListFieldItem("第三批次", "item3"));;
//        listBoxField.setBounds(rec);
//        listBoxField.setFont(font);
//        listBoxField.setSelectedIndex(0);//填充列表框
//        doc.getForm().getFields().add(listBoxField);//添加列表框到PDF
//        baseY += 60;
//
//        //添加单选按钮
//        page.getCanvas().drawString("招收方式：", font, brush1, new Point2D.Float(0, baseY));
//        PdfRadioButtonListField radioButtonListField = new PdfRadioButtonListField(page, "Radio");//创建单选按钮对象
//        PdfRadioButtonListItem radioItem1 = new PdfRadioButtonListItem("Item1");//创建第一个单选按钮
//        radioItem1.setBounds(new Rectangle2D.Float(baseX, baseY, 15, 15));
//        page.getCanvas().drawString("全日制", font, brush2, new Point2D.Float(baseX + 20, baseY));
//        PdfRadioButtonListItem radioItem2 = new PdfRadioButtonListItem("Item2");//创建第二个单选按钮
//        radioItem2.setBounds(new Rectangle2D.Float(baseX + 70, baseY, 15, 15));
//        page.getCanvas().drawString("成人教育", font, brush2, new Point2D.Float(baseX + 90, baseY));
//        radioButtonListField.getItems().add(radioItem1);
//        radioButtonListField.getItems().add(radioItem2);
//        radioButtonListField.setSelectedIndex(0);//选择填充第一个单选按钮
//        doc.getForm().getFields().add(radioButtonListField);//添加单选按钮到PDF
//        baseY += 25;
//
//        //添加组合框
//        page.getCanvas().drawString("最高学历：", font, brush1, new Point2D.Float(0, baseY));
//        Rectangle2D.Float cmbBounds = new Rectangle2D.Float(baseX, baseY, 150, 15);//创建cmbBounds对象
//        PdfComboBoxField comboBoxField = new PdfComboBoxField(page, "ComboBox");//创建comboBoxField对象
//        comboBoxField.setBounds(cmbBounds);
//        comboBoxField.getItems().add(new PdfListFieldItem("博士", "item1"));
//        comboBoxField.getItems().add(new PdfListFieldItem("硕士", "itme2"));
//        comboBoxField.getItems().add(new PdfListFieldItem("本科", "item3"));
//        comboBoxField.getItems().add(new PdfListFieldItem("大专", "item4"));
//        comboBoxField.setSelectedIndex(0);
//        comboBoxField.setFont(font);
//        doc.getForm().getFields().add(comboBoxField);//添加组合框到PDF
//        baseY += 25;
//
//        //添加签名域
//        page.getCanvas().drawString("本人签字确认\n以上信息属实：", font, brush1, new Point2D.Float(0, baseY));
//        PdfSignatureField sgnField= new PdfSignatureField(page,"sgnField");//创建sgnField对象
//        Rectangle2D.Float sgnBounds = new Rectangle2D.Float(baseX, baseY, 150, 80);//创建sgnBounds对象
//        sgnField.setBounds(sgnBounds);
//        doc.getForm().getFields().add(sgnField);//添加sgnField到PDF
//        baseY += 90;
//
//        //添加按钮
//        page.getCanvas().drawString("", font, brush1, new Point2D.Float(0, baseY));
//        Rectangle2D.Float btnBounds = new Rectangle2D.Float(baseX, baseY, 50, 15);//创建btnBounds对象
//        PdfButtonField buttonField = new PdfButtonField(page, "Button");//创建buttonField对象
//        buttonField.setBounds(btnBounds);
//        buttonField.setText("提交");//设置按钮显示文本
//        buttonField.setFont(font);
//        doc.getForm().getFields().add(buttonField);//添加按钮到PDF

        //保存文档
        doc.saveToFile("d:\\result2.pdf", FileFormat.PDF);
    }
}
