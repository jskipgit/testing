package com.ironyard.service;

import com.ironyard.data.Train;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by jasonskipper on 1/25/17.
 */
public class TrainServiceTest {
    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void saveTrainToJson() throws  Exception {
        TrainService ts = new TrainService();
        // saved to disk
        Train savedToJson = getTrain();
        ts.saveTrainToJson(savedToJson);

        //read back from disk
        Train found = ts.fetchTrainFromJson();
        assertNotNull("Fetched train was null!", found);
        assertAllTrainPropertiesEqual(savedToJson, found);

    }

    @Test
    public void testTwoSavesInARow(){
        TrainService ts = new TrainService();
        // saved to disk
        Train savedToJson = getTrain();

        // save 2 times
        ts.saveTrainToJson(savedToJson);
        ts.saveTrainToJson(savedToJson);

        //read back from disk
        Train found = ts.fetchTrainFromJson();
        assertAllTrainPropertiesEqual(savedToJson, found);
    }

    private Train getTrain() {
        Train savedToJson = new Train();
        savedToJson.setDirection("N");
        savedToJson.setName("SunRail");
        savedToJson.setLatitude(22.3333);
        savedToJson.setLongitude(2.222);
        savedToJson.setSpeed(10000);
        return savedToJson;
    }

    private void assertAllTrainPropertiesEqual(Train savedToJson, Train found) {
        // compare all values from train for saved/loaded
        assertEquals("Tain name does not match!",savedToJson.getName(), found.getName());
        assertEquals("Speed no match!",savedToJson.getSpeed(), found.getSpeed());
        assertEquals("Direction no match!", savedToJson.getDirection(), found.getDirection());
        assertEquals("lat no match", savedToJson.getLatitude(), found.getLatitude(), .001);
        assertEquals("lat no match", savedToJson.getLongitude(), found.getLongitude(), .001);
    }

}