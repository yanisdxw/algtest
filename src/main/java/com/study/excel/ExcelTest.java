package com.study.excel;

import org.apache.poi.poifs.crypt.EncryptionInfo;
import org.apache.poi.poifs.crypt.EncryptionMode;
import org.apache.poi.poifs.crypt.Encryptor;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.OutputStream;

public class ExcelTest {
    public static void doEncrypt(String data) throws Exception {

        POIFSFileSystem fs = new POIFSFileSystem();
        EncryptionInfo info = new EncryptionInfo(EncryptionMode.agile);

        Encryptor enc = info.getEncryptor();
        enc.confirmPassword("pass");

        XSSFWorkbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("sheet1");
        sheet.createRow(0).createCell(0).setCellValue(data);

        // write the workbook into the encrypted OutputStream
        OutputStream encos = enc.getDataStream(fs);
        workbook.write(encos);
        workbook.close();
        encos.close(); // this is necessary before writing out the FileSystem

        OutputStream os = new FileOutputStream("provawrite.xlsx");
        fs.writeFilesystem(os);
        os.close();
        fs.close();
    }

    public static void main(String[] args) throws Exception {
        doEncrypt("Test");
    }
}
