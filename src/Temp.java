import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Temp {
}


//import java.io.IOException;
//        import java.net.URI;
//        import java.net.http.HttpClient;
//        import java.net.http.HttpRequest;
//        import java.net.http.HttpResponse;
//        import java.util.concurrent.ExecutorService;
//        import java.util.concurrent.Executors;
//
//class Main {
//    public static void main(String args[]) {
//        // 1. 스레드 풀 생성
//        ExecutorService service = Executors.newCachedThreadPool();
//        HttpClient httpClient = HttpClient.newBuilder().build();
//
//        // 2. 반복문을 통해 - 여러개의 스레드가 거의 동시에 인스턴스를 생성
//        for (int i = 0; i < 10; i++) {
//            int finalI = i;
//            service.submit(() -> {
//                String json = new StringBuilder()
//                        .append("{")
//                        .append("\"seq\":\""+finalI +"\"")
//                        .append("}").toString();
//                HttpRequest request = HttpRequest.newBuilder().POST(HttpRequest.BodyPublishers.ofString(json))
//                        .uri(URI.create("http://localhost:8080/api/v1/account/amount"))
//                        .header("Content-Type", "application/json")
//                        .build();
//
//                try {
//                    httpClient.send(request, HttpResponse.BodyHandlers.ofString());
//                } catch (IOException e) {
//                    e.printStackTrace();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//
//            });
//        }
//        // 3. 종료
//        service.shutdown();
//    }
//}