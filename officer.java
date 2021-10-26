import java.util.Scanner;

interface officerInfo {
    abstract void officersignin();

    abstract void officerlogin();

    abstract void forgotpassword();

    abstract void authentication();

    abstract String getofficername();

    abstract String getofficername1();

    abstract String getofficerpassword();

    abstract String getofficerpassword1();

    abstract long getofficermobilenumber();

    abstract long getadharnumber();

    abstract void setofficername(String officername);

    abstract void setofficername1(String officername1);

    abstract void setadharnumber(long adharnumber);

    abstract void setofficerpassword(String password);

    abstract void setofficerpassword1(String password1);

    abstract void setofficermobilenumber(long mobilenumber);

    abstract void setofficermobilenumber1(long mobilenumber);
}

class officer extends methods implements officerInfo {
    Scanner scann = new Scanner(System.in);
    private String officername = "", officername1 = "";
    protected long officermobileNumber = 0, officermobilenumber1 = 0, adharnumber = 0;
    protected long officeridNumber = 0;
    private String password = "", password1 = "";
    public int check = 0, q = 0, ref = 0;

    public void officersignin() {
        System.out.print("\033[H\033[2J");
        System.out.println("  ----    Welcome To Tamilnadu Electricity Board(TNEB)   ----");
        System.out.println("          ----     Signin Page     ----\n");
        System.out.println("Provide the details to create new officer account\n\n");
        officeridNumber = idGenarator();
        setofficeridNumber(officeridNumber);
        System.out.println("please save your id: " + officeridNumber);
        System.out.println("Enter the officer name:   ");
        officername = scann.next();
        setofficername(officername);
        System.out.println("Enter the user 10 digit mobile number:   ");
        do {
            officermobileNumber = scann.nextLong();
            setofficermobilenumber(officermobileNumber);
            if (digitcounts(officermobileNumber, 10)) {
                ref = 1;
            } else {
                System.out.println("Please enter the full 10 digit mobile number !");
            }

        } while (ref == 0);
        ref = 0;
        System.out.println("Enter  Original Adharnumber  :");
        do {
            adharnumber = scann.nextLong();
            setadharnumber(adharnumber);
            if (digitcounts(adharnumber, 12)) {
                ref = 1;
            } else {
                System.out.println("Please enter the full 12 Adharnumber!");
            }
        } while (ref == 0);
        ref = 0;
        System.out.println("Enter the user password:   ");
        password = scann.next();
        setofficerpassword(password);
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            System.out.println(e);
        }

        System.out.print("\033[H\033[2J");

       System.out.println(" --If already sigin no need to again sign in--");
        q = 1;
    }

    public String getofficername() {
        return officername;
    }

    public long getadharnumber() {
        return adharnumber;
    }

    public String getofficername1() {
        return officername1;
    }

    public String getofficerpassword() {
        return password;
    }

    public String getofficerpassword1() {
        return password1;
    }

    public long getofficermobilenumber() {
        return officermobileNumber;
    }

    public long getofficermobilenumber1() {
        return officermobilenumber1;
    }

    public void setofficername(String officername) {
        this.officername = officername;
    }

    public void setofficeridNumber(long idnumber) {
        this.officeridNumber = idnumber;
    }

    public void setadharnumber(long adharnumber) {
        this.adharnumber = adharnumber;
    }

    public void setofficername1(String username1) {
        this.officername1 = username1;
    }

    public void setofficerpassword(String password) {
        this.password = password;
    }

    public void setofficerpassword1(String password1) {
        this.password1 = password1;
    }

    public void setofficermobilenumber(long mobilenumber) {
        this.officermobileNumber = mobilenumber;
    }

    public void setofficermobilenumber1(long mobilenumber1) {
        this.officermobilenumber1 = mobilenumber1;
    }

    public void officerlogin() {
        System.out.print("\033[H\033[2J");
        if (q == 0) {
            System.out.println("You need to create sign in:");
            officersignin();
        }
        System.out.println("  ----    Welcome To Tamilnadu Electricity Board(TNEB)   ----");
        System.out.println("          ----     Login Page     ----\n");
        System.out.println("Enter the user name    :   ");
        officername1 = scann.next();
        setofficername1(officername1);
        System.out.println("Enter the password     :   ");
        password1 = scann.next();
        setofficerpassword1(password1);
        try {
            Thread.sleep(2000);
        } catch (Exception e) {
            System.out.println(e);
        }

        System.out.print("\033[H\033[2J");

        System.out.println(" --If already login no need to again login--\n");
    }

    public void forgotpassword() {
        if (q == 0) {
            System.out.println("You need to create sign in:");
            officersignin();
        }
        System.out.println("Enter user mobile number:");
        ref = 0;
        do {
            officermobilenumber1 = scann.nextLong();
            setofficermobilenumber1(officermobilenumber1);
            if (digitcounts(officermobileNumber, 10)) {
                ref = 1;
            } else {
                System.out.println("Please enter the full 10 digit mobile number!");
            }
        } while (ref == 0);
        if (officermobileNumber == officermobilenumber1) {
            System.out.println("Officer Name :" + officername);
            System.out.println("Password     :" + password);
            try {
                Thread.sleep(5000);
            } catch (Exception e) {
                System.out.println(e);
            }
            this.authentication();
        } else {
            System.out.println("if you forgot mobile number, you need to contact Admin office:");
            System.out.println("else you need to create new account:");
            try {
                Thread.sleep(3000);
            } catch (Exception e) {
                System.out.println(e);
            }
            officersignin();
        }
    }

    public void authentication() {
        int o=0, y;

        this.officerlogin();
        if (this.getofficername().equalsIgnoreCase(this.getofficername1())
                && this.getofficerpassword().equals(this.getofficerpassword1())) {
            check = 1;
        } else {
            System.out.println("Wrong Password    :\n Please Enter the correct Credentials:");
            
            try {
                do {
                    System.out.println("    -- Authentication Page  --");
                    System.out.println("choose the below option:");
                    System.out.println("1.Userlogin:");
                    System.out.println("2.forget password:");
                    System.out.println("3.exit:");
                    y = scann.nextInt();
                    try {
                        Thread.sleep(1000);
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                    System.out.print("\033[H\033[2J");
                    if (y == 1) {
                        officerlogin();
                        if (this.getofficername().equalsIgnoreCase(this.getofficername1())
                                && this.getofficerpassword().equals(this.getofficerpassword1())) {
                            o = 1;
                        }
                        else{
                            System.out.println("You enter wrong Password:\nPlease try again:");
                            o=0;
                        }
                    } else if (y == 2) {
                        forgotpassword();

                    } else if (y == 3) {

                        break;
                    } else {
                        System.out.println("chose correct option:");
                    }
                    if (y != 1 && y != 2 &&  y != 3) {
                        o = 0;
                    }
                } while (o == 0);

            } catch (Exception e) {
                System.out.println("you to need give in the form integer from 1-4 as mentioned");
            }
        }
    }
}
