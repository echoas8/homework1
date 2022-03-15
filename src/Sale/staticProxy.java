package Sale;

public class staticProxy implements SellInterface {
    private SalesService salesService;

    public staticProxy(SalesService ss) {
        this.salesService = ss;
    }

    @Override
    public void sell() {
        beforeSale();
        salesService.sell();
        afterSale();
    }

    protected void beforeSale() {
        System.out.println("Providing pre-sales service,售前服务");
    }

    protected void afterSale() {
        System.out.println("Providing after-sales services,售后服务");
    }
}
