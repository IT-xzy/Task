package Task4.unit;

import javax.servlet.http.HttpServletRequest;

public class EmailBody {

    public String email(HttpServletRequest request){
        String url=request.getServletPath();

        return url;
    }
}
