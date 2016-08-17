package hjg.rpcmina;
public class RpcServerImpl implements RpcInterface {
    public String getStringValue(String arg0,int arg1,Apple arg2) {
        System.out.println("apple time is "+arg2.getPdate());
        return "this is sign from server.";
    }
    public int getIntValue() {
        return 3;
    }
    public void printPrice() {
        System.out.println("******price**********");
        System.out.println("$10000000000000000000");
        System.out.println("*********************");
    }
}