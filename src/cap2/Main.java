package cap2;

import java.util.*;

public class Main {
    public static void main(String[] args) {


        List<Number> nums = new ArrayList<Number>(); //Applying subtitution principle
        nums.add(2);nums.add(3.14);
        assert nums.toString().equals("[2, 3.14]");

        List<Integer> ints = new ArrayList<Integer>();
        ints.add(1);
        ints.add(2);
        List<Number> nums = ints;  // compile-time error
        nums.add(3.14);
        assert ints.toString().equals("[1, 2, 3.14]");  // uh oh!


        List<Number> nums1 = new ArrayList<Number>();  // Wildcard implemented in the method addAll
        List<Integer> ints1 = Arrays.asList(1, 2);
        List<Double> dbls1 = Arrays.asList(2.78, 3.14);
        nums.addAll(ints);nums.addAll(dbls1);
        assert nums.toString().equals("[1, 2, 2.78, 3.14]");


        List<Integer> ints3 = new ArrayList<Integer>();
        ints3.add(1);
        ints3.add(2);
        List<? extends Number> nums3 = ints; // Correct form to resolve the problem of the line 18
        nums.add(3.14);  // compile-time error
        assert ints.toString().equals("[1, 2, 3.14]");  // uh oh!


        List<Object> objs4 = Arrays.<Object>asList(2, 3.14, "four");
        List<Integer> ints4 = Arrays.asList(5, 6);
        Collections.copy(objs4, ints4);
        assert objs4.toString().equals("[5, 6, four]");

        Collections.copy(objs4, ints4);
        Collections.<Object>copy(objs4, ints4);
        Collections.<Number>copy(objs4, ints4);
        Collections.<Integer>copy(objs4, ints);



        List<Integer> ints5 = Arrays.asList(1,2,3);
        assert sum(ints5) == 6.0;

        List<Double> doubles = Arrays.asList(2.78,3.14);
        assert sum(doubles) == 5.92;

        List<Number> nums5 = Arrays.<Number>asList(1,2,2.78,3.14);
        assert sum(nums) == 8.92;



        List<Integer> ints = new ArrayList<Integer>();
        ints.add(1);ints.add(2);
        List<? extends Number> nums = ints;
        double dbl = sum(nums);// ok
        nums.add(3.14);  // compile-time error


        List<Object> objs = new ArrayList<Object>();
        objs.add(1);objs.add("two");
        List<? super Integer> ints6 = objs;
        ints6.add(3);  // ok
         double dbl = sum(ints6);  // compile-time error

        List<Integer> ints7 = new ArrayList<Integer>();
        ints7.add(1);
        ints7.add(2);
        List<? extends Number> nums7 = ints;
        nums7.add(null);// ok
         assert nums7.toString().equals("[1, 2, null]");

        List<Object> objs8 = Arrays.<Object>asList(1,"two");
        List<? super Integer> ints8 = objs;
        String str = "";

        for (Object obj : ints8) str += obj.toString();
        assert str.equals("1two");


        List<Integer> ints9 = Arrays.asList(1,2,3);
        List<Number> nums9 = ints9;  // compile-time error
        nums9.set(2, 3.14);
        assert ints9.toString().equals("[1, 2, 3.14]");  // uh oh!



        Object obj10 = "one";
        List<Object> objs10 = Arrays.<Object>asList("one", 2, 3.14, 4);
        List<Integer> ints10 = Arrays.asList(2, 4);
        assert objs.contains(obj10);
        assert objs.containsAll(ints10);
        assert !ints.contains(obj10);
        assert !ints.containsAll(objs10);

        Object obj11 = 1;
        List<Object> objs11 = Arrays.<Object>asList(1, 3);
        List<Integer> ints11 = Arrays.asList(1, 2, 3, 4);
        assert ints11.contains(obj11);
        assert ints11.containsAll(objs11);





    }


    interface MyCollection<E> {  // alternative design  ...
        public boolean contains(E o);

        public boolean containsAll(Collection<? extends E> c);
    }


    public static double sum(Collection<? extends Number> nums)
    {  double s = 0.0;
    for (Number num : nums) s += num.doubleValue();
    return s;
    }

    public static <T> void copy(List<? super T> dst, List<? extends T> src) {  // super is used for super class of T and itself and extends is used for subclases of T and itself

        for (int i = 0; i < src.size(); i++) {
            dst.set(i, src.get(i));
        }
    }

    public static void count(Collection<? super Integer> ints, int n) {  for (int i = 0; i < n; i++) ints.add(i);}

    public static double sumCount(Collection<Number> nums, int n) {  count(nums, n);  return sum(nums);} // when puts and get values it's not recommended to use wildcard

    //double sumCount(Collection<? extends Number super Integer> coll, int n) not legal Java!



}
