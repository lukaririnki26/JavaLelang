/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lib;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.sun.jndi.url.corbaname.corbanameURLContextFactory;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;

/**
 *
 * @author fahmi
 */
public class Qr {
    public static void main(String[] args){
        Charset charset = Charset.forName("ISO-8859-1");
        CharsetEncoder encoder = charset.newEncoder();
        byte[] b=null;
        try {
            ByteBuffer bb = encoder.encode(CharBuffer.wrap("=========="
                    + "==========jbjhnklnknknknknl===="
                    + "ippkpkp"));
            b = bb.array();
        } catch (CharacterCodingException e) {
            System.out.println("disini");
        }
        String data=null;
        try {
            data = new String(b,"ISO-8859-1");
        } catch (UnsupportedEncodingException e) {
            System.out.print("disini1");
        }
        BitMatrix matrix = null;
        int h = 150;
        int w = 150;
        com.google.zxing.Writer writer = new QRCodeWriter();
        try {
            matrix = writer.encode(data, BarcodeFormat.QR_CODE, w, h);
        } catch (com.google.zxing.WriterException e) {
        }
        String filepath = "src/qr/qr2.png";
        File file = new File(filepath);
        try {
            MatrixToImageWriter.writeToFile(matrix, "PNG", file);
            
        } catch (Exception e) {
        }
    }
}
