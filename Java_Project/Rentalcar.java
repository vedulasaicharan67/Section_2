import java.util.Scanner;

class RentalCarFleetManager {

    static void displayCars(String[] carNames, String[] carTypes,
                            double[] rent, boolean[] available, int n){

        System.out.println("\n----- CAR FLEET -----");

        for (int i = 0; i < n; i++) {
            System.out.println("Car ID       : " + (i + 1));
            System.out.println("Car Name     : " + carNames[i]);
            System.out.println("Car Type     : " + carTypes[i]);
            System.out.println("Rent/Day     : Rs." + rent[i]);

            if (available[i])
                System.out.println("Status       : Available");
            else
                System.out.println("Status       : Rented");

            System.out.println("---------------------");
        }
    }


    static void searchCar(String[] carNames, String[] carTypes,
                          double[] rent, boolean[] available, int n,
                          String search) {

        boolean found = false;

        for (int i = 0; i < n; i++) {

            if (carNames[i].equalsIgnoreCase(search)) {
                System.out.println("\nCar Found!");
                System.out.println("Car ID    : " + (i + 1));
                System.out.println("Name      : " + carNames[i]);
                System.out.println("Type      : " + carTypes[i]);
                System.out.println("Rent/Day  : Rs." + rent[i]);

                if (available[i])
                    System.out.println("Status    : Available");
                else
                    System.out.println("Status    : Rented");

                found = true;
            }
        }

        if (!found)
            System.out.println("Car not found.");
    }

    static void rentCar(String[] carNames, double[] rent,
                        boolean[] available, int n,
                        int id, int days) {

        if (id < 1 || id > n) {
            System.out.println("Invalid Car ID!");
        }
        else if (!available[id - 1]) {
            System.out.println("Sorry! This car is already rented.");
        }
        else {
            double total = rent[id - 1] * days;

            available[id - 1] = false;

            System.out.println("\nCar rented successfully!");
            System.out.println("Car       : " + carNames[id - 1]);
            System.out.println("Days      : " + days);
            System.out.println("Total Rent: Rs." + total);
        }
    }

    static void returnCar(String[] carNames, boolean[] available,
                          int n, int id) {

        if (id < 1 || id > n) {
            System.out.println("Invalid Car ID!");
        }
        else if (available[id - 1]) {
            System.out.println("This car is already available.");
        }
        else {
            available[id - 1] = true;
            System.out.println(carNames[id - 1] + " returned successfully!");
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // 1D Arrays
        String[] carNames = {
                "Swift",
                "Baleno",
                "Creta",
                "Nexon",
                "Innova"
        };

        String[] carTypes = {
                "Hatchback",
                "Hatchback",
                "SUV",
                "SUV",
                "MUV"
        };

        double[] rent = {
                1500,
                1700,
                2500,
                2200,
                3000
        };

        boolean[] available = {
                true,
                true,
                true,
                false,
                true
        };

        int n = carNames.length;
        int choice;

        do {
            System.out.println("\n================================");
            System.out.println("     RENTAL CAR FLEET MANAGER");
            System.out.println("================================");
            System.out.println("1. Display All Cars");
            System.out.println("2. Search Car");
            System.out.println("3. Rent a Car");
            System.out.println("4. Return a Car");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    displayCars(carNames, carTypes, rent,
                            available, n);
                    break;

                case 2:
                    System.out.print("Enter car name to search: ");
                    String search = sc.nextLine();

                    searchCar(carNames, carTypes, rent,
                            available, n, search);
                    break;

                case 3:
                    System.out.print("Enter Car ID: ");
                    int rentId = sc.nextInt();

                    System.out.print("Enter number of days: ");
                    int days = sc.nextInt();

                    if (days <= 0) {
                        System.out.println("Invalid number of days!");
                    }
                    else {
                        rentCar(carNames, rent, available,
                                n, rentId, days);
                    }
                    break;

                case 4:
                    System.out.print("Enter Car ID to return: ");
                    int returnId = sc.nextInt();

                    returnCar(carNames, available,
                            n, returnId);
                    break;

                case 5:
                    System.out.println("Thank you for using Rental Car Fleet Manager!");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 5);

        sc.close();
    }
}