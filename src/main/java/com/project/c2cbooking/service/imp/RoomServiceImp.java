package com.project.c2cbooking.service.imp;

import com.project.c2cbooking.convert.AmenityConvert;
import com.project.c2cbooking.convert.RoomConvert;
import com.project.c2cbooking.model.*;
import com.project.c2cbooking.model.location.CityEntity;
import com.project.c2cbooking.model.location.LocationEntity;
import com.project.c2cbooking.repository.*;
import com.project.c2cbooking.request.AddRoomRequest;
import com.project.c2cbooking.request.RoomRequest;
import com.project.c2cbooking.response.*;
import com.project.c2cbooking.service.RoomService;
import com.project.c2cbooking.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RoomServiceImp implements RoomService {
    private  final static Integer DEFAULT_RATING = 3;
    private  final static String DEFAULT_COMMENT = "Good";

    @Autowired
    private RoomRepository roomRepository;
    @Autowired
    private RoomTypeServiceImp roomTypeServiceImp;

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoomTypeRepository roomTypeRepository;

    @Autowired
    private LocationRepository locationRepository;

    @Autowired
    private CityRepository cityRepository;

    @Autowired
    private PhotoRepository photoRepository;

    @Autowired
    private RoomAmenityRepository roomAmenityRepository;

    @Autowired
    private AmenityRepository amenityRepository;

    @Autowired
    private ReviewRepository reviewRepository;

    @Override
    public List<RoomResponse> topFavoriteRooms(Integer count) {
        List<RoomEntity> roomEntities = roomRepository.findTopFavoritesLimit(count);
        return roomEntities.stream().map(RoomConvert::convert).collect(Collectors.toList());
    }

    @Override
    public RoomFullResponse findOneRoom(Integer idRoom) {
        RoomEntity roomEntity = roomRepository.findByIdEquals(idRoom);
        return RoomConvert.convertFullData(roomEntity);
    }

    @Override
    public List<RoomResponse> viewAllRooms() {
        List<RoomEntity> roomEntities = roomRepository.findAll();
        return roomEntities.stream().map(RoomConvert::convert).collect(Collectors.toList());
    }

    @Override
    public List<RoomResponse> searchRoom(RoomRequest roomRequest) {
        List<RoomTypeResponse> responseList = roomTypeServiceImp.viewAllRoomType();
        Collection<Integer> collection = new ArrayList<>();
        for (RoomTypeResponse roomTypeEntity : responseList){
            collection.add(roomTypeEntity.getId());
        }
        roomRequest.setGuestCount(roomRequest.getGuestCount() == null ? Integer.MAX_VALUE : roomRequest.getGuestCount());
        roomRequest.setMaxPrice(roomRequest.getMaxPrice() == null ? Integer.MAX_VALUE : roomRequest.getMaxPrice());
        roomRequest.setMinPrice(roomRequest.getMinPrice() == null ? 0 : roomRequest.getMinPrice());
        roomRequest.setLocation(roomRequest.getLocation() == null ? "" : roomRequest.getLocation());
        roomRequest.setNameRoom(roomRequest.getNameRoom() == null ? "" : roomRequest.getNameRoom());
        roomRequest.setRoomTypeId(roomRequest.getRoomTypeId().size() == 0 ?  collection: roomRequest.getRoomTypeId());
        List<RoomEntity> roomEntities = roomRepository.searchRoom(
                roomRequest.getGuestCount(),
                new BigDecimal(roomRequest.getMinPrice()),
                new BigDecimal(roomRequest.getMaxPrice()),
                roomRequest.getLocation(),
                roomRequest.getNameRoom(),
                roomRequest.getRoomTypeId()
                );
        return roomEntities.stream().map(RoomConvert::convert).collect(Collectors.toList());
    }

    @Override
    public void addRoom(AddRoomRequest request) {
        RoomEntity entity = new RoomEntity();
        entity.setName(request.getRoomName());
        entity.setPrice(request.getPrice());
        entity.setServiceFee(request.getServiceFee());
        entity.setGuestCount(request.getGuestCount());
        entity.setBedCount(request.getBedCount());
        entity.setBedroomCount(request.getBedroomCount());
        entity.setBathroomCount(request.getBathroomCount());

        LocationEntity locationEntity = new LocationEntity();
        locationEntity.setLat(request.getLocation().getLat());
        locationEntity.setLng(request.getLocation().getLng());
        locationEntity.setStreet(request.getLocation().getStreet());
        CityEntity cityEntity = cityRepository.findById(request.getLocation().getCityId()).get();

        locationEntity.setCityEntity(cityEntity);
        entity.setLocationEntity(locationEntity);

        UserEntity user = userRepository.findById(request.getOwnerId()).get();
        entity.setUserEntity(user);


        RoomTypeEntity roomType = roomTypeRepository.findById(request.getRoomTypeId()).get();
        entity.setRoomTypeEntity(roomType);

        entity.setDescription(request.getDescription());
        entity.setMinGuestCount(request.getMinGuestCount());
        entity.setFeeIncreasingPerson(request.getFeeIncreasingPerson());
        entity.setDelFlag(false);
        RoomEntity roomEntity = roomRepository.save(entity);

        PhotoEntity photoEntity = new PhotoEntity();
        photoEntity.setUrl(request.getUrlImage());
        photoEntity.setRoomEntity(roomEntity);
        photoEntity.setDelFlag(false);
        photoRepository.save(photoEntity);

        List<RoomAmenityEntity> RAList = new ArrayList<>();
        for (Integer amenityId : request.getAmenityIdList()){
            RoomAmenityEntity roomAmenityEntity = new RoomAmenityEntity();
            roomAmenityEntity.setRoomEntity(roomEntity);
            roomAmenityEntity.setAmenityEntity(amenityRepository.findById(amenityId).get());
            roomAmenityEntity.setDel_flag(false);
            RAList.add(roomAmenityEntity);
        }
        roomAmenityRepository.saveAll(RAList);


        ReviewEntity reviewEntity = new ReviewEntity();
        reviewEntity.setRoomEntity(roomEntity);
        reviewEntity.setDelFlag(false);
        reviewEntity.setUserEntity(user);
        reviewEntity.setRating(DEFAULT_RATING);
        reviewEntity.setComment(DEFAULT_COMMENT);
        reviewRepository.save(reviewEntity);
    }

    @Override
    public List<HostListingResponse> getListRoomsByUserId(Integer id) {
        List<RoomEntity> list= roomRepository.findAllByUserEntity_Id(id);

        return list.stream().map(room -> {
            HostListingResponse response = new HostListingResponse();
            response.setRoomResponse(RoomConvert.convert(room));
            response.setCountBooking(room != null && room.getBookingEntities()!= null ? room.getBookingEntities().size() : 0);
            BigDecimal totalMoney = new BigDecimal(0);
            for (BookingEntity booking : room.getBookingEntities()){
                totalMoney = totalMoney.add(booking.getTotalCost());
            }
            response.setTotalMoney(totalMoney);
            return response;
        }).collect(Collectors.toList());
    }


}
