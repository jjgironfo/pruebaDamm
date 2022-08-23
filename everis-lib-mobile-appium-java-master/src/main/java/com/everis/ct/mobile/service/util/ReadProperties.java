package com.everis.ct.mobile.service.util;

import java.io.*;
import java.util.Properties;
import com.everis.ct.mobile.base.MobileBase;

public class ReadProperties extends MobileBase {
    Properties properties = new Properties();
    String path = System.getProperty("user.dir") + File.separator + "src" + File.separator + "test" + File.separator + "resources" + File.separator + "application.properties";
    {
        try {
            properties.load(new FileInputStream(path));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

     public String pinCode(){
      return properties.getProperty("pincode");
     }

    public String pasarEmail(){
        if(isIOS()){
            return properties.getProperty("userNameIOS");
        }else{
            return properties.getProperty("userName");
        }
    }

    public String pasarEmailPromos(){
        if(isIOS()){
            return properties.getProperty("userPromosiOS");
        }else{
            return properties.getProperty("userPromosAndroid");
        }
    }

    public String pasarPass(){
        if(isIOS()){
            return properties.getProperty("passwordIOS");
        }else{
            return properties.getProperty("password");
        }
    }

    public String pasarPassPromos(){
        if(isIOS()){
//            Se coge el passwordIOS por problemas con el usuario, habra que modificarlo cuando tengamos users estables
            return properties.getProperty("passwordIOS");
        }else{
            return properties.getProperty("passwordIOS");
        }
    }

    public String pasarPassNueva(){
        if (isIOS()){
            String pass = properties.getProperty("passwordIOS");
            String digitos = pass.substring(5, 9);
            int numero = Integer.parseInt(digitos);
            String passFinal = pass.substring(0, 5) + String.valueOf(numero + 1);
            properties.setProperty("passNuevaIOS", passFinal);
            return properties.getProperty("passNuevaIOS");
        }else {
            String pass = properties.getProperty("password");
            String digitos = pass.substring(5, 9);
            int numero = Integer.parseInt(digitos);
            String passFinal = pass.substring(0, 5) + String.valueOf(numero + 1);
            properties.setProperty("passNueva", passFinal);
            return properties.getProperty("passNueva");
        }
    }

    public String pasarEmailNuevo() {
        boolean isIOS = isIOS();
        if(isIOS){
            String email = properties.getProperty("userNameIOS");

            int posicionArroba = email.indexOf("@");
            char caracterPrevio = email.charAt(posicionArroba-1);

            if(caracterPrevio == '3') {
                email = email.replace("+3@", "+1@");
            } else {
                email = email.replace("+1@", "+3@");
            }
            properties.setProperty("userNameNuevoIOS", email);
            return properties.getProperty("userNameNuevoIOS");
        }else {
            String email = properties.getProperty("userName");

            int posicionArroba = email.indexOf("@");
            char caracterPrevio = email.charAt(posicionArroba-1);

            if(caracterPrevio == '2') {
                email = email.replace("+2@", "@");
            } else {
                email = email.replace("@", "+2@");
            }
            properties.setProperty("userNameNuevo", email);
            return properties.getProperty("userNameNuevo");
        }
    }

    public void cambiarPassNXPassA(){
        if (isIOS()) {
            String passNueva = properties.getProperty("passNuevaIOS");
            properties.setProperty("passwordIOS", passNueva);
        }else{
            String passNueva = properties.getProperty("passNueva");
            properties.setProperty("password", passNueva);
        }
    }

    public void cambiarEmailNXEmailA(){
        if (isIOS()){
            String userNuevo = properties.getProperty("userNameNuevoIOS");
            properties.setProperty("userNameIOS", userNuevo);
        }else {
            String userNuevo = properties.getProperty("userNameNuevo");
            properties.setProperty("userName", userNuevo);
        }
    }

    public void escribirArchivoProperties(){
        try (final OutputStream outputstream = new FileOutputStream(path);) {
            properties.store(outputstream, "File Updated");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}


