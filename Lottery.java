import java.util.HashMap;
import java.util.ArrayList;
public class Lottery {
	int one;
	int two;
	int three;
	int four;
	int five;
	boolean status = true;
	int count = 0;
	int firstRand;
	int secondRand;
	int thirdRand;
	int fourthRand;
	int fifthRand;
	int fourCount = 0;
	int threeCount = 0;
	int twoCount = 0;
	int oneCount = 0;
	int noneCount = 0;
	
	
	public Lottery(int one, int two, int three, int four, int five){
		this.one = one;
		this.two = two;
		this.three = three;
		this.four = four;
		this.five = five;
		
		int[] winList = {one, two, three, four, five};
		
		ArrayList<Integer> winning = new ArrayList<>();
		winning.add(one);
		winning.add(two);
		winning.add(three);
		winning.add(four);
		winning.add(five);
		
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		int hashcount = 0;
		
		while(status == true)
		{
			boolean duplicate_status = true;
			while(duplicate_status==true)
			{
				int first_rand = (int)(Math.random()*(70 - 1) + 1);
				int second_rand = (int)(Math.random()*(70 - 1) + 1);
				int third_rand = (int)(Math.random()*(70 - 1) + 1);
				int fourth_rand = (int)(Math.random()*(70 - 1) + 1);
				int fifth_rand = (int)(Math.random()*(70 - 1) + 1);
				
				if (first_rand != second_rand && first_rand != third_rand && first_rand != fourth_rand && first_rand != fifth_rand &&
						second_rand != third_rand && second_rand != fourth_rand && second_rand != fifth_rand &&
						third_rand != first_rand && third_rand != fourth_rand && third_rand != fifth_rand && 
						fourth_rand != first_rand && fourth_rand != second_rand && fourth_rand != fifth_rand && 
						fifth_rand != first_rand && fifth_rand != second_rand && fifth_rand != third_rand)
				{
					duplicate_status = false;
					firstRand = first_rand;
					secondRand = second_rand;
					thirdRand = third_rand;
					fourthRand = fourth_rand;
					fifthRand = fifth_rand;
				}
			}
			
			ArrayList <Integer> randNum = new ArrayList<>();
			randNum.add(firstRand);
			randNum.add(secondRand);
			randNum.add(thirdRand);
			randNum.add(fourthRand);
			randNum.add(fifthRand);
			
			if (map.containsKey(firstRand))
			{
				hashcount = map.get(firstRand);
				hashcount++;
				map.replace(firstRand, hashcount);
			}
			else
			{
				map.put(firstRand, 1);
			}
			
			if (map.containsKey(secondRand))
			{
				hashcount = map.get(secondRand);
				hashcount++;
				map.replace(secondRand, hashcount);
			}
			else
			{
				map.put(secondRand, 1);
			}
			if (map.containsKey(thirdRand))
			{
				hashcount = map.get(thirdRand);
				hashcount++;
				map.replace(thirdRand, hashcount);
			}
			else
			{
				map.put(thirdRand, 1);
			}
			if (map.containsKey(fourthRand))
			{
				hashcount = map.get(fourthRand);
				hashcount++;
				map.replace(fourthRand, hashcount);
			}
			else
			{
				map.put(fourthRand, 1);
			}
			if (map.containsKey(fifthRand))
			{
				hashcount = map.get(fifthRand);
				hashcount++;
				map.replace(fifthRand, hashcount);
			}
			else
			{
				map.put(fifthRand, 1);
			}
			
//			int[] pickList = {firstRand, secondRand, thirdRand, fourthRand, fifthRand};
			
			int checkCount = 0;
			for (int x : randNum)
			{
				if (winning.contains(x))
				{
					checkCount++;
				}
			}
			if (checkCount == 0)
			{
				noneCount++;
				System.out.println("Failed: [" + firstRand + "|" + secondRand + "|" + thirdRand + "|" + fourthRand + "|" + fifthRand + "]");
				count++;
			}
			
			else if (checkCount == 1)
			{
				oneCount++;
				System.out.println("Failed: [" + firstRand + "|" + secondRand + "|" + thirdRand + "|" + fourthRand + "|" + fifthRand + "]");
				count++;
			}
			
			else if (checkCount == 2)
			{
				twoCount++;
				System.out.println("Failed: [" + firstRand + "|" + secondRand + "|" + thirdRand + "|" + fourthRand + "|" + fifthRand + "]");
				count++;
			}
			
			else if (checkCount == 3)
			{
				threeCount++;
				System.out.println("Failed: [" + firstRand + "|" + secondRand + "|" + thirdRand + "|" + fourthRand + "|" + fifthRand + "]");
				count++;
			}
			
			else if (checkCount == 4)
			{
				fourCount++;
				System.out.println("Failed: [" + firstRand + "|" + secondRand + "|" + thirdRand + "|" + fourthRand + "|" + fifthRand + "]");
				count++;
			}
			
			else if (checkCount == 5)
			{
				count++;
				System.out.println("Won lottery! Winning number: [" + firstRand + "|" + secondRand + "|" + thirdRand + "|" + fourthRand + "|" + fifthRand + "]");
				System.out.println("Total attempts: " + count);
				System.out.println("Matched 0 item: " + noneCount);
				System.out.println("Matched 1 item: " + oneCount);
				System.out.println("Matched 2 item: " + twoCount);
				System.out.println("Matched 3 item: " + threeCount);
				System.out.println("Matched 4 item: " + fourCount);
				System.out.println("Probability: " + (double) 1/count);
				System.out.println(map);
				status = false;
			}
//			
//			if ((firstRand != one && firstRand != two && firstRand != three && firstRand != four && firstRand != five) &&
//					(secondRand != one && secondRand != two && secondRand != three && secondRand != four && secondRand != five) &&
//					(thirdRand != one && thirdRand != two && thirdRand != three && thirdRand != four && thirdRand != five) &&
//					(fourthRand != one && fourthRand != two && fourthRand != three && fourthRand != four && fourthRand != five) &&
//					(fifthRand != one && fifthRand != two && fifthRand != three && fifthRand != four && fifthRand != five))
//			{
//				noneCount++;
//			}
//			
//			if ((firstRand == one || firstRand == two || firstRand == three || firstRand == four || firstRand == five) &&
//					(secondRand == one || secondRand == two || secondRand == three || secondRand == four || secondRand == five) &&
//					(thirdRand == one || thirdRand == two || thirdRand == three || thirdRand == four || thirdRand == five) &&
//					(fourthRand == one || fourthRand == two || fourthRand == three || fourthRand == four || fourthRand == five) &&
//					(fifthRand == one || fifthRand == two || fifthRand == three || fifthRand == four || fifthRand == five))
//			{
//				System.out.println("Won lottery! Winning number: [" + firstRand + "|" + secondRand + "|" + thirdRand + "|" + fourthRand + "|" + fifthRand + "]");
//				System.out.println("Total attempts: " + count);
//				System.out.println("Count for 0 items: " + noneCount);
//				System.out.println("Probability: " + (double) 1/count);
//				System.out.println(map);
////				System.out.println("Total number of " + one + ": " + map.get(one));
////				System.out.println("Total number of " + two + ": " + map.get(two));
////				System.out.println("Total number of " + three + ": " + map.get(three));
////				System.out.println("Total number of " + four + ": " + map.get(four));
////				System.out.println("Total number of " + five + ": " + map.get(five));
//				status = false;
//			}
//			else
//			{
//				System.out.println("Failed: [" + firstRand + "|" + secondRand + "|" + thirdRand + "|" + fourthRand + "|" + fifthRand + "]");
//				count++;
//			}
		}
	}
}
