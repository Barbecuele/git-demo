package Study;

public class Test1 {
    private Test1(){}

    public static void main(String[] args) {
        Student YFF = new Student("YFF");
        Student[] students = {
                new Student("GJR"),
                new Student("BZL"),
                new Student("YFf")};

        int i = sel(students, YFF);
        System.out.println(i);
    }

    public static<E> int sel(E[] arr,E target){
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equals(target)){
                return i;
            }
        }
        return -1;
    }
}
