package com.company.models;

import java.util.ArrayList;
public class Garden{
    private int SIZE = 10;
    private int nTanaman = 0;
    private String mGardenName;
    private ArrayList<Plant> pArrList;
    private int hasilPanen;
    public Garden(String pName)
    {
        pArrList = new ArrayList<Plant>(10);
        mGardenName = pName;
    }
    public Garden()
    {
        this("UGarden");
    }
    public boolean addPlant(Plant p)
    {
        if(nTanaman < SIZE)
        {
            pArrList.add(p);
            nTanaman++;
            return true;
        }else
            return false;
    }
    public int harvestPlant()
    {
        int tmpN=0;
        int i=0;
        while ((pArrList != null) && (i < pArrList.size()))
        {
            if(pArrList.get(i).getStatusTumbuh() == 4)
            {
                pArrList.remove(i);
                nTanaman--;
                tmpN++;
                i=0;
            }else
                i++;
        }
        hasilPanen = hasilPanen + (tmpN*100);
        return tmpN;
    }
    public void beriAir()
    {
        for (int i = 0; i < pArrList.size(); i++) {
            pArrList.get(i).beriAir();
        }
    }
    public void beriPupuk()
    {
        for (int i = 0; i < pArrList.size(); i++) {
            pArrList.get(i).beriPupuk();
        }
    }
    public void displayPlant()
    {
        System.out.println("----------" + mGardenName +
                "----------");
        System.out.println("There are " + nTanaman + " plant(s) in the garden");
                System.out.println("Your harvest point:" +
                        hasilPanen);
        for (int i = 0; i < pArrList.size(); i++) {
            pArrList.get(i).displayPlant();
        }
    }
    public int getHasilPanen()
    {
        return hasilPanen;
    }
}