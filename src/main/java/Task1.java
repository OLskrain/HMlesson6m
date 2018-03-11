public class Task1 {
    private int [] mass2;
    private int x;

    public int [] newMass(int[] m){
        for (int i = 0; i < m.length ; i++) {
            if(m[i] == 4){
                x = i+1;
            }
        }
        if(x == 0) {
            throw new RuntimeException("Исходный массив должен содержать хотя бы одну цифру 4!");
        }
        mass2 = new int[m.length - x];
        System.arraycopy(m,x,mass2,0,(m.length-x));
        return mass2;
    }
}
