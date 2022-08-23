package com.everis.ct.mobile.step.youtube;

import com.everis.ct.mobile.service.aspect.evidence.ScreenShot;
import com.everis.ct.mobile.step.YoutubeViews;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@ScreenShot
public class SearchVideoStep {

    @Autowired
    private YoutubeViews youtubeViews;

    public void searchVideo(String nombreVideo) {
        youtubeViews.home().searchVideo();
        youtubeViews.home().writeAndSearch(nombreVideo);
    }

    public int getSizeResult() {
        return youtubeViews.results().getResults();
    }

}
