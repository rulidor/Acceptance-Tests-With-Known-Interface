import java.sql.Time;
import java.util.Date;

public interface ShowsService {

    boolean addNewShow(String showName, String desc, String hall, Date date,
                       double price, Date lastDayToReserve);

    boolean showAvailableSeats(String showId);

    boolean reserveSeats(String showId, String[] seats, String userId, String phone);

    boolean updateShowTime(String showId, Date newTime);

    boolean ensureSeatsForSubscribers(String showId, String[] seats);

    boolean getMyUploadedShows(String userId);

    boolean updateShowDetails(String userId, String showId, String showName, String desc, String hall, Date date,
                              double price, Date lastDayToReserve);

    boolean updateShowPrice(String userId, String showId, double newPrice);

    boolean getShowDetails(String location, String desc, Date showDate);

    boolean getMyReservations(String userId);

    boolean updateUsersAboutShowTime(String showId);

    boolean addUserToAShowUpdateList(String userId, String showId);


}
