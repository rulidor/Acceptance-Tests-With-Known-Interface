import java.sql.Time;
import java.util.Date;

public class ShowsServiceImpl implements ShowsService{
    @Override
    public boolean addNewShow(String showName, String desc, String hall, Date date, double price, Date lastDayToReserve) {
        return false;
    }

    @Override
    public boolean showAvailableSeats(String showId) {
        return false;
    }

    @Override
    public boolean reserveSeats(String showId, String[] seats, String userId, String phone) {
        return false;
    }

    @Override
    public boolean updateShowTime(String showId, Date newTime) {
        return false;
    }

    @Override
    public boolean ensureSeatsForSubscribers(String showId, String[] seats) {
        return false;
    }

    @Override
    public boolean getMyUploadedShows(String userId) {
        return false;
    }

    @Override
    public boolean updateShowDetails(String userId, String showId, String showName, String desc, String hall, Date date, double price, Date lastDayToReserve) {
        return false;
    }

    @Override
    public boolean updateShowPrice(String userId, String showId, double newPrice) {
        return false;
    }

    @Override
    public boolean getShowDetails(String location, String desc, Date showDate) {
        return false;
    }

    @Override
    public boolean getMyReservations(String userId) {
        return false;
    }

    @Override
    public boolean updateUsersAboutShowTime(String showId) {
        return false;
    }

    @Override
    public boolean addUserToAShowUpdateList(String userId, String showId) {
        return false;
    }
}
