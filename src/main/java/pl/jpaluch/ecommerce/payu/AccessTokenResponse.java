package pl.jpaluch.ecommerce.payu;

public class AccessTokenResponse {
    String access_token;

    public String getAccessToken() {
        return access_token;
    }

    public AccessTokenResponse setAccess_token(String access_token) {
        this.access_token = access_token;
        return this;
    }
}
