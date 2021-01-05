
/**
 * @author aebrn
 * 12/12/2020
 */
public class Start {
    private static final TestCommandHandler COMMAND_HANDLER = new TestCommandHandler();

    public static void main(String[] args) {
        //System.out.println(COMMAND_HANDLER.execute("-twoarg no yes"));

        System.out.println(COMMAND_HANDLER.execute("-arg yes"));
        //System.out.println(COMMAND_HANDLER.execute("-arg"));
        //System.out.println(COMMAND_HANDLER.execute("-arg -y"));

        //System.out.println(COMMAND_HANDLER.execute("-narg"));
    }
}
