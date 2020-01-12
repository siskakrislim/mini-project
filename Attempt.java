
public class Attempt {

	public static void main(String[] args) {
		String[]menu= {"Rent Mountain Bike","Rent Children Bike","Rent Double Bike","Rent Bike with baby seats","Earning Report"};
		int [] bicycles= new int[20];
		int choice=-1;
		dataInject(bicycles);
		while(choice!=0) {
			choice =Helper.getUserOption("SIMRide", menu);
			if(choice==1) {
				System.out.println(menu[choice-1]);
				rentBike(bicycles,1,5);// TODO Auto-generated method stub
			}else if(choice==2) {
				System.out.println(menu[choice-1]);
				rentBike(bicycles,6,10);
			}else if(choice==3) {
				System.out.println(menu[choice-1]);
				rentBike(bicycles,11,15);
			}else if(choice==4) {
				System.out.println(menu[choice-1]);
				rentBike(bicycles,16,20);
			}else if(choice==5) {
				System.out.println(menu[choice-1]);
				earningReport(bicycles);
			}printAll(bicycles);
	}System.out.println("Goodbye");
	
	}public static void rentBike(int[]bicycles, int startIndex,int endIndex) {
		int id=Helper.readInt("Enter bike ID ("+startIndex+" to "+endIndex+"):");
		while(id<startIndex || id>endIndex) {
			System.out.println("Invalid ID");
			id=Helper.readInt("Enter bike ID ("+startIndex+" to "+endIndex+"):");
		}
		bicycles[id-1]++;
		System.out.println("Bike ID "+id+" rented out");
	}//internal method testing. inject rental count into the array
	public static void dataInject(int []bicycles) {
		bicycles[0]=10;
		bicycles[2]=8;
		bicycles[4]=3;
		bicycles[12]=23;
		bicycles[19]=112;
		
	}
	public static void printAll(int[] bicycles) {
		for (int i=0;i<bicycles.length;i++) {
			System.out.printf("ID %d, rental count %d \n",(i+1),bicycles[i]);
		}
	}public static void earningReport(int[] bicycles) {
		int [] typeOfBikeRentalCount=new int[4];
		double[]typeOfBikeEarning=new double[4];
		for(int i=0;i<bicycles.length;i++) {
			if(i>=0&&i<=4) {//Mountain Bike
				typeOfBikeRentalCount[0]+=bicycles[i];
				typeOfBikeEarning[0]+=bicycles[i]*4;
			}else if(i>=5&&i<=9) {
				typeOfBikeRentalCount[1]+=bicycles[i];
				typeOfBikeEarning[1]+=bicycles[i]*2;
			}else if(i>=10&&i>=14) {
				typeOfBikeRentalCount[2]+=bicycles[i];
				typeOfBikeEarning[2]+=bicycles[i]*3;
			}else if(i>=15&&i>=19) {
				typeOfBikeRentalCount[3]+=bicycles[i];
				typeOfBikeEarning[3]+=bicycles[i]*5;
			}
		}System.out.printf("Mountain Bike - rental count: %d earning: %.2f\n",typeOfBikeRentalCount[0],typeOfBikeEarning[0]);
		System.out.printf("Children Bike - rental count: %d earning: %.2f\n", typeOfBikeRentalCount[1],typeOfBikeEarning[1]);
		System.out.printf("Double Bike - rental count: %d earning: %.2f\n", typeOfBikeRentalCount[2],typeOfBikeEarning[2]);
		System.out.printf("Baby Seats Bike - rental count: %d earning: %.2f\n", typeOfBikeRentalCount[3],typeOfBikeEarning[3]);
		double totalEarning=0;
		for(int i=0;i<typeOfBikeEarning.length;i++) {
			totalEarning+=typeOfBikeEarning[i];
		}System.out.printf("Total earning:$%.2f\n",totalEarning);
	}
		
}
