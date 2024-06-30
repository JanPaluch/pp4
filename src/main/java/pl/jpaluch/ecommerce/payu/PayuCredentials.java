package pl.jpaluch.ecommerce.payu;

public class PayuCredentials {
    String clinetId,clientSecret;
    boolean sandbox;

    public PayuCredentials(String clinetId, String clientSecret, boolean sandbox) {
        this.clinetId = clinetId;
        this.clientSecret = clientSecret;
        this.sandbox = sandbox;
    }
    public static PayuCredentials sandbox(String clinetId, String clientSecret) {
        return new PayuCredentials(clinetId, clientSecret, true);
    }

    public String getClientId() {
        return clinetId;
    }

    public String getClientSecret() {
        return clientSecret;
    }

    public String getBaseUrl(){
        if (sandbox) {
            return "https://secure.snd.payu.com";
        } else {
            return "https://secure.payu.com";
        }
    }
}
