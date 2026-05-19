import java.time.LocalDateTime;
import java.util.ArrayList;
import java.time.format.DateTimeFormatter;

public class CompanyShare {
    String symbol;
    int shares;
    LocalDateTime dateTime;
    public CompanyShare(String symbol,int share)
    {
        this.symbol=symbol;
        this.shares=share;
        this.dateTime=LocalDateTime.now();
    }
}
