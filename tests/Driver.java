public class Driver {
    public static ShowsService getService() {
        ShowsServiceProxy proxy = new ShowsServiceProxy();
        // Uncomment when real application is ready:
        // proxy.setReal(new ShowsServiceImpl());
        return proxy;
    }

}
