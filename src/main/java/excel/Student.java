package excel;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.ttzero.excel.annotation.ExcelColumn;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Student {
  @ExcelColumn("分数")
  private Integer score;
  @ExcelColumn("表扬内容")
  private String content;
}
