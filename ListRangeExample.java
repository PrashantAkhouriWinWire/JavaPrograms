public class ListRangeExample {
    public void Run(String[] args) {
        
      //  System.out.println("Hello, World!");
       // String[] strarr = {"81", "84-100", "84-90", "84", "85"};   // [81-100]
        String [] strarr =       {"81", "81-100", "83-90", "84", "85"};

        //devlare a dynamic array to hold all the numbers
        int [] numbers = new int[50];

         // Split the strings by hyphen and convert to integers
        int j = 0;
        for (String str : strarr) {
                String[] parts = str.split("-");
                int min = Integer.parseInt(parts[0]);
                if (parts.length > 1) {
                int max = Integer.parseInt(parts[1]);
                
                   // fill all the numbers between min and max into the numbers array
                    for (int i = min; i <= max; i++) {
                    numbers[j] = i;
                    j++;
                    }
                } else {
                    numbers[j] = min;
                    j++;
                }
    }

    // sort the numbers array in ascending order    java.util.Arrays.sort(numbers);
    System.out.println("Sorted numbers:");
    java.util.Arrays.sort(numbers);

    // REmove numbers that are zero (0)
    int count = 0;
    for (int i = 0; i < numbers.length; i++) {
        if (numbers[i] != 0) {
            numbers[count] = numbers[i];
            count++;
        }
    }
    // Create a new array with the non-zero numbers
    int[] nonZeroNumbers = new int[count];
    for (int i = 0; i < count; i++) {
        nonZeroNumbers[i] = numbers[i];
    }
    numbers = nonZeroNumbers;
    
    // print the numbers
    for (int i = 0; i < numbers.length; i++) {
    System.out.println(numbers[i]);
    }


    System.out.println("Output:");
    int max = numbers[numbers.length - 1];
            int min = numbers[0];

    // check if number array contains all numbers between min and max
    boolean containsAll = true;
    for (int i = min; i <= max; i++) {
        boolean found = false;
        for (int j1 = 0; j1 < numbers.length; j1++) {
            if (numbers[j1] == i) {
                found = true;
                break;
            }
        }
        if (!found) {
            containsAll = false;
            break;
        }
    }

        if (!containsAll)
        {
            //System.out.println(i);
            //Print the original strarr
            for (String str : strarr) {
                System.out.println(str);
            }
            
        }
        else
        {
            //FInd the min - maximum number 
            int max1 = numbers[numbers.length - 1];
            int min1 = numbers[0];
            System.out.println(min1 + "-" + max1);

        }
    }
}
    
