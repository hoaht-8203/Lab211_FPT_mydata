/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FormV2;

import Entity.Employee;
import Entity.EmployeeList;
import Entity.Validate;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.plaf.BorderUIResource;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author hoaht
 */
public class EmployeeManagmentSystemForm extends javax.swing.JFrame {

    /**
     * Creates new form Demo
     */
    public EmployeeManagmentSystemForm() {
        customForm();
        actionPerformed();
        try {
            test();
        } catch (ParseException ex) {
            Logger.getLogger(Form.EmployeeManagmentSystemForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        btn_update.setVisible(false);
        btn_cancle.setVisible(false);
    }
    
    private JLabel label_eId;
    private JLabel label_firstName;
    private JLabel label_lastName;
    private JLabel label_gender;
    private JLabel label_phone;
    private JLabel label_email;
    private JLabel label_address;
    private JLabel label_dob;
    private JLabel label_salary;
    private JLabel label_agency;
    
    private JTextField txt_eId;
    private JTextField txt_eFirstName;
    private JTextField txt_eLastName;
    private JTextField txt_ePhone;
    private JTextField txt_eEmail;
    private JTextField txt_eAddress;
    private JTextField txt_eDob;
    private JTextField txt_eSalary;
    private JTextField txt_eAgency;
    private JTextField txt_eIdSelect;
    private JTextField txt_search;
    
    private JRadioButton option_male;
    private JRadioButton option_female;
    private ButtonGroup btn_group_gender;
    
    private JButton btn_wantUpdate;
    private JButton btn_remove;
    private JButton btn_cancle;
    private JButton btn_update;
    private JButton btn_clear;
    private JButton btn_add;
    
    private JComboBox option_sortType;
    
    private JTable table_listOfEmployees;
    
    public void actionPerformed() {
        txt_search.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                txt_searchKeyReleased(e);
            }
        });
        
        option_sortType.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                option_sortTypeActionPerformed(e);
            }
        });
        
        btn_cancle.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btn_cancleActionPerformed(e);
            }
        });
        
        btn_update.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btn_updateActionPerformed(e);
            }
        });
        
        table_listOfEmployees.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                table_listOfEmployeesMouseClicked(evt);
            }
        });
        
        btn_wantUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btn_wantUpdateActionPerformed(e);
            }
        });
        
        btn_remove.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btn_removeActionPerformed(e);
            }
        });
        
        btn_clear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btn_clearActionPerformed(e);
            }
        });
        
        btn_add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btn_addActionPerformed(e);
            }
        });
    }
    
    private void txt_searchKeyReleased(java.awt.event.KeyEvent evt) {                                       
        String nameSearch = txt_search.getText().trim();
        
        List<Employee> listEmployeeByName = EmployeeList.getListEmployeeByName(nameSearch);
        removeInforTable();
        EmployeeList.addEmployeeToTable(listEmployeeByName, table_listOfEmployees);
    } 
    
    private void option_sortTypeActionPerformed(java.awt.event.ActionEvent evt) {                                                
        if (option_sortType.getSelectedIndex() == 1) {
            EmployeeList.sortEmployeeSalary();
            refreshTable();
        }
    }  
    
    private void btn_cancleActionPerformed(java.awt.event.ActionEvent evt) {                                           
        clearTxt();
        btn_add.setVisible(true);
        btn_update.setVisible(false);
        btn_cancle.setVisible(false);
        btn_clear.setVisible(true);
        txt_eId.setEditable(true);
    }  
    
    private void btn_updateActionPerformed(java.awt.event.ActionEvent evt) {                                           
        if (!isNotNullValue()) {
            showAlert("You need to enter complete employee information!");
        } else if (!isValidateDate()) {
            showAlert("Your date must be greater than 18 years old and format! \n"
                    + "Example: 2003-02-22 [dd-MM-yyyy]");
        } else if (!isValidateSalary()) {
            showAlert("Price must be number and greater than 0!");
        } else if (!isValidateGmail()) {
            showAlert("Gmail is not format \n"
                    + "Example: example@gmail.com");
        } else if (!isValidateTelephone()) {
            showAlert("Telephone is not format \n"
                    + "Example: 0123456789");
        } else {
            String eId = txt_eId.getText().trim();
            String new_eFirstName = txt_eFirstName.getText().trim();
            String new_eLastName = txt_eLastName.getText().trim();
            String new_ePhone = txt_ePhone.getText().trim();
            String new_eEmail = txt_eEmail.getText().trim();
            String new_eAddress = txt_eAddress.getText().trim();
            Date new_eDob = Validate.coverToDate(txt_eDob, label_dob);
            float new_eSalary = Float.parseFloat(txt_eSalary.getText().trim());
            String new_eAgency = txt_eAgency.getText().trim();
            boolean new_eGender = option_male.isSelected();

            Employee employeeUpdate = EmployeeList.getEmployeeById(eId);
            employeeUpdate.seteFirstName(new_eFirstName);
            employeeUpdate.seteLastName(new_eLastName);
            employeeUpdate.setePhone(new_ePhone);
            employeeUpdate.seteEmail(new_eEmail);
            employeeUpdate.seteAddress(new_eAddress);
            employeeUpdate.seteDob(new_eDob);
            employeeUpdate.setSalary(new_eSalary);
            employeeUpdate.setAgency(new_eAgency);
            employeeUpdate.setSex(new_eGender);
            showAlert("Update employee success!");

            refreshTable();
            clearTxt();
            btn_add.setVisible(true);
            btn_update.setVisible(false);
            btn_cancle.setVisible(false);
            btn_clear.setVisible(true);
            txt_eId.setEditable(true);
            txt_eIdSelect.setText("");
        }
    }
    
    private void table_listOfEmployeesMouseClicked(MouseEvent evt) {                                                   
        DefaultTableModel tableModel = (DefaultTableModel) table_listOfEmployees.getModel();
        
        int selectedRow = table_listOfEmployees.getSelectedRow();
        System.out.println(selectedRow + " - ");
        
        String eIdSelected = (String) tableModel.getValueAt(selectedRow, 0);
        txt_eIdSelect.setText(eIdSelected);
    } 
    
    public void btn_wantUpdateActionPerformed(ActionEvent evt) {
        if (txt_eIdSelect.getText().length() == 0) {
            showAlert("Choose some employee please!");
        } else {
            Employee eUpdate = EmployeeList.getEmployeeById(txt_eIdSelect.getText());
            
            if (eUpdate == null) {
                System.out.println("Employee is empty!");
            } else {
                SimpleDateFormat sf = new SimpleDateFormat("dd-MM-yyyy");
                
                txt_eId.setText(eUpdate.geteId());
                txt_eFirstName.setText(eUpdate.geteFirstName());
                txt_eLastName.setText(eUpdate.geteLastName());
                txt_ePhone.setText(eUpdate.getePhone());
                txt_eEmail.setText(eUpdate.geteEmail());
                txt_eAddress.setText(eUpdate.geteAddress());
                txt_eDob.setText(sf.format(eUpdate.geteDob()));
                txt_eSalary.setText(String.format("%.1f", eUpdate.getSalary()));
                txt_eAgency.setText(eUpdate.getAgency());
                if (eUpdate.isSex()) {
                    option_male.setSelected(true);
                } else {
                    option_female.setSelected(true);
                }
                
                btn_cancle.setVisible(true);
                btn_update.setVisible(true);
                btn_clear.setVisible(false);
                btn_add.setVisible(false);
                txt_eId.setEditable(false);
            }
        }
    }
    
    public void btn_removeActionPerformed(ActionEvent evt) {
        if (txt_eIdSelect.getText().length() == 0) {
            showAlert("Choose some employee please!");
        } else {
            int isConfirm = JOptionPane.showConfirmDialog(this, "Are your sure to delete this employee?");
            
            if (isConfirm == 0) {
                EmployeeList.deleteEmployeeById(txt_eIdSelect.getText());
                refreshTable();
            }
        }
    }
    
    public void btn_clearActionPerformed(ActionEvent evt) {
        int isConfirm = JOptionPane.showConfirmDialog(this, "Are you sure to clear?");
        
        if (isConfirm == 0) {
            clearTxt();
        }
    }
    
    private void btn_addActionPerformed(ActionEvent evt) {
        if (!isNotNullValue()) {
            showAlert("You need to enter complete employee information!");
        } else if (!isValidateDate()) {
            showAlert("Your date must be greater than 18 years old and format! \n"
                    + "Example: 2003-02-22 [dd-MM-yyyy]");
        } else if (!isValidateSalary()) {
            showAlert("Price must be number and greater than 0!");
        } else if (!isValidateGmail()) {
            showAlert("Gmail is not format \n"
                    + "Example: example@gmail.com");
        } else if (!isValidateTelephone()) {
            showAlert("Telephone is not format \n"
                    + "Example: 0123456789");
        } else {
            String eId = txt_eId.getText().trim();
            
            label_eId.setForeground(Color.black);
            if (EmployeeList.isDuplicateId(eId)) {
                showAlert("Employee ID is exsited!");
                label_eId.setForeground(Color.red);
            } else {
                String eFirstName = txt_eFirstName.getText().trim();
                String eLastName = txt_eLastName.getText().trim();
                String ePhone = txt_ePhone.getText().trim();
                String eEmail = txt_eEmail.getText().trim();
                String eAddress = txt_eAddress.getText().trim();
                Date eDob = Validate.coverToDate(txt_eDob, label_dob);
                float eSalary = Float.parseFloat(txt_eSalary.getText().trim());
                String eAgency = txt_eAgency.getText().trim();
                boolean eGender = option_male.isSelected();
                
                Employee newEmployee = new Employee(eId, eFirstName, eLastName, ePhone, eEmail, eAddress, eDob, eGender, eSalary, eAgency);
                EmployeeList.addNewEmployee(newEmployee);
                showAlert("Add new employee success!");
                
                refreshTable();
                clearTxt();
            }
        }
    }
    
    public void removeInforTable() {
        DefaultTableModel tableModel = (DefaultTableModel) table_listOfEmployees.getModel();
        
        while (tableModel.getRowCount() > 0) {
            tableModel.removeRow(0);
        }
    }
    
    public void refreshTable() {
        DefaultTableModel tableModel = (DefaultTableModel) table_listOfEmployees.getModel();
        
        while (tableModel.getRowCount() > 0) {
            tableModel.removeRow(0);
        }
        
        EmployeeList.addEmployeeToTable(table_listOfEmployees);
    }
    
    public void test() throws ParseException {
        SimpleDateFormat sf = new SimpleDateFormat("dd-MM-yyyy");
        
        Employee employee1 = new Employee("E01", "John", "Doe", "0912456345", "john.doe@example.com",
                "123 Main St, City", sf.parse("12-2-2003"), true, 21000000f, "Agency A");
        Employee employee2 = new Employee("E02", "Alice", "Smith", "0934324567", "alice.smith@example.com",
                "456 Elm St, Town", sf.parse("24-4-2002"), false, 22200000f, "Agency B");
        Employee employee3 = new Employee("E03", "Bob", "Johnson", "0945645234", "bob.j@example.com",
                "789 Oak St, Village", sf.parse("8-3-2003"), true, 15000000f, "Agency C");
        Employee employee4 = new Employee("E04", "Sarah", "Williams", "0934234523", "sarah.w@example.com",
                "101 Pine St, Suburb", sf.parse("23-5-2002"), false, 8000000f, "Agency A");
        Employee employee5 = new Employee("E05", "Michael", "Brown", "0945234345", "michael.b@example.com",
                "222 Cedar St, County", sf.parse("13-6-2000"), true, 23000000f, "Agency D");
        Employee employee6 = new Employee("E06", "Emily", "Davis", "0978545324", "emily.d@example.com",
                "333 Maple St, Town", sf.parse("21-8-1999"), false, 30000000f, "Agency B");
        Employee employee7 = new Employee("E07", "David", "Wilson", "0945234344", "david.w@example.com",
                "444 Birch St, City", sf.parse("7-5-2003"), true, 22000000f, "Agency C");
        Employee employee8 = new Employee("E08", "Olivia", "Lee", "0954567245", "olivia.l@example.com",
                "555 Redwood St, Suburb", sf.parse("24-11-2002"), false, 12000000f, "Agency A");
        Employee employee9 = new Employee("E09", "James", "Anderson", "0934342237", "james.a@example.com",
                "666 Spruce St, Village", sf.parse("6-10-2001"), true, 6000000f, "Agency D");
        Employee employee10 = new Employee("E10", "Sophia", "Harris", "0953452653", "sophia.h@example.com",
                "777 Willow St, County", sf.parse("22-12-1998"), false, 6000000f, "Agency B");
        
        EmployeeList.addNewEmployee(employee1);
        EmployeeList.addNewEmployee(employee2);
        EmployeeList.addNewEmployee(employee3);
        EmployeeList.addNewEmployee(employee4);
        EmployeeList.addNewEmployee(employee5);
        EmployeeList.addNewEmployee(employee6);
        EmployeeList.addNewEmployee(employee7);
        EmployeeList.addNewEmployee(employee8);
        EmployeeList.addNewEmployee(employee9);
        EmployeeList.addNewEmployee(employee10);
        
        EmployeeList.addEmployeeToTable(table_listOfEmployees);
    }
    
    public void clearTxt() {
        txt_eId.setText("");
        txt_eFirstName.setText("");
        txt_eLastName.setText("");
        txt_ePhone.setText("");
        txt_eEmail.setText("");
        txt_eAddress.setText("");
        txt_eDob.setText("");
        txt_eSalary.setText("");
        txt_eAgency.setText("");
    }
    
    public boolean isNotNullValue() {
        boolean b1 = Validate.isNotEmpty(txt_eId, label_eId);
        boolean b2 = Validate.isNotEmpty(txt_eFirstName, label_firstName);
        boolean b3 = Validate.isNotEmpty(txt_eLastName, label_lastName);
        boolean b4 = Validate.isNotEmpty(txt_ePhone, label_phone);
        boolean b5 = Validate.isNotEmpty(txt_eEmail, label_email);
        boolean b6 = Validate.isNotEmpty(txt_eAddress, label_address);
        boolean b7 = Validate.isNotEmpty(txt_eDob, label_dob);
        boolean b8 = Validate.isNotEmpty(txt_eSalary, label_salary);
        boolean b9 = Validate.isNotEmpty(txt_eAgency, label_agency);
        
        boolean b10;
        if (option_male.isSelected() || option_female.isSelected()) {
            b10 = true;
            label_gender.setForeground(Color.black);
        } else {
            b10 = false;
            label_gender.setForeground(Color.red);
        }
        
        return b1 && b2 && b3 && b4 && b5 && b6 && b7 && b8 && b9 && b10;
    }
    
    public boolean isValidateDate() {
        SimpleDateFormat sf= new SimpleDateFormat("dd-MM-yyyy");
        
        Date maxDate = new Date();
        
        try {
            maxDate = sf.parse("1-1-2005");
        } catch (ParseException e) {
            System.out.println("Error!");
        }
        
        return Validate.isValidateDate(txt_eDob, label_dob);
    }
    
    public boolean isValidateSalary() {
        return Validate.isFormatPrice(txt_eSalary, label_salary);
    }
    
    public boolean isValidateGmail() {
        return Validate.isFormatEmail(txt_eEmail, label_email);
    }
    
    public boolean isValidateTelephone() {
        return Validate.isValidateTelephone(txt_ePhone, label_phone, 10);
    }
    
    public void showAlert(String msg) {
        JOptionPane.showMessageDialog(this, msg);
    }
    
    public void customForm() {
        JFrame frame = new JFrame("Employee Managment System");
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setBounds(290, 290, 1380, 561);
        
        JPanel panelAddNewEmployee = new JPanel();
        JPanel panelRemoveUpdate = new JPanel();
        JPanel panelHandleTable = new JPanel();
        JPanel panelTable = new JPanel();
        
        frame.add(panelAddNewEmployee);
        frame.add(panelRemoveUpdate);
        frame.add(panelHandleTable);

        ////////////////////////////////////////////////
        EtchedBorder etchedBorder = new EtchedBorder();
        
        panelAddNewEmployee.setLayout(null);
        
        panelAddNewEmployee.setBorder(etchedBorder);
        panelAddNewEmployee.setBounds(10, 10, 306, 384);
        
        label_eId = new JLabel("Employee ID");
        label_eId.setBounds(10, 10 + 4, 100, 14);
        panelAddNewEmployee.add(label_eId);
        txt_eId = new JTextField();
        txt_eId.setBounds(10 + 100 + 10, 10, 180, 25);
        panelAddNewEmployee.add(txt_eId);
        
        label_firstName = new JLabel("First name");
        label_firstName.setBounds(10, 10 + 4 + 35, 100, 14);
        panelAddNewEmployee.add(label_firstName);
        txt_eFirstName = new JTextField();
        txt_eFirstName.setBounds(10 + 100 + 10, 10 + 35, 180, 25);
        panelAddNewEmployee.add(txt_eFirstName);
        
        label_lastName = new JLabel("Last name");
        label_lastName.setBounds(10, 10 + 4 + 35 * 2, 100, 14);
        panelAddNewEmployee.add(label_lastName);
        txt_eLastName = new JTextField();
        txt_eLastName.setBounds(10 + 100 + 10, 10 + 35 * 2, 180, 25);
        panelAddNewEmployee.add(txt_eLastName);
        
        label_gender = new JLabel("Gender");
        label_gender.setBounds(10, 10 + 4 + 35 * 3, 100, 14);
        panelAddNewEmployee.add(label_gender);
        option_male = new JRadioButton("Male");
        option_male.setBounds(10 + 100 + 10, 10 + 35 * 3, 55, 25);
        panelAddNewEmployee.add(option_male);
        option_female = new JRadioButton("Female");
        option_female.setBounds(10 + 100 + 10 + 60, 10 + 35 * 3, 70, 25);
        panelAddNewEmployee.add(option_female);
        btn_group_gender = new ButtonGroup();
        btn_group_gender.add(option_male);
        btn_group_gender.add(option_female);
        
        label_phone = new JLabel("Phone");
        label_phone.setBounds(10, 10 + 4 + 35 * 4, 100, 14);
        panelAddNewEmployee.add(label_phone);
        txt_ePhone = new JTextField();
        txt_ePhone.setBounds(10 + 100 + 10, 10 + 35 * 4, 180, 25);
        panelAddNewEmployee.add(txt_ePhone);
        
        label_email = new JLabel("Email");
        label_email.setBounds(10, 10 + 4 + 35 * 5, 100, 14);
        panelAddNewEmployee.add(label_email);
        txt_eEmail = new JTextField();
        txt_eEmail.setBounds(10 + 100 + 10, 10 + 35 * 5, 180, 25);
        panelAddNewEmployee.add(txt_eEmail);
        
        label_address = new JLabel("Address");
        label_address.setBounds(10, 10 + 4 + 35 * 6, 100, 14);
        panelAddNewEmployee.add(label_address);
        txt_eAddress = new JTextField();
        txt_eAddress.setBounds(10 + 100 + 10, 10 + 35 * 6, 180, 25);
        panelAddNewEmployee.add(txt_eAddress);
        
        label_dob = new JLabel("Date of birth");
        label_dob.setBounds(10, 10 + 4 + 35 * 7, 100, 14);
        panelAddNewEmployee.add(label_dob);
        txt_eDob = new JTextField();
        txt_eDob.setBounds(10 + 100 + 10, 10 + 35 * 7, 180, 25);
        panelAddNewEmployee.add(txt_eDob);
        
        label_salary = new JLabel("Salary");
        label_salary.setBounds(10, 10 + 4 + 35 * 8, 100, 14);
        panelAddNewEmployee.add(label_salary);
        txt_eSalary = new JTextField();
        txt_eSalary.setBounds(10 + 100 + 10, 10 + 35 * 8, 180, 25);
        panelAddNewEmployee.add(txt_eSalary);
        
        label_agency = new JLabel("Agency");
        label_agency.setBounds(10, 10 + 4 + 35 * 9, 100, 14);
        panelAddNewEmployee.add(label_agency);
        txt_eAgency = new JTextField();
        txt_eAgency.setBounds(10 + 100 + 10, 10 + 35 * 9, 180, 25);
        panelAddNewEmployee.add(txt_eAgency);
        
        btn_cancle = new JButton("CANCLE");
        btn_cancle.setBounds(5, 10 + 4 + 340, 77, 25);
        panelAddNewEmployee.add(btn_cancle);
        
        btn_update = new JButton("UPDATE");
        btn_update.setBounds(5 + 77 + 4, 10 + 4 + 340, 77, 25);
        panelAddNewEmployee.add(btn_update);
        
        btn_clear = new JButton("CLEAR");
        btn_clear.setBounds(5 + 77 * 2 + 4 * 2, 10 + 4 + 340, 77, 25);
        panelAddNewEmployee.add(btn_clear);
        
        btn_add = new JButton("ADD");
        btn_add.setBounds(5 + 77 * 3 + 4 * 3, 10 + 4 + 340, 53, 25);
        panelAddNewEmployee.add(btn_add);

        //-------------------------------------------------------
        panelRemoveUpdate.setBorder(etchedBorder);
        panelRemoveUpdate.setBounds(10, 384 + 10 + 10, 306, 110);
        panelRemoveUpdate.setLayout(null);
        
        JLabel label1 = new JLabel("CLICK ANY EMPLOYEE YOU WANT IN TABLE");
        label1.setBounds(8, 8, 348, 10);
        panelRemoveUpdate.add(label1);
        
        JLabel label2 = new JLabel("You seleted");
        label2.setBounds(8, 40, 70, 10);
        panelRemoveUpdate.add(label2);
        
        txt_eIdSelect = new JTextField();
        txt_eIdSelect.setBounds(8 + 70 + 5, 33, 88, 25);
        panelRemoveUpdate.add(txt_eIdSelect);
        
        btn_remove = new JButton("REMOVE");
        btn_remove.setBounds(6, 63, 80, 25);
        panelRemoveUpdate.add(btn_remove);
        
        btn_wantUpdate = new JButton("UPDATE");
        btn_wantUpdate.setBounds(6 + 80 + 4, 63, 80, 25);
        panelRemoveUpdate.add(btn_wantUpdate);

        //-------------------------------------------------------
        panelHandleTable.setBorder(etchedBorder);
        panelHandleTable.setBounds(10 + 306 + 10, 10, 1030, 38);
        panelHandleTable.setLayout(null);
        
        option_sortType = new JComboBox();
        option_sortType.addItem("Choose type of sort");
        option_sortType.addItem("Sort by salary");
        option_sortType.setBounds(6, 6, 150, 25);
        panelHandleTable.add(option_sortType);
        
        txt_search = new JTextField();
        txt_search.setBounds(1030 - 106 - 50, 6, 150, 25);
        panelHandleTable.add(txt_search);

        ////////////////////////////////////////////////
        frame.add(panelTable);
        panelTable.setBorder(etchedBorder);
        panelTable.setBounds(10 + 306 + 10, 50, 1030, 345);
        panelTable.setLayout(new BorderLayout());
        
        String[] cols = {"ID", "First name", "Last name", "Phone", "Email", "Address", "Date of birth", "Sex", "Salary (VND)", "Agency"};
        DefaultTableModel tableModel = new DefaultTableModel(cols, 0);
        
        table_listOfEmployees = new JTable(tableModel);
        table_listOfEmployees.setRowHeight(30);
        table_listOfEmployees.getColumnModel().getColumn(0).setPreferredWidth(35);
        table_listOfEmployees.getColumnModel().getColumn(1).setPreferredWidth(50);
        table_listOfEmployees.getColumnModel().getColumn(2).setPreferredWidth(50);
        table_listOfEmployees.getColumnModel().getColumn(4).setPreferredWidth(140);
        table_listOfEmployees.getColumnModel().getColumn(5).setPreferredWidth(130);
        panelTable.add(new JScrollPane(table_listOfEmployees));
        
        frame.setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(EmployeeManagmentSystemForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EmployeeManagmentSystemForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EmployeeManagmentSystemForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EmployeeManagmentSystemForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EmployeeManagmentSystemForm();
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
