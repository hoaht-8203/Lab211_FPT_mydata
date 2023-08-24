
import java.math.BigInteger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author hoaht
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String[] options = {"Binary", "Decimal", "Hexadecimal", "Exit"};
        
        do {
            System.out.println("+--- Cover System ---+");
            // Display the menu
            Menu.displayMenu(options);
            
            // Get the options from menu
            int input_option = Input.input_withRange(1, 4, "Enter input base: ");
            if(input_option == 4) System.exit(0);
            int output_option = Input.input_withRange(1, 4, "Enter output base: ");
            
            switch (input_option) {
                // Base BIN
                case 1:
                    String binNum = Input.input_binary("Enter binary number: ");
                    // Choose base output
                    switch (output_option) {
                        case 1:
                            Manager.covertDisplay("BIN", "BIN", binNum, binNum);
                            break;
                        case 2:
                            Manager.covertDisplay("BIN", "DEC", binNum, Manager.binaryToDecimal(binNum));
                            break;
                        case 3:
                            Manager.covertDisplay("BIN", "HEX", binNum, Manager.binaryToHex(binNum));
                            break;
                        default:
                            break;
                    }
                    break;
                // Base DEC
                case 2:
                    String decNum = Input.input_decimal("Enter decimal number: ");
                    // Choose base output
                    switch (output_option) {
                        case 1:
                            Manager.covertDisplay("DEC", "BIN", decNum, Manager.decimalToBinary(decNum));
                            break;
                        case 2:
                            Manager.covertDisplay("DEC", "DEC", decNum, decNum);
                            break;
                        case 3:
                            Manager.covertDisplay("DEC", "HEX", decNum, Manager.decimalToHex(decNum));
                            break;
                        default:
                            break;
                    }
                    break;
                // Base HEX
                case 3:
                    String hexNum = Input.input_hexa("Enter hexadecimal number: ");
                    // Choose base output
                    switch (output_option) {
                        case 1:
                            Manager.covertDisplay("HEX", "BIN", hexNum, Manager.hexToBinary(hexNum));
                            break;
                        case 2:
                            Manager.covertDisplay("HEX", "DEC", hexNum, Manager.hexToDecimal(hexNum));
                            break;
                        case 3:
                            Manager.covertDisplay("HEX", "DEC", hexNum, hexNum);
                            break;
                        default:
                            break;
                    }
                    break;
            }
        } while (true);
    }
    
}
