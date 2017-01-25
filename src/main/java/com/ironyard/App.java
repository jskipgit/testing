package com.ironyard;

import com.ironyard.data.Train;
import com.ironyard.service.TrainService;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        TrainService myService = new TrainService();
        Train found = myService.fetchTrainFromJson();
        System.out.println("FOUND:"+found);
    }
}
