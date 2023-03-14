package ar.edu.unnoba.POO.model.QR.controller;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
@RestController
@RequestMapping("/logs")

public class LogController {

    @GetMapping(value = "/download", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    public ResponseEntity<StreamingResponseBody> downloadLog() throws FileNotFoundException {
        InputStream inputStream = new FileInputStream("src/main/resources/QrImg/QRCode2.png");
        StreamingResponseBody body = outputStream -> FileCopyUtils.copy(inputStream, outputStream);
        return ResponseEntity.ok()
                .header("Content-Disposition", "attachment;filename=QRCode2.png")
                .body(body);
    }
}

