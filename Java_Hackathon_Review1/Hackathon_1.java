public class Hackathon_1 {

    static double calculateTotalWaste(double point1Waste, double point2Waste) {
        double totalweightc = point1Waste + point2Waste;
        return totalweightc;
    }
    public static void main(String[] args) {
        
        int vnum = 167;
        double weightc = 100;
        int collectionpoints = 10;
        char vstatus = 'A';

        System.out.println("Vehicle Number : "+vnum);
        System.out.println("Number Of Collection Points : "+collectionpoints);
        System.out.println("Vehicle Status : "+vstatus);

        if (weightc >= 100) {
            System.out.println("Collection Target Achieved");
        }

        else {
            System.out.println("More Waste Collection Required");
        }

        double totalweightc = calculateTotalWaste(100, 200);
        System.out.println("Total Weight Collected : "+totalweightc);
    }
}
