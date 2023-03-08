public class UnknownAccountException extends Exception {
    
    private static final long serialVersionUID = 8340333926671329022L;
    private String account;
    
    public UnknownAccountException( String account ) {
        super();
        this.account = account;
    }
    
    public String getMessage() {
        return "The account "+account+" is unknown.";
    }

}
