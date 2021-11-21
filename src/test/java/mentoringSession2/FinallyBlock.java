package mentoringSession2;

class FinallyBlock {
    public static void main(String args[]) {

        try {
            System.out.println(9/0);
        } catch(Exception e){
            System.out.println("I am in catch block");
            System.exit(1);
        } finally {
            System.out.println("I am in finally block");

        }

    }







}
