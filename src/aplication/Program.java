package aplication;

import java.util.Scanner;

import entities.Department;
import entities.Worker;
import entities.Enum.WorkerLevel;

public class Program {

	public static void main(String[] args) {
		// obtendo dados do trabalhador 
       Scanner sc = new Scanner(System.in);
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
       
       sc.close();   		
	}
    
}
