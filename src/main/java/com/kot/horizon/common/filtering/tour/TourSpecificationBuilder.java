package com.kot.horizon.common.filtering.tour;

import java.util.Arrays;
import java.util.List;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import com.kot.horizon.common.filtering.EntityFilterSpecificationsBuilder;
import com.kot.horizon.common.filtering.FilterableProperty;
import com.kot.horizon.common.filtering.SearchCriteria;
import com.kot.horizon.common.filtering.tour.nameordescription.TourNameOrDescriptionSpecificationBuilder;
import com.kot.horizon.common.filtering.tour.owner.TourOwnerSpecificationBuilder;
import com.kot.horizon.tour.TourEntity;

@Component
public class TourSpecificationBuilder implements EntityFilterSpecificationsBuilder<TourEntity> {
	@Override
	public List<FilterableProperty<TourEntity>> getFilterableProperties() {
		return Arrays.asList(
				new FilterableProperty<TourEntity>("owner", Long.class,
						TourOwnerSpecificationBuilder.SUPPORTED_OPERATORS, new TourOwnerSpecificationBuilder()),
//				new FilterableProperty<TourEntity>("tourist", Long.class,
//						TourTouristSpecificationBuilder.SUPPORTED_OPERATORS, new TourTouristSpecificationBuilder()),
				new FilterableProperty<TourEntity>("nameOrDescription", String.class,
						TourNameOrDescriptionSpecificationBuilder.SUPPORTED_OPERATORS, new TourNameOrDescriptionSpecificationBuilder())
		);
	}

	@Override
	public Specification<TourEntity> buildSpecification(List<SearchCriteria> searchCriterias) {
		return EntityFilterSpecificationsBuilder.super.buildSpecification(searchCriterias);
	}
}
