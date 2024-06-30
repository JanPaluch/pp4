package pl.jpaluch.creditcard;

import org.junit.jupiter.api.Test;

public class HelloTest {
    @Test
    void helloWorldTest(){
        //AAAAAA
        //Arange//Given
        var a=2;
        var b=4;
        //Act//When
        var result=a+b;
        //Assert//Then//Expected
        assert result==6;
    }

    @Test
    void itShowsHello(){
        var hello="Hello Jan";
    }
}
