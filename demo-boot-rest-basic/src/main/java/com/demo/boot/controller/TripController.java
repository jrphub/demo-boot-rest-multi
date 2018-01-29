package com.demo.boot.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.boot.exception.EntityNotFoundException;
import com.demo.boot.model.Trip;
import com.demo.boot.repository.TripRepository;

@RestController
@RequestMapping("/api")
public class TripController {

	@Autowired
	TripRepository tripRepo;

	@GetMapping("/trips")
	public List<Trip> getAllTrips() {
		return tripRepo.findAll();
	}

	@PostMapping("/trips")
	public Trip createTrip(@Valid @RequestBody Trip trip) {
		return tripRepo.save(trip);
	}

	@GetMapping("/trips/{id}")
	public ResponseEntity<Trip> getTripById(
			@PathVariable(value = "id") Long tripId) throws EntityNotFoundException {
		Trip trip = tripRepo.findOne(tripId);
		if (trip == null) {
			//return ResponseEntity.notFound().build();
			throw new EntityNotFoundException(Trip.class, "id", tripId.toString());
		}
		return ResponseEntity.ok().body(trip);
	}

	@PutMapping("/trips/{id}")
	public ResponseEntity<Trip> updateTripById(
			@PathVariable(value = "id") Long tripId,
			@Valid @RequestBody Trip tripDetails) throws EntityNotFoundException {
		Trip trip = tripRepo.findOne(tripId);
		if (trip == null) {
			//return ResponseEntity.notFound().build();
			throw new EntityNotFoundException(Trip.class, "id", tripId.toString());
		}

		trip.setStartPlace(tripDetails.getStartPlace());
		trip.setDestPlace(tripDetails.getDestPlace());

		Trip updatedTrip = tripRepo.save(trip);
		return ResponseEntity.ok(updatedTrip);
	}

	@DeleteMapping("/trips/{id}")
	public ResponseEntity<Trip> deleteTripById(
			@PathVariable(value = "id") Long tripId) throws EntityNotFoundException {
		Trip trip = tripRepo.findOne(tripId);
		if (trip == null) {
			//return ResponseEntity.notFound().build();
			throw new EntityNotFoundException(Trip.class, "id", tripId.toString());
		}

		tripRepo.delete(tripId);
		return ResponseEntity.ok().build();
	}

}
