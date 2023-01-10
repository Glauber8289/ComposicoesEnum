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
       
       System.out.print("Digite seu departamento");
       String departmentName = sc.next();
       System.out.print("Dados do trabalhador");
       System.out.print("Digite seu nome");
       String workername= sc.next();
       System.out.print("Digite seu  nivel");
       String workerLevel= sc.next();
       System.out.print("Digite seu Salario");
       double baseSalary= sc.nextDouble();
       
       //instanciando trabalhador 
       Worker worker = new Worker(workername, WorkerLevel.valueOf(workerLevel), baseSalary, new Department(departmentName));
       
       System.out.println("Quantos contratos o trabalhador terá ?");
       int n= sc.nextInt();
       
       for(int i=1;i<=n;i++) {
    	   System.out.println("Digite o contrato # " + i + " data");
    	   System.out.print(" Data (DD/MM/YYYY): ");
    	   Date contractDate = sdf.parse(sc.next());
    	  double valuePerHour = sc.nextDouble();
    	  System.out.print("Duração por horas");
    	  int hours = sc.nextInt();
    	  
    	//instanciando contrato
    	  Hourcontract contract=new Hourcontract(contractDate, valuePerHour, hours);
    	  
    	  //adicionando contrato ao trabalhador
    	  worker.addContract(contract);
    	  
    	  }
       System.out.println();
       System.out.println("Entre com mes e ano para calcular o salario (MM/YYYY): ");
       String monthandYear=sc.next();
       int month= Integer.parseInt(monthandYear.substring(0, 1));
       int year = Integer.parseInt(monthandYear.substring(3, 6));
       System.out.println("Nome: " + worker.getName());
       System.out.println("Departamento: " + worker.getDepartment().getName());
       System.out.println("Renda: " + monthandYear + ":" + String.format("%.2f" worker.income(year, month)));
       
       
       sc.close();   		
	}
    
}
