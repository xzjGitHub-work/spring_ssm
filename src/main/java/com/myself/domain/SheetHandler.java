package com.myself.domain;

import lombok.SneakyThrows;
import org.apache.poi.xssf.eventusermodel.XSSFSheetXMLHandler;
import org.apache.poi.xssf.usermodel.XSSFComment;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 方法作用描述：解析器
 * SheetContentsHandler 接口在XSSFSheetXMLHandler 类中
 * 事件驱动的解析: 一行一行解析 每次只读取一行数据
 *
 * @param  :
 * @author xzj
 * @createDate 2020/8/31 15:04
 * @return
 */


public class SheetHandler implements XSSFSheetXMLHandler.SheetContentsHandler {

    private ContractProductVo contractProductVo = null; //临时对象
    static SimpleDateFormat simpleDateFormat = null;

    static {
        simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");//注意月份是MM
    }

    @Override
    public void startRow(int rowNum) {//解析每一行之前执行的方法  rowNum 解析的索引
        if (rowNum > 1) {//前两行标题不要
            contractProductVo = new ContractProductVo();//创建对象
        }
    }

    @Override
    public void endRow(int rowNum) {// 解析每一行之后执行的方法
        System.out.println(contractProductVo);//打印对象
    }

    /**
     * 解析每一个单元格的方法   这一行有多少单元格就执行多少次
     * 开始封装对象数据
     *
     * @param cellReference  单元格的指向(列名)  B1 B2 B3 B4  B100... 用来确定每一个数据的位置  B开头的就是 客户 C开头的就是订单号
     * @param formattedValue 单元格中的值部分
     * @param comment        单元格的注释
     */
    @SneakyThrows
    @Override
    public void cell(String cellReference, String formattedValue, XSSFComment comment) {
        if (contractProductVo != null) {//不是前两行
            //确定是哪一列
            String columnName = cellReference.substring(0, 1); //截取字符串 获得列的名称
            //根据已经得到的列 知道每一列的位置 属性
            switch (columnName) {
                case "B":
                    contractProductVo.setCustomName(formattedValue);
                    break;
                case "C":
                    contractProductVo.setContractNo(formattedValue);
                    break;
                case "D":
                    contractProductVo.setProductNo(formattedValue);
                    break;
                case "E":
                    contractProductVo.setCnumber(Integer.parseInt(formattedValue));
                    break;
                case "F":
                    contractProductVo.setFactoryName(formattedValue);
                    break;
                case "G":
                    Date date = simpleDateFormat.parse(formattedValue);
                    contractProductVo.setDeliveryPeriod(date);
                    break;
                case "H":
                    Date time = simpleDateFormat.parse(formattedValue);
                    contractProductVo.setShipTime(time);
                    break;
                case "I":
                    contractProductVo.setTradeTerms(formattedValue);
                    break;
            }
        }
    }
}
