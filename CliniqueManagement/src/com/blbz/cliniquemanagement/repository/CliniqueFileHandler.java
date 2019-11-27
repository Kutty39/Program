package com.blbz.cliniquemanagement.repository;

import com.blbz.cliniquemanagement.model.CliniqueModel;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import static com.blbz.cliniquemanagement.model.CliniqueModel.*;

public class CliniqueFileHandler {
    public CliniqueFileHandler() {
        readJson();
    }

    public static void readJson() {
        try (FileReader fr = new FileReader(getFilename())) {
            JSONObject base = (JSONObject) jsonreader.parse(fr);
            setBase(base);
            setDoctor((JSONObject) base.get("Doctors"));
            getDoctor().forEach((k, v) -> {
                switch (k.toString()){
                    case "Name":
                        setDname((JSONArray) v);
                        break;
                    case "ID":
                        setDid((JSONArray) v);
                        break;
                    case "Availability":
                        setDavl((JSONArray) v);
                        break;
                    case "Specialization":
                        setDspc((JSONArray) v);
                        break;
                }
            });
            setPatients((JSONObject) base.get("Patients"));
            getPatients().forEach((k, v) -> {
                switch (k.toString()){
                    case "Name":
                        setPname((JSONArray) v);
                        break;
                    case "ID":
                        setPid((JSONArray) v);
                        break;
                    case "Age":
                        setPtage((JSONArray) v);
                        break;
                    case "Phone":
                        setPphn((JSONArray) v);
                        break;
                }
            });
            setAppointments((JSONArray) base.get("Appointment"));
            setDetails((JSONArray) base.get("Details"));
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }

    public static void writeJson() {
        try (FileWriter fw = new FileWriter(getFilename())) {
            fw.write(getBase().toJSONString());
            fw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
