package ScoreApp;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Driver {
	static Scanner sc=new Scanner(System.in); 
	static ScoreDescription obj=new ScoreDescription();
	static DecimalFormat df=new DecimalFormat("#.##");

	public static void main(String[] args) {
		System.out.println("========================================");
		System.out.println();
		System.out.println();
		System.out.println("Welcome !");
		System.out.println("==========================================");
		
		System.out.println("Enter team name who is going to bat:");
		String name=sc.nextLine();
		obj.setTeamName(name);
		System.out.println("Enter the number of overs:");
		int n=sc.nextInt();
		System.out.println("Hi!   let's start:):)");
		
		int count =1;
	outer:	while(count<=n||obj.getWickets()>=10)
		{
		double ball=0;
			while(ball<0.6)
			{
				
				System.out.println("Over no:"+count+" is in progress!");
				System.out.println("press 1 for wide/noball");
				System.out.println("press 2 for wickets");
				System.out.println("press 3 for runs(like press 0,1,2,3,4,6");
				System.out.println();
				System.out.println("press!!");
				int op=sc.nextInt();
				switch(op)
				{
				case 1:
					System.out.println("Enter runs including wide/noball");
					int run=sc.nextInt();
					obj.setRuns(obj.getRuns()+run);
				
					break;
				case 2:
					ball+=0.1;
					obj.setWickets(obj.getWickets()+1);
					obj.setOvers(obj.getOvers()+0.1);
					if(obj.getWickets()>=10)
					{
						System.out.println("All out!!");
					  livescore();
					  break outer;
					}
					 	
					break;
				case 3:
					
					System.out.println("Runs is:");
					int runs=sc.nextInt();
					if(runs>=0&& runs<=6 && runs!=5)
					{
					obj.setRuns(obj.getRuns()+runs);
					}
					else
					{
						System.out.println("Run is not valid!");
						break;
					}
					ball+=0.1;
					obj.setOvers(obj.getOvers()+0.1);
					break;
				default:
					System.out.println("Please enter valid option:");
					break;
				}
					
			}
			obj.setOvers(obj.getOvers()+0.4);
		    livescore();
			count++;
		}

	}

	private static void livescore() {
		System.out.println("========="+obj.getTeamName()+"==========");
		System.out.println("Runs:"+obj.getRuns());
		System.out.println("Wickets:"+obj.getWickets());
		System.out.println("Overs:"+df.format(obj.getOvers()));
		System.out.println("Run Rate:"+df.format(obj.getRuns()/obj.getOvers()));
		System.out.println("=========================================");
		System.out.println();
		
	}

}
