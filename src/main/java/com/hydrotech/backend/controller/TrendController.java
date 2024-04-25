package com.hydrotech.backend.controller;

import com.hydrotech.backend.repository.TrendRepository;
import com.hydrotech.backend.model.Trend;
import com.hydrotech.backend.service.TrendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/api/hydro-tech/v1")
public class TrendController {
    @Autowired
    private TrendService trendService;

    private final TrendRepository trendRepository;

    /**
     * Constructor for TrendController.
     * @param trendRepository The repository object used for accessing trends.
     */
    public TrendController(TrendRepository trendRepository) {
        this.trendRepository = trendRepository;
    }


    /**
     * Method for handling GET requests for all trends.
     * @return ResponseEntity with the list of all trends and the HTTP status code.
     */
    @GetMapping("/trends")
    public ResponseEntity<List<Trend>> getAllTrends() {
        return new ResponseEntity<List<Trend>>(trendRepository.findAll(), HttpStatus.OK);
    }


    /**
     * Method for handling POST requests for creating a new trend.
     * @param trend The trend object to be created.
     * @return ResponseEntity with the created trend and the HTTP status code.
     */
    @PostMapping("/trends")
    public ResponseEntity<Trend> createTrend(Trend trend) {
        try {
            return new ResponseEntity<Trend>(trendService.createTrend(trend), HttpStatus.CREATED);
        }catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}