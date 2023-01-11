package aplication;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import entities.Department;
import entities.Hourcontract;
import entities.Worker;
import entities.Enum.WorkerLevel;


public class Program {

	public static void main(String[] args) throws ParseException {
		// obtendo dados do trabalhador 
       Scanner sc = new Scanner(System.in);
       SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
       
       System.out.print("Digite  qual é seu departamento");
       String departmentName = sc.next();
       System.out.println("Dados do trabalhador");
       System.out.print("Digite o nome do funcionario");
       String workername= sc.next();
       System.out.print("Digite o nivel do funcionario : JUNIOR, MID_LEVEL ou SENIOR ?");
       String workerLevel= sc.next();
       System.out.print("Digite seu Salario");
       double baseSalary= sc.nextDouble();
       
       //instanciando trabalhador 
       Worker worker = new Worker(workername, WorkerLevel.valueOf(workerLevel), baseSalary, new Department(departmentName));
       
       System.out.println("Quantos contratos o funcionario terá ?");
       int n= sc.nextInt();
       
       for(int i=1;i<=n;i++) {
    	   System.out.println("Digite o contrato # " + i + " data : ");
    	   System.out.print(" Data (DD/MM/YYYY): ");
    	   Date contractDate = sdf.parse(sc.next());
           System.out.println("Digite o valor recebido por hora"); 	  
    	   double valuePerHour = sc.nextDouble();
    	  System.out.print("Duração por (hours) : ");
    	  int hours = sc.nextInt();
    	  Hourcontract contract=new Hourcontract(contractDate, valuePerHour, hours);
    	  worker.addContract(contract);
    	  
    	  }
       System.out.println();
        System.out.println("Entre com mes e ano para calcular o salario (MM/YYYY): ");
        String monthandYear = sc.next();
        int month= Integer.parseInt(monthandYear.substring(0, 2));
        int year = Integer.parseInt(monthandYear.substring(3));
        System.out.println("Nome: " + worker.getName());
        System.out.println("Departamento: " + worker.getDepartment().getName());
        System.out.println("Renda: " + monthandYear + ":" + String.format("%.2f",worker.income(year, month)));
       
       
    //   System.out.println();
       //  	System.out.print("Enter month and year to calculate income (MM/YYYY): ");
       //  String monthAndYear = sc.next();
       //  int month = Integer.parseInt(monthAndYear.substring(0, 2));
       //  int year = Integer.parseInt(monthAndYear.substring(3));
       //  System.out.println("Name: " + worker.getName());
       //  System.out.println("Department: " + worker.getDepartment().getName());
       //  System.out.println("Income for " + monthAndYear + ": " + String.format("%.2f", worker.income(year, month)));
       
       sc.close();   		
	}
    
}
