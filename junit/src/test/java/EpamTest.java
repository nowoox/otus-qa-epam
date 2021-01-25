import base.BaseTest;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class EpamTest extends BaseTest {

    final static Logger logger = Logger.getLogger(EpamTest.class);

    @Test
    @DisplayName("TestTest")
    void Test() {
        System.out.println("Test text");
        logger.info("Лог окей");
    }

    @Test
    @DisplayName("TestOneTest")
    void TestOne() {
        System.out.println("Test One text ");
        logger.info("Лог One окей");
    }
}
