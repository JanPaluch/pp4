package pl.jpaluch.creditcard;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.assertj.core.api.Assertions.*;

public class AssertTest {

    @Test
    void moreExpressiveAssertions(){
        var hello="Hello World";
        assertThat(hello).contains("Hello");
        assertThat(new ArrayList<>()).
                hasSize(10).
                contains("Hello");
    }





}
