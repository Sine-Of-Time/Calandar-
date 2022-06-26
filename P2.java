import java.util.Scanner;
public class P2 {
	public static void main(String[] args) { //Works as of 5/2/22. Just need to optimize and ask.
											//Fixed missing feature on 5/3/22 and resub.
		Scanner in = new Scanner(System.in);
		
		String inLine="";
		int year=0;
		int d1=0;
		boolean b=true;
		do {
		System.out.println("Enter year less then 10000");
		inLine=in.nextLine();
		
		if(inLine.length()<=4) { //Input validation.
			int x=1;
			int n=inLine.length()-1;
			for(int i=0;i<inLine.length();i++) {
				if(inLine.charAt(i)=='-') break;
				if(inLine.charAt(i)>='0'&&'9'>=inLine.charAt(i)) {
				char ch=inLine.charAt(n-i);
				x=(int)(ch-'0');
				year+=x*Math.pow(10, i);
				b=false;
				}
			}
		}

		}while(b==true);
		
		
		b=true;
		do { 		//Input validation.
		System.out.println("Enter the day of the week January First Falls on.");
		System.out.println("Enter in the form 0 to 6, 0 being Sunday, 6 being Saturday.");
		inLine=in.nextLine();
		if(inLine.length()==1) {
			if(inLine.charAt(0)>='0'&&'6'>=inLine.charAt(0)) {
				d1=(int)(inLine.charAt(0)-'0');
				b=false;
			}
		}
		}while(b==true);
		in.close();
		
		for(int i=1;i<=12;i++) { //Main code.
			printHeader(i,year);
			int monthLength=getMonthLength(i,year);
			printBody(monthLength,d1);
			d1=updateD1(monthLength,d1);
		}
	}
	public static void printHeader(int month, int year) { //Works 5/2/22
		switch(month) {
		case 1:
			System.out.println("\t\t\tJanuary "+year);
			System.out.println("Sun\tMon\tTue\tWed\tThu\tFri\tSat");
			System.out.printf("---------------------------------------------------"); //Would have used printf and used right justify 
			break;							   	  	   //But that would require a string variable and wasted RAM.
		case 2:
			System.out.println("\t\t\tFebruary "+year);
			System.out.println("Sun\tMon\tTue\tWed\tThu\tFri\tSat");
			System.out.printf("---------------------------------------------------");
			break;
		case 3:
			System.out.println("\t\t\tMarch "+year);
			System.out.println("Sun\tMon\tTue\tWed\tThu\tFri\tSat");
			System.out.printf("---------------------------------------------------");
			break;
		case 4:
			System.out.println("\t\t\tApril "+year);
			System.out.println("Sun\tMon\tTue\tWed\tThu\tFri\tSat");
			System.out.printf("---------------------------------------------------");
			break;
		case 5:
			System.out.println("\t\t\tMay "+year);
			System.out.println("Sun\tMon\tTue\tWed\tThu\tFri\tSat");
			System.out.printf("---------------------------------------------------");
			break;
		case 6:
			System.out.println("\t\t\tJune "+year);
			System.out.println("Sun\tMon\tTue\tWed\tThu\tFri\tSat");
			System.out.printf("---------------------------------------------------");
			break;
		case 7:
			System.out.println("\t\t\tJuly "+year);
			System.out.println("Sun\tMon\tTue\tWed\tThu\tFri\tSat");
			System.out.printf("---------------------------------------------------");
			break;
		case 8:
			System.out.println("\t\t\tAugust "+year);
			System.out.println("Sun\tMon\tTue\tWed\tThu\tFri\tSat");
			System.out.printf("---------------------------------------------------");
			break;
		case 9:
			System.out.println("\t\t\tSeptember "+year);
			System.out.println("Sun\tMon\tTue\tWed\tThu\tFri\tSat");
			System.out.printf("---------------------------------------------------");
			break;
		case 10:
			System.out.println("\t\t\tOctober "+year);
			System.out.println("Sun\tMon\tTue\tWed\tThu\tFri\tSat");
			System.out.printf("---------------------------------------------------");
			break;
		case 11:
			System.out.println("\t\t\tNovember "+year);
			System.out.println("Sun\tMon\tTue\tWed\tThu\tFri\tSat");
			System.out.printf("---------------------------------------------------");
			break;
		case 12:
			System.out.println("\t\t\tDecember "+year);
			System.out.println("Sun\tMon\tTue\tWed\tThu\tFri\tSat");
			System.out.printf("---------------------------------------------------");
			break;
		}
	}
	public static int getMonthLength(int month,int year) { //Errors for years like 2000.
		if(month==1||month==3||month==5||month==7||month==8||month==10||month==12) {
			return 31;
		}else if(month==4||month==6||month==9||month==11){
			return 30;
		}else{//29 for leap,otherwise 28.
			if(year%4==0) {
				if(year%100==0) {
					if(year%400==0) {
						return 29;
					}
				}else {
					return 29;
				}
			}
		 return 28;
		}
	}
	public static void printBody(int monthLength,int d1) { //Works 5/3/22
		System.out.println();
		int k=0;
		for(;k<d1;k++) {
			System.out.printf("\t");
		}
		
		int i=1;
		int cntr=1;
		while(i<monthLength+1) {
			System.out.printf("%2d\t",i);
			if(d1==6) {
				System.out.println();
				int x=6-k+1;
				cntr=cntr-x;
			}
			i++;
			cntr++;
			d1++;
			if((cntr+6)%7==0&&(cntr+6)>7) {
				System.out.println();
			}
		}
		System.out.println(); //Make space for next month.
	}
	public static int updateD1(int monthLength,int d1) { //Works 5/2/22
		return (d1+monthLength)%7;
	}
}