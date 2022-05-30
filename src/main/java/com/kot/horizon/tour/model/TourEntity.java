package com.kot.horizon.tour.model;

import java.time.ZonedDateTime;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import com.kot.horizon.architecture.model.BaseEntity;
import com.kot.horizon.geodata.GeoDataEntity;
import com.kot.horizon.image.model.ImageEntity;
import com.kot.horizon.user.model.UserEntity;

@Entity
@Table(name = "tour")
public class TourEntity implements BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "name", nullable = false)
	@NotBlank
	private String name;

	@Column(name = "description", nullable = false)
	@NotBlank
	private String description;

	@Column(name = "rate", nullable = false)
	private int rate;

	@Column(name = "event_date", nullable = false, columnDefinition = "TIMESTAMP WITH TIME ZONE")
	private ZonedDateTime eventDate;

	@OneToMany
	@JoinTable( name = "tour_image",
			joinColumns = @JoinColumn(name = "tour_id", foreignKey = @ForeignKey(name = "fk_tour_image_to_tour")),
			inverseJoinColumns = @JoinColumn(name = "image_id", foreignKey = @ForeignKey(name = "fk_tour_image_to_image")))
	private List<ImageEntity> images;

	@OneToOne(cascade = CascadeType.ALL)
	private GeoDataEntity geoData;

	@ManyToOne
	@JoinColumn(name = "owner_id")
	private UserEntity owner;

	@Override
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getRate() {
		return rate;
	}

	public void setRate(int rate) {
		this.rate = rate;
	}

	public List<ImageEntity> getImages() {
		return images;
	}

	public void setImages(List<ImageEntity> images) {
		this.images = images;
	}

	public GeoDataEntity getGeoData() {
		return geoData;
	}

	public void setGeoData(GeoDataEntity geoData) {
		this.geoData = geoData;
	}

	public UserEntity getOwner() {
		return owner;
	}

	public void setOwner(UserEntity owner) {
		this.owner = owner;
	}

	public ZonedDateTime getEventDate() {
		return eventDate;
	}

	public void setEventDate(ZonedDateTime eventDate) {
		this.eventDate = eventDate;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;

		if (o == null || getClass() != o.getClass()) return false;

		TourEntity that = (TourEntity) o;

		return new EqualsBuilder()
				.append(rate, that.rate)
				.append(id, that.id)
				.append(name, that.name)
				.append(description, that.description)
				.append(geoData, that.geoData)
				.append(eventDate, that.eventDate)
				.isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder()
				.append(id)
				.append(name)
				.append(description)
				.append(rate)
				.append(geoData)
				.append(eventDate)
				.toHashCode();
	}

	@Override
	public String toString() {
		return "TourEntity{" +
				"id=" + id +
				", name='" + name + '\'' +
				", description='" + description + '\'' +
				", rate=" + rate +
				", eventDate=" + eventDate +
				", geoData=" + geoData +
				", owner=" + owner +
				'}';
	}
}
