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

    @Test
    @DisplayName("TestRemoteTest")
    void TestRemote() throws InterruptedException {
        System.out.println("Test Remote text ");
        logger.info("Лог Remote окей");
        driver.get("https://vk.com");
        Thread.sleep(3000);
    }

    @Test
    @DisplayName("Test Open Epam")
    public void TestOpenEpam() {

        driver.get("https://events.epam.com");

        mainPage.openEvents();

        eventsPage.openUpcomingEvents();

        //logger.info("1");
    }
}
