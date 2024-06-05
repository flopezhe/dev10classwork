import java.util.Scanner;

public class Exercise10 {

    public static void main(String[] args) {
        // USPS
        // Below is an abbreviated version of the US Postal Service retail parcel rates:
        /*
        Lbs | Zones 1&2 | Zone 3
        ===============
        1      $7.50      $7.85
        2       8.25       8.70
        3       8.70       9.70
        4       9.20      10.55
        5      10.20      11.30
        */

        // 1. Collect the parcel lbs and zone (1, 2, or 3) from the user.
        // 2. Add `if`/`else if`/`else` logic to cover all rates.
        // Use whatever strategy you think is best. You can create compound conditions or nest if/else statements.
        // If a lbs/zone combo does not exist, print a warning message for the user.

        Scanner console = new Scanner(System.in);
        System.out.println("Enter parcel lbs:");
        int parcelLbs = Integer.parseInt(console.nextLine());
        System.out.println("Enter zone(1,2,3):");
        int parcelZone = Integer.parseInt(console.nextLine());

        if ((parcelLbs == 1 ) && (( parcelZone == ( 1)) || (parcelZone == 2))){
            System.out.println("Your rate is $7.50");
        } else if ((parcelLbs == 2 ) && (( parcelZone == ( 1)) || (parcelZone == 2))) {
            System.out.println("Your rate is $8.25");
        } else if ((parcelLbs == 3 ) && (( parcelZone == ( 1)) || (parcelZone == 2))){
            System.out.println( "Your rate is $8.70");
        }
    }
}
