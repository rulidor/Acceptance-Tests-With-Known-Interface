import java.sql.Time;
import java.util.Date;

public class ShowsServiceProxy implements ShowsService{
    private ShowsService real;

    public void setReal(ShowsService real) {
        this.real = real;
    }

    @Override
    public boolean addNewShow(String showName, String desc, String hall, Date date, double price, Date lastDayToReserve) {
        if (real == null) {
            return false;
        } else {
            return real.addNewShow(showName, desc, hall, date, price, lastDayToReserve);
        }
    }

    @Override
    public boolean showAvailableSeats(String showId) {
        if (real == null) {
            return false;
        } else {
            return real.showAvailableSeats(showId);
        }
    }

    @Override
    public boolean reserveSeats(String showId, String[] seats, String userId, String phone) {
        if (real == null) {
            return false;
        } else {
            return real.reserveSeats(showId, seats, userId, phone);
        }
    }

    @Override
    public boolean updateShowTime(String showId, Date newTime) {
        if (real == null) {
            return false;
        } else {
            return real.updateShowTime(showId, newTime);
        }
    }

    @Override
    public boolean ensureSeatsForSubscribers(String showId, String[] seats) {
        if (real == null) {
            return false;
        } else {
            return real.ensureSeatsForSubscribers(showId, seats);
        }
    }

    @Override
    public boolean getMyUploadedShows(String userId) {
        if (real == null) {
            return false;
        } else {
            return real.getMyUploadedShows(userId);
        }
    }

    @Override
    public boolean updateShowDetails(String userId, String showId, String showName, String desc, String hall, Date date, double price, Date lastDayToReserve) {
        if (real == null) {
            return false;
        } else {
            return real.updateShowDetails(userId, showId, showName, desc, hall, date, price, lastDayToReserve);
        }
    }

    @Override
    public boolean updateShowPrice(String userId, String showId, double newPrice) {
        if (real == null) {
            return false;
        } else {
            return real.updateShowPrice(userId, showId, newPrice);
        }
    }

    @Override
    public boolean getShowDetails(String location, String desc, Date showDate) {
        if (real == null) {
            return false;
        } else {
            return real.getShowDetails(location, desc, showDate);
        }
    }

    @Override
    public boolean getMyReservations(String userId) {
        if (real == null) {
            return false;
        } else {
            return real.getMyReservations(userId);
        }
    }

    @Override
    public boolean updateUsersAboutShowTime(String showId) {
        if (real == null) {
            return false;
        } else {
            return real.updateUsersAboutShowTime(showId);
        }
    }

    @Override
    public boolean addUserToAShowUpdateList(String userId, String showId) {
        if (real == null) {
            return false;
        } else {
            return real.addUserToAShowUpdateList(userId, showId);
        }
    }


}
