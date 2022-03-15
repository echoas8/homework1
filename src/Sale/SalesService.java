package Sale;

public class SalesService implements SellInterface {
    @Override
    public void sell() {
        System.out.println("Providing sales service,销售服务");
    }
}