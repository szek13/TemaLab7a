package com.company;


import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

import static java.awt.SystemColor.text;

/**
 * Created by icondor on 12/11/16.
 */
public class NotepadLaunch {

    public static void main(String[] args) {

        // demo lucrul cu fisiere si colectii, atentie aici fisierul e citit doar la pornirea programului
        // daca adaugati elemente noi trebuie sa reporniti

        /* pasul 1. citesc din fisier linie cu linie si pun intr-o lista (de studiat java.util.List)  */

        /* pasul 2. pun lista intr-un map (de studiat java.util.Map) unde cheia = primul elem din lista, iar valoarea  = al doilea element din lista
         deci intai trebuie sa parsez fiecare element din linie dupa simbolul , ca sa le separ
         ionel,pass
         ana, pwd
         */

        /* pasul 3.
         found = false;
         while(!found) {
                citesc user
                citesc parola
                if combinatia user parola exista in map-ul de la 2 atunci
                found=true
        }
       */


        /*
        4. lansez notepad
        */
        //------------- gata pseudocodul --
      //  String = txtRead();
       // System.out.println("" + lines);
        txtRead();
        userAndPwdCheck();

        String np = notepadStart();
    }


        // pasul 1

    public static void txtRead() {

        Path wiki_path = Paths.get("D:\\Laborok", "passwords.txt");

        Charset charset = Charset.forName("UTF-8");

        List<String> lines = null;
        try {
            lines = Files.readAllLines(wiki_path, charset);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    // pasul 2

    public static void userAndPwdCheck() {


        Map<String, String> pwdStruct = new HashMap<String, String>();
        for (String str : lines) { // se executa de cate linii am
            // System.out.println(str);

            StringTokenizer st2 = new StringTokenizer(str, ",");

            while (st2.hasMoreElements()) { // se executa de cate elem am pe linie
                pwdStruct.put(st2.nextElement().toString(), st2.nextElement().toString());
            }
        }
    }

    // pasul 3

    public static String foundUserandPwd() {

        boolean isFound = false;
        while (!isFound) {

            String u = SkeletonJava.readStringConsole("Userul:");
            String p = SkeletonJava.readStringConsole("Parola:");

            // bug lasat pt tudor c
            //if(pwdStruct.containsKey(u) && pwdStruct.containsValue(p))
            //  isFound=true;


            for (Map.Entry<String, String> entry : pwdStruct.entrySet()) {
                if (u.equals(entry.getKey()) && p.equals(entry.getValue())) {
                    isFound = true;
                    break;
                }
            }
        }

    }



    //pasul 4 - tema de casa

    public static String notepadStart() {

        try

        {
            Runtime.getRuntime().exec("notepad.exe ");
        } catch (
                Exception e)

        {
            e.printStackTrace();
        }

        return("Notepad launched: ");
    }

}
