/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BL;

import java.util.Comparator;

/**
 *
 * @author Alex
 */
public class FileComparer implements Comparator<Datei>{

    @Override
    public int compare(Datei t1, Datei t2) {
        if(t2.isFile() && t1.isDirectory()){
            return -1;
        }
        else if((t1.isDirectory() && t2.isDirectory()) || (t1.isFile() && t2.isFile())) {
            if(t1.equals("..."))
            {
                return 1;
            }
            return t1.getName().compareTo(t2.getName());
        }
        else {
            return 0;
        }
    }
}
