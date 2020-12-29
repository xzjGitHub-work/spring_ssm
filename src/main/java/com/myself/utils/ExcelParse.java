package com.myself.utils;

import com.myself.domain.ContractProductVo;
import com.myself.domain.SheetHandler;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.openxml4j.opc.PackageAccess;
import org.apache.poi.xssf.eventusermodel.XSSFReader;
import org.apache.poi.xssf.eventusermodel.XSSFSheetXMLHandler;
import org.apache.poi.xssf.model.SharedStringsTable;
import org.apache.poi.xssf.model.StylesTable;
import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;
import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.InputStream;

/**
 * 方法作用描述
 *
 * @param  :
 * @author xzj
 * @createDate 2020/8/31 15:04
 * @return
 */

public class ExcelParse {

    public void parse(MultipartFile file) throws Exception {
        //解析器
        SheetHandler hl = new SheetHandler();
//        MultipartFile file = null;
        Resource resource = file.getResource();
        String description = resource.getDescription();
        //1.根据 Excel 获取 OPCPackage 对象
        OPCPackage pkg = OPCPackage.open(description, PackageAccess.READ);
        try {
            //2.创建 XSSFReader 对象
            XSSFReader reader = new XSSFReader(pkg);
            //3.获取 SharedStringsTable 对象
            SharedStringsTable sst = reader.getSharedStringsTable();
            //4.获取 StylesTable 对象
            StylesTable styles = reader.getStylesTable();
            XMLReader parser = XMLReaderFactory.createXMLReader();
            // 处理公共属性
            parser.setContentHandler(new XSSFSheetXMLHandler(styles, sst, hl, false));
            XSSFReader.SheetIterator sheets = (XSSFReader.SheetIterator)reader.getSheetsData();
            //逐行读取逐行解析
            while (sheets.hasNext()) {
                InputStream sheetstream = sheets.next();
                InputSource sheetSource = new InputSource(sheetstream);
                try {
                    parser.parse(sheetSource);
                } finally {
                    sheetstream.close();
                }
            }
        } finally {
            pkg.close();
        }
    }
}
