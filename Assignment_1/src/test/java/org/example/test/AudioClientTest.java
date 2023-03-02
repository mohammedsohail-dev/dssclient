package org.example.test;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;


import java.util.Random;


 class threaddetails{

    public static Integer numberofthreads=32;
    public static Integer numberofpostsperthread=10000;

}





class post extends Thread{
    public int j=0;
    @Override 
       public void run(){
    
       for(;j<=threaddetails.numberofpostsperthread;j++){
            try {
                TestPost.testLiftRidePost();
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    
    }
       }
    
    
    






class TestPost {


   
/// do get and do post for random gen data
    public static void testLiftRidePost() throws Exception {


        Integer minskierID=1;
        Integer maxskierID=100000;

        Random random1 = new Random();
        Integer skierID=random1.nextInt(maxskierID-minskierID+1)+minskierID;

        Integer minresortID=1;
        Integer maxresortID=10;

        Random random2 = new Random();
        Integer resortID=random2.nextInt(maxresortID-minresortID+1)+minresortID;
        
        Integer minliftID=1;
        Integer maxliftID=40;

        Random random3 = new Random();
        Integer liftID=random3.nextInt(maxliftID-minliftID+1)+minliftID;


                
        Integer mintime=1;
        Integer maxtime=360;

        Random random4 = new Random();
        Integer time=random4.nextInt(maxtime-mintime+1)+mintime;


        String jsonPayload = String.format("{\"time\": %d, \"liftID\": %d}", time,liftID);

        HttpClient httpClient = HttpClient.newHttpClient();


        String seasonID = "2022";
        String dayID = "1";

        URI uri = URI.create(String.format("http://168.138.69.171:8093/skiers/%d/seasons/%s/days/%s/skiers/%d", resortID,seasonID,dayID,skierID));

        HttpRequest request = HttpRequest.newBuilder()
                .uri(uri)
                .POST(HttpRequest.BodyPublishers.ofString(jsonPayload))
                .header("Content-Type", "application/json")
                .build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        int statusCode = response.statusCode();
        String responseBody = response.body();

        System.out.println("Status code: " + statusCode);
        System.out.println("Response body: " + responseBody);
		


	
	
}


}



class AudioClientTest{


    

    public static void main( String arg [] ) throws Exception{
        long begin = System.currentTimeMillis();  

   
        
        


     for(int i=0;i<=threaddetails.numberofthreads;i++){
   
     post posttest = new post();
     posttest.start();


     }

   


   long end = System.currentTimeMillis();
        
long dt = end - begin;

System.out.println(dt+"ms");

  

   

    
    


     



}






}
