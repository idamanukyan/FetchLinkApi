package com.example.fetchlinkapi.api;

import com.example.fetchlinkapi.model.LinkPreview;
import com.example.fetchlinkapi.service.LinkPreviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/link-preview")
public class LinkPreviewController {

    @Autowired
    private LinkPreviewService linkPreviewService;

    @GetMapping
    public LinkPreview getPreview(@RequestParam String url) throws Exception {
        return linkPreviewService.extractPreview(url);
    }
}

