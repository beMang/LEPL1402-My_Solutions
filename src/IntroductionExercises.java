public class IntroductionExercises {

    public static int variable = 0;

    public static int[] squares;

    public static void attribute(int value){
        IntroductionExercises.variable = value;
    }

    public static int add(int a, int b){
        return a+b;
    }

    public static boolean equalsIntegers(int a, int b){
        return a==b;
    }

    public static int middleValue(int a, int b, int c){
        if (a==b || a==c || b==c) {
            return -1;
        } else {
            if (c < a && c < b) {
                if (b>a) {
                    return a;
                } else {
                    return b;
                }
            } else if (a < b && a < c) {
                if (c>b) {
                    return b;
                } else {
                    return c;
                }
            } else {
                if (c>a){
                    return a;
                } else {
                    return c;
                }
            }
        }
    }

    public static int max(int a, int b){
        return (a>b)? a : b;
    }

    public static String greetings(String str){
        switch (str){
            case "Morning":
                return "Good morning, sir!";
            case "Evening":
                return "Good evening, sir!";
            default:
                return "Hello, sir!";
        }
    }

    public static int[] lastFirstMiddle(int[] a){
        int[] result = new int[3];
        result[0] = a[a.length - 1];
        result[1] = a[0];
        result[2] = a[a.length / 2];

        return result;
    }

    public static int sum(int[] array){
        int sum = 0;
        for (int n : array) {
            sum += n;
        }
        return sum;
    }

    public static int maxArray(int[] array){
        int i = 1;
        int length = array.length;
        int max = array[0];

        while (i<length){
            if (max < array[i]) {
                max = array[i];
            }
            i ++;
        }
        return max;
    }

    public static void main(String... args){
        IntroductionExercises.squares = new int[args.length];
        int i = 0;
        for (String str : args){
            try {
                IntroductionExercises.squares[i] = Integer.parseInt(str)*Integer.parseInt(str);
            } catch (NumberFormatException e){
                IntroductionExercises.squares[i] = 0;
            }
            i++;
        }
    }
}