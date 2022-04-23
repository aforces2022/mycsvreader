package com.zorba;

import com.zorba.pojo.Employee;

import java.io.*;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main(String[] args) throws Exception {
        URL url = App.class.getClassLoader().getResource("emp.csv");
        File file = new File(url.getPath());
        BufferedReader br = new BufferedReader(new FileReader(file));
        String line="";

        //skip the header
        if(br !=null){
            br.readLine();
        }
        List<Employee> employees = new ArrayList<Employee>();
        while((line =br.readLine())!=null){
            String[] res = line.split(",");
            Employee emp = new Employee();
            emp.setName(res[0]);
            emp.setDob(res[1]);
            emp.setGender(res[2]);
            try{
                emp.setSalary(Double.parseDouble(res[3]));
            }catch (NumberFormatException e){
                emp.setSalary(0);
            }
            emp.setAddress(res[4]);
            employees.add(emp);
        }

        System.out.println(employees);









    }
}
