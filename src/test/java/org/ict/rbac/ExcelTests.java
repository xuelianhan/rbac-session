package org.ict.rbac;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;


/**
 * Created by joshuazhang on 14-8-15.
 */
public class ExcelTests {
    
	/**
	 * beijing(110000, 11, "");
	 * @throws InvalidFormatException
	 * @throws IOException
	 */
    @Test
    public void readExcel() throws InvalidFormatException, IOException {
        InputStream  in  = new FileInputStream(new File("D:\\cityId-gbCode-mapping.xlsx"));
        Workbook wb = WorkbookFactory.create(in);
        Sheet sheet = wb.getSheetAt(0);
        int rows = sheet.getPhysicalNumberOfRows();
        Row row;
        DataFormatter formatter = new DataFormatter();
        PinYinTool tool = new PinYinTool();
        //Set<String> callOutPhones = new HashSet<String>();
        for(int r = 1; r < rows; r++) {
            row = sheet.getRow(r);
            if(row != null) {
                //只取第一列的手机号码
                Cell cell0 = row.getCell(0);
                Cell cell1 = row.getCell(1);
                Cell cell2 = row.getCell(2);
               
                /**
                 * Cannot get a text value from a numeric cell
                 * http://stackoverflow.com/questions/30125465/cannot-get-a-text-value-from-a-numeric-cell-poi
                 */
                String seq  = formatter.formatCellValue(cell0);
                String gbCode  = formatter.formatCellValue(cell1);
                String cityChineseName  = formatter.formatCellValue(cell2);
                String cityName = "test";
				try {
					cityName = tool.toPinYin(cityChineseName, "", PinYinTool.Type.LOWERCASE);
				} catch (BadHanyuPinyinOutputFormatCombination e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
                //callOutPhones.add(seq);
				int len = cityName.length();
				String cityNewName = cityName.substring(0, len - 3);
                System.out.println(cityNewName + "(" + gbCode + ", " + seq + ", \"" +cityChineseName+ "\"),");
            }
        }
        System.out.println("rows:"+ rows);
		/*
		 * for(String s : callOutPhones) { System.out.
		 * println("delete from chasing_auto_close_whitelist where hotel_seq='"+s+"';");
		 * }
		 */
    }

	
	@Test
	public void testAddNull() {
		List<String> l1 = new ArrayList<String>();
		List<String> l2 = null;
		l1.addAll(l2);
	}

}
