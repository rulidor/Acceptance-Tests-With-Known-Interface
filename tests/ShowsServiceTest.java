import org.junit.Before;
import org.junit.Test;

import java.util.Calendar;
import java.util.Date;

import static org.junit.Assert.*;

public class ShowsServiceTest {
    private ShowsService showsService;

    @Before
    public void setUp(){
        showsService = Driver.getService();

        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, 2021);
        cal.set(Calendar.MONTH, Calendar.JULY);
        cal.set(Calendar.DAY_OF_MONTH, 1);
        Date showDate = cal.getTime();

        cal.set(Calendar.MONTH, Calendar.JUNE);
        Date lastReserveDate = cal.getTime();

        showsService.addNewShow("Show1", "dance show", "Hall1", showDate, 20, lastReserveDate);
    }

    @Test
    public void addNewShow() {

        //add show without exact time
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, 2021);
        cal.set(Calendar.MONTH, Calendar.JULY);
        cal.set(Calendar.DAY_OF_MONTH, 1);
        Date showDate = cal.getTime();

        cal.set(Calendar.MONTH, Calendar.JUNE);
        Date lastReserveDate = cal.getTime();

        assertTrue(showsService.addNewShow("JustDance", "dance show", "Habima", showDate, 20, lastReserveDate));

        //add show with exact time
        cal.set(Calendar.HOUR_OF_DAY, 13);
        cal.set(Calendar.MINUTE, 0);
        showDate = cal.getTime();

        assertTrue(showsService.addNewShow("JustDance2", "dance show", "Habima", showDate, 20, lastReserveDate));

        //add show without a name
        assertFalse(showsService.addNewShow("", "dance show", "Habima", showDate, 20, lastReserveDate));

    }

    @Test
    public void showAvailableSeats() {
        assertTrue(showsService.showAvailableSeats("1"));
        assertFalse(showsService.showAvailableSeats("-1"));
        assertFalse(showsService.showAvailableSeats("200"));

    }

    @Test
    public void reserveSeats() {
        assertFalse(showsService.reserveSeats("", new String[]{"10", "11"}, "",""));
        assertFalse(showsService.reserveSeats("", new String[]{}, "11", "0542222222"));
        assertFalse(showsService.reserveSeats("1", new String[]{"12", "13"}, "user1","notDigits"));
        assertTrue(showsService.reserveSeats("1", new String[]{"14", "15"}, "user1","0542222222"));

    }

    @Test
    public void updateShowTime() {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, 2021);
        cal.set(Calendar.MONTH, Calendar.JULY);
        cal.set(Calendar.DAY_OF_MONTH, 1);
        cal.set(Calendar.HOUR_OF_DAY, 22);
        cal.set(Calendar.MINUTE, 44);
        Date showDate = cal.getTime();

        assertTrue(showsService.updateShowTime("1", showDate));
        assertFalse(showsService.updateShowTime("200", showDate));

    }

    @Test
    public void ensureSeatsForSubscribers() {

        assertFalse(showsService.ensureSeatsForSubscribers("90", new String[]{"1","2","3"}));
        assertFalse(showsService.ensureSeatsForSubscribers("90", new String[]{"-1","2","3"}));
        assertTrue(showsService.ensureSeatsForSubscribers("1", new String[]{"1","2","3"}));

    }

    @Test
    public void getMyUploadedShows() {
        assertFalse(showsService.getMyUploadedShows("-1"));
        assertTrue(showsService.getMyUploadedShows("1"));
    }

    @Test
    public void updateShowDetails() {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, 2021);
        cal.set(Calendar.MONTH, Calendar.JULY);
        cal.set(Calendar.DAY_OF_MONTH, 2);
        Date showDate = cal.getTime();

        cal.set(Calendar.MONTH, Calendar.JUNE);
        Date lastReserveDate = cal.getTime();



        assertFalse(showsService.updateShowDetails("-1", "","","","",null, 10, null));
        assertTrue(showsService.updateShowDetails("1", "1", "JustDance", "dance show", "Habima", showDate, 20, lastReserveDate));
    }

    @Test
    public void updateShowPrice() {
        assertFalse(showsService.updateShowPrice("-1","1", 10));
        assertFalse(showsService.updateShowPrice("100","1", 10));
        assertFalse(showsService.updateShowPrice("1","100", 10));
        assertFalse(showsService.updateShowPrice("1","1", -1));

        assertTrue(showsService.updateShowPrice("1","1", 100));

    }

    @Test
    public void getShowDetails() {
        assertTrue(showsService.getShowDetails("TA", "dance show", null));

    }

    @Test
    public void getMyReservations() {
        assertFalse(showsService.getMyReservations("-1"));
        assertFalse(showsService.getMyReservations("20"));
        assertTrue(showsService.getMyReservations("1"));

    }

    @Test
    public void updateUsersAboutShowTime() {
        assertFalse(showsService.updateUsersAboutShowTime("-1"));
        assertFalse(showsService.updateUsersAboutShowTime("20"));
        assertTrue(showsService.updateUsersAboutShowTime("1"));

    }

    @Test
    public void addUserToAShowUpdateList() {
        assertFalse(showsService.addUserToAShowUpdateList("-1","1"));
        assertFalse(showsService.addUserToAShowUpdateList("1","-1"));
        assertFalse(showsService.addUserToAShowUpdateList("100","100"));
        assertTrue(showsService.addUserToAShowUpdateList("1","1"));


    }
}