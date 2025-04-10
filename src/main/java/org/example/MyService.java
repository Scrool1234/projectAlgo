package org.example;

import java.util.ArrayList;
import org.springframework.stereotype.Service;

@Service
public class MyService {
    public ArrayList<Integer> changeMoney(ArrayList<Integer> cones, int sum) {
        ArrayList<Integer> list = new ArrayList<>();

        for(int cone: cones) {
            while(sum >= cone) {
                list.add(cone);
                sum -= cone;
            }
        }

        if(sum == 0) return list;
        return null;
    }
}