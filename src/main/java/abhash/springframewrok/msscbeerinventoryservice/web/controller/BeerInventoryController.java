package abhash.springframewrok.msscbeerinventoryservice.web.controller;

import abhash.springframewrok.msscbeerinventoryservice.repository.BeerInventoryRepository;
import abhash.springframewrok.msscbeerinventoryservice.web.mappers.BeerInventoryMapper;
import abhash.springframewrok.msscbeerinventoryservice.web.model.BeerInventoryDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Slf4j
@RestController
@RequiredArgsConstructor
public class BeerInventoryController {

        private final BeerInventoryMapper beerInventoryMapper;
        private  final BeerInventoryRepository beerInventoryRepository;



        @GetMapping("/api/v1/beer/{beerId}/inventory")
        List<BeerInventoryDto> listBeersById(@PathVariable UUID beerId){

            log.debug("Finding the inventory for beerId ::" +beerId);
            return  beerInventoryRepository.findAllByBeerId(beerId)
                    .stream()
                    .map(beerInventoryMapper :: beerInventoryToBeerInventoryDto)
                    .collect(Collectors.toList());
        }
}
