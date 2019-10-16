    package com.kodilla.travel.repository;

    import com.kodilla.travel.domain.Flight;
    import org.springframework.data.repository.CrudRepository;
    import org.springframework.stereotype.Repository;

    import java.math.BigDecimal;
    import java.util.List;
    import java.util.Optional;

    @Repository
    public interface FlightRepository extends CrudRepository<Flight, Long> {

        @Override
        List<Flight> findAll();

        List<Flight> findAllByAirport(String airport);

        List<Flight> findAllByDestination(String destination);

        List<Flight> findAllByAirportAndPrice(String airport, BigDecimal price);

        List<Flight> findAllByDestinationAndPrice(String destination, BigDecimal price);

        @Override
        Optional<Flight> findById(Long id);

        @Override
        Flight save(Flight flight);

        @Override
        void deleteById(Long id);


    }
