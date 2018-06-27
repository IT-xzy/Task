package Task4.unit;


import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

public class CookieUnit {

        public static Cookie getCookie(String cookieName, String cookieValue){
        Cookie cookie = new Cookie(cookieName,cookieValue);
        cookie.setPath("/");
        cookie.setMaxAge(60 * 30);
        return cookie;
        }


        /**
         * 创建cookie
         * @param cookieName
         * @param cookieValue
         */
        public static void addLoginCookie(HttpServletResponse response, String cookieName, String cookieValue){
            Cookie cookie = new Cookie(cookieName,cookieValue);
            cookie.setPath("/");
            cookie.setMaxAge(60 * 30);
            response.addCookie(cookie);
            System.out.println("cookie===="+cookie.getValue()+"===="+"cookiename====="+cookie.getName());
        }

        /**
         * 根据cookieName删除cookie
         * @param request
         * @param cookieName
         * @return
         */
        public static Cookie deleteCookieByName(HttpServletRequest request, String cookieName){
            Cookie cookie = getCookieByName(request, cookieName);
            cookie.setPath("/");//路径一致才能删除
            cookie.setValue(null);
            cookie.setMaxAge(0);
            return cookie;
        }

        /**
         * 封装cookie进Map
         * @param request
         * @return
         */
        private static Map<String, Cookie> getCookieMap(HttpServletRequest request){
            Map<String, Cookie> map = new HashMap<>();
            Cookie[] cookies = request.getCookies();
            if (cookies != null){
                for (Cookie cookie : cookies){
                    map.put(cookie.getName(),cookie);
                }
            }
            return map;
        }

        /**
         * 根据cookieName获取cookie
         * @param request
         * @param cookieName
         * @return
         */
        public static Cookie getCookieByName(HttpServletRequest request, String cookieName){
            Map<String, Cookie> map = getCookieMap(request);
            if (map.containsKey(cookieName)){
                System.out.println("查找到cookie=="+cookieName);
                return map.get(cookieName);
            }else {
                return null;
            }
        }

    }

