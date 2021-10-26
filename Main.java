import java.util.*;
class Main extends UserDetails{
    public static void main(String[] args) {
        Main j=new Main();
        Scanner scan=new Scanner(System.in);
        int x=0,a=0,s=0;
        try{
            do{
            System.out.print("\033[H\033[2J");
            System.out.println("  ----    Welcome To Tamilnadu Electricity Board(TNEB)   ----");
            System.out.println("choose the options:");
            System.out.println("1.Officer Login:");
            System.out.println("2.Customer Pay:");
            s = scan.nextInt();
            try {
                Thread.sleep(3000);
            } catch (Exception e) {
                System.out.println(e);
            }
            if(s==1){
        try{
            do{
                 System.out.print("\033[H\033[2J");
                System.out.println("  ----    Welcome To Tamilnadu Electricity Board(TNEB)   ----");
                System.out.println("choose the options:");
                System.out.println("1.New Officer Registration:");
                System.out.println("2.Officer Login:");
                System.out.println("3.exit:");
                x = scan.nextInt();
                try {
                    Thread.sleep(3000);
                } catch (Exception e) {
                    System.out.println(e);
                }
                System.out.print("\033[H\033[2J");
                if (x == 1) {
                    j.officersignin();
                    x = 0;
                } else if (x == 2) {
                    int d=0,d1;
                    try{
            do{
                if(j.q==0)
                {
                    j.officersignin();
                }
                if(j.check==0)
                {
                    j.authentication();
                }
                if(j.check==1){
                 System.out.print("\033[H\033[2J");
                System.out.println("  ----    Welcome To Tamilnadu Electricity Board(TNEB)   ----");
                System.out.println("choose the options:");
                System.out.println("1.Officer Bill update:");
                System.out.println("2.Officer Bill pay:");
                System.out.println("3.Customer new Entry:");
                System.out.println("4.exit:");
                d1 = scan.nextInt();
                try {
                    Thread.sleep(3000);
                } catch (Exception e) {
                    System.out.println(e);
                }
                System.out.print("\033[H\033[2J");
                if(d1==1)
                {
                    j.customerBills();
                    d=0;
                }
                else if(d1==2)
                {
                    j.displaybills();
                    j.Officerpaying();
                    d=0;
                }
                else if(d1==3)
                {
                    j.customerDetail();
                    d=0;
                }
                else if(d1==4)
                {
                    System.out.println("Thank you....");
                    try {
                            Thread.sleep(3000);
                        } catch (Exception e) {
                            System.out.println(e);
                        }
                    d=1;
                }
            }
            }while(d==0);x=0;
        } catch (Exception e1) {
            System.out.println("you to need give in the form integer from 1-4 as mentioned");
            try {
                Thread.sleep(3000);
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }
                else if (x == 3) {
                    j.check = 0;
                    x=1;
                    break;
                } else 
                {
                    System.out.println("Choose the correct option :");
                    try {
                        Thread.sleep(3000);
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                    x = 0;
                }
            } while (x == 0);a=0;
        } catch (Exception e) {
            System.out.println("you to need give in the form integer from 1-4 as mentioned");
            try {
                Thread.sleep(3000);
            } catch (Exception e1) {
                System.out.println(e1);
            }
        }
    }else if(s==2){
        int e1=0,e2;
        do {
        System.out.print("\033[H\033[2J");
            System.out.println("  ----    Welcome To Tamilnadu Electricity Board(TNEB)   ----");
            System.out.println("choose the options:");
            System.out.println("1.Electricity bill Pay:");
            System.out.println("2.exit:");
            e2=scan.nextInt();
            try {
                Thread.sleep(3000);
            } catch (Exception e) {
                System.out.println(e);
            }
            System.out.print("\033[H\033[2J");
            
            if(e2==1){
                    j.displaybills();
                    j.customerchecking();
                    j.customerpay();
                    j.phonepay();
                    j.customerpaychecking();
                    e1 = 0;
                } 
                else if(e2==2){
                    System.out.println("Thanks you for paying Electricity Bill:");
                    e1 = 1;
                    break;
                    
                }
            }while(e1==0);a=0;
    }else if(s==3)
    {
        System.out.println("Thank You !");
        a=1;
        break;
    }

     System.out.print("\033[H\033[2J");

        }while(a==0);
     } catch (Exception e) {
            System.out.println("you to need give in the form integer from 1-4 as mentioned");
        }
    }     
}     
 