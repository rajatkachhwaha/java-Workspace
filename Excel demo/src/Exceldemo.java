
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;


import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.json.JSONObject;



public class Exceldemo {

	final static String jsonOpenBrack 		="[";
	final static String jsonClosedBrack 	="]";
	final static String jsonOpenCurly	 	="{";
	final static String jsonClosedCurly 	="}";
	final static String jsonComma           =",";
	     
	static ArrayList<String> headers= new ArrayList<String>();
	static int maxcells;
	public static void main(String[] args) 
	{

		try
		{
			FileInputStream file = new FileInputStream(new File("demorace.xlsx"));

	//Create Workbook instance holding reference to .xlsx file
			XSSFWorkbook workbook = new XSSFWorkbook(file);

			//Get first/desired sheet from the workbook
			XSSFSheet sheet = workbook.getSheetAt(0);
            maxcells=sheet.getRow(0).getLastCellNum();
            System.out.println(maxcells);
			//Iterate through each rows one by one
			Iterator<Row> rowIterator = sheet.iterator();
			
			WriteColumnHeaders(rowIterator);
			WriteColumnData(rowIterator);
			
			
		
				
			file.close();
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}// end of main function

	private static void WriteColumnData(Iterator<Row> rowIterator) {
		// TODO Auto-generated method stub
		//int columnIndex = 0, rowIndex= 0;
		String cellData="";
		String jsonstring = ""; 
		String jsonfinal = "";
		
		jsonfinal +=jsonOpenBrack;
		
		while(rowIterator.hasNext())
		{
			Row row= rowIterator.next();
			if(row.getRowNum()==0){
				continue;
			}
			jsonfinal+=jsonOpenCurly;
			for(int i=0;i<maxcells;i++){
				
			Cell cell=row.getCell(i, Row.CREATE_NULL_AS_BLANK);	
			
			if(cell==null)
			{
				cellData="No values";
					
			}//end of if
			else
			{
				switch(cell.getCellType()){
				case Cell.CELL_TYPE_NUMERIC:
					if (DateUtil.isCellDateFormatted(cell)) {
                      cellData=(new SimpleDateFormat("MM-dd-yyyy").format(cell.getDateCellValue()));
                    } else {
                    	String str = NumberToTextConverter.toText(cell.getNumericCellValue());
                   	     cellData=str;
                    }
					break;
				case Cell.CELL_TYPE_STRING:
					
					 cellData=(cell.getStringCellValue()) ;
					break;							
				case Cell.CELL_TYPE_FORMULA:
					cellData=(cell.getCellFormula());
				    
				    
				case Cell.CELL_TYPE_BLANK:
					cellData="No Value";
					break;
				
				}
			}//end of else
			//System.out.println(headers.get(cell.getColumnIndex()));	
			jsonstring += "\"" +headers.get(i) +"\" : " +"\"" +cellData + "\"" ;	
			
			if(i<maxcells-1)
			{
				jsonstring += jsonComma;	
			}
			
			
			}//end of for
			
			
			
			
			jsonstring+= jsonClosedCurly;
			
			if(rowIterator.hasNext())
			{
				jsonstring+= jsonComma;
			}
			jsonfinal+=jsonstring;
			jsonstring ="";
		}//End of row Iterator
		jsonfinal+=jsonClosedBrack;
		System.out.println(jsonfinal);
	}// end of WriteColumnData


	public static  void WriteColumnHeaders(Iterator<Row> rowIterator) {
		// TODO Auto-generated method stub
		
		
			int columnIndex = 0, rowIndex= 0;
			String cellData="";
			String jsonstring = ""; 
			String jsonfinal = "";
			
			jsonfinal += jsonOpenBrack;
			//Get Header Row
			Row row = rowIterator.next();
			if (row != null)
			{
				//Got Header, iterate through all the columns
				Iterator<Cell> cellIterator = row.cellIterator();
				while (cellIterator.hasNext()) 
				{
					Cell cell = cellIterator.next();
					columnIndex = cell.getColumnIndex();
					rowIndex = cell.getRowIndex();
					 
					switch (cell.getCellType()) 
					{
						case Cell.CELL_TYPE_NUMERIC:
		                    cellData = (Double.toString (cell.getNumericCellValue()));
							break;
						case Cell.CELL_TYPE_STRING:
							cellData = (cell.getStringCellValue());	
							break;
					}
					
					
					headers.add(cellData);
					
					//Lets build up the json column header string
					jsonstring =  jsonOpenCurly + "\"Row_Id\" :\"" + Integer.toString(rowIndex) + "\""
															   + ",\"Col_Id\":\"" +Integer.toString(columnIndex) + "\""
															   + ",\"Header_Name\":\"" + cellData +"\"" 
															   + jsonClosedCurly; 
					
					
					jsonfinal +=jsonstring;
					
					
					//If there is another cell, add comma
					if(cellIterator.hasNext())
						jsonfinal += jsonComma ;
				}
				
				for(String obj:headers){
					System.out.println(obj);
				}
				
				jsonfinal += jsonClosedBrack;
			
				//System.out.println(jsonfinal);
				
			} //end of if
	    }//end of function
	} //end of main class
