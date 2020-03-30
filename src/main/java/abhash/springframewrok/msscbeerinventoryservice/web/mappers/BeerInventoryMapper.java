package abhash.springframewrok.msscbeerinventoryservice.web.mappers;

import abhash.springframewrok.msscbeerinventoryservice.domain.BeerInventory;
import abhash.springframewrok.msscbeerinventoryservice.web.model.BeerInventoryDto;
import org.mapstruct.Mapper;

@Mapper(uses = DateMapper.class)
public interface BeerInventoryMapper {

    BeerInventory beerInventoryDtoToBeerInventory (BeerInventoryDto beerInventoryDto);
    BeerInventoryDto beerInventoryToBeerInventoryDto (BeerInventory beerInventory);


}
