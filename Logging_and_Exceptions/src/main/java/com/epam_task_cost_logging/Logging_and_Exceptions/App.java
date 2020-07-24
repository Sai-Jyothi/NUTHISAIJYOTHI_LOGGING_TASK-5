package com.epam_task_cost_logging.Logging_and_Exceptions;
import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Hello world!
 *
 */
public class App 
{
	public static final Logger LOGGER=LogManager.getLogger(App.class);
	 public static void main( String[] args )
	    {
	        Scanner sc=new Scanner(System.in);
	        InterestCalculator interestCalculator =new InterestCalculator();
	        HouseConstructionCost houseConstructionCost;
	        LOGGER.info("Select an option :  \\n 1.Simple Interest 2.Compound Interest\\n");
	        if(sc.nextInt()==1) {
	        	LOGGER.info("Enter principal, rate of interest and time in years :\n");
	        	double principal=sc.nextDouble();
	        	double rate=sc.nextDouble();
	        	double timeInYears=sc.nextDouble();
	        	LOGGER.info("The amount is:: "+interestCalculator.simpleInterest(principal, rate, timeInYears));
	        }
	        else {
	        	LOGGER.info("Enter principal, rate of interest and time in years and number of times interest is compounded in an year :\n");
	        	double principal=sc.nextDouble();
	        	double rate=sc.nextDouble();
	        	double timeInYears=sc.nextDouble();
	        	int noOfTimesInterestCompoundedInYear=sc.nextInt();
	        	LOGGER.info("Amount is: "+interestCalculator.compoundInterest(principal, rate, timeInYears,noOfTimesInterestCompoundedInYear));
	        }
	        LOGGER.info("\nHouse Construction -->\nEnter material standard as: (1.standard 2.above standard 3.high standard)");
	        int standard=sc.nextInt();
	        LOGGER.info("\n Also enter the total area of the house: ");
	        double area=sc.nextDouble();
	        if(standard==3){
	        	LOGGER.info("Do you want the house to be fully automated? Enter--\n 1.Yes 2.No\n");
	        	int option=sc.nextInt();
	        	houseConstructionCost=new HouseConstructionCost(standard,area,option==1?true:false);
	        	LOGGER.info("Total cost required: "+houseConstructionCost.cost());
	        }
	        else {
	        	houseConstructionCost=new HouseConstructionCost(standard,area);
	        	LOGGER.info("Total cost required: "+houseConstructionCost.cost());
	        }
	        sc.close();
	    }
}

/*OUTPUT ON CONSOLE:
2020-07-24 15:29:52 INFO  App:21 - Select an option :  \n 1.Simple Interest 2.Compound Interest\n
1
2020-07-24 15:30:02 INFO  App:23 - Enter principal, rate of interest and time in years :

345
3
6
2020-07-24 15:30:12 INFO  App:27 - The amount is:: 62.1
2020-07-24 15:30:12 INFO  App:37 - 
House Construction -->
Enter material standard as: (1.standard 2.above standard 3.high standard)
3
2020-07-24 15:30:17 INFO  App:39 - 
 Also enter the total area of the house: 
567
2020-07-24 15:30:20 INFO  App:42 - Do you want the house to be fully automated? Enter--
 1.Yes 2.No

1
2020-07-24 15:30:22 INFO  App:45 - Total cost required: 1417500.0
*/