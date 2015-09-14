package Lab1;
// import scanner utilities for user input 
import java.util.Scanner;
// import apache for financeLib calculations 
import org.apache.poi.ss.formula.functions.FinanceLib;

public class Main {
	public static void main(String[] args){
		// set values to be used for calculations 
		
		double r;
		double n;
		double y;
		double p;
		double f;
		boolean t;
		
		//set up scanner of inputs 
		Scanner input= new Scanner(System.in);
		
		//set up inputs 
		System.out.print("Enter Expected Years to Work:");
		double yearsToWorks = input.nextDouble();
		
		System.out.print("Enter Expected Annual Payback Return (0-.03): ");
		double annualReturnPM = input.nextDouble();
		
		System.out.print("Enter Expected Years Retired:");
		double yearsRetired = input.nextDouble();
		
		System.out.print("Enter Required Income:");
		double requiredIncome = input.nextDouble();
		
		System.out.print("Enter Monthly SSI:");
		double monthlySSI = input.nextDouble();
			
		System.out.print("Enter Annual Investment Return Decimal (0-.20):");
		double annualReturnIM = input.nextDouble();
		
		
	
		// set payment value 
		double PV;
		// create calculations for payment value with input variables 
		r=(annualReturnPM/12);
		n= (yearsRetired*12);
		y= (requiredIncome-monthlySSI);
		f=0;
		t= false; // boolean for Finance lib function 
		
		// place calculations into FinanceLib function for payment values
		PV= FinanceLib.pv(r,n,y,f,t);
		
		System.out.format("What you need saved: "+ "%.2f%n", -PV);
		
		
		double PMT;
		// create calculations for payment calculation with input variables 
		r=(annualReturnIM/12);
		n= (yearsToWorks*12);
		p=0;
		f=PV;
		t=false;
		
		// place calculations into FinanceLib function for payment calculations 
		PMT=FinanceLib.pmt(r, n, p, f, t);
		System.out.format("What you need to save: "+ "%.2f%n", PMT);
		
		
		
		
	}

}
