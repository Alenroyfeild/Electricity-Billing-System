import java.util.ArrayList;

interface UsersInterface {
    abstract boolean custdetails();
    //used for to register user details

    abstract boolean custbills();
    //officer enter the units consumed by user
    abstract void customerDetail();

    abstract void customerBills();

    abstract void displaybills();
    //display the total users and bills

    abstract void Officerpaying();
    //officer can pay the bill
    abstract void customerchecking();
    //customer can get the details
    abstract void phonepay();
    //generats the transaction id

    abstract void customerpay();
    //customer can pay the bill
    abstract void customerpaychecking();
    // checking the transaction id is correct or not
}

class UserDetails extends officer implements UsersInterface {

    ArrayList<String> customername = new ArrayList<>();
    ArrayList<Long> customerservicenumber = new ArrayList<>();
    ArrayList<Integer> bill = new ArrayList<>();
    int i = 0, j, n, c = 0, z = 0;
    public boolean custdetail = false;
    public boolean custbill = false;
    int index, size;
    int tempfare;
    String tem;
    long UpiTransactionid = 0;

    public boolean custdetails() {
        return custdetail;
    }

    public boolean custbills() {
        return custbill;
    }

    public void customerDetail() {
        System.out.print("\033[H\033[2J");
        System.out.println("---    Customers name  Entering Page:    ---");

        int r = 0;
        do {
            System.out.println("enter New Customer name  : ");
            tem = scann.next();
            customername.add(tem);

            customerservicenumber.add(this.servicenumber());
            bill.add(0);
            custdetail = true;
            System.out.println("Enter 1 to add new customer and to exit enter other than 1:");
            r = scann.nextInt();
        } while (r == 1);
        size = customername.size();
        System.out.println("Total no of customers created is :" + size);
        try {
            Thread.sleep(3000);
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public void customerBills() {
        System.out.print("\033[H\033[2J");
        System.out.println("---    Customer Bill Entering Page:    ---");
        if (custdetail == true) {
            for (int i = 0; i < size; i++) {
                System.out.println("enter the fares according to the Names and service number");
                System.out.println("customer name           :" + customername.get(i) + " \n"
                        + "customer service number :" + customerservicenumber.get(i));
                System.out.print("Enter Units Consumed    :");
                int uni;
                uni = scann.nextInt();
                bill.set(i, bill.get(i) + this.billamount(uni));
            }
            custbill = true;
        } else {
            System.out.println("please enter the Customer Details:");
            try {
                Thread.sleep(3000);
            } catch (Exception e) {
                System.out.println(e);
            }
            this.customerDetail();

        }
    }

    public void displaybills() {
        System.out.print("\033[H\033[2J");
        System.out.println("---    Customer Bills Display Page:    ---");
        if (custbill == true) {
            for (int i = 0; i < size; i++) {
                System.out.println("");
                System.out.println("customer name           :" + customername.get(i) + " \n"
                        + "customer service number :" + customerservicenumber.get(i));
                System.out.println("Fare    :" + bill.get(i));
            }
        } else if (custdetail == true) {
            System.out.println("Please Update the Electricity bills:");
            try {
                Thread.sleep(3000);
            } catch (Exception e) {
                System.out.println(e);
            }
            this.customerBills();
        } else {
            System.out.println("please enter the Customer Details:");
            try {
                Thread.sleep(3000);
            } catch (Exception e) {
                System.out.println(e);
            }
            this.customerDetail();
        }
        try {
            Thread.sleep(3000);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void Officerpaying() {
        System.out.print("\033[H\033[2J");
        this.displaybills();
        System.out.println("\n\n---    Customer Payment Page:    ---\n");
        System.out.print("enter the Service Number:   ");
        long tempservicenumber;

        tempservicenumber = scann.nextLong();
        for (i = 0; i < size; i++) {
            if (tempservicenumber == customerservicenumber.get(i)) {
                index = i;
            }
        }
        System.out.println("Bill amount           :  " + bill.get(index));
        System.out.print("Enter the amount        :");
        tempfare = scann.nextInt();
        int temp = 0;
        temp = bill.get(index);

        if (tempfare > temp) {
            bill.set(index, bill.get(index) - tempfare);
            System.out.println("Successfully Paid......");
            System.out.println("Extra balanace: " + bill.get(index));
        } else if (tempfare <= temp) {
            bill.set(index, bill.get(index) - tempfare);
        }
        if (tempfare == temp) {
            System.out.println("Successfully Paid......");

        }
        if (tempfare < temp) {
            System.out.println("Successfully Paid......");
            System.out.println("Remaining bill balanace to be Pay:" + bill.get(index));
        }
        try {
            Thread.sleep(4000);
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public void customerchecking() {
        System.out.print("\033[H\033[2J");

        long tempservicenumber;
        this.displaybills();
        System.out.println("---    Customer Checking Page:    ---");
        System.out.println("Enter Service Number : ");
        do {
            tempservicenumber = scann.nextLong();

            if (digitcounts(tempservicenumber, 11)) {
                ref = 1;
            } else {
                System.out.println("Please enter the full 11 service number !");
            }
        } while (ref == 0);

        for (i = 0; i < size; i++) {
            if (tempservicenumber == customerservicenumber.get(i)) {
                index = i;
            }
        }
        c = 1;

    }

    public void phonepay() {
        System.out.print("\033[H\033[2J");
        if (z == 1) {

            if (tempfare != 0) {
                System.out.println("---    Customer bill Paying Page:    ---");
                UpiTransactionid = this.Utrnumber();
                System.out.println("Transaction Id: " + UpiTransactionid);
                System.out.println("please note  the Id:");
                c = 0;
                try {
                    Thread.sleep(5000);
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        }
    }

    public void customerpay() {
        System.out.print("\033[H\033[2J");
        System.out.println("---    Customer bill Checking Page:    ---");
        if (c == 1) {

            System.out.println("Customer service Number :" + customerservicenumber.get(index));
            System.out.println("        fare            :" + bill.get(index));
            tempfare = scann.nextInt();
            z = 1;
        }
        try {
            Thread.sleep(3000);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void customerpaychecking() {
        System.out.print("\033[H\033[2J");
        System.out.println("---    Customer Bill Pay Checking Page:    ---");
        if (c == 0 && z == 1) {
            long tempid;
            int k = 1;
            do {
                System.out.println("Please enter the Transaction Id: ");
                tempid = scann.nextLong();
                if (tempid == UpiTransactionid) {
                    int temp = 0;
                    temp = bill.get(index);

                    if (tempfare > temp) {
                        bill.set(index, bill.get(index) - tempfare);
                        System.out.println("Successfully Paid......");
                        System.out.println("Extra balanace: " + bill.get(index));
                    } else if (tempfare <= bill.get(index)) {
                        bill.set(index, bill.get(index) - tempfare);

                    }
                    if (tempfare == temp) {
                        System.out.println("Successfully Paid......");

                    }
                    if (tempfare < temp) {
                        System.out.println("Successfully Paid......");
                        System.out.println("Remaining bill balanace to be Pay:" + bill.get(index));
                    }
                    k = 0;
                    System.out.println("You paid electricity bill successfully....");
                    try {
                        Thread.sleep(3000);
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                } else {
                    System.out.println("Enter other than 1 to exit if u forgor transaction id:");
                    k = scann.nextInt();
                }
                try {
                    Thread.sleep(3000);
                } catch (Exception e) {
                    System.out.println(e);
                }
            } while (k == 1);
        }
    }
}