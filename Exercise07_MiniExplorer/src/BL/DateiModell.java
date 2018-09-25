/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BL;

import java.io.File;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import javax.swing.AbstractListModel;

/**
 *
 * @author Alex
 */
public class DateiModell extends AbstractListModel {

    private LinkedList<Datei> list = new LinkedList<>();
    private File[] fileArray = new File[list.size()+1];

    private String pathname = System.getProperty("user.dir");
    private File filepath = new File(pathname);

    public void initPath() {
        Datei parentDatei = new Datei(filepath.getParent(), "...");
        list.add(parentDatei);
        fileArray = filepath.listFiles();
        for (int i = 0; i < fileArray.length; i++) {
            Datei d = new Datei(fileArray[i].getAbsolutePath(), fileArray[i].getName().toString());
            list.add(d);
        }

        Comparator comp = new FileComparer();
        Collections.sort(list, comp);
        this.fireIntervalAdded(this, 0, list.size()-1);
    }

    public void changeDir(String string) throws Exception{

        if (string.contains("...")) {
            list.clear();

            Datei dt = new Datei(filepath.getParent(), "...");
            list.add(dt);

            pathname = filepath.getParent();                    
            filepath = new File(pathname);
            fileArray = filepath.listFiles();

            for (int i = 0; i < fileArray.length; i++) {
                Datei d = new Datei(fileArray[i].getAbsolutePath(), fileArray[i].getName());
                list.add(d);
            }
            System.out.println("Filepath ...: " + filepath.getAbsolutePath());
        } else {
            list.clear();
            System.out.println("Übergabe: " +string);
            pathname = string;
            
            String newfilepath = filepath + File.separator + string;
//            System.out.println("Filepath 1: " +filepath.getAbsolutePath());
//            System.out.println("newfilepath 1: " + newfilepath);
            
            filepath = new Datei(newfilepath, pathname);
            
//            System.out.println("Filepath 2: " + filepath.getAbsolutePath());
//            System.out.println("newfilepath 2:" + newfilepath);
            
            Datei e = new Datei(filepath.getParent(), "...");
            list.add(e);
            
            fileArray = filepath.listFiles();
            
            
            for (int i = 0; i < fileArray.length; i++) {
                Datei d = new Datei(fileArray[i].getAbsolutePath(), fileArray[i].getName());
                list.add(d);
            }
        }
        Comparator comp = new FileComparer();
        Collections.sort(list, comp);
        this.fireIntervalAdded(this, 0, list.size()-1);
    }

    public File getFilepath() {
        return filepath;
    }

    @Override
    public int getSize() {
        return list.size();
    }

    @Override
    public Object getElementAt(int i) {
        return list.get(i);
    }
}
