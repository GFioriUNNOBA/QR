package ar.edu.unnoba.POO.model.QR.util;

import ar.edu.unnoba.POO.model.QR.controller.ProductoDelGestorController;
import ar.edu.unnoba.POO.model.QR.controller.QrController;
import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.Image;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.servlet.view.document.AbstractPdfView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileOutputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

@Component("/gestor/productos/QrDelProducto")
public class QrPDF extends AbstractPdfView {

    @Override
    protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer, HttpServletRequest request, HttpServletResponse response) throws Exception {
        Path path = Paths.get(ClassLoader.getSystemResource("QrImg/QRCode2.png").toURI());
        FileOutputStream fileOutputStream= new FileOutputStream("QrCode.pdf");

        PdfWriter.getInstance(document, fileOutputStream);
        document.open();
        Image img = Image.getInstance(path.toAbsolutePath().toString());
        document.add(img);

        document.close();

    }

}
