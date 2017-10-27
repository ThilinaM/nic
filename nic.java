package Model;

/**
 *
 * @author Thilina Dharmasena
 */
public class nic {
    public static nic NICOBJECT;
        public static String NIC;

    public nic(String NIC) {
    }

    
    public static nic model_DOB_getInstance(String nic) {
        if (NICOBJECT == null) {
            NIC = nic;
            NICOBJECT = new nic(nic);
            return NICOBJECT;
        } else {
            NICOBJECT = null;
            NIC = nic;
            NICOBJECT = new nic(nic);
            return NICOBJECT;
        }

    }
    
    public static void main(String[] args) {
      nic nic   = model_DOB_getInstance("938463469v");
      String []data =nic.process_birthday();
        System.out.println("Birth Day "+data[0]);
        System.out.println("Gender "+data[1]);
    }
    
    
    public String[] process_birthday() {
        try {
              if (NIC.length() == 10 & (NIC.endsWith("v") | NIC.endsWith("V") | NIC.endsWith("x") | NIC.endsWith("X"))) {

            int year = Integer.parseInt(NIC.substring(0, 2));
            int date = Integer.parseInt(NIC.substring(2, 5));
            int reg = Integer.parseInt(NIC.substring(5, 8));

            int d = 0;
            int m = 0;

            String sex = "";


            if (date < 500) {
                sex = "Male";
            } else {
                sex = "Female";
                date = date - 500;
            }




            if (date <= totalDays(1)) {
                m = 01;
                d = date;
            } else if (date <= totalDays(2)) {
                m = 02;
                d = date - totalDays(1);
            } else if (date <= totalDays(3)) {
                m = 03;
                d = date - totalDays(2);
            } else if (date <= totalDays(4)) {
                m = 04;
                d = date - totalDays(3);
            } else if (date <= totalDays(5)) {
                m = 05;
                d = date - totalDays(4);
            } else if (date <= totalDays(6)) {
                m = 06;
                d = date - totalDays(5);
            } else if (date <= totalDays(7)) {
                m = 07;
                d = date - totalDays(6);
            } else if (date <= totalDays(8)) {
                m = 8;
                d = date - totalDays(7);
            } else if (date <= totalDays(9)) {
                m = 9;
                d = date - totalDays(8);
            } else if (date <= totalDays(10)) {
                m = 10;
                d = date - totalDays(9);
            } else if (date <= totalDays(11)) {
                m = 11;
                d = date - totalDays(10);
            } else if (date <= totalDays(12)) {
                m = 12;
                d = date - totalDays(11);
            }
            String value[] = new String[2];
//            System.out.println("********************************************************");
//            System.out.println();
//            System.out.println("1. Your Date Of Birth is = 19" + year + "-" + m + "-" + d);
//            System.out.println();
//            System.out.println("2. You are  " + sex);
//            System.out.println();
//            System.out.println("3. Your Registration Number of that day = " + reg);
//            System.out.println();
//            System.out.println("********************************************************");
            //value[0] = "19" +year + "/" + m + "/" + d;
            value[0] = d+ "/" + m + "/" +"19" +year  ;
            value[1] = sex;

            return value;
        } else {

            System.out.println("You have entered an invalid NIC number, please try again!");
            return null;
        }

        } catch (Exception e) {
            return null;
        }
      


    }

     int totalDays(int x) {
        int[] monthDays = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int sum = 0;
        for (int i = 0; i < x; i++) {
            sum = sum + monthDays[i];
        }
        return sum;
    }
}


  

    

 