package conceptual;
public class Naber {


    public static int put_left(int variable, int writeMe) {
        variable &= 0xFFFF;
        variable |= (writeMe & 0xFFFF) << 16;
        return variable;
    }

    public static int put_right(int variable, int writeMe) {
        variable &= 0xFFFF << 16;
        variable |= writeMe & 0xFFFF;
        return variable;
    }

    public static int get_right(int variable) {
        return variable &= 0xFFFF;
    }
    public static int get_left(int variable) {
        return ((variable &= (0xFFFF << 16)) >> 16) % 0xFFFF;
    }
    
    public static void main(String[] args) {
        int variable = -1;

        variable = put_right(variable, 6);
        variable = put_left(variable, 125);


        System.out.println(variable);
        System.out.println(get_right(variable));
        System.out.println(get_left(variable));
    }
}