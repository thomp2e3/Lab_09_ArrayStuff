import java.util.*;

public class Main
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        Random rnd = new Random();
        int sum = 0;
        double average;
        int[] dataPoints = new int[100];

        for (int i = 0; i < dataPoints.length; i++)
        {
            dataPoints[i] = rnd.nextInt(100) + 1;
        }
        for (int i = 0; i < dataPoints.length; i++)
        {
            System.out.print(dataPoints[i]);
            if (i != dataPoints.length - 1)
            {
                System.out.print(" | ");
            }
        }
        for (int i = 0; i < 100; i++){
            sum = sum + dataPoints[i];
        }

        int listMin = minimum(dataPoints);
        int listMax = maximum(dataPoints);
        average = getAverage(dataPoints);
        System.out.println();
        System.out.println("The average of the data points is: " + getAverage(dataPoints));
        System.out.println("The total sum of the data points is: " + sum);

        Scanner in = new Scanner(System.in);
        int chosenNumber = getRangedInt(in, "Pick your number [1-100]", 0, 101);
        int matches = numberMatch(dataPoints, chosenNumber);
        System.out.println("Your chosen number " + chosenNumber + " was found " + matches + " time(s)");
        System.out.println("It was found at position(s): " + numberCount(dataPoints, chosenNumber));
        System.out.println("The maximum value is " + listMax + ", the minimum value is " + listMin);


    }


    public static int getRangedInt(Scanner pipe, String prompt, int low, int high)
    {
        int number = 0;
        boolean validInput = false;

        do
        {
            System.out.print("\n" + prompt + ": ");
            if (pipe.hasNextInt())
            {
                number = pipe.nextInt();
                if (low < number && number < high)
                {
                    validInput = true;
                }
                else
                {
                    System.out.print("Please enter an integer within the valid range.");
                }
            }
            else
            {
                System.out.print("Invalid input, please enter an integer.");
                pipe.next();
            }
        } while (!validInput);
        return number;
    }

    public static int numberMatch(int[] array, int target)
    {
        int count = 0;
        ArrayList<Integer> matchPosition = new ArrayList<Integer>();
        for (int i = 0; i < array.length; i++)
        {
            if (array[i] == target)
            {
                count++;
                matchPosition.add(i);
            }
        }
        return count;
    }

    public static ArrayList<Integer> numberCount(int[] array, int target)
    {
        int count = 0;
        ArrayList<Integer> matchPosition = new ArrayList<Integer>();
        for (int i = 0; i < array.length; i++)
        {
            if (array[i] == target)
            {
                matchPosition.add(i);
            }
        }
        return matchPosition;
    }

public static int minimum(int[] array)
    {
        int min = array[0];
        for(int i = 0; i < array.length; i++)
        {
            if(array[i] < min)
            {
                min = array[i];
            }
        }
        return min;
    }

    public static int maximum(int[] array)
    {
        int max = array[0];
        for(int i = 0; i < array.length; i++)
        {
            if(array[i] > max)
            {
                max = array[i];
            }
        }
        return max;
    }

    public static double getAverage(int[] array)
    {
        double total = 0;
        double average = 0;
        for(int i = 0; i < array.length; i++)
        {
            total = total + array[i];
        }
        average = total / array.length;
        return average;
    }
}
