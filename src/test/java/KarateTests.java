import com.example.starwars.StarWarsApplication;
import com.intuit.karate.junit5.Karate;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT, classes = {StarWarsApplication.class})
class KarateTests {


    @Karate.Test
    Karate hello1Test() {
        return Karate.run("classpath:karate/hello/hello1.feature");
    }


    @Karate.Test
    Karate hello2Test() {
        return Karate.run("classpath:karate/hello/hello2.feature");
    }

    @Karate.Test
    Karate hello3Test() {
        return Karate.run("classpath:karate/hello/hello3.feature");
    }

    @Karate.Test
    Karate hello4Test() {
        return Karate.run("classpath:karate/hello/hello4.feature");
    }

    @Karate.Test
    Karate hello5Test() { return Karate.run("classpath:karate/hello/hello5.feature");
    }


}