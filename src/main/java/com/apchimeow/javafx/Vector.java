package com.apchimeow.javafx;

import java.util.ArrayList;
import java.util.Random;

public class Vector {
    int x;
    int y;
    int z;
    static Vector vector[][];

    static Integer[] tri;
    Vector(int x,int y)
    {
        this.x=x;
        this.y=y;
        this.z=new Random().nextInt();
    }
    static void createVector(int n)
    {
        ArrayList<Integer> a=new ArrayList();
        vector=new Vector[n][n];
        for(int i=0;i<n;i++)
            for(int j=0;j<n;j++)
            {
                vector[i][j]=new Vector(i,j);

            }
        for(int i=0;i<n-1;i++)
            for(int j=0;j<n-1;j++) {
                a.add(i*n+j);
                a.add((i+1)*n+j);
                a.add(i*n+(j+1));

                a.add((i+1)*n+j);
                a.add((i+1)*n+(j+1));
                a.add(i*n+(j+1));
            }
        tri=new Integer[0];
        tri=a.toArray(tri);
    }
    static void writeVector()
    {
        for(int i=0;i<vector.length;i++)
        {
            System.out.println("\n");
            for(int j=0;j<vector.length;j++)
                System.out.print(" ("+vector[i][j].x+";"+vector[i][j].y+";"+vector[i][j].z+") "+(i*vector.length+j)+"   ");
        }
        System.out.println("\n");
        for (int i=0;i<tri.length;i+=3)
            System.out.print(" ("+tri[i]+";"+tri[i+1]+";"+tri[i+2]+") ");

    }
    public static void main(String[] args)
    {
        Vector.createVector(4);
        Vector.writeVector();
    }
}
