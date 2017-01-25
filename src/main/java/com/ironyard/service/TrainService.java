package com.ironyard.service;

import com.google.gson.Gson;
import com.google.gson.stream.JsonWriter;
import com.ironyard.data.Train;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;

/**
 * Created by jasonskipper on 1/25/17.
 */
public class TrainService {


    public Train fetchTrainFromJson(){
        Train found = null;
        Gson util = new Gson();
        try {
            FileReader fileReader = new FileReader("/tmp/train.json");
            found = util.fromJson(fileReader, Train.class);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return found;
    }

    public void saveTrainToJson(Train aTrain){
        // save to json file
        try {
            Gson util = new Gson();
            FileWriter writer = new FileWriter("/tmp/train.json");
            util.toJson(aTrain, writer);
            writer.flush();
            writer.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

}
