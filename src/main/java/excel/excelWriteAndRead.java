package excel;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.write.metadata.WriteSheet;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang.StringUtils;
import org.apache.poi.util.StringUtil;
import org.ttzero.excel.entity.ListSheet;
import org.ttzero.excel.entity.Workbook;
import org.ttzero.excel.reader.ExcelReader;
import org.ttzero.excel.reader.Row;
import org.ttzero.excel.reader.Sheet;

import java.io.IOException;
import java.nio.file.Paths;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class excelWriteAndRead {


  /**
   * 10000 数据，371毫秒
   * @param students
   * @throws IOException
   */
  public static void testEccWrite(List<Student> students) throws IOException {
    // 创建一个名为"test object"的excel文件，指定作者，不指定时默认取系统登陆名
    new Workbook("test object", "guanquan.wang")

      // 添加一个worksheet，可以通过addSheet添加多个worksheet
      .addSheet(new ListSheet<>("学生信息", students))

      // 指定输出位置，如果做文件导出可以直接输出到`respone.getOutputStream()`
      .writeTo(Paths.get("/Users/happyelements/Desktop/excel.xlsx"));
  }
  /*
   10000 数据 spend time=2007
   */
  public static void simpleWrite(List<Student> students) {
    // 写法1
    String fileName = "/Users/happyelements/Desktop/"+ "easyExcel" + System.currentTimeMillis() + ".xlsx";
    // 这里 需要指定写用哪个class去写，然后写到第一个sheet，名字为模板 然后文件流会自动关闭
    // 如果这里想使用03 则 传入excelType参数即可
    EasyExcel.write(fileName, Student.class).sheet("模板").doWrite(students);

  }

  public static void read(String path) throws IOException {
//    try (ExcelReader reader = ExcelReader.read(Paths.get(path))) {
//      reader.sheets() // 所有worksheet
//        .flatMap(Sheet::dataRows)
//        .filter(row -> row.getRowNumber() > 1)// 去掉表头和空行
//        .map(row -> HecActionPlanApFormEntity.builder().apId(apId).uniqueId(row.getString(0))
//          .score(row.getInt(1)).assessContent(row.getString(2)).build())
//        .toArray(HecActionPlanApFormEntity[]::new);
      try (ExcelReader reader = ExcelReader.read(Paths.get(path))) {
        Sheet sheet = reader.sheet(0);
        System.out.println("count = "+sheet.getDimension().getLastRow());
        for (Iterator<Row> it = sheet.iterator(); it.hasNext(); ) {
          Row row = it.next();
          if (StringUtils.isBlank(row.getString(0)) && StringUtils.isBlank(row.getString(1))) {
            continue;
          }
//          System.out.println("row count=" + sheet.rows().count());
          System.out.println("row = " + row.getRowNumber());
          System.out.println("last column index c" + row.getLastColumnIndex());
          System.out.print("row" + row.getRowNumber());
          System.out.println(" score" + row.getString(1));
          System.out.println(row.isEmpty());


        }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }



  public static void main(String[] args) throws IOException {
    readXls("/Users/happyelements/Desktop/feng.xlsx");
//    readXls("/Users/happyelements/Desktop/test-fixed-row.xlsx");

  }


  public static void readXls(String path) {
    try (ExcelReader reader = ExcelReader.read(Paths.get(path))) {
      reader.sheets().flatMap(Sheet::rows).forEach(System.out::println);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
