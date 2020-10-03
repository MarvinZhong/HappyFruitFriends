import java.util.Scanner;
public class Fruits {
    private static void caribuah(int money , int n, int[] fruit ) {
        caribuah(fruit, money, n,0,0,new int[n]);//run caribuah method with new data
    }
    private static void caribuah(int[] fruit, int money, int n, int all, int many, int[] result){
        if (many >= fruit.length || all > n){//if enough method
            return;
        }
        if (money >= 0 && n == all) {//money bigger than 0 and n is all
            for (int i = 0;i < n-1;i++)
                System.out.print(fruit[i]+" 元的 "+result[i]+" 個 、");//print with comma
            System.out.print(fruit[n-1]+" 元的 "+result[n-1]+" 個");//print without comma
            System.out.println();
            return;
        }
        for (int i = n; i >= 0 ;i--){
            result[many] = i;//result by many is i
            all += i;//all + i
            caribuah(fruit, money-fruit[many]*i, n, all, many+1, result);//recursion
            result[many] = 0;//result by many is 0
            all -= i;//all - i
        }
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int money = input.nextInt(); //input money
        int n = input.nextInt(); //input total number of fruits to buy
        int species = input.nextInt(); //input type of fruit
        int[] buah = new int[species]; //make array
        boolean murah = false; //boolean murah is false
        for (int i = 0; i < species; i++){ //for input list of price
            buah[i] = input.nextInt();
            if (buah[i]*n <= money)// if can buy fruit with the money then murah become true
                murah = true;
        }
        if (murah) //run caribuah method
            caribuah(money, n, buah);
        else
            System.out.println("Can't buy full"); //print Can't buy full
    }
}
