class Cinema {
    String customer, movie;
    double price;
    int tickets;

    Cinema() {
        movie = "Avatar";
        price = 200;
    }

    Cinema(String m, double p) {
        movie = m;
        price = p;
    }

    void book(String c, int t) {
        customer = c;
        tickets = t;
        display();
    }

    void book(String c, String m, int t) {
        customer = c;
        movie = m;
        tickets = t;
        display();
    }

    void display() {
        System.out.println("\nCustomer: " + customer.toUpperCase());
        System.out.println("Movie: " + movie.toUpperCase());

        if (tickets <= 0) {
            System.out.println("Invalid tickets");
            return;
        }

        double total = price * tickets;
        double discount = tickets >= 5 ? total * 0.10 : 0;

        System.out.println("Tickets: " + tickets);
        System.out.println("Total: Rs. " + total);
        System.out.println("Discount: Rs. " + discount);
        System.out.println("Final Amount: Rs. " + (total - discount));
    }

    public static void main(String[] args) {
        Cinema b1 = new Cinema();
        b1.book("Sneha", 5);

        Cinema b2 = new Cinema("Avatar", 200);
        b2.book("Arjun", "Avatar", 2);

        System.out.println(b1.customer.equalsIgnoreCase(b2.customer)
                ? "Same Customer" : "Different Customers");
    }
}