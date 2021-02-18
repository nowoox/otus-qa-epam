import base.BaseTest;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

import static base.BasePage.EventsType.PAST;
import static base.BasePage.EventsType.UPCOMING;

public class EpamTest extends BaseTest {


     /**
     * Тест-кейс для проверки соответствия счетчика предстоящих
     * мероприятий и количества отображаемых карточек
     */
    @Test
    @Disabled //
    @Execution(ExecutionMode.CONCURRENT)
    @DisplayName("Check number of upcoming events")
    public void CheckNumberOfUpcomingEvents() {

        mainPage.openEvents();

        eventsPage.openUpcomingEvents();

        eventsPage.checkIfCountersMatch(UPCOMING);

    }

    /**
     * Тест-кейс для проверки корректности отображаемых данных
     * на карточке предстоящего мероприятия
     *
     * !!!
     * Проверки не реализованы ввиду отсутствия предстоящих
     * мероприятий на момент выполнения курсовой работы
     * !!!
     */
    @Test
    @Disabled
    @DisplayName("Check upcoming event card")
    public void CheckUpcomingEventCard() {

        mainPage.openEvents();

        eventsPage.openUpcomingEvents();

    }

    /**
     * Тест-кейс для проверки соответствия счетчика прошедших
     * мероприятий и количества отображаемых карточек по фильтру
     * Location: Canada
     */
    @Test
    @Disabled //
//   @Execution(ExecutionMode.CONCURRENT)
    @DisplayName("Check past events")
    public void checkPastEvents() {

        mainPage.openEvents();

        eventsPage.openPastEvents();

        eventsPage.adjustFilter();

        eventsPage.checkIfCountersMatch(PAST);

    }

    /**
     * Тест-кейс для проверки фильтра поиска по фильтру
     * Category: Testing
     * Location: Belarus
     * Language: English
     *
     * После выполнения поиска по фильтру происходит переход на
     * страницу мероприятия и проверка тегов соответствующих Category
     */
    @Test
    //@Execution(ExecutionMode.CONCURRENT)
    @DisplayName("Video filter test")
    public void videoFilterTest() {

        mainPage.openVideos();

        videoPage.adjustFilter();

        videoPage.checkFoundTalksInfo();

    }

    /**
     * Тест-кейс для проверки наличия ключевого слова поиска
     * в заголовках найденных карточек мероприятий
     */
    @Test
    @Disabled//
    @Execution(ExecutionMode.CONCURRENT)
    @DisplayName("Video search test")
    public void videoSearchTest() {

        mainPage.openVideos();

        videoPage.typeAndSearch();

        videoPage.checkFoundTalksTitle();

    }

    /**
     * Тест-кейс для проверки наличия и порядка полей
     * отображаемых на карточке мероприятия
     */
    @Test
    @Disabled//
    @Execution(ExecutionMode.CONCURRENT)
    @DisplayName("Event card info test")
    public void eventCardInfoTest() {

        mainPage.openEvents();

        eventsPage.checkEventCardInfo();

    }

    /**
     * Тест-кейс для проверки дат предстояших мероприятий
     *
     *!!!
     * Проверки не реализованы ввиду отсутствия предстоящих
     * мероприятий на момент выполнения курсовой работы
     * !!!
     */
    @Test
    @Disabled
    @DisplayName("Check upcoming event date")
    public void checkUpcomingEventDate() {

        mainPage.openEvents();

        eventsPage.openUpcomingEvents();

    }
}
