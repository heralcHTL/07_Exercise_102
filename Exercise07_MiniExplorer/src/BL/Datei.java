/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BL;

import java.io.File;
import java.text.SimpleDateFormat;

/**
 *
 * @author Alex
 */
public class Datei extends File {

    private static final SimpleDateFormat SDF = new SimpleDateFormat("dd.MM.yyyy hh:mm");
    private String displayName;

    public Datei(String filepath, String displayname) {
        super(displayname);

        File f = new File(filepath);

        if (f.exists()) {
            if (!f.isDirectory()) {
                String rwx = "";
                if (f.canRead()) {
                    rwx += "R";
                }
                if (f.canWrite()) {
                    rwx += "W";
                }
                if (f.canExecute()) {
                    rwx += "X";
                }
                displayName = String.format("%-25s %30s %5s", displayname, SDF.format(lastModified()), rwx);
            } else {
                displayName = displayname;
            }
        }

    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    @Override
    public String toString() {
        return String.format("%s", displayName);
    }

}
