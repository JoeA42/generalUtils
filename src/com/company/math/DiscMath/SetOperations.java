package com.company.math.DiscMath;

import java.util.ArrayList;

public class SetOperations {

    public static Set difference(Set firstSet, Set secondSet){
        Set R = new Set("R",firstSet);
        for(int i = 0;i<firstSet.getSize();i++) {
            if(belongs(firstSet.get(i), secondSet)){
                R.remove(firstSet.get(i));
            }
        }
//        System.out.println("El resultado de "+firstSet.getName()+" - "+secondSet.getName() +" es: ");
//        R.print();
        return R;

    }

    /**
     * This method takes as input two sets, and returns a boolean value, that determines if the first set is a subset of the second.
     * @param firstSet The set that is being evaluated
     * @param secondSet The set that is being used by the first one.
     * @return boolean depending on value
     */

    public static boolean isSubSet(Set firstSet, Set secondSet){
        boolean subset = false;
        for(int firstItem = 0; firstItem<firstSet.getSize(); firstItem++){
            for(int secondItem = 0; secondItem<secondSet.getSize(); secondItem++){
                if(secondSet.contains(firstSet.get(firstItem))){
                    subset=true;

                }
                else {
                    subset=false;
//                    System.out.println("El conjunto " + firstSet.getName() + " NO es subconjunto de " + secondSet.getName());
                    return subset;
                    }
                }
            }
//        System.out.println("El conjunto "+firstSet.getName()+" es subconjunto de "+secondSet.getName());
        return subset;
        }

    public static boolean isEqual(Set firstSet, Set secondSet){
        return isSubSet(firstSet, secondSet) && isSubSet(secondSet, firstSet);
    }

    public static boolean isProperSubSet(Set firstSet, Set secondSet){
        return isSubSet(firstSet, secondSet) && !isEqual(firstSet, secondSet);
    }

    public static Set union(Set firstSet, Set secondSet){
        Set R = new Set("R",firstSet);
        for(int i = 0;i<secondSet.getSize();i++){
            R.add(secondSet.get(i));
        }
//        System.out.println("El resultado de "+firstSet.getName()+" union "+secondSet.getName() +" es: ");
//        R.print();
        return R;
    }

    public static Set intersection(Set firstSet, Set secondSet){
        Set R = new Set("R",firstSet);
        for(int i = 0;i<firstSet.getSize();i++) {
            if(!belongs(firstSet.get(i), secondSet)){
                R.remove(firstSet.get(i));
            }
        }
//        System.out.println("El resultado de "+firstSet.getName()+" interseccion "+secondSet.getName() +" es: ");
//        R.print();
        return R;
    }

    public static Set symmetricDifference(Set firstSet, Set secondSet){
        //        System.out.println("El resultado de "+firstSet.getName()+" diferencia simetrica "+secondSet.getName() +" es: ");
        //        R.print();
        return union(difference(firstSet,secondSet),difference(secondSet,firstSet));


    }

    public static Set complement(Set set, Set relativeUniverse){
        return difference(relativeUniverse,set);
    }

    public static boolean belongs(String item, Set set){
        return set.contains(item);
    }

    public static Set powerSet(Set set){
        Set R = new Set("R");
        int resultSize = (int) Math.pow(2,set.getSize());
        R.add("{}");
        while(R.getSize()!=resultSize){
            Set t = new Set("T");
            powerSet(set,R,t);
        }

        return R;
    }

    private static void powerSet(Set set, Set r, Set t) {
        if(!isSubSet(set,r)) {
            for (int i = 0; i < set.getSize(); i++) {
                r.add(set.get(i));
            }
        }
        for(int i = 0; i< set.getSize();i++){
            for(int e = 1; e<set.getSize();e++){
                if(i!=e) {
                    String item = set.get(e)+set.get(i);
                    if(!r.contains(item)) {
                        String data = set.get(i) + set.get(e);
                        r.add(data);
                        t.add(data);
                    }

                }
            }
        }
        for (int i = 0; i< t.getSize();i++){
            for(int e = 0; e< set.getSize();e++) {
                String item = set.get(e);
                if (!t.get(i).contains(item)) {
                    String data = t.get(i) + set.get(e);
                    if (!isPermutation(data, r)) {
                        r.add(data);
                        t.add(data);
                    }
                }
            }
        }
    }

    private static boolean isPermutation(String data, Set r) {
        int n = data.length();
        ArrayList<String> list = new ArrayList<>();
        ArrayList<String> permutationList = permute(data,0,n-1, list);
        for (String s : permutationList) {
            if (belongs(s, r)) {
                return true;
            }
        }
        return false;
    }

    private static ArrayList<String> permute(String str, int l, int r, ArrayList<String> permutationList) {
        if (l == r)
            permutationList.add(str);
        else
        {
            for (int i = l; i <= r; i++)
            {
                str = swap(str,l,i);
                permute(str, l+1, r, permutationList);
                str = swap(str,l,i);
            }
        }
        return permutationList;
    }

    /**
     * Swap Characters at position
     * @param a string value
     * @param i position 1
     * @param j position 2
     * @return swapped string
     */
    public static String swap(String a, int i, int j)
    {
        char temp;
        char[] charArray = a.toCharArray();
        temp = charArray[i] ;
        charArray[i] = charArray[j];
        charArray[j] = temp;
        return String.valueOf(charArray);
    }


    public static Set cartesianProduct(Set firstSet, Set secondSet){
        Set R = new Set("R");
        for(int i=0; i<firstSet.getSize();i++){
            for(int e=0; e<secondSet.getSize();e++){
                R.add("("+firstSet.get(i)+","+secondSet.get(e)+")");
            }
        }
        return R;
    }

    private static String valueToSet(String value){
        return "{"+value+"}";
    }

    private static String setToValue(String value){
        value.replace("{","");
        value.replace(",","");
        value.replace("}","");
        return "{"+value+"}";
    }

}

