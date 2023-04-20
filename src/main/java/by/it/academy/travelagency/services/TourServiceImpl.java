package by.it.academy.travelagency.services;

import by.it.academy.travelagency.dto.TourRequest;
import by.it.academy.travelagency.dto.TourResponse;
import by.it.academy.travelagency.dto.UpdateTourRequest;
import by.it.academy.travelagency.entities.Tour;
import by.it.academy.travelagency.mapper.TourMapper;
import by.it.academy.travelagency.repositories.TourRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TourServiceImpl implements TourService {
    private final TourRepository tourRepository;
    private final TourMapper tourMapper;

    @Override
    public List<TourResponse> getByNameTour(String nameTour) {
        List<Tour> tours = tourRepository.findByTourName(nameTour);
        return tours.stream()
                .map(tourMapper::buildTourResponse)
                .toList();
    }

    @Override
    public List<TourResponse> getByCost(String hotel) {
        List<Tour> tours = tourRepository.findByHotel(hotel);
        return tours.stream()
                .map(tourMapper::buildTourResponse)
                .toList();
    }

    @Override
    public List<TourResponse> getByState(String state) {
        List<Tour> tours = tourRepository.findByState(state);
        return tours.stream()
                .map(tourMapper::buildTourResponse)
                .toList();
    }

    @Override
    public TourResponse getTour(UUID id) {
        return tourRepository.findById(id)
                .map(tourMapper::buildTourResponse)
                .orElseThrow(() -> new RuntimeException(String.format("Cannot find Tour with id %s", id)));
    }

    @Override
    public List<TourResponse> getAllTours(Pageable pageable) {
        return tourRepository.findAll(pageable).stream()
                .map(tourMapper::buildTourResponse)
                .toList();
    }

    @Override
    public TourResponse createTour(TourRequest tourRequest) {
        Tour tour = tourMapper.buildTour(tourRequest);
        Tour savedTour = tourRepository.save(tour);
        return tourMapper.buildTourResponse(savedTour);
    }

    @Override
    public TourResponse updateTour(UpdateTourRequest updateTourRequest) {
        Tour tour = tourRepository.findById(updateTourRequest.getId()).get();
        return tourMapper.buildUpdatedTourResponse(tour, updateTourRequest);
    }

    @Override
    public void deleteTour(UUID id) throws RuntimeException {
        Optional<Tour> tour = tourRepository.findById(id);
        if (tour.isPresent()) {
            tourRepository.deleteById(id);
        } else {
            throw new RuntimeException(String.format("Cannot find Tour with id %s", id));
        }
    }
}
