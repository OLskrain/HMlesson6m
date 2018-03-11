public class Task2 {
    private boolean value_1 = false;
    private boolean value_4 = false;

    public boolean arrayCheck(int [] m){
        for (int i = 0; i < m.length ; i++) {
            if(m[i] == 1){
                value_1 = true;
            }else if(m[i] == 4){
                value_4 = true;
            }
        }
        if(value_1 && value_4){
            return true;
        }else return false;
    }
}
