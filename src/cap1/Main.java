package cap1;

import java.util.*;

public final class Main  {


    public static void main(String[] args) {

        List<Integer> ints = Arrays.asList(1,2,3);  //Code with Generics
        int s = 0;
        for (int n : ints) { s += n; }
        assert s == 6;


        List ints2 = Arrays.asList( new Integer[] {         // Doing the iteration  before generics
                new Integer(1), new Integer(2), new Integer(3)
        } );
        int s1 = 0;
        for (Iterator it = ints2.iterator(); it.hasNext(); ) {
            int n = ((Integer)it.next()).intValue();

            s1 += n;
        }
        assert s1 == 6;


        int[] ints3 = new int[] { 1,2,3 };  //Same code with arrays, the problem here  is that you can't add more elements
        int s3 = 0;
        for (int i = 0; i < ints3.length; i++) { s3 += ints3[i]; }
        assert s3 == 6;

        List<String> words = new ArrayList<String>();
        words.add("Hello ");
        words.add("world!");
        String s2 = words.get(0)+words.get(1);
        assert s2.equals("Hello world!");


        List words1 = new ArrayList();
        words1.add("Hello ");
        words1.add("world!");
        String s4 = ((String)words1.get(0))+((String)words1.get(1));
        assert s4.equals("Hello world!");


        //------------------- Section 1.2-----------------------------------
        List<Integer> ints4 = new ArrayList<Integer>();
        ints4.add(1);
        int n = ints.get(0);


        List<Integer> ints5 = new ArrayList<Integer>();  //This is the same as above
        ints5.add(Integer.valueOf(1));
        int n2 = ints5.get(0).intValue();


        List<Integer> bigs = Arrays.asList(100,200,300);
        assert sumInteger(bigs) == sum(bigs);
        assert sumInteger(bigs) != sumInteger(bigs);


        //--------Section 1.3

        for (Iterator<Integer> it = ints. iterator(); it.hasNext(); ) {
             n = it.next();
            s += n;
        }


    }

    public static int sum (List<Integer> ints) {
        int s = 0;
        for (int n : ints) { s += n; }
        return s;
    }

    public static Integer sumInteger(List<Integer> ints) {
        Integer s = 0;
        for (Integer n : ints) { s += n; }
        return s;

    }


    public static int sumArray(int[] a) {   // For each can also be applied to arrays
        int s = 0;
        for (int n : a) { s += n; }
        return s;
    }

    public static void removeNegative(List<Double> v) {
        for (Iterator<Double> it = v.iterator(); it.hasNext();) { // Removing negative numbers using a Iterator
            if (it.next() < 0) it.remove();
        }
    }


    public static double dot(List<Double> u, List<Double> v) {  //Calculating dot product of 2 vectors with the same size
        if (u.size() != v.size())
            throw new IllegalArgumentException("different sizes");
        double d = 0;
        Iterator<Double> uIt = u.iterator();
        Iterator<Double> vIt = v.iterator();
        while (uIt.hasNext()) {
            assert uIt.hasNext() && vIt.hasNext();
            d += uIt.next() * vIt.next();
        }
        assert !uIt.hasNext() && !vIt.hasNext();
        return d;
    }

  // --------- Section 1.4-----------------------




}

class Lists {
    public static <T> List<T> toList(T...arr) {
        List<T> list = new ArrayList<T>();
        for (T elt : arr) list.add(elt);
        return list;
    }



    public  void fillList(){
        List<Integer> ints = Lists.toList(new Integer[]{1,2,3});
        List<String> strings = Lists.toList(new String[]{"hello","world"});


    }
}
