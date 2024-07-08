package de.dhbwka.java.exercise.threads.search;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SearchEngine {
    public static void main(String[] args) {
        List<String> urls = List.of("https://www.tagesschau.de","https://www.sueddeutsche.de","https://www.kit.edu","https://www.spiegel.de","https://www.etienne-bader.de","https://www.iai.kit.edu/javavl");
        List<PageLoader> loaders = new ArrayList<>(urls.stream().map(PageLoader::new).toList());
        try (ExecutorService exec = Executors.newFixedThreadPool(3)) {
            loaders.forEach(exec::execute);
            exec.shutdown();
        }
        while (!loaders.isEmpty()){
            for (int i = 0; i < loaders.size(); i++) {
                if(loaders.get(i).pageLoaded()){
                    System.out.println(loaders.get(i).getPageContent().split("title>")[1].replace("</",""));
                    loaders.remove(i);
                    i--;
                }
            }
        }
    }
}
