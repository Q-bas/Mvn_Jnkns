package excelStdy;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class dataDriven {

    //
    public ArrayList<String> getData(String testcaseName) throws IOException{


        //Create arraylist for data from .xslx
        ArrayList<String> a=new ArrayList<String>();
        // fileInputStream argument\\ create an object that will read testcase file
        FileInputStream fis = new FileInputStream("/Users/andrew/dev0/files/testcases1.xlsx");
        //create object for class XSSWorkbook
        XSSFWorkbook workbook = new XSSFWorkbook(fis);

        //count number of sheets
        int sheets = workbook.getNumberOfSheets();
        
        //itereate though file and find necessary sheet
        for(int i=0; i<sheets; i++){
            if (workbook.getSheetName(i).equalsIgnoreCase("sheet1")){
                //get acess to sheet
                XSSFSheet sheet =  workbook.getSheetAt(i);

                //identify row 
                Iterator<Row> rows = sheet.iterator();
                //get acess to specific row
                Row firstrow = rows.next();
                //scan row to get each cell in that row
                Iterator<Cell> ce = firstrow.cellIterator();
                //counter variable
                int k=0;
                //column index varaible
                int column=0;
                //reach each cell
                while(ce.hasNext()){
                    //grab cell
                    Cell value= ce.next();
                    //get string present in that cell
                    if(value.getStringCellValue()
                        //check if this cell contains necessary text
                        .equalsIgnoreCase("testcases")){
                            //lock required row->
                            //assign column = k. Because k will be 4 outside this while loop(number of all columns in the row)
                            column=k;
                    }
                    k++;
                }
                System.out.println(column);

                //iterate throug rows
                while(rows.hasNext()){
                    //move coursor to nex row
                    Row r = rows.next();
                    //find required row
                    if(r.getCell(column).getStringCellValue().equalsIgnoreCase(testcaseName)){
                        //iterate throug cells in that row
                        Iterator<Cell> cv= r.cellIterator();
                        while(cv.hasNext()){
                            Cell c = cv.next();
                            if(c.getCellType()==CellType.STRING){
                                //grab value of current cell and add to arraylist
                                a.add(c.getStringCellValue());
                            }
                            else{
                               a.add(NumberToTextConverter.toText(c.getNumericCellValue()));
                                
                            }
                            //

                        }
                    }
                }

            }
        }
        return a;

    }

    public static void main(String[] args) throws IOException {
        // debugging
        // dataDriven dd = new dataDriven();
        // ArrayList <String> data = dd.getData("purchase");
        // System.out.println(data);
    }
    
}
