public class bits {
    public static void main(String[] args) {
        int num = 748,count = 0;
        while (num > 0) {
            System.out.println(Integer.toBinaryString(num));                    
            num = num & (num-1);
            count++;
        }
        System.out.println(count);
        num = 748; count = 0;
        while(num > 0) {
            System.out.println(Integer.toBinaryString(num));                    
            if(num % 2 == 1) {
                count++;
            }
            num = num / 2;            
        }
    }
}