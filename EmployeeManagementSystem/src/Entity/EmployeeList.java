/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Entity;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author hoaht
 */
public class EmployeeList {
    public static List<Employee> listEmployees = new ArrayList<>();
    
    public static void addNewEmployee(Employee newEmployee) {
        listEmployees.add(newEmployee);
    }
    
    public static void deleteEmployeeById(String eId) {
        int i = -1;
        
        for (Employee objEmployee : listEmployees) {
            if (objEmployee.geteId().equalsIgnoreCase(eId)) {
                i = listEmployees.indexOf(objEmployee);
            }
        }
        
        if (i != -1) {
            listEmployees.remove(i);
        }
    }
    
    public static void sortEmployeeSalary() {
        Collections.sort(listEmployees, new Comparator<Employee>() {
            @Override
            public int compare(Employee e1, Employee e2) {
                return (int) (e1.getSalary() - e2.getSalary());
            }
        });
    }
    
    public static boolean isDuplicateId(String emId) {
        for (Employee objEmployee : listEmployees) {
            if (objEmployee.geteId().equalsIgnoreCase(emId)) {
                return true;
            }
        }
        
        return false;
    }
    
    public static Employee getEmployeeById(String eId) {
        for (Employee objEmployee : listEmployees) {
            if (objEmployee.geteId().equalsIgnoreCase(eId)) {
                return objEmployee;
            }
        }
        
        return null;
    }
    
    public static List<Employee> getListEmployeeByName(String searchName) {
        List<Employee> listEmployeesSearch = new ArrayList<>();
        
        for (Employee objEmployee : listEmployees) {
            String fullName = objEmployee.geteFirstName() + " " + objEmployee.geteLastName();
            
            if (fullName.toUpperCase().contains(searchName.toUpperCase())) {
                listEmployeesSearch.add(objEmployee);
            }
        }
        
        return listEmployeesSearch;
    }
    
    public static void addEmployeeToTable(JTable jTable) {
        SimpleDateFormat sf = new SimpleDateFormat("dd-MM-yyyy");
        
        DefaultTableModel tableModel = (DefaultTableModel) jTable.getModel();
        
        Object[] objs = new Object[tableModel.getColumnCount()];
        for (Employee objEmployee : listEmployees) {
            objs[0] = objEmployee.geteId();
            objs[1] = objEmployee.geteFirstName();
            objs[2] = objEmployee.geteLastName();
            objs[3] = objEmployee.getePhone();
            objs[4] = objEmployee.geteEmail();
            objs[5] = objEmployee.geteAddress();
            objs[6] = sf.format(objEmployee.geteDob());
            objs[7] = objEmployee.isSex() ? "Male" : "Female";
            objs[8] = String.format("%.1f", objEmployee.getSalary());
            objs[9] = objEmployee.getAgency();
            
            tableModel.addRow(objs);
        }
    }
    
    public static void addEmployeeToTable(List<Employee> listNewEmployees, JTable jTable) {
        SimpleDateFormat sf = new SimpleDateFormat("dd-MM-yyyy");
        
        DefaultTableModel tableModel = (DefaultTableModel) jTable.getModel();
        
        Object[] objs = new Object[tableModel.getColumnCount()];
        for (Employee objEmployee : listNewEmployees) {
            objs[0] = objEmployee.geteId();
            objs[1] = objEmployee.geteFirstName();
            objs[2] = objEmployee.geteLastName();
            objs[3] = objEmployee.getePhone();
            objs[4] = objEmployee.geteEmail();
            objs[5] = objEmployee.geteAddress();
            objs[6] = sf.format(objEmployee.geteDob());
            objs[7] = objEmployee.isSex() ? "Male" : "Female";
            objs[8] = String.format("%.1f", objEmployee.getSalary());
            objs[9] = objEmployee.getAgency();
            
            tableModel.addRow(objs);
        }
    }
}
