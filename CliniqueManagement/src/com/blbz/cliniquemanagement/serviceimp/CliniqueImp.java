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

    /*
    adding doctor detail
     */
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

    /*
    adding patient detail
     */
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

    /*
    validating the id. which is given by user
     */
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

    /*
    To retrieving appointment detail form the JSON
    need to pass date and person(Doctor/Patient)
     */
    @Override
    public void getAppointment(String id, String date, String person) {
        JSONObject tmp = (JSONObject) getAppointmentArray().get(date);
        if (tmp != null) {
            if (person.equals("Doctor")) {
                JSONArray ary = (JSONArray) tmp.get("Dc ID");
                if (ary.contains(id)) {
                    JSONArray ary1 = (JSONArray) tmp.get("Pt ID");
                    System.out.println("----------" + date + " Appointment Detail ----------");
                    for (Object s : (JSONArray) ary1.get(ary.indexOf(id))) {
                        int pos = getPid().indexOf(s);
                        System.out.print("Patient Name:" + getPname().get(pos));
                        System.out.print("\tPatient Age:" + getPtage().get(pos));
                        System.out.print("\tPatient Phone:" + getPphn().get(pos));
                        System.out.println();
                    }
                    System.out.println("________________________________________________");
                }
            } else if (person.equals("Patient")) {
                int i = 0;
                for (Object s : (JSONArray) tmp.get("Pt ID")) {
                    JSONArray ary = (JSONArray) s;
                    for (Object s1 : ary) {
                        if (id.equals(s1.toString())) {
                            JSONArray ary1 = (JSONArray) tmp.get("Dc ID");
                            int pos = getDid().indexOf(ary1.get(i));
                            System.out.println("----------" + date + " Appointment Detail ----------");
                            System.out.println("Doctor Name\t:\t" + getDname().get(pos));
                            System.out.println("Specialization\t:\t" + getDspc().get(pos));
                            System.out.println("Availability\t:\t" + getDavl().get(pos));
                            System.out.println("________________________________________________");
                            break;
                        }
                    }
                    ++i;
                }
            }
        }

    }

    /*
        it will search the doctor detail base on the search text
         */
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

    /*
    Creating appointment using patient id , doctor id and date
    it will check whether the doctor have 5 patient for one day, if he has then ask the user to make appointment for next day
    if patient aleady have appointment on the day it will show the appointment detail.
     */
    @Override
    public void createAppointment(String ptid, String dcid, LocalDate date) {
        JSONObject ap = new JSONObject();
        JSONArray ary = new JSONArray();
        JSONArray ary1 = new JSONArray();
        DateTimeFormatter pat = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String datestring = date.format(pat);

        ary.add(ptid);
        ary1.add(ary);
        ap.put("Pt ID", ary1);
        ary = new JSONArray();
        ary.add(dcid);
        ap.put("Dc ID", ary);


        if (getAppointmentArray() != null) {
            if (getAppointmentArray().get(datestring) != null) {
                ap = new JSONObject();
                ap = (JSONObject) getAppointmentArray().get(datestring);
                ary = new JSONArray();
                ary1 = new JSONArray();
                ary1 = (JSONArray) ap.get("Dc ID");
                if (ary1.contains(dcid)) {
                    ary = (JSONArray) ap.get("Pt ID");
                    ary = (JSONArray) ary.get(ary1.indexOf(dcid));
                    if (ary.size() < 5) {
                        if (ary.contains(ptid)) {
                            System.out.println("Already you have one appointment on this date. below is the detail");
                            getAppointment(ptid, datestring, "Patient");
                        } else {
                            ary.add(ptid);
                            writeJson();
                        }
                    } else {
                        System.out.println("All slot full. shall i set appointment on " + date.plusDays(1).format(pat) + "?\n" +
                                "Press 'y' for yes, any key for cancel");
                        if (Utility.getString().toUpperCase().equals("Y")) {
                            createAppointment(ptid, dcid, date.plusDays(1));
                        }
                    }
                } else {
                    ary1.add(dcid);
                    ary1 = (JSONArray) ap.get("Pt ID");
                    ary = new JSONArray();
                    ary.add(ptid);
                    ary1.add(ary);
                    writeJson();
                }
            } else {

                getAppointmentArray().put(datestring, ap);
                setAppointments(getAppointmentArray());
                writeJson();
            }

        }
    }

    /*
    it will create id for doctor and patient
     */
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
