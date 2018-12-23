import java.util.*;


public class Main {

    static int n, m;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        Queue<Integer> q = new ArrayDeque<>();
        for(int i=1; i<=n; i++){
            q.add(i);
        }

        int cnt = 1;
        System.out.print("<");
        while(!q.isEmpty()){
            if(cnt == m){

                System.out.print(q.peek());
                if(q.size() != 1){
                    System.out.print(", ");
                }
                q.remove();
                cnt = 1;
            }
            else{
                q.add(q.peek());
                q.remove();
                cnt++;
            }
        }
        System.out.println(">");
    }

}
