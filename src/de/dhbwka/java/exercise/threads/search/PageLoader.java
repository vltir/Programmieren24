package de.dhbwka.java.exercise.threads.search;

public class PageLoader implements Runnable{
    private final String url;
    private boolean pageLoaded = false;
    private String contentString;

    public PageLoader(String url) {
        this.url = url;
    }

    @Override
    public void run() {
        contentString=ReadURLExample.getStringContentFromUrl(url,"UTF-8");
        pageLoaded=true;
    }

    public boolean pageLoaded(){
        return pageLoaded;
    }

    public String getPageContent(){
        return contentString;
    }
}
