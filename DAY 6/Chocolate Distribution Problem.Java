public class ChocolateDistribution {

  public static int findMinDifference(int[] chocolates, int students) {
    if (students > chocolates.length) {
      return -1; // Not enough chocolates for all students
    }

    // Sort the chocolates in ascending order
    Arrays.sort(chocolates);

    // Initialize the minimum difference variable
    int minDifference = Integer.MAX_VALUE;

    // Iterate through the array to find the difference between subarrays of size 'students'
    for (int i = 0; i + students - 1 < chocolates.length; i++) {
      int difference = chocolates[i + students - 1] - chocolates[i];
      minDifference = Math.min(minDifference, difference);
    }

    return minDifference;
  }

  public static void main(String[] args) {
    int[] chocolates = {3, 4, 1, 9, 56, 7, 9, 12};
    int students = 5;
    int minDifference = findMinDifference(chocolates, students);
    System.out.println("Minimum difference in chocolates: " + minDifference);
  }
}
