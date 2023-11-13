/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Entity;

import java.awt.Color;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.util.converter.LocalDateStringConverter;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author hoaht
 */
public class Validate {
    public static boolean isNotEmpty(JTextField jTextField, JLabel jLabel) {
        String data = jTextField.getText().trim();
        
        if (data.length() == 0) {
            jLabel.setForeground(Color.red);
            return false;
        }
        
        jLabel.setForeground(Color.black);
        return true;
    }
    
    public static boolean isValidateDate(JTextField jTextField, JLabel jLabel) {
        SimpleDateFormat sf = new SimpleDateFormat("dd-MM-yyyy");
        sf.setLenient(false);
        String data = jTextField.getText().trim();
        
        Date date = new Date();
        
        try {
            date = sf.parse(data);
        } catch (ParseException e) {
            jLabel.setForeground(Color.red);
            return false;
        }
        
        SimpleDateFormat sf2 = new SimpleDateFormat("yyyy-MM-dd");
        String format1 = sf2.format(date);
        LocalDate curDate = LocalDate.now();
        LocalDate birthDate = LocalDate.parse(format1);
        int yearsOld = Period.between(birthDate, curDate).getYears();
        
        if (yearsOld >= 18) {
            jLabel.setForeground(Color.black);
            return true;
        } else {
            jLabel.setForeground(Color.red);
            return false;
        }
        
    }
    
    public static Date coverToDate(JTextField jTextField, JLabel jLabel) {
        SimpleDateFormat sf = new SimpleDateFormat("dd-MM-yyyy");
        sf.setLenient(false);
        String data = jTextField.getText().trim();
        
        try {
            Date date = sf.parse(data);
            jLabel.setForeground(Color.black);
            return date;
        } catch (ParseException e) {
            jLabel.setForeground(Color.red);
            System.out.println("Error format date input!");
            return null;
        }
    }
    
    public static boolean isFormatPrice(JTextField jTextField, JLabel jLabel) {
        String data = jTextField.getText().trim();
        
        try {
            float price = Float.parseFloat(data);
            
            if (price < 0) {
                jLabel.setForeground(Color.red);
                return false;
            }
            
            jLabel.setForeground(Color.black);
            return true;
        } catch (NumberFormatException e) {
            jLabel.setForeground(Color.red);
            return false;
        }
    }
    
    public static boolean isFormatEmail(JTextField jTextField, JLabel jLabel) {
        String data = jTextField.getText().trim();
        
            String regex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}$";//...........@........com

        Pattern pattern = Pattern.compile(regex);

        Matcher matcher = pattern.matcher(data);
        
        if (matcher.matches()) {
            jLabel.setForeground(Color.black);
            return true;
        } else {
            jLabel.setForeground(Color.red);
            return false;
        }
    }
    
    public static boolean isValidateTelephone(JTextField jTextField, JLabel jLabel, int max) {
        String data = jTextField.getText().trim();
        
        String regex = "^[0-9]{10}$";
        
        if (!data.matches(regex)) {
            jLabel.setForeground(Color.red);
            return false;
        } else {
            jLabel.setForeground(Color.black);
            return true;
        }
    }
}
