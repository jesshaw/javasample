package sample.cee;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * Created by csluo on 2018/11/30.
 */
public class ExcelDownloadSvc {
    private static final Integer FIFTEEN_WIDTH = 15 * 256;
    private static final Integer TWENTY_WIDTH = 20 * 256;
    private static final int KEEP_ROW = 100;

    public Workbook scoresPerYearsToExcel(List<ScoresPerYear> scoresPerYears) throws IOException {
        List<String> titles = Arrays.asList("学校", "办学类型", "省份", "城市","录取批次", "招生类型"
                , "2019最低分", "2019最低分专项", "2018最低分", "2018最低分专项", "2017最低分", "2017最低分专项"
                , "2016最低分", "2016最低分专项", "2015最低分", "2015最低分专项", "2014最低分", "2014最低分专项","网站地址");
        Workbook wb = new SXSSFWorkbook(KEEP_ROW);
        Sheet sh = wb.createSheet();
        sh = createTitleRow(sh, titles);
        for (int i = 0; i < scoresPerYears.size(); i++) {
            ScoresPerYear item = scoresPerYears.get(i);
            Row row = sh.createRow(i + 1);
            Cell cell = row.createCell(0);
            cell.setCellValue(item.getSchoolName());
            cell = row.createCell(1);
            cell.setCellValue(item.getLevelName());
            cell = row.createCell(2);
            cell.setCellValue(item.getProvinceName());
            cell = row.createCell(3);
            cell.setCellValue(item.getCityName());
            cell = row.createCell(4);
            cell.setCellValue(item.getLocalBatchName());
            cell = row.createCell(5);
            cell.setCellValue(item.getZslxName());
            cell = row.createCell(6);
            cell.setCellValue(Double.parseDouble(item.getMinScore2019()));
            cell = row.createCell(7);
            cell.setCellValue(Double.parseDouble(item.getMinScore2019s()));
            cell = row.createCell(8);
            cell.setCellValue(Double.parseDouble(item.getMinScore2018()));
            cell = row.createCell(9);
            cell.setCellValue(Double.parseDouble(item.getMinScore2018s()));
            cell = row.createCell(10);
            cell.setCellValue(Double.parseDouble(item.getMinScore2017()));
            cell = row.createCell(11);
            cell.setCellValue(Double.parseDouble(item.getMinScore2017s()));
            cell = row.createCell(12);
            cell.setCellValue(Double.parseDouble(item.getMinScore2016()));
            cell = row.createCell(13);
            cell.setCellValue(Double.parseDouble(item.getMinScore2016s()));
            cell = row.createCell(14);
            cell.setCellValue(Double.parseDouble(item.getMinScore2015()));
            cell = row.createCell(15);
            cell.setCellValue(Double.parseDouble(item.getMinScore2015s()));
            cell = row.createCell(16);
            cell.setCellValue(Double.parseDouble(item.getMinScore2014()));
            cell = row.createCell(17);
            cell.setCellValue(Double.parseDouble(item.getMinScore2014s()));
            cell = row.createCell(18);
            cell.setCellValue(String.format("https://gkcx.eol.cn/school/%s/provinceline", item.getSchoolId()));
        }
        return wb;
    }


    private Sheet createTitleRow(Sheet sh, List<String> titles) {
        Row row = sh.createRow(0);
        for (int i = 0; i < titles.size(); i++) {
            Cell cell = row.createCell(i);
            cell.setCellValue(titles.get(i));
        }
        return sh;
    }

    private CellStyle createDateCellStyle(Workbook wb) {
        CellStyle cellStyle = wb.createCellStyle();
        DataFormat format = wb.createDataFormat();
        cellStyle.setDataFormat(format.getFormat("yyyy/m/d"));
        return cellStyle;
    }
}
