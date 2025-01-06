package com.example.fetchlinkapi.service;

import com.example.fetchlinkapi.model.LinkPreview;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Service;

@Service
public class LinkPreviewService {

    public Document fetchHTML(String url) throws Exception {
        return Jsoup.connect(url).get();
    }

    public LinkPreview extractPreview(String url) throws Exception {
        Document document = fetchHTML(url);

        // Extract titles from the h1 tag with class 'h2 normal black tc p-0 mt-1 m-0'
        String titles = document.select("h1.h2.normal.black.tc.p-0.mt-1.m-0").text();
        if (titles.isEmpty()) {
            titles = document.select("meta[property=og:titles]").attr("content");
        }
        if (titles.isEmpty()) {
            titles = document.select("h1.h2.normal.black.tc.p-0.mt-1.mb-2").text();
        }
        // Extract description from the div with class 'text'
        String description = document.select("div.text").text();
        if (description.isEmpty()) {
            description = document.select("meta[property=og:description]").attr("content");
        }

        // Extract main photo (main image)
        String mainPhoto = document.select("meta[property=og:image]").attr("content");
        if (mainPhoto.isEmpty()) {
            mainPhoto = "default-image-url.jpg"; // fallback if no image is found
        }

        // Extract subtitle from the h2 tag with class 'h5 tc p-0 mb-2 pb-1'
        String subtitle = document.select("h2.h5.tc.p-0.mb-2.pb-1").text();
        if (subtitle.isEmpty()) {
            subtitle = "";
        }

        // Extract price from the p tag with class 'price' and em tag within it
        String price = document.select("p.price em.ib").text();
        if (price.isEmpty()) {
            price = ""; // fallback if no price is found
        } else {
            price = price.replace("€", "").trim(); // Remove the euro sign and trim any extra spaces
        }

        // Extract logo (from OpenGraph or fallback to favicon)
        String logo = document.select("meta[property=og:logo]").attr("content");
        if (logo.isEmpty()) {
            logo = document.select("link[rel=icon]").attr("href"); // Fallback to favicon
        }

        return new LinkPreview(url, titles, mainPhoto, subtitle, price, logo, description);
    }
}


