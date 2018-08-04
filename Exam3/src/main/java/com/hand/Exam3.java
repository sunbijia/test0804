package com.hand;

/**
 * @author bijia.sun@hand-china.com
 * @date 2018/8/4 11:32
 */
import java.util.List;
import java.util.ArrayList;
import java.util.Vector;
import java.util.Set;
import java.util.HashSet;
import java.util.Map;
import java.util.HashMap;
import java.util.Vector;
import java.util.Collections;
import java.util.Comparator;
public class Exam3 {
    public static void main(String args[]) {
        List<Integer> list = new ArrayList<Integer>();
        Map<Integer, List<Integer>> mymap = new HashMap<Integer, List<Integer>>();
        List<Integer> tp;

        List<List<Integer>> vc = new ArrayList<List<Integer>>();
        for(int j = 0;j < 11;j++)vc.add(new ArrayList<Integer>());
        for(int i = 0;i < 50;++i){
            int temp = (int)(Math.random()*100);
            list.add(temp);
        }
        System.out.print("随机生成50个小于100的数,分别为：");
        for(Integer ex : list){
            System.out.print(ex);
            System.out.print(' ');
            int kj = 0;
            if(ex >= 10)kj = ex / 10;
            else kj = ex;
            tp = vc.get(kj);
            tp.add(ex);
        }
        System.out.print('\n');
        for(int j = 0;j < 11;j++)
        {
            //vc.get(j).sort();
            Collections.sort(vc.get(j), new Comparator<Integer>() {


                public int compare(Integer o1, Integer o2) {
                    //return o2.compareTo(o1); //降序
                    return o1.compareTo(o2);  //升序
                }

            });

            mymap.put(j,vc.get(j));
        }
        System.out.print("排序后的Map为：");
        for (Integer key : mymap.keySet()) {

            System.out.print(key + "=>[" );
            for(Integer ex : mymap.get(key)){
                System.out.print(ex);
                System.out.print(' ');
            }
            System.out.print("], " );
        }
    }
}
