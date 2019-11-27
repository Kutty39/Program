package com.blbz.cliniquemanagement.serviceimp;

import com.blbz.cliniquemanagement.service.Clinique;
import com.blbz.cliniquemanagement.utility.Utility;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import static com.blbz.cliniquemanagement.model.CliniqueModel.*;
import static com.blbz.cliniquemanagement.repository.CliniqueFileHandler.*;

public class CliniqueImp implements Clinique {
    public CliniqueImp() {
        readJson();
    }

    @Override
    public void addDoctor(String name, String specialization, String availability) {
        getDname().add(name);
        setDname(getDname());
        getDavl().add(availability);
        setDavl(getDavl());
        getDspc().add(specialization);
        setDspc(getDspc());
        getDid().add(getID("Doctor"));
        setDid(getDid());

        writeJson();
    }

    @Override
    public void addPatient(String pname, String ph, String age) {
        getPname().add(pname);
        setPname(getPname());
        getPphn().add(ph);
        setPphn(getPphn());
        getPtage().add(age);
        setPtage(getPtage());
        getPid().add(getID("Patient"));
        setPid(getPid());

        writeJson();
    }

    @Override
    public String validateID(String id) {
        readJson();
        if (getDid().contains(id)) {
            return "Doctor";
        } else if (getPid().contains(id)) {
            return "Patient";
        } else {
            return "invalid";
        }
    }

    @Override
    public void getAppointment(String date, String person) {

    }

    @Override
    public List<String> searchDoctor(String string) {
        List<String> idL = new ArrayList<>();
        int[] i = new int[1];
        i[0] = 0;
        if (getDid().contains(string)) {
            idL.add(string);
        } else if (getDname().contains(string)) {
            getDname().forEach(v -> {
                if (v.equals(string)) {
                    idL.add(String.valueOf(getDid().get(i[0])));
                    i[0] = i[0] + 1;
                }
            });
        } else if (getDspc().contains(string)) {
            getDspc().forEach(v -> {
                if (v.equals(string)) {
                    idL.add(String.valueOf(getDid().get(i[0])));
                }
                i[0] = i[0] + 1;
            });
        }
        System.out.println("ID\t\tName\tSpeciality\tAvailability");
        idL.forEach(v -> {
            int j = getDid().indexOf(v);
            System.out.print(v + "\t");
            System.out.print(getDname().get(j) + "\t");
            System.out.print(getDspc().get(j) + "\t");
            System.out.print(getDavl().get(j) + "\t");
            System.out.println();
        });
        return idL;
    }

    @Override
    public void createAppointment(String ptid, String dcid, String date) {
        JSONObject ap = new JSONObject();
        JSONObject ap1 = new JSONObject();
        JSONArray pary = new JSONArray();
        pary.add(ptid);
        ap.put("Pt ID", pary);
        ap.put("Dc ID", dcid);
        ap1.put(date, ap);
        pary.clear();
        pary.add(ap1);
        if (getAppointments() != null) {
            if (getAppointments().contains(date)) {
                ap = (JSONObject) getAppointments().get(getAppointments().indexOf(date));
                pary = (JSONArray) ap.get("Pt ID");
                if (pary.size() < 5) {
                } else {
                    System.out.println("All slot full. shall i set appointment on "+LocalDate.parse(date, DateTimeFormatter.ofPattern("dd/MM/yyyy")).plusDays(1).toString()+"?\n" +
                            "Press 'y' for yes, any key for cancel");
                    if(Utility.getString().toUpperCase().equals("Y")){
                        createAppointment(ptid,dcid, LocalDate.parse(date, DateTimeFormatter.ofPattern("dd/MM/yyyy")).plusDays(1).toString());
                    }
                }
            } else {
                getAppointments().add(ap1);
                setAppointments(getAppointments());
            }

        }
    }

    private String getID(String person) {
        long val = 0;
        if (person.equals("Doctor")) {
            val = (long) getDetails().get(0) + 1;
            getDetails().remove(0);
            getDetails().add(0, val);
            setDetails(getDetails());
            return "DC" + "0".repeat(4 - String.valueOf(val).length()) + val;
        } else {
            val = (long) getDetails().get(1) + 1;
            getDetails().remove(1);
            getDetails().add(1, val);
            setDetails(getDetails());
            return "PT" + "0".repeat(4 - String.valueOf(val).length()) + val;
        }

    }
}
