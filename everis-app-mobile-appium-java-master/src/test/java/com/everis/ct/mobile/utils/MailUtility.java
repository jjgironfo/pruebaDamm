package com.everis.ct.mobile.utils;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import javax.mail.*;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.CookieHandler;
import java.net.CookieManager;
import java.net.CookiePolicy;
import java.net.URL;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static io.restassured.RestAssured.given;

public class MailUtility {

    private static RequestSpecification request;
    private static Response response;


    public static void leerEmailYAccederAUrl() {
        //Accede a hotmail y recupera la url del mensaje que contenga Bar Manager
        String url = readEmailUrl();

        //Si esto no funciona como activacion, se puede hacer driver.get(url)
        llamarUrl(url);
    }

    private static String readEmailUrl() {
        String url = null;

        try {
            String host = "smtp-mail.outlook.com";

            //USUARIO Y CUENTA DE HOTMAIL. NO DE LA APP
            String user = "a.t.bm@hotmail.com";
            String pass = "Damm2022!";


            Properties properties = System.getProperties();
            properties.setProperty("mail.smtp.host", host);
            properties.put("mail.smtp.port", 993);
            properties.put("mail.smtp.auth", "true");
            properties.put("mail.smtp.user", user);
            properties.put("mail.smtp.starttls.enable", true);

            Session session = Session.getDefaultInstance(properties, null);

            Store store = session.getStore("imaps");
            store.connect(host, 993, user, pass);

            Folder inbox = store.getFolder("inbox");
            inbox.open(Folder.READ_ONLY);

            Message message = encontrarMensaje(inbox);

            url = sacarUrlDelMensaje(message);

            inbox.close(true);
            store.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return url;
    }

    private static Message encontrarMensaje(Folder folder) throws MessagingException {

        Message message = null;
        Message[] messages = folder.getMessages();

        for (int i = (messages.length)-1; i >= messages.length-5; i--) {
            message = messages[i];
            System.out.println("Subject: " + message.getSubject());

            if(message.getSubject().contains("[Bar Manager] Activación de la cuenta")) {
                break;
            }
        }

        return message;
    }


    private static String sacarUrlDelMensaje(Message message) throws MessagingException, IOException {
        String url = null;

        Multipart mp = (Multipart) message.getContent();

        Multipart insideMp = (Multipart) mp.getBodyPart(0).getContent();
        String text = (String) insideMp.getBodyPart(0).getContent();

        System.out.println(text);

        Pattern pattern = Pattern.compile("^ http.*$", Pattern.MULTILINE);
        Matcher matcher = pattern.matcher(text);
        if(matcher.find()) {
            System.out.println("Match found");
            url = matcher.group().trim();
            System.out.println(url);
        } else {
            System.out.println("No se ha encontrado ninguna url válida en el mensaje");
        }

        return url;
    }


    private static void llamarUrl(String url) {

        evitarProblemaSSL();

        try {
            CookieHandler.setDefault( new CookieManager( null, CookiePolicy.ACCEPT_ALL ) );
//            HttpsURLConnection c = (HttpsURLConnection) new URL(url).openConnection();
//            c.setRequestMethod("GET");
//            c.setRequestProperty("Content-Type", "text/html;charset=UTF-8");
//            c.setRequestProperty("Accept", "*/*");
//            c.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:102.0) Gecko/20100101 Firefox/102.0");
//            c.setDoOutput(true);
//            c.setDoInput(true);
//            c.connect();
            request = given().contentType(ContentType.JSON).log().all();
   System.out.println(request);
            response = request.when().get(url);



//            BufferedReader br = new BufferedReader(new InputStreamReader(c.getInputStream()));
//            String line;
//            while ((line = br.readLine()) != null) {
//                System.out.println(line);
//            }
        } catch(Exception e) {
            System.err.println("Error al realizar la llamada a la URL " + url + " del email");
            e.printStackTrace();
        }
    }

    private static void evitarProblemaSSL() {
        TrustManager tm = new X509TrustManager() {
            public X509Certificate[] getAcceptedIssuers() {
                return null;
            }
            public void checkClientTrusted(X509Certificate[] certs, String authType) {
            }
            public void checkServerTrusted(X509Certificate[] certs, String authType) {
            }
        };

        try {
            SSLContext sc = null;
            sc = SSLContext.getInstance("SSL");
            sc.init(null, new TrustManager[] { tm }, null);
            HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
        } catch (NoSuchAlgorithmException | KeyManagementException e ) {
            e.printStackTrace();
        }
    }
}
