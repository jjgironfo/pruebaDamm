package com.everis.ct.mobile.step;

import com.everis.ct.mobile.view.youtube.HomeView;
import com.everis.ct.mobile.view.youtube.ResultsView;
import org.springframework.stereotype.Component;

@Component
public class YoutubeViews {

    public HomeView home() {
        return new HomeView();
    }

    public ResultsView results() {
        return new ResultsView();
    }

}
