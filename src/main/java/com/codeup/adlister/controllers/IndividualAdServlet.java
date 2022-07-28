package com.codeup.adlister.controllers;
import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.dao.Users;
import com.codeup.adlister.models.Ad;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "controllers.IndividualAdServlet", urlPatterns = "/ad")
public class IndividualAdServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        Get ad id
        String adId = req.getParameter("adId");
//        set ad id attribute to the clicked ad
        req.setAttribute("ad", DaoFactory.getAdsDao().singleAd(Integer.parseInt(adId)));

        Ad usernameId = (Ad) req.getAttribute("ad");
//       gets users dao
        Users username = DaoFactory.getUsersDao();
//       finds by users id that was retrieved from the adId
        req.setAttribute("username", username.findByUsernameId(usernameId.getUserId()));


        req.getRequestDispatcher("/WEB-INF/ads/ad.jsp").forward(req, resp);
    }


}
