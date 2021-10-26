import java.util.*;
interface method{
    abstract int billamount(int units);
    //generates the bill based on units consumed
    abstract boolean digitcounts(long mobilenum, int c);
    //counts the no of digits for mobile and adhar number
    abstract int idGenarator();
    //generats the officer id 
    abstract long Utrnumber();
    //generats the transaction number
    abstract long servicenumber();
    //generates the service number for user
}
class methods implements method {
    public int ref = 0,i=1,a=1;
    public boolean digitcounts(long mobilenumb, int c) {
        long digitcount = mobilenumb;
        int count = 0;
        while (digitcount != 0) {
            count += 1;
            digitcount /= 10;
        }
        if (count == c) {
            ref = 1;
            return true;
        } else {
            return false;
        }
    }
    public int idGenarator()
    {
        int code=62618;
        code*=100;
        code+=i;
        return code;
    }
    public long Utrnumber()
    {
        long utrcode=970166080;
        utrcode*=100;
        utrcode+=i*i+i;
        return utrcode;
    }

    public long servicenumber() {
        long servicecode = 62618310;
        servicecode = servicecode * 1000;
        servicecode = servicecode + a;
        a++;
        return servicecode;
    }  
      public int billamount(int units) {
        int amount = 0;
        int fixedcharges = 0;
        if (units <= 100) {
            amount = 0;
        } else if (units > 100 && units <= 200) {
            fixedcharges = 20;
            units -= 100;
            amount = (int) (units * 1.5) + fixedcharges;
        } else if (units > 200 && units <= 500) {
            fixedcharges = 30;
            units -= 100;
            amount = 100 * 2;
            amount += (units - 100) * 3 + fixedcharges;
        } else if (units > 500) {
            fixedcharges = 50;
            units -= 100;
            amount = (int) (100 * (3.5));
            amount += 300 * 4.6;
            amount += (units - 400) * 6.6 + fixedcharges;
        }
        return amount;

    }

}
